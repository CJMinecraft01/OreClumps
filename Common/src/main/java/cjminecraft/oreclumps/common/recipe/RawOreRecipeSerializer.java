package cjminecraft.oreclumps.common.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;

public class RawOreRecipeSerializer<T extends AbstractCookingRecipe> implements RecipeSerializer<T> {

    private final int defaultCookingTime;
    private final CookieBaker<T> factory;

    public RawOreRecipeSerializer(CookieBaker<T> factory, int defaultCookingTime) {
        this.defaultCookingTime = defaultCookingTime;
        this.factory = factory;
    }

    @Override
    public @NotNull T fromJson(@NotNull ResourceLocation resourceLocation, @NotNull JsonObject jsonObject) {
        String group = GsonHelper.getAsString(jsonObject, "group", "");
        JsonElement jsonElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
        Ingredient ingredient = Ingredient.fromJson(jsonElement);
        jsonElement = GsonHelper.isArrayNode(jsonObject, "result") ? GsonHelper.getAsJsonArray(jsonObject, "result") : GsonHelper.getAsJsonObject(jsonObject, "result");
        Ingredient result = Ingredient.fromJson(jsonElement);
        float experience = GsonHelper.getAsFloat(jsonObject, "experience", 0.0F);
        int cookingTime = GsonHelper.getAsInt(jsonObject, "cookingtime", this.defaultCookingTime);
        return this.factory.create(resourceLocation, group, ingredient, result.isEmpty() ? ItemStack.EMPTY : result.getItems()[0], experience, cookingTime);
    }

    @Override
    public @NotNull T fromNetwork(@NotNull ResourceLocation resourceLocation, FriendlyByteBuf buf) {
        String group = buf.readUtf();
        Ingredient ingredient = Ingredient.fromNetwork(buf);
        ItemStack result = buf.readItem();
        float experience = buf.readFloat();
        int cookingTime = buf.readInt();
        return this.factory.create(resourceLocation, group, ingredient, result, experience, cookingTime);
    }

    @Override
    public void toNetwork(@NotNull FriendlyByteBuf buf, @NotNull T t) {
        buf.writeUtf(t.getGroup());
        t.getIngredients().get(0).toNetwork(buf);
        buf.writeItem(t.getResultItem());
        buf.writeFloat(t.getExperience());
        buf.writeInt(t.getCookingTime());
    }

    public interface CookieBaker<T extends AbstractCookingRecipe> {
        T create(ResourceLocation id, String group, Ingredient input, ItemStack output, float experience, int cookingTime);
    }
}
