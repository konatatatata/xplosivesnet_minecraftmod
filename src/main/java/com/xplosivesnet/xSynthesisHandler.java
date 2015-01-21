package com.xplosivesnet;

import java.util.Arrays;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class xSynthesisHandler
{
	public static int arrayBounds = 20;
	private static ItemStack[] vesselSynthesisInput = new ItemStack[arrayBounds];
	private static ItemStack[] vesselSynthesisOutput = new ItemStack[arrayBounds];
	private static int counter = 0;
	
	static void loadSynthesis()
	{
		xSynthesisHandler.addSynthesis(new ItemStack(xItems.getItemByName("ammoniumNitrate")), new ItemStack(xItems.getItemByName("potassiumNitrate")));
	}
	
	public static void addSynthesis(ItemStack input, ItemStack output)
	{
		vesselSynthesisInput[counter] = input;
		vesselSynthesisOutput[counter] = output;
		counter++;
	}
	
	public static boolean validSynthesis(ItemStack input)
	{
		if(input == null) return false;
		for(ItemStack syn : vesselSynthesisInput)
		{
			if(syn == input) return true;
		}
		return false;
	}
}
