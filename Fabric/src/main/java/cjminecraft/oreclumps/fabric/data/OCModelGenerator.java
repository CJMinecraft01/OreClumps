package cjminecraft.oreclumps.fabric.data;

import cjminecraft.oreclumps.fabric.common.init.OCItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class OCModelGenerator extends FabricModelProvider {
    public OCModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(OCItems.RAW_LEAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_NICKEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_SILVER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_TIN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_URANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_OSMIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_ZINC, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_ALUMINUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_CHROMIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_COBALT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_PLATINUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_THORIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_TITANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_TUNGSTEN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_ADAMANTIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_MYTHRIL, ModelTemplates.FLAT_ITEM);
    }
}
