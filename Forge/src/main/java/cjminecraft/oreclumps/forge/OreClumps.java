package cjminecraft.oreclumps.forge;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import cjminecraft.oreclumps.forge.common.init.OCRecipes;
import cjminecraft.oreclumps.forge.data.OCItemModelProvider;
import cjminecraft.oreclumps.forge.data.OCLanguageProvider;
import cjminecraft.oreclumps.forge.data.OCRecipeProvider;
import com.google.common.collect.Lists;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
public class OreClumps {

    public OreClumps() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();

        mod.addListener(this::gatherData);

        OCItems.ITEMS.register(mod);
        OCRecipes.SERIALIZERS.register(mod);
    }

    private void gatherData(final GatherDataEvent event) {
        final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        final DataGenerator generator = event.getGenerator();

        if (event.includeClient()) {
            generator.addProvider(true, new OCItemModelProvider(generator, existingFileHelper));
            Lists.newArrayList("en_us", "en_gb").forEach(l -> generator.addProvider(true, new OCLanguageProvider(generator, l)));
        }
        if (event.includeServer()) {
            generator.addProvider(true, new OCRecipeProvider(generator));
        }
    }

}