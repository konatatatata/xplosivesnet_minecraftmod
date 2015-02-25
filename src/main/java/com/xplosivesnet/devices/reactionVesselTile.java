package com.xplosivesnet.devices;

import ic2.api.network.INetworkDataProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xSynthesisHandler;

import cpw.mods.fml.common.network.ByteBufUtils;

public class reactionVesselTile extends TileEntity 
{
	private Item[] itemsHolding = new Item[xSynthesisHandler.itemBounds];
	private Item[] synthesisOutput = new Item[xSynthesisHandler.itemBounds];
	
	private int counter = 0;
	private boolean synthesisRunning = false;
	protected int synthesisRuntime = 10 * 20; //10 sec
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
		System.out.println("nbt read");
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
        
        
        System.out.println("nbt write");
        
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
			if(player.worldObj.isRemote) xHelper.sendMessage(player, "-Synthesis running: " + this.synthesisLeft + "-");
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
			if(player.worldObj.isRemote) xHelper.sendMessage(player, "-Synthesis running: " + this.synthesisLeft + "-");
			return false;
		}
		
		itemsHolding[counter] = item;
		counter++;
		
		//getInfo(player);
		
		if(xSynthesisHandler.validSynthesis(itemsHolding))
		{
			synthesisOutput = xSynthesisHandler.getSynthesisOutput(itemsHolding);
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