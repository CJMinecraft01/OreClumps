package cjminecraft.oreclumps.fabric.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class DeferredRegister<T> {
    
    private DeferredRegister(Registry<T> registry, String modid) {
        this.registry = registry;
        this.modid = modid;
    }
    
    public static <T> DeferredRegister<T> create(Registry<T> registry, String modid) {
        return new DeferredRegister<>(registry, modid);
    }
    
    private final Registry<T> registry;
    private final String modid;
    
    private final Map<ResourceLocation, Supplier<T>> entries = new HashMap<>();
    private final List<RegistryObject<T>> objects = new ArrayList<>();
    
    public RegistryObject<T> register(String id, Supplier<T> entry) {
        ResourceLocation rl = new ResourceLocation(this.modid, id);
        this.entries.put(rl, entry);
        RegistryObject<T> ro = RegistryObject.of(rl);
        this.objects.add(ro);
        return ro;
    }
    
    public void initialize() {
        this.entries.forEach((rl, e) -> Registry.register(this.registry, rl, e.get()));
        this.objects.forEach(e -> e.updateValue(this.registry));
    }
    
}
