package cjminecraft.oreclumps.platform;

import cjminecraft.oreclumps.common.recipe.RawOreRecipeSerializer;
import cjminecraft.oreclumps.forge.common.init.OCRecipes;
import cjminecraft.oreclumps.platform.services.IRegistryHelper;

import java.util.function.Supplier;

public class ForgeRegistryHelper implements IRegistryHelper {

    @Override
    public Supplier<RawOreRecipeSerializer<?>> RAW_ORE_BLASTING_RECIPE_SERIALIZER() {
        return OCRecipes.RAW_ORE_BLASTING_RECIPE_SERIALIZER;
    }

    @Override
    public Supplier<RawOreRecipeSerializer<?>> RAW_ORE_SMELTING_RECIPE_SERIALIZER() {
        return OCRecipes.RAW_ORE_SMELTING_RECIPE_SERIALIZER;
    }
}
