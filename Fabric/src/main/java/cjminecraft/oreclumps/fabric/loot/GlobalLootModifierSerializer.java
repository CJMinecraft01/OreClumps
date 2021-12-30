package cjminecraft.oreclumps.fabric.loot;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.SerializationContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

// note: these are copied directly from the forge reference
public abstract class GlobalLootModifierSerializer<T extends IGlobalLootModifier> {
    
    private ResourceLocation registryName = null;
    
    public final GlobalLootModifierSerializer<T> setRegistryName(String modID, String name) {
        this.registryName = new ResourceLocation(modID, name);
        return this;
    }
    
    public final ResourceLocation getRegistryName() {
        return registryName;
    }
    
    /**
     * Most mods will likely not need more than<br/>
     * <code>return new MyModifier(conditionsIn)</code><br/>
     * but any additional properties that are needed will need to be deserialized here.
     *
     * @param location        The resource location (if needed)
     * @param object          The full json object (including ILootConditions)
     * @param ailootcondition An already deserialized list of ILootConditions
     */
    public abstract T read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition);
    
    /**
     * Write the serializer to json.
     *
     * Most serializers won't have to do anything else than {@link #makeConditions}
     * Which simply creates the JsonObject from an array of ILootConditions.
     */
    public abstract JsonObject write(T instance);
    
    /**
     * Helper to create the json object from the conditions.
     * Add any extra properties to the returned json.
     */
    public JsonObject makeConditions(LootItemCondition[] conditions) {
        JsonObject json = new JsonObject();
        json.add("conditions", SerializationContext.INSTANCE.serializeConditions(conditions));
        return json;
    }
    
}