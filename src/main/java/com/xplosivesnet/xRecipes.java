package com.xplosivesnet;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class xRecipes
{
	public static void loadRecipes()
	{
		//crafting
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("detonatingCord"), 6), new Object[]
			{
		    	"sss",
		    	"xxx",
		    	"sss",
		    	's', Items.string,
		    	'x', xBlocks.getBlockByName("PETN")
			});
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("quickFuse"), 16), new Object[]
				{
			    	"sss",
			    	"xxx",
			    	"sss",
			    	's', Items.string,
			    	'x', Items.gunpowder
				});
		
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("concrete"), 8), new Object[]
				{
			    	"xcx",
			    	"cxc",
			    	"xcx",
			    	'c', Items.clay_ball,
			    	'x', Blocks.stone
				});
		
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("hardenedConcrete"), 8), new Object[]
				{
					"xxx",
					"xix",
					"xxx",
			    	'i', Items.iron_ingot,
			    	'x', xBlocks.getBlockByName("concrete")
				});
		
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("reinforcedConcrete"), 8), new Object[]
				{
					"xxx",
					"xix",
					"xxx",
			    	'i', xItems.getItemByName("titaniumIngot"),
			    	'x', xBlocks.getBlockByName("hardenedConcrete")
				});
		
		GameRegistry.addRecipe(new ItemStack(xItems.getItemByName("bottle"), 1), new Object[]
				{
					"x",
			    	'x', Items.glass_bottle
				});
		
		GameRegistry.addRecipe(new ItemStack(Items.glass_bottle, 1), new Object[]
				{
					"x",
			    	'x', xItems.getItemByName("bottle")
				});
		
		GameRegistry.addRecipe(new ItemStack(xItems.getItemByName("shell"), 16), new Object[]
				{
					"xcx",
					"c c",
					"xcx",
			    	'x', Items.iron_ingot,
			    	'c', Items.brick
				});
		
		GameRegistry.addRecipe(new ItemStack(xMachines.reactionVessel, 1), new Object[]
				{
					"xix",
					"oxo",
					"xxx",
			    	'x', xBlocks.getBlockByName("concrete"),
			    	'o', xItems.getItemByName("titaniumIngot"),
			    	'i', Items.blaze_rod
				});
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("sulfur"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("sulfurIngot")
		        );
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("aluminium"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("aluminiumIngot")
		        );
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("carbon"), 1),
		        xItems.getItemByName("bottle"),
		        Items.coal
		        );
		
		//smelting
		GameRegistry.addSmelting(xOres.getBlockByName("sulfur"), new ItemStack(xItems.getItemByName("sulfurIngot")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("nitratine"), new ItemStack(xItems.getItemByName("sodiumNitrate")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("uraninite"), new ItemStack(xItems.getItemByName("uraniumIngot")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("ilmenite"), new ItemStack(xItems.getItemByName("titaniumIngot")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("aluminosilicate"), new ItemStack(xItems.getItemByName("aluminiumIngot")), 0.5f);
		
		for(String name : xBlocks.blockNamesExplosives)
		{
			if(name == null) break;
			addShellRecipe(name);
		}
		
	}
	
	static void addShellRecipe(String n)
	{
		GameRegistry.addShapelessRecipe(
				new ItemStack(xBlocks.getBlockByName(n), 1),
		        xItems.getItemByName("shell"),
		        xItems.getItemByName(n)
		        );
	}
}
