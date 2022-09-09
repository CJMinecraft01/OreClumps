package cjminecraft.oreclumps.forge.data;

import cjminecraft.oreclumps.common.Constants;
import cjminecraft.oreclumps.forge.common.init.OCItems;
import cjminecraft.oreclumps.forge.common.loot.RawOreModifier;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class OCGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public OCGlobalLootModifierProvider(DataGenerator gen) {
        super(gen, Constants.MODID);
    }

    @Override
    protected void start() {
        final LootItemCondition[] conditions = new LootItemCondition[] {
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        };
        final LootItemFunction[] functions = new LootItemFunction[] {
                ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE).build(),
                ApplyExplosionDecay.explosionDecay().build()
        };

        add("raw_lead", new RawOreModifier(conditions, functions, "forge:ores/lead", OCItems.RAW_LEAD.get(), 0, 0));
        add("raw_nickel", new RawOreModifier(conditions, functions, "forge:ores/nickel", OCItems.RAW_NICKEL.get(), 0, 0));
        add("raw_osmium", new RawOreModifier(conditions, functions, "forge:ores/osmium", OCItems.RAW_OSMIUM.get(), 0, 0));
        add("raw_silver", new RawOreModifier(conditions, functions, "forge:ores/silver", OCItems.RAW_SILVER.get(), 0, 0));
        add("raw_tin", new RawOreModifier(conditions, functions, "forge:ores/tin", OCItems.RAW_TIN.get(), 0, 0));
        add("raw_uranium", new RawOreModifier(conditions, functions, "forge:ores/uranium", OCItems.RAW_URANIUM.get(), 0, 0));
        add("raw_zinc", new RawOreModifier(conditions, functions, "forge:ores/zinc", OCItems.RAW_ZINC.get(), 0, 0));
        add("raw_aluminum", new RawOreModifier(conditions, functions, "forge:ores/aluminum", OCItems.RAW_ALUMINUM.get(), 0, 0));
        add("raw_chromium", new RawOreModifier(conditions, functions, "forge:ores/chromium", OCItems.RAW_CHROMIUM.get(), 0, 0));
        add("raw_cobalt", new RawOreModifier(conditions, functions, "forge:ores/cobalt", OCItems.RAW_COBALT.get(), 0, 0));
        add("raw_platinum", new RawOreModifier(conditions, functions, "forge:ores/platinum", OCItems.RAW_PLATINUM.get(), 0, 0));
        add("raw_thorium", new RawOreModifier(conditions, functions, "forge:ores/thorium", OCItems.RAW_THORIUM.get(), 0, 0));
        add("raw_titanium", new RawOreModifier(conditions, functions, "forge:ores/titanium", OCItems.RAW_TITANIUM.get(), 0, 0));
        add("raw_tungsten", new RawOreModifier(conditions, functions, "forge:ores/tungsten", OCItems.RAW_TUNGSTEN.get(), 0, 0));
        add("raw_adamantium", new RawOreModifier(conditions, functions, "forge:ores/adamantium", OCItems.RAW_ADAMANTIUM.get(), 0, 0));
        add("raw_mythril", new RawOreModifier(conditions, functions, "forge:ores/mythril", OCItems.RAW_MYTHRIL.get(), 0, 0));
    }
}
