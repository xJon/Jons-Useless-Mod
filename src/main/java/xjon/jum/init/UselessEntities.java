package xjon.jum.init;

import com.google.common.collect.Iterables;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import xjon.jum.JumCore;
import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.entity.projectile.EntityUselessArrow;

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
	
	public static void createEntity(Class<? extends EntityLiving> entityClass, String entityName, int solidColor, int spotColor)
	{		
		EntityRegistry.registerModEntity(entityClass, entityName, 1, JumCore.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 1, 1, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.MESA, Biomes.EXTREME_HILLS, Biomes.PLAINS, Biomes.TAIGA, Biomes.SAVANNA);
		createEgg("0", solidColor, spotColor);
	}
	
	private static void createEgg(String spawnedID, int primColor, int spotColor)
	{
		EntityRegistry.registerEgg(EntityUselessDave.class, primColor, spotColor);
	}
}
