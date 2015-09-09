package xjon.jum.init;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import xjon.jum.JumCore;
import xjon.jum.entity.mob.EntityUselessDave;

public class UselessEntities {

	public static void init()
	{
		register();
	}
	
	public static void register()
	{
		createEntity(EntityUselessDave.class, "Dave the Useless", 0x2E2814, 0x594E30);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor)
	{
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		BiomeGenBase[] allBiomes = Iterators.toArray(Iterators.filter(Iterators.forArray(BiomeGenBase.getBiomeGenArray()), Predicates.notNull()), BiomeGenBase.class);
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, JumCore.instance, 64, 1, true);
		
		EntityRegistry.addSpawn(entityClass, 7, 1, 1, EnumCreatureType.CREATURE, allBiomes);
		
		createEgg(randomId, solidColor, spotColor);
	}
	
	private static void createEgg(int randomId, int solidColor, int spotColor)
	{
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	}
}
