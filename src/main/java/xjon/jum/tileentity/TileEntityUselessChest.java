package xjon.jum.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.blocks.UselessChest;



public class TileEntityUselessChest extends TileEntityLockable implements ITickable, IInventory {
	
	private ItemStack[] chestContents = new ItemStack[45];
    public boolean adjacentChestChecked;
    public TileEntityUselessChest adjacentChestZNeg;
    public TileEntityUselessChest adjacentChestXPos;
    public TileEntityUselessChest adjacentChestXNeg;
    public TileEntityUselessChest adjacentChestZPos;
    public float lidAngle;
    public float prevLidAngle;
    public int numPlayersUsing;
    private int ticksSinceSync;
    private int cachedChestType;
    private String customName;

    public TileEntityUselessChest()
    {
        this.cachedChestType = -1;
    }

    @SideOnly(Side.CLIENT)
    public TileEntityUselessChest(int chestType)
    {
        this.cachedChestType = chestType;
    }

    public int getSizeInventory()
    {
        return chestContents.length;
    }

    public ItemStack getStackInSlot(int index)
    {
        return this.chestContents[index];
    }

    public ItemStack decrStackSize(int index, int count)
    {
        if (this.chestContents[index] != null)
        {
            if (this.chestContents[index].stackSize <= count)
            {
                ItemStack itemstack1 = this.chestContents[index];
                this.chestContents[index] = null;
                this.markDirty();
                return itemstack1;
            }
            else
            {
                ItemStack itemstack = this.chestContents[index].splitStack(count);

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

    public void setInventorySlotContents(int index, ItemStack stack)
    {
        this.chestContents[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    public String getName()
    {
        return this.hasCustomName() ? this.customName : "Useless Chest";
    }

    public boolean hasCustomName()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setCustomName(String name)
    {
        this.customName = name;
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.chestContents = new ItemStack[this.getSizeInventory()];

        if (compound.hasKey("CustomName", 8))
        {
            this.customName = compound.getString("CustomName");
        }

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot") & 255;

            if (j >= 0 && j < this.chestContents.length)
            {
                this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
    	super.writeToNBT(compound);

        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.customName);
        }

        return compound;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void updateContainingBlockInfo()
    {
        super.updateContainingBlockInfo();
        this.adjacentChestChecked = false;
    }

    @SuppressWarnings("incomplete-switch")
    private void func_174910_a(TileEntityUselessChest chestTe, EnumFacing side)
    {
        if (chestTe.isInvalid())
        {
            this.adjacentChestChecked = false;
        }
        else if (this.adjacentChestChecked)
        {
            switch (side)
            {
                case NORTH:

                    if (this.adjacentChestZNeg != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;
                case SOUTH:

                    if (this.adjacentChestZPos != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;
                case EAST:

                    if (this.adjacentChestXPos != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }

                    break;
                case WEST:

                    if (this.adjacentChestXNeg != chestTe)
                    {
                        this.adjacentChestChecked = false;
                    }
            }
        }
    }

    public void update()
    {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        ++this.ticksSinceSync;

        if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + i + j + k) % 200 == 0)
        {
            this.numPlayersUsing = 0;
            float f = 5.0F;

            this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double) ((float) i - f), (double) ((float) j - f), (double) ((float) k - f), (double) ((float) (i + 1) + f), (double) ((float) (j + 1) + f), (double) ((float) (k + 1) + f))).stream().filter(entityplayer -> entityplayer.openContainer instanceof ContainerChest).forEach(entityplayer -> {
                IInventory iinventory = ((ContainerChest) entityplayer.openContainer).getLowerChestInventory();

                if (iinventory == this || iinventory instanceof InventoryLargeChest && ((InventoryLargeChest) iinventory).isPartOfLargeChest(this)) {
                    ++this.numPlayersUsing;
                }
            });
        }

        this.prevLidAngle = this.lidAngle;
        float f1 = 0.1F;

        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null)
        {
            double d1 = (double)i + 0.5D;
            double d2 = (double)k + 0.5D;

            if (this.adjacentChestZPos != null)
            {
                d2 += 0.5D;
            }

            if (this.adjacentChestXPos != null)
            {
                d1 += 0.5D;
            }

            this.worldObj.playSound(null, d1, (double)j + 0.5D, d2, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
        {
            float f2 = this.lidAngle;

            if (this.numPlayersUsing > 0)
            {
                this.lidAngle += f1;
            }
            else
            {
                this.lidAngle -= f1;
            }

            if (this.lidAngle > 1.0F)
            {
                this.lidAngle = 1.0F;
            }

            float f3 = 0.5F;

            if (this.lidAngle < f3 && f2 >= f3 && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null)
            {
                double d3 = (double)i + 0.5D;
                double d0 = (double)k + 0.5D;

                if (this.adjacentChestZPos != null)
                {
                    d0 += 0.5D;
                }

                if (this.adjacentChestXPos != null)
                {
                    d3 += 0.5D;
                }

                this.worldObj.playSound(null, d3, (double)j + 0.5D, d0, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.lidAngle < 0.0F)
            {
                this.lidAngle = 0.0F;
            }
        }
    }

    public boolean receiveClientEvent(int id, int type)
    {
        if (id == 1)
        {
            this.numPlayersUsing = type;
            return true;
        }
        else
        {
            return super.receiveClientEvent(id, type);
        }
    }

    public void openInventory(EntityPlayer player)
    {
        if (!player.isSpectator())
        {
            if (this.numPlayersUsing < 0)
            {
                this.numPlayersUsing = 0;
            }

            ++this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyNeighborsOfStateChange(this.pos, this.getBlockType());
            this.worldObj.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType());
        }
    }

    public void closeInventory(EntityPlayer player)
    {
        if (!player.isSpectator() && this.getBlockType() instanceof UselessChest)
        {
            --this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyNeighborsOfStateChange(this.pos, this.getBlockType());
            this.worldObj.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType());
        }
    }

    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return true;
    }
    public void invalidate()
    {
        super.invalidate();
        this.updateContainingBlockInfo();
    }

    public String getGuiID()
    {
        return "minecraft:chest";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerChest(playerInventory, this, playerIn);
    }

    public int getField(int id)
    {
        return 0;
    }

    public void setField(int id, int value)
    {
    }

    public int getFieldCount()
    {
        return 0;
    }

    public void clear()
    {
        for (int i = 0; i < this.chestContents.length; ++i)
        {
            this.chestContents[i] = null;
        }
    }

    public net.minecraftforge.items.IItemHandler getSingleChestHandler()
    {
        return super.getCapability(net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
    }
}
