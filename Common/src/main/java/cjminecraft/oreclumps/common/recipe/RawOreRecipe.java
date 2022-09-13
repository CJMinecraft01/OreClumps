package cjminecraft.oreclumps.common.recipe;

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public interface RawOreRecipe {

    Ingredient getResult();


    @NotNull
    default ItemStack assemble(@NotNull Container container) {
        return getResultItem().copy();
    }


    @NotNull
    default ItemStack getResultItem() {
        return getResult().getItems().length > 0 ? getResult().getItems()[0] : ItemStack.EMPTY;
    }
}
