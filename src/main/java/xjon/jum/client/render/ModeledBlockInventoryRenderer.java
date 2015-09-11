package xjon.jum.client.render;

import xjon.jum.init.UselessBlocks;
import xjon.jum.tileentity.TileEntityUselessChest;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

public class ModeledBlockInventoryRenderer extends TileEntityItemStackRenderer {
	private TileEntityUselessChest temc = new TileEntityUselessChest();
	
	@Override public void renderByItem(ItemStack itemStack) {
		Block block = Block.getBlockFromItem(itemStack.getItem());
		if (block == UselessBlocks.useless_chest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.temc, 0, 0, 0, 0F);
		} else {
			super.renderByItem(itemStack);
		}
	}
}
