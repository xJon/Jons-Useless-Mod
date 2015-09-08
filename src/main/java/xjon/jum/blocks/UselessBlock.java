package xjon.jum.blocks;

import java.util.Random;

import xjon.jum.init.UselessAchievements;
import xjon.jum.init.UselessBlocks;
import xjon.jum.init.UselessDimensions;
import xjon.jum.init.UselessItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class UselessBlock extends Block {

	public UselessBlock(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 5);
		this.setHardness(9.0F);
		this.setLightLevel(0.4F);
		this.setLightOpacity(10);
		this.setStepSound(this.soundTypeMetal);
		
	}
		
}
