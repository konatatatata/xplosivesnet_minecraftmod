package com.xplosivesnet.explosives;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.xplosivesnet.xTabs;
import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.devices.reactionVesselTile;
import com.xplosivesnet.explosives.entities.genericExplosion;
import com.xplosivesnet.explosives.entities.timedChargeTile;
import com.xplosivesnet.guis.guiTimedCharge;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class timedCharge extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	private IIcon texture_generic;

    private static final String __OBFID = "CL_00000324";
  
    private static int x, y, z, id;
    
    public timedCharge(String name)
    {
        super(Material.rock);
        this.setCreativeTab(xTabs.explosives);
        this.setBlockName(name);
        this.setHardness(2f);
		this.setResistance(2f);
		this.setHarvestLevel("pickaxe", 0);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.texture_generic;
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
    	this.x = x;
    	this.y = y;
    	this.z = z;
    	this.id++;
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block p_149695_5_)
    {
    	if (world.isBlockIndirectlyGettingPowered(x, y, z))
        {
    		timedChargeTile tile = (timedChargeTile) world.getTileEntity(x, y, z);
    		tile.fuse();
        }
    }

    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explo)
    {
    	world.removeTileEntity(x, y, z);
    }
    
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int p_149664_5_)
    {
    	world.removeTileEntity(x, y, z);
    }

    @SideOnly(Side.CLIENT)
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	if (!world.isRemote)
		{
			if(player == null) return false;
			timedChargeTile tile = (timedChargeTile) world.getTileEntity(x, y, z);
			
	    	System.out.println("ID: " + id);
	    	tile.openGui();
	    	return true;
		}
    	return false;
    }
    
    
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
    	
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	
    }

    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		this.texture_generic = icon.registerIcon(xplosivesnet.MODID + ":explosives/" + this.getUnlocalizedName().substring(5));
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new timedChargeTile(x, y, z);
	}
		
	
}