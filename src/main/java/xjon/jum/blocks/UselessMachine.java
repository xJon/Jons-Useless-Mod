package xjon.jum.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.client.gui.GuiUselessMachine;
import xjon.jum.init.UselessAchievements;
import xjon.jum.init.UselessDimensions;
import xjon.jum.tileentity.TileEntityUselessChest;
import xjon.jum.util.Log;
import xjon.jum.util.UselessConfiguration;
import xjon.jum.world.dimension.TeleporterUseless;

public class UselessMachine extends Block {
		
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
		
	public static int x1, y1, z1;
	
	public  UselessMachine(Material material) {
		super(material);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", 2);
		this.setLightLevel(0.4F);
		this.setStepSound(this.soundTypeMetal);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
		
	}
	
	@Override
	public boolean isFullCube()
	{
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!UselessConfiguration.isUseless)		
		{
			if(playerIn instanceof EntityPlayerMP)
			{
				EntityPlayerMP playerMP = (EntityPlayerMP) playerIn;
					if (worldIn.provider.getDimensionId() != UselessDimensions.dimensionId) {
						x1 = playerIn.getPosition().getX();
						y1 = playerIn.getPosition().getY() + 1;
						z1 = playerIn.getPosition().getZ();
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, UselessDimensions.dimensionId, new TeleporterUseless(playerMP.mcServer.worldServerForDimension(UselessDimensions.dimensionId)));
						playerIn.setPositionAndUpdate(playerIn.getPosition().getX(), playerIn.getPosition().getY() + 1, playerIn.getPosition().getZ() + 1);	
					} else if (x1 != 0 && y1 != 0 && z1 != 0) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, new TeleporterUseless(playerMP.mcServer.worldServerForDimension(0)));
						//playerIn.setPositionAndUpdate(x1, y1 + 1, z1);
					}
					  else if (x1 == 0 && y1 == 0 && z1 == 0)
					  {
						  playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, new TeleporterUseless(playerMP.mcServer.worldServerForDimension(0)));
						  playerIn.setPositionAndUpdate(worldIn.getSpawnPoint().getX(), worldIn.getSpawnPoint().getY(), worldIn.getSpawnPoint().getZ());
						  playerIn.setPositionAndUpdate(playerIn.posX, worldIn.getTopSolidOrLiquidBlock(new BlockPos(playerIn.posX, playerIn.posY, playerIn.posZ)).getY() + 1, playerIn.posZ);
						  Log.error("No coordinates were found, teleporting player back to spawn point");
					  }
			}
		}
		else
		{
			worldIn.playSoundToNearExcept(playerIn, "jum:nope", 1.0F, 1.0F);
			playerIn.playSound("jum:nope", 1.0F, 1.0F);
		}
		return true;
}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {

		return super.createTileEntity(world, state);
	}
	
	 public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	    {
	        this.setDefaultFacing(worldIn, pos, state);
	    }
	
	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(pos.north()).getBlock();
            Block block1 = worldIn.getBlockState(pos.south()).getBlock();
            Block block2 = worldIn.getBlockState(pos.west()).getBlock();
            Block block3 = worldIn.getBlockState(pos.east()).getBlock();
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }
            else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }
	
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing()), 2);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityFurnace)
            {
                ((TileEntityFurnace)tileentity).setCustomInventoryName(stack.getDisplayName());
            }
        }
        ((EntityPlayer)placer).addStat(UselessAchievements.uselessMachine, 1);
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
    
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
    
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }

    @SideOnly(Side.CLIENT)
    static final class SwitchEnumFacing
        {
            static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];
            static
            {
                try
                {
                    FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 1;
                }
                catch (NoSuchFieldError var4)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 2;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 3;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 4;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
            }
        }
}