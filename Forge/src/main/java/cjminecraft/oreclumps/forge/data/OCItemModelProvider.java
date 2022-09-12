package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OCItemModelProvider extends ItemModelProvider {
    public OCItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        generated("raw_lead");
        generated("raw_nickel");
        generated("raw_silver");
        generated("raw_tin");
        generated("raw_uranium");
        generated("raw_osmium");
        generated("raw_zinc");
        generated("raw_aluminum");
        generated("raw_chromium");
        generated("raw_cobalt");
        generated("raw_platinum");
        generated("raw_thorium");
        generated("raw_titanium");
        generated("raw_tungsten");
        generated("raw_adamantium");
        generated("raw_mythril");
        generated("raw_quicksilver");
        generated("raw_froststeel");
        generated("raw_cloggrum");

        block("raw_lead_block");
        block("raw_nickel_block");
        block("raw_silver_block");
        block("raw_tin_block");
        block("raw_uranium_block");
        block("raw_osmium_block");
        block("raw_zinc_block");
        block("raw_aluminum_block");
        block("raw_chromium_block");
        block("raw_cobalt_block");
        block("raw_platinum_block");
        block("raw_thorium_block");
        block("raw_titanium_block");
        block("raw_tungsten_block");
        block("raw_adamantium_block");
        block("raw_mythril_block");
        block("raw_quicksilver_block");
        block("raw_froststeel_block");
        block("raw_cloggrum_block");
    }

    private void block(String name) {
        withExistingParent(name, "oreclumps:block/" + name);
    }

    private void generated(String name) {
        withExistingParent(name, "item/generated").texture("layer0", "oreclumps:item/" + name);
    }
}
