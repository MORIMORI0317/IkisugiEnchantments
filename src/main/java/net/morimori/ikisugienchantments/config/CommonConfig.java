package net.morimori.ikisugienchantments.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.morimori.ikisugienchantments.IkisugiEnchant;

public class CommonConfig {
	public static ConfigValue<Integer> SlowdownnEnchantabilityMin;
	public static ConfigValue<Integer> SlowdownnEnchantabilityCost;
	public static ConfigValue<Integer> SlowdownnEnchantabilityCostSpan;
	public static ConfigValue<Integer> SlowdownnMaxLevel;
	public static ConfigValue<Boolean> SlowdownnTreasure;
	public static ConfigValue<Boolean> SlowdownnCurse;

	public static ConfigValue<Integer> GlowEnchantabilityMin;
	public static ConfigValue<Integer> GlowEnchantabilityCost;
	public static ConfigValue<Integer> GlowEnchantabilityCostSpan;
	public static ConfigValue<Integer> GlowMaxLevel;
	public static ConfigValue<Boolean> GlowTreasure;
	public static ConfigValue<Boolean> GlowCurse;

	public static ConfigValue<Integer> ToxicityEnchantabilityMin;
	public static ConfigValue<Integer> ToxicityEnchantabilityCost;
	public static ConfigValue<Integer> ToxicityEnchantabilityCostSpan;
	public static ConfigValue<Integer> ToxicityMaxLevel;
	public static ConfigValue<Boolean> ToxicityTreasure;
	public static ConfigValue<Boolean> ToxicityCurse;

	public static ConfigValue<Integer> WeaknessEnchantabilityMin;
	public static ConfigValue<Integer> WeaknessEnchantabilityCost;
	public static ConfigValue<Integer> WeaknessEnchantabilityCostSpan;
	public static ConfigValue<Integer> WeaknessMaxLevel;
	public static ConfigValue<Boolean> WeaknessTreasure;
	public static ConfigValue<Boolean> WeaknessCurse;

	public static ConfigValue<Integer> WeakeningEnchantabilityMin;
	public static ConfigValue<Integer> WeakeningEnchantabilityCost;
	public static ConfigValue<Integer> WeakeningEnchantabilityCostSpan;
	public static ConfigValue<Integer> WeakeningMaxLevel;
	public static ConfigValue<Boolean> WeakeningTreasure;
	public static ConfigValue<Boolean> WeakeningCurse;

	public static ConfigValue<Integer> FloatingEnchantabilityMin;
	public static ConfigValue<Integer> FloatingEnchantabilityCost;
	public static ConfigValue<Integer> FloatingEnchantabilityCostSpan;
	public static ConfigValue<Integer> FloatingMaxLevel;
	public static ConfigValue<Boolean> FloatingTreasure;
	public static ConfigValue<Boolean> FloatingCurse;

	public static ConfigValue<Integer> TreatmentEnchantabilityMin;
	public static ConfigValue<Integer> TreatmentEnchantabilityMax;
	public static ConfigValue<Boolean> TreatmentTreasure;
	public static ConfigValue<Boolean> TreatmentCurse;

	public static ConfigValue<Integer> IllagerKillerEnchantabilityMin;
	public static ConfigValue<Integer> IllagerKillerEnchantabilityCost;
	public static ConfigValue<Integer> IllagerKillerEnchantabilityCostSpan;
	public static ConfigValue<Integer> IllagerKillerMaxLevel;
	public static ConfigValue<Boolean> IllagerKillerTreasure;
	public static ConfigValue<Boolean> IllagerKillerCurse;

