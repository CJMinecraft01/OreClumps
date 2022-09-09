package cjminecraft.oreclumps.fabric.data;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OCDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(OCRecipeGenerator::new);
        fabricDataGenerator.addProvider(OCModelGenerator::new);
        Lists.newArrayList("en_uk", "en_us").forEach(l -> fabricDataGenerator.addProvider(new OCLanguageGenerator(fabricDataGenerator, l)));
    }
}
