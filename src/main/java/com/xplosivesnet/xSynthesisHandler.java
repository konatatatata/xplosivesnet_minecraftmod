package com.xplosivesnet;

import ic2.api.item.IC2Items;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xSynthesisHandler
{
	public static int arrayBounds = 100;
	public static int itemBounds = 10;
	private static Item[][] vesselSynthesisInput = new Item[arrayBounds][itemBounds];
	private static Item[][] vesselSynthesisOutput = new Item[arrayBounds][itemBounds];
	private static int counter = 0;
	
	static void loadSynthesis()
	{
		Item[] input, output;
		
		addSynthesis(new Item[] 
				{
					xItems.getItemByName("acetone"), 
					xItems.getItemByName("hydrochloricAcid"),
					xItems.getItemByName("hydrogenPeroxide"),
					xItems.getItemByName("distilledWater")
				}, new Item[] 
				{
					xItems.getItemByName("APEX"),
					xItems.getItemByName("toxicWaste")
				});
	
		addSynthesis(new Item[] 
				{
					xItems.getItemByName("hexamine"), 
					xItems.getItemByName("hydrochloricAcid"),
					xItems.getItemByName("hydrogenPeroxide"),
					xItems.getItemByName("distilledWater")
				}, new Item[] 
				{
					xItems.getItemByName("HMTD"),
					xItems.getItemByName("toxicWaste")
				});

		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("ammoniumNitrate");
		input[1] = xItems.getItemByName("potassiumCarbonate");
		input[2] = xItems.getItemByName("distilledWater");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("potassiumNitrate");
		output[1] = xItems.getItemByName("potassiumNitrate");
		output[2] = xItems.getItemByName("ammonia");
		addSynthesis(input, output);
		
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("carbon");
		input[1] = xItems.getItemByName("distilledWater");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("potassiumCarbonate");
		addSynthesis(input, output);
		
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("electrolyzer");
		input[1] = xItems.getItemByName("sulfur");
		input[2] = xItems.getItemByName("distilledWater");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("sulfuricAcid");
		addSynthesis(input, output);
		
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("sodiumNitrate");
		input[1] = xItems.getItemByName("sulfuricAcid");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("nitricAcid");
		addSynthesis(input, output);
		
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("ammoniumNitrate");
		input[1] = xItems.getItemByName("sulfuricAcid");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("nitricAcid");
		addSynthesis(input, output);
		
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("potassiumNitrate");
		input[1] = xItems.getItemByName("sulfuricAcid");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("nitricAcid");
		addSynthesis(input, output);
		
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("electrolyzer");
		input[1] = xItems.getItemByName("water");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("hydrochloricAcid");
		addSynthesis(input, output);
		
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("distilledWater");
		input[1] = xItems.getItemByName("ammonia");
		input[2] = xItems.getItemByName("formaldehyde");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("hexamine");
		output[1] = xItems.getItemByName("toxicWaste");
		addSynthesis(input, output);
		
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName("distilledWater");
		input[1] = xItems.getItemByName("heater");
		input[2] = xItems.getItemByName("carbon");
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName("formaldehyde");
		addSynthesis(input, output);

		addExp("ammoniumNitrate", "aluminium", "AMMONAL");
		addExp("ammoniumNitrate", "magnesium", "AMMONAL");
		addExp("ammoniumNitrate", "titanium", "AMMONAL");
		addExp("ammoniumNitrate", "carbon", "ANFO");
		
		addExp("potassiumNitrate", "magnesium", "FLASH");
		addExp("potassiumNitrate", "aluminium", "FLASH");
		addExp("potassiumNitrate", "titanium", "FLASH");

		printSynthesis();
	}
	
	static private void printSynthesis()
	{
		int c = 0;
		String file = "synthesis.txt";
		xHelper.writeFile("Synthesis mapping starting...", file, false);
		for(Item[] vsi : vesselSynthesisInput)
		{
			if(countItems(vsi) == 0) break;
			xHelper.writeFile("Input:", file, true);
			for(Item i : vsi)
			{
				if(i == null) break;
				xHelper.writeFile("<" + i.getUnlocalizedName().substring(5), file, true);
			}
			xHelper.writeFile("Output:", file, true);

			for(Item i : vesselSynthesisOutput[c])
			{
				if(i == null) break;
				xHelper.writeFile(">" + i.getUnlocalizedName().substring(5), file, true);
			}
			xHelper.writeFile("", file, true);
			c++;
		}
		xHelper.writeFile("...Synthesis mapping ended", file, true);
	}
	
	private static void addExp(String oxi, String metal, String out)
	{
		Item[] input, output;
		input = new Item[itemBounds];
		input[0] = xItems.getItemByName(oxi);
		input[1] = xItems.getItemByName(oxi);
		input[2] = xItems.getItemByName(metal);
		output = new Item[itemBounds];
		output[0] = xItems.getItemByName(out);
		output[1] = xItems.getItemByName(out);
		addSynthesis(input, output);
	}
	
	public static void addSynthesis(Item[] input, Item[] output)
	{
		vesselSynthesisInput[counter] = input;
		vesselSynthesisOutput[counter] = output;
		counter++;
	}
	
	public static Item[] getSynthesisOutput(Item[] input)
	{
		Item[] output = new Item[itemBounds];
		
		int vsc = 0;
		boolean valid = false;
		boolean found = false;
		for(Item[] vsi : vesselSynthesisInput)
		{
			if(vsi == null || found) break;
			valid = true;
			for(Item i : vsi)
			{
				if(i == null) break;
				if(!inArray(i, input))
				{
					valid = false;
				}
			}
			if(valid)
			{
				output = vesselSynthesisOutput[vsc];
				found = true;
				break;
			}
			vsc++;
		}
		
		
		return output;
	}
	
	public static Item[] getSynthesisInput(Item[] input)
	{
		Item[] output = new Item[itemBounds];
		
		int vsc = 0;
		boolean valid = false;
		boolean found = false;
		for(Item[] vsi : vesselSynthesisInput)
		{
			if(vsi == null || found) break;
			valid = true;
			for(Item i : vsi)
			{
				if(i == null) break;
				if(!inArray(i, input))
				{
					valid = false;
				}
			}
			if(valid)
			{
				output = vesselSynthesisInput[vsc];
				found = true;
				break;
			}
			vsc++;
		}
		
		
		return output;
	}
	
	private static int countItems(Item[] items)
	{
		int i = 0;
		for(Item item : items)
		{
			if(item == null) break;
			i++;
		}
		return i;
	}
	
	private static boolean inArray(Item a, Item[] b)
	{
		boolean contains = false;
		for(Item it : b)
		{
			if(it == null) break;
			if(it.getUnlocalizedName().substring(5).equals(a.getUnlocalizedName().substring(5)))
			{
				contains = true;
				break;
			}
		}
		return contains;
	}

	public static boolean validSynthesis(Item[] input)
	{
		if(countItems(getSynthesisOutput(input)) > 0 && countItems(input) == countItems(getSynthesisInput(input)))
		{
			return true;
		}
		return false;
	}
}
