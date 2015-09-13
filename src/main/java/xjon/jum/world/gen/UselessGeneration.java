package xjon.jum.world.gen;

import java.util.Random;

import xjon.jum.init.UselessBlocks;
import xjon.jum.init.UselessDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class UselessGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
	switch (world.provider.getDimensionId())
	{
	case -1:
		break;
	
	case 0:
		generateOverworld(world, random, new BlockPos(chunkX * 16, 64, chunkZ * 16));
		break;
		
	case 1:
		break;
		
	case UselessDimensions.dimensionId:
		generateUselessDimension(world, random, new BlockPos(chunkX * 16, 64, chunkZ * 16));
		break;
	}
		
	}

	private void generateOverworld(World world, Random rnd, BlockPos pos)
	{
		generateOre(UselessBlocks.useless_ore, world, rnd, pos, 16, 16, 1 + rnd.nextInt(8), 12, 0, 100, BlockHelper.forBlock(Blocks.stone));
	}
	
	private void generateUselessDimension(World world, Random rnd, BlockPos pos)
	{
		generateOre(UselessBlocks.better_useless_ore, world, rnd, pos, 16, 16, 3, 8, 0, 255, BlockHelper.forBlock(Blocks.stone));
		generateOre(UselessBlocks.legitimate_diamond_ore, world, rnd, pos, 16, 16, 5, 10, 0, 255, BlockHelper.forBlock(Blocks.stone));
	}
	
	public void generateOre(Block block, World world, Random random, BlockPos pos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY, BlockHelper blockHelper)
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
