package cjminecraft.oreclumps.fabric.loot;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.Deserializers;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class RawOreModifier extends LootModifier {
    
    private static final Gson GSON_INSTANCE = Deserializers.createFunctionSerializer().create();
    
    private final LootItemFunction[] functions;
    private final Item replacement;
    private final String toReplaceTagString;
    private Tag<Block> toReplace = null;
    private final Block blockToReplace;
    private final int xpMin;
    private final int xpMax;
    
    public RawOreModifier(LootItemCondition[] conditionsIn, LootItemFunction[] functions, String toReplace, Item replacement, int xpMin, int xpMax) {
        super(conditionsIn);
        this.functions = functions;
        this.toReplaceTagString = toReplace;
        this.blockToReplace = null;
        this.replacement = replacement;
        this.xpMin = xpMin;
        this.xpMax = xpMax;
    }
    
    public RawOreModifier(LootItemCondition[] conditionsIn, LootItemFunction[] functions, Tag<Block> toReplace, Item replacement, int xpMin, int xpMax) {
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
    
    public boolean shouldOverrideDrop(BlockState state) {
        return (this.getTag() != null && state.is(this.getTag()))
                || (this.blockToReplace != null && state.is(this.blockToReplace));
    }
    
    private Tag<Block> getTag() {
        // used to delay fetching the tag since tags are cleared when reading the loot modifier
        if (this.toReplaceTagString != null && this.toReplace == null)
            this.toReplace = BlockTags.getAllTags().getTagOrEmpty(new ResourceLocation(this.toReplaceTagString));
        return this.toReplace;
    }
    
    @Override
    @NotNull
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
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
    
    public static class Serializer extends GlobalLootModifierSerializer<RawOreModifier> {
        @Override
        public RawOreModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] conditions) {
            LootItemFunction[] functions = object.has("functions") ? GSON_INSTANCE.fromJson(object.get("functions"), LootItemFunction[].class) : new LootItemFunction[0];
            Item replacement = Registry.ITEM.get(new ResourceLocation(GsonHelper.getAsString(object, "replacement")));
            String toReplace = GsonHelper.getAsString(object, "replace");
            int xpMin = object.has("xp_min") ? object.get("xp_min").getAsInt() : 0;
            int xpMax = object.has("xp_max") ? object.get("xp_max").getAsInt() : xpMin;
            if (toReplace.startsWith("#"))
                return new RawOreModifier(conditions, functions, toReplace.substring(1), replacement, xpMin, xpMax);
            Block block = Registry.BLOCK.get(new ResourceLocation(toReplace));
            return new RawOreModifier(conditions, functions, block, replacement, xpMin, xpMax);
        }
        
        @Override
        public JsonObject write(RawOreModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            if (!ArrayUtils.isEmpty(instance.functions))
                json.add("functions", GSON_INSTANCE.toJsonTree(instance.functions));
            if (instance.toReplace != null)
                json.addProperty("replace", "#" + BlockTags.getAllTags().getId(instance.toReplace));
            else if (instance.toReplaceTagString != null)
                json.addProperty("replace", "#" + instance.toReplaceTagString);
            else if (instance.blockToReplace != null)
                json.addProperty("replace", Objects.requireNonNull(Registry.BLOCK.getKey(instance.blockToReplace)).toString());
            
            json.addProperty("replacement", Objects.requireNonNull(Registry.ITEM.getKey(instance.replacement)).toString());
            if (instance.xpMin > 0)
                json.addProperty("xp_min", instance.xpMin);
            if (instance.xpMax > 0)
                json.addProperty("xp_min", instance.xpMax);
            
            return json;
        }
    }
}

