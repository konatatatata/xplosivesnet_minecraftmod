package com.konatatatata;

import com.konatatatata.building.genericBuildingBlock;
import com.konatatatata.explosives.genericCustomModelExplosive;
import com.konatatatata.explosives.genericExplosive;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
public class xBlocks
{
	private static Block[] blocks = new Block[100];
	private static String[] blockNames = new String[100];
	public static String[] blockNamesExplosives = new String[100];
	private static int counter = 0;
	private static int explosivesCounter = 0;
	
	public static void loadBlocks()
	{
		addExplosive("APEX", true, true, false, 1.5f, 0.1f, 20f); //
		addExplosive("HMTD", true, true, false, 1.5f, 0.1f, 20f); //
		addExplosive("leadAzide", true, true, false, 1.5f, 0.1f, 20f);
		addExplosive("APAN", false, true, true, 2.5f, 1f, 20f);
		addExplosive("ANFO", false, false, true, 3.5f, 5f, 100f);
		addExplosive("ANNM", false, false, true, 5f, 2f, 90f);
		addExplosive("AMMONAL", false, false, true, 4f, 5f, 90f); //
		addExplosive("dynamite", true, false, true, 5f, 2f, 50f); //
		addExplosive("RDX", false, false, true, 7f, 2f, 10f); //
		addExplosive("CL20", false, false, true, 10f, 2f, 10f);
		addExplosive("ONC", false, false, true, 12f, 2f, 10f);
		addExplosive("astroliteG", false, false, true, 8.5f, 4f, 10f);
		addExplosive("PETN", false, false, true, 7.5f, 2f, 30f);
		
		addExplosive("AMATOL", false, false, true, 5f, 4.5f, 50f);
		addExplosive("ANNMNC", false, false, true, 4f, 3f, 30f);
		addExplosive("ATOMIC", false, false, true, 100f, 20f, 0f);
		addExplosive("C4", false, false, true, 4f, 3f, 30f);
		addExplosive("cheddite", false, false, true, 4f, 3f, 30f);
		addExplosive("EGDN", false, false, true, 4f, 3f, 30f);
		addExplosive("ETN", false, false, true, 6.5f, 2f, 30f);
		addExplosive("FLASH", true, false, true, 2f, 1f, 60f);

		addExplosive("HMX", false, false, true, 4f, 3f, 30f);
		addExplosive("MEKP", false, false, true, 4f, 3f, 30f);
		addExplosive("MEKPAN", false, false, true, 4f, 3f, 30f);
		addExplosive("semtex", false, false, true, 4f, 3f, 30f);
		addExplosive("TNP", false, false, true, 4f, 3f, 40f);
		addExplosive("TNT", false, false, true, 3f, 3f, 40f);
		
		
		addCustomExplosive("detonatingCord", true, false, false, 2.5f, 2f, 50f);
		addCustomExplosive("quickFuse", true, false, false, 0.5f, 0.1f, 50f);
		
		addBuildingBlock("concrete", 10f, 5f, false, 1);
		addBuildingBlock("hardenedConcrete", 30f, 7f, false, 1);
		addBuildingBlock("reinforcedConcrete", 50f, 14f, false, 1);
		addBuildingBlock("hardenedGlass", 30f, 7f, true,1 );
		addBuildingBlock("reinforcedGlass", 50f, 14f, true, 1);
	}
	
	private static void addBuildingBlock(String name, float hardness, float resistance, boolean glassy, int type)
	{
		Block block = new genericBuildingBlock(name, hardness, resistance, glassy);

		if(block != null)
		{
			blocks[counter] = block;
			blockNames[counter] = name;
			counter++;
			GameRegistry.registerBlock(block, block.getUnlocalizedName());	
		}
	}

	public static void addExplosive(String name, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float hardness, float chance)
	{
		Block block = new genericExplosive(name, hardness, false, explodeOnPower, explodeOnHit, needsIni, strength, chance);
		blocks[counter] = block;
		blockNames[counter] = name;
		blockNamesExplosives[explosivesCounter] = name;
		explosivesCounter++;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	public static void addCustomExplosive(String name, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float hardness, float chance)
	{
		Block block = new genericCustomModelExplosive(name, hardness, false, explodeOnPower, explodeOnHit, needsIni, strength, chance);
		blocks[counter] = block;
		blockNames[counter] = name;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());		
	}
	
	public static Block getBlockByName(String blockName)
	{
		
		int counter = 0;
		for (Block block: xBlocks.blocks)
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
		return xBlocks.blocks[blockId];
	}
	
	public static Block[] getBlocks()
	{
		return xBlocks.blocks;
	}
	
	public static void registerBlock(Block block, String name)
	{
		blocks[counter] = block;
		blockNames[counter] = name;
		counter++;
	}

	public static boolean isRegistered(String itemName)
	{
		if(getBlockByName(itemName) != null) return true;
		return false;
	}
	
}

