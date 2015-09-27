package com.konatatatata;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xRecipes
{
	public static void loadRecipes()
	{
		//remove tnt recipe
		xHelper.removeRecipe(new ItemStack(Blocks.tnt));
		
		//building supplies
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
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("hardenedGlass"), 8), new Object[]
				{
					"xxx",
					"xix",
					"xxx",
			    	'i', Items.iron_ingot,
			    	'x', Blocks.glass
				});
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("reinforcedGlass"), 8), new Object[]
				{
					"xxx",
					"xix",
					"xxx",
			    	'i', xItems.getItemByName("titaniumIngot"),
			    	'x', xBlocks.getBlockByName("hardenedGlass")
				});
			
		//utilities & machines
		GameRegistry.addRecipe(new ItemStack(xItems.getItemByName("shell"), 16), new Object[]
				{
					"xcx",
					"c c",
					"xcx",
			    	'x', Items.iron_ingot,
			    	'c', Items.brick
				});
		//basic chemicals	
		
		//basic explosives
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("FLASH"), 2),
				xItems.getItemByName("sodiumNitrate"),
				xItems.getItemByName("sodiumNitrate"),
		        xItems.getItemByName("sulfur"),
		        xItems.getItemByName("carbon")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.gunpowder, 4),
		        xItems.getItemByName("FLASH")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("FLASH"), 1),
				Items.gunpowder,
				Items.gunpowder,
				Items.gunpowder,
				Items.gunpowder
		        );
		//explosive devices
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("mine"), 2), new Object[]
				{
			    	"sps",
			    	"sas",
			    	"srs",
			    	'p', Blocks.wooden_pressure_plate,
			    	'r', xItems.getItemByName("RDX"),
			    	'a', xItems.getItemByName("APEX"),
			    	's', xItems.getItemByName("shell")
				});
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("mine"), 2), new Object[]
				{
			    	"sps",
			    	"sas",
			    	"srs",
			    	'p', Blocks.wooden_pressure_plate,
			    	'r', xItems.getItemByName("RDX"),
			    	'a', xItems.getItemByName("HMTD"),
			    	's', xItems.getItemByName("shell")
				});
		
		//smelting
		GameRegistry.addSmelting(xOres.getBlockByName("sulfur"), new ItemStack(xItems.getItemByName("sulfurIngot")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("nitratine"), new ItemStack(xItems.getItemByName("nitratineIngot")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("uraninite"), new ItemStack(xItems.getItemByName("uraniumIngot")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("ilmenite"), new ItemStack(xItems.getItemByName("titaniumIngot")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("aluminosilicate"), new ItemStack(xItems.getItemByName("aluminiumIngot")), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockByName("magnesite"), new ItemStack(xItems.getItemByName("magnesiumIngot")), 0.5f);
		GameRegistry.addSmelting(xItems.getItemByName("water"), new ItemStack(xItems.getItemByName("distilledWater")), 0.5f);
		GameRegistry.addSmelting(new ItemStack(Items.potionitem, 1, 0), new ItemStack(xItems.getItemByName("distilledWater")), 0.5f);
		GameRegistry.addSmelting(xItems.getItemByName("carbon"), new ItemStack(xItems.getItemByName("acetone")), 0.5f);
		
		GameRegistry.addSmelting(xItems.getItemByName("sulphurDust"), new ItemStack(xItems.getItemByName("sulfurIngot")), 0.5f);
		GameRegistry.addSmelting(xItems.getItemByName("nitratineDust"), new ItemStack(xItems.getItemByName("nitratineIngot")), 0.5f);
		GameRegistry.addSmelting(xItems.getItemByName("titaniumDust"), new ItemStack(xItems.getItemByName("titaniumIngot")), 0.5f);
		GameRegistry.addSmelting(xItems.getItemByName("aluminiumDust"), new ItemStack(xItems.getItemByName("aluminiumIngot")), 0.5f);
		GameRegistry.addSmelting(xItems.getItemByName("magnesiumDust"), new ItemStack(xItems.getItemByName("magnesiumIngot")), 0.5f);
		
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
