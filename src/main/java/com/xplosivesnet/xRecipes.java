package com.xplosivesnet;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class xRecipes
{
	public static void loadRecipes()
	{
		//crafting
		GameRegistry.addRecipe(new ItemStack(Items.apple), new Object[]
			{
		    	"AAA",
		    	"AAA",
		    	"AAA",
		    	'A', Items.cookie
			});
		
		
		//smelting
		GameRegistry.addSmelting(xOres.getBlockById(0), new ItemStack(xItems.getItemById(15)), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockById(1), new ItemStack(xItems.getItemById(16)), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockById(2), new ItemStack(xItems.getItemById(17)), 0.5f);
		GameRegistry.addSmelting(xOres.getBlockById(3), new ItemStack(xItems.getItemById(18)), 0.5f); //ilmenite -> titaniumIngot
		
	}
}
