package cjminecraft.oreclumps.forge.common.recipe;

import cjminecraft.oreclumps.common.recipe.RawOreRecipe;
import cjminecraft.oreclumps.forge.common.init.OCRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class RawOreBlastingRecipe extends RawOreRecipe {
    public RawOreBlastingRecipe(ResourceLocation id, String group, Ingredient ingredient, Ingredient result, float experience, int cookingTime) {
        super(RecipeType.BLASTING, id, group, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return OCRecipes.RAW_ORE_BLASTING_RECIPE_SERIALIZER.get();
    }
}
