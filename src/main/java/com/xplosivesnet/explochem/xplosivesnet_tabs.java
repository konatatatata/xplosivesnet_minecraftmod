package com.xplosivesnet.explochem;

import net.minecraft.creativetab.CreativeTabs;

import com.xplosivesnet.explochem.tabs.explo_tabs_components;
import com.xplosivesnet.explochem.tabs.explo_tabs_explosives;
import com.xplosivesnet.explochem.tabs.explo_tabs_machines;
import com.xplosivesnet.explochem.tabs.tabs_ores;

public class xplosivesnet_tabs
{
	public static CreativeTabs components;
	public static CreativeTabs explosives;
	public static CreativeTabs machines;
	public static CreativeTabs ores;
		
	public static void loadTabs()
	{
		components = new explo_tabs_components();
		explosives = new explo_tabs_explosives();
		machines = new explo_tabs_machines();
		ores = new tabs_ores();
	}
}

