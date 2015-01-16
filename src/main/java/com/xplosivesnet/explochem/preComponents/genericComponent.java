package com.xplosivesnet.explochem.preComponents;

import com.xplosivesnet.explochem.xplosivesnet;
import com.xplosivesnet.explochem.xplosivesnet_items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class genericComponent  extends Item
{
	public genericComponent(String componentName, CreativeTabs tab, int maxStack)
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
