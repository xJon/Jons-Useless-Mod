package xjon.jum.world.biome;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.entity.mob.EntityUselessDave;


public class BiomeGenUseless extends BiomeGenBase {

	public BiomeGenUseless(int biomeId) {
		super(biomeId);
		
		this.setBiomeName("Useless Biome");
		this.setColor(0xEFAAAA);
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.stone.getDefaultState();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityUselessDave.class, 8, 1, 3));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 5, 1, 4));
		this.waterColorMultiplier = 53562184;		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float f) {
		return 0xC7FF85;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int i)
	{
		return 0xd8fa9e;
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random p_180622_2_, ChunkPrimer p_180622_3_, int p_180622_4_, int p_180622_5_, double p_180622_6_)
    {
		this.generateBiomeTerrain(worldIn, p_180622_2_, p_180622_3_, p_180622_4_, p_180622_5_, p_180622_6_);
    }
	
	public void generateCustomBiomeTerrain(World worldIn, Random p_180628_2_, ChunkPrimer p_180628_3_, int p_180628_4_, int p_180628_5_, double p_180628_6_)
	{
		boolean flag = true;
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int k = -1;
        int l = (int)(p_180628_6_ / 3.0D + 3.0D + p_180628_2_.nextDouble() * 0.25D);
        int i1 = p_180628_4_ & 15;
        int j1 = p_180628_5_ & 15;

        for (int k1 = 255; k1 >= 0; --k1)
        {
                IBlockState iblockstate2 = p_180628_3_.getBlockState(j1, k1, i1);

                if (iblockstate2.getBlock().getMaterial() == Material.air)
                {
                    k = -1;
                }
                else if (iblockstate2.getBlock() == Blocks.stone)
                {
                    if (k == -1)
                    {
                        if (l <= 0)
                        {
                            iblockstate = null;
                            iblockstate1 = Blocks.stone.getDefaultState();
                        }
                        else if (k1 >= 59 && k1 <= 64)
                        {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        k = l;

                        if (k1 >= 62)
                        {
                            p_180628_3_.setBlockState(j1, k1, i1, iblockstate);
                        }
                        else if (k1 < 56 - l)
                        {
                            iblockstate = null;
                            iblockstate1 = Blocks.stone.getDefaultState();
                        }
                    }
                }
        }
	}
	
}
