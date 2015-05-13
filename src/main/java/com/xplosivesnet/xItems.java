package com.xplosivesnet;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.oredict.OreDictionary;

import com.xplosivesnet.building.itemKey;
import com.xplosivesnet.components.genericComponent;
import com.xplosivesnet.components.testItem;
import com.xplosivesnet.utilities.genericArmor;
import com.xplosivesnet.utilities.genericBook;

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
		addGenericComponent("acetonePeroxide", false, 64);
		addGenericComponent("nitroGlycerine", true, 64);
		addGenericComponent("ammoniumNitrate", false, 64);
		addGenericComponent("potassiumNitrate", false, 64);
		addGenericComponent("bariumNitrate", false, 64);
		addGenericComponent("sodiumNitrate", false, 64);
		addGenericComponent("potassiumCarbonate", false, 64);
		addGenericComponent("distilledWater", true, 64);
		addGenericComponent("toxicWaste", true, 64);
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
		addGenericComponent("oil", false, 64);
		
		addGenericComponent("sulfurIngot", false, 64);
		addGenericComponent("nitratineIngot", false, 64);
		addGenericComponent("uraniumIngot", false, 64);
		addGenericComponent("titaniumIngot", false, 64);
		addGenericComponent("aluminiumIngot", false, 64);
		addGenericComponent("magnesiumIngot", false, 64);
		
		addGenericComponent("sulfurDust", false, 64);
		addGenericComponent("titaniumDust", false, 64);
		addGenericComponent("aluminiumDust", false, 64);
		addGenericComponent("magnesiumDust", false, 64);
		addGenericComponent("nitratineDust", false, 64);
		
		addGenericArmor("hazmaHelmet", 0);
		addGenericArmor("hazmaChestplate", 1);
		addGenericArmor("hazmaLeggins", 2);
		addGenericArmor("hazmaBoots", 3);
    	
		OreDictionary.registerOre("ingotSulfur", xItems.getItemByName("sulfurIngot"));
		OreDictionary.registerOre("dustSulfur", xItems.getItemByName("sulfurDust"));
		
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
			addGenericComponent(name, false, 64);
		}
		
		
		//addKey("itemKey");
		
		//test item
		Item item = new testItem();
		item.setUnlocalizedName("itemTest");
		item.setCreativeTab(xTabs.machines);
		items[counter] = item;
		itemNames[counter] = "testItem";
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
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
	
	public static void addGenericComponent(String itemName, boolean inBottle, int maxStack)
	{
		Item item = new genericComponent(itemName, inBottle, maxStack);
		items[counter] = item;
		itemNames[counter] = itemName;
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	public static Item getItemByName(String itemName)
	{
		
		if(ic2.api.item.IC2Items.getItem(itemName) != null)
		{
			return ic2.api.item.IC2Items.getItem(itemName).getItem();
		}
		
		
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
