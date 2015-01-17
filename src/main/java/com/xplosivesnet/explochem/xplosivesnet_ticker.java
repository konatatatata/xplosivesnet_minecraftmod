package com.xplosivesnet.explochem;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class xplosivesnet_ticker
{
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		/*
		if(event.player.inventory.getCurrentItem() == new ItemStack(xplosivesnet_items.items[15]))
		{
			Helper.attack(event.player, explo_damageSource.acid, 0.5f);
		}
		*/
		
		if(event.player.getCurrentEquippedItem() != null)
	    {
			ItemStack hand = event.player.getCurrentEquippedItem();
	        if(hand.getItem() == xplosivesnet_items.items[17])
	        {
	        	Helper.addPotionEffect(event.player, Potion.weakness, 10);
        		Helper.attack(event.player, xplosivesnet_damageSource.radiation, 0.5f);
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
}
