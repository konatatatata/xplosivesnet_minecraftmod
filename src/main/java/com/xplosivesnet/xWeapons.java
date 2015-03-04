package com.xplosivesnet;

import com.xplosivesnet.models.tileMine;
import com.xplosivesnet.weapons.cannonTile;
import com.xplosivesnet.weapons.genericRocket;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class xWeapons
{

	public static Block mine, cannon;
	public static Item cannonMarker;
	private static Item[] rockets = new Item[100];
	private static Float[] rocketStrength = new Float[100];
	private static int counter = 0;
	
	public static void loadWeapons()
	{
		mine = new com.xplosivesnet.weapons.mine();
		GameRegistry.registerBlock(mine, "mine");
		GameRegistry.registerTileEntity(tileMine.class, "tileMine");
		
		cannon = new com.xplosivesnet.weapons.cannon();
		GameRegistry.registerBlock(cannon, "cannon");
		GameRegistry.registerTileEntity(cannonTile.class, "cannonTile");
		
		addRocket("APEX_rocket", 10f);
		
		cannonMarker = new com.xplosivesnet.weapons.cannonMarker();
		GameRegistry.registerItem(cannonMarker, "cannonMarker");
	}
	
	private static void addRocket(String name, float strength)
	{
		rockets[counter] = new genericRocket(name);
		rocketStrength[counter] = strength;
		GameRegistry.registerItem(rockets[counter], name);
		counter++;
	}

	public static boolean isRocket(Item item)
	{
		for(Item rocket : rockets)
		{
			if(rocket == null) break;
			if(rocket == item) return true;
		}
		return false;
	}
	
	public static float getRocketStrength(Item item)
	{
		int i = 0;
		for(Item rocket : rockets)
		{
			if(rocket == null) break;
			if(rocket == item) return rocketStrength[i];
			i++;
		}
		return 1f;
	}
}
