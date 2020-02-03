package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class BaneCreatureEnchantment extends BaseEnchantment {
	private CreatureAttribute tyape;

	public BaneCreatureEnchantment(Rarity rarityIn, CreatureAttribute cre, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
		this.tyape = cre;
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return 5 + (enchantmentLevel - 1) * 8;
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + 20;
	}

	public boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof DamageEnchantment || ench instanceof BaneCreatureEnchantment
				|| ench instanceof ShipmentEnchantment);
	}

	@Override
	public float calcDamageByCreature(int level, CreatureAttribute creatureType) {
		if (creatureType == tyape)
			return (float) level * 2.5F;

		return 0;
	}

	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	public int getMaxLevel() {
		return 5;
	}
}
