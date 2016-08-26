package xjon.jum.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xjon.jum.entity.projectile.EntityUselessArrow;

public class ItemUselessArrow extends Item {
	
	public ItemUselessArrow()
	{

	}
	
	public EntityUselessArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
	{
		return new EntityUselessArrow(worldIn, shooter);
	}
	
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == ItemUselessArrow.class;
    }
	

}