package com.xplosivesnet.explochem;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = explochem.MODID, version = explochem.VERSION)
public class explochem
{
    public static final String MODID = "explochem";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	explo_tabs.loadTabs();
		explo_items.loadItems();
    	explo_blocks.loadBlocks();
    	explo_machines.loadMachines();
    	explo_fluids.loadFluids();
    	explo_recipes.loadRecipes();
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    }
    
    
}
