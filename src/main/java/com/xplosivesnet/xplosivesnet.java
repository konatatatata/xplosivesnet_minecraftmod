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
    	xplosivesnet_tabs.loadTabs();
    	xplosivesnet_items.loadItems();
    	xplosivesnet_blocks.loadBlocks();
    	xplosivesnet_machines.loadMachines();
    	xplosivesnet_fluids.loadFluids();
    	xplosivesnet_ores.loadOres();
    	xplosivesnet_recipes.loadRecipes();
    	
    	
    	System.out.println("ID : ITEM");
		int i = 0;
		for (Item item : xplosivesnet_items.items)
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
		for (Block block : xplosivesnet_ores.blocks)
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
		for (Block block : xplosivesnet_blocks.blocks)
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
		for (Fluid fluid : xplosivesnet_fluids.fluids)
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
		
		
		FMLCommonHandler.instance().bus().register(new xplosivesnet_ticker());
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    }
    
    
}
