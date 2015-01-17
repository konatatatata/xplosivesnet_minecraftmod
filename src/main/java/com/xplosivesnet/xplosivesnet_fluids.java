package com.xplosivesnet;

import net.minecraft.util.DamageSource;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.xplosivesnet.fluids.genericFluid;

import cpw.mods.fml.common.registry.GameRegistry;

public class xplosivesnet_fluids
{
	public static Fluid[] xplosivesnet_fluids = new Fluid[10];
	private static int counter = 0;
	
	public static void loadFluids()
	{
		//void addFluid(String fluidName, int density, int particleType, boolean doDamage, float damage, boolean destroyItems, DamageSource dmg)
		addFluid("acetone", 300, 1, true, 0.5f, false, xplosivesnet_damageSource.poison);
		addFluid("glycerine", 300, 0, false, 0.0f, false, null);
		addFluid("hydrochloricAcid", 300, 2, true, 2f, true, xplosivesnet_damageSource.acid);
		addFluid("hydrogenPeroxide", 300, 2, true, 3f, true, xplosivesnet_damageSource.acid);
		addFluid("nitricAcid", 300, 2, true, 2f, true, xplosivesnet_damageSource.acid);
		addFluid("nitroGlycerine", 300, 0, true, 1.5f, true, xplosivesnet_damageSource.acid);
		addFluid("sulfuricAcid", 300, 2, true, 2f, true, xplosivesnet_damageSource.acid);
	}
	
	public static void addFluid(String fluidName, int density, int particleType, boolean doDamage, float damage, boolean destroyItems, DamageSource dmg)
	{
		Fluid fluid = new Fluid(fluidName);
		xplosivesnet_fluids[counter] = fluid;
		counter++;
		FluidRegistry.registerFluid(fluid);
		BlockFluidClassic fluid_x = new genericFluid(fluid, density, particleType, doDamage, damage, destroyItems, dmg);
		fluid_x.setBlockName("fluid_" + fluidName);
		GameRegistry.registerBlock(fluid_x, xplosivesnet.MODID + ":" + fluid_x.getUnlocalizedName().substring(5));
		fluid.setUnlocalizedName(fluid_x.getUnlocalizedName());
	}
}
