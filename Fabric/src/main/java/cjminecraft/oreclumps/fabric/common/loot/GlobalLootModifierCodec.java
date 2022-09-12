package cjminecraft.oreclumps.fabric.common.loot;

import cjminecraft.oreclumps.fabric.common.init.OCLootModifiers;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import net.minecraft.resources.ResourceLocation;

public final class GlobalLootModifierCodec implements Codec<Codec<? extends GlobalLootModifier>> {

    public static final GlobalLootModifierCodec INSTANCE = new GlobalLootModifierCodec();

    @Override
    public <T> DataResult<Pair<Codec<? extends GlobalLootModifier>, T>> decode(DynamicOps<T> ops, T input) {
        if (ops.compressMaps()) {
            return ops.getNumberValue(input).flatMap(n -> {
                int id = n.intValue();
                if (OCLootModifiers.LOOT_MODIFIER_SERIALIZERS.getHolder(id).isEmpty())
                    return DataResult.error("Unknown registry id in loot modifiers: " + n);
                Codec<? extends GlobalLootModifier> value = OCLootModifiers.LOOT_MODIFIER_SERIALIZERS.getHolder(id).get().value();
                return DataResult.success(value);
            }).map(v -> Pair.of(v, ops.empty()));
        } else {
            return ResourceLocation.CODEC.decode(ops, input).flatMap(keyValuePair -> !OCLootModifiers.LOOT_MODIFIER_SERIALIZERS.containsKey(keyValuePair.getFirst())
                    ? DataResult.error("Unknown registry key in loot modifiers: " + keyValuePair.getFirst())
                    : DataResult.success(keyValuePair.mapFirst(OCLootModifiers.LOOT_MODIFIER_SERIALIZERS::get)));
        }
    }

    @Override
    public <T> DataResult<T> encode(Codec<? extends GlobalLootModifier> input, DynamicOps<T> ops, T prefix) {
        ResourceLocation key = OCLootModifiers.LOOT_MODIFIER_SERIALIZERS.getKey(input);
        if (key == null)
            return DataResult.error("Unknown registry element in loot modifiers: " + input);
        T toMerge = ops.compressMaps() ? ops.createInt(OCLootModifiers.LOOT_MODIFIER_SERIALIZERS.getId(input)) : ops.createString(key.toString());
        return ops.mergeToPrimitive(prefix, toMerge);
    }
}
