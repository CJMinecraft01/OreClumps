package cjminecraft.oreclumps.fabric;

import cjminecraft.oreclumps.fabric.common.init.*;
import cjminecraft.oreclumps.fabric.common.loot.LootModifierManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

public class OreClumps implements ModInitializer {
    @Override
    public void onInitialize() {
        OCItems.register();
        OCBlocks.register();
        OCRecipes.register();
        OCLootModifiers.register();

        OCCodecs.load();

        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(LootModifierManager.INSTANCE);
    }
}
