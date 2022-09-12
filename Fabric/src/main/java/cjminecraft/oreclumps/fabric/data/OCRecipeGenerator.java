package cjminecraft.oreclumps.fabric.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.common.recipe.RawOreRecipeSerializer;
import cjminecraft.oreclumps.data.RawOreRecipeBuilder;
import cjminecraft.oreclumps.fabric.common.init.OCBlocks;
import cjminecraft.oreclumps.fabric.common.init.OCItems;
import cjminecraft.oreclumps.fabric.common.init.OCRecipes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class OCRecipeGenerator extends FabricRecipeProvider {

    public static void oreCooking(Consumer<FinishedRecipe> exporter, RawOreRecipeSerializer<?> serializer, Item ingredient, TagKey<Item> result, float experience, int cookingTime, @Nullable String group, String pathMiddle) {
        RawOreRecipeBuilder.cooking(Ingredient.of(ingredient), Ingredient.of(result), experience, cookingTime, serializer).group(group).unlockedBy(getHasName(ingredient), has(ingredient)).save(exporter, new ResourceLocation(Constants.MODID, result.location().getPath() + pathMiddle + "_" + getItemName(ingredient)));
    }

    public static void oreSmelting(Consumer<FinishedRecipe> exporter, Item ingredient, TagKey<Item> result, float experience, int cookingTime, @Nullable String group) {
        oreCooking(exporter, OCRecipes.RAW_ORE_SMELTING_RECIPE_SERIALIZER, ingredient, result, experience, cookingTime, group, "_from_smelting");
    }

    public static void oreBlasting(Consumer<FinishedRecipe> exporter, Item ingredient, TagKey<Item> result, float experience, int cookingTime, @Nullable String group) {
        oreCooking(exporter, OCRecipes.RAW_ORE_BLASTING_RECIPE_SERIALIZER, ingredient, result, experience, cookingTime, group, "_from_blasting");
    }

    private static void rawOreRecipes(Consumer<FinishedRecipe> exporter, Item raw, Item rawBlock, TagKey<Item> ingot, String name) {
        rawOre(exporter, raw, rawBlock);
        rawOreBlock(exporter, raw, rawBlock);
        ingotFromRaw(exporter, raw, ingot, name);
    }

    private static void rawOre(Consumer<FinishedRecipe> exporter, Item raw, Item rawBlock) {
        ShapelessRecipeBuilder.shapeless(raw, 9).requires(rawBlock).unlockedBy("has_raw_ore_block", has(rawBlock)).save(exporter);
    }

    private static void rawOreBlock(Consumer<FinishedRecipe> exporter, Item raw, Item rawBlock) {
        ShapedRecipeBuilder.shaped(rawBlock).define('#', raw).pattern("###").pattern("###").pattern("###").unlockedBy("has_raw_ore", has(raw)).save(exporter);
    }

    private static void ingotFromRaw(Consumer<FinishedRecipe> exporter, Item raw, TagKey<Item> ingot, String name) {
        oreSmelting(exporter, raw, ingot, 0.7f, 200, name);
        oreBlasting(exporter, raw, ingot, 0.7f, 100, name);
    }

    public OCRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<FinishedRecipe> exporter) {
        rawOreRecipes(exporter, OCItems.RAW_LEAD, OCBlocks.RAW_LEAD_BLOCK_ITEM, ModTags.LEAD_INGOTS, "lead");
        rawOreRecipes(exporter, OCItems.RAW_NICKEL, OCBlocks.RAW_NICKEL_BLOCK_ITEM, ModTags.NICKEL_INGOTS, "nickel");
        rawOreRecipes(exporter, OCItems.RAW_OSMIUM, OCBlocks.RAW_OSMIUM_BLOCK_ITEM, ModTags.OSMIUM_INGOTS, "osmium");
        rawOreRecipes(exporter, OCItems.RAW_SILVER, OCBlocks.RAW_SILVER_BLOCK_ITEM, ModTags.SILVER_INGOTS, "silver");
        rawOreRecipes(exporter, OCItems.RAW_TIN, OCBlocks.RAW_TIN_BLOCK_ITEM, ModTags.TIN_INGOTS, "tin");
        rawOreRecipes(exporter, OCItems.RAW_URANIUM, OCBlocks.RAW_URANIUM_BLOCK_ITEM, ModTags.URANIUM_INGOTS, "uranium");
        rawOreRecipes(exporter, OCItems.RAW_ZINC, OCBlocks.RAW_ZINC_BLOCK_ITEM, ModTags.ZINC_INGOTS, "zinc");
        rawOreRecipes(exporter, OCItems.RAW_ALUMINUM, OCBlocks.RAW_ALUMINUM_BLOCK_ITEM, ModTags.ALUMINUM_INGOTS, "aluminum");
        rawOreRecipes(exporter, OCItems.RAW_CHROMIUM, OCBlocks.RAW_CHROMIUM_BLOCK_ITEM, ModTags.CHROMIUM_INGOTS, "chromium");
        rawOreRecipes(exporter, OCItems.RAW_COBALT, OCBlocks.RAW_COBALT_BLOCK_ITEM, ModTags.COBALT_INGOTS, "cobalt");
        rawOreRecipes(exporter, OCItems.RAW_PLATINUM, OCBlocks.RAW_PLATINUM_BLOCK_ITEM, ModTags.PLATINUM_INGOTS, "platinum");
        rawOreRecipes(exporter, OCItems.RAW_THORIUM, OCBlocks.RAW_THORIUM_BLOCK_ITEM, ModTags.THORIUM_INGOTS, "thorium");
        rawOreRecipes(exporter, OCItems.RAW_TITANIUM, OCBlocks.RAW_TITANIUM_BLOCK_ITEM, ModTags.TITANIUM_INGOTS, "titanium");
        rawOreRecipes(exporter, OCItems.RAW_TUNGSTEN, OCBlocks.RAW_TUNGSTEN_BLOCK_ITEM, ModTags.TUNGSTEN_INGOTS, "tungsten");
        rawOreRecipes(exporter, OCItems.RAW_ADAMANTIUM, OCBlocks.RAW_ADAMANTIUM_BLOCK_ITEM, ModTags.ADAMANTIUM_INGOTS, "adamantium");
        rawOreRecipes(exporter, OCItems.RAW_MYTHRIL, OCBlocks.RAW_MYTHRIL_BLOCK_ITEM, ModTags.MYTHRIL_INGOTS, "mythril");
        rawOreRecipes(exporter, OCItems.RAW_QUICKSILVER, OCBlocks.RAW_QUICKSILVER_BLOCK_ITEM, ModTags.QUICKSILVER_INGOTS, "quicksilver");
        rawOreRecipes(exporter, OCItems.RAW_FROSTSTEEL, OCBlocks.RAW_FROSTSTEEL_BLOCK_ITEM, ModTags.FROSTSTEEL_INGOTS, "froststeel");
        rawOreRecipes(exporter, OCItems.RAW_CLOGGRUM, OCBlocks.RAW_CLOGGRUM_BLOCK_ITEM, ModTags.CLOGGRUM_INGOTS, "cloggrum");
    }
}
