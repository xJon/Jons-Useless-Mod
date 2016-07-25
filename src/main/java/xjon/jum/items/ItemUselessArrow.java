package xjon.jum.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xjon.jum.entity.projectile.EntityUselessArrow;

public class ItemUselessArrow extends ItemArrow {
	
	public ItemUselessArrow()
	{
		super();
	}
	
	@Override
	public EntityUselessArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
	{
		return new EntityUselessArrow(worldIn, shooter);
	}
	

}
