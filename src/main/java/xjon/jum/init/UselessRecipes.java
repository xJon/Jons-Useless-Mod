package xjon.jum.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UselessRecipes {

	public static void register()
	{
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_sword), "U","U","S", 'U', UselessItems.useless_material, 'S', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_axe), "UU","US"," S", 'U', UselessItems.useless_material, 'S', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_hoe), "UU"," S"," S", 'U', UselessItems.useless_material, 'S', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_bro), "H",'H', UselessItems.useless_hoe);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_pickaxe), "UUU"," S "," S ", 'U', UselessItems.useless_material, 'S', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_shovel), "U","S","S", 'U', UselessItems.useless_material, 'S', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_helmet), "UUU","U U", 'U', UselessItems.useless_material);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_chestplate), "U U","UUU","UUU", 'U', UselessItems.useless_material);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_leggings), "UUU","U U","U U", 'U', UselessItems.useless_material);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_boots), "U U","U U", 'U', UselessItems.useless_material);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_bow), " US", "U S", " US", 'U', UselessItems.useless_material, 'S', Items.STRING);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_arrow, 4), "T", "U", "F", 'T', Items.FLINT, 'U', UselessItems.useless_material, 'F', Items.FEATHER);
		GameRegistry.addRecipe(new ItemStack(UselessItems.useless_multitool), "ASP","D$D", "BHB", 'P', UselessItems.useless_pickaxe, '$', UselessItems.useless_shovel, 'A', UselessItems.useless_axe, 'B', UselessBlocks.super_useless_block, 'S', UselessItems.useless_sword, 'D', Blocks.DIAMOND_BLOCK, 'H', UselessItems.useless_hoe);
		GameRegistry.addRecipe(new ItemStack(UselessBlocks.useless_block), "UUU","UUU","UUU", 'U', UselessItems.useless_material);
		GameRegistry.addRecipe(new ItemStack(UselessBlocks.super_useless_block), "UUU","UUU","UUU", 'U', UselessItems.super_useless_material);
		GameRegistry.addRecipe(new ItemStack(UselessBlocks.useless_chest), "UUU","U U", "UUU", 'U', UselessItems.useless_material);
		GameRegistry.addRecipe(new ItemStack(UselessBlocks.useless_machine), "QGQ","DRD", "ULU", 'Q', Blocks.QUARTZ_BLOCK, 'L', Blocks.SEA_LANTERN, 'D', Items.DIAMOND, 'R', Blocks.REDSTONE_BLOCK, 'U', UselessBlocks.useless_block, 'G', Items.GLOWSTONE_DUST);
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(UselessItems.useless_material, 9), new ItemStack(UselessBlocks.useless_block));
		GameRegistry.addShapelessRecipe(new ItemStack(UselessItems.super_useless_material, 9), new ItemStack(UselessBlocks.super_useless_block));
		
		GameRegistry.addSmelting(UselessItems.useless_material, new ItemStack(UselessItems.useless_food), 3.0F);
		GameRegistry.addSmelting(UselessBlocks.useless_ore, new ItemStack(UselessItems.useless_material), 5.0F);
		GameRegistry.addSmelting(UselessBlocks.better_useless_ore, new ItemStack(UselessItems.super_useless_material), 7.0F);
		GameRegistry.addSmelting(UselessBlocks.legitimate_diamond_ore, new ItemStack(UselessItems.legitimate_diamond), 1.0F);
	}
	
}
