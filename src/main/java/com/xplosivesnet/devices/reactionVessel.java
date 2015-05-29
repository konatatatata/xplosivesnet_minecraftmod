package com.xplosivesnet.devices;

import ic2.api.energy.event.EnergyTileUnloadEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;
import com.xplosivesnet.xTabs;
import com.xplosivesnet.xplosivesnet;

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
		
	}

	public boolean onItemUse(ItemStack tool, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat)
	{
		return true;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		if(player == null) return false;
		reactionVesselTile tile = (reactionVesselTile) world.getTileEntity(x, y, z);
		
		if(!player.worldObj.isRemote)
		{
			xHelper.sendMessage(player, "Energy Stored: ");
			xHelper.sendMessage(player, tile.EUenergy + "/" + tile.EUmaxEnergy + "EU");
			xHelper.sendMessage(player, tile.RFenergy + "/" + tile.RFmaxEnergy + "RF");
			xHelper.sendMessage(player, "{infinite}");
		}
		
		if(player.inventory.getCurrentItem() == null)
		{
			return false;
		}
		ItemStack tool = player.inventory.getCurrentItem();
		if(tool.getItem() == null )
		{
			return false;
		}
		if(tile.synthesisRunning)
		{
			return true;
		}
		
		if(tool.stackSize == 0) return false;
	    
	    if(xItems.isComponentItem(tool.getItem().getUnlocalizedName().substring(5)))
	    {
	    	if(tool.getItem() == xItems.getItemByName("bottle"))
	    	{
	    		//fill bottle
	    		if(true)
	    		{
		    		if(tile.canFillBottle())
		    		{
		    			xHelper.giveItem(player, tile.fillBottle(player));
		    			tool.stackSize--;
		    			player.inventoryContainer.detectAndSendChanges();
		    		}
	    		}
	    	}
	    	else
	    	{
	    		//empty bottle
	    		if(true)
	    		{
		    		if(tile.addItem(tool.getItem(), player))
		    		{
		    			xHelper.giveItem(player, xItems.getItemByName("bottle"));
		    			tool.stackSize--;
		    			player.inventoryContainer.detectAndSendChanges();
		    		}
	    		}
	    	}
	    }
	    else
	    {
	    	//xHelper.sendMessage(player, "This is not a valid item");
	    }
	    return true;
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
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block p_149749_5_, int p_149749_6_)
    {
		reactionVesselTile tile = (reactionVesselTile) world.getTileEntity(x, y, z);
		for(Item i : tile.itemsHolding)
		{
			if(i == null) break;
			Entity ent = new EntityItem(world, x, y, z, new ItemStack(i));
			world.spawnEntityInWorld(ent);
		}
		
		EnergyTileUnloadEvent unloadEvent = new EnergyTileUnloadEvent(tile);
		MinecraftForge.EVENT_BUS.post(unloadEvent);
		
        world.removeTileEntity(x, y, z);
        world.markBlockForUpdate(x, y, z);
    }

}
