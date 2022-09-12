package cjminecraft.oreclumps.fabric.common.init;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.fabric.common.loot.GlobalLootModifier;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class OCLootModifiers {

    public static WritableRegistry<Codec<? extends GlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS;

    public static void register() {
        LOOT_MODIFIER_SERIALIZERS = FabricRegistryBuilder.from(new MappedRegistry<Codec<? extends GlobalLootModifier>>(ResourceKey.createRegistryKey(new ResourceLocation(Constants.MODID, "loot_modifiers")), Lifecycle.stable(), null)).buildAndRegister();
    }

}
