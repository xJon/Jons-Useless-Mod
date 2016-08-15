package xjon.jum.util;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import xjon.jum.JumCore;

public class UselessConfiguration {
	
	public static boolean isUseless;
	public static int uselessDimensionId;
	public static int uselessBiomeId;
	
	public static boolean IS_USELESS_DEFAULT = false;
	public static int USELESS_DIMENSION_ID_DEFAULT = 57;
	public static int USELESS_BIOME_ID_DEFAULT = 184;
	
	public static final String IS_USELESS_NAME = "Sets if the mod is being useless or not";
	public static final String USELESS_DIMENSION_ID_NAME = "Sets the ID of the Useless Dimension";
	public static final String USELESS_BIOME_ID_NAME = "Sets the ID of the Useless Biome";
	
	public static final String MAIN = Configuration.CATEGORY_GENERAL + Configuration.CATEGORY_SPLITTER + "Main";

	public static void syncConfig()
	{
		MinecraftForge.EVENT_BUS.register(JumCore.instance);
		
		isUseless = JumCore.config.get(MAIN, IS_USELESS_NAME, IS_USELESS_DEFAULT).getBoolean(IS_USELESS_DEFAULT);
		uselessDimensionId = JumCore.config.get(MAIN, USELESS_DIMENSION_ID_NAME, USELESS_DIMENSION_ID_DEFAULT).getInt(USELESS_DIMENSION_ID_DEFAULT);
		uselessBiomeId = JumCore.config.get(MAIN, USELESS_BIOME_ID_NAME, USELESS_BIOME_ID_DEFAULT).getInt(USELESS_BIOME_ID_DEFAULT);
		
		if (JumCore.config.hasChanged())
		{
			JumCore.config.save();
		}
	}
	
}
