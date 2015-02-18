package com.xplosivesnet;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;

import com.xplosivesnet.building.itemKey;
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
		addGenericComponent("bottle", false, 64);
		addGenericComponent("shell", false, 64);
		addGenericComponent("acetone", true, 64);
		addGenericComponent("ammonia", true, 64);
		addGenericComponent("glycerine", true, 64);
		addGenericComponent("hydrochloricAcid", true, 64);
		addGenericComponent("hydrogenPeroxide", true, 64);
		addGenericComponent("nitricAcid", true, 64);
		addGenericComponent("sulfuricAcid", true, 64);
		addGenericComponent("acetonePeroxide", true, 64);
		addGenericComponent("nitroGlycerine", true, 64);
		addGenericComponent("ammoniumNitrate", true, 64);
		addGenericComponent("potassiumNitrate", true, 64);
		addGenericComponent("bariumNitrate", true, 64);
		addGenericComponent("sodiumNitrate", true, 64);
		addGenericComponent("potassiumCarbonate", true, 64);
		addGenericComponent("distilledWater", true, 64);
		addGenericComponent("toxicWaste", true, 64);
		addGenericComponent("sulfur", true, 64);
		addGenericComponent("carbon", true, 64);
		addGenericComponent("hexamine", true, 64);
		addGenericComponent("aluminium", true, 64);
		addGenericComponent("magnesium", true, 64);
		addGenericComponent("water", true, 64);
		addGenericComponent("formaldehyde", true, 64);
		
		addGenericIngot("sulfurIngot");
		addGenericIngot("nitratineIngot");
		addGenericIngot("uraniumIngot");
		addGenericIngot("titaniumIngot");
		addGenericIngot("aluminiumIngot");
		addGenericIngot("magnesiumIngot");
		
		addGenericArmor("hazmaHelmet", 0);
		addGenericArmor("hazmaChestplate", 1);
		addGenericArmor("hazmaLeggins", 2);
		addGenericArmor("hazmaBoots", 3);
    	
		for(String name : xBlocks.blockNamesExplosives)
		{
			if(name == null) break;
			addGenericComponent(name, true, 64);
		}
		
		addKey("itemKey");
	}
	
	private static void addKey(String itemName)
	{
		Item item = new itemKey(itemName);
		items[counter] = item;
		itemNames[counter] = itemName;
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
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
