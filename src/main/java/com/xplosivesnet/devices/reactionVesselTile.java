package com.xplosivesnet.devices;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.xplosivesnet.xAchievements;
import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xSynthesisHandler;

public class reactionVesselTile extends TileEntity
{
	public Item[] itemsHolding = new Item[xSynthesisHandler.itemBounds];
	private Item[] synthesisOutput = new Item[xSynthesisHandler.itemBounds];
	
	private int counter = 0;
	public boolean synthesisRunning = false;
	private int synthesisRuntime = 10 * 20; //10 sec, re-set by synthesis handler!
	private int synthesisLeft = 0;
	private boolean validSynthesis = false;
	
	reactionVesselTile()
	{
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
		
		this.counter = par1.getInteger("counter");
		this.synthesisRunning = par1.getBoolean("synthesisRunning");
		this.synthesisRuntime = par1.getInteger("synthesisRuntime");
		this.synthesisLeft = par1.getInteger("synthesisLeft");
		this.validSynthesis = par1.getBoolean("validSynthesis");
		
		NBTTagList nbttaglist = par1.getTagList("Items", xSynthesisHandler.itemBounds);
		this.itemsHolding = new Item[xSynthesisHandler.itemBounds];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            //this.itemsHolding[i] = ItemStack.loadItemStackFromNBT(nbttagcompound1).getItem();
            
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.itemsHolding.length)
            {
                this.itemsHolding[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1).getItem();
            }
            
        }
		super.readFromNBT(par1);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
		
		par1.setInteger("counter", this.counter);
		par1.setBoolean("synthesisRunning", this.synthesisRunning);
		par1.setInteger("synthesisRuntime", this.synthesisRuntime);
		par1.setInteger("synthesisLeft", this.synthesisLeft);
		par1.setBoolean("validSynthesis", this.validSynthesis);
		
		NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.itemsHolding.length; ++i)
        {
        	NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)i);
            new ItemStack(this.itemsHolding[i]).writeToNBT(nbttagcompound1);
            nbttaglist.appendTag(nbttagcompound1);
        }
        par1.setTag("Items", nbttaglist);
        super.writeToNBT(par1);
	}
	
	private void reset()
	{
		itemsHolding = new Item[xSynthesisHandler.arrayBounds];
		counter = 0;
		synthesisRunning = false;
		synthesisLeft = 0;
		validSynthesis = false;
	}
	
	public void getInfo(EntityPlayer player)
	{
		if(this.synthesisRunning)
		{
			if(player.worldObj.isRemote) xHelper.sendMessage(player, "Synthesis running: " + Math.round(this.synthesisLeft / 20) + "s");
		}
		else
		{
			if(player.worldObj.isRemote) xHelper.sendMessage(player, "Holding " + countItems() + "/" + itemsHolding.length);
		}
		for(Item item : this.itemsHolding)
		{
			if(item == null) break;
			if(player.worldObj.isRemote) xHelper.sendMessage(player, ">" + item.getUnlocalizedName().substring(5));
		}
	}
		
	public boolean addItem(Item item, EntityPlayer player)
	{
		if(itemsHolding.length == countItems())
		{
			if(player.worldObj.isRemote) xHelper.sendMessage(player, "-----Vessel full-----");
			return false;
		}
		if(this.synthesisRunning)
		{
			if(player.worldObj.isRemote) xHelper.sendMessage(player, "-Synthesis running: " + Math.round(this.synthesisLeft / 20) + "s");
			return false;
		}
		
		itemsHolding[counter] = item;
		counter++;
		
		//getInfo(player);
		
		if(xSynthesisHandler.validSynthesis(itemsHolding))
		{
			synthesisOutput = xSynthesisHandler.getSynthesisOutput(itemsHolding);
			synthesisRuntime = xSynthesisHandler.getSynthesisTime(itemsHolding);
			startSynthesis();
			if(player.worldObj.isRemote) xHelper.sendMessage(player, "----Synthesis started----");
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
		this.validSynthesis = true;
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		if(this.synthesisRunning)
		{
			if(this.worldObj.isRemote)
			{
				double d = (float)this.xCoord + 0.5F;
				double d1 = (float)this.yCoord + 1F;
				double d2 = (float)this.zCoord + 0.5F;
			    
				this.worldObj.spawnParticle("smoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
				this.worldObj.spawnParticle("flame", d, d1, d2, 0.0D, 0.0D, 0.0D);
			}
			if(this.synthesisLeft <= 0)
			{
				this.synthesisRunning = false;
				if(this.validSynthesis == false)
				{
					this.addItem(xItems.getItemByName("toxicWaste"));
				} else {
					reset();
					for(Item item : synthesisOutput)
					{
						if(item == null) break;
						this.addItem(item);
					}
				}
			}
			else
			{
				this.synthesisLeft--;
			}
		}
		this.getWorldObj().notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType());
	}
	
	public Item fillBottle(EntityPlayer player)
	{
		if(countItems() >= 1)
		{
			Item lastItem = removeLastItem();
			if(lastItem.getUnlocalizedName().substring(5).equals("ammoniumNitrate")) player.addStat(xAchievements.getByName("craftAN"), 1);
			if(lastItem.getUnlocalizedName().substring(5).equals("AMMONAL")) player.addStat(xAchievements.getByName("craftAMMONAL"), 1);
			if(lastItem.getUnlocalizedName().substring(5).equals("APEX")) player.addStat(xAchievements.getByName("craftINI"), 1);
			if(lastItem.getUnlocalizedName().substring(5).equals("HMTD")) player.addStat(xAchievements.getByName("craftINI"), 1);
			
			return lastItem;
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
			if(item != null)
			{
				c++;
			}
			else
			{
				break;
			}
		}
		return c;
	}
}