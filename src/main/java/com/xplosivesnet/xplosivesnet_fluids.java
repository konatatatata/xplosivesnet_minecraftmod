package com.xplosivesnet;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.xplosivesnet.fluids.fluid_acetone;
import com.xplosivesnet.fluids.fluid_glycerine;
import com.xplosivesnet.fluids.fluid_hydrochloricAcid;
import com.xplosivesnet.fluids.fluid_hydrogenPeroxide;
import com.xplosivesnet.fluids.fluid_nitricAcid;
import com.xplosivesnet.fluids.fluid_nitroGlycerine;
import com.xplosivesnet.fluids.fluid_sulfuricAcid;

import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_fluids
{
	public static Fluid[] xplosivesnet_fluids = new Fluid[10];
	private static int counter = 0;
	
	public static void loadFluids()
	{
		addFluid("acetone");
		addFluid("glycerine");
		addFluid("hydrochloricAcid");
		addFluid("hydrogenPeroxide");
		addFluid("nitricAcid");
		addFluid("nitroGlycerine");
		addFluid("sulfuricAcid");
	}
	
	public static void addFluid(String fluidName)
	{
		Fluid fluid = new Fluid(fluidName);
		xplosivesnet_fluids[counter] = fluid;
		counter++;
		FluidRegistry.registerFluid(fluid);
		BlockFluidClassic fluid_x = getFluid(fluidName, fluid);
		fluid_x.setBlockName("fluid_" + fluidName);
		GameRegistry.registerBlock(fluid_x, xplosivesnet.MODID + ":" + fluid_x.getUnlocalizedName().substring(5));
		fluid.setUnlocalizedName(fluid_x.getUnlocalizedName());
	}
	
	private static BlockFluidClassic getFluid(String fluidName, Fluid fluid)
	{
		if(fluidName == "acetone")
		{
			return new fluid_acetone(fluid, Material.water);
		}
		else if(fluidName == "glycerine")
		{
			return new fluid_glycerine(fluid, Material.water);
		}
		else if(fluidName == "hydrochloricAcid")
		{
			return new fluid_hydrochloricAcid(fluid, Material.water);
		}
		else if(fluidName == "hydrogenPeroxide")
		{
			return new fluid_hydrogenPeroxide(fluid, Material.water);
		}
		else if(fluidName == "nitricAcid")
		{
			return new fluid_nitricAcid(fluid, Material.water);
		}
		else if(fluidName == "nitroGlycerine")
		{
			return new fluid_nitroGlycerine(fluid, Material.water);
		}
		else if(fluidName == "sulfuricAcid")
		{
			return new fluid_sulfuricAcid(fluid, Material.water);
		}
		else {
			return null;
		}
	}
}
