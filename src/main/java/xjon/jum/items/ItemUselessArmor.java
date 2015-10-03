package xjon.jum.items;

import xjon.jum.init.UselessItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemUselessArmor extends ItemArmor {

	public ItemUselessArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (this.armorType == 2)
		{
			return "jum:textures/models/armor/useless_armor_2.png";
		}
		return "jum:textures/models/armor/useless_armor_1.png";
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (!world.isRemote)
		{
		
			if(player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null)
				{
					ItemStack boots = player.getCurrentArmor(0);
					ItemStack leggings = player.getCurrentArmor(1);
					ItemStack chestplate = player.getCurrentArmor(2);
					ItemStack helmet = player.getCurrentArmor(3);
			
				if(boots.getItem() == UselessItems.useless_boots && leggings.getItem() == UselessItems.useless_leggings && chestplate.getItem() == UselessItems.useless_chestplate && helmet.getItem() == UselessItems.useless_helmet)
					{
						player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
					}
			
				}
		}
		else { 	super.onArmorTick(world, player, itemStack); }
	}

}
