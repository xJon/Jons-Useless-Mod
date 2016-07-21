package xjon.jum.world.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import xjon.jum.init.UselessBlocks;
import xjon.jum.init.UselessDimensions;
import xjon.jum.util.Log;

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
				if(i == 847 && entityIn.dimension == UselessDimensions.dimensionId) {
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
					this.worldServerInstance.setBlockState(new BlockPos(entityIn.posX, entityIn.posY, entityIn.posZ + 1), Blocks.TORCH.getDefaultState());
					i = 0;
						}
				else
				{
					if (entityIn.dimension == UselessDimensions.dimensionId)
					{
						Log.warn("Useless Machine already spawned, not spawning another one");
					}
					i = 0;
				}
			}
	}