package cjminecraft.oreclumps.forge.common.init;

import cjminecraft.oreclumps.common.Constants;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OCItems {

    private static final Item.Properties PROPERTIES = new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);

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
    public static final RegistryObject<Item> RAW_FROSTSTEEL = ITEMS.register("raw_froststeel", () -> new Item(PROPERTIES));
    public static final RegistryObject<Item> RAW_CLOGGRUM = ITEMS.register("raw_cloggrum", () -> new Item(PROPERTIES));

}
