package com.xplosivesnet.explochem.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


public class explo_tabs_components extends CreativeTabs
{

	public explo_tabs_components()
	{
		super(CreativeTabs.getNextID(), "explo_tabs_components");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return Items.book;
	}
	
	

}
