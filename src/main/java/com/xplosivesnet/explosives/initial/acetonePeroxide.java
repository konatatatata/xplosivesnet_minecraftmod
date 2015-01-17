package com.xplosivesnet.explosives.initial;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xplosivesnet_tabs;
import com.xplosivesnet.utilities.bottle;

public class acetonePeroxide extends Item
{
	public float sensitivity;
	
	public acetonePeroxide()
	{
		setMaxStackSize(1);
		setCreativeTab(xplosivesnet_tabs.explosives);
		setUnlocalizedName("acetonePeroxide");
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	//Item rightclick
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	{
		//place on ground
		return new ItemStack(new bottle());
	}
}
