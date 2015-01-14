package com.xplosivesnet.explochem.components;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.explo_fluids;
import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;
import com.xplosivesnet.explochem.utilities.bottle;

public class sulfuricAcid extends Item
{
	public sulfuricAcid()
	{
		setMaxStackSize(1);
		setCreativeTab(explo_tabs.explo_tabs_components);
		setUnlocalizedName("sulfuricAcid");
		setTextureName(explochem.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		return par1ItemStack;
	}
}



