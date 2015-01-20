package com.xplosivesnet.fluids;

import java.util.Random;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xplosivesnet;
import com.xplosivesnet.xDamageSource;
import com.xplosivesnet.xTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class genericFluid  extends BlockFluidClassic
{

	@SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    private boolean doDamage;
    private int particleType;
    private DamageSource damageSource;
    private boolean destroyItems;
    private float damage;
    
	public genericFluid(Fluid fluid, int density, int particleType, boolean doDamage, float damage, boolean destroyItems, DamageSource dmg)
	{
		super(fluid, Material.water);
		this.setCreativeTab(xTabs.components);
		this.setDensity(density);
		this.damageSource = dmg;
		this.doDamage = doDamage;
		this.particleType = particleType;
		this.destroyItems = destroyItems;
		this.damage = damage;
	}
	
	@Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
   
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon(xplosivesnet.MODID + ":fluids/" + this.getUnlocalizedName().substring(5) + "_s");
            flowingIcon = register.registerIcon(xplosivesnet.MODID + ":fluids/" + this.getUnlocalizedName().substring(5) + "_f");
    }
   
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
   
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
    
    public void onEntityCollidedWithBlock(World a, int b, int c, int d, Entity player)
    {
    	if(this.doDamage)
    	{
			if (xHelper.isPlayer(player))
			{
				xHelper.attack(player, this.damageSource, this.damage);
			} else {
				if(this.destroyItems) xHelper.attack(player, xDamageSource.poison, 1f);
			}
		}
    }
    
    @SideOnly(Side.CLIENT)
   	public void randomDisplayTick(World world, int x, int y, int z, Random random)
       {
   		float f1 = (float)x + 0.5F;
   		float f2 = (float)y + 1.1F;
   		float f3 =(float)z + 0.5F;
   		float f4 = random.nextFloat() * 0.3F;
   		float f5 = random.nextFloat() * -0.6F - -0.3F;
   		
   		switch(particleType)
   		{
   		case 0:
   			break;
   		case 1:
   			world.spawnParticle("splash", (double)(f1+f4), (double)f2, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
   			break;
   		case 2:
   			world.spawnParticle("smoke", (double)(f1+f4), (double)f2, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
   			break;
   		default:
   			break;
   		}
   		
   		
   	}

}
