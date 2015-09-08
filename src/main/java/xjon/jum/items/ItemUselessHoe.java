package xjon.jum.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUselessHoe extends ItemHoe {

	public ItemUselessHoe(ToolMaterial material) {
		super(material);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced)
	{
		stack.setStackDisplayName(EnumChatFormatting.DARK_RED + "Useless Hoe");
    	toolTip.add("You never listen to me!");
	}

}
