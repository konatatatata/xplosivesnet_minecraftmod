package com.xplosivesnet;

import ic2.api.item.IC2Items;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class xRecipes
{
	public static void loadRecipes()
	{
		//remove
		//disable tnt
		xHelper.removeRecipe(new ItemStack(Blocks.tnt));
		xHelper.removeRecipe(ic2.api.item.IC2Items.getItem("industrialTnt"));
		
		
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
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("timedCharge"), 2), new Object[]
				{
			    	"iii",
			    	"c a",
			    	"iii",
			    	'c', Items.clock,
			    	'a', xBlocks.getBlockByName("APEX"),
			    	'i', Items.iron_ingot
				});
		GameRegistry.addRecipe(new ItemStack(xBlocks.getBlockByName("timedCharge"), 2), new Object[]
				{
			    	"iii",
			    	"c h",
			    	"iii",
			    	'c', Items.clock,
			    	'h', xBlocks.getBlockByName("HMTD"),
			    	'i', Items.iron_ingot
				});
		
		//filling s.t. in bottle
		//ingots
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("sulfur"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("sulfurIngot")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("titanium"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("titaniumIngot")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("aluminium"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("aluminiumIngot")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("magnesium"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("magnesiumIngot")
		        );
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("sodiumNitrate"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("nitratineIngot")
		        );
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("carbon"), 1),
		        xItems.getItemByName("bottle"),
		        ic2.api.item.IC2Items.getItem("coalDust")
		        );
		
		//bottle<>cell
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("water"), 1),
		        ic2.api.item.IC2Items.getItem("waterCell")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(ic2.api.item.IC2Items.getItem("waterCell").getItem(), 1),
				xItems.getItemByName("water")
		        );
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(ic2.api.item.IC2Items.getItem("cell").getItem(), 1),
				xItems.getItemByName("bottle")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("bottle"), 1),
				ic2.api.item.IC2Items.getItem("cell").getItem()
		        );
		
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("electrolyzer"), 1),
		        xItems.getItemByName("bottle"),
		        ic2.api.item.IC2Items.getItem("suBattery")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("heater"), 1),
		        xItems.getItemByName("bottle"),
		        Items.redstone
		        );
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("ammonia"), 2),
		        xItems.getItemByName("distilledWater"),
		        Items.rotten_flesh
		        );
		
		//crafting explosives
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.gunpowder, 5),
				xItems.getItemByName("sodiumNitrate"),
				xItems.getItemByName("sodiumNitrate"),
				xItems.getItemByName("sodiumNitrate"),
		        xItems.getItemByName("sulfur"),
		        xItems.getItemByName("carbon")
		        );

		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("dynamite"), 1),
				xItems.getItemByName("nitroGlycerine"),
				Blocks.sand
		        );
		
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
		
		for(String name : xBlocks.blockNamesExplosives)
		{
			if(name == null) break;
			addShellRecipe(name);
		}
		
		//addMaceratorRecipe("nitratineIngot", "sodiumNitrate");
		//addMaceratorRecipe("titaniumIngot", "titanium");
		//addMaceratorRecipe("aluminiumIngot", "aluminium");
		//addMaceratorRecipe("magnesiumIngot", "magnesium");
	}
	
	static void addMaceratorRecipe(String input, String output)
	{
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(xItems.getItemByName(input))), null, new ItemStack(xItems.getItemByName(output)));
	}
	
	static void addFLASH(String dust)
	{
		GameRegistry.addShapelessRecipe(
			new ItemStack(xItems.getItemByName("FLASH"), 2),
			xItems.getItemByName("sodiumNitrate"),
			xItems.getItemByName("sodiumNitrate"),
			IC2Items.getItem(dust)
			);
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
