package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.morimori.ikisugienchantments.util.EntityHelper;

public class TreatmentEnchantment extends BaseEnchantment {

	protected TreatmentEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	@Override
	public void attack(LivingEntity attacker, LivingEntity target, ItemStack itemStack, int level,
			EntityDamageSource source) {
		if (!(source.damageType == "mob" || source.damageType == "player"))
			return;

		EntityHelper.treatmentEntity(target);

	}

	public boolean isTreasureEnchantment() {
		return true;
	}

	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}
}
