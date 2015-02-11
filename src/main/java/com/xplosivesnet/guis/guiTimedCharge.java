package com.xplosivesnet.guis;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.explosives.entities.timedChargeTile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class guiTimedCharge extends GuiScreen
{
	int guiWidth = 148;
	int guiHeight = 80;
	int sec = 0;
	
	GuiButton buttonInc;
	GuiButton buttonDec;
	
	timedChargeTile tile;
	
	public guiTimedCharge(timedChargeTile t)
	{
		this.tile = t;
	}
	
	
	public void drawScreen(int x, int y, float ticks)
    {
		
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		GL11.glColor4f(1, 1, 1, 1);
		
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(xplosivesnet.MODID, "textures/gui/test.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		fontRendererObj.drawString("Controls:" , guiX + 10, guiY + 5, 0x404040);
		fontRendererObj.drawString("E - increase" , guiX + 15, guiY + 15, 0x404040);
		fontRendererObj.drawString("Q - decrease" , guiX + 15, guiY + 25, 0x404040);
		fontRendererObj.drawString("w - fuse" , guiX + 15, guiY + 35, 0x404040);
		
		fontRendererObj.drawString("Time left: "+tile.getSecondsLeft() , guiX + 40, guiY + 45, 0x404040);
		super.drawScreen(x, y, ticks);
		
    }
	
	@Override
	public void initGui()
	{
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		buttonList.clear();
		
		super.initGui();
	}
	
	@Override
	public boolean doesGuiPauseGame()
    {
        return false;
    }
	
	@Override
	protected void keyTyped(char c, int key)
	{
		switch(key)
		{
		case Keyboard.KEY_E:
			tile.increaseTime();
			break;
		case Keyboard.KEY_Q:
			tile.decreaseTime();
			break;
		case Keyboard.KEY_W:
			tile.fuse();
		}
		
		super.keyTyped(c, key);
	}
	
}
