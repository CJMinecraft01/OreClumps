package cjminecraft.oreclumps.common.recipe;

import cjminecraft.oreclumps.platform.Services;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;

public class RawOreBlastingRecipe extends BlastingRecipe implements RawOreRecipe {

    private final Ingredient result;

    public RawOreBlastingRecipe(ResourceLocation id, String group, Ingredient ingredient, Ingredient result, float experience, int cookingTime) {
        super(id, group, ingredient, ItemStack.EMPTY, experience, cookingTime);
        this.result = result;
    }

    public Ingredient getResult() {
        return result;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return this.result.getItems().length > 0 ? this.result.getItems()[0] : ItemStack.EMPTY;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container container) {
        return getResultItem().copy();
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Services.REGISTRIES.RAW_ORE_BLASTING_RECIPE_SERIALIZER().get();
    }
}
