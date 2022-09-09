package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
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
            }
        }
    }
}
