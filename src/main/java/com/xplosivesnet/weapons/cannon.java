package com.xplosivesnet.weapons;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xTabs;
import com.xplosivesnet.xWeapons;
import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.explosives.entities.rocketEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class cannon extends BlockContainer
{
	EntityPlayer lastPlayer = null;
	private IIcon icon;
	
	public cannon()
	{
		super(Material.rock);
		this.setCreativeTab(xTabs.building);
		this.setBlockName("cannon");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new cannonTile(world);
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		cannonTile tile = (cannonTile) world.getTileEntity(x, y, z);
		ItemStack tool = player.inventory.getCurrentItem();
		if(tool != null)
		{
			if(xWeapons.isRocket(tool.getItem()))
			{
				if(tile.loadRocket(tool.getItem()))
				{
					tool.stackSize--;
				}
			}
			else if(tool.getItem() == xWeapons.cannonMarker)
			{
				if(world.isRemote) xHelper.sendMessage(player, "Coords imported");
				int hitX = tool.getTagCompound().getInteger("posX");
				int hitZ = tool.getTagCompound().getInteger("posZ");
				tile.hitX = hitX;
				tile.hitZ = hitZ;
			}
		}
		if(world.isRemote) xHelper.sendMessage(player, "Destination: " + tile.hitX + "/" + tile.hitZ);
		
		lastPlayer = player;
		tile.markDirty();
		return true;
    }
	
    @Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block p_149695_5_)
    {
    	cannonTile tile = (cannonTile) world.getTileEntity(x, y, z);
		if (world.isBlockIndirectlyGettingPowered(x, y, z))
		{
			if(tile.isRocketLoaded())
			{
				tile.fireRocket(lastPlayer);
				tile.markDirty();
				System.out.println("fired");
			}
    	}
    }
    
    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return this.icon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		this.icon = icon.registerIcon(xplosivesnet.MODID + ":weapons/" + this.getUnlocalizedName().substring(5));
	}

}
