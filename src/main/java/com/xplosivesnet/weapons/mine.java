package com.xplosivesnet.weapons;

import com.xplosivesnet.xTabs;
import com.xplosivesnet.models.tileMine;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class mine extends BlockContainer
{

	public mine()
	{
		super(Material.rock);
		this.setCreativeTab(xTabs.explosives);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		
		return new tileMine();
	}

}
