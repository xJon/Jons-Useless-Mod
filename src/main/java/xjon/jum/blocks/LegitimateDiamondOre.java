package xjon.jum.blocks;

import java.util.Random;

import xjon.jum.init.UselessItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class LegitimateDiamondOre extends Block {
	

	public LegitimateDiamondOre(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(4.5F);
		this.setStepSound(this.soundTypeStone);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rnd, int fortune)
	{
		return UselessItems.legitimate_diamond;
	}
	
	@Override
	public int quantityDropped(Random rnd)
	{
		return 1;
	}

}
