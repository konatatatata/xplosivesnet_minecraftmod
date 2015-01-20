package com.xplosivesnet;

import net.minecraft.block.Block;

import com.xplosivesnet.explosives.genericCustomModelExplosive;
import com.xplosivesnet.explosives.genericExplosive;
import com.xplosivesnet.models.genericCustomModelExplosiveRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import com.xplosivesnet.models.tilegenericCustomModelExplosive;
public class xBlocks
{
	public static Block[] blocks = new Block[25];
	private static int counter = 0;
	
	public static void loadBlocks()
	{
		addExplosive("apex", true, true, false, 1.5f, 0.1f);
		addExplosive("hmtd", true, false, false, 1.5f, 0.1f);
		addExplosive("leadAzide", true, false, false, 1.5f, 0.1f);
		addExplosive("apan", false, true, true, 2.5f, 1f);
		addCustomExplosive("detonatingCord", true, false, false, 2f, 0.1f);
		addCustomExplosive("quickFuse", true, false, false, 0.5f, 0.1f);
		addExplosive("ANFO", false, false, true, 3.5f, 5f);
		addExplosive("ANNM", false, false, true, 5f, 2f);
		addExplosive("AMMONAL", false, false, true, 4f, 5f);
		addExplosive("Dynamite", false, false, true, 5f, 2f);
		addExplosive("RDX", false, false, true, 7f, 2f);
		addExplosive("CL20", false, false, true, 10f, 2f);
		addExplosive("ONC", false, false, true, 12f, 2f);
		addExplosive("AstroliteG", false, false, true, 8.5f, 4f);
		addExplosive("PETN", false, false, true, 7.5f, 2f);
		
	}
	
	public static void addExplosive(String name, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float hardness)
	{
		Block block = new genericExplosive(name, hardness, false, explodeOnPower, explodeOnHit, needsIni, strength);
		blocks[counter] = block;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	public static void addCustomExplosive(String name, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float hardness)
	{
		Block block = new genericCustomModelExplosive(name, hardness, false, explodeOnPower, explodeOnHit, needsIni, strength);
		blocks[counter] = block;
		counter++;
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		ClientRegistry.bindTileEntitySpecialRenderer(tilegenericCustomModelExplosive.class, new genericCustomModelExplosiveRenderer(10f));
	}
}

