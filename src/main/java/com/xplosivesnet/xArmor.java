package com.xplosivesnet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class xArmor
{
	public static boolean hasFullHazardArmor(EntityPlayer player)
	{
		ItemStack helmet = player.getCurrentArmor(0);
		ItemStack chestplate = player.getCurrentArmor(1);
		ItemStack leggins = player.getCurrentArmor(2);
		ItemStack boots = player.getCurrentArmor(3);
		
		if(helmet.getItem() == null) return false;
		
		if(helmet.getItem() != xItems.getItemById(19)) return false;
		if(chestplate.getItem() != xItems.getItemById(20)) return false;
		if(leggins.getItem() != xItems.getItemById(21)) return false;
		if(boots.getItem() != xItems.getItemById(22)) return false;
        
		return true;
	}
}
