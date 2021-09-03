package cjminecraft.oreclumps.data;

import cjminecraft.oreclumps.common.OreClumps;
import cjminecraft.oreclumps.common.init.OCBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OCLootTableProvider extends LootTableProvider {
    public OCLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    private static Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet> addSingleBlockDrop(String path, RegistryObject<Item> drop) {
        return Pair.of(() -> r ->
                r.accept(new ResourceLocation(OreClumps.MODID, "blocks/" + path),
                        LootTable.lootTable().withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantRange.exactly(1))
                                        .bonusRolls(0, 0)
                                        .add(ItemLootEntry.lootTableItem(drop::get))
                                        .when(SurvivesExplosion.survivesExplosion())
                        )
                ), LootParameterSets.BLOCK);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                addSingleBlockDrop("raw_iron_block", OCBlocks.RAW_IRON_BLOCK_ITEM),
                addSingleBlockDrop("raw_gold_block", OCBlocks.RAW_GOLD_BLOCK_ITEM),
                addSingleBlockDrop("raw_copper_block", OCBlocks.RAW_COPPER_BLOCK_ITEM),
                addSingleBlockDrop("raw_lead_block", OCBlocks.RAW_LEAD_BLOCK_ITEM),
                addSingleBlockDrop("raw_nickel_block", OCBlocks.RAW_NICKEL_BLOCK_ITEM),
                addSingleBlockDrop("raw_osmium_block", OCBlocks.RAW_OSMIUM_BLOCK_ITEM),
                addSingleBlockDrop("raw_silver_block", OCBlocks.RAW_SILVER_BLOCK_ITEM),
                addSingleBlockDrop("raw_tin_block", OCBlocks.RAW_TIN_BLOCK_ITEM),
                addSingleBlockDrop("raw_uranium_block", OCBlocks.RAW_URANIUM_BLOCK_ITEM),
                addSingleBlockDrop("raw_zinc_block", OCBlocks.RAW_ZINC_BLOCK_ITEM),
                addSingleBlockDrop("raw_aluminum_block", OCBlocks.RAW_ALUMINUM_BLOCK_ITEM),
                addSingleBlockDrop("raw_chromium_block", OCBlocks.RAW_CHROMIUM_BLOCK_ITEM),
                addSingleBlockDrop("raw_cobalt_block", OCBlocks.RAW_COBALT_BLOCK_ITEM),
                addSingleBlockDrop("raw_platinum_block", OCBlocks.RAW_PLATINUM_BLOCK_ITEM),
                addSingleBlockDrop("raw_thorium_block", OCBlocks.RAW_THORIUM_BLOCK_ITEM),
                addSingleBlockDrop("raw_titanium_block", OCBlocks.RAW_TITANIUM_BLOCK_ITEM),
                addSingleBlockDrop("raw_tungsten_block", OCBlocks.RAW_TUNGSTEN_BLOCK_ITEM),
                addSingleBlockDrop("raw_adamantium_block", OCBlocks.RAW_ADAMANTIUM_BLOCK_ITEM),
                addSingleBlockDrop("raw_mythril_block", OCBlocks.RAW_MYTHRIL_BLOCK_ITEM)
        );
    }
}
