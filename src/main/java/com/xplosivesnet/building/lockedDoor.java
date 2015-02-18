package com.xplosivesnet.building;

import java.util.Random;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xTabs;
import com.xplosivesnet.xplosivesnet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class lockedDoor extends BlockContainer
{
	
	@SideOnly(Side.CLIENT)
    private IIcon icon_upper;
    @SideOnly(Side.CLIENT)
    private IIcon icon_lower;

    private boolean opened = false;
    private boolean unlocked = true;
    private int keyID = 0;
    
	public lockedDoor()
	{
		super(Material.rock);
		this.setBlockBounds(0f, 0f, 0f, 1f, 1f, 1f);
		this.setBlockTextureName("lockedDoor");
		this.setCreativeTab(xTabs.building);
		this.setBlockName("lockedDoor");
		
		open();
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.icon_lower;
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
		return this.icon_lower;
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconReg)
    {
        this.icon_upper = iconReg.registerIcon(xplosivesnet.MODID + ":building/" + this.getTextureName() + "_upper");
        this.icon_lower = iconReg.registerIcon(xplosivesnet.MODID + ":building/" + this.getTextureName() + "_lower");
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 0;
    }
    
    private void open()
    {
    	this.setBlockBounds(0f, 0f, 0f, 0.2f, 2f, 1f);
    	opened = true;
    }

    private void close()
    {
    	this.setBlockBounds(0f, 0f, 0f, 1f, 2f, 0.2f);
    	opened = false;
    }
    
    public boolean onItemUse(ItemStack tool, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat)
	{
    	return false;
	}
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	if(world.isRemote)
    	{
    		if(player.getCurrentEquippedItem() == null) return false;
	    	if(player.getCurrentEquippedItem().getItem() == xItems.getItemByName("itemKey"))
	    	{
	    		xHelper.sendMessage(player, "key!");
	    		if(this.opened)
	    		{
	    			if(world.isRemote) close();
	    			world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
	    		}
	    		else
	    		{
	    			if(world.isRemote) open();
	    			world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
	    		}
	    		return true;
	    	}
	    	xHelper.sendMessage(player, "wrong key!");
    	}
    	/*
    	if(this.unlocked)
    	{
    		if(this.opened)
    		{
    			if(world.isRemote) close();
    			world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
    		}
    		else
    		{
    			if(world.isRemote) open();
    			world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
    		}
    		return true;
    	}
    	*/
    	return false;
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new lockedDoorTile();
	}
}
