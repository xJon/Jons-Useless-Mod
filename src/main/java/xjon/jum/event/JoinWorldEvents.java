package xjon.jum.event;

import java.util.Random;

import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.init.UselessItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class JoinWorldEvents {

	 public static double rnd;
	 public static int range;

	  public static Random random = new Random();
	  	  
	  @SubscribeEvent
	  public void EntityJoinWorldEvent(EntityJoinWorldEvent event)
	  {
	      Entity entity = event.getEntity();
		  
		  rnd = Math.random();
		  range = random.nextInt(6);
		  
		  if ((rnd <= 0.04D) && ((entity instanceof EntityLiving)) && ((event.getEntity() instanceof EntitySkeleton || event.getEntity() instanceof EntityZombie || event.getEntity() instanceof EntityUselessDave)))
	    {
		  EntityLiving living = (EntityLiving)entity;
	      
	      switch (range)
	      {
	      	case 0:
	      	  living.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(UselessItems.useless_helmet));
	      	  break;

	        case 1:
	    	  living.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(UselessItems.useless_chestplate));
	    	  break;

	        case 2:
	    	  living.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(UselessItems.useless_leggings));
	    	  break;
	    	  
	        case 3:
	    	  living.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(UselessItems.useless_boots));
	    	  break;

	        case 4:
	    	  living.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(UselessItems.useless_food));
	    	  break;
	      
	        case 5:
	    	  living.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(UselessItems.useless_axe));
	    	  break;
	      }
	    
	    }
		  		
	}
	  	
}
