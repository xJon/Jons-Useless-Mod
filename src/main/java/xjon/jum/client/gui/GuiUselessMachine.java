package xjon.jum.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xjon.jum.util.Reference;
import xjon.jum.util.UselessConfiguration;

public class GuiUselessMachine extends GuiScreen{

	int guiWidth = 176;
    int guiHeight = 165;
    
	int guiX = (width - guiWidth) / 2;
	int guiY = (height - guiHeight) / 2;
	
	GuiButton tpButton;
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
	int guiX = (width - guiWidth) / 2;
	int guiY = (height - guiHeight) / 2;
	GL11.glColor4f(1, 1, 1, 1);
	drawDefaultBackground();
	mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/useless_machine.png"));
    drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
	
	super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui()
	{
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		buttonList.clear();
		if(!UselessConfiguration.isUseless)
		{
			buttonList.add(tpButton = new GuiButton(0, guiX + guiWidth / 2 - 30, guiY + guiWidth / 2 - 30, 60, 20, "Click to go!"));
		}
		else
			{
			buttonList.add(tpButton = new GuiButton(0, guiX + guiWidth / 2 - 30, guiY + guiWidth / 2 - 30, 120, 20, "Click to NOPE!"));
			};
		
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException 
	{
		switch(button.id)
		{
		case 0:
			if(!UselessConfiguration.isUseless)
			{
		    Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("jum:waiting")));
			}
			else
			{
			Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("jum:nope")));
			}
			break;
		}
		super.actionPerformed(button);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		switch(keyCode)
		{
		case Keyboard.KEY_E:
			Minecraft.getMinecraft().getSoundHandler().stopSounds();
			mc.displayGuiScreen(null);
			break;
			
		case Keyboard.KEY_ESCAPE:
			Minecraft.getMinecraft().getSoundHandler().stopSounds();
			break;
			
		}
		
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException 
	{
		
		
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	private int getTopBlock(World world, BlockPos pos)
	   {
	      int j;
	      int y=-1;
	      int k=0;
	      
	      boolean topBlock = false;
	      
	      
	      for ( j=255; j>=63; j--)
	      {
	         if (!world.getBlockState(pos.add(0, j, 0)).getBlock().equals(Blocks.AIR))
	         {
	            topBlock=true;
	            k++;
	            
	         }
	         if (topBlock && (k==1))
	         {
	            y=j;
	         }
	         
	         
	      }
	      	      
	      return y;
	   }
}
