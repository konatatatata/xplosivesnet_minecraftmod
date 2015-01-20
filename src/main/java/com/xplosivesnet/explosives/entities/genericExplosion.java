package com.xplosivesnet.explosives.entities;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class genericExplosion extends Entity
{
    /** How long the fuse is */
    public int fuse;
    private EntityLivingBase tntPlacedBy;
    private static final String __OBFID = "CL_00001681";
    private boolean triggerWalking = false;
    float strength;
    public genericExplosion(World p_i1729_1_)
    {
        super(p_i1729_1_);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
    }

    public genericExplosion(World world, int fuse, double posX, double posY, double posZ, float strength, EntityLivingBase p_i1730_8_)
    {
        this(world);
        this.setPosition(posX, posY, posZ);
        this.strength = strength;
        this.fuse = fuse;
        this.prevPosX = posX;
        this.prevPosY = posY;
        this.prevPosZ = posZ;
        this.tntPlacedBy = p_i1730_8_;
        this.triggerWalking = false;
    }

    protected void entityInit() {}

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return this.triggerWalking;
    }

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
    	this.setDead();

        if (!this.worldObj.isRemote)
        {
            this.explode();
        }
    }

    private void explode()
    {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.strength, true);
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