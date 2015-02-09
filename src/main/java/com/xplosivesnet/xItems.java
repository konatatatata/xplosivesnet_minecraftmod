package com.xplosivesnet;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;

import com.xplosivesnet.components.genericComponent;
import com.xplosivesnet.utilities.genericArmor;
import com.xplosivesnet.utilities.genericIngot;

import cpw.mods.fml.common.registry.GameRegistry;

public class xItems
{
	private static Item[] items = new Item[100];
	private static String[] itemNames = new String[100];
	private static int counter = 0;
	
	public static void loadItems()
	{
		addGenericComponent("bottle", false, 16);
		addGenericComponent("shell", false, 64);
		addGenericComponent("acetone", true, 16);
		addGenericComponent("ammonia", true, 16);
		addGenericComponent("glycerine", true, 16);
		addGenericComponent("hydrochloricAcid", true, 16);
		addGenericComponent("hydrogenPeroxide", true, 16);
		addGenericComponent("nitricAcid", true, 16);
		addGenericComponent("sulfuricAcid", true, 16);
		addGenericComponent("acetonePeroxide", true, 16);
		addGenericComponent("nitroGlycerine", true, 16);
		addGenericComponent("ammoniumNitrate", true, 16);
		addGenericComponent("potassiumNitrate", true, 16);
		addGenericComponent("bariumNitrate", true, 16);
		addGenericComponent("sodiumNitrate", true, 16);
		addGenericComponent("potassiumCarbonate", true, 16);
		addGenericComponent("distilledWater", true, 16);
		addGenericComponent("toxicWaste", true, 16);
		addGenericComponent("sulfur", true, 16);
		addGenericComponent("carbon", true, 16);
		addGenericComponent("hexamine", true, 16);
		addGenericComponent("aluminium", true, 16);
		addGenericComponent("water", true, 16);
		

		addGenericIngot("sulfurIngot");
		addGenericIngot("nitratineIngot");
		addGenericIngot("uraniumIngot");
		addGenericIngot("titaniumIngot");
		addGenericIngot("aluminiumIngot");
		
		addGenericArmor("hazmaHelmet", 0);
		addGenericArmor("hazmaChestplate", 1);
		addGenericArmor("hazmaLeggins", 2);
		addGenericArmor("hazmaBoots", 3);
    	
		for(String name : xBlocks.blockNamesExplosives)
		{
			if(name == null) break;
			addGenericComponent(name, true, 16);
		}
		
	}
	
	private static void addGenericArmor(String itemName, int type)
	{
		Item item = new genericArmor(itemName, ArmorMaterial.CLOTH, type);
		items[counter] = item;
		itemNames[counter] = itemName;
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	private static void addGenericComponent(String itemName, boolean inBottle, int maxStack)
	{
		Item item = new genericComponent(itemName, inBottle, maxStack);
		items[counter] = item;
		itemNames[counter] = itemName;
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	private static void addGenericIngot(String itemName)
	{
		Item item = new genericIngot(itemName);
		items[counter] = item;
		itemNames[counter] = itemName;
		if(counter != 0) item.setContainerItem(items[0]);
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	public static Item getItemByName(String itemName)
	{
		int counter = 0;
		for (Item item : xItems.items)
		{
			try
			{
				if(itemNames[counter].equals(itemName))
				{
					return item;
				}
				counter++;
		    }
		    catch (NullPointerException e)
			{
		        return null;
		    }
		}
		return Items.apple;
	}
	
	public static Item getItemById(int itemId)
	{
		return xItems.items[itemId];
	}
	
	public static Item[] getItems()
	{
		return xItems.items;
	}
	
	public static boolean isComponentItem(String itemName)
	{
		int counter = 0;
		for (Item item : xItems.items)
		{
			try
			{
				if(itemNames[counter].equals(itemName.substring(5)))
				{
					return true;
				}
				counter++;
		    }
		    catch (NullPointerException e)
			{
		    	
		    }
		}
		return false;
	}
}
