package xjon.jum.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xjon.jum.JumCore;
import xjon.jum.items.ItemBlockBetterUselessOre;
import xjon.jum.items.ItemBlockUselessMachine;
import xjon.jum.items.ItemBlockUselessOre;
import xjon.jum.items.ItemSuperUselessMaterial;
import xjon.jum.items.ItemUselessArmor;
import xjon.jum.items.ItemUselessAxe;
import xjon.jum.items.ItemUselessBow;
import xjon.jum.items.ItemUselessBro;
import xjon.jum.items.ItemUselessHoe;
import xjon.jum.items.ItemUselessMultitool;
import xjon.jum.items.ItemUselessPickaxe;
import xjon.jum.items.ItemUselessShovel;
import xjon.jum.items.ItemUselessSword;
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
			harvestLevel = 4;
			maxUses = 1000;
			enchantability = 100;
			efficiency = 10.0F;
			damage = 5.0F;
			
			armorHelm = 3;
			armorChest = 9;
			armorLeg = 6;
			armorBoot = 3;
			//84% damage reduction
			
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
			//24% damage reduction
			
			foodAmount = 2;
			foodSaturation = 0.5F;
		}
	}
	
	public static void init()
	{
		uselessToolMaterial = EnumHelper.addToolMaterial("uselessToolMaterial", harvestLevel, maxUses, efficiency, damage, enchantability);
	    uselessArmorMaterial = EnumHelper.addArmorMaterial("uselessArmorMaterial", "useless_armor", maxUses, new int []{armorHelm,armorChest,armorLeg,armorBoot}, enchantability, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, damage);
		
		useless_material = new Item().setUnlocalizedName("useless_material").setRegistryName("useless_material").setCreativeTab(JumCore.tabJUM);
		super_useless_material = new ItemSuperUselessMaterial().setUnlocalizedName("super_useless_material").setRegistryName("super_useless_material").setCreativeTab(JumCore.tabJUM);
		legitimate_diamond = new Item().setUnlocalizedName("legitimate_diamond").setRegistryName("legitimate_diamond").setCreativeTab(JumCore.tabJUM);
		useless_sword = new ItemUselessSword(uselessToolMaterial).setUnlocalizedName("useless_sword").setRegistryName("useless_sword").setCreativeTab(JumCore.tabJUM);
		useless_shovel = new ItemUselessShovel(uselessToolMaterial).setUnlocalizedName("useless_shovel").setRegistryName("useless_shovel").setCreativeTab(JumCore.tabJUM);
		useless_axe = new ItemUselessAxe(uselessToolMaterial).setUnlocalizedName("useless_axe").setRegistryName("useless_axe").setCreativeTab(JumCore.tabJUM);
		useless_hoe = new ItemUselessHoe(uselessToolMaterial).setUnlocalizedName("useless_hoe").setRegistryName("useless_hoe").setCreativeTab(JumCore.tabJUM);
		useless_bro = new ItemUselessBro().setUnlocalizedName("useless_bro").setRegistryName("useless_bro").setCreativeTab(JumCore.tabJUM);
		useless_pickaxe = new ItemUselessPickaxe(uselessToolMaterial).setUnlocalizedName("useless_pickaxe").setRegistryName("useless_pickaxe").setCreativeTab(JumCore.tabJUM);
		useless_food = new ItemFood(foodAmount, foodSaturation, true).setUnlocalizedName("useless_food").setRegistryName("useless_food").setCreativeTab(JumCore.tabJUM);
		useless_helmet = new ItemUselessArmor(uselessArmorMaterial, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("useless_helmet").setRegistryName("useless_helmet").setCreativeTab(JumCore.tabJUM);
		useless_chestplate = new ItemUselessArmor(uselessArmorMaterial, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("useless_chestplate").setRegistryName("useless_chestplate").setCreativeTab(JumCore.tabJUM);
		useless_leggings = new ItemUselessArmor(uselessArmorMaterial, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("useless_leggings").setRegistryName("useless_leggings").setCreativeTab(JumCore.tabJUM);
		useless_boots = new ItemUselessArmor(uselessArmorMaterial, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("useless_boots").setRegistryName("useless_boots").setCreativeTab(JumCore.tabJUM);
		useless_multitool = new ItemUselessMultitool(uselessToolMaterial).setUnlocalizedName("useless_multitool").setRegistryName("useless_multitool").setCreativeTab(JumCore.tabJUM);
		useless_bow = new ItemUselessBow().setUnlocalizedName("useless_bow").setRegistryName("useless_bow").setCreativeTab(JumCore.tabJUM);
		useless_arrow = new Item().setUnlocalizedName("useless_arrow").setRegistryName("useless_arrow").setCreativeTab(JumCore.tabJUM);
	}
	
	public static void registerItems()
	{
		GameRegistry.register(useless_material);
		GameRegistry.register(super_useless_material);
		GameRegistry.register(legitimate_diamond);
		GameRegistry.register(useless_sword);
		GameRegistry.register(useless_axe);
		GameRegistry.register(useless_shovel);
		GameRegistry.register(useless_pickaxe);
		GameRegistry.register(useless_hoe);
		GameRegistry.register(useless_bro);
		GameRegistry.register(useless_food);
		GameRegistry.register(useless_helmet);
		GameRegistry.register(useless_chestplate);
		GameRegistry.register(useless_leggings);
		GameRegistry.register(useless_boots);
		GameRegistry.register(useless_multitool);
		GameRegistry.register(useless_bow);
		GameRegistry.register(useless_arrow);
		}
	
	public static void registerItemBlocks()
	{
		GameRegistry.register(new ItemBlockBetterUselessOre(UselessBlocks.better_useless_ore), UselessBlocks.better_useless_ore.getRegistryName());
		GameRegistry.register(new ItemBlockUselessMachine(UselessBlocks.useless_machine), UselessBlocks.useless_machine.getRegistryName());
		GameRegistry.register(new ItemBlockUselessOre(UselessBlocks.useless_ore), UselessBlocks.useless_ore.getRegistryName());
		GameRegistry.register(new ItemBlock(UselessBlocks.legitimate_diamond_ore), UselessBlocks.legitimate_diamond_ore.getRegistryName());
		GameRegistry.register(new ItemBlock(UselessBlocks.useless_block), UselessBlocks.useless_block.getRegistryName());
		GameRegistry.register(new ItemBlock(UselessBlocks.useless_chest), UselessBlocks.useless_chest.getRegistryName());
		GameRegistry.register(new ItemBlock(UselessBlocks.super_useless_block), UselessBlocks.super_useless_block.getRegistryName());
		
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
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
