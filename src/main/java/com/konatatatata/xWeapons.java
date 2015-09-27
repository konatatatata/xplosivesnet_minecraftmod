package com.konatatatata;

import com.konatatatata.models.tileMine;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class xWeapons
{

	public static Block mine;
	private static int counter = 0;
	
	public static void loadWeapons()
	{
		mine = new com.konatatatata.weapons.mine();
		GameRegistry.registerBlock(mine, "mine");
		GameRegistry.registerTileEntity(tileMine.class, "tileMine");
		xBlocks.registerBlock(mine, "mine");
	}
}
