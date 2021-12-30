package cjminecraft.oreclumps.fabric.mixin;

import cjminecraft.oreclumps.fabric.loot.LootModifierManager;
import com.google.common.collect.Lists;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.function.Consumer;

@Mixin(LootTable.class)
public abstract class LootTableMixin {
    
    @Shadow
    public abstract void getRandomItems(LootContext lootContext, Consumer<ItemStack> consumer);
    
    @Inject(at = @At("HEAD"), method = "getRandomItems(Lnet/minecraft/world/level/storage/loot/LootContext;)Ljava/util/List;", cancellable = true)
    private void oreclumps_getRandomItems(LootContext context, CallbackInfoReturnable<List<ItemStack>> info) {
        List<ItemStack> list = Lists.newArrayList();
        this.getRandomItems(context, list::add);
        list = LootModifierManager.modifyLoot(list, context);
        info.setReturnValue(list);
    }
    
}
