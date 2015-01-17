package com.xplosivesnet.components;

import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xplosivesnet_items;
import com.xplosivesnet.xplosivesnet_tabs;

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
		setCreativeTab(xplosivesnet_tabs.components);
		setUnlocalizedName(name);
		setTextureName(xplosivesnet.MODID + ":components/" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if(isInBottle)
		{
			return new ItemStack(xplosivesnet_items.items[0]);
		}
		return itemstack;
	}
}
