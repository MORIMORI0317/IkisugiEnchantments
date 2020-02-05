package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.Explosion.Mode;

public class ExplosionEnchantment extends BaseEnchantment {
	public ExplosionEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return 20 + (enchantmentLevel - 1) * 10;
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + 70;
	}

	@Override
	public int getMaxLevel() {
		return 5;

	}

	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	public void attack(LivingEntity attacker, LivingEntity target, ItemStack itemStack, int level,
			EntityDamageSource source) {
		if (!(source.damageType == "mob" || source.damageType == "player"))
			return;

		target.world.createExplosion(attacker, target.func_226277_ct_(), target.func_226283_e_(0.0625D),
				target.func_226281_cx_(), 3.0F * level, level >= 3 ? Mode.BREAK : Mode.NONE);

	}

}
