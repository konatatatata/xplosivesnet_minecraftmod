package com.xplosivesnet.weapons;

import com.xplosivesnet.xWeapons;
import com.xplosivesnet.explosives.entities.rocketEntity;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class cannonTile extends TileEntity
{
	private Item rocketHolding = null;
	public int hitX = 0, hitZ = 0;
	
	cannonTile(World world)
	{
		this.worldObj = world;
		this.hitX = this.xCoord;
		this.hitZ = this.zCoord;
	}
	
	public boolean isRocketLoaded()
	{
		if(rocketHolding == null) return false;
		return true;
	}
	
	public boolean loadRocket(Item rocket)
	{
		if(xWeapons.isRocket(rocket))
		{
			if(isRocketLoaded()) return false;
			rocketHolding = rocket;
			return true;
		}
		return false;
	}
	
	public void fireRocket()
	{
		rocketEntity rocketEntity = new rocketEntity(this.worldObj, this.xCoord, this.yCoord+2, this.zCoord, this.hitX, this.hitZ, xWeapons.getRocketStrength(rocketHolding));
		this.worldObj.spawnEntityInWorld(rocketEntity);
		this.rocketHolding = null;
		this.worldObj.playSoundAtEntity(rocketEntity, "minecraft:fire.fire", 1, 1);
	}

	public void setX(int integer)
	{
		this.hitX = integer;
	}
	
	public void setZ(int integer)
	{
		this.hitZ = integer;
	}
	
}
