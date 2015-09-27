package com.konatatatata.ores;

import java.util.Random;

import com.konatatatata.xHelper;
import com.konatatatata.xItems;
import com.konatatatata.xRealisticExplosives;
import com.konatatatata.xTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class genericOre extends BlockContainer
{
	private IIcon texture_top;
	private IIcon texture_bottom;
	private IIcon texture_side;
	private IIcon texture_front;
	private IIcon texture_generic;
	
	
	private boolean customTexture = false;
	
	public genericOre(String name, float hardness, boolean textureEachSide, int l)
	{
		super(Material.rock);
		this.setCreativeTab(xTabs.ores);
		this.setBlockName(name);
		this.setHardness(hardness);
		this.customTexture = textureEachSide;
		this.setHarvestLevel("pickaxe", l);
	}

	public TileEntity createNewTileEntity(World world)
	{
		return null;
	}

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		
	}

	public boolean onItemUse(ItemStack tool, EntityPlayer player, World world,
			int x, int y, int z, int par7, float xFloat, float yFloat,
			float zFloat) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if(!customTexture)
		{
			return this.texture_generic;
		} else if (side == 0) {
			return this.texture_bottom;
		} else if (side == 1) {
			return this.texture_top;
		} else if (side == 2) {
			return this.texture_side;
		} else {
			return this.texture_front;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		if(this.customTexture)
		{
			this.texture_top = icon.registerIcon(xRealisticExplosives.MODID + ":ores/" + this.getUnlocalizedName().substring(5) + "_top");
			this.texture_bottom = icon.registerIcon(xRealisticExplosives.MODID + ":ores/" + this.getUnlocalizedName().substring(5) + "_bottom");
			this.texture_side = icon.registerIcon(xRealisticExplosives.MODID + ":ores/"	+ this.getUnlocalizedName().substring(5) + "_side");
			this.texture_front = icon.registerIcon(xRealisticExplosives.MODID + ":ores/"	+ this.getUnlocalizedName().substring(5) + "_side");
		} else {
			this.texture_generic = icon.registerIcon(xRealisticExplosives.MODID + ":ores/" + this.getUnlocalizedName().substring(5));
		}
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return null;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_)
    {
		
    }
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		if(this.getUnlocalizedName().substring(5).equals("sulfur"))
        {
			return xItems.getItemByName("sulphurDust");
        }
		else
		{
			return Item.getItemFromBlock(this);
		}
    }
	
	@Override
	public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
    {
        return this.quantityDropped(p_149679_2_) + p_149679_2_.nextInt(p_149679_1_ + 1);
    }
	
	@Override
    public int quantityDropped(Random p_149745_1_)
    {
		if(this.getUnlocalizedName().substring(5).equals("sulfur"))
        {
			return xHelper.randomInt(2, 5);
        }
		return 1;
    }
}
