package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OCBlockModelProvider extends BlockModelProvider {
    public OCBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        rawOreBlock("raw_lead_block");
        rawOreBlock("raw_nickel_block");
        rawOreBlock("raw_silver_block");
        rawOreBlock("raw_tin_block");
        rawOreBlock("raw_uranium_block");
        rawOreBlock("raw_osmium_block");
        rawOreBlock("raw_zinc_block");
        rawOreBlock("raw_aluminum_block");
        rawOreBlock("raw_chromium_block");
        rawOreBlock("raw_cobalt_block");
        rawOreBlock("raw_platinum_block");
        rawOreBlock("raw_thorium_block");
        rawOreBlock("raw_titanium_block");
        rawOreBlock("raw_tungsten_block");
        rawOreBlock("raw_adamantium_block");
        rawOreBlock("raw_mythril_block");
        rawOreBlock("raw_quicksilver_block");
        rawOreBlock("raw_froststeel_block");
        rawOreBlock("raw_cloggrum_block");
    }

    private void rawOreBlock(String name) {
        cubeAll(name, new ResourceLocation(Constants.MODID, "block/" + name));
    }
}
