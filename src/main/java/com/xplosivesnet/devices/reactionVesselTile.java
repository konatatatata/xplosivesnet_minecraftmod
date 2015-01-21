package com.xplosivesnet.devices;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xSynthesisHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class reactionVesselTile extends TileEntity
{
	private Item[] itemsHolding = new Item[xSynthesisHandler.arrayBounds];
	private int counter = 0;
	private boolean synthesisRunning = false;
	private int synthesisRuntime = 15 * 20; //15 sec
	private int synthesisLeft = 0;
	
	reactionVesselTile()
	{
		
	}
	
	public void getInfo(EntityPlayer player)
	{
		if(this.synthesisRunning)
		{
			xHelper.sendMessage(player, "-Synthesis running: " + this.synthesisLeft + "-");
		}
		else
		{
			xHelper.sendMessage(player, "Holding " + countItems() + "/" + itemsHolding.length);
		}
		if(xSynthesisHandler.validSynthesis(getItemsAsString()))
		{
			xHelper.sendMessage(player, "Synthesis valid");
		}
		else
		{
			xHelper.sendMessage(player, "Synthesis invalid");
		}
	}
		
	public boolean addItem(Item item, EntityPlayer player)
	{
		if(itemsHolding.length == countItems())
		{
			xHelper.sendMessage(player, "-----Vessel full-----");
			return false;
		}
		if(this.synthesisRunning)
		{
			xHelper.sendMessage(player, "-Synthesis running: " + this.synthesisLeft + "-");
			return false;
		}
		itemsHolding[counter] = item;
		counter++;
		
		xHelper.sendMessage(player, "Holding " + countItems() + "/" + itemsHolding.length);

		if(item.getUnlocalizedName().substring(5).equalsIgnoreCase("distilledWater"))
		{
			startSynthesis();
			xHelper.sendMessage(player, "----Synthesis started----");
		}
		
		return true;
	}
	
	private void startSynthesis()
	{
		this.synthesisRunning = true;
		this.synthesisLeft = this.synthesisRuntime;
	}

	@Override
	public void updateEntity()
	{
		if(this.synthesisRunning)
		{
			if(this.synthesisLeft <= 0)
			{
				this.synthesisRunning = false;
				this.itemsHolding[0] = xItems.getItemByName("potassiumNitrate");
				this.itemsHolding[1] = xItems.getItemByName("ammonia");
				this.counter = 2;
			}
			else
			{
				this.synthesisLeft--;
			}
		}
		else
		{
		
			if(xSynthesisHandler.validSynthesis(getItemsAsString()))
			{
				this.synthesisRunning = true;
				this.synthesisLeft = this.synthesisRuntime;
			}
		}
	}
	
	private void clearItems()
	{
		int counter = 0;
		for(Item item : itemsHolding)
		{
			if(item == null) break;
			itemsHolding[counter] = null;
			counter++;
		}
	}
	
	private int countItems()
	{
		int counter = 0;
		for(Item item : itemsHolding)
		{
			if(item == null) break;
			try
			{
				counter++;
		    }
		    catch (NullPointerException e)
			{
		       
		    }
		}
		return counter;
	}
	
	private String[] getItemsAsString_old()
	{
		String[] output = new String[xSynthesisHandler.arrayBounds];
		int counter = 0;
		for(Item item : itemsHolding)
		{
			if(item == null)
			{
				output[counter] = "";
			}
			else
			{
				output[counter] = item.getUnlocalizedName().substring(5);
			}
			counter++;
		}
		return output;
	}
	
	private String getItemsAsString()
	{
		String holding = "";
		int counter = 0;
		for(Item item : itemsHolding)
		{
			if(item == null)
			{
				break;
			}
			else
			{
				holding = holding + "," + item.getUnlocalizedName().substring(5);
			}
		}
		if(holding.length() >= 1) holding = holding.substring(1);
		if(holding.equals("")) return "";
		return holding;
	}
}