package xjon.jum.blocks;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import xjon.jum.tileentity.TileEntityUselessChest;

public class UselessChest extends BlockChest {

	public UselessChest() 
	{
		super(Type.BASIC);
		this.setHardness(1.0F);
		this.setHarvestLevel("axe", 1);
		this.setHardness(2.5F);
		this.setSoundType(blockSoundType.WOOD);
	}
	
	@Override
	 public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	        TileEntity tileentity = worldIn.getTileEntity(pos);

	        if (tileentity instanceof IInventory)
	        {
	            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
	            worldIn.updateComparatorOutputLevel(pos, this);
	        }

	        super.breakBlock(worldIn, pos, state);
	    }
	 
	@Override
	 public TileEntity createNewTileEntity(World worldIn, int meta)
	    {
	        return new TileEntityUselessChest();
	    }
	
	@Override
	 public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	    {
		 EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor_double(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3).getOpposite();
			state = state.withProperty(FACING, enumfacing);
			worldIn.setBlockState(pos, state, 3);

			TileEntity tileentity = worldIn.getTileEntity(pos);

	    }
	
	@Override
	 public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        
    }
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return true;
    }
	 
	 private boolean isOcelotSittingOnChest(World worldIn, BlockPos pos)
	    {
	        Iterator iterator = worldIn.getEntitiesWithinAABB(EntityOcelot.class, new AxisAlignedBB((double)pos.getX(), (double)(pos.getY() + 1), (double)pos.getZ(), (double)(pos.getX() + 1), (double)(pos.getY() + 2), (double)(pos.getZ() + 1))).iterator();
	        EntityOcelot entityocelot;

	        do
	        {
	            if (!iterator.hasNext())
	            {
	                return false;
	            }

	            Entity entity = (Entity)iterator.next();
	            entityocelot = (EntityOcelot)entity;
	        }
	        while (!entityocelot.isSitting());

	        return true;
	    }

	 	@Override
	    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
	    {
	        TileEntity tileentity = worldIn.getTileEntity(pos);

	        if (!(tileentity instanceof TileEntityUselessChest))
	        {
	            return null;
	        }
	        else
	        {
	            Object object = (TileEntityUselessChest)tileentity;

	            if (this.isBlocked(worldIn, pos))
	            {
	                return null;
	            }
	            else
	            {
	                Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();

	                while (iterator.hasNext())
	                {
	                    EnumFacing enumfacing = (EnumFacing)iterator.next();
	                    BlockPos blockpos1 = pos.offset(enumfacing);
	                    Block block = worldIn.getBlockState(blockpos1).getBlock();

	                    if (block == this)
	                    {
	                        if (this.isBlocked(worldIn, blockpos1))
	                        {
	                            return null;
	                        }

	                        TileEntity tileentity1 = worldIn.getTileEntity(blockpos1);
	                    }
	                }

	                return (ILockableContainer)object;
	            }
	        }
	    }
	 		    
	    private boolean isBlocked(World worldIn, BlockPos pos)
	    {
	        return this.isBelowSolidBlock(worldIn, pos) || this.isOcelotSittingOnChest(worldIn, pos);
	    }
	    
	    private boolean isBelowSolidBlock(World worldIn, BlockPos pos)
	    {
	        return worldIn.isSideSolid(pos.up(), EnumFacing.DOWN, false);
	    }
}
