package cjminecraft.oreclumps.fabric.common.init;

import cjminecraft.oreclumps.fabric.common.loot.GlobalLootModifier;
import cjminecraft.oreclumps.fabric.common.loot.RegistryCodec;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static cjminecraft.oreclumps.fabric.common.init.OCLootModifiers.LOOT_MODIFIER_SERIALIZERS;

public class OCCodecs {

    public static Codec<Codec<? extends GlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS_CODEC;
    public static Codec<Item> ITEMS_CODEC = new RegistryCodec<>(Registry.ITEM);

    public static void load() {
        LOOT_MODIFIER_SERIALIZERS_CODEC = new RegistryCodec<>(LOOT_MODIFIER_SERIALIZERS);
    }

}
