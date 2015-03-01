package com.xplosivesnet.explosives;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xTabs;
import com.xplosivesnet.explosives.entities.genericExplosion;
import com.xplosivesnet.models.tileGenericCustomModelExplosive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class genericCustomModelExplosive extends BlockContainer
{
	public float sensitivity;
	
	@SideOnly(Side.CLIENT)
	private IIcon texture_generic;

	private boolean customTexture;
    private static final String __OBFID = "CL_00000324";

    private boolean explodeOnHit;
    private boolean needsIni;
    private float strength;
    private boolean explodeOnPower;
    private float chance;
    
    public genericCustomModelExplosive(String name, float hardness, boolean customTexture, boolean explodeOnPower, boolean explodeOnHit, boolean needsIni, float strength, float chance)
    {
        super(Material.tnt);
        this.setCreativeTab(xTabs.explosives);
        this.setBlockName(name);
		this.setHardness(hardness);
		this.customTexture = customTexture;
		this.explodeOnHit = explodeOnHit;
		this.explodeOnPower = explodeOnPower;
		this.needsIni = needsIni;
		this.strength = strength;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		this.chance = chance;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.texture_generic;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        if(explodeOnPower)
        {
        	try
        	{
        		if (world.isBlockIndirectlyGettingPowered(x, y, z))
		        {
		            this.onBlockDestroyedByPlayer(world, x, y, z, 1);
		            world.setBlockToAir(x, y, z);
		        }
            }
        	catch (Exception e)
        	{
                 
            }
	        
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World world, int x, int y, int z, Block p_149695_5_)
    {
    	if(explodeOnPower)
    	{
	        if (world.isBlockIndirectlyGettingPowered(x, y, z))
	        {
	            try
	            {
	            	this.onBlockDestroyedByPlayer(world, x, y, z, 1);
	            	world.setBlockToAir(x, y, z);
	            	explode(world, x, y, z);
	            }
	            catch(Exception e)
	            {
	            	
	            }
	            
	        }
    	}
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explo)
    {
        if (!world.isRemote)
        {
        	explode(world, x, y, z, explo);
        }
    }

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    
    public void explode(World world, int x, int y, int z, Explosion explo)
    {
    	double dx = (double)((float)x + 0.5F);
    	double dy = (double)((float)y + 0.5F);
    	double dz = (double)((float)z + 0.5F);
    	genericExplosion genericExplosion = new genericExplosion(world, 0, dx , dy, dz, this.strength, explo.getExplosivePlacedBy(), this.chance);
    	world.spawnEntityInWorld(genericExplosion);
    }
    
    public void explode(World world, int x, int y, int z, EntityLivingBase ent)
    {
    	double dx = (double)((float)x + 0.5F);
    	double dy = (double)((float)y + 0.5F);
    	double dz = (double)((float)z + 0.5F);
    	genericExplosion genericExplosion = new genericExplosion(world, 0, dx , dy, dz, this.strength, ent, this.chance);
    	world.spawnEntityInWorld(genericExplosion);
    }
    
    public void explode(World world, int x, int y, int z)
    {
    	double dx = (double)((float)x + 0.5F);
    	double dy = (double)((float)y + 0.5F);
    	double dz = (double)((float)z + 0.5F);
    	genericExplosion genericExplosion = new genericExplosion(world, 0, dx , dy, dz, this.strength, null, this.chance);
    	world.spawnEntityInWorld(genericExplosion);
    }
    
    public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_)
    {
    	if(explodeOnHit)
    	{
    		this.blow(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_, (EntityLivingBase)null);
    	}
    }

    public void blow(World world, int x, int y, int z, int p_150114_5_, EntityLivingBase ent)
    {
        if (!world.isRemote)
        {
                explode(world, x, y, z, ent);
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	if(explodeOnHit)
    	{
    		this.blow(world, x, y, z, 0, (EntityLivingBase)null);
    	}
    	return false;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity entity)
    {
    	if(this.explodeOnHit)
    	{
	        if (entity instanceof EntityPlayer && !p_149670_1_.isRemote)
	        {
	        	this.blow(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, 1, (EntityLivingBase)entity);
	            p_149670_1_.setBlockToAir(p_149670_2_, p_149670_3_, p_149670_4_);
	        }
    	}
    }

    /**
     * Return whether this block can drop from an explosion.
     */
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
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new tileGenericCustomModelExplosive();
	}
	
	@Override
    public int getRenderType() {
            return -1;
    }
   
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
   
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }
	
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
    {
    	if(entity == null) return;
    	tileGenericCustomModelExplosive tile = (tileGenericCustomModelExplosive) world.getTileEntity(x, y, z);
    	tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360) + 0.5D) & 3;
    	
    }
    
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) || p_149742_1_.getBlock(p_149742_2_, p_149742_3_ - 1, p_149742_4_) == Blocks.glowstone;
    }
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
	
}
