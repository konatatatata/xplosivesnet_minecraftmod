package com.xplosivesnet.explochem;

import com.xplosivesnet.explochem.ores.genericOre;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class xplosivesnet_ores
{
	public static Block[] nitrates = new Block[10];
	public static int[] spawnrates =  new int[nitrates.length];
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
		nitrates[counter] = ore;
		spawnrates[counter] = spawnRate;
		counter++;
		GameRegistry.registerBlock(ore, ore.getUnlocalizedName());
	}
	
}
