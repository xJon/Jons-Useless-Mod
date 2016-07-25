package xjon.jum.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class UselessBlock extends Block {

	public UselessBlock(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 5);
		this.setHardness(9.0F);
		this.setLightLevel(0.4F);
		this.setLightOpacity(10);
		this.setSoundType(SoundType.METAL);
	}
		
}
