package cjminecraft.oreclumps.data;

import cjminecraft.oreclumps.common.OreClumps;
import cjminecraft.oreclumps.common.init.OCBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OCBlockStateProvider extends BlockStateProvider {
    public OCBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, OreClumps.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(OCBlocks.RAW_IRON_BLOCK.get());
        simpleBlock(OCBlocks.RAW_GOLD_BLOCK.get());
        simpleBlock(OCBlocks.RAW_COPPER_BLOCK.get());
        simpleBlock(OCBlocks.RAW_LEAD_BLOCK.get());
        simpleBlock(OCBlocks.RAW_NICKEL_BLOCK.get());
        simpleBlock(OCBlocks.RAW_SILVER_BLOCK.get());
        simpleBlock(OCBlocks.RAW_TIN_BLOCK.get());
        simpleBlock(OCBlocks.RAW_URANIUM_BLOCK.get());
        simpleBlock(OCBlocks.RAW_OSMIUM_BLOCK.get());
        simpleBlock(OCBlocks.RAW_ZINC_BLOCK.get());
        simpleBlock(OCBlocks.RAW_ALUMINUM_BLOCK.get());
        simpleBlock(OCBlocks.RAW_CHROMIUM_BLOCK.get());
        simpleBlock(OCBlocks.RAW_COBALT_BLOCK.get());
        simpleBlock(OCBlocks.RAW_PLATINUM_BLOCK.get());
        simpleBlock(OCBlocks.RAW_THORIUM_BLOCK.get());
        simpleBlock(OCBlocks.RAW_TITANIUM_BLOCK.get());
        simpleBlock(OCBlocks.RAW_TUNGSTEN_BLOCK.get());

        cubeAll(OCBlocks.RAW_IRON_BLOCK.get());
        cubeAll(OCBlocks.RAW_GOLD_BLOCK.get());
        cubeAll(OCBlocks.RAW_COPPER_BLOCK.get());
        cubeAll(OCBlocks.RAW_LEAD_BLOCK.get());
        cubeAll(OCBlocks.RAW_NICKEL_BLOCK.get());
        cubeAll(OCBlocks.RAW_SILVER_BLOCK.get());
        cubeAll(OCBlocks.RAW_TIN_BLOCK.get());
        cubeAll(OCBlocks.RAW_URANIUM_BLOCK.get());
        cubeAll(OCBlocks.RAW_OSMIUM_BLOCK.get());
        cubeAll(OCBlocks.RAW_ZINC_BLOCK.get());
        cubeAll(OCBlocks.RAW_ALUMINUM_BLOCK.get());
        cubeAll(OCBlocks.RAW_CHROMIUM_BLOCK.get());
        cubeAll(OCBlocks.RAW_COBALT_BLOCK.get());
        cubeAll(OCBlocks.RAW_PLATINUM_BLOCK.get());
        cubeAll(OCBlocks.RAW_THORIUM_BLOCK.get());
        cubeAll(OCBlocks.RAW_TITANIUM_BLOCK.get());
        cubeAll(OCBlocks.RAW_TUNGSTEN_BLOCK.get());
    }
}
