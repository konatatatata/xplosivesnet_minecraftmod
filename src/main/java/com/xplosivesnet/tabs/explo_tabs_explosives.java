package com.xplosivesnet.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class explo_tabs_explosives extends CreativeTabs
{

	public explo_tabs_explosives()
	{
		super(CreativeTabs.getNextID(), "explo_tabs_explosives");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return Items.gunpowder;
	}
	
	

}
