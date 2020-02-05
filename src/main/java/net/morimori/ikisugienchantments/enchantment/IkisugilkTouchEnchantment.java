package net.morimori.ikisugienchantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class IkisugilkTouchEnchantment extends BaseEnchantment {
	public IkisugilkTouchEnchantment(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.DIGGER, slots);
	}

	public int getMinEnchantability(int enchantmentLevel) {
		return 30;
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + 80;
	}

	public boolean canApplyTogether(Enchantment p_77326_1_) {
		return super.canApplyTogether(p_77326_1_) && p_77326_1_ != Enchantments.FORTUNE
				&& p_77326_1_ != Enchantments.SILK_TOUCH;
	}

	public void blockDrop(HarvestDropsEvent e, PlayerEntity target, ItemStack itemStack, int level, Hand hand) {
		e.getDrops().clear();
	}
}
