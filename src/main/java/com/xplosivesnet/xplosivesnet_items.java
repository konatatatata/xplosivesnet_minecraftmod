package com.xplosivesnet;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;

import com.xplosivesnet.components.genericComponent;
import com.xplosivesnet.utilities.genericArmor;
import com.xplosivesnet.utilities.genericIngot;

import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_items
{
	public static Item[] items = new Item[25];
	private static int counter = 0;
	
	public static void loadItems()
	{
		addGenericComponent("bottle", false, 16);
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
		addGenericIngot("sulfurIngot");
		addGenericIngot("nitratineIngot");
		addGenericIngot("uraniniteIngot");
		addGenericIngot("titaniumIngot");
		
		addGenericArmor("hazmaHelmet", 0);
		addGenericArmor("hazmaChestplate", 1);
		addGenericArmor("hazmaLeggins", 2);
		addGenericArmor("hazmaBoots", 3);
    	
	}
	
	private static void addGenericArmor(String itemName, int type)
	{
		Item item = new genericArmor(itemName, ArmorMaterial.CLOTH, type);
		items[counter] = item;
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	private static void addGenericComponent(String itemName, boolean inBottle, int maxStack)
	{
		Item item = new genericComponent(itemName, inBottle, maxStack);
		items[counter] = item;
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	private static void addGenericIngot(String itemName)
	{
		Item item = new genericIngot(itemName);
		items[counter] = item;
		if(counter != 0) item.setContainerItem(items[0]);
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
}
