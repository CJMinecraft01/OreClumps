package cjminecraft.oreclumps.common.init;

import cjminecraft.oreclumps.common.OreClumps;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class OCBlocks {

    private static final Item.Properties PROPERTIES = new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OreClumps.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OreClumps.MODID);

    public static final RegistryObject<Block> RAW_IRON_BLOCK = BLOCKS.register("raw_iron_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_GOLD_BLOCK = BLOCKS.register("raw_gold_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.GOLD).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_COPPER_BLOCK = BLOCKS.register("raw_copper_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_LEAD_BLOCK = BLOCKS.register("raw_lead_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_NICKEL_BLOCK = BLOCKS.register("raw_nickel_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = BLOCKS.register("raw_silver_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = BLOCKS.register("raw_tin_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_URANIUM_BLOCK = BLOCKS.register("raw_uranium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_OSMIUM_BLOCK = BLOCKS.register("raw_osmium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_ZINC_BLOCK = BLOCKS.register("raw_zinc_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_ALUMINUM_BLOCK = BLOCKS.register("raw_aluminum_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_CHROMIUM_BLOCK = BLOCKS.register("raw_chromium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_COBALT_BLOCK = BLOCKS.register("raw_cobalt_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = BLOCKS.register("raw_platinum_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_THORIUM_BLOCK = BLOCKS.register("raw_thorium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_TITANIUM_BLOCK = BLOCKS.register("raw_titanium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = BLOCKS.register("raw_tungsten_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_ADAMANTIUM_BLOCK = BLOCKS.register("raw_adamantium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> RAW_MYTHRIL_BLOCK = BLOCKS.register("raw_mythril_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));

    public static final RegistryObject<Item> RAW_IRON_BLOCK_ITEM = ITEMS.register("raw_iron_block", () -> new BlockItem(RAW_IRON_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_GOLD_BLOCK_ITEM = ITEMS.register("raw_gold_block", () -> new BlockItem(RAW_GOLD_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_COPPER_BLOCK_ITEM = ITEMS.register("raw_copper_block", () -> new BlockItem(RAW_COPPER_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_LEAD_BLOCK_ITEM = ITEMS.register("raw_lead_block", () -> new BlockItem(RAW_LEAD_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_NICKEL_BLOCK_ITEM = ITEMS.register("raw_nickel_block", () -> new BlockItem(RAW_NICKEL_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_SILVER_BLOCK_ITEM = ITEMS.register("raw_silver_block", () -> new BlockItem(RAW_SILVER_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_TIN_BLOCK_ITEM = ITEMS.register("raw_tin_block", () -> new BlockItem(RAW_TIN_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_URANIUM_BLOCK_ITEM = ITEMS.register("raw_uranium_block", () -> new BlockItem(RAW_URANIUM_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_OSMIUM_BLOCK_ITEM = ITEMS.register("raw_osmium_block", () -> new BlockItem(RAW_OSMIUM_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_ZINC_BLOCK_ITEM = ITEMS.register("raw_zinc_block", () -> new BlockItem(RAW_ZINC_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_ALUMINUM_BLOCK_ITEM = ITEMS.register("raw_aluminum_block", () -> new BlockItem(RAW_ALUMINUM_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_CHROMIUM_BLOCK_ITEM = ITEMS.register("raw_chromium_block", () -> new BlockItem(RAW_CHROMIUM_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_COBALT_BLOCK_ITEM = ITEMS.register("raw_cobalt_block", () -> new BlockItem(RAW_COBALT_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_PLATINUM_BLOCK_ITEM = ITEMS.register("raw_platinum_block", () -> new BlockItem(RAW_PLATINUM_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_THORIUM_BLOCK_ITEM = ITEMS.register("raw_thorium_block", () -> new BlockItem(RAW_THORIUM_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_TITANIUM_BLOCK_ITEM = ITEMS.register("raw_titanium_block", () -> new BlockItem(RAW_TITANIUM_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_TUNGSTEN_BLOCK_ITEM = ITEMS.register("raw_tungsten_block", () -> new BlockItem(RAW_TUNGSTEN_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_ADAMANTIUM_BLOCK_ITEM = ITEMS.register("raw_adamantium_block", () -> new BlockItem(RAW_ADAMANTIUM_BLOCK.get(), PROPERTIES));
    public static final RegistryObject<Item> RAW_MYTHRIL_BLOCK_ITEM = ITEMS.register("raw_mythril_block", () -> new BlockItem(RAW_MYTHRIL_BLOCK.get(), PROPERTIES));

}
