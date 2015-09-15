package xjon.jum.client.render.mob;

import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderUselessDave extends RenderLiving {

	private static final ResourceLocation mobTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/useless_dave.png");
	
	public RenderUselessDave(RenderManager manager, ModelBase par1ModelBase, float par2) {
		super(manager, par1ModelBase, par2);
	}

	protected ResourceLocation getEntityTexture(EntityUselessDave entity) {
		return mobTextures;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityUselessDave)entity);
	}
	
}
