package com.xplosivesnet.building;

import com.xplosivesnet.xTabs;
import com.xplosivesnet.xplosivesnet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class genericBuildingBlock extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon texture_generic;
	private boolean glassy = false;
	public genericBuildingBlock(String name, float hardness, float resistance, boolean glassy)
	{
		super(Material.rock);

		this.setCreativeTab(xTabs.building);
		this.setBlockName(name);
		this.setResistance(resistance);
		this.setHardness(hardness);
		this.glassy = glassy;
		this.setHarvestLevel("pickaxe", 2);
	}

	public boolean renderAsNormalBlock()
    {
        return true;
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.texture_generic;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		this.texture_generic = icon.registerIcon(xplosivesnet.MODID + ":building/" + this.getUnlocalizedName().substring(5));
	}
	
	public boolean isOpaqueCube()
	{
		return this.glassy;
	}
}
