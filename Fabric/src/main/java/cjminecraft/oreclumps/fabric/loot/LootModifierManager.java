package cjminecraft.oreclumps.fabric.loot;

import cjminecraft.oreclumps.common.Constants;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.Deserializers;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

// note: these are copied directly from the forge reference
public class LootModifierManager implements IdentifiableResourceReloadListener {
    private static final int PATH_SUFFIX_LENGTH = ".json".length();
    
    public static final LootModifierManager INSTANCE = new LootModifierManager();
    
    public static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON_INSTANCE = Deserializers.createFunctionSerializer().create();
    
    private static final Map<ResourceLocation, GlobalLootModifierSerializer<?>> SERIALIZERS = new HashMap<>();
    
    private Map<ResourceLocation, IGlobalLootModifier> registeredLootModifiers = ImmutableMap.of();
    private static final String folder = "loot_modifiers";
    
    @Override
    public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller profilerFiller, ProfilerFiller profilerFiller2, Executor executor, Executor executor2) {
        return CompletableFuture.supplyAsync(() -> this.prepare(resourceManager, profilerFiller), executor).thenCompose(preparationBarrier::wait).thenAcceptAsync((map) -> this.apply(map, resourceManager, profilerFiller), executor2);
    }
    
    protected Map<ResourceLocation, JsonElement> prepare(ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        Map<ResourceLocation, JsonElement> map = Maps.newHashMap();
        int i = folder.length() + 1;
        
        for (ResourceLocation resourceLocation : resourceManager.listResources(folder, name -> name.endsWith(".json"))) {
            String string = resourceLocation.getPath();
            ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getNamespace(), string.substring(i, string.length() - PATH_SUFFIX_LENGTH));
    
            try {
                Resource resource = resourceManager.getResource(resourceLocation);
        
                try {
                    InputStream inputStream = resource.getInputStream();
            
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                
                        try {
                            JsonElement jsonElement = (JsonElement)GsonHelper.fromJson(GSON_INSTANCE, reader, JsonElement.class);
                            if (jsonElement != null) {
                                JsonElement jsonElement2 = (JsonElement)map.put(resourceLocation2, jsonElement);
                                if (jsonElement2 != null) {
                                    throw new IllegalStateException("Duplicate data file ignored with ID " + resourceLocation2);
                                }
                            } else {
                                LOGGER.error("Couldn't load data file {} from {} as it's null or empty", resourceLocation2, resourceLocation);
                            }
                        } catch (Throwable var17) {
                            try {
                                reader.close();
                            } catch (Throwable var16) {
                                var17.addSuppressed(var16);
                            }
                    
                            throw var17;
                        }
                
                        reader.close();
                    } catch (Throwable var18) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable var15) {
                                var18.addSuppressed(var15);
                            }
                        }
                
                        throw var18;
                    }
            
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable var19) {
                    if (resource != null) {
                        try {
                            resource.close();
                        } catch (Throwable var14) {
                            var19.addSuppressed(var14);
                        }
                    }
            
                    throw var19;
                }
        
                if (resource != null) {
                    resource.close();
                }
            } catch (IllegalArgumentException | IOException | JsonParseException var20) {
                LOGGER.error("Couldn't parse data file {} from {}", resourceLocation2, resourceLocation, var20);
            }
        }
        
        return map;
    }
    
    protected void apply(Map<ResourceLocation, JsonElement> resourceList, ResourceManager resourceManagerIn, ProfilerFiller profilerIn) {
        ImmutableMap.Builder<ResourceLocation, IGlobalLootModifier> builder = ImmutableMap.builder();
        ArrayList<ResourceLocation> finalLocations = new ArrayList<ResourceLocation>();
        ResourceLocation resourcelocation = new ResourceLocation("forge","loot_modifiers/global_loot_modifiers.json");
        try {
            //read in all data files from forge:loot_modifiers/global_loot_modifiers in order to do layering
            for(Resource iresource : resourceManagerIn.getResources(resourcelocation)) {
                try (InputStream inputstream = iresource.getInputStream();
                     Reader reader = new BufferedReader(new InputStreamReader(inputstream, StandardCharsets.UTF_8));
                ) {
                    JsonObject jsonobject = GsonHelper.fromJson(GSON_INSTANCE, reader, JsonObject.class);
                    boolean replace = jsonobject.get("replace").getAsBoolean();
                    if(replace) finalLocations.clear();
                    JsonArray entryList = jsonobject.get("entries").getAsJsonArray();
                    for(JsonElement entry : entryList) {
                        String loc = entry.getAsString();
                        ResourceLocation res = new ResourceLocation(loc);
                        if(finalLocations.contains(res)) finalLocations.remove(res);
                        finalLocations.add(res);
                    }
                }
                
                catch (RuntimeException | IOException ioexception) {
                    LOGGER.error("Couldn't read global loot modifier list {} in data pack {}", resourcelocation, iresource.getSourceName(), ioexception);
                } finally {
                    IOUtils.closeQuietly((Closeable)iresource);
                }
            }
        } catch (IOException ioexception1) {
            LOGGER.error("Couldn't read global loot modifier list from {}", resourcelocation, ioexception1);
        }
        //use layered config to fetch modifier data files (modifiers missing from config are disabled)
        finalLocations.forEach(location -> {
            try {
                IGlobalLootModifier modifier = deserializeModifier(location, resourceList.get(location));
                if(modifier != null)
                    builder.put(location, modifier);
            } catch (Exception exception) {
                LOGGER.error("Couldn't parse loot modifier {}", location, exception);
            }
        });
        ImmutableMap<ResourceLocation, IGlobalLootModifier> immutablemap = builder.build();
        this.registeredLootModifiers = immutablemap;
    }
    
    private IGlobalLootModifier deserializeModifier(ResourceLocation location, JsonElement element) {
        if (!element.isJsonObject()) return null;
        JsonObject object = element.getAsJsonObject();
        LootItemCondition[] lootConditions = GSON_INSTANCE.fromJson(object.get("conditions"), LootItemCondition[].class);
        
        ResourceLocation serializer = new ResourceLocation(GsonHelper.getAsString(object, "type"));
        
        return SERIALIZERS.get(serializer).read(location, object, lootConditions);
    }
    
    public static GlobalLootModifierSerializer<?> getSerializerForName(ResourceLocation resourcelocation) {
        return SERIALIZERS.get(resourcelocation);
    }
    
    /**
     * An immutable collection of the registered loot modifiers in layered order.
     * @return
     */
    public Collection<IGlobalLootModifier> getAllLootMods() {
        return registeredLootModifiers.values();
    }
    
    public static List<ItemStack> modifyLoot(List<ItemStack> generatedLoot, LootContext context) {
        for (IGlobalLootModifier mod : INSTANCE.getAllLootMods()) {
            generatedLoot = mod.apply(generatedLoot, context);
        }
        return generatedLoot;
    }
    
    public static void register(ResourceLocation id, GlobalLootModifierSerializer<?> serializer) {
        SERIALIZERS.put(id, serializer);
    }
    
    @Override
    public ResourceLocation getFabricId() {
        return new ResourceLocation(Constants.MODID, "loot_modifier");
    }
    
}
