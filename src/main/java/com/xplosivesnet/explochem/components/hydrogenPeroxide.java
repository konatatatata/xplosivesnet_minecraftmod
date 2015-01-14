package com.xplosivesnet.explochem.components;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;

public class hydrogenPeroxide extends Item
{
	public hydrogenPeroxide()
	{
		setMaxStackSize(1);
		setCreativeTab(explo_tabs.explo_tabs_components);
		setUnlocalizedName("hydrogenPeroxide");
		setTextureName(explochem.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		//spawn on ground
		return new ItemStack(new bottle());
	}
}
