package com.konatatatata;

import com.konatatatata.models.genericCustomModelExplosiveRenderer;
import com.konatatatata.models.mineRenderer;
import com.konatatatata.models.tileGenericCustomModelExplosive;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

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
		ClientRegistry.bindTileEntitySpecialRenderer(com.konatatatata.models.tileMine.class, new mineRenderer(10f));
	}

	@Override
    public void postInit(FMLPostInitializationEvent e)
	{
		
    }
}
