package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class AttackPotionEnchantment extends BaseEnchantment {
	private Effect Effect;
	private int Enmin;
	private int Enmcos;
	private int Enspan;

	protected AttackPotionEnchantment(Enchantment.Rarity rarityIn, Effect effect, int enmin, int encos, int enspan,
			EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.WEAPON, slots);
		this.Effect = effect;
		this.Enmin = enmin;
		this.Enmcos = encos;
		this.Enspan = enspan;

	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return Enmin + (enchantmentLevel - 1) * Enmcos;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + Enspan;
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	@Override
	public boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof AttackPotionEnchantment);
	}

	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		if (target instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) target;
			livingentity
					.addPotionEffect(new EffectInstance(Effect, user.getRNG().nextInt(300 * level) + 100, level - 1));
		}
	}
}
