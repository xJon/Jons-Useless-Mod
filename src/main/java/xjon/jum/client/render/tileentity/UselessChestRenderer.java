package xjon.jum.client.render.tileentity;

import xjon.jum.blocks.UselessChest;
import xjon.jum.tileentity.TileEntityUselessChest;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class UselessChestRenderer extends TileEntitySpecialRenderer<TileEntityUselessChest>
{
    private static final ResourceLocation textureNormal = new ResourceLocation("jum:textures/entity/chest/normal.png");
    private ModelChest simpleChest = new ModelChest();

    public void renderTileEntityAt(TileEntityUselessChest uselessChest, double x, double y, double z, float partialTicks, int destroyStage) {
        {
            int j;

            if (!uselessChest.hasWorldObj()) {
                j = 0;
            } else {
                Block block = uselessChest.getBlockType();
                j = uselessChest.getBlockMetadata();

                if (block instanceof UselessChest && j == 0) {
                    ((UselessChest) block).checkForSurroundingChests(uselessChest.getWorld(), uselessChest.getPos(), uselessChest.getWorld().getBlockState(uselessChest.getPos()));
                    j = uselessChest.getBlockMetadata();
                }
            }

            if (uselessChest.adjacentChestZNeg == null && uselessChest.adjacentChestXNeg == null) {
                ModelChest modelchest;

                if (uselessChest.adjacentChestXPos == null && uselessChest.adjacentChestZPos == null) {
                    modelchest = this.simpleChest;

                    if (destroyStage >= 0) {
                        this.bindTexture(DESTROY_STAGES[destroyStage]);
                        GlStateManager.matrixMode(5890);
                        GlStateManager.pushMatrix();
                        GlStateManager.scale(4.0F, 4.0F, 1.0F);
                        GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
                        GlStateManager.matrixMode(5888);
                    } else {
                        this.bindTexture(textureNormal);
                    }
                } else {
                    modelchest = this.simpleChest;

                    if (destroyStage >= 0) {
                        this.bindTexture(DESTROY_STAGES[destroyStage]);
                        GlStateManager.matrixMode(5890);
                        GlStateManager.pushMatrix();
                        GlStateManager.scale(8.0F, 4.0F, 1.0F);
                        GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
                        GlStateManager.matrixMode(5888);
                    }

                }

                GlStateManager.pushMatrix();
                GlStateManager.enableRescaleNormal();

                if (destroyStage < 0) {
                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                }

                GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
                GlStateManager.scale(1.0F, -1.0F, -1.0F);
                GlStateManager.translate(0.5F, 0.5F, 0.5F);
                short short1 = 0;

                if (j == 2) {
                    short1 = 180;
                }

                if (j == 3) {
                    short1 = 0;
                }

                if (j == 4) {
                    short1 = 90;
                }

                if (j == 5) {
                    short1 = -90;
                }

                if (j == 2 && uselessChest.adjacentChestXPos != null) {
                    GlStateManager.translate(1.0F, 0.0F, 0.0F);
                }

                if (j == 5 && uselessChest.adjacentChestZPos != null) {
                    GlStateManager.translate(0.0F, 0.0F, -1.0F);
                }

                GlStateManager.rotate((float) short1, 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(-0.5F, -0.5F, -0.5F);
                float f1 = uselessChest.prevLidAngle + (uselessChest.lidAngle - uselessChest.prevLidAngle) * partialTicks;
                float f2;

                if (uselessChest.adjacentChestZNeg != null) {
                    f2 = uselessChest.adjacentChestZNeg.prevLidAngle + (uselessChest.adjacentChestZNeg.lidAngle - uselessChest.adjacentChestZNeg.prevLidAngle) * partialTicks;

                    if (f2 > f1) {
                        f1 = f2;
                    }
                }

                if (uselessChest.adjacentChestXNeg != null) {
                    f2 = uselessChest.adjacentChestXNeg.prevLidAngle + (uselessChest.adjacentChestXNeg.lidAngle - uselessChest.adjacentChestXNeg.prevLidAngle) * partialTicks;

                    if (f2 > f1) {
                        f1 = f2;
                    }
                }

                f1 = 1.0F - f1;
                f1 = 1.0F - f1 * f1 * f1;
                modelchest.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);
                modelchest.renderAll();
                GlStateManager.disableRescaleNormal();
                GlStateManager.popMatrix();
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                if (destroyStage >= 0) {
                    GlStateManager.matrixMode(5890);
                    GlStateManager.popMatrix();
                    GlStateManager.matrixMode(5888);
                }
            }
        }
    }

}