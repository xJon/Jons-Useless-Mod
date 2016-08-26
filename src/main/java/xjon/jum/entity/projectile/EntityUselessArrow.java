package xjon.jum.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import xjon.jum.init.UselessItems;
import xjon.jum.util.UselessConfiguration;

public class EntityUselessArrow extends EntityArrow implements IProjectile {

    private double damage = 5.0D;
    
    public EntityUselessArrow(World worldIn)
    {
    	super(worldIn);
    }

    public EntityUselessArrow(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    public EntityUselessArrow(World worldIn, EntityLivingBase shooter)
    {
    	super(worldIn, shooter);
    }
    
    
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
		if (this.worldObj.isRemote && !this.inGround)
		{
			this.worldObj.spawnParticle(EnumParticleTypes.END_ROD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}
    }

    @Override
    public void setDamage(double damage)
    {
    	if (!UselessConfiguration.isUseless)
    	{
    		this.damage = damage;
    	}
    	else
    	{
    		this.damage = damage - 4.0D;
    	}
    }

    @Override
    public double getDamage()
    {
        return this.damage;
    }

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(UselessItems.useless_arrow);
	}
	
}