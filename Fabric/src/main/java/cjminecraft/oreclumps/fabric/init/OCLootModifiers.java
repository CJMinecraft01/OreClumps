package cjminecraft.oreclumps.fabric.init;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.fabric.loot.GlobalLootModifierSerializer;
import cjminecraft.oreclumps.fabric.loot.LootModifierManager;
import cjminecraft.oreclumps.fabric.loot.RawOreModifier;
import net.minecraft.resources.ResourceLocation;

public class OCLootModifiers {

    public static final GlobalLootModifierSerializer<RawOreModifier> RAW_ORE_MODIFIER = new RawOreModifier.Serializer();
    
    public static void initialize() {
    
        LootModifierManager.register(new ResourceLocation(Constants.MODID, "raw_ore"), RAW_ORE_MODIFIER);
    }

}
