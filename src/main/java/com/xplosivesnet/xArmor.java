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
		
		if(helmet == null) return false;
		if(chestplate == null) return false;
		if(leggins == null) return false;
		if(boots == null) return false;
		
		if(helmet.getItem() != xItems.getItemByName("hazmaHelmet")) return false;
		if(chestplate.getItem() != xItems.getItemByName("hazmaChestplate")) return false;
		if(leggins.getItem() != xItems.getItemByName("hazmaLeggins")) return false;
		if(boots.getItem() != xItems.getItemByName("hazmaBoots")) return false;
        
		return true;
	}
}
