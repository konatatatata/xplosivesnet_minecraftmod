package com.xplosivesnet.explochem.preComponents;

import com.xplosivesnet.explochem.xplosivesnet;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class genericComponent  extends Item
{
	public genericComponent(String componentName, CreativeTabs tab, int maxStack)
	{
		setMaxStackSize(maxStack);
		setCreativeTab(tab);
		setUnlocalizedName(componentName);
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
