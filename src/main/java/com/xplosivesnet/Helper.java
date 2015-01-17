package com.xplosivesnet;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;

public class Helper
{

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
	
	public static boolean isDouble(String in)
	{
		 try { 
			 Double.parseDouble(in);
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    return true;
	}
	
	public static Double getDouble(String in)
	{
		if(isDouble(in)) return Double.parseDouble(in);
		return null;
	}
	
	public static int getInt(String in)
	{
		if(isInteger(in)) return Integer.parseInt(in);
		return 0;
	}
	
	public static int getInt(Double in)
	{
		if(isInteger(in.toString())) return Integer.parseInt(in.toString());
		return 0;
	}
	
	public static boolean isPlayer(Entity ent)
	{
		if (ent.canAttackWithItem())
		{
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isPlayer(EntityPlayer ent)
	{
		if (ent.canAttackWithItem())
		{
			return true;
		} else {
			return false;
		}
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
		if(isPlayer(sender))
		{
			getPlayer(sender).addChatMessage(new ChatComponentTranslation(msg));
		} else {
			sender.addChatMessage(new ChatComponentTranslation(msg));
		}
	}
	
	public static void sendMessage(EntityPlayer sender, String msg)
	{
		if(isPlayer(sender))
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
	
	public static boolean isAlphaNumeric(String s){
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
	
}
