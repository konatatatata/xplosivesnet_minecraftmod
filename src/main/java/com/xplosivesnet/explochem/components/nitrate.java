package com.xplosivesnet.explochem.components;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.xplosivesnet.explochem.xplosivesnet;

public class nitrate  extends Item
{
	public nitrate(String componentName, CreativeTabs tab, int maxStack)
	{
		setMaxStackSize(maxStack);
		setCreativeTab(tab);
		setUnlocalizedName(componentName);
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}