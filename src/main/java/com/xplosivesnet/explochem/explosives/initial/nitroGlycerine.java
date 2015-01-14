package com.xplosivesnet.explochem.explosives.initial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;
import com.xplosivesnet.explochem.components.bottle;

public class nitroGlycerine extends Item
{
	public float sensitivity;
	
	public nitroGlycerine()
	{
		setMaxStackSize(1);
		setCreativeTab(explo_tabs.explo_tabs_explosives);
		setUnlocalizedName("nitroGlycerine");
		setTextureName(explochem.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	//Item rightclick
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		//place on ground
		return new ItemStack(new bottle());
	}
}



