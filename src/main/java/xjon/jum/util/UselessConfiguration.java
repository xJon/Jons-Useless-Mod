package xjon.jum.util;

import xjon.jum.JumCore;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

public class UselessConfiguration {
	
	public static boolean isUseless;
	public static int uselessDimensionId;
	public static int uselessBiomeId;
	public static int durability;
	public static int enchantability;
	public static float efficiency;
	public static int foodAmount;
	public static float daveHealth;
	
	public static boolean IS_USELESS_DEFAULT = false;
	public static int USELESS_DIMENSION_ID_DEFAULT = 57;
	public static int USELESS_BIOME_ID_DEFAULT = 184;
	public static int DURABILITY_DEFAULT = 40;
	public static int ENCHANTABILITY_DEFAULT = 100;
	public static int EFFICIENCY_DEFAULT = 10;
	public static int FOOD_AMOUNT_DEFAULT = 8;
	public static int DAVE_HEALTH_DEFAULT = 28;
	
	public static final String IS_USELESS_NAME = "Sets if the mod is being useless or not";
	public static final String USELESS_DIMENSION_ID_NAME = "Sets the ID of the Useless Dimension";
	public static final String USELESS_BIOME_ID_NAME = "Sets the ID of the Useless Biome";
	public static final String DURABILITY_NAME = "Tools durability level";
	public static final String ENCHANTABILITY_NAME = "Tools enchantibility"; 
	public static final String EFFICIENCY_NAME = "Tools efficiency";
	public static final String FOOD_AMOUNT_NAME = "Useless Food efficiency"; 
	public static final String DAVE_HEALTH_NAME = "Dave's HP amount"; 

	public static final String MAIN = Configuration.CATEGORY_GENERAL + Configuration.CATEGORY_SPLITTER + "Main";
	public static final String BALANCE = Configuration.CATEGORY_GENERAL + Configuration.CATEGORY_SPLITTER + "Balance";

	public static void syncConfig()
	{	
		MinecraftForge.EVENT_BUS.register(JumCore.instance);
		
		isUseless = JumCore.config.get(MAIN, IS_USELESS_NAME, IS_USELESS_DEFAULT).getBoolean(IS_USELESS_DEFAULT);
		uselessDimensionId = JumCore.config.get(MAIN, USELESS_DIMENSION_ID_NAME, USELESS_DIMENSION_ID_DEFAULT).getInt(USELESS_DIMENSION_ID_DEFAULT);
		uselessBiomeId = JumCore.config.get(MAIN, USELESS_BIOME_ID_NAME, USELESS_BIOME_ID_DEFAULT).getInt(USELESS_BIOME_ID_DEFAULT);

		durability = JumCore.config.get(BALANCE, DURABILITY_NAME, DURABILITY_DEFAULT).getInt(DURABILITY_DEFAULT);
		enchantability = JumCore.config.get(BALANCE, ENCHANTABILITY_NAME, ENCHANTABILITY_DEFAULT).getInt(ENCHANTABILITY_DEFAULT);
		efficiency = JumCore.config.get(BALANCE, EFFICIENCY_NAME, EFFICIENCY_DEFAULT).getInt(EFFICIENCY_DEFAULT);
		foodAmount = JumCore.config.get(BALANCE, FOOD_AMOUNT_NAME, FOOD_AMOUNT_DEFAULT).getInt(FOOD_AMOUNT_DEFAULT);
		daveHealth = JumCore.config.get(BALANCE, DAVE_HEALTH_NAME, DAVE_HEALTH_DEFAULT).getInt(DAVE_HEALTH_DEFAULT);
		
		if (JumCore.config.hasChanged())
		{
			JumCore.config.save();
		}
	}
	
}
