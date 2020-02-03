package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;

public class ShipmentEnchantment extends BaseEnchantment {

	public ShipmentEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
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

	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	public int getMaxLevel() {
		return 5;
	}

	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		if (target instanceof AnimalEntity) {
			AnimalEntity livingentity = (AnimalEntity) target;

			if (user instanceof PlayerEntity)
				livingentity.attackEntityFrom(new EntityDamageSource("player", user), level * 2f);
			else
				livingentity.attackEntityFrom(new EntityDamageSource("mob", user), level * 2f);

		}

	}
}
