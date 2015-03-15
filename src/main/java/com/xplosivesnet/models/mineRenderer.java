package com.xplosivesnet.models;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.xplosivesnet.xplosivesnet;


public class mineRenderer extends TileEntitySpecialRenderer
{
    
    //The model of your block
    private final IModelCustom model;
    private ResourceLocation modelTexture;
    
    public mineRenderer(float rotate)
    {
            //this.model = new mine();
            //this.model.setRotationAngles(rotate, 0, 0, 0, 0, 0);
            
            this.model = AdvancedModelLoader.loadModel(new ResourceLocation(xplosivesnet.MODID + ":textures/blocks/explosives/models/mine.obj"));
            this.modelTexture = new ResourceLocation(xplosivesnet.MODID + ":textures/blocks/explosives/models/mineTex.png");
    }
   
    private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
    {
            int meta = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
            GL11.glPopMatrix();
    }
    
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
    	 GL11.glPushMatrix();
         GL11.glTranslated(x+0.5, y, z+0.5);
         GL11.glScaled(0.5, 0.5, 0.5);
         GL11.glRotatef(90, 0, 1, 0);
         bindTexture(modelTexture);
         model.renderAll();
         GL11.glPopMatrix();
    	
    	/*
    //The PushMatrix tells the renderer to "start" doing something.
            GL11.glPushMatrix();
    //This is setting the initial location.
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
    //This is the texture of your block. It's pathed to be the same place as your other blocks here.
            //Outdated bindTextureByName("/mods/roads/textures/blocks/TrafficLightPoleRed.png");
   //Use in 1.6.2  this
            ResourceLocation textures = (new ResourceLocation(xplosivesnet.MODID + ":textures/blocks/explosives/models/mine.png"));
    //the ':' is very important
    //binding the textures
            Minecraft.getMinecraft().renderEngine.bindTexture(textures);

    //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!                      
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            
            tileMine tile = (tileMine) te;
            int direction = tile.direction;
            GL11.glRotatef(direction * 90 + 90, 0f, 1f, 0f);
            
    //A reference to your Model file. Again, very important.
            this.model.renderAll();  //.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    //Tell it to stop rendering for both the PushMatrix's
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            
            */
    }

    //Set the lighting stuff, so it changes it's brightness properly.      
    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
            Tessellator tess = Tessellator.instance;
            //float brightness = block.getBlockBrightness(world, i, j, k);
            //As of MC 1.7+ block.getBlockBrightness() has become block.getLightValue():
            float brightness = block.getLightValue(world, i, j, k);
            int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
            int modulousModifier = skyLight % 65536;
            int divModifier = skyLight / 65536;
            tess.setColorOpaque_F(brightness, brightness, brightness);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
    }

}