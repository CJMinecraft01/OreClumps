package cjminecraft.oreclumps.forge.common.init;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.common.recipe.RawOreBlastingRecipe;
import cjminecraft.oreclumps.common.recipe.RawOreRecipeSerializer;
import cjminecraft.oreclumps.common.recipe.RawOreSmeltingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OCRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Constants.MODID);

    public static final RegistryObject<RawOreRecipeSerializer<?>> RAW_ORE_SMELTING_RECIPE_SERIALIZER = SERIALIZERS.register("raw_ore_smelting", () -> new RawOreRecipeSerializer<>(RawOreSmeltingRecipe::new, 200));
    public static final RegistryObject<RawOreRecipeSerializer<?>> RAW_ORE_BLASTING_RECIPE_SERIALIZER = SERIALIZERS.register("raw_ore_blasting", () -> new RawOreRecipeSerializer<>(RawOreBlastingRecipe::new, 100));

}
