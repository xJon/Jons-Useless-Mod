package xjon.jum.items;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockUselessMachine extends ItemBlock {

	public ItemBlockUselessMachine(Block block) {
		super(block);
		this.maxStackSize = 1;
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> toolTip, boolean advanced)
    {
		stack.setStackDisplayName(ChatFormatting.DARK_PURPLE + "Useless Machine");
    	toolTip.add("Teleports you to the Useless Dimension!");
    }
	
	

}
