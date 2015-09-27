package com.konatatatata.explosives.entities;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class genericExplosion extends Entity
{
    public int fuse;
    private int fused = 0;
    private EntityLivingBase tntPlacedBy;
    private static final String __OBFID = "CL_00001681";
    float strength;
    private float chance;
    public genericExplosion(World p_i1729_1_)
    {
        super(p_i1729_1_);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
    }

    public genericExplosion(World world, int fuse, double posX, double posY, double posZ, float strength, EntityLivingBase p_i1730_8_, float chance)
    {
        this(world);
        this.setPosition(posX, posY, posZ);
        this.strength = strength;
        this.fuse = fuse * 20;
        this.fused = 0;
        this.prevPosX = posX;
        this.prevPosY = posY;
        this.prevPosZ = posZ;
        this.tntPlacedBy = p_i1730_8_;
        this.chance = chance;
    }

    protected void entityInit() {}

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	

    	if(this.fuse <= this.fused)
    	{
    		if (!this.worldObj.isRemote)
            {
    			this.setDead();
                this.explode();
            }
    	}
    	else
    	{
    		this.fuse--;
    	}
    }

    private void explode()
    {
        this.createExplosion(this, this.posX, this.posY, this.posZ, this.strength, true, this.chance);
    }

    /**
     * Creates an explosion. Args: entity, x, y, z, strength
     */
    public Explosion createExplosion(Entity p_72876_1_, double p_72876_2_, double p_72876_4_, double p_72876_6_, float p_72876_8_, boolean p_72876_9_, float chance)
    {
        return this.newExplosion(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, false, p_72876_9_, chance);
    }

    /**
     * returns a new explosion. Does initiation (at time of writing Explosion is not finished)
     */
    public Explosion newExplosion(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_, boolean p_72885_10_, float chance)
    {
        Explosion explosion = new worldExplosion(worldObj, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_, chance);
        explosion.isFlaming = p_72885_9_;
        explosion.isSmoking = p_72885_10_;
        explosion.doExplosionA();
        explosion.doExplosionB(true);
        return explosion;
    }
    
    /**
     * (abstract) Protected xHelper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.setByte("Fuse", (byte)this.fuse);
    }

    /**
     * (abstract) Protected xHelper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        this.fuse = p_70037_1_.getByte("Fuse");
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    /**
     * returns null or the entityliving it was placed or ignited by
     */
    public EntityLivingBase getTntPlacedBy()
    {
        return this.tntPlacedBy;
    }
}