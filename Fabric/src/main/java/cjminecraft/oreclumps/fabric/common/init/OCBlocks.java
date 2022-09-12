package cjminecraft.oreclumps.fabric.common.init;

import cjminecraft.oreclumps.common.Constants;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.net.URI;

public class OCBlocks {

    private static final Item.Properties PROPERTIES = new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static Block RAW_LEAD_BLOCK;
    public static Block RAW_NICKEL_BLOCK;
    public static Block RAW_SILVER_BLOCK;
    public static Block RAW_TIN_BLOCK;
    public static Block RAW_URANIUM_BLOCK;
    public static Block RAW_OSMIUM_BLOCK;
    public static Block RAW_ZINC_BLOCK;
    public static Block RAW_ALUMINUM_BLOCK;
    public static Block RAW_CHROMIUM_BLOCK;
    public static Block RAW_COBALT_BLOCK;
    public static Block RAW_PLATINUM_BLOCK;
    public static Block RAW_THORIUM_BLOCK;
    public static Block RAW_TITANIUM_BLOCK;
    public static Block RAW_TUNGSTEN_BLOCK;
    public static Block RAW_ADAMANTIUM_BLOCK;
    public static Block RAW_MYTHRIL_BLOCK;
    public static Block RAW_QUICKSILVER_BLOCK;
    public static Block RAW_FROSTSTEEL_BLOCK;
    public static Block RAW_CLOGGRUM_BLOCK;

    public static Item RAW_LEAD_BLOCK_ITEM;
    public static Item RAW_NICKEL_BLOCK_ITEM;
    public static Item RAW_SILVER_BLOCK_ITEM;
    public static Item RAW_TIN_BLOCK_ITEM;
    public static Item RAW_URANIUM_BLOCK_ITEM;
    public static Item RAW_OSMIUM_BLOCK_ITEM;
    public static Item RAW_ZINC_BLOCK_ITEM;
    public static Item RAW_ALUMINUM_BLOCK_ITEM;
    public static Item RAW_CHROMIUM_BLOCK_ITEM;
    public static Item RAW_COBALT_BLOCK_ITEM;
    public static Item RAW_PLATINUM_BLOCK_ITEM;
    public static Item RAW_THORIUM_BLOCK_ITEM;
    public static Item RAW_TITANIUM_BLOCK_ITEM;
    public static Item RAW_TUNGSTEN_BLOCK_ITEM;
    public static Item RAW_ADAMANTIUM_BLOCK_ITEM;
    public static Item RAW_MYTHRIL_BLOCK_ITEM;
    public static Item RAW_QUICKSILVER_BLOCK_ITEM;
    public static Item RAW_FROSTSTEEL_BLOCK_ITEM;
    public static Item RAW_CLOGGRUM_BLOCK_ITEM;

