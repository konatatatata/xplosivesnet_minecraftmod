package com.xplosivesnet.explochem.components;
import com.xplosivesnet.explochem.explo_items;
import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class acetone extends Item
{
	long lastClick = 0;
	
	public acetone()
	{
		setMaxStackSize(1);
		setCreativeTab(explo_tabs.explo_tabs_components);
		setUnlocalizedName("acetone");
		setTextureName(explochem.MODID + ":" + this.getUnlocalizedName().substring(5));
		setContainerItem(explo_items.bottle);
	}
	
	@SideOnly(Side.CLIENT)
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(lastClick + 500 < System.currentTimeMillis())
		{
			//only usable every 500ms
			lastClick = System.currentTimeMillis();
			
		}
		return itemStack;
	}

}



