package cjminecraft.oreclumps.forge.common.init;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.common.recipe.RawOreRecipeSerializer;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OCRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Constants.MODID);

    public static final RegistryObject<RecipeSerializer<?>> RAW_ORE_SMELTING_RECIPE_SERIALIZER = SERIALIZERS.register("raw_ore_smelting", () -> new RawOreRecipeSerializer<>(SmeltingRecipe::new, 200));
    public static final RegistryObject<RecipeSerializer<?>> RAW_ORE_BLASTING_RECIPE_SERIALIZER = SERIALIZERS.register("raw_ore_smelting", () -> new RawOreRecipeSerializer<>(BlastingRecipe::new, 100));

}