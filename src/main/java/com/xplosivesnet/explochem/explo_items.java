package com.xplosivesnet.explochem;

import net.minecraft.item.Item;

import com.xplosivesnet.explochem.components.acetone;
import com.xplosivesnet.explochem.components.bottle;
import com.xplosivesnet.explochem.components.glycerine;
import com.xplosivesnet.explochem.components.hydrochloricAcid;
import com.xplosivesnet.explochem.components.hydrogenPeroxide;
import com.xplosivesnet.explochem.components.nitricAcid;
import com.xplosivesnet.explochem.components.sulfuricAcid;
import com.xplosivesnet.explochem.explosives.initial.acetonePeroxide;
import com.xplosivesnet.explochem.explosives.initial.nitroGlycerine;

import cpw.mods.fml.common.registry.GameRegistry;

public class explo_items
{
	public static Item
		acetone, bottle, glycerine, 
		hydrochloricAcid, hydrogenPeroxide, nitricAcid, 
		sulfuricAcid, acetonePeroxide, nitroGlycerine;
	
	public static void loadItems()
	{
		//Components
		bottle = new bottle();
		acetone = new acetone();
		glycerine = new glycerine();
		hydrochloricAcid = new hydrochloricAcid();
		hydrogenPeroxide = new hydrogenPeroxide();
		nitricAcid = new nitricAcid();
		sulfuricAcid = new sulfuricAcid();
		
		//Explosives
		acetonePeroxide = new acetonePeroxide();
		nitroGlycerine = new nitroGlycerine();
		
		//Register stuff
		GameRegistry.registerItem(bottle, "bottle");
		GameRegistry.registerItem(acetone, "acetone");
		GameRegistry.registerItem(glycerine, "glycerine");
		GameRegistry.registerItem(hydrochloricAcid, "hydrochloricAcid");
		GameRegistry.registerItem(hydrogenPeroxide, "hydrogenPeroxide");
		GameRegistry.registerItem(nitricAcid, "nitricAcid");
		GameRegistry.registerItem(sulfuricAcid, "sulfuricAcid");
		GameRegistry.registerItem(acetonePeroxide, "acetonePeroxide");
		GameRegistry.registerItem(nitroGlycerine, "nitroGlycerine");
		
	}
}