    public static void register() {
        RAW_LEAD_BLOCK = registerRaw("lead", MaterialColor.COLOR_BLUE);
        RAW_NICKEL_BLOCK = registerRaw("nickel", MaterialColor.COLOR_YELLOW);
        RAW_SILVER_BLOCK = registerRaw("silver", MaterialColor.COLOR_LIGHT_BLUE);
        RAW_TIN_BLOCK = registerRaw("tin", MaterialColor.COLOR_CYAN);
        RAW_URANIUM_BLOCK = registerRaw("uranium", MaterialColor.COLOR_LIGHT_GREEN);
        RAW_OSMIUM_BLOCK = registerRaw("osmium", MaterialColor.COLOR_LIGHT_GRAY);
        RAW_ZINC_BLOCK = registerRaw("zinc", MaterialColor.WARPED_NYLIUM);
        RAW_ALUMINUM_BLOCK = registerRaw("aluminum", MaterialColor.TERRACOTTA_WHITE);
        RAW_CHROMIUM_BLOCK = registerRaw("chromium", MaterialColor.QUARTZ);
        RAW_COBALT_BLOCK = registerRaw("cobalt", MaterialColor.COLOR_BLUE);
        RAW_PLATINUM_BLOCK = registerRaw("platinum", MaterialColor.COLOR_LIGHT_BLUE);
        RAW_THORIUM_BLOCK = registerRaw("thorium", MaterialColor.COLOR_BLACK);
        RAW_TITANIUM_BLOCK = registerRaw("titanium", MaterialColor.TERRACOTTA_WHITE);
        RAW_TUNGSTEN_BLOCK = registerRaw("tungsten", MaterialColor.COLOR_PURPLE);
        RAW_ADAMANTIUM_BLOCK = registerRaw("adamantium", MaterialColor.TERRACOTTA_LIGHT_GREEN);
        RAW_MYTHRIL_BLOCK = registerRaw("mythril", MaterialColor.TERRACOTTA_BLUE);
        RAW_QUICKSILVER_BLOCK = registerRaw("quicksilver", MaterialColor.COLOR_ORANGE);
        RAW_FROSTSTEEL_BLOCK = registerRaw("froststeel", MaterialColor.ICE);
        RAW_CLOGGRUM_BLOCK = registerRaw("cloggrum", MaterialColor.COLOR_BROWN);

        RAW_LEAD_BLOCK_ITEM = registerRaw("lead", RAW_LEAD_BLOCK);
        RAW_NICKEL_BLOCK_ITEM = registerRaw("nickel", RAW_NICKEL_BLOCK);
        RAW_SILVER_BLOCK_ITEM = registerRaw("silver", RAW_SILVER_BLOCK);
        RAW_TIN_BLOCK_ITEM = registerRaw("tin", RAW_TIN_BLOCK);
        RAW_URANIUM_BLOCK_ITEM = registerRaw("uranium", RAW_URANIUM_BLOCK);
        RAW_OSMIUM_BLOCK_ITEM = registerRaw("osmium", RAW_OSMIUM_BLOCK);
        RAW_ZINC_BLOCK_ITEM = registerRaw("zinc", RAW_ZINC_BLOCK);        
        RAW_ALUMINUM_BLOCK_ITEM = registerRaw("aluminum", RAW_ALUMINUM_BLOCK);        
        RAW_CHROMIUM_BLOCK_ITEM = registerRaw("chromium", RAW_CHROMIUM_BLOCK);        
        RAW_COBALT_BLOCK_ITEM = registerRaw("cobalt", RAW_COBALT_BLOCK);        
        RAW_PLATINUM_BLOCK_ITEM = registerRaw("platinum", RAW_PLATINUM_BLOCK);        
        RAW_THORIUM_BLOCK_ITEM = registerRaw("thorium", RAW_THORIUM_BLOCK);        
        RAW_TITANIUM_BLOCK_ITEM = registerRaw("titanium", RAW_TITANIUM_BLOCK);        
        RAW_TUNGSTEN_BLOCK_ITEM = registerRaw("tungsten", RAW_TUNGSTEN_BLOCK);        
        RAW_ADAMANTIUM_BLOCK_ITEM = registerRaw("adamantium", RAW_ADAMANTIUM_BLOCK);        
        RAW_MYTHRIL_BLOCK_ITEM = registerRaw("mythril", RAW_MYTHRIL_BLOCK);        
        RAW_QUICKSILVER_BLOCK_ITEM = registerRaw("quicksilver", RAW_QUICKSILVER_BLOCK);        
        RAW_FROSTSTEEL_BLOCK_ITEM = registerRaw("froststeel", RAW_FROSTSTEEL_BLOCK);        
        RAW_CLOGGRUM_BLOCK_ITEM = registerRaw("cloggrum", RAW_CLOGGRUM_BLOCK);        
    }

    private static Block registerRaw(String name, MaterialColor color) {
        return Registry.register(
                Registry.BLOCK,
                new ResourceLocation(Constants.MODID, "raw_" + name + "_block"),
                new Block(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(5f, 6f))
        );
    }

    private static Item registerRaw(String name, Block block) {
        return Registry.register(
                Registry.ITEM,
                new ResourceLocation(Constants.MODID, "raw_" + name + "_block"),
                new BlockItem(block, PROPERTIES)
        );
    }
    
}
