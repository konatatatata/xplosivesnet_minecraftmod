package com.xplosivesnet;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.xplosivesnet.ores.genericOre;

import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_ores
{
	public static Block[] blocks = new Block[10];
	public static int[] spawnrates =  new int[blocks.length];
	private static int counter = 0;
	
	public static void loadOres()
	{
		addOre("sulfur", 20);
		addOre("nitratine", 20); //sodiumNitrate
		addOre("uraninite", 5);
		addOre("ilmenite", 5); //titan ore
		
	}
	
	public static void addOre(String name, int spawnRate)
	{
		Block ore = new genericOre(name, 1f, Material.rock, false);
		blocks[counter] = ore;
		spawnrates[counter] = spawnRate;
		counter++;
		GameRegistry.registerBlock(ore, ore.getUnlocalizedName());
	}
	
}
