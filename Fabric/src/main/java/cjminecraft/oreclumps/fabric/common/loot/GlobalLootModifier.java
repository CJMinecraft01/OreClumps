package cjminecraft.oreclumps.fabric.common.loot;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface GlobalLootModifier {

    Codec<GlobalLootModifier> DIRECT_CODEC = ExtraCodecs.lazyInitializedCodec(() -> GlobalLootModifierCodec.INSTANCE)
            .dispatch(GlobalLootModifier::codec, Function.identity());

    @NotNull ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> generatedLoot, LootContext context);

    Codec<? extends GlobalLootModifier> codec();

}
