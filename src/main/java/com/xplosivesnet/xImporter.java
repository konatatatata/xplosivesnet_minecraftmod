package com.xplosivesnet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.prefs.Preferences;

import net.minecraft.item.Item;

public class xImporter
{
	public static void importSyntheses()
	{
		File folder = new File("realistic_explosives/import/syntheses/");
		if (!folder.exists())
		{
			try
			{
				folder.mkdirs();
			}
			catch(SecurityException se)
			{
				
			}
		}
		
		try
		{
			System.out.println("Scanning " + folder.getPath() + " for synthesis imports");
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++)
			{
				if (listOfFiles[i].isFile())
				{
					importSynthesisFile(listOfFiles[i].getPath());
				}
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void importItems()
	{
		File folder = new File("realistic_explosives/import/components/");
		if (!folder.exists())
		{
			try
			{
				folder.mkdirs();
			}
			catch(SecurityException se)
			{
				
			}
		}
		
		try
		{
			System.out.println("Scanning " + folder.getPath() + " for component imports");
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++)
			{
				if (listOfFiles[i].isFile())
				{
					importItemFile(listOfFiles[i].getPath());
				}
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void importExplosives()
	{
		File folder = new File("realistic_explosives/import/explosives/");
		if (!folder.exists())
		{
			try
			{
				folder.mkdirs();
			}
			catch(SecurityException se)
			{
				
			}
		}
		
		try
		{
			System.out.println("Scanning " + folder.getPath() + " for explosive imports");
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++)
			{
				if (listOfFiles[i].isFile())
				{
					importExplosiveFile(listOfFiles[i].getPath());
				}
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	@SuppressWarnings("resource")
	private static void importExplosiveFile(String name)
	{
		try
		{
			System.out.println("Importing explosive: " + name);
			BufferedReader br;
			br = new BufferedReader(new FileReader(name));
	        String line, total = new String();
	        ArrayList<Item> inputList = new ArrayList<Item>();
	        ArrayList<Item> outputList = new ArrayList<Item>();

	        Properties props = new Properties();
	        props.load(new FileReader(name));
	        
	        String itemName = props.getProperty("itemName", "null");
	        Boolean needsIni =  xHelper.getBoolean(props.getProperty("needsIni", "false"));
	        Boolean explodeOnPower =  xHelper.getBoolean(props.getProperty("explodeOnPower", "false"));
	        Boolean explodeOnHit =  xHelper.getBoolean(props.getProperty("explodeOnHit", "false"));
	        Float strength =  xHelper.getFloat(props.getProperty("strength", "1f"));
	        Float hardness =  xHelper.getFloat(props.getProperty("hardness", "1f"));
	        Float chance =  xHelper.getFloat(props.getProperty("chance", "1f"));
	        props.setProperty("itemName", itemName.toString());
	        props.setProperty("needsIni", needsIni.toString());
	        props.setProperty("explodeOnPower", explodeOnPower.toString());
	        props.setProperty("explodeOnHit", explodeOnHit.toString());
	        props.setProperty("strength", strength.toString());
	        props.setProperty("hardness", hardness.toString());
	        props.setProperty("chance", chance.toString());
	        props.store(new FileWriter(name), "");
	        
	        if(!xItems.isComponentItem(itemName) || !xBlocks.isRegistered(itemName))
	        {
	        	xBlocks.addExplosive(itemName, explodeOnPower, explodeOnHit, needsIni, strength, hardness, chance);
	        }
	        else
	        {
	        	System.out.println("Skipping double item: " + name);
	        }
		}
		catch(Exception e)
		{
			System.out.println("Skipping invalid item: " + name);
		}
	}

	@SuppressWarnings("resource")
	private static void importSynthesisFile(String name)
	{
		try
		{
			BufferedReader br;
			br = new BufferedReader(new FileReader(name));
	        String line;
	        int time = 10;
	        ArrayList<Item> inputList = new ArrayList<Item>();
	        ArrayList<Item> outputList = new ArrayList<Item>();
	        while((line = br.readLine()) != null)
	        {
	        	if(line.length() > 0)
	        	{
	        		if(line.startsWith(">"))
	        		{
	        			String item = line.substring(1);
	        			if(xItems.isComponentItem(item))
	        			{
	        				inputList.add(xItems.getItemByName(item));
	        			}
	        			else
	        			{
	        				System.out.println("Skipping invalid item: " + item);
	        			}
	        			
	        		}
	        		else if(line.startsWith("<"))
	        		{
	        			String item = line.substring(1);
	        			if(xItems.isComponentItem(item))
	        			{
	        				outputList.add(xItems.getItemByName(item));
	        			}
	        			else
	        			{
	        				System.out.println("Skipping invalid item: " + item);
	        			}
	        		}
	        		else if(line.startsWith("="))
	        		{
	        			String t = line.substring(1);
	        			if(xHelper.isInteger(t))
	        			{
	        				time = xHelper.getInt(t);
	        			}
	        		}
	        	}
	        }
	        Item[] inputArray = new Item[inputList.size()];
	        inputArray = inputList.toArray(inputArray);
	        Item[] outputArray = new Item[outputList.size()];
	        outputArray = outputList.toArray(outputArray);
	        xSynthesisHandler.addSynthesis(time, inputArray, outputArray);
		}
		catch(Exception e)
		{
			
		}
	}
	
	@SuppressWarnings("resource")
	private static void importItemFile(String name)
	{
		try
		{
			System.out.println("Importing item: " + name);
			BufferedReader br;
			br = new BufferedReader(new FileReader(name));
	        String line, total = new String();
	        ArrayList<Item> inputList = new ArrayList<Item>();
	        ArrayList<Item> outputList = new ArrayList<Item>();

	        Properties props = new Properties();
	        props.load(new FileReader(name));
	        
	        String itemName = props.getProperty("name", "null");
	        String stackSize = props.getProperty("stack", "64");
	        String bottled = props.getProperty("bottled", "true");
	        
	        if(!xItems.isComponentItem(itemName))
	        {
	        	xItems.addGenericComponent(itemName, xHelper.getBoolean(bottled), xHelper.getInt(stackSize));
	        }
	        else
	        {
	        	System.out.println("Skipping double item: " + name);
	        }
		}
		catch(Exception e)
		{
			System.out.println("Skipping invalid item: " + name);
		}
	}
	
	public static void checkUpdates()
	{
		
	}
}
