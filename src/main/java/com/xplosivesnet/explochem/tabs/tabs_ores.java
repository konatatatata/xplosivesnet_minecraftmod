package com.xplosivesnet.explochem.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class tabs_ores extends CreativeTabs
{
	public tabs_ores()
	{
		super(CreativeTabs.getNextID(), "explo_tabs_ores");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return Items.coal;
	}
}
