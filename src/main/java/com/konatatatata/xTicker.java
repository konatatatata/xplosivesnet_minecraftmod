package com.konatatatata;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class xTicker
{
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		
	}
	 
	//Called when the client ticks. 
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event)
	{

	}
	 
	//Called when the server ticks. Usually 20 ticks a second. 
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event)
	{

	}
	 
	//Called when a new frame is displayed (See fps) 
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event)
	{

	}
	 
	//Called when the world ticks
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event)
	{

	}
	
	/*
	@SubscribeEvent
	public void onBreakBlock(BreakEvent event, Block block, EntityPlayer player, int meta)
	{
		TileEntity entity = event.world.getTileEntity(event.x, event.y, event.z);
		if(entity instanceof genericBuildingBlockTile)
		{
			genericBuildingBlockTile xEntity = (genericBuildingBlockTile) entity;
			if(xEntity.getOwner()!=null)
			{
				if(xEntity.getOwner() != player.getDisplayName())
				{
					event.setCanceled(true);
				}
			}
		}
	}
	*/
}
