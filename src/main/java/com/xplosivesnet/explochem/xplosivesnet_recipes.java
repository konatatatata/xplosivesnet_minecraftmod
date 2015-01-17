package com.xplosivesnet.explochem;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_recipes
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
		GameRegistry.addSmelting(xplosivesnet_ores.blocks[0], new ItemStack(xplosivesnet_items.items[15]), 0.5f);
		GameRegistry.addSmelting(xplosivesnet_ores.blocks[1], new ItemStack(xplosivesnet_items.items[16]), 0.5f);
		GameRegistry.addSmelting(xplosivesnet_ores.blocks[2], new ItemStack(xplosivesnet_items.items[17]), 0.5f);
		GameRegistry.addSmelting(xplosivesnet_ores.blocks[3], new ItemStack(xplosivesnet_items.items[18]), 0.5f); //ilmenite -> titaniumIngot
		
	}
}
