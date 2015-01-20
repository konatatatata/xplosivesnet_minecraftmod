package com.xplosivesnet.devices;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class reactionVessel extends BlockContainer
{
	private IIcon texture_top;
	private IIcon texture_bottom;
	private IIcon texture_side;
	private IIcon texture_front;

	public reactionVessel()
	{
		super(Material.rock);
		this.setCreativeTab(xTabs.machines);
		this.setBlockName("reactionVessel");
		this.setHardness(2f);
	}

	public TileEntity createNewTileEntity(World world)
	{
		return new tile_reactionVessel();
	}

	public void onBlockClicked(World world, int x, int y, int z,
			EntityPlayer player) {
		xHelper.sendMessage(player, "left clicked!");
	}

	public boolean onItemUse(ItemStack tool, EntityPlayer player, World world,
			int x, int y, int z, int par7, float xFloat, float yFloat,
			float zFloat) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (side == 0) {
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
		this.texture_top = icon.registerIcon(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5) + "_top");
		this.texture_bottom = icon.registerIcon(xplosivesnet.MODID + ":" + this.getUnlocalizedName().substring(5) + "_bottom");
		this.texture_side = icon.registerIcon(xplosivesnet.MODID + ":"	+ this.getUnlocalizedName().substring(5) + "_side");
		this.texture_front = icon.registerIcon(xplosivesnet.MODID + ":"	+ this.getUnlocalizedName().substring(5) + "_side");
	}


	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return null;
	}
}
