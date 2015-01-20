package com.xplosivesnet;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = xplosivesnet.MODID, version = xplosivesnet.VERSION)
public class xplosivesnet
{
    public static final String MODID = "xplosivesnet";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	xTabs.loadTabs();
    	xItems.loadItems();
    	xBlocks.loadBlocks();
    	xMachines.loadMachines();
    	xFluids.loadFluids();
    	xOres.loadOres();
    	xRecipes.loadRecipes();
    	
    	
    	System.out.println("ID : ITEM");
		int i = 0;
		for (Item item : xItems.items)
		{
			try
			{
				System.out.println(i + " : " + item.getUnlocalizedName());
				i++;
		    }
		    catch (NullPointerException e)
			{
		        
		    }
		}
		
		System.out.println("ID : BLOCK : ORE");
		int j = 0;
		for (Block block : xOres.blocks)
		{
			try
			{
				System.out.println(j + " : " + block.getUnlocalizedName());
				j++;
		    }
		    catch (NullPointerException e)
			{
		        
		    }
		}
		
		System.out.println("ID : BLOCK");
		int k = 0;
		for (Block block : xBlocks.blocks)
		{
			try
			{
				System.out.println(k + " : " + block.getUnlocalizedName());
				k++;
		    }
		    catch (NullPointerException e)
			{
		        
		    }
		}
		
		System.out.println("ID : BLOCK : FLUID");
		int l = 0;
		for (Fluid fluid : xFluids.fluids)
		{
			try
			{
				System.out.println(l + " : " + fluid.getUnlocalizedName());
				l++;
		    }
		    catch (NullPointerException e)
			{
		        
		    }
		}
		
		
		FMLCommonHandler.instance().bus().register(new xTicker());
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    }
    
    
}
