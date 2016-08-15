package xjon.jum.client.render.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.entity.mob.EntityUselessDave;
import xjon.jum.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderUselessDave extends RenderLiving<EntityUselessDave> {

	private static final ResourceLocation mobTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/useless_dave.png");
	
	public RenderUselessDave(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityUselessDave entity) {
		return mobTextures;
	}
	
}
