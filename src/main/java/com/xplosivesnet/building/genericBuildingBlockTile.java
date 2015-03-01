package com.xplosivesnet.building;

import com.xplosivesnet.xHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class genericBuildingBlockTile extends TileEntity
{
	String owner = "unknown";
	boolean playerSet = false;
	
	public genericBuildingBlockTile()
	{
		
	}
	
	public String getOwner()
	{
		return this.owner;
		
	}
	
	public void setOwner(EntityPlayer player)
	{
		if(playerSet == false)
		{
			owner = player.getDisplayName();
			xHelper.sendMessage(player, "Owner set");
		}
		else
		{
			xHelper.sendMessage(player, "Owner already set");
		}
	}
}
