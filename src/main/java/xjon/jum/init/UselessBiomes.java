package xjon.jum.init;

import xjon.jum.world.biome.BiomeUseless;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;


public class UselessBiomes {

	public static void init(){
		initializeBiome();
		registerBiome();
	}
	
	public static Biome biomeUseless;
	
	public static void initializeBiome(){
		
		biomeUseless = new BiomeUseless(new BiomeProperties("Useless Biome").setWaterColor(13762304).setBaseBiome("Useless Dimension"));
		
	}
	
	public static void registerBiome(){
		BiomeDictionary.registerBiomeType(biomeUseless, Type.MAGICAL);
		Biome.registerBiome(184, "Useless Biome", biomeUseless);
		BiomeManager.addSpawnBiome(biomeUseless);
		
	}
	
}
