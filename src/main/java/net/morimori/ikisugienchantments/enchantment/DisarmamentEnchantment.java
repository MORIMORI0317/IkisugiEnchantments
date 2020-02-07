package net.morimori.ikisugienchantments.enchantment;

import java.util.ArrayList;
import java.util.Collections;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.morimori.ikisugienchantments.config.CommonConfig;
import net.morimori.ikisugienchantments.util.EntityHelper;

public class DisarmamentEnchantment extends BaseEnchantment {
	public DisarmamentEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return CommonConfig.DisarmamentEnchantabilityMin.get()
				+ (enchantmentLevel - 1) * CommonConfig.DisarmamentEnchantabilityCost.get();
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + CommonConfig.DisarmamentEnchantabilityCostSpan.get();
	}

	public boolean isTreasureEnchantment() {
		return CommonConfig.DisarmamentTreasure.get();
	}

	@Override
	public int getMaxLevel() {
		return CommonConfig.DisarmamentMaxLevel.get();
	}

	public boolean isCurse() {
		return CommonConfig.DisarmamentCurse.get();
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	@Override
	public void attack(LivingEntity attacker, LivingEntity target, ItemStack itemStack, int level,
			EntityDamageSource source) {

		if (!(source.damageType == "mob" || source.damageType == "player"))
			return;

		if (target instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) target;
			ArrayList<EquipmentSlotType> types = new ArrayList<EquipmentSlotType>();

			if (!livingentity.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty())
				types.add(EquipmentSlotType.MAINHAND);

			if (!livingentity.getItemStackFromSlot(EquipmentSlotType.OFFHAND).isEmpty())
				types.add(EquipmentSlotType.OFFHAND);

			if (!livingentity.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty())
				types.add(EquipmentSlotType.HEAD);

			if (!livingentity.getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty())
				types.add(EquipmentSlotType.CHEST);

			if (!livingentity.getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty())
				types.add(EquipmentSlotType.LEGS);

			if (!livingentity.getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty())
				types.add(EquipmentSlotType.FEET);

			if (!types.isEmpty()) {
				Collections.shuffle(types);
				for (int i = 0; i < level; ++i) {
					EntityHelper.dropEquipment(livingentity, types.get(i));
				}

				target.world.playSound((PlayerEntity) null, target.getPosition(),
						SoundEvents.ENTITY_ITEM_FRAME_BREAK,
						SoundCategory.HOSTILE, 1.0F + target.getRNG().nextFloat(),
						1);
			}
		}
	}

}
