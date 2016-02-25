package xjon.jum.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.init.UselessAchievements;
import xjon.jum.init.UselessBlocks;
import xjon.jum.init.UselessDimensions;
import xjon.jum.util.Log;
import xjon.jum.util.UselessConfiguration;
import xjon.jum.world.dimension.TeleporterUseless;


public class UselessMachine extends Block {
		
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	private boolean flag; 
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
						flag = true;
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, UselessDimensions.dimensionId, new TeleporterUseless(playerMP.mcServer.worldServerForDimension(UselessDimensions.dimensionId)));
						playerIn.setPositionAndUpdate(playerIn.posX, playerIn.posY + 1, playerIn.posZ);
						for (int x = -4; x <= 4; ++x)
						{ for (int y = -2; y <= 2; ++y)
							{ for (int z = -4; z <= 4; ++z)
								{
									if(playerIn.worldObj.getBlockState(new BlockPos(playerIn.posX + x, playerIn.posY + y, playerIn.posZ + z)).equals(UselessBlocks.useless_machine.getDefaultState()))
									{
										playerIn.setPositionAndUpdate(playerIn.posX + x, playerIn.posY + y + 1, playerIn.posZ + z + 1.5);
										break;
									}
								}
							}
						}
					} else if (flag == true) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, new TeleporterUseless(playerMP.mcServer.worldServerForDimension(0)));
						playerIn.setPositionAndUpdate(x1, y1 + 1, z1);	
						flag = false;
					}
					  else
					  {
						  playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, new TeleporterUseless(playerMP.mcServer.worldServerForDimension(0)));
						  playerIn.setPositionAndUpdate(worldIn.getSpawnPoint().getX(), worldIn.getSpawnPoint().getY(), worldIn.getSpawnPoint().getZ());
						  for (int y = playerIn.getPosition().getY(); y < 255; ++y)
						  {
							  if (worldIn.getBlockState(new BlockPos(playerIn.posX, y, playerIn.posZ)).equals(Blocks.air) && worldIn.getBlockState(new BlockPos(playerIn.posX, y + 1, playerIn.posZ)).equals(Blocks.air))
							  {
								  playerIn.setPositionAndUpdate(playerIn.posX, y + 2, playerIn.posZ);
								  break;
							  }
						  }
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