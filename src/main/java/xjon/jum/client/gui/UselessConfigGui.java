package xjon.jum.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import xjon.jum.JumCore;
import xjon.jum.util.Reference;



public class UselessConfigGui extends GuiConfig{

	public UselessConfigGui(GuiScreen screen)
	{
		super(screen, new ConfigElement(JumCore.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				Reference.MOD_NAME, false, false, GuiConfig.getAbridgedConfigPath(JumCore.config.toString()));
	}

}
