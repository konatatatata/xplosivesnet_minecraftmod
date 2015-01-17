package com.xplosivesnet.explochem;

import com.xplosivesnet.explochem.devices.reactionVessel;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

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
