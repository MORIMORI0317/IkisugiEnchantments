package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.inventory.EquipmentSlotType;
import net.morimori.ikisugienchantments.config.CommonConfig;

public class GlowPotionEnchantment extends AttackPotionEnchantment {

	protected GlowPotionEnchantment(Rarity rarityIn, net.minecraft.potion.Effect effect,
			EquipmentSlotType... slots) {
		super(rarityIn, effect, 0, 0, 0, slots);
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.GlowEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.GlowEnchantabilityCost.get();
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + CommonConfig.GlowEnchantabilityCostSpan.get();
	}

	@Override
	public int getMaxLevel() {
		return CommonConfig.GlowMaxLevel.get();
	}

	@Override
	public boolean isTreasureEnchantment() {
		return CommonConfig.GlowTreasure.get();
	}

	@Override
	public boolean isCurse() {
		return CommonConfig.GlowCurse.get();
	}

}
