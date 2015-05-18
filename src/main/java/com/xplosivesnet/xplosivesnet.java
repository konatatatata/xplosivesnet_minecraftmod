package com.xplosivesnet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    public static final String VERSION = "1.5.2.4";
    @SidedProxy(clientSide="com.xplosivesnet.xCommonClientProxy", serverSide="com.xplosivesnet.xCommonProxy")
	public static xCommonProxy proxy;
	public static double newCPVERSION = 1.0;
    public static double CPVERSION = 1.0;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {	
    	System.out.println("check for new content pack version...");
		if(CPoutdated())
		{
			System.out.println("CP outdated. Updating.");
			CPupdate();
		}
		else
		{
			System.out.println("CP up to date.");
		}
    	
    	//xPotions.loadPotions();
    	xTabs.loadTabs();
    	xBlocks.loadBlocks();
    	xImporter.importExplosives();
    	xItems.loadItems();
    	xImporter.importItems();
    	xMachines.loadMachines();
    	xFluids.loadFluids();
    	xOres.loadOres();
    	
    	xSynthesisHandler.loadSyntheses();
    	xImporter.importSyntheses();
    	xWeapons.loadWeapons();
    	xAchievements.loadAchivements();
    	xRecipes.loadRecipes();
    	
		this.proxy.init(event);
		FMLCommonHandler.instance().bus().register(new xTicker());
    }
    
    public static void CPupdate()
    {
    	if(downloadFile("http://mindlesssoftware.de/projects/mc/x/CP.zip", "realistic_explosives/CP.zip"))
    	{
    		System.out.println("Download sucessful. Extracting...");
    		if(extractUpdate("realistic_explosives/CP.zip", "realistic_explosives/"))
    		{
    			System.out.println("Update successful");
    			xHelper.writeFile(String.valueOf(xplosivesnet.newCPVERSION), "realistic_explosives/version.txt");
    		}
    		else
    		{
    			System.out.println("Extraction failed");
    		}
    	}
    	else
    	{
    		System.out.println("Download failed");
    	}
    }
    
    private static boolean extractUpdate(String update, String dest)
    {
    	try {
            ZipFile zipFile = new ZipFile(update);
            Enumeration<?> enu = zipFile.entries();
            while (enu.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) enu.nextElement();

                String name = zipEntry.getName();
                long size = zipEntry.getSize();
                long compressedSize = zipEntry.getCompressedSize();
                System.out.printf("name: %-20s | size: %6d | compressed size: %6d\n", 
                        name, size, compressedSize);

                File file = new File(dest + name);
                if (name.endsWith("/")) {
                    file.mkdirs();
                    continue;
                }
                
                if(file.exists()) file.delete();
                
                File parent = file.getParentFile();
                if (parent != null) {
                    parent.mkdirs();
                }

                InputStream is = zipFile.getInputStream(zipEntry);
                FileOutputStream fos = new FileOutputStream(file);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = is.read(bytes)) >= 0) {
                    fos.write(bytes, 0, length);
                }
                is.close();
                fos.close();

            }
            zipFile.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    	return true;
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
    
    public static boolean CPoutdated()
    {
    	URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    boolean outdated = false;
	    
	    Double newVersion = 0.0;
    	Double version = xplosivesnet.CPVERSION;
	    
	    downloadFile("http://mindlesssoftware.de/projects/mc/x/version.txt", "realistic_explosives/newversion.txt");
	    
	    
    	try
    	{
    		if(xHelper.fileExists("realistic_explosives/newversion.txt"))
    	    {
    	    	newVersion = xHelper.getDouble(xHelper.readFile("realistic_explosives/newversion.txt"));
    	    }
		}
    	catch (IOException e)
    	{
			e.printStackTrace();
		}
    	
    	if(xHelper.fileExists("realistic_explosives/version.txt"))
    	{
    		try
        	{
    			version = xHelper.getDouble(xHelper.readFile("realistic_explosives/version.txt"));
    		}
        	catch (IOException e)
        	{
    			e.printStackTrace();
    		}
    	}
    		
	    
    	if(version == null)
    	{
    		version = 1.0;
    	}
    	if(newVersion == null)
    	{
    		newVersion = 1.0;
    	}
    	
    	System.out.println("newVersion: " + newVersion + ", version: " + version);
    	newCPVERSION = newVersion;
    	
    	if(newVersion > version) return true;
    	
	    return outdated;
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
