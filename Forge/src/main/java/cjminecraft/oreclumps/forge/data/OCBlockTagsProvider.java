package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class OCBlockTagsProvider extends BlockTagsProvider {
    public OCBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }
}
