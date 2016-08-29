package xjon.jum.init;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import xjon.jum.JumCore;
import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.entity.projectile.EntityUselessArrow;
import xjon.jum.util.Reference;

public class UselessEntities {
	
	public static void init()
	{
		register();
	}
	
	public static void register()
	{
		createEntity(EntityUselessDave.class, "Dave the Useless", 0x2E2814, 0x594E30);
		EntityRegistry.registerModEntity(EntityUselessArrow.class, "Useless Arrow", 0, JumCore.instance, 250, 20, true);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor)
	{
		BiomeGenBase[] allBiomes = Iterators.toArray(Iterators.filter(Iterators.forArray(BiomeGenBase.getBiomeGenArray()), Predicates.notNull()), BiomeGenBase.class);
		
		EntityRegistry.registerModEntity(entityClass, entityName, 1, JumCore.instance, 64, 1, true);
		
		EntityRegistry.addSpawn(entityClass, 2, 1, 1, EnumCreatureType.CREATURE, allBiomes);
		
		createEgg(solidColor, spotColor);
	}
	
	private static void createEgg(int primColor, int spotColor)
	{
		EntityRegistry.registerEgg(EntityUselessDave.class, primColor, spotColor);
	}
}
