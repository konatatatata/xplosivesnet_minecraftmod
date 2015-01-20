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
		
		if(helmet.getItem() != xItems.items[19]) return false;
		if(chestplate.getItem() != xItems.items[20]) return false;
		if(leggins.getItem() != xItems.items[21]) return false;
		if(boots.getItem() != xItems.items[22]) return false;
        
		return true;
	}
}
