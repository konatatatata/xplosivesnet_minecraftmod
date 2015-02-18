package com.xplosivesnet;

import com.xplosivesnet.models.tileMine;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class xWeapons
{

	public static Block mine;
	
	public static void loadWeapons()
	{
		mine = new com.xplosivesnet.weapons.mine();
		GameRegistry.registerBlock(mine, "mine");
		GameRegistry.registerTileEntity(tileMine.class, "tileMine");
	}
}