	public static void init() {
		Pair<ConfigLoder, ForgeConfigSpec> common_config = new ForgeConfigSpec.Builder().configure(ConfigLoder::new);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, common_config.getRight());

	}

	static class ConfigLoder {
		public ConfigLoder(ForgeConfigSpec.Builder builder) {
			IkisugiEnchant.LOGGER.info("Config Loading...");
			builder.push("Slowdown Enchantment");
			SlowdownnEnchantabilityMin = builder.define("Enchantability Min", 1);
			SlowdownnEnchantabilityCost = builder.define("Enchantability Cost", 11);
			SlowdownnEnchantabilityCostSpan = builder.define("Enchantability CostSpan", 20);
			SlowdownnMaxLevel = builder.define("MaxLevel", 5);
			SlowdownnTreasure = builder.define("Treasure", false);
			SlowdownnCurse = builder.define("Curse", false);
			builder.pop();
			builder.push("Glow Enchantment");
			GlowEnchantabilityMin = builder.define("Enchantability Min", 1);
			GlowEnchantabilityCost = builder.define("Enchantability Cost", 11);
			GlowEnchantabilityCostSpan = builder.define("Enchantability CostSpan", 20);
			GlowMaxLevel = builder.define("MaxLevel", 5);
			GlowTreasure = builder.define("Treasure", false);
			GlowCurse = builder.define("Curse", false);
			builder.pop();
			builder.push("Toxicity Enchantment");
			ToxicityEnchantabilityMin = builder.define("Enchantability Min", 5);
			ToxicityEnchantabilityCost = builder.define("Enchantability Cost", 8);
			ToxicityEnchantabilityCostSpan = builder.define("Enchantability CostSpan", 20);
			ToxicityMaxLevel = builder.define("MaxLevel", 5);
			ToxicityTreasure = builder.define("Treasure", false);
			ToxicityCurse = builder.define("Curse", false);
			builder.pop();
			builder.push("Weakness Enchantment");
			WeaknessEnchantabilityMin = builder.define("Enchantability Min", 5);
			WeaknessEnchantabilityCost = builder.define("Enchantability Cost", 8);
			WeaknessEnchantabilityCostSpan = builder.define("Enchantability CostSpan", 20);
			WeaknessMaxLevel = builder.define("MaxLevel", 5);
			WeaknessTreasure = builder.define("Treasure", false);
			WeaknessCurse = builder.define("Curse", false);
			builder.pop();
			builder.push("Weakening Enchantment");
			WeakeningEnchantabilityMin = builder.define("Enchantability Min", 2);
			WeakeningEnchantabilityCost = builder.define("Enchantability Cost", 10);
			WeakeningEnchantabilityCostSpan = builder.define("Enchantability CostSpan", 25);
			WeakeningMaxLevel = builder.define("MaxLevel", 5);
			WeakeningTreasure = builder.define("Treasure", false);
			WeakeningCurse = builder.define("Curse", false);
			builder.pop();
			builder.push("Floating Enchantment");
			FloatingEnchantabilityMin = builder.define("Enchantability Min", 20);
			FloatingEnchantabilityCost = builder.define("Enchantability Cost", 15);
			FloatingEnchantabilityCostSpan = builder.define("Enchantability CostSpan", 50);
			FloatingMaxLevel = builder.define("MaxLevel", 5);
			FloatingTreasure = builder.define("Treasure", false);
			FloatingCurse = builder.define("Curse", false);
			builder.pop();
			builder.push("Treatment Enchantment");
			TreatmentEnchantabilityMin = builder.define("Enchantability Min", 30);
			TreatmentEnchantabilityMax = builder.define("Enchantability Max", 60);
			TreatmentTreasure = builder.define("Treasure", true);
			TreatmentCurse = builder.define("Curse", false);
			builder.pop();
			builder.push("IllagerKiller Enchantment");
			IllagerKillerEnchantabilityMin = builder.define("Enchantability Min", 5);
			IllagerKillerEnchantabilityCost = builder.define("Enchantability Cost", 8);
			IllagerKillerEnchantabilityCostSpan = builder.define("Enchantability CostSpan", 20);
			IllagerKillerMaxLevel = builder.define("MaxLevel", 5);
			IllagerKillerTreasure = builder.define("Treasure", false);
			IllagerKillerCurse = builder.define("Curse", false);
			builder.pop();
		}

	}

}
