package cjminecraft.oreclumps.data;

import cjminecraft.oreclumps.common.OreClumps;
import cjminecraft.oreclumps.common.init.OCItems;
import cjminecraft.oreclumps.common.init.OCLootModifiers;
import cjminecraft.oreclumps.common.loot.RawOreModifier;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.Inverted;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.ILootFunction;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class OCGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public OCGlobalLootModifierProvider(DataGenerator gen) {
        super(gen, OreClumps.MODID);
    }

    @Override
    protected void start() {
        final ILootCondition[] conditions = new ILootCondition[] {
                Inverted.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))).build()
        };
        final ILootFunction[] functions = new ILootFunction[] {
                ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE).build(),
                ExplosionDecay.explosionDecay().build()
        };

        add("raw_iron", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, Tags.Blocks.ORES_IRON, OCItems.RAW_IRON.get()));
        add("raw_gold", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, Blocks.GOLD_ORE, OCItems.RAW_GOLD.get()));
        add("raw_copper", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/copper", OCItems.RAW_COPPER.get()));
        add("raw_lead", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/lead", OCItems.RAW_LEAD.get()));
        add("raw_nickel", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/nickel", OCItems.RAW_NICKEL.get()));
        add("raw_osmium", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/osmium", OCItems.RAW_OSMIUM.get()));
        add("raw_silver", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/silver", OCItems.RAW_SILVER.get()));
        add("raw_tin", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/tin", OCItems.RAW_TIN.get()));
        add("raw_uranium", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/uranium", OCItems.RAW_URANIUM.get()));
        add("raw_zinc", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/zinc", OCItems.RAW_ZINC.get()));
        add("raw_aluminum", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/aluminum", OCItems.RAW_ALUMINUM.get()));
        add("raw_chromium", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/chromium", OCItems.RAW_CHROMIUM.get()));
        add("raw_cobalt", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/cobalt", OCItems.RAW_COBALT.get()));
        add("raw_platinum", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/platinum", OCItems.RAW_PLATINUM.get()));
        add("raw_thorium", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/thorium", OCItems.RAW_THORIUM.get()));
        add("raw_titanium", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/titanium", OCItems.RAW_TITANIUM.get()));
        add("raw_tungsten", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/tungsten", OCItems.RAW_TUNGSTEN.get()));
        add("raw_adamantium", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/adamantium", OCItems.RAW_ADAMANTIUM.get()));
        add("raw_mythril", OCLootModifiers.RAW_ORE_MODIFIER.get(), new RawOreModifier(conditions, functions, "forge:ores/mythril", OCItems.RAW_MYTHRIL.get()));
    }


}
