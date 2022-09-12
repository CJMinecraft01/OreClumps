package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.init.OCBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OCLootTableProvider extends LootTableProvider {
    public OCLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    private static Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet> addSingleBlockDrop(String path, RegistryObject<Item> drop) {
        return Pair.of(() -> r ->
                r.accept(new ResourceLocation(Constants.MODID, "blocks/" + path),
                        LootTable.lootTable().withPool(
                                LootPool.lootPool()
                                        .add(LootItem.lootTableItem(drop::get))
                                        .when(ExplosionCondition.survivesExplosion())
                        )
                ), LootContextParamSets.BLOCK);
    }
    
    @Override
    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationtracker) {
    
    }
    
    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(
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
                addSingleBlockDrop("raw_mythril_block", OCBlocks.RAW_MYTHRIL_BLOCK_ITEM),
                addSingleBlockDrop("raw_quicksilver_block", OCBlocks.RAW_QUICKSILVER_BLOCK_ITEM),
                addSingleBlockDrop("raw_froststeel_block", OCBlocks.RAW_FROSTSTEEL_BLOCK_ITEM),
                addSingleBlockDrop("raw_cloggrum_block", OCBlocks.RAW_CLOGGRUM_BLOCK_ITEM)
        );
    }
}
