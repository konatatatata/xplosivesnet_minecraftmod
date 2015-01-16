package com.xplosivesnet.explochem;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = xplosivesnet.MODID, version = xplosivesnet.VERSION)
public class xplosivesnet
{
    public static final String MODID = "explochem";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	xplosivesnet_tabs.loadTabs();
    	xplosivesnet_items.loadItems();
    	xplosivesnet_blocks.loadBlocks();
    	xplosivesnet_machines.loadMachines();
    	xplosivesnet_fluids.loadFluids();
    	xplosivesnet_recipes.loadRecipes();
    	xplosivesnet_ores.loadOres();
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    }
    
    
}
