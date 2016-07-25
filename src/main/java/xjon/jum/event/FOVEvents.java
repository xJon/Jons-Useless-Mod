package xjon.jum.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.init.UselessItems;
import xjon.jum.items.ItemUselessBow;

public class FOVEvents {

	  @SideOnly(Side.CLIENT)
	  @SubscribeEvent
	  public void onFovUpdateEvent(FOVUpdateEvent fovEvt) {
	    ItemStack currentItem = fovEvt.getEntity().getHeldItemMainhand();
	    if(currentItem == null || currentItem.getItem() != UselessItems.useless_bow || fovEvt.getEntity().getItemInUseCount() <= 0) {
	      return;
	    }

	    int drawDuration = 72000 - fovEvt.getEntity().getItemInUseCount();
	    float ratio = drawDuration / (float) 14;

	    if(ratio > 1.0F) {
	      ratio = 1.0F;
	    } else {
	      ratio *= ratio;
	    }
	    fovEvt.setNewfov((1.0F - ratio * 0.15F));

	  }


}
