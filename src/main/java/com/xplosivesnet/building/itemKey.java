package com.xplosivesnet.building;

import com.xplosivesnet.xTabs;

import net.minecraft.item.Item;

public class itemKey extends Item
{
	public itemKey(String itemName)
	{
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(xTabs.building);
	}
}
