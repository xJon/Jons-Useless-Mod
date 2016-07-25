 package xjon.jum.proxy;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import xjon.jum.client.render.ModeledBlockInventoryRenderer;
import xjon.jum.client.render.mob.RenderUselessDave;
import xjon.jum.client.render.projectile.RenderArrow;
import xjon.jum.client.render.tileentity.UselessChestRenderer;
import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.entity.mob.ModelUselessDave;
import xjon.jum.entity.projectile.EntityUselessArrow;
import xjon.jum.init.UselessBlocks;
import xjon.jum.init.UselessItems;
import xjon.jum.tileentity.TileEntityUselessChest;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityUselessDave.class, manager -> new RenderUselessDave(manager, new ModelUselessDave(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityUselessArrow.class, RenderArrow::new);

		TileEntitySpecialRenderer<TileEntityUselessChest> mcr = new UselessChestRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUselessChest.class, mcr);
		TileEntityItemStackRenderer.instance = new ModeledBlockInventoryRenderer();
		
		UselessBlocks.registerRenders();
		UselessItems.registerRenders();
	}
}
