package net.morimori.ikisugienchantments.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.morimori.ikisugienchantments.handler.EnchantmentHandler;

public class CommonProxy {

	public void setup() {
		MinecraftForge.EVENT_BUS.register(EnchantmentHandler.class);
	}
}
