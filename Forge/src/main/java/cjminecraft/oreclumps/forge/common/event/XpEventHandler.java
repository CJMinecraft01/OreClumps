package cjminecraft.oreclumps.forge.common.event;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.loot.RawOreModifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeInternalHandler;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifierManager;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid = Constants.MODID)
public class XpEventHandler {

    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        LootModifierManager man = ObfuscationReflectionHelper.getPrivateValue(ForgeInternalHandler.class, null, "INSTANCE");
        if (man == null)
            return;
        LootContext.Builder builder = new LootContext.Builder((ServerLevel) event.getLevel());
        builder.withRandom(event.getLevel().getRandom()).withParameter(LootContextParams.BLOCK_STATE, event.getState()).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(event.getPos())).withParameter(LootContextParams.TOOL, event.getPlayer().getMainHandItem()).withOptionalParameter(LootContextParams.THIS_ENTITY, event.getPlayer()).withOptionalParameter(LootContextParams.BLOCK_ENTITY, event.getLevel().getBlockEntity(event.getPos()));
        LootContext context = builder.create(LootContextParamSets.BLOCK);
        for (IGlobalLootModifier mod : man.getAllLootMods()) {
            if (mod instanceof RawOreModifier rawOre) {
                if (rawOre.getPredicate().test(context) && rawOre.shouldOverrideDrop(event.getState()) && rawOre.shouldOverrideXp()) {
                    event.setExpToDrop(event.getLevel().getRandom().nextIntBetweenInclusive(rawOre.getXpMin(), rawOre.getXpMax()));
                }
            }
        }
    }

}
