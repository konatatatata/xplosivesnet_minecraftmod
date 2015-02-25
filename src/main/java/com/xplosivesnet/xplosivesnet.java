package com.xplosivesnet;

import java.net.Proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = xplosivesnet.MODID, version = xplosivesnet.VERSION)
public class xplosivesnet
{
    public static final String MODID = "realistic_explosives";
    public static final String VERSION = "1.5.1";
    @SidedProxy(clientSide="com.xplosivesnet.xCommonClientProxy", serverSide="com.xplosivesnet.xCommonProxy")
	public static xCommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//xPotions.loadPotions();
    	xTabs.loadTabs();
    	xBlocks.loadBlocks();
    	xItems.loadItems();
    	xMachines.loadMachines();
    	xFluids.loadFluids();
    	xOres.loadOres();
    	xRecipes.loadRecipes();
    	xSynthesisHandler.loadSynthesis();
    	//xWeapons.loadWeapons();
    	
		this.proxy.init(event);
		
		FMLCommonHandler.instance().bus().register(new xTicker());
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	this.proxy.preInit(event);
    }
    
    
}
