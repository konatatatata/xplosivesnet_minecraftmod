package com.xplosivesnet.explochem;

import net.minecraft.item.Item;

import com.xplosivesnet.explochem.components.acetone;
import com.xplosivesnet.explochem.components.ammonia;
import com.xplosivesnet.explochem.components.glycerine;
import com.xplosivesnet.explochem.components.hydrochloricAcid;
import com.xplosivesnet.explochem.components.hydrogenPeroxide;
import com.xplosivesnet.explochem.components.nitrate;
import com.xplosivesnet.explochem.components.nitricAcid;
import com.xplosivesnet.explochem.components.sulfuricAcid;
import com.xplosivesnet.explochem.explosives.initial.acetonePeroxide;
import com.xplosivesnet.explochem.explosives.initial.nitroGlycerine;
import com.xplosivesnet.explochem.preComponents.genericComponent;
import com.xplosivesnet.explochem.utilities.bottle;
import com.xplosivesnet.explochem.utilities.genericIngot;

import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_items
{
	public static Item[] items = new Item[25];
	private static int counter = 0;
	
	public static void loadItems()
	{
		//with texture
		addItem("bottle");
		addItem("acetone");
		addItem("ammonia");
		addItem("glycerine");
		addItem("hydrochloricAcid");
		addItem("hydrogenPeroxide");
		addItem("nitricAcid");
		addItem("sulfuricAcid");
		addItem("acetonePeroxide");
		addItem("nitroGlycerine");
		
		//no texture yet
		addGenericItem(new nitrate("ammoniumNitrate", xplosivesnet_tabs.components, 16));
		addGenericItem(new nitrate("potassiumNitrate", xplosivesnet_tabs.components, 16));
		addGenericItem(new nitrate("bariumNitrate", xplosivesnet_tabs.components, 16));
		addGenericItem(new nitrate("sodiumNitrate", xplosivesnet_tabs.components, 16));
		addGenericItem(new genericComponent("potassiumCarbonate", xplosivesnet_tabs.components, 16));
		addGenericIngot(new genericIngot("titaniumIngot"));
	}
	
	private static void addGenericItem(Item item)
	{
		items[counter] = item;
		if(counter != 0) item.setContainerItem(items[0]);
		System.out.println(item.getUnlocalizedName() + " : " + counter);
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	private static void addGenericIngot(Item item)
	{
		items[counter] = item;
		if(counter != 0) item.setContainerItem(items[0]);
		System.out.println(item.getUnlocalizedName() + " : " + counter);
		counter++;
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	private static void addItem(String itemName)
	{
		Item item;
		if(itemName == "bottle")
		{
			item = new bottle();
		}
		else if(itemName == "acetone")
		{
			item = new acetone();
		}
		else if(itemName == "ammonia")
		{
			item = new ammonia();
		}
		else if(itemName == "glycerine")
		{
			item = new glycerine();
		}
		else if(itemName == "hydrochloricAcid")
		{
			item = new hydrochloricAcid();
		}
		else if(itemName == "hydrogenPeroxide")
		{
			item = new hydrogenPeroxide();
		}
		else if(itemName == "nitricAcid")
		{
			item = new nitricAcid();
		}
		else if(itemName == "sulfuricAcid")
		{
			item = new sulfuricAcid();
		}
		else if(itemName == "acetonePeroxide")
		{
			item = new acetonePeroxide();
		}
		else if(itemName == "nitroGlycerine")
		{
			item = new nitroGlycerine();
		}
		else
		{
			item = new bottle();
		}
		items[counter] = item;
		//if(counter != 0) item.setContainerItem(items[0]);
		System.out.println(item.getUnlocalizedName() + " : " + counter);
		counter++;
		GameRegistry.registerItem(item, itemName);
	}
}
