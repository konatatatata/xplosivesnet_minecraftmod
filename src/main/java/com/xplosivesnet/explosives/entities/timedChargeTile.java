package com.xplosivesnet.explosives.entities;

import com.xplosivesnet.guis.guiTimedCharge;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class timedChargeTile extends TileEntity
{
   private static boolean fused = false;
   private static float sec = 30;
   
   private static World world;
   private static int posx, posy, posz;
   private static boolean locSet = false;
   
   private static int tickCounter = 20;
   private static boolean blown = false;
   
   private static double rnd;
   
   private static timedChargeTile tile;
   
   public timedChargeTile(int x, int y, int z)
   {
	   fused = false;
	   sec = 30;
	   tickCounter = 20;
	   blown = false;
	   locSet = false;
	   this.posx = x;
	   this.posy = y;
	   this.posz = z;
	   tile = (timedChargeTile) this;
	   rnd = Math.random();
   }
   
   public static int getSecondsLeft()
   {
	   return Math.round(sec);
   }
   
   public static void openGui()
   {
	   //guiTimedCharge gui = new guiTimedCharge(tile);
	   guiTimedCharge gui = new guiTimedCharge(tile);
	   gui.show();
   }
   
   public static void increaseTime()
   {
	   if(sec < 120  && !fused) sec++;
   }
   
   public static void decreaseTime()
   {
	   if(sec >= 1 && !fused) sec--;
   }
   
   public static boolean isFused()
   {
	   return fused;
   }
   
   public static void fuse()
   {
	   fused = true;
   }
   
   @Override
   public void updateEntity()
   {
	   if(fused)
	   {
		   if(tickCounter <= 0)
		   {
			   //every second
			   tickCounter = 20;
		   }
		   else
		   {
			   tickCounter--;
		   }
		   
		   if(sec >= 0)
		   {
			   sec = sec - (1f/20);
		   }
		   else
		   {
			   if(!blown)
			   {
				   blown = true;
				   double dx = (double)(posx);
				   double dy = (double)(posy);
				   double dz = (double)(posz);
				   genericExplosion genericExplosion = new genericExplosion(world, 0, dx , dy, dz, 1.5f, null);
				   world.spawnEntityInWorld(genericExplosion);
				   
			   }
		   }
	   }
	   else
	   {
		   
	   }
   }
   
}
