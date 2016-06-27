package xjon.jum.event;

import java.util.Random;

import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.init.UselessAchievements;
import xjon.jum.init.UselessDimensions;
import xjon.jum.init.UselessItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
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
		  
		  if ((rnd <= 0.04D) && ((entity instanceof EntityLiving)) && ((event.entity instanceof EntitySkeleton | event.entity instanceof EntityZombie | event.entity instanceof EntityUselessDave)))
	    {
		  EntityLiving living = (EntityLiving)entity;
	      
	      if (range == 1) {
	        living.setCurrentItemOrArmor(4, new ItemStack(UselessItems.useless_helmet));
	      }

	      if (range == 2) {
	        living.setCurrentItemOrArmor(3, new ItemStack(UselessItems.useless_chestplate));
	      }

	      if (range == 3) {
	        living.setCurrentItemOrArmor(2, new ItemStack(UselessItems.useless_leggings));
	      }

	      if (range == 4) {
	        living.setCurrentItemOrArmor(1, new ItemStack(UselessItems.useless_boots));
	      }

	      if (range == 5) {
	        living.setCurrentItemOrArmor(0, new ItemStack(UselessItems.useless_food));
	      }
	    
	    }
		  		
	}
	  	
}
