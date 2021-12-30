package cjminecraft.oreclumps.fabric.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;
import java.util.function.Supplier;

public class RegistryObject<T> implements Supplier<T> {
    
    private final ResourceLocation id;
    private T value;
    
    public static <T> RegistryObject<T> of(ResourceLocation id) {
        return new RegistryObject<>(id);
    }
    
    private RegistryObject(ResourceLocation id) {
        this.id = id;
    }
    
    public ResourceLocation getId() {
        return id;
    }
    
    public void updateValue(Registry<T> registry) {
        this.value = registry.get(this.id);
    }
    
    @Override
    public T get() {
        return Objects.requireNonNull(this.value);
    }
    
}
