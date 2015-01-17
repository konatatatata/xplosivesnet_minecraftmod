package com.xplosivesnet.components;

import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xplosivesnet_items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class nitrate extends Item
{
	public nitrate(String componentName, CreativeTabs tab, int maxStack)
	{
		setMaxStackSize(maxStack);
		setCreativeTab(tab);
		setUnlocalizedName(componentName);
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		//place
		return new ItemStack(xplosivesnet_items.items[0]);
	}
}