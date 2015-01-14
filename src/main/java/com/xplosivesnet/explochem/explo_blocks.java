package com.xplosivesnet.explochem;

import net.minecraft.block.Block;

import com.xplosivesnet.explochem.devices.reactionVessel;
import cpw.mods.fml.common.registry.GameRegistry;

public class explo_blocks
{
	public static Block reactionVessel;
	
	public static void loadBlocks()
	{
		reactionVessel = new reactionVessel();
		GameRegistry.registerBlock(reactionVessel, "reactionVessel");
		//GameRegistry.registerTileEntity(reactionVesselTile.class, "reactionVesselTile");
	}
}

