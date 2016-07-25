package xjon.jum.items;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockBetterUselessOre extends ItemBlock {

	public ItemBlockBetterUselessOre(Block block) {
		super(block);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> toolTip, boolean advanced)
    {
		stack.setStackDisplayName(ChatFormatting.WHITE + "Better Useless Ore");
    	toolTip.add("Generates in the Useless Dimension");
    }

}
