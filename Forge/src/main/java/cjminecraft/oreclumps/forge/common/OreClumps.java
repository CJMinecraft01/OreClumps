package cjminecraft.oreclumps.forge.common;

import cjminecraft.oreclumps.forge.common.init.OCItems;
import cjminecraft.oreclumps.forge.common.init.OCBlocks;
import cjminecraft.oreclumps.forge.common.init.OCLootModifiers;
import cjminecraft.oreclumps.forge.data.OCBlockStateProvider;
import cjminecraft.oreclumps.forge.data.OCBlockTagsProvider;
import cjminecraft.oreclumps.forge.data.OCGlobalLootModifierProvider;
import cjminecraft.oreclumps.forge.data.OCItemModelProvider;
import cjminecraft.oreclumps.forge.data.OCItemTagsProvider;
import cjminecraft.oreclumps.forge.data.OCLanguageProvider;
import cjminecraft.oreclumps.forge.data.OCLootTableProvider;
import cjminecraft.oreclumps.forge.data.OCRecipeProvider;
import com.google.common.collect.Lists;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import static cjminecraft.oreclumps.common.Constants.MODID;

@Mod(MODID)
public class OreClumps {
    
    public OreClumps() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();
    
        mod.addListener(this::gatherData);
    
        OCItems.ITEMS.register(mod);
        OCBlocks.BLOCKS.register(mod);
        OCBlocks.ITEMS.register(mod);
        OCLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(mod);
    
    }
    
    private void gatherData(final GatherDataEvent event) {
        final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        final DataGenerator generator = event.getGenerator();
        
        if (event.includeClient()) {
            generator.addProvider(new OCBlockStateProvider(generator, existingFileHelper));
            generator.addProvider(new OCItemModelProvider(generator, existingFileHelper));
            Lists.newArrayList("en_us", "en_gb").forEach(l -> event.getGenerator().addProvider(new OCLanguageProvider(generator, l)));
        }
        if (event.includeServer()) {
            generator.addProvider(new OCGlobalLootModifierProvider(generator));
            generator.addProvider(new OCRecipeProvider(generator));
            generator.addProvider(new OCLootTableProvider(generator));
            final OCBlockTagsProvider blockTagsProvider = new OCBlockTagsProvider(generator, existingFileHelper);
            generator.addProvider(blockTagsProvider);
            generator.addProvider(new OCItemTagsProvider(generator, blockTagsProvider, existingFileHelper));
        }
    }
    
}
