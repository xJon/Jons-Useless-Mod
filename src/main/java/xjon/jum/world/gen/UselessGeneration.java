package xjon.jum.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import xjon.jum.JumCore;
import xjon.jum.init.UselessBlocks;
import xjon.jum.init.UselessDimensions;
import xjon.jum.util.UselessConfiguration;

public class UselessGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		int dimension = world.provider.getDimension();
		
		if (dimension == 0)
		{
		generateOverworld(world, random, new BlockPos(chunkX * 16, 64, chunkZ * 16));
		} 
		else if (dimension == UselessConfiguration.uselessDimensionId) 
		{
		generateUselessDimension(world, random, new BlockPos(chunkX * 16, 64, chunkZ * 16));
		}
		
	}

	private void generateOverworld(World world, Random rnd, BlockPos pos)
	{
		generateOre(UselessBlocks.useless_ore, world, rnd, pos, 16, 16, 1 + rnd.nextInt(8), 12, 0, 100, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	private void generateUselessDimension(World world, Random rnd, BlockPos pos)
	{
		generateOre(UselessBlocks.better_useless_ore, world, rnd, pos, 16, 16, 1 + rnd.nextInt(6), 50, 0, 255, BlockMatcher.forBlock(Blocks.STONE));
		generateOre(UselessBlocks.legitimate_diamond_ore, world, rnd, pos, 16, 16, 1 + rnd.nextInt(8), 65, 0, 255, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	public void generateOre(Block block, World world, Random random, BlockPos pos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY, BlockMatcher blockHelper)
	{
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), maxVeinSize);
		for (int i = 0; i < chanceToSpawn; ++i)
		{
			int xRnd = pos.getX() + random.nextInt(maxX);
			int yRnd = minY + random.nextInt(heightRange);
			int zRnd = pos.getZ() + random.nextInt(maxZ);
			gen.generate(world, random, new BlockPos(xRnd, yRnd, zRnd));
		}
	}

}
