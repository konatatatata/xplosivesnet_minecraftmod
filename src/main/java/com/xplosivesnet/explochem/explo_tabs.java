package com.xplosivesnet.explochem;

import net.minecraft.creativetab.CreativeTabs;

import com.xplosivesnet.explochem.tabs.explo_tabs_components;
import com.xplosivesnet.explochem.tabs.explo_tabs_explosives;
import com.xplosivesnet.explochem.tabs.explo_tabs_machines;

public class explo_tabs
{
	public static CreativeTabs explo_tabs_components;
	public static CreativeTabs explo_tabs_explosives;
	public static CreativeTabs explo_tabs_machines;
	
	
	public static void loadTabs()
	{
		explo_tabs_components = new explo_tabs_components();
		explo_tabs_explosives = new explo_tabs_explosives();
		explo_tabs_machines = new explo_tabs_machines();
		
	}
}

