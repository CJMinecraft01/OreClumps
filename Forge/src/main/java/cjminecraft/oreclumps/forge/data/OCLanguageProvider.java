package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.init.OCBlocks;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class OCLanguageProvider extends LanguageProvider {
    public OCLanguageProvider(DataGenerator gen, String locale) {
        super(gen, Constants.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        final String locale = this.getName().substring("Languages: ".length());

        switch (locale) {
            case "en_gb", "en_us" -> {
                addItem(OCItems.RAW_LEAD, "Raw Lead");
                addItem(OCItems.RAW_NICKEL, "Raw Nickel");
                addItem(OCItems.RAW_SILVER, "Raw Silver");
                addItem(OCItems.RAW_TIN, "Raw Tin");
                addItem(OCItems.RAW_URANIUM, "Raw Uranium");
                addItem(OCItems.RAW_OSMIUM, "Raw Osmium");
                addItem(OCItems.RAW_ZINC, "Raw Zinc");
                addItem(OCItems.RAW_ALUMINUM, locale.equals("en_us") ? "Raw Aluminum" : "Raw Aluminium");
                addItem(OCItems.RAW_CHROMIUM, "Raw Chromium");
                addItem(OCItems.RAW_COBALT, "Raw Cobalt");
                addItem(OCItems.RAW_PLATINUM, "Raw Platinum");
                addItem(OCItems.RAW_THORIUM, "Raw Thorium");
                addItem(OCItems.RAW_TITANIUM, "Raw Titanium");
                addItem(OCItems.RAW_TUNGSTEN, "Raw Tungsten");
                addItem(OCItems.RAW_ADAMANTIUM, "Raw Adamantium");
                addItem(OCItems.RAW_MYTHRIL, "Raw Mythril");
                addItem(OCItems.RAW_QUICKSILVER, "Raw Quicksilver");
                addItem(OCItems.RAW_FROSTSTEEL, "Raw Frost Steel");
                addItem(OCItems.RAW_CLOGGRUM, "Raw Cloggrum");

                addBlock(OCBlocks.RAW_LEAD_BLOCK, "Block of Raw Lead");
                addBlock(OCBlocks.RAW_NICKEL_BLOCK, "Block of Raw Nickel");
                addBlock(OCBlocks.RAW_SILVER_BLOCK, "Block of Raw Silver");
                addBlock(OCBlocks.RAW_TIN_BLOCK, "Block of Raw Tin");
                addBlock(OCBlocks.RAW_URANIUM_BLOCK, "Block of Raw Uranium");
                addBlock(OCBlocks.RAW_OSMIUM_BLOCK, "Block of Raw Osmium");
                addBlock(OCBlocks.RAW_ZINC_BLOCK, "Block of Raw Zinc");
                addBlock(OCBlocks.RAW_ALUMINUM_BLOCK, locale.equals("en_us") ? "Block of Raw Aluminum" : "Block of Raw Aluminium");
                addBlock(OCBlocks.RAW_CHROMIUM_BLOCK, "Block of Raw Chromium");
                addBlock(OCBlocks.RAW_COBALT_BLOCK, "Block of Raw Cobalt");
                addBlock(OCBlocks.RAW_PLATINUM_BLOCK, "Block of Raw Platinum");
                addBlock(OCBlocks.RAW_THORIUM_BLOCK, "Block of Raw Thorium");
                addBlock(OCBlocks.RAW_TITANIUM_BLOCK, "Block of Raw Titanium");
                addBlock(OCBlocks.RAW_TUNGSTEN_BLOCK, "Block of Raw Tungsten");
                addBlock(OCBlocks.RAW_ADAMANTIUM_BLOCK, "Block of Raw Adamantium");
                addBlock(OCBlocks.RAW_MYTHRIL_BLOCK, "Block of Raw Mythril");
                addBlock(OCBlocks.RAW_QUICKSILVER_BLOCK, "Block of Raw Quicksilver");
                addBlock(OCBlocks.RAW_FROSTSTEEL_BLOCK, "Block of Raw Frost Steel");
                addBlock(OCBlocks.RAW_CLOGGRUM_BLOCK, "Block of Raw Cloggrum");
            }
        }
    }
}
