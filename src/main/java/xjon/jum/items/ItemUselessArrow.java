package xjon.jum.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xjon.jum.entity.projectile.EntityUselessArrow;

public class ItemUselessArrow extends ItemArrow {
	
	public ItemUselessArrow() { }
	
	@Override
    public EntityUselessArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
		EntityUselessArrow entityuselessarrow = new EntityUselessArrow(worldIn);
        return entityuselessarrow;
    }

}
