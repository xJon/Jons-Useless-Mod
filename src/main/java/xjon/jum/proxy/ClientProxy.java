 package xjon.jum.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import xjon.jum.client.render.item.ItemRendererUselessChest;
import xjon.jum.client.render.mob.RenderUselessDave;
import xjon.jum.client.render.tileentity.UselessChestRenderer;
import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.entity.mob.ModelUselessDave;
import xjon.jum.init.UselessBlocks;
import xjon.jum.init.UselessItems;
import xjon.jum.tileentity.TileEntityUselessChest;


public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityUselessDave.class, new RenderUselessDave(Minecraft.getMinecraft().getRenderManager(), new ModelUselessDave(), 0));
		
		UselessBlocks.registerRenders();
		UselessItems.registerRenders();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUselessChest.class, new UselessChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(UselessBlocks.useless_chest), new ItemRendererUselessChest());
	}
	
}
