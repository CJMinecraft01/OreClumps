package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class OCItemTagsProvider extends TagsProvider<Item> {
    public OCItemTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Registry.ITEM, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
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
                OCItems.RAW_QUICKSILVER.get(),
                OCItems.RAW_FROSTSTEEL.get(),
                OCItems.RAW_CLOGGRUM.get()
        );
        
        tag(ItemTags.create(new ResourceLocation("forge", "ores/lead")))
                .add(OCItems.RAW_LEAD.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/nickel")))
                .add(OCItems.RAW_NICKEL.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/silver")))
                .add(OCItems.RAW_SILVER.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/tin")))
                .add(OCItems.RAW_TIN.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/osmium")))
                .add(OCItems.RAW_OSMIUM.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/uranium")))
                .add(OCItems.RAW_URANIUM.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/zinc")))
                .add(OCItems.RAW_ZINC.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/aluminum")))
                .add(OCItems.RAW_ALUMINUM.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/chromium")))
                .add(OCItems.RAW_CHROMIUM.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/cobalt")))
                .add(OCItems.RAW_COBALT.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/platinum")))
                .add(OCItems.RAW_PLATINUM.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/thorium")))
                .add(OCItems.RAW_THORIUM.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/titanium")))
                .add(OCItems.RAW_TITANIUM.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/tungsten")))
                .add(OCItems.RAW_TUNGSTEN.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/adamantium")))
                .add(OCItems.RAW_ADAMANTIUM.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/mythril")))
                .add(OCItems.RAW_MYTHRIL.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/quicksilver")))
                .add(OCItems.RAW_QUICKSILVER.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/froststeel")))
                .add(OCItems.RAW_FROSTSTEEL.get());
        tag(ItemTags.create(new ResourceLocation("forge", "ores/cloggrum")))
                .add(OCItems.RAW_CLOGGRUM.get());
    }
}
