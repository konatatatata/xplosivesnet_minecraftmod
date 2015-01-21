package com.xplosivesnet;

import java.util.Arrays;

import net.minecraft.item.Item;

public class xSynthesisHandler
{
	public static int arrayBounds = 20;
	private static String[] vesselSynthesisInput = new String[arrayBounds];
	private static String[] vesselSynthesisOutput = new String[arrayBounds];
	private static int counter = 0;
	
	static void loadSynthesis()
	{
		xSynthesisHandler.addSynthesis("ammoniumNitrate,potassiumCarbonate", "potassiumNitrate");
	}
	
	public static void addSynthesis(String input, String output)
	{
		counter++;
	}
	
	public static boolean validSynthesis(String input)
	{
		if(input == null) return false;
		for(String syn : vesselSynthesisInput)
		{
			if(syn == null) return false;
			if(syn.equals(input)) return true;
		}
		return false;
	}
	
	public static String[] fixArrays(String[] input)
	{
		String[] output = new String[arrayBounds];
		int counter = 0;
		for(String in: input)
		{
			if(in == null)
			{
				output[counter] = "";
			}
			else
			{
				output[counter] = in;
			}
			counter++;
		}
		return output;
	}
}
