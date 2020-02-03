package net.morimori.ikisugienchantments.handler;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.morimori.ikisugienchantments.enchantment.BaseEnchantment;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnchantmentHandler {
	@SubscribeEvent
	public static void onAttack(LivingHurtEvent e) {
		if (!(e.getSource() instanceof EntityDamageSource))
			return;

		EntityDamageSource ds = (EntityDamageSource) e.getSource();

		if (!(ds.getTrueSource() instanceof LivingEntity))
			return;

		LivingEntity en = (LivingEntity) ds.getTrueSource();

		if (en.getHeldItemMainhand().getItem() instanceof EnchantedBookItem)
			return;
		try {

			for (Enchantment ec : EnchantmentHelper.getEnchantments(en.getHeldItemMainhand()).keySet()) {
				if (ec instanceof BaseEnchantment) {

					((BaseEnchantment) ec).attack(en, e.getEntityLiving(), en.getHeldItemMainhand(),
							EnchantmentHelper.getEnchantments(en.getHeldItemMainhand()).get(ec), ds);

				}
			}

		} catch (Exception e2) {

		}
	}

	@SubscribeEvent
	public static void onEntityTick(LivingUpdateEvent e) {
		LivingEntity en = e.getEntityLiving();

		if (!(en.getHeldItemMainhand().getItem() instanceof EnchantedBookItem)) {

			for (Enchantment ec : EnchantmentHelper.getEnchantments(en.getHeldItemMainhand()).keySet()) {
				if (ec instanceof BaseEnchantment) {
					((BaseEnchantment) ec).handTick(en, en.getHeldItemMainhand(),
							EnchantmentHelper.getEnchantments(en.getHeldItemMainhand()).get(ec), Hand.MAIN_HAND);

				}
			}
		}

		if (!(en.getHeldItemOffhand().getItem() instanceof EnchantedBookItem)) {

			for (Enchantment ec : EnchantmentHelper.getEnchantments(en.getHeldItemOffhand()).keySet()) {
				if (ec instanceof BaseEnchantment) {
					((BaseEnchantment) ec).handTick(en, en.getHeldItemOffhand(),
							EnchantmentHelper.getEnchantments(en.getHeldItemOffhand()).get(ec), Hand.OFF_HAND);

				}
			}
		}

	}
}
