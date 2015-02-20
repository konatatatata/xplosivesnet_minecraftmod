package com.xplosivesnet.building;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class lockedDoorTile extends TileEntity
{
	private boolean opened = false;
    private boolean unlocked = true;
    private int keyID = 0;
	
	public lockedDoorTile()
	{
		
	}
	
	public boolean activated(World world, EntityPlayer player, int x, int y, int z)
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
    	return false;
	}
	
	private void open()
    {
    	//this.setBlockBounds(0f, 0f, 0f, 0.2f, 2f, 1f);
    	opened = true;
    }

    private void close()
    {
    	//this.setBlockBounds(0f, 0f, 0f, 1f, 2f, 0.2f);
    	opened = false;
    }
}
