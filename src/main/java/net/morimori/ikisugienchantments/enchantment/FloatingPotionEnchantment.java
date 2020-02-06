package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.inventory.EquipmentSlotType;
import net.morimori.ikisugienchantments.config.CommonConfig;

public class FloatingPotionEnchantment extends AttackPotionEnchantment {

	protected FloatingPotionEnchantment(Rarity rarityIn, net.minecraft.potion.Effect effect,
			EquipmentSlotType... slots) {
		super(rarityIn, effect, 0, 0, 0, slots);
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.FloatingEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.FloatingEnchantabilityCost.get();
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + CommonConfig.FloatingEnchantabilityCostSpan.get();
	}

	@Override
	public int getMaxLevel() {
		return CommonConfig.FloatingMaxLevel.get();
	}

	@Override
	public boolean isTreasureEnchantment() {
		return CommonConfig.FloatingTreasure.get();
	}

	@Override
	public boolean isCurse() {
		return CommonConfig.FloatingCurse.get();
	}

}
