package com.xplosivesnet.utilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xplosivesnet_tabs;

public class genericIngot extends Item
{
	public genericIngot(String name)
	{
		setMaxStackSize(64);
		setCreativeTab(xplosivesnet_tabs.components);
		setUnlocalizedName(name);
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity)
	{
		return itemstack;
	}
	
}