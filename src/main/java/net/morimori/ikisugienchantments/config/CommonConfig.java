package net.morimori.ikisugienchantments.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.morimori.ikisugienchantments.IkisugiEnchant;

public class CommonConfig {
	public static ConfigValue<Boolean> isAllEnchantmentEnable;

	public static void init() {
		Pair<ConfigLoder, ForgeConfigSpec> common_config = new ForgeConfigSpec.Builder().configure(ConfigLoder::new);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, common_config.getRight());

	}

	static class ConfigLoder {
		public ConfigLoder(ForgeConfigSpec.Builder builder) {
			IkisugiEnchant.LOGGER.info("Config Loading...");
			builder.push("Enchantments");
			builder.comment("All Common Setting");
			isAllEnchantmentEnable = builder.define("Enable", true);
			builder.pop();

		}
	}

}
