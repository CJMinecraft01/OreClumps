package cjminecraft.oreclumps.fabric;

import cjminecraft.oreclumps.fabric.common.init.OCItems;
import cjminecraft.oreclumps.fabric.common.init.OCLootModifiers;
import cjminecraft.oreclumps.fabric.common.init.OCRecipes;
import cjminecraft.oreclumps.fabric.common.loot.LootModifierManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

public class OreClumps implements ModInitializer {
    @Override
    public void onInitialize() {
        OCItems.register();
        OCRecipes.register();
        OCLootModifiers.register();
        // todo: need to have the raw ore blocks

        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(LootModifierManager.INSTANCE);
    }
}
