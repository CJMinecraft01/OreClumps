package cjminecraft.oreclumps.forge.common.loot;

import com.google.common.base.Suppliers;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.common.loot.LootModifierManager;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Objects;
import java.util.function.Supplier;

public class RawOreModifier extends LootModifier {

    private static final Codec<LootItemFunction[]> LOOT_FUNCTIONS_CODEC = Codec.PASSTHROUGH.flatXmap(
            d -> {
                try {
                    LootItemFunction[] functions = LootModifierManager.GSON_INSTANCE.fromJson(IGlobalLootModifier.getJson(d), LootItemFunction[].class);
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

    public static final Supplier<Codec<RawOreModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    inst.group(
                            LOOT_FUNCTIONS_CODEC.optionalFieldOf("functions", new LootItemFunction[0]).forGetter(m -> m.functions),
                            Codec.STRING.fieldOf("replace").forGetter(RawOreModifier::getReplaceString),
                            ForgeRegistries.ITEMS.getCodec().fieldOf("replacement").forGetter(m -> m.replacement),
                            ExtraCodecs.POSITIVE_INT.optionalFieldOf("xp_min", 0).forGetter(m -> m.xpMin),
                            ExtraCodecs.POSITIVE_INT.optionalFieldOf("xp_max", 0).forGetter(m -> m.xpMax)
                    )).apply(inst, RawOreModifier::new)
            ));

    private final LootItemFunction[] functions;
    private final Item replacement;
    private final String toReplaceTagString;
    private final Block blockToReplace;
    private final int xpMin;
    private final int xpMax;
    private TagKey<Block> toReplace;

    public RawOreModifier(LootItemCondition[] conditionsIn, LootItemFunction[] functions, String toReplace, Item replacement, int xpMin, int xpMax) {
        super(conditionsIn);
        this.functions = functions;
        if (toReplace.startsWith("#")) {
            this.toReplaceTagString = toReplace.substring(1);
            this.blockToReplace = null;
        } else {
            this.blockToReplace = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(toReplace));
            this.toReplaceTagString = null;
        }
        this.replacement = replacement;
        this.xpMin = xpMin;
        this.xpMax = xpMax;
    }

    public RawOreModifier(LootItemCondition[] conditionsIn, LootItemFunction[] functions, TagKey<Block> toReplace, Item replacement, int xpMin, int xpMax) {
        super(conditionsIn);
        this.functions = functions;
        this.toReplace = toReplace;
        this.toReplaceTagString = null;
        this.blockToReplace = null;
        this.replacement = replacement;
        this.xpMin = xpMin;
        this.xpMax = xpMax;
    }

    public RawOreModifier(LootItemCondition[] conditionsIn, LootItemFunction[] functions, Block toReplace, Item replacement, int xpMin, int xpMax) {
        super(conditionsIn);
        this.functions = functions;
        this.toReplaceTagString = null;
        this.blockToReplace = toReplace;
        this.replacement = replacement;
        this.xpMin = xpMin;
        this.xpMax = xpMax;
    }

    public int getXpMin() {
        return this.xpMin;
    }

    public int getXpMax() {
        return this.xpMax;
    }

    private String getReplaceString() {
        return this.blockToReplace == null || this.blockToReplace.equals(Blocks.AIR) ? "#" + this.getTag().location() : Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(this.blockToReplace)).toString();
    }

    public boolean shouldOverrideDrop(BlockState state) {
        return (this.getTag() != null && state.is(this.getTag()))
                || (this.blockToReplace != null && state.is(this.blockToReplace));
    }

    private TagKey<Block> getTag() {
        // used to delay fetching the tag since tags are cleared when reading the loot modifier
        if (this.toReplaceTagString != null && this.toReplace == null)
            this.toReplace = ForgeRegistries.BLOCKS.tags().createOptionalTagKey(new ResourceLocation(this.toReplaceTagString), Collections.emptySet());
        return this.toReplace;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        BlockState state = context.getParamOrNull(LootContextParams.BLOCK_STATE);
        if (state != null) {
            // ensure that this is a block drop
            if (shouldOverrideDrop(state)) {
                // if we should replace the drop for this block
                generatedLoot.clear();
                ItemStack stack = this.replacement.getDefaultInstance();
                for (LootItemFunction function : this.functions)
                    stack = function.apply(stack, context);
                generatedLoot.add(stack);
            }
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
