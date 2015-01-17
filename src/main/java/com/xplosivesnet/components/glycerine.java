package com.xplosivesnet.components;
import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xplosivesnet_items;
import com.xplosivesnet.xplosivesnet_tabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class glycerine extends Item
{
	public glycerine()
	{
		setMaxStackSize(1);
		setCreativeTab(xplosivesnet_tabs.components);
		setUnlocalizedName("glycerine");
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		//place fluid
		return new ItemStack(xplosivesnet_items.items[0]);	
	}
}



