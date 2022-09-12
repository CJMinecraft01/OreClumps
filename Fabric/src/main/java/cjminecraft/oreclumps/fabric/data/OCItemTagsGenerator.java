package cjminecraft.oreclumps.fabric.data;

import cjminecraft.oreclumps.fabric.common.init.OCItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class OCItemTagsGenerator extends FabricTagProvider<Item> {

    public OCItemTagsGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.ITEM);
    }

    @Override
    protected void generateTags() {
        getOrCreateTagBuilder(ConventionalItemTags.ORES).add(
                OCItems.RAW_LEAD,
                OCItems.RAW_NICKEL,
                OCItems.RAW_SILVER,
                OCItems.RAW_TIN,
                OCItems.RAW_OSMIUM,
                OCItems.RAW_URANIUM,
                OCItems.RAW_ZINC,
                OCItems.RAW_ALUMINUM,
                OCItems.RAW_CHROMIUM,
                OCItems.RAW_COBALT,
                OCItems.RAW_PLATINUM,
                OCItems.RAW_THORIUM,
                OCItems.RAW_TITANIUM,
                OCItems.RAW_TUNGSTEN,
                OCItems.RAW_ADAMANTIUM,
                OCItems.RAW_MYTHRIL,
                OCItems.RAW_QUICKSILVER,
                OCItems.RAW_FROSTSTEEL,
                OCItems.RAW_CLOGGRUM
        );

        getOrCreateTagBuilder(ModTags.LEAD_ORES).add(OCItems.RAW_LEAD);
        getOrCreateTagBuilder(ModTags.NICKEL_ORES).add(OCItems.RAW_NICKEL);
        getOrCreateTagBuilder(ModTags.SILVER_ORES).add(OCItems.RAW_SILVER);
        getOrCreateTagBuilder(ModTags.TIN_ORES).add(OCItems.RAW_TIN);
        getOrCreateTagBuilder(ModTags.OSMIUM_ORES).add(OCItems.RAW_OSMIUM);
        getOrCreateTagBuilder(ModTags.URANIUM_ORES).add(OCItems.RAW_URANIUM);
        getOrCreateTagBuilder(ModTags.ZINC_ORES).add(OCItems.RAW_ZINC);
        getOrCreateTagBuilder(ModTags.ALUMINUM_ORES).add(OCItems.RAW_ALUMINUM);
        getOrCreateTagBuilder(ModTags.CHROMIUM_ORES).add(OCItems.RAW_CHROMIUM);
        getOrCreateTagBuilder(ModTags.COBALT_ORES).add(OCItems.RAW_COBALT);
        getOrCreateTagBuilder(ModTags.PLATINUM_ORES).add(OCItems.RAW_PLATINUM);
        getOrCreateTagBuilder(ModTags.THORIUM_ORES).add(OCItems.RAW_THORIUM);
        getOrCreateTagBuilder(ModTags.TITANIUM_ORES).add(OCItems.RAW_TITANIUM);
        getOrCreateTagBuilder(ModTags.TUNGSTEN_ORES).add(OCItems.RAW_TUNGSTEN);
        getOrCreateTagBuilder(ModTags.ADAMANTIUM_ORES).add(OCItems.RAW_ADAMANTIUM);
        getOrCreateTagBuilder(ModTags.MYTHRIL_ORES).add(OCItems.RAW_MYTHRIL);
        getOrCreateTagBuilder(ModTags.QUICKSILVER_ORES).add(OCItems.RAW_QUICKSILVER);
        getOrCreateTagBuilder(ModTags.FROSTSTEEL_ORES).add(OCItems.RAW_FROSTSTEEL);
        getOrCreateTagBuilder(ModTags.CLOGGRUM_ORES).add(OCItems.RAW_CLOGGRUM);
    }
}
