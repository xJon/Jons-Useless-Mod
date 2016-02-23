package xjon.jum.tileentity;

import java.util.Iterator;
import java.util.List;

import xjon.jum.util.UselessConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import xjon.jum.blocks.UselessChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityUselessChest extends TileEntityChest {
	
	private String UselessChest;
	private ItemStack[] chestContents = new ItemStack[45];
	private int cachedChestType;
	public boolean adjacentChestChecked;
	private int ticksSinceSync;
	
    public TileEntityUselessChest adjacentChestZNeg;
    public TileEntityUselessChest adjacentChestXPos;
    public TileEntityUselessChest adjacentChestXNeg;
    public TileEntityUselessChest adjacentChestZPos;
    
    public TileEntityUselessChest()
	{
		this.cachedChestType = 0;
	}
    
	@SideOnly(Side.CLIENT)
	public TileEntityUselessChest(int cachedChestType)
	{
		this.cachedChestType = cachedChestType;
	}

	@Override
    public String getName()
    {
        return this.hasCustomName() ? this.UselessChest : "Useless Chest";
    }
    
	@Override
    public boolean hasCustomName()
    {
        return this.UselessChest != null && this.UselessChest.length() > 0;
    }

	@Override
    public void setCustomName(String name)
    {
        this.UselessChest = name;
    }
    
	@Override
    public int getSizeInventory()
    {
        return this.chestContents.length;
    }
    
	@Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.chestContents = new ItemStack[this.getSizeInventory()];

        if (compound.hasKey("Useless Chest", 8))
        {
            this.UselessChest = compound.getString("Useless Chest");
        }

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.chestContents.length)
            {
                this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }
	
	@Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.chestContents.length; ++i)
        {
            if (this.chestContents[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.chestContents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (this.hasCustomName())
        {
            compound.setString("Useless Chest", this.UselessChest);
        }
    }
	
	@Override
    public void update()
    {
    	int i = this.pos.getX();
		int j = this.pos.getY();
		int k = this.pos.getZ();
		++this.ticksSinceSync;
		float f;

		if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + i + j + k) % 200 == 0)
		{
			this.numPlayersUsing = 0;
			f = 5.0F;
			List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(i - f, j - f, k - f, i + 1 + f, j + 1 + f, k + 1 + f));
			Iterator iterator = list.iterator();

			while (iterator.hasNext())
			{
				EntityPlayer entityplayer = (EntityPlayer) iterator.next();

				if (entityplayer.openContainer instanceof ContainerChest)
				{
					IInventory iinventory = ((ContainerChest) entityplayer.openContainer).getLowerChestInventory();
					
					if (iinventory == this || iinventory instanceof InventoryLargeChest && ((InventoryLargeChest) iinventory).isPartOfLargeChest(this))
					{
						++this.numPlayersUsing;
					}
				}
			}
		}

		this.prevLidAngle = this.lidAngle;
		f = 0.1F;
		double d2;

		if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F)
		{
			double d1 = i + 0.5D;
			d2 = k + 0.5D;

			this.worldObj.playSoundEffect(d1, j + 0.5D, d2, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}

		if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
		{
			float f1 = this.lidAngle;

			if (this.numPlayersUsing > 0)
			{
				this.lidAngle += f;
			}
			else
			{
				this.lidAngle -= f;
			}

			if (this.lidAngle > 1.0F)
			{
				this.lidAngle = 1.0F;
			}

			float f2 = 0.5F;

			if (this.lidAngle < f2 && f1 >= f2)
			{
				d2 = i + 0.5D;
				double d0 = k + 0.5D;

				this.worldObj.playSoundEffect(d2, j + 0.5D, d0, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if (this.lidAngle < 0.0F)
			{
				this.lidAngle = 0.0F;
			}
		}
    }
        
	@Override
    public int getChestType()
    {
        return this.cachedChestType;
    }
    
	@Override
	public String getGuiID()
	{
		return "minecraft:chest";
	}

	@Override
	public void checkForAdjacentChests()
    {
        /*this.adjacentChestChecked = true;
		if (!this.adjacentChestChecked)
        {
            this.adjacentChestChecked = true;
            this.adjacentChestXNeg = this.func_174911_a(EnumFacing.WEST);
            this.adjacentChestXPos = this.func_174911_a(EnumFacing.EAST);
            this.adjacentChestZNeg = this.func_174911_a(EnumFacing.NORTH);
            this.adjacentChestZPos = this.func_174911_a(EnumFacing.SOUTH);
        }*/
    }
	
	/*@Override
	protected TileEntityUselessChest func_174911_a(EnumFacing p_174911_1_)
    {
        BlockPos blockpos = this.pos.offset(p_174911_1_);

        if (this.func_174912_b(blockpos))
        {
            TileEntity tileentity = this.worldObj.getTileEntity(blockpos);

            if (tileentity instanceof TileEntityChest)
            {
                TileEntityUselessChest tileentityuselesschest = (TileEntityUselessChest)tileentity;
                tileentityuselesschest.func_174910_a(this, p_174911_1_.getOpposite());
                return tileentityuselesschest;
            }
        }
        return null;
    }*/
        
        private boolean func_174912_b(BlockPos p_174912_1_)
        {
            if (this.worldObj == null)
            {
                return false;
            }
            else
            {
                Block block = this.worldObj.getBlockState(p_174912_1_).getBlock();
                return block instanceof UselessChest && ((UselessChest)block).chestType == this.getChestType();
            }
        }
        
        private void func_174910_a(TileEntityUselessChest p_174910_1_, EnumFacing p_174910_2_)
        {
            if (p_174910_1_.isInvalid())
            {
                this.adjacentChestChecked = false;
            }
            else if (this.adjacentChestChecked)
            {
                switch (TileEntityUselessChest.SwitchEnumFacing.field_177366_a[p_174910_2_.ordinal()])
                {
                    case 1:
                        if (this.adjacentChestZNeg != p_174910_1_)
                        {
                            this.adjacentChestChecked = false;
                        }

                        break;
                    case 2:
                        if (this.adjacentChestZPos != p_174910_1_)
                        {
                            this.adjacentChestChecked = false;
                        }

                        break;
                    case 3:
                        if (this.adjacentChestXPos != p_174910_1_)
                        {
                            this.adjacentChestChecked = false;
                        }

                        break;
                    case 4:
                        if (this.adjacentChestXNeg != p_174910_1_)
                        {
                            this.adjacentChestChecked = false;
                        }
                }
            }
        }
    
    static final class SwitchEnumFacing
    {
        static final int[] field_177366_a = new int[EnumFacing.values().length];
        static
        {
            try
            {
                field_177366_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_177366_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_177366_a[EnumFacing.EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_177366_a[EnumFacing.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
    
    @Override
    public ItemStack getStackInSlot(int index)
    {
        return this.chestContents[index];
    }
    
    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if (this.chestContents[index] != null)
        {
            ItemStack itemstack;

            if (this.chestContents[index].stackSize <= count)
            {
                itemstack = this.chestContents[index];
                this.chestContents[index] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.chestContents[index].splitStack(count);

                if (this.chestContents[index].stackSize == 0)
                {
                    this.chestContents[index] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }
    
    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        if (this.chestContents[index] != null)
        {
            ItemStack itemstack = this.chestContents[index];
            this.chestContents[index] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }
    
    public void setChestType(int chestType)
	{
		this.cachedChestType = chestType;
	}
    
    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        this.chestContents[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }
}
