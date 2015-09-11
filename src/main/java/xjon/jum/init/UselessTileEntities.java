package xjon.jum.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import xjon.jum.tileentity.TileEntityUselessChest;
import xjon.jum.util.Reference;

public class UselessTileEntities {

	public static void register()
	{
		GameRegistry.registerTileEntity(TileEntityUselessChest.class, Reference.MOD_ID);
	}
	
}
