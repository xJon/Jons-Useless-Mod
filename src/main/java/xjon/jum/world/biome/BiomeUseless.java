package xjon.jum.world.biome;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.entity.mob.EntityUselessDave;


public class BiomeUseless extends Biome {
		
	public BiomeUseless(BiomeProperties properties) {
		super(properties);
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.STONE.getDefaultState();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new BiomeUseless.SpawnListEntry(EntityUselessDave.class, 15, 3, 7));
		this.setRegistryName("UselessBiome");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float f) {
		return 0xC7FF85;
	}
	
	
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 0xd8fa9e;
	}
	
	@Override
	public int getWaterColorMultiplier() {
		return 13762304;
	}
	
	@Override
	public Class<? extends Biome> getBiomeClass() {
		return BiomeUseless.class;
	}
	
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 0xEDFCD3;
    }

	
}
