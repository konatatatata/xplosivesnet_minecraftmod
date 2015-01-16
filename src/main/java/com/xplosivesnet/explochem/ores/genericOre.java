package com.xplosivesnet.explochem.ores;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.xplosivesnet.explochem.Helper;
import com.xplosivesnet.explochem.xplosivesnet;
import com.xplosivesnet.explochem.xplosivesnet_tabs;
import com.xplosivesnet.explochem.devices.tile_reactionVessel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class genericOre extends BlockContainer
{
	private IIcon texture_top;
	private IIcon texture_bottom;
	private IIcon texture_side;
	private IIcon texture_front;
	private IIcon texture_generic;
	
	
	private boolean customTexture = false;
	
	public genericOre(String name, float hardness, Material mat, boolean textureEachSide)
	{
		super(mat);
		this.setCreativeTab(xplosivesnet_tabs.ores);
		this.setBlockName(name);
		this.setHardness(hardness);
		this.customTexture = textureEachSide;
	}

	public TileEntity createNewTileEntity(World world)
	{
		return null;
	}

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		
	}

	public boolean onItemUse(ItemStack tool, EntityPlayer player, World world,
			int x, int y, int z, int par7, float xFloat, float yFloat,
			float zFloat) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if(!customTexture)
		{
			return this.texture_generic;
		} else if (side == 0) {
			return this.texture_bottom;
		} else if (side == 1) {
			return this.texture_top;
		} else if (side == 2) {
			return this.texture_side;
		} else {
			return this.texture_front;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		if(this.customTexture)
		{
			this.texture_top = icon.registerIcon(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5) + "_top");
			this.texture_bottom = icon.registerIcon(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5) + "_bottom");
			this.texture_side = icon.registerIcon(xplosivesnet.MODID + ":"	+ this.getUnlocalizedName().substring(5) + "_side");
			this.texture_front = icon.registerIcon(xplosivesnet.MODID + ":"	+ this.getUnlocalizedName().substring(5) + "_side");
		} else {
			this.texture_generic = icon.registerIcon(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5));
		}
	}


	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return null;
	}
}
