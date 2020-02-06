package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.inventory.EquipmentSlotType;
import net.morimori.ikisugienchantments.config.CommonConfig;

public class WeakeningPotionEnchantment extends AttackPotionEnchantment {

	protected WeakeningPotionEnchantment(Rarity rarityIn, net.minecraft.potion.Effect effect,
			EquipmentSlotType... slots) {
		super(rarityIn, effect, 0, 0, 0, slots);
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.WeakeningEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.WeakeningEnchantabilityCost.get();
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + CommonConfig.WeakeningEnchantabilityCostSpan.get();
	}

	@Override
	public int getMaxLevel() {
		return CommonConfig.WeakeningMaxLevel.get();
	}

	@Override
	public boolean isTreasureEnchantment() {
		return CommonConfig.WeakeningTreasure.get();
	}

	@Override
	public boolean isCurse() {
		return CommonConfig.WeakeningCurse.get();
	}

}
