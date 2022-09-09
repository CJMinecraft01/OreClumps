package cjminecraft.oreclumps.forge;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import cjminecraft.oreclumps.forge.common.init.OCLootModifiers;
import cjminecraft.oreclumps.forge.common.init.OCRecipes;
import cjminecraft.oreclumps.forge.data.*;
import com.google.common.collect.Lists;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
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
        OCLootModifiers.LOOT_MODIFIERS.register(mod);
        // todo: need to have the raw ore blocks
    }

    private void gatherData(final GatherDataEvent event) {
        final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        final DataGenerator generator = event.getGenerator();

        generator.addProvider(event.includeClient(), new OCItemModelProvider(generator, existingFileHelper));
        Lists.newArrayList("en_us", "en_gb").forEach(l -> generator.addProvider(event.includeClient(), new OCLanguageProvider(generator, l)));

        generator.addProvider(event.includeServer(), new OCRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new OCItemTagsProvider(generator, existingFileHelper));
        generator.addProvider(event.includeServer(), new OCGlobalLootModifierProvider(generator));
    }

}