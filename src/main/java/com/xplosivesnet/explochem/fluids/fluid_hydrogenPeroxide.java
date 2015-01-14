package com.xplosivesnet.explochem.fluids;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import com.xplosivesnet.explochem.Helper;
import com.xplosivesnet.explochem.explo_damageSource;
import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class fluid_hydrogenPeroxide extends BlockFluidClassic
{
	
	@SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

	public fluid_hydrogenPeroxide(Fluid fluid, Material material)
	{
		super(fluid, material);
		this.setCreativeTab(explo_tabs.explo_tabs_components);
		this.setDensity(1000);
	}
	
	@Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
   
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon(explochem.MODID + ":" + this.getUnlocalizedName().substring(5) + "_s");
            flowingIcon = register.registerIcon(explochem.MODID + ":" + this.getUnlocalizedName().substring(5) + "_f");
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
		if (Helper.isPlayer(player))
		{
			Helper.attack(player, explo_damageSource.acid_heavy, 4.0f);
		} else {
			Helper.destroy(player);
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
		
		world.spawnParticle("smoke", (double)(f1+f4), (double)f2, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
	}
	
}