package xjon.jum.init;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xjon.jum.JumCore;
import xjon.jum.entity.projectile.EntityUselessArrow;
import xjon.jum.items.ItemSuperUselessMaterial;
import xjon.jum.items.ItemUselessAxe;
import xjon.jum.items.ItemUselessArmor;
import xjon.jum.items.ItemUselessBow;
import xjon.jum.items.ItemUselessBro;
import xjon.jum.items.ItemUselessHoe;
import xjon.jum.items.ItemUselessMultitool;
import xjon.jum.items.ItemUselessPickaxe;
import xjon.jum.items.ItemUselessShovel;
import xjon.jum.items.ItemUselessSword;
import xjon.jum.util.Reference;
import xjon.jum.util.UselessConfiguration;

public class UselessItems {

	public static Item useless_material;
	public static Item super_useless_material;
	public static Item legitimate_diamond;
	
	public static Item useless_sword;
	public static Item useless_shovel;
	public static Item useless_pickaxe;
	public static Item useless_axe;
	public static Item useless_hoe;
	public static Item useless_multitool;
	
	public static Item useless_bro;
	public static Item useless_food;
	
	public static Item useless_helmet;
	public static Item useless_chestplate;
	public static Item useless_leggings;
	public static Item useless_boots;
	
	public static Item useless_bow;
	public static Item useless_arrow;
	
	public static Item.ToolMaterial uselessToolMaterial;
	public static ItemArmor.ArmorMaterial uselessArmorMaterial;

	public static int harvestLevel, maxUses, enchantability, armorHelm, armorChest, armorLeg, armorBoot, foodAmount;
	public static float efficiency, damage, foodSaturation;
	
	public static void checks()
	{	
		if(!UselessConfiguration.isUseless)
		{
			harvestLevel = 10;
			maxUses = 1000;
			enchantability = 100;
			efficiency = 10.0F;
			damage = 5.0F;
			
			armorHelm = 4;
			armorChest = 9;
			armorLeg = 7;
			armorBoot = 4;
			
			foodAmount = 8;
			foodSaturation = 3.0F;
		}
		else
		{
			harvestLevel = 0;
			maxUses = 11;
			enchantability = 1;
			efficiency = 0.5F;
			damage = 0.5F;
			
			armorHelm = 1;
			armorChest = 2;
			armorLeg = 2;
			armorBoot = 1;
			
			foodAmount = 2;
			foodSaturation = 0.5F;
		}
	}
	
	public static void init()
	{
		uselessToolMaterial = EnumHelper.addToolMaterial("uselessToolMaterial", harvestLevel, maxUses, efficiency, damage, enchantability);
	    uselessArmorMaterial = EnumHelper.addArmorMaterial("uselessArmorMaterial", "useless_armor", maxUses, new int []{armorHelm,armorChest,armorLeg,armorBoot}, enchantability);
		
		useless_material = new Item().setUnlocalizedName("useless_material").setCreativeTab(JumCore.tabJUM);
		super_useless_material = new ItemSuperUselessMaterial().setUnlocalizedName("super_useless_material").setCreativeTab(JumCore.tabJUM);
		legitimate_diamond = new Item().setUnlocalizedName("legitimate_diamond").setCreativeTab(JumCore.tabJUM);
		useless_sword = new ItemUselessSword(uselessToolMaterial).setUnlocalizedName("useless_sword").setCreativeTab(JumCore.tabJUM);
		useless_shovel = new ItemUselessShovel(uselessToolMaterial).setUnlocalizedName("useless_shovel").setCreativeTab(JumCore.tabJUM);
		useless_axe = new ItemUselessAxe(uselessToolMaterial).setUnlocalizedName("useless_axe").setCreativeTab(JumCore.tabJUM);
		useless_hoe = new ItemUselessHoe(uselessToolMaterial).setUnlocalizedName("useless_hoe").setCreativeTab(JumCore.tabJUM);
		useless_bro = new ItemUselessBro().setUnlocalizedName("useless_bro").setCreativeTab(JumCore.tabJUM);
		useless_pickaxe = new ItemUselessPickaxe(uselessToolMaterial).setUnlocalizedName("useless_pickaxe").setCreativeTab(JumCore.tabJUM);
		useless_food = new ItemFood(foodAmount, foodSaturation, true).setUnlocalizedName("useless_food").setCreativeTab(JumCore.tabJUM);
		useless_helmet = new ItemUselessArmor(uselessArmorMaterial, 0, 0).setUnlocalizedName("useless_helmet").setCreativeTab(JumCore.tabJUM);
		useless_chestplate = new ItemUselessArmor(uselessArmorMaterial, 0, 1).setUnlocalizedName("useless_chestplate").setCreativeTab(JumCore.tabJUM);
		useless_leggings = new ItemUselessArmor(uselessArmorMaterial, 0, 2).setUnlocalizedName("useless_leggings").setCreativeTab(JumCore.tabJUM);
		useless_boots = new ItemUselessArmor(uselessArmorMaterial, 0, 3).setUnlocalizedName("useless_boots").setCreativeTab(JumCore.tabJUM);
		useless_multitool = new ItemUselessMultitool(uselessToolMaterial).setUnlocalizedName("useless_multitool").setCreativeTab(JumCore.tabJUM);
		useless_bow = new ItemUselessBow().setUnlocalizedName("useless_bow").setCreativeTab(JumCore.tabJUM);
		useless_arrow = new Item().setUnlocalizedName("useless_arrow").setCreativeTab(JumCore.tabJUM);
	}
	
	public static void register()
	{
		GameRegistry.registerItem(useless_material, useless_material.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(super_useless_material, super_useless_material.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(legitimate_diamond, legitimate_diamond.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_sword, useless_sword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_axe, useless_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_shovel, useless_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_pickaxe, useless_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_hoe, useless_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_bro, useless_bro.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_food, useless_food.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_helmet, useless_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_chestplate, useless_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_leggings, useless_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_boots, useless_boots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_multitool, useless_multitool.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_bow, useless_bow.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(useless_arrow, useless_arrow.getUnlocalizedName().substring(5));
	}

	public static void registerRenders()
	{
		registerRender(useless_material);
		registerRender(super_useless_material);
		registerRender(legitimate_diamond);
		registerRender(useless_sword);
		registerRender(useless_shovel);
		registerRender(useless_axe);
		registerRender(useless_pickaxe);
		registerRender(useless_hoe);
		registerRender(useless_bro);
		registerRender(useless_food);
		registerRender(useless_helmet);
		registerRender(useless_chestplate);
		registerRender(useless_leggings);
		registerRender(useless_boots);
		registerRender(useless_multitool);
		registerRender(useless_bow);
		registerRender(useless_arrow);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
