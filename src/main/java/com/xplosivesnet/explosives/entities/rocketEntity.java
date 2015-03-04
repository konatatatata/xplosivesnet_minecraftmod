package com.xplosivesnet.explosives.entities;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class rocketEntity extends Entity
{
	private boolean goDown = false;
	private double stepSize = 2;
	private double height = 0;
	private double hitX, hitZ;
	private float strength;
	private int soundCounter = 0;
	
    public rocketEntity(World world, double x, double y, double z, double hitX, double hitZ, float strength)
    {
    	super(world);
    	this.worldObj = world;
    	float force = 1f;
    	this.setSize(0.1F, 0.1F);
    	this.posX = x;
    	this.posY = y;
    	this.posZ = z;
    	this.hitX = hitX;
    	this.hitZ = hitZ;
    	this.strength = strength;
    	this.setPosition(this.posX, this.posY, this.posZ);
    }
    
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.soundCounter++;
        if(this.soundCounter >= 20)
        {
        	this.soundCounter = 0;
        	this.worldObj.playSoundAtEntity(this, "realistic_explosives:burning", 1f, 1f);
        }
        
    	this.worldObj.spawnParticle("smoke", (double)posX, (double)posY+1, (double)posZ, 0.0D, 0.0D, 0.0D);
    	if((height >= 200 || this.posY >= 230) && this.goDown == false)
    	{
    		goDown = true;
    		this.posX = this.hitX;
    		this.posZ = this.hitZ;
    	}
    	if(goDown)
    	{
    		this.posY = this.posY - stepSize;
    		this.height = this.height - stepSize;
    	}
    	else
    	{
    		this.posY = this.posY + stepSize;
    		this.height = this.height + stepSize;
    	}
    	
    	System.out.println(this.posX + " - " + this.posY);
    	
    	if(this.posY <= 5) explode();
    	if(didCollide()) explode();
    }
    
    private boolean didCollide()
    {
    	Block block = this.worldObj.getBlock((int)Math.round(this.posX), (int)Math.round(this.posY), (int)Math.round(this.posZ));
    	if(block.getMaterial() != Material.air) return true;
    	return false;
    }

    private void explode()
    {
    	genericExplosion genericExplosion = new genericExplosion(this.worldObj, 0, this.posX, this.posY, this.posZ, this.strength, null, 0.3f);
    	this.worldObj.spawnEntityInWorld(genericExplosion);
    	this.worldObj.spawnParticle("hugeexplosion", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
    	this.setDead();
    	this.setInvisible(true);
    }
    
	@Override
	protected void entityInit()
	{
		this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_)
	{
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_)
	{
		
	}
}