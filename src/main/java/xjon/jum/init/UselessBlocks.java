package xjon.jum.init;

import xjon.jum.JumCore;
import xjon.jum.blocks.BetterUselessOre;
import xjon.jum.blocks.LegitimateDiamondOre;
import xjon.jum.blocks.SuperUselessBlock;
import xjon.jum.blocks.UselessBlock;
import xjon.jum.blocks.UselessChest;
import xjon.jum.blocks.UselessMachine;
import xjon.jum.blocks.UselessOre;
import xjon.jum.items.ItemBlockBetterUselessOre;
import xjon.jum.items.ItemBlockUselessMachine;
import xjon.jum.items.ItemBlockUselessOre;
import xjon.jum.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UselessBlocks {

	public static Block useless_block;
	public static Block super_useless_block;
	public static Block useless_ore;
	public static Block better_useless_ore;
	public static Block legitimate_diamond_ore;
	public static Block useless_machine;
	public static Block useless_chest;
	
	public static void init()
	{
		useless_block = new UselessBlock(Material.CLOTH).setUnlocalizedName("useless_block").setRegistryName("useless_block").setCreativeTab(JumCore.tabJUM);
		super_useless_block = new SuperUselessBlock(Material.CLOTH).setUnlocalizedName("super_useless_block").setRegistryName("super_useless_block").setCreativeTab(JumCore.tabJUM);
		useless_ore = new UselessOre(Material.ROCK).setUnlocalizedName("useless_ore").setRegistryName("useless_ore").setCreativeTab(JumCore.tabJUM);
		better_useless_ore = new BetterUselessOre(Material.ROCK).setUnlocalizedName("better_useless_ore").setRegistryName("better_useless_ore").setCreativeTab(JumCore.tabJUM);
		legitimate_diamond_ore = new LegitimateDiamondOre(Material.ROCK).setUnlocalizedName("legitimate_diamond_ore").setRegistryName("legitimate_diamond_ore").setCreativeTab(JumCore.tabJUM);
		useless_machine = new UselessMachine(Material.ROCK).setUnlocalizedName("useless_machine").setRegistryName("useless_machine").setCreativeTab(JumCore.tabJUM);
		useless_chest = new UselessChest().setUnlocalizedName("useless_chest").setRegistryName("useless_chest").setCreativeTab(JumCore.tabJUM);
	}
	
	public static void register()
	{
		GameRegistry.register(useless_block);
		GameRegistry.register(super_useless_block);
		GameRegistry.register(useless_ore);
		GameRegistry.register(better_useless_ore);
		GameRegistry.register(legitimate_diamond_ore);
		GameRegistry.register(useless_machine);
		GameRegistry.register(useless_chest);
	}
	
	public static void registerRenders()
	{
		registerRender(useless_ore);
		registerRender(better_useless_ore);
		registerRender(useless_block);
		registerRender(super_useless_block);
		registerRender(legitimate_diamond_ore);
		registerRender(useless_machine);
		registerRender(useless_chest);
	}
	
	public static void registerRender(Block block)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
