package net.morimori.ikisugienchantments.handler;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.morimori.ikisugienchantments.IkisugiEnchant;
import net.morimori.ikisugienchantments.enchantment.IEEnchantments;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
	@SubscribeEvent
	public static void onEnchantmentRegistry(RegistryEvent.Register<Enchantment> e) {
		IkisugiEnchant.LOGGER.info("Enchantment Registering...");
		IEEnchantments.registerEnchantment(e.getRegistry());
	}
}