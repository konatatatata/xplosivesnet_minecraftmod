package com.xplosivesnet.devices;

import com.xplosivesnet.xHelper;

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
	private Item[] itemsHolding = new Item[50];
	private int counter = 0;
	
	reactionVesselTile()
	{
		
	}
	
	public boolean addItem(Item itemStack, EntityPlayer player)
	{
		itemsHolding[counter] = itemStack;
		counter++;
		
		xHelper.sendMessage(player, "Vessel holding:");
		for(Item item : itemsHolding)
		{
			try
			{
				xHelper.sendMessage(player, item.getUnlocalizedName().substring(5));
		    }
		    catch (NullPointerException e)
			{
		       
		    }
		}
		
		return true;
	}
}