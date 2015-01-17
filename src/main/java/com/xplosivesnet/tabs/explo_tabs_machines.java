package com.xplosivesnet.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


public class explo_tabs_machines extends CreativeTabs
{

	public explo_tabs_machines()
	{
		super(CreativeTabs.getNextID(), "explo_tabs_machines");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return Items.beef;
	}
	
	

}
