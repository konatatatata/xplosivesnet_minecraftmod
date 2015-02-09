package com.xplosivesnet.devices;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xSynthesisHandler;

public class reactionVesselTile extends TileEntity
{
	private Item[] itemsHolding = new Item[xSynthesisHandler.arrayBounds];
	private int counter = 0;
	private boolean synthesisRunning = false;
	protected int synthesisRuntime = 1 * 20; //15 sec
	private int synthesisLeft = 0;
	private boolean validSynthesis = false;
	
	reactionVesselTile()
	{
		
	}
	
	private void reset()
	{
		//itemsHolding = new Item[xSynthesisHandler.arrayBounds];
		//counter = 0;
		synthesisRunning = false;
		synthesisLeft = 0;
		validSynthesis = false;
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
		for(Item item : this.itemsHolding)
		{
			if(item == null) break;
			xHelper.sendMessage(player, ">" + item.getUnlocalizedName().substring(5));
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
		
		getInfo(player);
		
		if(item.getUnlocalizedName().substring(5).equals("distilledWater"))
		{
			startSynthesis();
			xHelper.sendMessage(player, "----Synthesis started----");
			xHelper.sendMessage(player, xSynthesisHandler.getSynthesisOutput(itemsHolding[0], itemsHolding[1], itemsHolding[2], itemsHolding[3], itemsHolding[4]).toString());
			
		}
		
		return true;
	}
	
	private void addItem(Item item)
	{
		itemsHolding[counter] = item;
		counter++;
	}
	
	private void startSynthesis()
	{
		this.synthesisRunning = true;
		this.synthesisLeft = this.synthesisRuntime;
		
		int c = 0;
		
		if(xSynthesisHandler.validSynthesis(itemsHolding[0], itemsHolding[1], itemsHolding[2], itemsHolding[3], itemsHolding[4]))
		{
			this.validSynthesis = true;
		} else {
			this.validSynthesis = false;
		}
	}
	
	@Override
	public void updateEntity()
	{
		if(this.synthesisRunning)
		{
			if(this.synthesisLeft <= 0)
			{
				this.synthesisRunning = false;
				//this.clearItems();
				if(this.validSynthesis == false)
				{
					this.addItem(xItems.getItemByName("toxicWaste"));
				} else {
					Item[] output = xSynthesisHandler.getSynthesisOutput(itemsHolding[0], itemsHolding[1], itemsHolding[2], itemsHolding[3], itemsHolding[4]);
					if(output != null)
					{
						for(Item i : output)
						{
							if( i != null)
								this.addItem(i);
						}
					}
					else
					{
						this.addItem(xItems.getItemByName("toxicWaste"));
					}
					//this.reset();
				}
			}
			else
			{
				this.synthesisLeft--;
			}
		}
	}
	
	public Item fillBottle()
	{
		if(countItems() >= 1)
		{
			return this.removeLastItem();
		}
		return xItems.getItemByName("bottle");
	}
	
	public boolean canFillBottle()
	{
		if(countItems() >= 1)
		{
			return true;
		}
		return false;
	}
	
	private void clearItems()
	{
		this.itemsHolding = new Item[xSynthesisHandler.arrayBounds];
		this.counter = 0;
	}
	
	private Item removeLastItem()
	{
		Item toReturn = this.itemsHolding[this.counter - 1];
		this.itemsHolding[this.countItems()-1] = null;
		this.counter--;
		return toReturn;
	}
	
	private int countItems()
	{
		int c = 0;
		for(Item item : this.itemsHolding)
		{
			if(item != null) c++;
		}
		return c;
	}
}