package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class OCItemTagsProvider extends ItemTagsProvider {
    public OCItemTagsProvider(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, provider, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.INGOTS).add(
                OCItems.LEAD_INGOT.get(),
                OCItems.NICKEL_INGOT.get(),
                OCItems.SILVER_INGOT.get(),
                OCItems.TIN_INGOT.get(),
                OCItems.OSMIUM_INGOT.get(),
                OCItems.URANIUM_INGOT.get(),
                OCItems.ZINC_INGOT.get(),
                OCItems.ALUMINUM_INGOT.get(),
                OCItems.CHROMIUM_INGOT.get(),
                OCItems.COBALT_INGOT.get(),
                OCItems.PLATINUM_INGOT.get(),
                OCItems.THORIUM_INGOT.get(),
                OCItems.TITANIUM_INGOT.get(),
                OCItems.TUNGSTEN_INGOT.get(),
                OCItems.ADAMANTIUM_INGOT.get(),
                OCItems.MYTHRIL_INGOT.get(),
                OCItems.QUICKSILVER_INGOT.get()
        );

        tag(Tags.Items.ORES).add(
                OCItems.RAW_LEAD.get(),
                OCItems.RAW_NICKEL.get(),
                OCItems.RAW_SILVER.get(),
                OCItems.RAW_TIN.get(),
                OCItems.RAW_OSMIUM.get(),
                OCItems.RAW_URANIUM.get(),
                OCItems.RAW_ZINC.get(),
                OCItems.RAW_ALUMINUM.get(),
                OCItems.RAW_CHROMIUM.get(),
                OCItems.RAW_COBALT.get(),
                OCItems.RAW_PLATINUM.get(),
                OCItems.RAW_THORIUM.get(),
                OCItems.RAW_TITANIUM.get(),
                OCItems.RAW_TUNGSTEN.get(),
                OCItems.RAW_ADAMANTIUM.get(),
                OCItems.RAW_MYTHRIL.get(),
                OCItems.RAW_QUICKSILVER.get()
        );
        
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/lead")))
                .add(OCItems.RAW_LEAD.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/nickel")))
                .add(OCItems.RAW_NICKEL.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/silver")))
                .add(OCItems.RAW_SILVER.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/tin")))
                .add(OCItems.RAW_TIN.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/osmium")))
                .add(OCItems.RAW_OSMIUM.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/uranium")))
                .add(OCItems.RAW_URANIUM.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/zinc")))
                .add(OCItems.RAW_ZINC.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/aluminum")))
                .add(OCItems.RAW_ALUMINUM.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/chromium")))
                .add(OCItems.RAW_CHROMIUM.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/cobalt")))
                .add(OCItems.RAW_COBALT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/platinum")))
                .add(OCItems.RAW_PLATINUM.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/thorium")))
                .add(OCItems.RAW_THORIUM.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/titanium")))
                .add(OCItems.RAW_TITANIUM.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/tungsten")))
                .add(OCItems.RAW_TUNGSTEN.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/adamantium")))
                .add(OCItems.RAW_ADAMANTIUM.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/mythril")))
                .add(OCItems.RAW_MYTHRIL.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ores/quicksilver")))
                .add(OCItems.RAW_QUICKSILVER.get());
        
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/lead")))
                .add(OCItems.LEAD_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/nickel")))
                .add(OCItems.NICKEL_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/silver")))
                .add(OCItems.SILVER_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/tin")))
                .add(OCItems.TIN_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/osmium")))
                .add(OCItems.OSMIUM_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/uranium")))
                .add(OCItems.URANIUM_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/zinc")))
                .add(OCItems.ZINC_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/aluminum")))
                .add(OCItems.ALUMINUM_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/chromium")))
                .add(OCItems.CHROMIUM_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/cobalt")))
                .add(OCItems.COBALT_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/platinum")))
                .add(OCItems.PLATINUM_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/thorium")))
                .add(OCItems.THORIUM_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/titanium")))
                .add(OCItems.TITANIUM_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/tungsten")))
                .add(OCItems.TUNGSTEN_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/adamantium")))
                .add(OCItems.ADAMANTIUM_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/mythril")))
                .add(OCItems.MYTHRIL_INGOT.get());
        tag(ItemTags.createOptional(new ResourceLocation("forge", "ingots/quicksilver")))
                .add(OCItems.QUICKSILVER_INGOT.get());
    }
}
