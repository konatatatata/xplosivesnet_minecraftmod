package com.xplosivesnet;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import com.xplosivesnet.models.genericCustomModelExplosiveRenderer;
import com.xplosivesnet.models.mineRenderer;
import com.xplosivesnet.models.tileGenericCustomModelExplosive;
import com.xplosivesnet.models.tileMine;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class xCommonClientProxy extends xCommonProxy
{
	
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(this);
    }
	
	@Override
    public void init(FMLInitializationEvent e)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(tileGenericCustomModelExplosive.class, new genericCustomModelExplosiveRenderer(10f));
		//ClientRegistry.bindTileEntitySpecialRenderer(com.xplosivesnet.models.tileMine.class, new mineRenderer(10f));
		
		GameRegistry.registerTileEntity(com.xplosivesnet.explosives.entities.timedChargeTileNoGui.class, "timedChargeTileNoGui");
		GameRegistry.registerTileEntity(com.xplosivesnet.devices.reactionVesselTile.class, "reactionVesselTile");
    }

	@Override
    public void postInit(FMLPostInitializationEvent e)
	{
		
    }
}
