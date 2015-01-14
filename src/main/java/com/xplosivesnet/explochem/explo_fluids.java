package com.xplosivesnet.explochem;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.xplosivesnet.explochem.fluids.fluid_acetone;
import com.xplosivesnet.explochem.fluids.fluid_hydrogenPeroxide;
import com.xplosivesnet.explochem.fluids.fluid_nitroGlycerine;

import cpw.mods.fml.common.registry.GameRegistry;

public class explo_fluids
{
	public static Fluid acetone;
	public static fluid_acetone fluid_acetone;
	
	public static Fluid hydrogenPeroxide;
	public static fluid_hydrogenPeroxide fluid_hydrogenPeroxide;
	
	public static Fluid nitroGlycerine;
	public static fluid_nitroGlycerine fluid_nitroGlycerine;
	
	
	
	public static void loadFluids()
	{
		acetone = new Fluid("fluid_acetone");
		FluidRegistry.registerFluid(acetone);
		fluid_acetone = new fluid_acetone(acetone, Material.water);
		fluid_acetone.setBlockName("fluid_acetone");
		GameRegistry.registerBlock(fluid_acetone, explochem.MODID + ":" + fluid_acetone.getUnlocalizedName().substring(5));
		acetone.setUnlocalizedName(fluid_acetone.getUnlocalizedName());
		
		hydrogenPeroxide = new Fluid("fluid_hydrogenPeroxide");
		FluidRegistry.registerFluid(hydrogenPeroxide);
		fluid_hydrogenPeroxide = new fluid_hydrogenPeroxide(hydrogenPeroxide, Material.water);
		fluid_hydrogenPeroxide.setBlockName("fluid_hydrogenPeroxide");
		GameRegistry.registerBlock(fluid_hydrogenPeroxide, explochem.MODID + ":" + fluid_hydrogenPeroxide.getUnlocalizedName().substring(5));
		hydrogenPeroxide.setUnlocalizedName(fluid_hydrogenPeroxide.getUnlocalizedName());
		
		nitroGlycerine = new Fluid("fluid_nitroGlycerine");
		FluidRegistry.registerFluid(nitroGlycerine);
		fluid_nitroGlycerine = new fluid_nitroGlycerine(nitroGlycerine, Material.water);
		fluid_nitroGlycerine.setBlockName("fluid_nitroGlycerine");
		GameRegistry.registerBlock(fluid_nitroGlycerine, explochem.MODID + ":" + fluid_hydrogenPeroxide.getUnlocalizedName().substring(5));
		hydrogenPeroxide.setUnlocalizedName(fluid_nitroGlycerine.getUnlocalizedName());
		
		
		//FluidContainerRegistry.registerFluidContainer(new FluidStack(acetone, 1), new ItemStack(explo_items.acetone), new ItemStack(explo_items.bottle));
		
	}
	
}
