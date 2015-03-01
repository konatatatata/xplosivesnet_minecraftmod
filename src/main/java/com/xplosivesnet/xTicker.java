package com.xplosivesnet;

import com.xplosivesnet.building.genericBuildingBlockTile;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class xTicker
{
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		if(event.player.getCurrentEquippedItem() != null)
	    {
			ItemStack hand = event.player.getCurrentEquippedItem();
	        if(hand.getItem() == xItems.getItemByName("uraniumIngot"))
	        {
	        	if(!xArmor.hasFullHazardArmor(event.player))
	        	{
	        		//xHelper.addPotionEffect(event.player, xPotions.radioactivity, 10);
	        		//xHelper.attack(event.player, xDamageSource.radiation, 0.5f);
	        	}
	         }
	     }
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
