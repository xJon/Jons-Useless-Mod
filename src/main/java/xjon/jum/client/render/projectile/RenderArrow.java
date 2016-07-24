package xjon.jum.client.render.projectile;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.entity.projectile.EntityUselessArrow;
import xjon.jum.util.Reference;


@SideOnly(Side.CLIENT)
public class RenderArrow extends Render<EntityUselessArrow> {
	
	private static final ResourceLocation arrowTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/useless_arrow.png");

    public RenderArrow(RenderManager manager) {
        super(manager);
    }

	@Override
    public void doRender(EntityUselessArrow entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (!this.renderOutlines)
        {
            this.renderName(entity, x, y, z);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityUselessArrow p_180550_1_)
    {
        return arrowTextures;
    }

}
