package xjon.jum.world.dimension;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import com.google.common.collect.Lists;

import xjon.jum.blocks.UselessMachine;
import xjon.jum.init.UselessBlocks;
import xjon.jum.init.UselessDimensions;
import xjon.jum.util.Log;
import xjon.jum.util.UselessConfiguration;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleporterUseless extends Teleporter {

    private final WorldServer worldServerInstance;
    public static int i = 0;
	
	public TeleporterUseless(WorldServer worldIn) {
		super(worldIn);
		this.worldServerInstance = worldIn;
	}

	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) {		
			for (int x = -5; x <= 5; ++x)
				{ for (int y = -3; y <= 3; ++y)
					{ for(int z = -5; z <= 5; ++z)
						{
							if(!this.worldServerInstance.getBlockState(new BlockPos(entityIn.posX + x, entityIn.posY + y, entityIn.posZ + z)).equals(UselessBlocks.useless_machine.getDefaultState()))
									{
										++i;
									}
						}
					}
				}
				if(i == 847 && entityIn.dimension == UselessConfiguration.uselessDimensionId) {
					for (int x = -1; x <= 1; ++x)
					{ for (int z = -1; z <= 1; ++z)
						{ for (int y = -1; y <= 2; ++y)
							{
								this.worldServerInstance.setBlockToAir(new BlockPos(entityIn.posX + x, entityIn.posY + y, entityIn.posZ + z));
							}
							this.worldServerInstance.setBlockState(new BlockPos(entityIn.posX + x, entityIn.posY - 1, entityIn.posZ + z), UselessBlocks.legitimate_diamond_ore.getDefaultState());
						}
					}
					this.worldServerInstance.setBlockState(new BlockPos(entityIn.posX, entityIn.posY, entityIn.posZ - 1), UselessBlocks.useless_machine.getDefaultState());
					Log.info("Useless Machine spawned at x: " + entityIn.posX + " y: " + (entityIn.posY) + " z: " + (entityIn.posZ - 1));
					this.worldServerInstance.setBlockState(new BlockPos(entityIn.posX, entityIn.posY, entityIn.posZ + 1), Blocks.torch.getDefaultState());
					i = 0;
						}
				else
				{
					if (entityIn.dimension == UselessConfiguration.uselessDimensionId)
					{
						Log.warn("Useless Machine already spawned, not spawning another one");
					}
					i = 0;
				}
			}
	}