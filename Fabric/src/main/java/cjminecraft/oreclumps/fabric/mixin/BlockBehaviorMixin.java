package cjminecraft.oreclumps.fabric.mixin;

import cjminecraft.oreclumps.fabric.common.loot.XpHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockBehaviour.class)
public class BlockBehaviorMixin {

    @Inject(method = "spawnAfterBreak", at = @At("HEAD"))
    public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean bl, CallbackInfo ci) {
        if (bl) {
            IntProvider provider = XpHandler.spawnExperience(state, level, pos, stack);
            if (provider != null) {
                if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
                    int xp = provider.sample(level.random);
                    if (xp > 0) {
                        if (level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
                            ExperienceOrb.award(level, Vec3.atCenterOf(pos), xp);
                        }
                    }
                }
            }
        }
    }

}
