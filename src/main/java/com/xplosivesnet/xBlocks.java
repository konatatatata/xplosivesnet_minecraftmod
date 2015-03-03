package com.xplosivesnet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.xplosivesnet.building.cannon;
import com.xplosivesnet.building.genericBuildingBlock;
import com.xplosivesnet.building.lockedDoor;
import com.xplosivesnet.explosives.genericCustomModelExplosive;
import com.xplosivesnet.explosives.genericExplosive;
import com.xplosivesnet.explosives.timedCharge;
import com.xplosivesnet.models.genericCustomModelExplosiveRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import com.xplosivesnet.models.tileGenericCustomModelExplosive;
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
		addCustomExplosive("detonatingCord", true, false, false, 2.5f, 2f, 50f);
		addCustomExplosive("quickFuse", true, false, false, 0.5f, 0.1f, 50f);
		addExplosive("ANFO", false, false, true, 3.5f, 5f, 100f);
		addExplosive("ANNM", false, false, true, 5f, 2f, 90f);
		addExplosive("AMMONAL", false, false, true, 4f, 5f, 90f); //
		addExplosive("dynamite", false, false, true, 5f, 2f, 50f); //
		addExplosive("RDX", false, false, true, 7f, 2f, 10f); //
		addExplosive("CL20", false, false, true, 10f, 2f, 10f);
		addExplosive("ONC", false, false, true, 12f, 2f, 10f);
		addExplosive("astroliteG", false, false, true, 8.5f, 4f, 10f);
		addExplosive("PETN", false, false, true, 7.5f, 2f, 40f);
		addExplosive("ETN", false, false, true, 7.5f, 2f, 40f);
		addExplosive("FLASH", true, false, false, 2.5f, 0.5f, 90f); //
		addExplosive("ATOMIC", false, false, false, 75f, 10f, 1f);
		addTimedCharge("timedCharge", false, false, false, 5, 2, 40f);
		
		addBuildingBlock("concrete", 10f, 5f, false, 1);
		addBuildingBlock("hardenedConcrete", 30f, 7f, false, 1);
		addBuildingBlock("reinforcedConcrete", 50f, 14f, false, 1);
		addBuildingBlock("hardenedGlass", 30f, 7f, true,1 );
		addBuildingBlock("reinforcedGlass", 50f, 14f, true, 1);
		addBuildingBlock("lockedDoor", 50f, 14f, true, 2);
		
		
		Block block = new cannon();
		block.setBlockName("cannon");
		blocks[counter] = block;
		blockNames[counter] = "cannon";
		blockNamesExplosives[explosivesCounter] = "cannon";
		explosivesCounter++;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		
	}
	
	private static void addBuildingBlock(String name, float hardness, float resistance, boolean glassy, int type)
	{
		Block block;
		switch(type)
		{
		case 1:
			block = new genericBuildingBlock(name, hardness, resistance, glassy);
			break;
		case 2:
			block = new lockedDoor();
			break;
		default:
			block = null;
			break;
		
		}
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
	
	public static void addTimedCharge(String name, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float hardness, float chance)
	{
		Block block = new timedCharge(name, chance);
		blocks[counter] = block;
		blockNames[counter] = name;
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
	
}

