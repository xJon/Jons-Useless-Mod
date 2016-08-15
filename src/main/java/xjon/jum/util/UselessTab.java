package xjon.jum.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xjon.jum.init.UselessItems;

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
