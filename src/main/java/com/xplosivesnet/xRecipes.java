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
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("bottle"), 1),
		        Items.glass_bottle
		        );
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.glass_bottle, 1),
				xItems.getItemByName("bottle")
		        );
		
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
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("carbon"), 1),
		        xItems.getItemByName("bottle"),
		        new ItemStack(Items.coal, 1, 1)
		        );
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("sodiumNitrate"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("nitratineIngot")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("magnesium"), 1),
		        xItems.getItemByName("bottle"),
		        xItems.getItemByName("magnesiumIngot")
		        );
		
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("water"), 1),
		        new ItemStack(Items.potionitem, 1, 0)
		        );
		//just beta recipes! as long as synthesis dont work
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("ammoniumNitrate"), 2),
				xItems.getItemByName("sodiumNitrate"),
				xItems.getItemByName("potassiumCarbonate"),
				xItems.getItemByName("distilledWater")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("potassiumCarbonate"), 1),
		        xItems.getItemByName("distilledWater"),
		        xItems.getItemByName("carbon")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("sulfuricAcid"), 1),
		        xItems.getItemByName("distilledWater"),
		        xItems.getItemByName("sulfur"),
		        Items.glowstone_dust
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("hydrogenPeroxide"), 1),
		        xItems.getItemByName("distilledWater"),
		        xItems.getItemByName("sulfuricAcid"),
		        Items.glowstone_dust
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("hexamine"), 1),
		        xItems.getItemByName("distilledWater"),
		        xItems.getItemByName("ammonia"),
		        xItems.getItemByName("formaldehyde")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("hydrochloricAcid"), 1),
		        xItems.getItemByName("water"),
		        Items.glowstone_dust
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("formaldehyde"), 1),
		        xItems.getItemByName("distilledWater"),
		        xItems.getItemByName("carbon"),
		        Items.redstone
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("ammonia"), 2),
		        xItems.getItemByName("distilledWater"),
		        Items.rotten_flesh
		        );
		
		//crafting explosives
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("AMMONAL"), 2),
				xItems.getItemByName("ammoniumNitrate"),
				xItems.getItemByName("ammoniumNitrate"),
		        xItems.getItemByName("aluminium")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("AMMONAL"), 2),
				xItems.getItemByName("ammoniumNitrate"),
				xItems.getItemByName("ammoniumNitrate"),
		        xItems.getItemByName("carbon")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("FLASH"), 2),
				xItems.getItemByName("sodiumNitrate"),
				xItems.getItemByName("sodiumNitrate"),
				xItems.getItemByName("magnesium")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(Items.gunpowder, 5),
				xItems.getItemByName("sodiumNitrate"),
				xItems.getItemByName("sodiumNitrate"),
				xItems.getItemByName("sodiumNitrate"),
		        xItems.getItemByName("sulfur"),
		        xItems.getItemByName("carbon")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("APEX"), 2),
		        xItems.getItemByName("acetone"),
		        xItems.getItemByName("hydrogenPeroxide"),
		        xItems.getItemByName("hydrochloricAcid")
		        );
		GameRegistry.addShapelessRecipe(
				new ItemStack(xItems.getItemByName("HMTD"), 2),
		        xItems.getItemByName("hexamine"),
		        xItems.getItemByName("hydrogenPeroxide"),
		        xItems.getItemByName("hydrochloricAcid")
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
