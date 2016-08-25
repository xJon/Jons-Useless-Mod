package xjon.jum.entity.projectile;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
