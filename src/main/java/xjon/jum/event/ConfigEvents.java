package xjon.jum.event;

import xjon.jum.util.Reference;
import xjon.jum.util.UselessConfiguration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigEvents {

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equals(Reference.MOD_ID))
		{
			UselessConfiguration.syncConfig();
		}
	}
	
}
