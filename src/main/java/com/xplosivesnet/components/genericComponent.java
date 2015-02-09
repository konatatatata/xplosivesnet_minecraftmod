package com.xplosivesnet.components;

import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class genericComponent extends Item
{
	private boolean isInBottle = false;
	
	public genericComponent(String name, boolean isInBottle, int maxStackSize)
	{
		setMaxStackSize(maxStackSize);
		setCreativeTab(xTabs.components);
		setUnlocalizedName(name);
		setTextureName(xplosivesnet.MODID + ":components/" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if(isInBottle)
		{
			//place
			//return new ItemStack(xItems.getItemByName("bottle"));
			if(this.getUnlocalizedName().substring(5).equals("water"))
			{
				
			}
		}
		return itemstack;
	}
}
