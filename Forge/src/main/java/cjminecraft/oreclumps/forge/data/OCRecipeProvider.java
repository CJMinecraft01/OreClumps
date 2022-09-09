package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.common.recipe.RawOreRecipeSerializer;
import cjminecraft.oreclumps.data.RawOreRecipeBuilder;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import cjminecraft.oreclumps.forge.common.init.OCRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class OCRecipeProvider extends RecipeProvider {

    public static void oreCooking(Consumer<FinishedRecipe> exporter, RawOreRecipeSerializer<?> serializer, Item ingredient, TagKey<Item> result, float experience, int cookingTime, @Nullable String group, String pathMiddle) {
        RawOreRecipeBuilder.cooking(Ingredient.of(ingredient), Ingredient.of(result), experience, cookingTime, serializer).group(group).unlockedBy(getHasName(ingredient), has(ingredient)).save(exporter, new ResourceLocation(Constants.MODID, result.location().getPath() + pathMiddle + "_" + getItemName(ingredient)));
    }

    public static void oreSmelting(Consumer<FinishedRecipe> exporter, RegistryObject<Item> ingredient, TagKey<Item> result, float experience, int cookingTime, @Nullable String group) {
        oreCooking(exporter, OCRecipes.RAW_ORE_SMELTING_RECIPE_SERIALIZER.get(), ingredient.get(), result, experience, cookingTime, group, "_from_smelting");
    }

    public static void oreBlasting(Consumer<FinishedRecipe> exporter, RegistryObject<Item> ingredient, TagKey<Item> result, float experience, int cookingTime, @Nullable String group) {
        oreCooking(exporter, OCRecipes.RAW_ORE_BLASTING_RECIPE_SERIALIZER.get(), ingredient.get(), result, experience, cookingTime, group, "_from_blasting");
    }

    public OCRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> exporter) {
        oreSmelting(exporter, OCItems.RAW_LEAD, ModTags.LEAD_INGOTS, 0.7f, 200, "lead_ingot");
        oreBlasting(exporter, OCItems.RAW_LEAD, ModTags.LEAD_INGOTS, 0.7f, 100, "lead_ingot");
        oreSmelting(exporter, OCItems.RAW_NICKEL, ModTags.NICKEL_INGOTS, 0.7f, 200, "nickel_ingot");
        oreBlasting(exporter, OCItems.RAW_NICKEL, ModTags.NICKEL_INGOTS, 0.7f, 100, "nickel_ingot");
        oreSmelting(exporter, OCItems.RAW_SILVER, ModTags.SILVER_INGOTS, 0.7f, 200, "silver_ingot");
        oreBlasting(exporter, OCItems.RAW_SILVER, ModTags.SILVER_INGOTS, 0.7f, 100, "silver_ingot");
        oreSmelting(exporter, OCItems.RAW_TIN, ModTags.TIN_INGOTS, 0.7f, 200, "tin_ingot");
        oreBlasting(exporter, OCItems.RAW_TIN, ModTags.TIN_INGOTS, 0.7f, 100, "tin_ingot");
        oreSmelting(exporter, OCItems.RAW_URANIUM, ModTags.URANIUM_INGOTS, 0.7f, 200, "uranium_ingot");
        oreBlasting(exporter, OCItems.RAW_URANIUM, ModTags.URANIUM_INGOTS, 0.7f, 100, "uranium_ingot");
        oreSmelting(exporter, OCItems.RAW_OSMIUM, ModTags.OSMIUM_INGOTS, 0.7f, 200, "osmium_ingot");
        oreBlasting(exporter, OCItems.RAW_OSMIUM, ModTags.OSMIUM_INGOTS, 0.7f, 100, "osmium_ingot");
        oreSmelting(exporter, OCItems.RAW_ZINC, ModTags.ZINC_INGOTS, 0.7f, 200, "zinc_ingot");
        oreBlasting(exporter, OCItems.RAW_ZINC, ModTags.ZINC_INGOTS, 0.7f, 100, "zinc_ingot");
        oreSmelting(exporter, OCItems.RAW_ALUMINUM, ModTags.ALUMINUM_INGOTS, 0.7f, 200, "aluminum_ingot");
        oreBlasting(exporter, OCItems.RAW_ALUMINUM, ModTags.ALUMINUM_INGOTS, 0.7f, 100, "aluminum_ingot");
        oreSmelting(exporter, OCItems.RAW_CHROMIUM, ModTags.CHROMIUM_INGOTS, 0.7f, 200, "chromium_ingot");
        oreBlasting(exporter, OCItems.RAW_CHROMIUM, ModTags.CHROMIUM_INGOTS, 0.7f, 100, "chromium_ingot");
        oreSmelting(exporter, OCItems.RAW_COBALT, ModTags.COBALT_INGOTS, 0.7f, 200, "cobalt_ingot");
        oreBlasting(exporter, OCItems.RAW_COBALT, ModTags.COBALT_INGOTS, 0.7f, 100, "cobalt_ingot");
        oreSmelting(exporter, OCItems.RAW_PLATINUM, ModTags.PLATINUM_INGOTS, 0.7f, 200, "platinum_ingot");
        oreBlasting(exporter, OCItems.RAW_PLATINUM, ModTags.PLATINUM_INGOTS, 0.7f, 100, "platinum_ingot");
        oreSmelting(exporter, OCItems.RAW_THORIUM, ModTags.THORIUM_INGOTS, 0.7f, 200, "thorium_ingot");
        oreBlasting(exporter, OCItems.RAW_THORIUM, ModTags.THORIUM_INGOTS, 0.7f, 100, "thorium_ingot");
        oreSmelting(exporter, OCItems.RAW_TITANIUM, ModTags.TITANIUM_INGOTS, 0.7f, 200, "titanium_ingot");
        oreBlasting(exporter, OCItems.RAW_TITANIUM, ModTags.TITANIUM_INGOTS, 0.7f, 100, "titanium_ingot");
        oreSmelting(exporter, OCItems.RAW_TUNGSTEN, ModTags.TUNGSTEN_INGOTS, 0.7f, 200, "tungsten_ingot");
        oreBlasting(exporter, OCItems.RAW_TUNGSTEN, ModTags.TUNGSTEN_INGOTS, 0.7f, 100, "tungsten_ingot");
        oreSmelting(exporter, OCItems.RAW_ADAMANTIUM, ModTags.ADAMANTIUM_INGOTS, 0.7f, 200, "adamantium_ingot");
        oreBlasting(exporter, OCItems.RAW_ADAMANTIUM, ModTags.ADAMANTIUM_INGOTS, 0.7f, 100, "adamantium_ingot");
        oreSmelting(exporter, OCItems.RAW_MYTHRIL, ModTags.MYTHRIL_INGOTS, 0.7f, 200, "mythril_ingot");
        oreBlasting(exporter, OCItems.RAW_MYTHRIL, ModTags.MYTHRIL_INGOTS, 0.7f, 100, "mythril_ingot");
    }
}
