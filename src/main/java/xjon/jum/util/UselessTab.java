package xjon.jum.util;

import xjon.jum.init.UselessItems;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UselessTab extends CreativeTabs {

	public UselessTab(String label) {
		super(label);
		this.setBackgroundImageName("jum.png");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return UselessItems.useless_material;
	}
}
