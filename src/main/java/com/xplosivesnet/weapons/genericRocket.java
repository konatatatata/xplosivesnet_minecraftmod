package com.xplosivesnet.weapons;

import com.xplosivesnet.xTabs;

import net.minecraft.item.Item;

public class genericRocket extends Item
{
	public genericRocket(String name)
	{
		this.setUnlocalizedName(name);
		setCreativeTab(xTabs.weapons);
	}
}
