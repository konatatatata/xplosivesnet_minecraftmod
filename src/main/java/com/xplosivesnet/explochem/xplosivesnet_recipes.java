package com.xplosivesnet.explochem;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_recipes
{
	public static void loadRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(Items.apple), new Object[]
			{
		    	"AAA",
		    	"AAA",
		    	"AAA",
		    	'A', Items.cookie
			});
		
	}
}
