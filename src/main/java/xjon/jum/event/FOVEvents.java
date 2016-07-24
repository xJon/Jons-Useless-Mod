package xjon.jum.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xjon.jum.items.ItemUselessBow;

public class FOVEvents {

	@SubscribeEvent
    public void FOVBowUpdate(FOVUpdateEvent event){
		EntityPlayer player = event.getEntity();
		
		if(player.getHeldItemMainhand() != null){
			if(player.getHeldItemMainhand().getItem() instanceof ItemUselessBow){
	            int i = player.getItemInUseCount();
	            float f1 = (float)i / 20.0F;

	            if (f1 > 1.0F)
	            {
	                f1 = 1.0F;
	            }
	            else
	            {
	                f1 *= f1;
	            }

	            event.setNewfov(event.getNewfov() * (1.0F - f1 * 0.15F));
			}
		}
	}


}
