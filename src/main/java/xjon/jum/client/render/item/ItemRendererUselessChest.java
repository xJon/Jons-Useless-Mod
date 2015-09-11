package xjon.jum.client.render.item;

import org.lwjgl.opengl.GL11;

import xjon.jum.tileentity.TileEntityUselessChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ItemRendererUselessChest implements IItemRenderer {

	private ModelChest chestModel;
	private ResourceLocation location = new ResourceLocation("jum:textures/entity/chest/normal");
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case ENTITY: {
			renderStratosChest(0.5F, 0.5F, 0.5F);
			break;
		}
		case EQUIPPED: {
			renderStratosChest(1.0F, 1.0F, 1.0F);
			break;
		}
		case EQUIPPED_FIRST_PERSON: {
			renderStratosChest(1.0F, 1.0F, 1.0F);
			break;
		}
		case INVENTORY: {
			renderStratosChest(0.0F, 0.075F, 0.0F);
			break;
		}
		default:
			break;
		}
	}
	private void renderStratosChest(float x, float y, float z) {
		location = new ResourceLocation("jum:textures/entity/chest/normal");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(location);
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glRotatef(-90, 0, 1, 0);
		chestModel.renderAll();
		GL11.glPopMatrix();
	}

}
