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
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityUselessDave.class, 16, 1, 3));
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
	
}
