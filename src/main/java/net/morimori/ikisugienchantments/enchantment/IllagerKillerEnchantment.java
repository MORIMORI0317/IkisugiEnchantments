package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.inventory.EquipmentSlotType;
import net.morimori.ikisugienchantments.config.CommonConfig;

public class IllagerKillerEnchantment extends BaneCreatureEnchantment {

	public IllagerKillerEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, CreatureAttribute.ILLAGER, slots);

	}

	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.IllagerKillerEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.IllagerKillerEnchantabilityCost.get();
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + CommonConfig.IllagerKillerEnchantabilityCostSpan.get();
	}

	public int getMaxLevel() {
		return CommonConfig.IllagerKillerMaxLevel.get();
	}

	public boolean isCurse() {
		return CommonConfig.IllagerKillerCurse.get();
	}

	public boolean isTreasureEnchantment() {
		return CommonConfig.IllagerKillerTreasure.get();
	}
}
