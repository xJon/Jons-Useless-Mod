package xjon.jum.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemUselessArrow extends Item {
	
	public ItemUselessArrow()
	{
		
	}
	
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant > 0 && this.getClass() == ItemUselessArrow.class;
    }

}
