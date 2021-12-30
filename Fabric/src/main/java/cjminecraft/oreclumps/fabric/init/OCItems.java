package cjminecraft.oreclumps.fabric.init;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.fabric.util.DeferredRegister;
import cjminecraft.oreclumps.fabric.util.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class OCItems {
    
    private static final Item.Properties PROPERTIES = new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS);
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registry.ITEM, Constants.MODID);
    
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_NICKEL = ITEMS.register("raw_nickel", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_URANIUM = ITEMS.register("raw_uranium", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_OSMIUM = ITEMS.register("raw_osmium", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_CHROMIUM = ITEMS.register("raw_chromium", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_COBALT = ITEMS.register("raw_cobalt", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_THORIUM = ITEMS.register("raw_thorium", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_ADAMANTIUM = ITEMS.register("raw_adamantium", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_MYTHRIL = ITEMS.register("raw_mythril", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_QUICKSILVER = ITEMS.register("raw_quicksilver", () -> new Item(PROPERTIES));
    
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> ADAMANTIUM_INGOT = ITEMS.register("adamantium_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> QUICKSILVER_INGOT = ITEMS.register("quicksilver_ingot", () -> new Item(PROPERTIES));
    
}
