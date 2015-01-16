package com.xplosivesnet.explochem.utilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.xplosivesnet;
import com.xplosivesnet.explochem.xplosivesnet_tabs;

public class bottle extends Item
{
	public bottle()
	{
		setMaxStackSize(1);
		setCreativeTab(xplosivesnet_tabs.components);
		setUnlocalizedName("bottle");
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity)
	{
		return itemstack;
	}
	
}
