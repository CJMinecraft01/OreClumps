package cjminecraft.oreclumps.fabric.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OCDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(OCRecipeGenerator::new);
        fabricDataGenerator.addProvider(OCModelGenerator::new);
    }
}
