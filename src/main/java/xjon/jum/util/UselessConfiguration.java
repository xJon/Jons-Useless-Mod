package xjon.jum.util;

import xjon.jum.JumCore;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class UselessConfiguration {
	
	public static boolean isUseless;
	public static final boolean IS_USELESS_DEFAULT = false;
	public static final String IS_USELESS_NAME = "Set if the mod is being useless or not";

	public static void syncConfig()
	{
		FMLCommonHandler.instance().bus().register(JumCore.instance);
	
		final String MAIN = JumCore.config.CATEGORY_GENERAL + JumCore.config.CATEGORY_SPLITTER + "Main";
		JumCore.config.addCustomCategoryComment(MAIN, "Is useless");
		isUseless = JumCore.config.get(MAIN, IS_USELESS_NAME, IS_USELESS_DEFAULT).getBoolean(IS_USELESS_DEFAULT);
		if(JumCore.config.hasChanged())
		{
			JumCore.config.save();
		}
	}
	
}
