package xjon.jum.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SuperUselessBlock extends Block{
	
	public SuperUselessBlock(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 5);
		this.setHardness(12.0F);
		this.setLightLevel(0.4F);
		this.setLightOpacity(10);
		this.setSoundType(blockSoundType.METAL);
		
	}

}
