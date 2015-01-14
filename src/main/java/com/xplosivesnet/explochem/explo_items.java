package com.xplosivesnet.explochem;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

import com.xplosivesnet.explochem.components.acetone;
import com.xplosivesnet.explochem.components.glycerine;
import com.xplosivesnet.explochem.components.hydrochloricAcid;
import com.xplosivesnet.explochem.components.hydrogenPeroxide;
import com.xplosivesnet.explochem.components.nitricAcid;
import com.xplosivesnet.explochem.components.sulfuricAcid;
import com.xplosivesnet.explochem.explosives.initial.acetonePeroxide;
import com.xplosivesnet.explochem.explosives.initial.nitroGlycerine;
import com.xplosivesnet.explochem.fluids.fluid_acetone;
import com.xplosivesnet.explochem.fluids.fluid_glycerine;
import com.xplosivesnet.explochem.utilities.bottle;

import cpw.mods.fml.common.registry.GameRegistry;

public class explo_items
{
	public static Item[] explo_items = new Item[10];
	private static int counter = 0;
	
	public static void loadItems()
	{
		addItem("bottle");
		addItem("acetone");
		addItem("glycerine");
		addItem("hydrochloricAcid");
		addItem("hydrogenPeroxide");
		addItem("nitricAcid");
		addItem("sulfuricAcid");
		addItem("acetonePeroxide");
		addItem("nitroGlycerine");
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
		} else {
			item = new bottle();
		}
		explo_items[counter] = item;
		if(counter != 0) item.setContainerItem(explo_items[0]);
		counter++;	
		GameRegistry.registerItem(item, itemName);
	}
}
