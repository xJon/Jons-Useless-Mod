package xjon.jum.blocks;

import java.util.Iterator;
import java.util.Random;

import xjon.jum.init.UselessItems;
import xjon.jum.tileentity.TileEntityUselessChest;
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
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UselessChest extends BlockChest {

	public UselessChest(int chest) 
	{
		super(chest);
		setHardness(1.0F);
		setHarvestLevel("axe", 1);
		this.setHardness(2.5F).setStepSound(this.soundTypeWood);
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
	    public int getComparatorInputOverride(World worldIn, BlockPos pos)
	    {
	        return Container.calcRedstoneFromInventory(this.getLockableContainer(worldIn, pos));
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
	 	
	 	public IBlockState checkForSurroundingChests(World worldIn, BlockPos pos, IBlockState state)
	    {
	        if (worldIn.isRemote)
	        {
	            return state;
	        }
	        else
	        {
	            IBlockState iblockstate1 = worldIn.getBlockState(pos.north());
	            IBlockState iblockstate2 = worldIn.getBlockState(pos.south());
	            IBlockState iblockstate3 = worldIn.getBlockState(pos.west());
	            IBlockState iblockstate4 = worldIn.getBlockState(pos.east());
	            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
	            Block block = iblockstate1.getBlock();
	            Block block1 = iblockstate2.getBlock();
	            Block block2 = iblockstate3.getBlock();
	            Block block3 = iblockstate4.getBlock();

	            if (block != this && block1 != this)
	            {
	                boolean flag = block.isFullBlock();
	                boolean flag1 = block1.isFullBlock();

	                if (block2 == this || block3 == this)
	                {
	                    BlockPos blockpos2 = block2 == this ? pos.west() : pos.east();
	                    IBlockState iblockstate7 = worldIn.getBlockState(blockpos2.north());
	                    IBlockState iblockstate8 = worldIn.getBlockState(blockpos2.south());
	                    enumfacing = EnumFacing.SOUTH;
	                    EnumFacing enumfacing2;

	                    if (block2 == this)
	                    {
	                        enumfacing2 = (EnumFacing)iblockstate3.getValue(FACING);
	                    }
	                    else
	                    {
	                        enumfacing2 = (EnumFacing)iblockstate4.getValue(FACING);
	                    }

	                    if (enumfacing2 == EnumFacing.NORTH)
	                    {
	                        enumfacing = EnumFacing.NORTH;
	                    }

	                    Block block6 = iblockstate7.getBlock();
	                    Block block7 = iblockstate8.getBlock();

	                    if ((flag || block6.isFullBlock()) && !flag1 && !block7.isFullBlock())
	                    {
	                        enumfacing = EnumFacing.SOUTH;
	                    }

	                    if ((flag1 || block7.isFullBlock()) && !flag && !block6.isFullBlock())
	                    {
	                        enumfacing = EnumFacing.NORTH;
	                    }
	                }
	            }
	            else
	            {
	                BlockPos blockpos1 = block == this ? pos.north() : pos.south();
	                IBlockState iblockstate5 = worldIn.getBlockState(blockpos1.west());
	                IBlockState iblockstate6 = worldIn.getBlockState(blockpos1.east());
	                enumfacing = EnumFacing.EAST;
	                EnumFacing enumfacing1;

	                if (block == this)
	                {
	                    enumfacing1 = (EnumFacing)iblockstate1.getValue(FACING);
	                }
	                else
	                {
	                    enumfacing1 = (EnumFacing)iblockstate2.getValue(FACING);
	                }

	                if (enumfacing1 == EnumFacing.WEST)
	                {
	                    enumfacing = EnumFacing.WEST;
	                }

	                Block block4 = iblockstate5.getBlock();
	                Block block5 = iblockstate6.getBlock();

	                if ((block2.isFullBlock() || block4.isFullBlock()) && !block3.isFullBlock() && !block5.isFullBlock())
	                {
	                    enumfacing = EnumFacing.EAST;
	                }

	                if ((block3.isFullBlock() || block5.isFullBlock()) && !block2.isFullBlock() && !block4.isFullBlock())
	                {
	                    enumfacing = EnumFacing.WEST;
	                }
	            }

	            state = state.withProperty(FACING, enumfacing);
	            worldIn.setBlockState(pos, state, 3);
	            return state;
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
