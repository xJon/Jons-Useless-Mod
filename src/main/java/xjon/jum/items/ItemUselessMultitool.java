package xjon.jum.items;

import java.util.List;
import java.util.Set;

import xjon.jum.init.UselessItems;
import xjon.jum.util.UselessConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Sets;


public class ItemUselessMultitool extends ItemTool{
 	
	private static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(Block.blockRegistry);
	protected Item.ToolMaterial theToolMaterial;
	
	
	public ItemUselessMultitool(ToolMaterial material) 
	{
		super(5, material, blocksEffectiveAgainst);
		this.setMaxDamage(3141);
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		if(!UselessConfiguration.isUseless)
		{
			if (block == Blocks.bedrock)
			{
				return false;
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		EntityPlayer player = (EntityPlayer) entityIn;
		ItemStack equipped = player.getCurrentEquippedItem();
		if (equipped == stack)
		{
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 20, 0));
		}
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
	
	 public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
	        if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
	        {
	            return false;
	        }
	        else
	        {
	            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
	            if (hook != 0) return hook > 0;

	            IBlockState iblockstate = worldIn.getBlockState(pos);
	            Block block = iblockstate.getBlock();

	            if (side != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
	            {
	                if (block == Blocks.grass)
	                {
	                    return this.useHoe(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
	                }

	                if (block == Blocks.dirt)
	                {
	                    switch (SwitchDirtType.TYPE_LOOKUP[((BlockDirt.DirtType)iblockstate.getValue(BlockDirt.VARIANT)).ordinal()])
	                    {
	                        case 1:
	                            return this.useHoe(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
	                        case 2:
	                            return this.useHoe(stack, playerIn, worldIn, pos, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
	                    }
	                }
	            }

	            return false;
	        }
	    }

	    protected boolean useHoe(ItemStack stack, EntityPlayer player, World worldIn, BlockPos target, IBlockState newState)
	    {
	        worldIn.playSoundEffect((double)((float)target.getX() + 0.5F), (double)((float)target.getY() + 0.5F), (double)((float)target.getZ() + 0.5F), newState.getBlock().stepSound.getStepSound(), (newState.getBlock().stepSound.getVolume() + 1.0F) / 2.0F, newState.getBlock().stepSound.getFrequency() * 0.8F);

	        if (worldIn.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	            worldIn.setBlockState(target, newState);
	            stack.damageItem(1, player);
	            return true;
	        }
	    }

	    static final class SwitchDirtType
	        {
	            static final int[] TYPE_LOOKUP = new int[BlockDirt.DirtType.values().length];
	            private static final String __OBFID = "CL_00002179";

	            static
	            {
	                try
	                {
	                    TYPE_LOOKUP[BlockDirt.DirtType.DIRT.ordinal()] = 1;
	                }
	                catch (NoSuchFieldError var2)
	                {
	                    ;
	                }

	                try
	                {
	                    TYPE_LOOKUP[BlockDirt.DirtType.COARSE_DIRT.ordinal()] = 2;
	                }
	                catch (NoSuchFieldError var1)
	                {
	                    ;
	                }
	            }
	        }
	    
	    @Override
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced)
		{
			stack.setStackDisplayName(EnumChatFormatting.AQUA + "Useless Multi-Tool");
	    	toolTip.add("Can mine pretty much anything");
		}

}
