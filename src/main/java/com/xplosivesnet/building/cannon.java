package com.xplosivesnet.building;

import com.xplosivesnet.explosives.entities.rocketEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class cannon extends BlockContainer
{

	public cannon()
	{
		super(Material.rock);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return null;
	}
	
	@SideOnly(Side.CLIENT)
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		rocketEntity rocketEntity = new rocketEntity(world, player, 1.0F);
        if (!world.isRemote)
        {
        	world.spawnEntityInWorld(rocketEntity);
        }
		return true;
    }
	

}
