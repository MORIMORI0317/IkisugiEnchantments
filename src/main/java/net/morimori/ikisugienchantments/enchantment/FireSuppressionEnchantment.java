package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class FireSuppressionEnchantment extends BaseEnchantment {
	public FireSuppressionEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
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

	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {

		ObfuscationReflectionHelper.setPrivateValue(Entity.class, target, 0, "fire");

	}
}
