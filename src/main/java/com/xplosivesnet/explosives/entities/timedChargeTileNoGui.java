package com.xplosivesnet.explosives.entities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.xplosivesnet.xHelper;



public class timedChargeTileNoGui extends TileEntity
{
	private static float timeDef = 30;
	private static float timeLeft = timeDef;
	private static float maxTime = 30 * 10;
	private static boolean fused = false;
	private float chance;
	
	public timedChargeTileNoGui(float chance)
	{
		this.chance = chance;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
		super.writeToNBT(par1);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
		super.readFromNBT(par1);
	}
	
	public static void fuse()
	{
		fused = true;
	}
	
	public void clicked(EntityPlayer player)
	{
		if(!fused)
		{
			if(timeLeft == maxTime)
			{
				timeLeft = timeDef;
			}
			else
			{
				timeLeft = timeLeft + timeDef;
			}
		}
		xHelper.sendMessage(player, "Timer: " + timeLeft + " s");
	}
	
	@Override
	public void updateEntity()
	{
		if(fused)
		{
			timeLeft = timeLeft - (1f / 20);
			double dx = (double)(this.xCoord);
			double dy = (double)(this.yCoord);
			double dz = (double)(this.zCoord);
			if(timeLeft < 0)
			{
				genericExplosion genericExplosion = new genericExplosion(this.worldObj, 0, dx , dy, dz, 1.5f, null, this.chance);
				this.worldObj.spawnEntityInWorld(genericExplosion);
			}
			this.worldObj.spawnParticle("splash", dx, dy, dz+0.5, 0.0D, 0.0D, 0.0D);
		}
	}
}
