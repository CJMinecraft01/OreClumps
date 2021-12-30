package cjminecraft.oreclumps.fabric.loot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// note: these are copied directly from the forge reference
public interface IGlobalLootModifier {
    @NotNull
    List<ItemStack> apply(List<ItemStack> generatedLoot, LootContext context);
}
