package cjminecraft.oreclumps.platform.services;

import cjminecraft.oreclumps.common.recipe.RawOreRecipeSerializer;

import java.util.function.Supplier;

public interface IRegistryHelper {

    Supplier<RawOreRecipeSerializer<?>> RAW_ORE_BLASTING_RECIPE_SERIALIZER();
    Supplier<RawOreRecipeSerializer<?>> RAW_ORE_SMELTING_RECIPE_SERIALIZER();

}
