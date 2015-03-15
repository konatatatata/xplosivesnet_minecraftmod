package com.xplosivesnet.weapons;

import com.xplosivesnet.xTabs;
import com.xplosivesnet.xplosivesnet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class genericRocket extends Item
{
	public genericRocket(String name)
	{
		this.setUnlocalizedName(name);
		setCreativeTab(xTabs.weapons);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(xplosivesnet.MODID + ":weapons/" + this.getUnlocalizedName().substring(5));
    }

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int p_94599_1_)
    {
        return this.itemIcon;
    }
}
