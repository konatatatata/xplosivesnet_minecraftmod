package com.xplosivesnet.devices;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import buildcraft.api.core.EnumColor;
import buildcraft.api.transport.IInjectable;

import com.xplosivesnet.xAchievements;
import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xSynthesisHandler;

public class reactionVesselTile extends TileEntity implements IEnergySink, IInjectable
{
	public Item[] itemsHolding = new Item[xSynthesisHandler.itemBounds];
	private Item[] synthesisOutput = new Item[xSynthesisHandler.itemBounds];
	
	private int counter = 0;
	public boolean synthesisRunning = false;
	private int synthesisRuntime = 10 * 20; //10 sec, re-set by synthesis handler!
	private int synthesisLeft = 0;
	private boolean validSynthesis = false;
	
	public double energy = 0.0;
	public double maxEnergy = 1000.0;
	private boolean eInit;
	
	reactionVesselTile()
	{
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
		super.readFromNBT(par1);
		
		if(par1.hasKey("energy"))
		{
			this.energy = par1.getDouble("energy");
		}
		
		
		this.counter = par1.getInteger("counter");
		this.synthesisRunning = par1.getBoolean("synthesisRunning");
		this.synthesisRuntime = par1.getInteger("synthesisRuntime");
		this.synthesisLeft = par1.getInteger("synthesisLeft");
		this.validSynthesis = par1.getBoolean("validSynthesis");
		
		/*
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
        */
        
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
		par1.setDouble("energy", this.energy);
		
		
		par1.setInteger("counter", this.counter);
		par1.setBoolean("synthesisRunning", this.synthesisRunning);
		par1.setInteger("synthesisRuntime", this.synthesisRuntime);
		par1.setInteger("synthesisLeft", this.synthesisLeft);
		par1.setBoolean("validSynthesis", this.validSynthesis);
		
		/*
		NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.itemsHolding.length; ++i)
        {
        	NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)i);
            new ItemStack(this.itemsHolding[i]).writeToNBT(nbttagcompound1);
            nbttaglist.appendTag(nbttagcompound1);
        }
        par1.setTag("Items", nbttaglist);
        */
        
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
	
	public boolean addItem(Item item, EntityPlayer player)
	{
		if(itemsHolding.length == countItems())
		{
			return false;
		}
		if(this.synthesisRunning)
		{
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
		
		if(!worldObj.isRemote)
		{
			EnergyTileLoadEvent loadEvent = new EnergyTileLoadEvent(this);
			MinecraftForge.EVENT_BUS.post(loadEvent);
			eInit = true;
		}
		
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
				if(this.energy >= 8)
				{
					this.energy = this.energy - 8;
					this.synthesisLeft--;
				}
			}
		}
		else
		{
			
		}
		//this.getWorldObj().notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType());
		
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
	}
	
	@Override
	public void invalidate()
	{
		EnergyTileUnloadEvent unloadEvent = new EnergyTileUnloadEvent(this);
		MinecraftForge.EVENT_BUS.post(unloadEvent);
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
	
	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction)
	{
		return true;
	}

	@Override
	public double getDemandedEnergy()
	{
		return this.maxEnergy - this.energy;
	}

	@Override
	public int getSinkTier()
	{
		return 2;
	}
	
	@Override
	public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage)
	{
		if(this.energy >= this.maxEnergy) return amount;
		double freeEnergy = this.maxEnergy - this.energy;
		if(freeEnergy >= amount)
		{
			this.energy += amount;
			return 0.0;
		}
		else if (amount > freeEnergy)
		{
			this.energy = this.maxEnergy;
			return amount - freeEnergy;
		}
		return 0;
	}

	@Override
	public boolean canInjectItems(ForgeDirection from)
	{
		return true;
	}

	@Override
	public int injectItem(ItemStack stack, boolean doAdd, ForgeDirection from, EnumColor color)
	{
		int added = 0;
		for(int i = 0; i <= stack.stackSize; i++)
		{
			if(countItems() < xSynthesisHandler.itemBounds)
			{
				this.addItem(stack.getItem());
				added++;
			}
		}
		
		return added;
	}
}