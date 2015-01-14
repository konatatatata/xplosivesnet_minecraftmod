package com.xplosivesnet.explochem.utilities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.explo_items;
import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;

public class bottle extends Item
{
	public bottle()
	{
		setMaxStackSize(1);
		setCreativeTab(explo_tabs.explo_tabs_components);
		setUnlocalizedName("bottle");
		setTextureName(explochem.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity)
	{
		return itemstack;
	}
	
}
