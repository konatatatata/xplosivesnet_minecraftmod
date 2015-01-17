package com.xplosivesnet;

import net.minecraft.block.Block;

import com.xplosivesnet.explosives.genericExplosive;

import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_blocks
{
	public static Block[] blocks = new Block[25];
	private static int counter = 0;
	
	public static void loadBlocks()
	{
		addExplosive("apex", true, true, false, 1f, 0.1f);
		addExplosive("hmtd", true, false, false, 1f, 0.1f);
		addExplosive("leadAzide", true, false, false, 1f, 0.1f);
		
		addExplosive("detonatingCord", true, false, false, 0.5f, 0.1f);
		
		addExplosive("ANFO", false, false, true, 3.5f, 1f);
		addExplosive("ANNM", false, false, true, 5f, 1f);
		addExplosive("AMMONAL", false, false, true, 4f, 1f);
		addExplosive("Dynamite", false, false, true, 3f, 1f);
		addExplosive("RDX", false, false, true, 5.5f, 2f);
		
		
	}
	
	public static void addExplosive(String name, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float hardness)
	{
		Block block = new genericExplosive(name, hardness, false, explodeOnPower, explodeOnHit, needsIni, strength);
		blocks[counter] = block;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
}

