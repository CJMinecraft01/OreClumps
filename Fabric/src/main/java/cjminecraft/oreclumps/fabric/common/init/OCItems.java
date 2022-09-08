package cjminecraft.oreclumps.fabric.common.init;

import cjminecraft.oreclumps.common.Constants;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class OCItems {

    private static final Item.Properties PROPERTIES = new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS);

    public static Item RAW_LEAD;
    public static Item RAW_NICKEL;
    public static Item RAW_SILVER;
    public static Item RAW_TIN;
    public static Item RAW_URANIUM;
    public static Item RAW_OSMIUM;
    public static Item RAW_ZINC;
    public static Item RAW_ALUMINUM;
    public static Item RAW_CHROMIUM;
    public static Item RAW_COBALT;
    public static Item RAW_PLATINUM;
    public static Item RAW_THORIUM;
    public static Item RAW_TITANIUM;
    public static Item RAW_TUNGSTEN;
    public static Item RAW_ADAMANTIUM;
    public static Item RAW_MYTHRIL;

    public static void register() {
        RAW_LEAD = register("raw_lead");
        RAW_NICKEL = register("raw_nickel");
        RAW_SILVER = register("raw_silver");
        RAW_TIN = register("raw_tin");
        RAW_URANIUM = register("raw_uranium");
        RAW_OSMIUM = register("raw_osmium");
        RAW_ZINC = register("raw_zinc");
        RAW_ALUMINUM = register("raw_aluminum");
        RAW_CHROMIUM = register("raw_chromium");
        RAW_COBALT = register("raw_cobalt");
        RAW_PLATINUM = register("raw_platinum");
        RAW_THORIUM = register("raw_thorium");
        RAW_TITANIUM = register("raw_titanium");
        RAW_TUNGSTEN = register("raw_tungsten");
        RAW_ADAMANTIUM = register("raw_adamantium");
        RAW_MYTHRIL = register("raw_mythril");
    }

    private static Item register(String name) {
        return Registry.register(
                Registry.ITEM,
                new ResourceLocation(Constants.MODID, name),
                new Item(PROPERTIES)
        );
    }

}
