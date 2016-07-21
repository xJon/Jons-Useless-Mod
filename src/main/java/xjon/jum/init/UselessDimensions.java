package xjon.jum.init;

import xjon.jum.world.dimension.WorldProviderUseless;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class UselessDimensions {
	
	public static final int dimensionId = 57;
	
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
