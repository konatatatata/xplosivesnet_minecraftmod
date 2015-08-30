package com.xplosivesnet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.xplosivesnet.commands.commandRS;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = xplosivesnet.MODID, version = xplosivesnet.VERSION)
public class xplosivesnet
{
    public static final String MODID = "realistic_explosives";
    public static final String VERSION = "1.5.3.1";
    @SidedProxy(clientSide="com.xplosivesnet.xCommonClientProxy", serverSide="com.xplosivesnet.xCommonProxy")
	public static xCommonProxy proxy;
	public static double newCPVERSION = 1.0;
    public static double CPVERSION = 1.0;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {	
    	
    	//xPotions.loadPotions();
    	xTabs.loadTabs();
    	xBlocks.loadBlocks();
    	xItems.loadItems();
    	xMachines.loadMachines();
    	xFluids.loadFluids();
    	xOres.loadOres();
    	
    	xSynthesisHandler.loadSyntheses();
    	xWeapons.loadWeapons();
    	xAchievements.loadAchivements();
    	//xRecipes.loadRecipes();
    	
		this.proxy.init(event);
		FMLCommonHandler.instance().bus().register(new xTicker());
    }
    
    
    @SuppressWarnings("resource")
	private static boolean downloadFile(String Url, String output)
    {
    	URL url;
	    ReadableByteChannel rbc;
	    FileOutputStream fos;
	    
	    boolean outdated = false;
	    try {
	    	
	    	File f = new File(output);
	    	if(f.exists()) f.delete();
	    	
	        url = new URL(Url);
	        rbc = Channels.newChannel(url.openStream());
	        fos = new FileOutputStream(output);
	        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	        
	    } catch (MalformedURLException mue)
	    {
	         mue.printStackTrace();
	         return false;
	    } catch (IOException ioe)
	    {
	         ioe.printStackTrace();
	         return false;
	    }
	    finally
	    {
	    }
    	return true;
    }
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	this.proxy.preInit(event);
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
    	event.registerServerCommand(new commandRS());
    }
    
    
}
