package com.xplosivesnet;

import com.xplosivesnet.potions.genericPotion;

import net.minecraft.potion.Potion;

public class xPotions
{
	public static Potion radioactivity;
	
	public static void loadPotions()
	{
		radioactivity = new genericPotion("radioactivity");
	}
}
