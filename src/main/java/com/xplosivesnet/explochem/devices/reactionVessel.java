package com.xplosivesnet.explochem.devices;

import com.xplosivesnet.explochem.Helper;
import com.xplosivesnet.explochem.explo_tabs;
import com.xplosivesnet.explochem.explochem;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class reactionVessel extends BlockContainer
{
	private IIcon texture_top;
	private IIcon texture_bottom;
	private IIcon texture_side;
	//private IIcon texture_front;
	
	public reactionVessel()
	{
		super(Material.wood);
		this.setCreativeTab(explo_tabs.explo_tabs_machines);
		this.setBlockName("reactionVessel");
		this.setHardness(2f);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return null;
	}
	
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		Helper.sendMessage(player, "left clicked!");
    }
	
	public boolean onItemUse(ItemStack tool, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat)
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
		if(side == 0)
		{
			return this.texture_bottom;
		} else if(side == 1)
		{
			return this.texture_top;
		} else if(side == 2)
		{
			return this.texture_side;
		} else {
			return this.texture_side;
		}
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.texture_top = icon.registerIcon(explochem.MODID + ":" + this.getUnlocalizedName().substring(5) + "_top");
        this.texture_bottom = icon.registerIcon(explochem.MODID + ":" + this.getUnlocalizedName().substring(5) +"_bottom");
        this.texture_side = icon.registerIcon(explochem.MODID + ":" + this.getUnlocalizedName().substring(5) + "_side");
        
    }
}

