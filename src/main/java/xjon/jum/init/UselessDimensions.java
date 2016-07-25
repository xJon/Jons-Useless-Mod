package xjon.jum.init;

import xjon.jum.util.UselessConfiguration;
import xjon.jum.world.dimension.WorldProviderUseless;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class UselessDimensions {
	
	private static int dimensionId = UselessConfiguration.uselessDimensionId;
	
	public static DimensionType DIMENSION_USELESS;
	
	public static void init()
	{
		registerDimension();
	}

	private static void registerDimension() 
	{
		DIMENSION_USELESS = DimensionType.register("Useless Dimension", "_useless_dimension", dimensionId, WorldProviderUseless.class, false);
		DimensionManager.registerDimension(dimensionId, DimensionType.getById(dimensionId));
	}

}
