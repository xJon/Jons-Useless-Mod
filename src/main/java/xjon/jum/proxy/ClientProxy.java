 package xjon.jum.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
import xjon.jum.util.Reference;


public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityUselessDave.class, new RenderUselessDave(Minecraft.getMinecraft().getRenderManager(), new ModelUselessDave(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityUselessArrow.class, new RenderArrow());
		
		UselessBlocks.registerRenders();
		UselessItems.registerRenders();
		
		
		ModelBakery.addVariantName(UselessItems.useless_bow, new String[] {Reference.MOD_ID + ":useless_bow", Reference.MOD_ID + ":bow_useless_pulling_0", Reference.MOD_ID + ":bow_useless_pulling_1", Reference.MOD_ID + ":bow_useless_pulling_2"});
		 registerItem(UselessItems.useless_bow, 0, Reference.MOD_ID + ":useless_bow");
		 registerItem(UselessItems.useless_bow, 1, Reference.MOD_ID + ":bow_useless_pulling_0");
         registerItem(UselessItems.useless_bow, 2, Reference.MOD_ID + ":bow_useless_pulling_1");
         registerItem(UselessItems.useless_bow, 3, Reference.MOD_ID + ":bow_useless_pulling_2");
		
		TileEntitySpecialRenderer mcr = new UselessChestRenderer(Minecraft.getMinecraft().getRenderManager());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUselessChest.class, mcr);
		TileEntityItemStackRenderer.instance = new ModeledBlockInventoryRenderer();
	}
	
	 	@SideOnly(Side.CLIENT)
	    public static void registerItem(Item item, int metadata, String itemName)
	    {
	        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
	        mesher.register(item, metadata, new ModelResourceLocation(itemName, "inventory"));
	    }
	
	
	
}
