package com.xplosivesnet;

import net.minecraft.block.Block;

import com.xplosivesnet.explosives.genericExplosive;

import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_blocks
{
	public static Block[] blocks = new Block[10];
	private static int counter = 0;
	
	public static void loadBlocks()
	{
		addExplosive("apex", true, false, 0.5f);
		addExplosive("anfo", false, true, 5f);
		
	}
	
	public static void addExplosive(String name, boolean explodeOnHit, boolean needsIni, float strength)
	{
		Block block = new genericExplosive(name, 0.1f, false, explodeOnHit, needsIni, strength);
		blocks[counter] = block;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
}

