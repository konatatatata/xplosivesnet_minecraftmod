package com.konatatatata;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = xRealisticExplosives.MODID, version = xRealisticExplosives.VERSION)
public class xRealisticExplosives
{
    public static final String MODID = "realistic_explosives";
    public static final String VERSION = "1.5.3.1";
    @SidedProxy(clientSide="com.konatatatata.xCommonClientProxy", serverSide="com.konatatatata.xCommonProxy")
	public static xCommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {	
    	
    	xTabs.loadTabs();
    	xBlocks.loadBlocks();
    	xItems.loadItems();
    	xMachines.loadMachines();
    	xFluids.loadFluids();
    	xOres.loadOres();
    	
    	xWeapons.loadWeapons();
    	xAchievements.loadAchivements();
    	xRecipes.loadRecipes();
    	
		this.proxy.init(event);
		FMLCommonHandler.instance().bus().register(new xTicker());
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	this.proxy.preInit(event);
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
    	
    }
    
    
}
