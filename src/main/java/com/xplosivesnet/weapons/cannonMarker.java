package com.xplosivesnet.weapons;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xTabs;
import com.xplosivesnet.xWeapons;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;

public class cannonMarker extends Item
{
	private int x = 0, y = 0, z = 0;
	private boolean isSet = false;
	
	public cannonMarker()
	{
		this.maxStackSize = 1;
		this.setUnlocalizedName("cannonMarker");
		this.setCreativeTab(xTabs.weapons);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if( itemStack.stackTagCompound == null )
		{
			itemStack.setTagCompound( new NBTTagCompound( ));
		    System.out.println("created!");
		}
		
		//Vec3 posVec = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		//Vec3 lookVec = player.getLookVec();
		MovingObjectPosition mop = player.rayTrace(200, 1f);
		
		if(mop != null)
		{
			x = mop.blockX;
			y = mop.blockY;
			z = mop.blockZ;
			
			if(!this.isSet)
			{
				if(world.isRemote) xHelper.sendMessage(player, "Coords saved (" + x + "/" + y + "/" + z + ")");

			}
			else
			{
				xHelper.sendMessage(player, "Coords already set!");
			}
			if(y == Math.round(player.posY - player.getEyeHeight()) + 1)
			{
				xHelper.sendMessage(player, "Coords reset!");
				this.isSet = false;
			}
			xHelper.sendMessage(player, (Math.round(player.posY - player.getEyeHeight()) + 1) + " " + y);
		}
		
		return itemStack;
	}
	
	public void addInformation(ItemStack itemStack, String name, int i)
	{
	    if( itemStack.stackTagCompound == null )
	    	itemStack.setTagCompound( new NBTTagCompound( ) );
	    itemStack.getTagCompound().removeTag(name);
	    itemStack.getTagCompound().setInteger(name, i);
	    
	}
	
	
	 
}
