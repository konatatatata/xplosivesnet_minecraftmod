package com.xplosivesnet;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;

import com.xplosivesnet.tabs.genericTab;

public class xTabs
{
	public static CreativeTabs components;
	public static CreativeTabs explosives;
	public static CreativeTabs machines;
	public static CreativeTabs ores;
	public static CreativeTabs building;
	
	
	public static void loadTabs()
	{
		components = new genericTab("components", Items.apple);
		explosives = new genericTab("explosives", Items.apple);
		machines = new genericTab("machines", Items.apple);
		ores = new genericTab("ores", Items.apple);
		building = new genericTab("buildung", Items.apple);
		
	}
}

