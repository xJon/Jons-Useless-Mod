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
	
	List<Biome.SpawnListEntry> spawnableCList = Lists.<Biome.SpawnListEntry>newArrayList();
	List<Biome.SpawnListEntry> spawnableCCList = Lists.<Biome.SpawnListEntry>newArrayList();
		
	public BiomeUseless(BiomeProperties properties) {
		super(properties);
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.STONE.getDefaultState();
		this.spawnableCList.add(new Biome.SpawnListEntry(EntityUselessDave.class, 15, 3, 7));
		this.spawnableCCList.add(new Biome.SpawnListEntry(EntityBat.class, 10, 8, 8));
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
	public List<SpawnListEntry> getSpawnableList(EnumCreatureType creatureType) 
	{
		switch (creatureType)
		{
        	case MONSTER:
        		return this.spawnableCList;
			case CREATURE:
				return this.spawnableCList;
			case AMBIENT:
	            return this.spawnableCCList;
	        default:
	        	return Collections.<Biome.SpawnListEntry>emptyList();
		}
	}
	
	@Override
	public boolean canRain() {
		return false;
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
