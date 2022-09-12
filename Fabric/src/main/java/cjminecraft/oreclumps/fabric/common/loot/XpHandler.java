package cjminecraft.oreclumps.fabric.common.loot;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

public class XpHandler {

    public static IntProvider spawnExperience(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack) {
        LootContext.Builder builder = new LootContext.Builder(level);
        builder.withRandom(level.getRandom()).withParameter(LootContextParams.BLOCK_STATE, state).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withParameter(LootContextParams.TOOL, stack).withOptionalParameter(LootContextParams.BLOCK_ENTITY, level.getBlockEntity(pos));
        LootContext context = builder.create(LootContextParamSets.BLOCK);
        for (GlobalLootModifier mod : LootModifierManager.INSTANCE.getModifiers()) {
            if (mod instanceof RawOreModifier rawOre) {
                if (rawOre.getPredicate().test(context) && rawOre.shouldOverrideDrop(state) && rawOre.shouldOverrideXp()) {
                    return UniformInt.of(rawOre.getXpMin(), rawOre.getXpMax());
                }
            }
        }
        return null;
    }

}
