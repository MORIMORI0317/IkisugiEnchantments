package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.inventory.EquipmentSlotType;
import net.morimori.ikisugienchantments.config.CommonConfig;

public class SlowdownnPotionEnchantment extends AttackPotionEnchantment {

	protected SlowdownnPotionEnchantment(Rarity rarityIn, net.minecraft.potion.Effect effect,
			EquipmentSlotType... slots) {
		super(rarityIn, effect, 0, 0, 0, slots);
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.SlowdownnEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.SlowdownnEnchantabilityCost.get();
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + CommonConfig.SlowdownnEnchantabilityCostSpan.get();
	}

	@Override
	public int getMaxLevel() {
		return CommonConfig.SlowdownnMaxLevel.get();
	}

	@Override
	public boolean isTreasureEnchantment() {
		return CommonConfig.SlowdownnTreasure.get();
	}

	@Override
	public boolean isCurse() {
		return CommonConfig.SlowdownnCurse.get();
	}

}
