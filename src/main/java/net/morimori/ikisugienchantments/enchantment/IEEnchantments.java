package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effects;
import net.minecraftforge.registries.IForgeRegistry;
import net.morimori.ikisugienchantments.IkisugiEnchant;

public class IEEnchantments {
	public static Enchantment SLOWDOWN = new AttackPotionEnchantment(Enchantment.Rarity.COMMON, Effects.SLOWNESS, 1, 11,
			20, EquipmentSlotType.MAINHAND);

	public static Enchantment GLOW = new AttackPotionEnchantment(Enchantment.Rarity.COMMON, Effects.GLOWING, 1,
			11, 20, EquipmentSlotType.MAINHAND);

	public static Enchantment TOXICITY = new AttackPotionEnchantment(Enchantment.Rarity.UNCOMMON, Effects.POISON, 5,
			8, 20, EquipmentSlotType.MAINHAND);

	public static Enchantment WEAKNESS = new AttackPotionEnchantment(Enchantment.Rarity.UNCOMMON, Effects.WITHER, 5,
			8, 20, EquipmentSlotType.MAINHAND);

	public static Enchantment WEAKENING = new AttackPotionEnchantment(Enchantment.Rarity.RARE, Effects.WEAKNESS, 2, 10,
			25, EquipmentSlotType.MAINHAND);

	public static Enchantment FLOATING = new AttackPotionEnchantment(Enchantment.Rarity.RARE, Effects.LEVITATION, 20,
			15, 50, EquipmentSlotType.MAINHAND);

	public static Enchantment TREATMENT = new TreatmentEnchantment(Enchantment.Rarity.VERY_RARE,
			EquipmentSlotType.MAINHAND);

	public static Enchantment ILLAGER_KILLER = new BaneCreatureEnchantment(Enchantment.Rarity.UNCOMMON,
			CreatureAttribute.ILLAGER, EquipmentSlotType.MAINHAND);

	public static Enchantment SHIPMENT = new ShipmentEnchantment(Enchantment.Rarity.UNCOMMON,
			EquipmentSlotType.MAINHAND);

	public static Enchantment DISARMAMENT = new DisarmamentEnchantment(Enchantment.Rarity.UNCOMMON,
			EquipmentSlotType.MAINHAND);

	public static Enchantment BENEFICIAL_EFFECT_CLEAR = new BeneficialEffectClearEnchantment(
			Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND);

	//cures
	public static Enchantment DULLNESS = new DullnessEnchantment(Enchantment.Rarity.UNCOMMON,
			EquipmentSlotType.MAINHAND);

	public static Enchantment NO_DAMAGE = new NoDamageEnchantment(Enchantment.Rarity.VERY_RARE,
			EquipmentSlotType.MAINHAND);

	public static Enchantment FIRE_SUPPRESSION = new FireSuppressionEnchantment(Enchantment.Rarity.COMMON,
			EquipmentSlotType.MAINHAND);

	public static Enchantment BAD_EFFECT_CLEAR = new BadEffectClearEnchantment(Enchantment.Rarity.VERY_RARE,
			EquipmentSlotType.MAINHAND);


	public static void registerEnchantment(IForgeRegistry<Enchantment> r) {
		r.register(SLOWDOWN.setRegistryName(IkisugiEnchant.MODID, "slowdown"));
		r.register(GLOW.setRegistryName(IkisugiEnchant.MODID, "glow"));
		r.register(TOXICITY.setRegistryName(IkisugiEnchant.MODID, "toxicity"));
		r.register(WEAKNESS.setRegistryName(IkisugiEnchant.MODID, "weakness"));
		r.register(WEAKENING.setRegistryName(IkisugiEnchant.MODID, "weakening"));
		r.register(FLOATING.setRegistryName(IkisugiEnchant.MODID, "floating"));
		r.register(TREATMENT.setRegistryName(IkisugiEnchant.MODID, "treatment"));
		r.register(ILLAGER_KILLER.setRegistryName(IkisugiEnchant.MODID, "illager_killer"));
		r.register(SHIPMENT.setRegistryName(IkisugiEnchant.MODID, "shipment"));
		r.register(DISARMAMENT.setRegistryName(IkisugiEnchant.MODID, "disarmament"));
		r.register(DULLNESS.setRegistryName(IkisugiEnchant.MODID, "dullness"));
		r.register(NO_DAMAGE.setRegistryName(IkisugiEnchant.MODID, "no_damage"));
		r.register(FIRE_SUPPRESSION.setRegistryName(IkisugiEnchant.MODID, "fire_suppression"));
		r.register(BAD_EFFECT_CLEAR.setRegistryName(IkisugiEnchant.MODID, "bad_effect_clear"));
		r.register(BENEFICIAL_EFFECT_CLEAR.setRegistryName(IkisugiEnchant.MODID, "beneficial_effect_clear"));

	}

}
