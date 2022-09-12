package cjminecraft.oreclumps.fabric.common.loot;

import cjminecraft.oreclumps.common.Constants;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import org.slf4j.Logger;

import java.io.Reader;
import java.util.List;

public class LootModifierManager implements SimpleSynchronousResourceReloadListener {

    public static final LootModifierManager INSTANCE = new LootModifierManager();

    private static final Logger LOGGER = LogUtils.getLogger();
    private List<GlobalLootModifier> modifiers = ImmutableList.of();

    @Override
    public ResourceLocation getFabricId() {
        return new ResourceLocation(Constants.MODID, "loot_modifiers");
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        LOGGER.info("Loading");
        ImmutableList.Builder<GlobalLootModifier> builder = new ImmutableList.Builder<>();
        resourceManager.listResources("loot_modifiers", l -> l.getPath().endsWith(".json")).forEach(
                (location, resource) -> {
                    try {
                        Reader reader = resource.openAsReader();

                        try {
                            JsonElement json = JsonParser.parseReader(reader);
                            GlobalLootModifier.DIRECT_CODEC.parse(JsonOps.INSTANCE, json)
                                    .resultOrPartial(errorMsg -> LOGGER.warn("Could not decode loot modifier with json id {} - error {}", location, errorMsg))
                                    .ifPresent(builder::add);
                        } catch (Throwable throwable) {
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (Throwable throwable1) {
                                    throwable.addSuppressed(throwable);
                                }
                            }
                            throw throwable;
                        }

                        if (reader != null)
                            reader.close();
                    } catch (Exception exception) {
                        LOGGER.error("Couldn't read loot modifier {}", location, exception);
                    }
                }
        );
        this.modifiers = builder.build();
        LOGGER.info("Registered {} loot modifiers", this.modifiers.size());
    }

    public List<GlobalLootModifier> getModifiers() {
        return modifiers;
    }
}
