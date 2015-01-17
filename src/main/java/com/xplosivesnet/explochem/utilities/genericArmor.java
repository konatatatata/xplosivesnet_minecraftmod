package com.xplosivesnet.explochem.utilities;

import com.xplosivesnet.explochem.xplosivesnet;
import com.xplosivesnet.explochem.xplosivesnet_tabs;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class genericArmor extends ItemArmor
{
	public String textureName;

	public genericArmor(String unlocalizedName, ArmorMaterial material, int type)
	{
	    super(material, 0, type);
	    this.textureName = unlocalizedName;
	    setCreativeTab(xplosivesnet_tabs.components);
		setUnlocalizedName(unlocalizedName);
		setTextureName(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}

