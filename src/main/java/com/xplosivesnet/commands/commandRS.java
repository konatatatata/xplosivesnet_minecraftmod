package com.xplosivesnet.commands;

import java.util.ArrayList;
import java.util.List;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xSynthesisHandler;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.Item;

public class commandRS implements ICommand
{ 
    private final List aliases;
  
  
    public commandRS() 
    { 
        aliases = new ArrayList();
        aliases.add("syn");

    } 
  
    @Override 
    public int compareTo(Object o)
    { 
        return 0; 

    } 

    @Override 
    public String getCommandName() 
    { 
        return "XRE"; 

    } 

    @Override         
    public String getCommandUsage(ICommandSender var1) 
    { 
        return "Help message";
    }

    @Override 
    public List getCommandAliases() 
    { 
        return this.aliases;

    } 

    @Override 
    public void processCommand(ICommandSender sender, String[] argString)
    { 
    	
    	if(argString.length == 1)
    	{
    		if(argString[0].equals("list"))
    		{
    			int i = 0;
    			String buffer = "";
    			for(Item item : xItems.getItems())
    			{
    				if(item == null) break;
    				if(i == 5)
    				{
    					xHelper.sendMessage(sender, buffer);
    					buffer = "";
    					i = 0;
    				}
    				else
    				{
    					if(i != 0)
    					{
    						buffer = buffer + ", " + item.getUnlocalizedName().substring(5);
    					}
    					else
    					{
    						buffer = item.getUnlocalizedName().substring(5);
    					}
    					i++;
    				}
    			}
    		}
    		else
    		{
    			if(xItems.isComponentItem(argString[0]))
    			{
    				int counter = 0;
    				for(Item[] items : xSynthesisHandler.getSynthesisBySingleItem(xItems.getItemByName(argString[0])))
    				{
    					if(xHelper.countItems(items) == 0) break;
    					xHelper.sendMessage(sender, "Input:");
    					for(Item i : items)
    					{
    						xHelper.sendMessage(sender, ">" + i.getUnlocalizedName().substring(5));
    					}
    					xHelper.sendMessage(sender, " ");
    					counter++;
    				}
    				if(counter == 0)
    				{
    					xHelper.sendMessage(sender, "Nothing found...");
    				}
    			}
    			else
    			{
    				xHelper.sendMessage(sender, "Unknown item, use /syn list");
    			}
    		}
    	}
    	else
    	{
    		xHelper.sendMessage(sender, "Use /syn <result>  OR /syn list");
    	}
    }

    @Override 
    public boolean canCommandSenderUseCommand(ICommandSender var1) 
    { 
        return true;

    } 

    @Override  
    public List addTabCompletionOptions(ICommandSender var1, String[] var2) 
    { 
        // TODO Auto-generated method stub 
        return null; 

    } 

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) 
    { 
        // TODO Auto-generated method stub 

        return false;

    } 

}
