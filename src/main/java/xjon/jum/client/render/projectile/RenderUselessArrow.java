package xjon.jum.client.render.projectile;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.entity.projectile.EntityUselessArrow;
import xjon.jum.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderUselessArrow extends RenderArrow<EntityUselessArrow> {
	
	private static final ResourceLocation arrowTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/useless_arrow.png");

    public RenderUselessArrow(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityUselessArrow p_180550_1_)
    {
        return arrowTextures;
    }

}
