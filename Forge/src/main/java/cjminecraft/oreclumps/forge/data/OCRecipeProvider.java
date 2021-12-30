package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.forge.common.init.OCBlocks;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class OCRecipeProvider extends RecipeProvider {
    public OCRecipeProvider(DataGenerator generator) {
        super(generator);
    }
    
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        rawOreRecipes(consumer, OCItems.RAW_LEAD, OCBlocks.RAW_LEAD_BLOCK_ITEM, OCItems.LEAD_INGOT, "lead");
        rawOreRecipes(consumer, OCItems.RAW_NICKEL, OCBlocks.RAW_NICKEL_BLOCK_ITEM, OCItems.NICKEL_INGOT, "nickel");
        rawOreRecipes(consumer, OCItems.RAW_OSMIUM, OCBlocks.RAW_OSMIUM_BLOCK_ITEM, OCItems.OSMIUM_INGOT, "osmium");
        rawOreRecipes(consumer, OCItems.RAW_SILVER, OCBlocks.RAW_SILVER_BLOCK_ITEM, OCItems.SILVER_INGOT, "silver");
        rawOreRecipes(consumer, OCItems.RAW_TIN, OCBlocks.RAW_TIN_BLOCK_ITEM, OCItems.TIN_INGOT, "tin");
        rawOreRecipes(consumer, OCItems.RAW_URANIUM, OCBlocks.RAW_URANIUM_BLOCK_ITEM, OCItems.URANIUM_INGOT, "uranium");
        rawOreRecipes(consumer, OCItems.RAW_ZINC, OCBlocks.RAW_ZINC_BLOCK_ITEM, OCItems.ZINC_INGOT, "zinc");
        rawOreRecipes(consumer, OCItems.RAW_ALUMINUM, OCBlocks.RAW_ALUMINUM_BLOCK_ITEM, OCItems.ALUMINUM_INGOT, "aluminum");
        rawOreRecipes(consumer, OCItems.RAW_CHROMIUM, OCBlocks.RAW_CHROMIUM_BLOCK_ITEM, OCItems.CHROMIUM_INGOT, "chromium");
        rawOreRecipes(consumer, OCItems.RAW_COBALT, OCBlocks.RAW_COBALT_BLOCK_ITEM, OCItems.COBALT_INGOT, "cobalt");
        rawOreRecipes(consumer, OCItems.RAW_PLATINUM, OCBlocks.RAW_PLATINUM_BLOCK_ITEM, OCItems.PLATINUM_INGOT, "platinum");
        rawOreRecipes(consumer, OCItems.RAW_THORIUM, OCBlocks.RAW_THORIUM_BLOCK_ITEM, OCItems.THORIUM_INGOT, "thorium");
        rawOreRecipes(consumer, OCItems.RAW_TITANIUM, OCBlocks.RAW_TITANIUM_BLOCK_ITEM, OCItems.TITANIUM_INGOT, "titanium");
        rawOreRecipes(consumer, OCItems.RAW_TUNGSTEN, OCBlocks.RAW_TUNGSTEN_BLOCK_ITEM, OCItems.TUNGSTEN_INGOT, "tungsten");
        rawOreRecipes(consumer, OCItems.RAW_ADAMANTIUM, OCBlocks.RAW_ADAMANTIUM_BLOCK_ITEM, OCItems.ADAMANTIUM_INGOT, "adamantium");
        rawOreRecipes(consumer, OCItems.RAW_MYTHRIL, OCBlocks.RAW_MYTHRIL_BLOCK_ITEM, OCItems.MYTHRIL_INGOT, "mythril");
        rawOreRecipes(consumer, OCItems.RAW_QUICKSILVER, OCBlocks.RAW_QUICKSILVER_BLOCK_ITEM, OCItems.QUICKSILVER_INGOT, "quicksilver");
    }

    private static void rawOreRecipes(Consumer<FinishedRecipe> consumer, RegistryObject<Item> raw, RegistryObject<Item> rawBlock, Item ingot, float xp, String name) {
        rawOre(consumer, raw, rawBlock);
        rawOreBlock(consumer, raw, rawBlock, name);
        ingotFromRaw(consumer, raw, ingot, xp, name);
    }

    private static void rawOreRecipes(Consumer<FinishedRecipe> consumer, RegistryObject<Item> raw, RegistryObject<Item> rawBlock, RegistryObject<Item> ingot, String name) {
        rawOre(consumer, raw, rawBlock);
        rawOreBlock(consumer, raw, rawBlock, name);
        ingotFromRaw(consumer, raw, ingot, name);
    }

    private static void rawOre(Consumer<FinishedRecipe> consumer, RegistryObject<Item> raw, RegistryObject<Item> rawBlock) {
        ShapelessRecipeBuilder.shapeless(raw::get, 9).requires(rawBlock::get).unlockedBy("has_raw_ore_block", has(rawBlock::get)).save(consumer);
    }

    private static void rawOreBlock(Consumer<FinishedRecipe> consumer, RegistryObject<Item> raw, RegistryObject<Item> rawBlock, String name) {
        ShapedRecipeBuilder.shaped(rawBlock::get).define('#', raw::get).pattern("###").pattern("###").pattern("###").unlockedBy("has_raw_ore", has(raw::get)).save(consumer);
    }

    private static void ingotFromRaw(Consumer<FinishedRecipe> consumer, RegistryObject<Item> raw, RegistryObject<Item> ingot, String name) {
        ingotFromRaw(consumer, raw, ingot::get, 0.7f, name);
    }

    private static void ingotFromRaw(Consumer<FinishedRecipe> consumer, RegistryObject<Item> raw, ItemLike ingot, float xp, String name) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(raw.get().getDefaultInstance()), ingot, xp, 200).unlockedBy("has_raw_ore", has(raw::get)).save(consumer, "oreclumps:" + name + "_ingot_from_smelting_raw_" + name);
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(raw.get().getDefaultInstance()), ingot, xp, 100).unlockedBy("has_raw_ore", has(raw::get)).save(consumer, "oreclumps:" + name + "_ingot_from_blasting_raw_" + name);
    }
}
