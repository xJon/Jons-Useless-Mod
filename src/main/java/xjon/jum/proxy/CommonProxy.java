package xjon.jum.proxy;

import xjon.jum.init.UselessBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {

	public void registerRenders()
	{
		
	}
	
	private void addOreDictionary() {
		OreDictionary.registerOre("oreUseless", UselessBlocks.useless_ore);
		OreDictionary.registerOre("oreSuperUseless", UselessBlocks.better_useless_ore);
	}
	
}
