package net.morimori.ikisugienchantments.handler;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.morimori.ikisugienchantments.enchantment.IEEnchantments;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {

	@SubscribeEvent
	public static void onEnchantmentRegistry(final RegistryEvent.Register<Enchantment> e) {
		IEEnchantments.registerEnchantment(e.getRegistry());
	}
}
