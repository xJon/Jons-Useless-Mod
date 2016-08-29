package xjon.jum.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xjon.jum.blocks.UselessMachine;
import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.util.Reference;

public class UselessSounds {
	
	public static void init()
	{
		GameRegistry.register(EntityUselessDave.SND_HI, new ResourceLocation(Reference.MOD_ID, "hidave"));
	    GameRegistry.register(EntityUselessDave.SND_HIT, new ResourceLocation(Reference.MOD_ID, "hitdave"));
	    GameRegistry.register(EntityUselessDave.SND_DEATH, new ResourceLocation(Reference.MOD_ID, "deathdave"));
	    GameRegistry.register(UselessMachine.SND_NOPE, new ResourceLocation(Reference.MOD_ID, "nope"));
	}

}
