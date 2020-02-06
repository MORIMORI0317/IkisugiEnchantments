package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.inventory.EquipmentSlotType;
import net.morimori.ikisugienchantments.config.CommonConfig;

public class ToxicityPotionEnchantment extends AttackPotionEnchantment {

	protected ToxicityPotionEnchantment(Rarity rarityIn, net.minecraft.potion.Effect effect,
			EquipmentSlotType... slots) {
		super(rarityIn, effect, 0, 0, 0, slots);
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.ToxicityEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.ToxicityEnchantabilityCost.get();
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + CommonConfig.ToxicityEnchantabilityCostSpan.get();
	}

	@Override
	public int getMaxLevel() {
		return CommonConfig.ToxicityMaxLevel.get();
	}

	@Override
	public boolean isTreasureEnchantment() {
		return CommonConfig.ToxicityTreasure.get();
	}

	@Override
	public boolean isCurse() {
		return CommonConfig.ToxicityCurse.get();
	}

}
