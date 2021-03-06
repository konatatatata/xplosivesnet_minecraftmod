package com.konatatatata.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class detonatingCord extends ModelBase
{
  //fields
    ModelRenderer leg3;
  Entity entity;
  public detonatingCord()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      leg3 = new ModelRenderer(this, 0, 0);
      leg3.addBox(-2F, 0F, -2F, 16, 1, 2);
      leg3.setRotationPoint(-6F, 23F, 1F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    leg3.render(f5);
    this.entity = entity;
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, this.entity);
  }

}
