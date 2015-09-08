package xjon.jum.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import xjon.jum.tileentity.TileEntityUselessChest;

public class UselessTileEntities {

	public static void register()
	{
		GameRegistry.registerTileEntity(TileEntityUselessChest.class, "jumChest");
	}
	
}
