package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class NoDamageEnchantment extends BaseEnchantment {
	public NoDamageEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return 1 + (enchantmentLevel - 1) * 11;
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + 20;
	}

	public boolean isTreasureEnchantment() {
		return true;
	}

	public boolean canApplyTogether(Enchantment ench) {
		return !((ench instanceof DamageEnchantment) || (ench instanceof NoDamageEnchantment)
				|| (ench instanceof DullnessEnchantment));
	}

	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	public boolean isCurse() {
		return true;
	}

	public float calcDamageByCreature(int level, CreatureAttribute creatureType) {

		return -Long.MAX_VALUE;

	}
}
