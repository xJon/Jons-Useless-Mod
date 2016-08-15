package xjon.jum.init;

import xjon.jum.util.UselessConfiguration;
import xjon.jum.world.dimension.WorldProviderUseless;
import net.minecraftforge.common.DimensionManager;

public class UselessDimensions {
		
	public static void init()
	{
		registerDimension();
	}

	private static void registerDimension() 
	{
		DimensionManager.registerProviderType(UselessConfiguration.uselessDimensionId, WorldProviderUseless.class, false);
		DimensionManager.registerDimension(UselessConfiguration.uselessDimensionId, UselessConfiguration.uselessDimensionId);
	}

}
