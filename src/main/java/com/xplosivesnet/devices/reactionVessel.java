package com.xplosivesnet.devices;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xTabs;
import com.xplosivesnet.models.tileGenericCustomModelExplosive;

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

	@SideOnly(Side.CLIENT)
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		//xHelper.sendMessage(player, "left clicked!");
		if (!world.isRemote)
		{
	    	reactionVesselTile tile = (reactionVesselTile) world.getTileEntity(x, y, z);
	    	tile.getInfo(player);
		}
	}

	public boolean onItemUse(ItemStack tool, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat)
	{
    	return false;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		if (!world.isRemote)
		{
			
			if(player == null) return false;
	    	reactionVesselTile tile = (reactionVesselTile) world.getTileEntity(x, y, z);
	    	
	    	if(player.getCurrentEquippedItem() == null)
	    	{
	    		tile.getInfo(player);
	    		return false;
	    	}
	    	Item item = player.getCurrentEquippedItem().getItem();
	    	if(item == null) return false;
	    	
	    	if(xItems.isComponentItem(item.getUnlocalizedName()))
	    	{
	    		if(item == xItems.getItemByName("bottle"))
	    		{
	    			if(tile.canFillBottle())
	    			{
	    				player.inventory.consumeInventoryItem(player.getCurrentEquippedItem().getItem());
	    				Item ret = tile.fillBottle();
	    				if(ret == null)
	    				{
	    					player.inventory.addItemStackToInventory(new ItemStack(xItems.getItemByName("bottle")));
	    				}
	    				else
	    				{
	    					player.inventory.addItemStackToInventory(new ItemStack(ret));
	    				}
	    				
	    				player.inventory.inventoryChanged = true;
	    				player.inventory.markDirty();
	    				return true;
	    			}
	    			return false;
	    		}
	    		if(tile.addItem(item, player))
	    		{
	    			player.inventory.consumeInventoryItem(player.getCurrentEquippedItem().getItem());
	    			player.inventory.addItemStackToInventory(new ItemStack(xItems.getItemByName("bottle")));
	    			player.inventory.inventoryChanged = true;
	    			player.inventory.markDirty();
	    			return true;
	    		}
	    		else
	    		{
	    			xHelper.sendMessage(player, "adding failed");
	    			return false;
	    		}
	    	} else {
	    		xHelper.sendMessage(player, "no valid item");
	    	}
	    	player.inventory.inventoryChanged = true;
		}
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
		return new reactionVesselTile();
	}
}
