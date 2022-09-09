package cjminecraft.oreclumps.fabric;

import cjminecraft.oreclumps.fabric.common.init.OCItems;
import cjminecraft.oreclumps.fabric.common.init.OCRecipes;
import net.fabricmc.api.ModInitializer;

public class OreClumps implements ModInitializer {
    @Override
    public void onInitialize() {
        OCItems.register();
        OCRecipes.register();
        // todo: need to have the raw ore blocks
    }
}
