package cjminecraft.oreclumps.common.recipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;

public abstract class RawOreRecipe extends AbstractCookingRecipe {

    protected final Ingredient result;

    public RawOreRecipe(RecipeType<?> type, ResourceLocation id, String group, Ingredient ingredient, Ingredient result, float experience, int cookingTime) {
        super(type, id, group, ingredient, ItemStack.EMPTY, experience, cookingTime);
        this.result = result;
    }

    public Ingredient getResult() {
        return result;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container container) {
        return getResultItem().copy();
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return this.result.getItems()[0];
    }
}
