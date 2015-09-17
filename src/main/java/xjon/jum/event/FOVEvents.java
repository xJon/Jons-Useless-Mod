package xjon.jum.event;

import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xjon.jum.items.ItemUselessBow;

public class FOVEvents {

	@SubscribeEvent
    public void FOVBowUpdate(FOVUpdateEvent event){
		if(event.entity.getItemInUse() != null){
			if(event.entity.getItemInUse().getItem() instanceof ItemUselessBow){
	            int i = event.entity.getItemInUseDuration();
	            float f1 = (float)i / 20.0F;

	            if (f1 > 1.0F)
	            {
	                f1 = 1.0F;
	            }
	            else
	            {
	                f1 *= f1;
	            }

	            event.newfov *= 1.0F - f1 * 0.15F;
			}
		}
	}


}
