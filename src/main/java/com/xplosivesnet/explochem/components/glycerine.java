package com.xplosivesnet.explochem.components;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.explo_fluids;
import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;

public class glycerine extends Item
{
	public glycerine()
	{
		setMaxStackSize(1);
		setCreativeTab(explo_tabs.explo_tabs_components);
		setUnlocalizedName("glycerine");
		setTextureName(explochem.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player)
	{
		if(explo_fluids.fluid_acetone.displaceIfPossible(world, 50, 75, 50))
		{
			return new ItemStack(new bottle());
		} else {
			return par1ItemStack;
		}		
	}
}



