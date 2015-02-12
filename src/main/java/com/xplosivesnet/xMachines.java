package com.xplosivesnet;

import net.minecraft.block.Block;

import com.xplosivesnet.devices.reactionVessel;

import cpw.mods.fml.common.registry.GameRegistry;

public class xMachines
{
	public static Block reactionVessel;
	
	public static void loadMachines()
	{
		reactionVessel = new reactionVessel();
		GameRegistry.registerBlock(reactionVessel, "reactionVessel");
		GameRegistry.registerTileEntity(com.xplosivesnet.devices.reactionVesselTile.class, "reactionVesselTile");
	
		GameRegistry.registerTileEntity(com.xplosivesnet.explosives.entities.timedChargeTile.class, "timedChargeTile");
		
		xGeneration ore_gen = new xGeneration();
		GameRegistry.registerWorldGenerator(ore_gen, 0);
	}
}
