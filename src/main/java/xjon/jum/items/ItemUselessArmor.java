package xjon.jum.items;

import xjon.jum.init.UselessItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHealth;
import net.minecraft.potion.PotionType;
import net.minecraft.world.World;

public class ItemUselessArmor extends ItemArmor {

	public ItemUselessArmor(ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		if (this.armorType.getIndex() == 2)
			return "jum:textures/models/armor/useless_armor_2.png";
		return "jum:textures/models/armor/useless_armor_1.png";
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		
		if (!world.isRemote)
		{
		
			if (player.getArmorInventoryList()!= null)
				{
					ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
					ItemStack leggings = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
					ItemStack chestplate = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
					ItemStack helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
			
				if (boots.getItem() == UselessItems.useless_boots && leggings.getItem() == UselessItems.useless_leggings && chestplate.getItem() == UselessItems.useless_chestplate && helmet.getItem() == UselessItems.useless_helmet)
					{
						if (player.getActivePotionEffect(MobEffects.REGENERATION) == null)
						{
							player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 50, 0));
						}
						if (world.getWorldTime() % 50 > 0)
						{
							return;
						}
						player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 50, 0));
					}
			
				}
		}
		else { super.onArmorTick(world, player, itemStack); }
	}

}
