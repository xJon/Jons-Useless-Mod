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
			
			ItemStack currentBoots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
			ItemStack currentLeggings = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
			ItemStack currentChestplate = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
			ItemStack currentHelmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		
			if (currentBoots != null && currentLeggings != null && currentChestplate != null && currentHelmet != null)
				{
				if (currentBoots.getItem() == UselessItems.useless_boots && currentLeggings.getItem() == UselessItems.useless_leggings && currentChestplate.getItem() == UselessItems.useless_chestplate && currentHelmet.getItem() == UselessItems.useless_helmet)
					{
						if (player.getActivePotionEffect(MobEffects.REGENERATION) == null)
						{
							player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 1, 0));
						}
						if (world.getWorldTime() % 50 > 0)
						{
							return;
						}
						player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 1, 0));
					}
			
				}
		}
		else { super.onArmorTick(world, player, itemStack); }
	}

}
