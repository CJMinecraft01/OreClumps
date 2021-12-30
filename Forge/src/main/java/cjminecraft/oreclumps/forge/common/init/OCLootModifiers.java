package cjminecraft.oreclumps.forge.common.init;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.loot.RawOreModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OCLootModifiers {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, Constants.MODID);

    public static final RegistryObject<GlobalLootModifierSerializer<RawOreModifier>> RAW_ORE_MODIFIER = LOOT_MODIFIER_SERIALIZERS.register("raw_ore", RawOreModifier.Serializer::new);

}
