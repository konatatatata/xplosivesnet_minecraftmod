package com.xplosivesnet.explochem.components;
import com.xplosivesnet.explochem.xplosivesnet;
import com.xplosivesnet.explochem.xplosivesnet_tabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class acetone extends Item
{
	public acetone()
	{
		setMaxStackSize(1);
		setCreativeTab(xplosivesnet_tabs.explo_tabs_components);
		setUnlocalizedName("acetone");
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		return par1ItemStack;
	}

}



