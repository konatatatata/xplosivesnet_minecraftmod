package com.konatatatata.weapons;

import com.konatatatata.xTabs;
import com.konatatatata.xRealisticExplosives;
import com.konatatatata.explosives.entities.genericExplosion;
import com.konatatatata.models.tileMine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;


public class mine extends BlockContainer
{

	private IIcon texture_generic;
	
	public mine()
	{
		super(Material.rock);
		this.setCreativeTab(xTabs.weapons);
		this.setBlockName("mine");
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.0625F, 1F);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new tileMine();
	}
	
	@Override
    public int getRenderType()
	{
            return -1;
    }
   
    @Override
    public boolean isOpaqueCube()
    {
            return false;
    }
   
    @Override
    public boolean renderAsNormalBlock()
    {
            return false;
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	world.setBlockToAir(x, y, z);
    	blow(world, x, y, z, (EntityLivingBase)null);
    }
    
    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
    	world.setBlockToAir(x, y, z);
    	blow(world, x, y, z, (EntityLivingBase)entity);
    }

    public void blow(World world, int x, int y, int z, EntityLivingBase ent)
    {
    	world.setBlockToAir(x, y, z);
        if (!world.isRemote)
        {
                explode(world, x, y, z, ent);
        }
    }
    
    public void explode(World world, int x, int y, int z, EntityLivingBase ent)
    {
    	double dx = (double)((float)x + 0.5F);
    	double dy = (double)((float)y + 0.5F);
    	double dz = (double)((float)z + 0.5F);
    	genericExplosion genericExplosion = new genericExplosion(world, 0, dx , dy, dz, 1.5f, ent, 0.1f);
    	world.spawnEntityInWorld(genericExplosion);
    }
    
    @Override
    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		this.texture_generic = icon.registerIcon(xRealisticExplosives.MODID + ":explosives/" + this.getUnlocalizedName().substring(5));
	}
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
    	if (!world.isRemote)
        {
            boolean flag = this.canPlaceBlockAt(world, x, y, z);

            if (!flag)
            {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
    }
    
    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explo)
    {
        if (!world.isRemote)
        {
        	world.setBlockToAir(x, y, z);
        	explode(world, x, y, z, null);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.texture_generic;
    }
    
}
