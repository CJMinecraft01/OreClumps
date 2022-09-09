package cjminecraft.oreclumps.forge.common.init;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.loot.RawOreModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OCLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MODID);

    public static final RegistryObject<Codec<RawOreModifier>> RAW_ORE = LOOT_MODIFIERS.register("raw_ore", RawOreModifier.CODEC);

}
