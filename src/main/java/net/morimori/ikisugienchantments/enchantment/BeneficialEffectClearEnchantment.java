package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.EntityDamageSource;
import net.morimori.ikisugienchantments.config.CommonConfig;

public class BeneficialEffectClearEnchantment extends BaseEnchantment {
	public BeneficialEffectClearEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.BeneficialEffectClearEnchantabilityMin.get();
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return CommonConfig.BeneficialEffectClearEnchantabilityMax.get();
	}

	public boolean isTreasureEnchantment() {
		return CommonConfig.BeneficialEffectClearTreasure.get();
	}

	public boolean isCurse() {
		return CommonConfig.BeneficialEffectClearCurse.get();
	}

	public boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof FireAspectEnchantment);
	}

	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	public void attack(LivingEntity attacker, LivingEntity target, ItemStack itemStack, int level,
			EntityDamageSource source) {
		if (!(source.damageType == "mob" || source.damageType == "player"))
			return;

		for (EffectInstance e : target.getActivePotionEffects()) {

			if (e.getPotion().isBeneficial())
				target.removePotionEffect(e.getPotion());

		}
	}
}
