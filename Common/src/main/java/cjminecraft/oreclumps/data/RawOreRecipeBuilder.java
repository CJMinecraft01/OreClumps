package cjminecraft.oreclumps.data;

import cjminecraft.oreclumps.common.recipe.RawOreRecipeSerializer;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static net.minecraft.data.recipes.RecipeBuilder.ROOT_RECIPE_ADVANCEMENT;

public class RawOreRecipeBuilder {
    private final Ingredient result;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final RawOreRecipeSerializer<?> serializer;

    private RawOreRecipeBuilder(Ingredient result, Ingredient ingredient, float experience, int cookingTime, RawOreRecipeSerializer<?> serializer) {
        this.result = result;
        this.ingredient = ingredient;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.serializer = serializer;
    }

    public static RawOreRecipeBuilder cooking(Ingredient ingredient, Ingredient result, float experience, int cookingTime, RawOreRecipeSerializer<?> serializer) {
        return new RawOreRecipeBuilder(result, ingredient, experience, cookingTime, serializer);
    }

    public RawOreRecipeBuilder unlockedBy(String criterion, CriterionTriggerInstance instance) {
        this.advancement.addCriterion(criterion, instance);
        return this;
    }

    public RawOreRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public void save(Consumer<FinishedRecipe> exporter, ResourceLocation location) {
        this.ensureValid(location);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(location)).rewards(AdvancementRewards.Builder.recipe(location)).requirements(RequirementsStrategy.OR);
        exporter.accept(new RawOreRecipeBuilder.Result(location, this.group == null ? "" : this.group, this.ingredient, this.result, this.experience, this.cookingTime, this.advancement, new ResourceLocation(location.getNamespace(), "recipes/" + this.ingredient.getItems()[0].getItem().getItemCategory().getRecipeFolderName() + "/" + location.getPath()), this.serializer));
    }

    private void ensureValid(ResourceLocation p_126266_) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + p_126266_);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Ingredient ingredient;
        private final Ingredient result;
        private final float experience;
        private final int cookingTime;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<? extends AbstractCookingRecipe> serializer;

        public Result(ResourceLocation id, String group, Ingredient ingredient, Ingredient result, float experience, int cookingTime, Advancement.Builder advancementBuilder, ResourceLocation advancementId, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
            this.id = id;
            this.group = group;
            this.ingredient = ingredient;
            this.result = result;
            this.experience = experience;
            this.cookingTime = cookingTime;
            this.advancement = advancementBuilder;
            this.advancementId = advancementId;
            this.serializer = serializer;
        }

        public void serializeRecipeData(JsonObject jsonObject) {
            if (!this.group.isEmpty()) {
                jsonObject.addProperty("group", this.group);
            }

            jsonObject.add("ingredient", this.ingredient.toJson());
            jsonObject.add("result", this.result.toJson());
            jsonObject.addProperty("experience", this.experience);
            jsonObject.addProperty("cookingtime", this.cookingTime);
        }

        public RecipeSerializer<?> getType() {
            return this.serializer;
        }

        public ResourceLocation getId() {
            return this.id;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
