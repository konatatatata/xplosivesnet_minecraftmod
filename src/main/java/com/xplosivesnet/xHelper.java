package com.xplosivesnet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;

public class xHelper
{
	public static int randomInt(int min, int max)
	{

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void writeFile(String text, String file)
	{
		File out = new File(file);
		if(out.exists() && out.isFile()) out.delete();
		
		try {
			PrintWriter o = new PrintWriter(file);
			o.print(text);
			o.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static int countItems(Item[] items)
	{
		int i = 0;
		for(Item item : items)
		{
			if(item == null) break;
			i++;
		}
		return i;
	}
	
	public static boolean fileExists(String file)
	{
		File f = new File(file);
		
		if(f.exists() && f.isFile()) return true;
		return false;
	}
	
	public static String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }
	    reader.close();
	    return stringBuilder.toString();
	}
	
	public static void removeItem(EntityPlayer ep, ItemStack removeitem)
	{
		IInventory inv = ep.inventory;
		for(int i=0; i < inv.getSizeInventory(); i++)
		{
			if(inv.getStackInSlot(i) != null)
			{
				ItemStack j = inv.getStackInSlot(i);
				if(j.getItem() != null && j.getItem() == removeitem.getItem())
				{
					inv.setInventorySlotContents(i, null);
				}
			}
		}
	}
	
	public static void giveItem(EntityPlayer player, Item item)
	{
		if (!player.inventory.addItemStackToInventory(new ItemStack(item)))
        {
			player.dropPlayerItemWithRandomChoice(new ItemStack(item), false);
        }
		player.inventory.markDirty();
		player.inventory.inventoryChanged = true;
		player.inventoryContainer.detectAndSendChanges();
	}

	public static void giveItem(EntityPlayer player, ItemStack item)
	{
		if (!player.inventory.addItemStackToInventory(item))
        {
			player.dropPlayerItemWithRandomChoice(item, false);
        }
		player.inventory.markDirty();
		player.inventory.inventoryChanged = true;
	}
	
	public static void removeRecipe(ItemStack resultItem)
	{
	ItemStack recipeResult = null;
	ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
	for (int scan = 0; scan < recipes.size(); scan++)
	{
		 IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
		 if (tmpRecipe instanceof ShapedRecipes)
		 {
			 ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
			 recipeResult = recipe.getRecipeOutput();
		 }
		 if (tmpRecipe instanceof ShapelessRecipes)
		 {
			 ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
			 recipeResult = recipe.getRecipeOutput();
		 }
		 if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
		 {
			 recipes.remove(scan);
		 }
	}
	}

	public static void addPotionEffect(EntityPlayer player, Potion potion, int duration)
	{
		player.addPotionEffect((new PotionEffect(potion.id, duration, 0)));
	}
	
	public static boolean isInteger(String in)
	{
	    try { 
	        Integer.parseInt(in); 
	    } catch(NumberFormatException e) {
	        return false; 
	    }
	    return true;
	}
	
	public static boolean isBoolean(String in)
	{
	    try { 
	        Boolean.parseBoolean(in); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
	
	public static boolean isDouble(String in)
	{
		 try { 
			 Double.parseDouble(in);
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    return true;
	}
	
	public static boolean isFloat(String in)
	{
		 try { 
			 Float.parseFloat(in);
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    return true;
	}
	
	public static Double getDouble(String in)
	{
		if(isDouble(in)) return Double.parseDouble(in);
		System.out.println("Failed to parse! " + in);
		return null;
	}
	
	public static int getInt(String in)
	{
		if(isInteger(in)) return Integer.parseInt(in);
		System.out.println("Failed to parse! " + in);
		return 0;
	}
	
	public static boolean getBoolean(String in)
	{
		if(isBoolean(in)) return Boolean.parseBoolean(in);
		System.out.println("Failed to parse! " + in);
		return false;
	}
	
	public static int getInt(Double in)
	{
		if(isInteger(in.toString())) return Integer.parseInt(in.toString());
		System.out.println("Failed to parse! " + in);
		return 0;
	}
	
	public static float getFloat(String in)
	{
		if(isFloat(in.toString())) return Float.parseFloat(in.toString());
		System.out.println("Failed to parse! " + in);
		return 0f;
	}
	
	public static boolean isPlayer(Entity ent)
	{
		if(ent instanceof EntityPlayer)
			return true;
		return false;
	}
	
	public static boolean isPlayer(EntityPlayer ent)
	{
		if(ent instanceof EntityPlayer)
			return true;
		return false;
	}
	
	public static boolean isPlayer(ICommandSender sender)
	{
		if(sender instanceof EntityPlayer)
			return true;
		return false;
	}
	
	public static EntityPlayer getPlayer(ICommandSender sender)
	{
		if(isPlayer(sender))
		{
			return ((EntityPlayer) sender);
		}
		return null;
	}
	
	public static void attack(Entity player, DamageSource dms, float dmg)
	{
		player.attackEntityFrom(dms, dmg);
	}
	
	public static void destroy(Entity player)
	{
		player.attackEntityFrom(DamageSource.generic, 10f);
	}
	
	public static void sendMessage(ICommandSender sender, String msg)
	{
		if(isPlayer(sender) && !getPlayer(sender).worldObj.isRemote)
		{
			getPlayer(sender).addChatMessage(new ChatComponentTranslation(msg));
		} else {
			sender.addChatMessage(new ChatComponentTranslation(msg));
		}
	}
	
	public static void sendMessage(EntityPlayer sender, String msg)
	{
		if(isPlayer(sender) && !sender.worldObj.isRemote)
		{
			getPlayer(sender).addChatMessage(new ChatComponentTranslation(msg));
		} else {
			sender.addChatMessage(new ChatComponentTranslation(msg));
		}
	}
	
	public static void sendMessageToServer(String msg)
	{
		MinecraftServer.getServer().addChatMessage(new ChatComponentTranslation(msg));
	}
	
	public static boolean isAlphaNumeric(String s)
	{
	    String pattern= "^[a-zA-Z0-9]*$";
	    if(s.matches(pattern)){
	    	return true;
	    }
	    return false;   
	}
	
	public static int getDimension(EntityPlayer player)
	{
		return player.dimension;
	}
	
	public static int getDimension(ICommandSender sender)
	{
		return getPlayer(sender).dimension;
	}
	
	public static void writeFile(String text, String fileName, boolean append)
	{
		try
		{
			PrintWriter pw = new PrintWriter(new BufferedWriter( new FileWriter(fileName, append)));
			pw.write(text);
			pw.println();
			pw.close();
		}
		catch (IOException e)
		{
			
		}
	}
	
}
