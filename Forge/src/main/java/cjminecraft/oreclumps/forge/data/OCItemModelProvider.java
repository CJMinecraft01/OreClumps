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
    }

    private void generated(String name) {
        withExistingParent(name, "item/generated").texture("layer0", "oreclumps:item/" + name);
    }
}
