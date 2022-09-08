package cjminecraft.oreclumps.forge;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import cjminecraft.oreclumps.forge.common.init.OCRecipes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
public class OreClumps {

    public OreClumps() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();

        OCItems.ITEMS.register(mod);
        OCRecipes.SERIALIZERS.register(mod);
    }

}