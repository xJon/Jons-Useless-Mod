package xjon.jum.world.dimension;

import xjon.jum.init.UselessBiomes;
import xjon.jum.init.UselessDimensions;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderUseless extends WorldProvider {

	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(UselessBiomes.biomeUseless, 1.2F);
		this.dimensionId = UselessDimensions.dimensionId;
		isHellWorld = false;
	}

	@Override
	public String getSaveFolder() {
		return "UselessDim";
	}

	@Override
	public float getCloudHeight() {
		return 128.0F;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setSkyRenderer(IRenderHandler skyRenderer) {
		super.setSkyRenderer(new UselessSkyRenderer());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float f1, float f2) {
		return new Vec3(1.2, 1.2, 1);
	}

	public IChunkProvider createChunkGeneration() {
		return new ChunkProviderUseless(this.worldObj, this.worldObj.getSeed());
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float calculateCelestialAngle(long var1, float var3) {
		return 0.1F;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		return 0;
	}

	@Override
	public String getDimensionName() {
		return "Useless Dimension";
	}

	@Override
	public String getInternalNameSuffix() {
		return "Useless Dimension";
	}
	
	@Override
	public String getWelcomeMessage() {
		return "You are wasting your time.";
	}


}
