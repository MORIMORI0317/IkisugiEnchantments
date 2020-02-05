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

public class BadEffectClearEnchantment extends BaseEnchantment {
	public BadEffectClearEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return 10 + 20 * (enchantmentLevel - 1);
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + 50;
	}

	public boolean isTreasureEnchantment() {
		return true;
	}

	public boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof FireAspectEnchantment);
	}

	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	public boolean isCurse() {
		return true;
	}

	public void attack(LivingEntity attacker, LivingEntity target, ItemStack itemStack, int level,
			EntityDamageSource source) {

		if (!(source.damageType == "mob" || source.damageType == "player"))
			return;

		for (EffectInstance e : target.getActivePotionEffects()) {

			if (!e.getPotion().isBeneficial())
				target.removePotionEffect(e.getPotion());

		}
	}
}
