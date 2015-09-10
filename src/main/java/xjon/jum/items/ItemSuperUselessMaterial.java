package xjon.jum.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSuperUselessMaterial extends Item {
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced)
	{
		stack.setStackDisplayName(EnumChatFormatting.WHITE + "Super Useless Material");
		toolTip.add("It's so useless, it's used for only one recipe");
	}

}
