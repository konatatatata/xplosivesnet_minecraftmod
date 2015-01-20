package com.xplosivesnet;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class xTicker
{
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		/*
		if(event.player.inventory.getCurrentItem() == new ItemStack(xItems.items[15]))
		{
			xHelper.attack(event.player, explo_damageSource.acid, 0.5f);
		}
		*/
		
		if(event.player.getCurrentEquippedItem() != null)
	    {
			ItemStack hand = event.player.getCurrentEquippedItem();
	        if(hand.getItem() == xItems.getItemByName("uraniniteIngot")) //uraniniteIngot
	        {
	        	xHelper.addPotionEffect(event.player, xPotions.radioactivity, 10);
        		xHelper.attack(event.player, xDamageSource.radiation, 0.5f);
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