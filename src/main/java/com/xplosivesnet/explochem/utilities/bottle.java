package com.xplosivesnet.explochem.utilities;

import net.minecraft.item.Item;

import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;

public class bottle extends Item
{
	public bottle()
	{
		setMaxStackSize(1);
		setCreativeTab(explo_tabs.explo_tabs_components);
		setUnlocalizedName("bottle");
		setTextureName(explochem.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	
}
