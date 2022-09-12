package cjminecraft.oreclumps.fabric.common.loot;

import cjminecraft.oreclumps.fabric.common.init.OCCodecs;
import cjminecraft.oreclumps.fabric.common.init.OCLootModifiers;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface GlobalLootModifier {

    Codec<GlobalLootModifier> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> OCCodecs.LOOT_MODIFIER_SERIALIZERS_CODEC)
            .dispatch(GlobalLootModifier::codec, Function.identity());

    Codec<LootItemFunction[]> LOOT_FUNCTIONS_CODEC = Codec.PASSTHROUGH.flatXmap(
            d -> {
                try {
                    LootItemFunction[] functions = LootModifierManager.GSON_INSTANCE.fromJson(GlobalLootModifier.getJson(d), LootItemFunction[].class);
                    return DataResult.success(functions);
                } catch (JsonSyntaxException e) {
                    LootModifierManager.LOGGER.warn("Unable to decode loot functions", e);
                    return DataResult.error(e.getMessage());
                }
            },
            functions -> {
                try {
                    JsonElement element = LootModifierManager.GSON_INSTANCE.toJsonTree(functions);
                    return DataResult.success(new Dynamic<>(JsonOps.INSTANCE, element));
                } catch (JsonSyntaxException e) {
                    LootModifierManager.LOGGER.warn("Unable to encode loot functions", e);
                    return DataResult.error(e.getMessage());
                }
            }
    );

    Codec<LootItemCondition[]> LOOT_CONDITIONS_CODEC = Codec.PASSTHROUGH.flatXmap(
            d ->
            {
                try
                {
                    LootItemCondition[] conditions = LootModifierManager.GSON_INSTANCE.fromJson(getJson(d), LootItemCondition[].class);
                    return DataResult.success(conditions);
                }
                catch (JsonSyntaxException e)
                {
                    LootModifierManager.LOGGER.warn("Unable to decode loot conditions", e);
                    return DataResult.error(e.getMessage());
                }
            },
            conditions ->
            {
                try
                {
                    JsonElement element = LootModifierManager.GSON_INSTANCE.toJsonTree(conditions);
                    return DataResult.success(new Dynamic<>(JsonOps.INSTANCE, element));
                }
                catch (JsonSyntaxException e)
                {
                    LootModifierManager.LOGGER.warn("Unable to encode loot conditions", e);
                    return DataResult.error(e.getMessage());
                }
            }
    );

    @SuppressWarnings("unchecked")
    static <U> JsonElement getJson(Dynamic<?> dynamic) {
        Dynamic<U> typed = (Dynamic<U>) dynamic;
        return typed.getValue() instanceof JsonElement ?
                (JsonElement) typed.getValue() :
                typed.getOps().convertTo(JsonOps.INSTANCE, typed.getValue());
    }

    @NotNull ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> generatedLoot, LootContext context);

    Codec<? extends GlobalLootModifier> codec();

}
