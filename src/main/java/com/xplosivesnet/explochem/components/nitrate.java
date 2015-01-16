package com.xplosivesnet.explochem.components;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.xplosivesnet;
import com.xplosivesnet.explochem.xplosivesnet_items;

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