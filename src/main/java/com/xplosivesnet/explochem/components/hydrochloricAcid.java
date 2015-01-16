package com.xplosivesnet.explochem.components;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.xplosivesnet;
import com.xplosivesnet.explochem.xplosivesnet_items;
import com.xplosivesnet.explochem.xplosivesnet_tabs;

public class hydrochloricAcid extends Item
{
	public hydrochloricAcid()
	{
		setMaxStackSize(1);
		setCreativeTab(xplosivesnet_tabs.components);
		setUnlocalizedName("hydrochloricAcid");
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		//place fluid
		return new ItemStack(xplosivesnet_items.items[0]);
	}
}



