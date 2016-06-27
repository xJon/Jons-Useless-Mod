package xjon.jum.blocks;

import java.util.Random;

import xjon.jum.init.UselessItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BetterUselessOre extends Block {
	
	public BetterUselessOre(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 3);
		this.setHardness(9.0F);
		this.setSoundType(blockSoundType.STONE);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rnd, int fortune)
	{
		return UselessItems.super_useless_material;
	}
	
	@Override
	public int quantityDropped(Random rnd)
	{
		return 1;
	}

}
