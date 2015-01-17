package com.xplosivesnet;

import net.minecraft.block.Block;

import com.xplosivesnet.devices.reactionVessel;

import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_machines
{
	public static Block reactionVessel;
	
	public static void loadMachines()
	{
		reactionVessel = new reactionVessel();
		GameRegistry.registerBlock(reactionVessel, "reactionVessel");
		//GameRegistry.registerTileEntity(reactionVesselTile.class, "reactionVesselTile");
	
		xplosivesnet_generation ore_gen = new xplosivesnet_generation();
		GameRegistry.registerWorldGenerator(ore_gen, 0);
	}
}
