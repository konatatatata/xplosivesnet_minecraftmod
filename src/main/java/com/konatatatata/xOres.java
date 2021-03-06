package com.konatatatata;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.konatatatata.ores.genericOre;

import cpw.mods.fml.common.registry.GameRegistry;

public class xOres
{
	private static Block[] blocks = new Block[25];
	private static String[] blockNames = new String[25];
	private static int[] spawnrates =  new int[blocks.length];
	private static int[] size =  new int[blocks.length];
	private static int counter = 0;
	
	public static void loadOres()
	{
		addOre("sulfur", 25, 10, 1);
		addOre("nitratine", 25, 15, 1); //sodiumNitrate
		addOre("uraninite", 3, 3, 2);
		addOre("ilmenite", 10, 5, 2); //titan ore
		addOre("aluminosilicate", 25, 15, 1); //aluminium ore
		addOre("magnesite", 15, 10, 1); //aluminium ore
		
		OreDictionary.registerOre("oreSulfur", xOres.getBlockByName("sulfur"));
		OreDictionary.registerOre("oreUranium", xOres.getBlockByName("uraninite"));
		OreDictionary.registerOre("oreTitanium", xOres.getBlockByName("ilmenite"));
		OreDictionary.registerOre("oreAluminium", xOres.getBlockByName("aluminosilicate"));
		OreDictionary.registerOre("oreMagnesium", xOres.getBlockByName("magnesite"));
		
		xGeneration ore_gen = new xGeneration();
		GameRegistry.registerWorldGenerator(ore_gen, 0);
	}
	
	public static void addOre(String name, int spawnRate, int s, int l)
	{
		Block ore = new genericOre(name, 1.5f, false, l);
		blocks[counter] = ore;
		blockNames[counter] = name;
		spawnrates[counter] = spawnRate;
		size[counter] = s;
		counter++;
		GameRegistry.registerBlock(ore, ore.getUnlocalizedName());
	}
	
	public static Block getBlockByName(String blockName)
	{
		int counter = 0;
		for (Block block: xOres.blocks)
		{
			try
			{
				if(blockNames[counter] == blockName)
				{
					return block;
				}
				counter++;
		    }
		    catch (NullPointerException e)
			{
		        return null;
		    }
		}
		return null;
	}
	
	public static Block getBlockById(int blockId)
	{
		return xOres.blocks[blockId];
	}
	
	public static int getSpawnrateById(int blockId)
	{
		return xOres.spawnrates[blockId];
	}
	
	public static Block[] getBlocks()
	{
		return xOres.blocks;
	}

	public static int getSizeById(int blockId)
	{
		return xOres.size[blockId];
	}
	
}
