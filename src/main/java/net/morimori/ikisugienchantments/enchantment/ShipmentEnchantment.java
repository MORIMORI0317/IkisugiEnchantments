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
import net.morimori.ikisugienchantments.config.CommonConfig;

public class ShipmentEnchantment extends BaseEnchantment {

	public ShipmentEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.ShipmentEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.ShipmentEnchantabilityCost.get();
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + CommonConfig.ShipmentEnchantabilityCostSpan.get();
	}

	public boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof DamageEnchantment || ench instanceof BaneCreatureEnchantment
				|| ench instanceof ShipmentEnchantment);
	}

	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	public int getMaxLevel() {
		return CommonConfig.ShipmentMaxLevel.get();
	}

	public boolean isCurse() {
		return CommonConfig.ShipmentCurse.get();
	}

	public boolean isTreasureEnchantment() {
		return CommonConfig.ShipmentTreasure.get();
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
