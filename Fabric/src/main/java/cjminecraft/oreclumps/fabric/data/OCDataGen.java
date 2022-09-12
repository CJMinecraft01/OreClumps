package cjminecraft.oreclumps.fabric.data;

import cjminecraft.oreclumps.fabric.OreClumps;
import cjminecraft.oreclumps.fabric.common.init.OCBlocks;
import cjminecraft.oreclumps.fabric.common.init.OCItems;
import cjminecraft.oreclumps.fabric.common.init.OCLootModifiers;
import cjminecraft.oreclumps.fabric.common.init.OCRecipes;
import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OCDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(OCRecipeGenerator::new);
        fabricDataGenerator.addProvider(OCModelGenerator::new);
        fabricDataGenerator.addProvider(OCItemTagsGenerator::new);
        Lists.newArrayList("en_uk", "en_us").forEach(l -> fabricDataGenerator.addProvider(new OCLanguageGenerator(fabricDataGenerator, l)));
    }
}
