package cjminecraft.oreclumps.fabric;

import cjminecraft.oreclumps.fabric.init.OCBlocks;
import cjminecraft.oreclumps.fabric.init.OCItems;
import cjminecraft.oreclumps.fabric.init.OCLootModifiers;
import cjminecraft.oreclumps.fabric.loot.LootModifierManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

public class OreClumps implements ModInitializer {
    
    @Override
    public void onInitialize() {
        OCItems.ITEMS.initialize();
        OCBlocks.BLOCKS.initialize();
        OCBlocks.ITEMS.initialize();
        OCLootModifiers.initialize();
    
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(LootModifierManager.INSTANCE);
    }
    
}
