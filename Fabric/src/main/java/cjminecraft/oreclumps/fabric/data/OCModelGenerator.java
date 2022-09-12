package cjminecraft.oreclumps.fabric.data;

import cjminecraft.oreclumps.fabric.common.init.OCBlocks;
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
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_LEAD_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_NICKEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_SILVER_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_URANIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_OSMIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_ZINC_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_ALUMINUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_CHROMIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_COBALT_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_PLATINUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_THORIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_TITANIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_TUNGSTEN_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_ADAMANTIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_MYTHRIL_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_QUICKSILVER_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_FROSTSTEEL_BLOCK);
        blockStateModelGenerator.createTrivialCube(OCBlocks.RAW_CLOGGRUM_BLOCK);
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
        itemModelGenerator.generateFlatItem(OCItems.RAW_QUICKSILVER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_FROSTSTEEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(OCItems.RAW_CLOGGRUM, ModelTemplates.FLAT_ITEM);
    }
}
