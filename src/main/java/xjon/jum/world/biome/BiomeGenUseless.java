	package xjon.jum.world.biome;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.entity.mob.EntityUselessDave;



public class BiomeGenUseless extends BiomeGenBase {
	
	List<BiomeGenBase.SpawnListEntry> spawnableCList = Lists.<BiomeGenBase.SpawnListEntry>newArrayList();
	List<BiomeGenBase.SpawnListEntry> spawnableCCList = Lists.<BiomeGenBase.SpawnListEntry>newArrayList();

	public BiomeGenUseless(int biomeId) {
		super(biomeId);
		
		this.setBiomeName("Useless Biome");
		this.setColor(0xEDFCD3);
		this.setDisableRain();
		this.waterColorMultiplier = 13762304;
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.stone.getDefaultState();
		this.spawnableCList.add(new BiomeGenBase.SpawnListEntry(EntityUselessDave.class, 15, 3, 5));
		this.spawnableCCList.add(new BiomeGenBase.SpawnListEntry(EntityBat.class, 10, 8, 8));
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
	        	return Collections.<BiomeGenBase.SpawnListEntry>emptyList();
		}
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
	public int getFoliageColorAtPos(BlockPos pos) {
		return 0xEDFCD3;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int i)
	{
		return 0xd8fa9e;
	}
	
}
