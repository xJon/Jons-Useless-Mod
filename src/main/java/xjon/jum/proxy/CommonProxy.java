package xjon.jum.proxy;

import xjon.jum.init.UselessBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {

	public void registerRenders()
	{
		
	}
	
	private void addOreDictionary() {
		OreDictionary.registerOre("oreUseless", UselessBlocks.useless_ore);
		OreDictionary.registerOre("oreSuperUseless", UselessBlocks.super_useless_block);
	}
	
}
