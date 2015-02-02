package com.xplosivesnet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.xplosivesnet.building.genericBuildingBlock;
import com.xplosivesnet.building.genericDoor;
import com.xplosivesnet.explosives.genericCustomModelExplosive;
import com.xplosivesnet.explosives.genericExplosive;
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
		addExplosive("APEX", true, true, false, 1.5f, 0.1f);
		addExplosive("HMTD", true, true, false, 1.5f, 0.1f);
		addExplosive("leadAzide", true, true, false, 1.5f, 0.1f);
		addExplosive("APAN", false, true, true, 2.5f, 1f);
		addCustomExplosive("detonatingCord", true, false, false, 2.5f, 2f);
		addCustomExplosive("quickFuse", true, false, false, 0.5f, 0.1f);
		addExplosive("ANFO", false, false, true, 3.5f, 5f);
		addExplosive("ANNM", false, false, true, 5f, 2f);
		addExplosive("AMMONAL", false, false, true, 4f, 5f);
		addExplosive("dynamite", false, false, true, 5f, 2f);
		addExplosive("RDX", false, false, true, 7f, 2f);
		addExplosive("CL20", false, false, true, 10f, 2f);
		addExplosive("ONC", false, false, true, 12f, 2f);
		addExplosive("astroliteG", false, false, true, 8.5f, 4f);
		addExplosive("PETN", false, false, true, 7.5f, 2f);
		addExplosive("ETN", false, false, true, 7.5f, 2f); //?
		
		addBuildingBlock("concrete", 10f, 5f, false);
		addBuildingBlock("hardenedConcrete", 30f, 7f, false);
		addBuildingBlock("reinforcedConcrete", 50f, 14f, false);
		addBuildingBlock("hardenedGlass", 30f, 7f, false);
		addBuildingBlock("reinforcedGlass", 50f, 14f, false);
		//addBuildingBlockDoor("hardenedDoor", 30f, 7f);
		//addBuildingBlockDoor("reinforcedDoor", 50f, 14f);
		
		
		ClientRegistry.bindTileEntitySpecialRenderer(tileGenericCustomModelExplosive.class, new genericCustomModelExplosiveRenderer(10f));
	}
	
	private static void addBuildingBlock(String name, float hardness, float resistance, boolean glassy)
	{
		Block block = new genericBuildingBlock(name, hardness, resistance, glassy);
		blocks[counter] = block;
		blockNames[counter] = name;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());	
	}
	
	private static void addBuildingBlockDoor(String name, float hardness, float resistance)
	{
		
		Block block = new genericDoor(name, hardness, resistance);
		blocks[counter] = block;
		blockNames[counter] = name;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());	
	}

	public static void addExplosive(String name, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float hardness)
	{
		Block block = new genericExplosive(name, hardness, false, explodeOnPower, explodeOnHit, needsIni, strength);
		blocks[counter] = block;
		blockNames[counter] = name;
		blockNamesExplosives[explosivesCounter] = name;
		explosivesCounter++;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	public static void addCustomExplosive(String name, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float hardness)
	{
		Block block = new genericCustomModelExplosive(name, hardness, false, explodeOnPower, explodeOnHit, needsIni, strength);
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

