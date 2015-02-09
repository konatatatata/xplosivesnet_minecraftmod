package com.xplosivesnet;

import java.lang.reflect.Array;
import java.util.Arrays;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xSynthesisHandler
{
	public static int arrayBounds = 20;
	public static int itemBounds = 5;
	private static Item[][] vesselSynthesisInput = new Item[arrayBounds][itemBounds];
	private static Item[][] vesselSynthesisOutput = new Item[arrayBounds][itemBounds];
	private static int counter = 0;
	
	static void loadSynthesis()
	{
		addSynthesis(xItems.getItemByName("ammoniumNitrate"), xItems.getItemByName("potassiumCarbonate"), xItems.getItemByName("distilledWater"), xItems.getItemByName("potassiumNitrate"));
		addSynthesis(xItems.getItemByName("acetone"), xItems.getItemByName("hydrochloricAcid"), xItems.getItemByName("hydrogenPeroxide"), xItems.getItemByName("distilledWater"), xItems.getItemByName("acetonePeroxide"));
		addSynthesis(xItems.getItemByName("hexamine"), xItems.getItemByName("hydrochloricAcid"), xItems.getItemByName("hydrogenPeroxide"), xItems.getItemByName("distilledWater"), xItems.getItemByName("HMTD"));
		
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
	
	public static void addSynthesis(Item a, Item b, Item c, Item d, Item oa)
	{
		addSynthesis(a, b, c, d, null, oa, null, null, null, null);
	}

	public static void addSynthesis(Item a, Item b, Item c, Item d, Item e, Item oa, Item ob, Item oc, Item od, Item oe)
	{
		Item[] unsorted = new Item[itemBounds];
		unsorted[0] = a;
		unsorted[1] = b;
		unsorted[2] = c;
		unsorted[3] = d;
		unsorted[4] = e;
		Item[] sorted = (unsorted);
		
		vesselSynthesisInput[counter][0] = sorted[0];
		vesselSynthesisInput[counter][1] = sorted[1];
		vesselSynthesisInput[counter][2] = sorted[2];
		vesselSynthesisInput[counter][3] = sorted[3];
		vesselSynthesisInput[counter][4] = sorted[4];
		vesselSynthesisOutput[counter][0] = oa;
		vesselSynthesisOutput[counter][1] = ob;
		vesselSynthesisOutput[counter][2] = oc;
		vesselSynthesisOutput[counter][3] = od;
		vesselSynthesisOutput[counter][4] = oe;
		counter++;
	}
	
	private static Item[] sortItems(Item[] unsorted)
	{
		Item[] sorted = new Item[itemBounds];
		
		
		//sorting cycle
		
		
		return unsorted;
	}
	
	public static boolean inArray(int[] arr, int x)
	{
		if(arr == null) return true;
		for(int ar : arr)
		{
			if(ar == x) return true;
		}
		return false;
	}

	public static boolean validSynthesis(Item a, Item b, Item c, Item d, Item e)
	{
		Item[] unsorted = new Item[itemBounds];
		unsorted[0] = a;
		unsorted[1] = b;
		unsorted[2] = c;
		unsorted[3] = d;
		unsorted[4] = e;
		Item[] sorted = sortItems(unsorted);
		
		for(Item[] input : vesselSynthesisInput)
		{
			if(input[0] == sorted[0])
			{
				if(input[1] == sorted[1])
				{
					if(input[2] == sorted[2])
					{
						if(input[3] == sorted[3])
						{
							if(input[4] == sorted[4])
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
	
	public static Item[] getSynthesisOutput(Item a, Item b, Item c, Item d, Item e)
	{
		int count = 0;
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
								return vesselSynthesisOutput[counter];
							}
						}
					}
				}
			}
			counter++;
		}
		return null;
	}
}
