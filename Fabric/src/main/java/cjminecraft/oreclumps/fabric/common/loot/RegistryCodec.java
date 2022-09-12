package cjminecraft.oreclumps.fabric.common.loot;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public final class RegistryCodec<V> implements Codec<V> {

    private final Registry<V> registry;

    public RegistryCodec(Registry<V> registry) {
        this.registry = registry;
    }

    @Override
    public <T> DataResult<Pair<V, T>> decode(DynamicOps<T> ops, T input) {
        if (ops.compressMaps()) {
            return ops.getNumberValue(input).flatMap(n -> {
                int id = n.intValue();
                if (this.registry.getHolder(id).isEmpty())
                    return DataResult.error("Unknown registry id in loot modifiers: " + n);
                V value = this.registry.getHolder(id).get().value();
                return DataResult.success(value);
            }).map(v -> Pair.of(v, ops.empty()));
        } else {
            return ResourceLocation.CODEC.decode(ops, input).flatMap(keyValuePair -> !this.registry.containsKey(keyValuePair.getFirst())
                    ? DataResult.error("Unknown registry key in loot modifiers: " + keyValuePair.getFirst())
                    : DataResult.success(keyValuePair.mapFirst(this.registry::get)));
        }
    }

    @Override
    public <T> DataResult<T> encode(V input, DynamicOps<T> ops, T prefix) {
        ResourceLocation key = this.registry.getKey(input);
        if (key == null)
            return DataResult.error("Unknown registry element in loot modifiers: " + input);
        T toMerge = ops.compressMaps() ? ops.createInt(this.registry.getId(input)) : ops.createString(key.toString());
        return ops.mergeToPrimitive(prefix, toMerge);
    }
}
