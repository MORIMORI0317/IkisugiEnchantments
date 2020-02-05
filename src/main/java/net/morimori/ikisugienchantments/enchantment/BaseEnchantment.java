package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class BaseEnchantment extends Enchantment {

	protected BaseEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
		super(rarityIn, typeIn, slots);

	}

	public void onLivingHurtEvent(LivingHurtEvent e) {

	}

	public void attack(LivingEntity attacker, LivingEntity target, ItemStack itemStack, int level,
			EntityDamageSource source) {

	}

	public void handTick(LivingEntity target, ItemStack itemStack, int level, Hand hand) {

	}

	public void blockDrop(HarvestDropsEvent e, PlayerEntity target, ItemStack itemStack, int level, Hand hand) {

	}

}
