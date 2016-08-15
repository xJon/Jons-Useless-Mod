package xjon.jum.init;

import xjon.jum.util.UselessConfiguration;
import xjon.jum.world.biome.BiomeGenUseless;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;


public class UselessBiomes {

	public static void init(){
		initializeBiome();
		registerBiome();
	}
	
	public static BiomeGenBase biomeUseless;
	
	public static void initializeBiome(){
		
		biomeUseless = new BiomeGenUseless(UselessConfiguration.uselessBiomeId).setBiomeName("Useless Biome");
		
	}
	
	public static void registerBiome(){
		BiomeDictionary.registerBiomeType(biomeUseless, Type.MAGICAL);
		BiomeManager.addSpawnBiome(biomeUseless);
		
	}
	
}
