package com.xplosivesnet.utilities;

import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class bottle extends Item
{
	public bottle()
	{
		setMaxStackSize(1);
		setCreativeTab(xTabs.components);
		setUnlocalizedName("bottle");
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity)
	{
		return itemstack;
	}
	
}
