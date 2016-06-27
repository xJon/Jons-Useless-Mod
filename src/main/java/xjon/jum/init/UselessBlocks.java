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
		useless_block = new UselessBlock(Material.CLOTH).setUnlocalizedName("useless_block").setCreativeTab(JumCore.tabJUM);
		super_useless_block = new SuperUselessBlock(Material.CLOTH).setUnlocalizedName("super_useless_block").setCreativeTab(JumCore.tabJUM);
		useless_ore = new UselessOre(Material.ROCK).setUnlocalizedName("useless_ore").setCreativeTab(JumCore.tabJUM);
		better_useless_ore = new BetterUselessOre(Material.ROCK).setUnlocalizedName("better_useless_ore").setCreativeTab(JumCore.tabJUM);
		legitimate_diamond_ore = new LegitimateDiamondOre(Material.ROCK).setUnlocalizedName("legitimate_diamond_ore").setCreativeTab(JumCore.tabJUM);
		useless_machine = new UselessMachine(Material.ROCK).setUnlocalizedName("useless_machine").setCreativeTab(JumCore.tabJUM);
		useless_chest = new UselessChest().setUnlocalizedName("useless_chest").setCreativeTab(JumCore.tabJUM);
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(useless_block, useless_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(super_useless_block, super_useless_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(useless_ore, ItemBlockUselessOre.class, useless_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(better_useless_ore, ItemBlockBetterUselessOre.class, better_useless_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(legitimate_diamond_ore, legitimate_diamond_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(useless_machine, ItemBlockUselessMachine.class, useless_machine.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(useless_chest, useless_chest.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(useless_block);
		registerRender(super_useless_block);
		registerRender(useless_ore);
		registerRender(better_useless_ore);
		registerRender(legitimate_diamond_ore);
		registerRender(useless_machine);
		registerRender(useless_chest);
	}
	
	public static void registerRender(Block block)
	{
		
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
