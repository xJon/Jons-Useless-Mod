package xjon.jum.util;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import xjon.jum.JumCore;

public class UselessConfiguration {
	
	public static boolean isUseless;
	public static boolean IS_USELESS_DEFAULT = false;
	public static final String IS_USELESS_NAME = "Set if the mod is being useless or not";
	public static final String MAIN = Configuration.CATEGORY_GENERAL + Configuration.CATEGORY_SPLITTER + "Main";

	public static void syncConfig()
	{
		MinecraftForge.EVENT_BUS.register(JumCore.instance);
		
		isUseless = JumCore.config.get(MAIN, IS_USELESS_NAME, IS_USELESS_DEFAULT).getBoolean(IS_USELESS_DEFAULT);
		if(JumCore.config.hasChanged())
		{
			JumCore.config.save();
		}
	}
	
}
