package com.xplosivesnet;

import java.util.Arrays;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xSynthesisHandler
{
	public static int arrayBounds = 20;
	private static Item[][] vesselSynthesisInput = new Item[arrayBounds][5];
	private static Item[][] vesselSynthesisOutput = new Item[arrayBounds][5];
	private static int counter = 0;
	
	static void loadSynthesis()
	{
		addSynthesis(xItems.getItemByName("ammoniumNitrate"), xItems.getItemByName("potassiumCarbonate"), xItems.getItemByName("destilledWater"), xItems.getItemByName("potassiumNitrate"));
	}
	
	public static void addSynthesis(Item a, Item oa)
	{
		addSynthesis(a, null, null, null, null, oa, null, null, null, null);
	}
	public static void addSynthesis(Item a, Item b, Item oa)
	{
		addSynthesis(a, b, null, null, null, oa, null, null, null, null);
	}
	public static void addSynthesis(Item a, Item b, Item c, Item oa)
	{
		addSynthesis(a, b, c, null, null, oa, null, null, null, null);
	}

	public static void addSynthesis(Item a, Item b, Item c, Item d, Item e, Item oa, Item ob, Item oc, Item od, Item oe)
	{
		vesselSynthesisInput[counter][0] = a;
		vesselSynthesisInput[counter][1] = b;
		vesselSynthesisInput[counter][2] = c;
		vesselSynthesisInput[counter][3] = d;
		vesselSynthesisInput[counter][4] = e;
		vesselSynthesisOutput[counter][0] = oa;
		vesselSynthesisOutput[counter][1] = ob;
		vesselSynthesisOutput[counter][2] = oc;
		vesselSynthesisOutput[counter][3] = od;
		vesselSynthesisOutput[counter][4] = oe;
		counter++;
	}
	
	public static boolean validSynthesis(Item a, Item b, Item c, Item d, Item e)
	{
		for(Item[] input : vesselSynthesisInput)
		{
			if(input[0] == a)
			{
				if(input[1] == b)
				{
					if(input[2] == c)
					{
						if(input[3] == d)
						{
							if(input[4] == e)
							{
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public static ItemStack getSynthesisOutput(ItemStack input)
	{
		return new ItemStack(Items.apple);
	}
}
