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
		GameRegistry.addSmelting(xOres.blocks[0], new ItemStack(xItems.items[15]), 0.5f);
		GameRegistry.addSmelting(xOres.blocks[1], new ItemStack(xItems.items[16]), 0.5f);
		GameRegistry.addSmelting(xOres.blocks[2], new ItemStack(xItems.items[17]), 0.5f);
		GameRegistry.addSmelting(xOres.blocks[3], new ItemStack(xItems.items[18]), 0.5f); //ilmenite -> titaniumIngot
		
	}
}
