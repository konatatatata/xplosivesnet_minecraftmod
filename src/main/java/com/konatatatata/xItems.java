package com.konatatatata;

import com.konatatatata.components.genericComponent;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class xItems
{
	private static Item[] items = new Item[100];
	private static String[] itemNames = new String[100];
	private static int counter = 0;
	
	public static void loadItems()
	{
		addGenericComponent("bottle", false, 64, "Used to transport all kind of components");
		addGenericComponent("shell", false, 64, "Housing for all explosives");
		addGenericComponent("acetone", true, 64, "Poor mans hexamine");
		addGenericComponent("ammonia", true, 64, "Stinky..");
		addGenericComponent("glycerine", true, 64);
		addGenericComponent("hydrochloricAcid", true, 64);
		addGenericComponent("hydrogenPeroxide", true, 64);
		addGenericComponent("nitricAcid", true, 64);
		addGenericComponent("sulfuricAcid", true, 64);
		addGenericComponent("acetonePeroxide", false, 64, "Free O's anyone??");
		addGenericComponent("nitroGlycerine", true, 64);
		addGenericComponent("ammoniumNitrate", false, 64, "Core of cheap explosives");
		addGenericComponent("potassiumNitrate", false, 64);
		addGenericComponent("bariumNitrate", false, 64);
		addGenericComponent("sodiumNitrate", false, 64);
		addGenericComponent("potassiumCarbonate", false, 64);
		addGenericComponent("distilledWater", true, 64, "You should not drink that");
		addGenericComponent("toxicWaste", true, 64, "You should NOT drink that!");
		addGenericComponent("sulfur", false, 64);
		addGenericComponent("carbon", false, 64);
		addGenericComponent("hexamine", false, 64);
		addGenericComponent("aluminium", false, 64);
		addGenericComponent("magnesium", false, 64);
		addGenericComponent("titanium", false, 64);
		addGenericComponent("water", true, 64);
		addGenericComponent("formaldehyde", false, 64);
		addGenericComponent("electrolyzer", false, 64);
		addGenericComponent("heater", false, 64);
		addGenericComponent("uranium", false, 64);
		
		//ingots
		addGenericComponent("sulfurIngot", false, 64);
		addGenericComponent("nitratineIngot", false, 64);
		addGenericComponent("uraniumIngot", false, 64);
		addGenericComponent("titaniumIngot", false, 64);
		addGenericComponent("aluminiumIngot", false, 64);
		addGenericComponent("magnesiumIngot", false, 64);
		
		//dusts
		addGenericComponent("sulphurDust", false, 64);
		addGenericComponent("titaniumDust", false, 64);
		addGenericComponent("aluminiumDust", false, 64);
		addGenericComponent("magnesiumDust", false, 64);
		addGenericComponent("nitratineDust", false, 64);
		addGenericComponent("uraniumDust", false, 64);
		
		OreDictionary.registerOre("ingotSulfur", xItems.getItemByName("sulfurIngot"));
		OreDictionary.registerOre("dustSulfur", xItems.getItemByName("sulphurDust"));
		
		OreDictionary.registerOre("ingotUranium", xItems.getItemByName("uraniumIngot"));
		
		OreDictionary.registerOre("ingotTitanium", xItems.getItemByName("titaniumIngot"));
		OreDictionary.registerOre("dustTitanium", xItems.getItemByName("titaniumDust"));
		
		OreDictionary.registerOre("ingotAluminium", xItems.getItemByName("aluminiumIngot"));
		OreDictionary.registerOre("dustAluminium", xItems.getItemByName("aluminiumDust"));
		
		OreDictionary.registerOre("ingotMagnesium", xItems.getItemByName("magnesiumIngot"));
		OreDictionary.registerOre("dustMagnesium", xItems.getItemByName("magnesiumDust"));
		
		OreDictionary.registerOre("ingotSaltpeter", xItems.getItemByName("nitratineIngot"));
		OreDictionary.registerOre("itemDustSaltpeter", xItems.getItemByName("nitratineDust"));
		
		for(String name : xBlocks.blockNamesExplosives)
		{
			if(name == null) break;
			if(isComponentItem(name)) break;
			addGenericComponent(name, false, 64, "EXPLOSIVE! Combine with shell");
		}
		
	}
	
	public static void addGenericComponent(String itemName, boolean fluid, int maxStack, String desc)
	{
		Item item = new genericComponent(itemName, fluid, maxStack, desc);
		items[counter] = item;
		itemNames[counter] = itemName;
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	public static void addGenericComponent(String itemName, boolean fluid, int maxStack)
	{
		Item item = new genericComponent(itemName, fluid, maxStack, "");
		items[counter] = item;
		itemNames[counter] = itemName;
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
		if(itemName == null) return false;
		for (Item item : xItems.items)
		{
			if(item == null) break;
			if(itemNames[counter].equals(itemName))
			{
				return true;
			}
			counter++;
		}
		return false;
	}
}
