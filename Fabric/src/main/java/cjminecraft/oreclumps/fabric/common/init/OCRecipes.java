package cjminecraft.oreclumps.fabric.common.init;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.common.recipe.RawOreBlastingRecipe;
import cjminecraft.oreclumps.common.recipe.RawOreRecipeSerializer;
import cjminecraft.oreclumps.common.recipe.RawOreSmeltingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class OCRecipes {

    public static RawOreRecipeSerializer<?> RAW_ORE_SMELTING_RECIPE_SERIALIZER;
    public static RawOreRecipeSerializer<?> RAW_ORE_BLASTING_RECIPE_SERIALIZER;

    private static <T extends RecipeSerializer<?>> T register(String name, T serializer) {
        return Registry.register(
                Registry.RECIPE_SERIALIZER,
                new ResourceLocation(Constants.MODID, name),
                serializer
        );
    }

    public static void register() {
        RAW_ORE_SMELTING_RECIPE_SERIALIZER = register("raw_ore_smelting", new RawOreRecipeSerializer<>(RawOreSmeltingRecipe::new, 200));
        RAW_ORE_BLASTING_RECIPE_SERIALIZER = register("raw_ore_blasting", new RawOreRecipeSerializer<>(RawOreBlastingRecipe::new, 100));
    }

}
