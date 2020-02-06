package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.inventory.EquipmentSlotType;
import net.morimori.ikisugienchantments.config.CommonConfig;

public class WeaknessPotionEnchantment extends AttackPotionEnchantment {

	protected WeaknessPotionEnchantment(Rarity rarityIn, net.minecraft.potion.Effect effect,
			EquipmentSlotType... slots) {
		super(rarityIn, effect, 0, 0, 0, slots);
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.WeaknessEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.WeaknessEnchantabilityCost.get();
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + CommonConfig.WeaknessEnchantabilityCostSpan.get();
	}

	@Override
	public int getMaxLevel() {
		return CommonConfig.WeaknessMaxLevel.get();
	}

	@Override
	public boolean isTreasureEnchantment() {
		return CommonConfig.WeaknessTreasure.get();
	}

	@Override
	public boolean isCurse() {
		return CommonConfig.WeaknessCurse.get();
	}

}
