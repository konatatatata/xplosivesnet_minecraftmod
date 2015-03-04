package com.xplosivesnet;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.xplosivesnet.tabs.genericTab;

import cpw.mods.fml.common.registry.GameRegistry;

public class xTabs
{
	public static CreativeTabs components;
	public static CreativeTabs explosives;
	public static CreativeTabs machines;
	public static CreativeTabs ores;
	public static CreativeTabs building;
	public static CreativeTabs weapons;
	
	
	
	public static void loadTabs()
	{
		
		components = new genericTab("components", getIconItem("components"));
		explosives = new genericTab("explosives", getIconItem("explosives"));
		machines = new genericTab("machines", getIconItem("machines"));
		ores = new genericTab("ores", getIconItem("ores"));
		building = new genericTab("building", getIconItem("building"));
		weapons = new genericTab("weapons", getIconItem("weapons"));
	}
	
	private static Item getIconItem(String name)
	{
		Item item = new Item();
		item.setUnlocalizedName(name);
		item.setTextureName(xplosivesnet.MODID + ":icons/" + item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item, item.getUnlocalizedName());
		return item;
	}
}

