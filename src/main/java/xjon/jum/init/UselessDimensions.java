package xjon.jum.init;

import xjon.jum.world.dimension.WorldProviderUseless;
import net.minecraftforge.common.DimensionManager;

public class UselessDimensions {
	
	public static final int dimensionId = 57;
	
	public static void init()
	{
		registerDimension();
	}

	private static void registerDimension() 
	{
		DimensionManager.registerProviderType(dimensionId, WorldProviderUseless.class, false);
		DimensionManager.registerDimension(dimensionId, dimensionId);
	}

}
