package com.xplosivesnet.weapons;

import com.xplosivesnet.xHelper;
import com.xplosivesnet.xTabs;
import com.xplosivesnet.xWeapons;
import com.xplosivesnet.xplosivesnet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;

public class cannonMarker extends Item
{
	private int x = 0, y = 0, z = 0;

	public cannonMarker()
	{
		this.maxStackSize = 1;
		this.setUnlocalizedName("cannonMarker");
		this.setCreativeTab(xTabs.weapons);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if( itemStack.stackTagCompound == null )
		{
			itemStack.setTagCompound( new NBTTagCompound( ));
		}
		
		//Vec3 posVec = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		//Vec3 lookVec = player.getLookVec();
		if(world.isRemote)
		{
			MovingObjectPosition mop = player.rayTrace(200, 1f);
		
			if(mop != null)
			{
				x = mop.blockX;
				y = mop.blockY;
				z = mop.blockZ;			
				
				if(!world.getBlock(x, y, z).getUnlocalizedName().equals(xWeapons.cannon.getUnlocalizedName()))
				{
					addInformation(itemStack, "posX", x);
					addInformation(itemStack, "posY", y);
					addInformation(itemStack, "posZ", z);
					if(world.isRemote) xHelper.sendMessage(player, "Coords saved (" + getInformation(itemStack, "posX") + "/" + getInformation(itemStack, "posY") + "/" + getInformation(itemStack, "posZ") + ")");
				}
				else
				{
					if(world.isRemote) xHelper.sendMessage(player, "cannon block, skipped");
				}
			}
		}
		
		return itemStack;
	}
	
	public void addInformation(ItemStack itemStack, String name, int i)
	{
	    if( itemStack.stackTagCompound == null )
	    	itemStack.setTagCompound( new NBTTagCompound( ) );
	    itemStack.getTagCompound().setInteger(name, i);
	    
	}
	
	public int getInformation(ItemStack itemStack, String name)
	{
		return itemStack.getTagCompound().getInteger(name);
	}
	

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(xplosivesnet.MODID + ":weapons/" + this.getUnlocalizedName().substring(5));
    }

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int p_94599_1_)
    {
        return this.itemIcon;
    }
	 
}
