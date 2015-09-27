package com.konatatatata.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class genericTab extends CreativeTabs
{
	public Item icon;
	public genericTab(String name, Item icon)
	{
		super(CreativeTabs.getNextID(), name);
		this.icon = icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return icon;
	}
	
	public void setIcon(Item item)
	{
		this.icon = item;
	}
}
