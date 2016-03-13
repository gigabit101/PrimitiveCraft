package gigabit101.primitivecraft.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelJug extends ModelBase
{
    public ModelRenderer base;
    public ModelRenderer side1;
    public ModelRenderer side2;
    public ModelRenderer side3;
    public ModelRenderer side4;

    public ModelJug() 
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.side1 = new ModelRenderer(this, 0, 0);
        this.side1.setRotationPoint(0.0F, 18.0F, 5.0F);
        this.side1.addBox(-6.0F, -1.0F, -6.0F, 12, 2, 12, 0.0F);
        this.setRotateAngle(side1, 1.5707963267948966F, 0.0F, 0.0F);
        this.side3 = new ModelRenderer(this, 0, 0);
        this.side3.setRotationPoint(-5.0F, 18.0F, 0.0F);
        this.side3.addBox(-6.0F, -1.0F, -6.0F, 12, 2, 12, 0.0F);
        this.setRotateAngle(side3, 1.5707963267948966F, 1.5707963267948966F, 0.0F);
        this.side4 = new ModelRenderer(this, 0, 0);
        this.side4.setRotationPoint(5.0F, 18.0F, 0.0F);
        this.side4.addBox(-6.0F, -1.0F, -6.0F, 12, 2, 12, 0.0F);
        this.setRotateAngle(side4, 1.5707963267948966F, 1.5707963267948966F, 0.0F);
        this.side2 = new ModelRenderer(this, 0, 0);
        this.side2.setRotationPoint(0.0F, 18.0F, -5.0F);
        this.side2.addBox(-6.0F, -1.0F, -6.0F, 12, 2, 12, 0.0F);
        this.setRotateAngle(side2, 1.5707963267948966F, 0.0F, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-6.0F, -1.0F, -6.0F, 12, 2, 12, 0.0F);
    }

    public void render(float f5) 
    { 
        this.side1.render(f5);
        this.side3.render(f5);
        this.side4.render(f5);
        this.side2.render(f5);
        this.base.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
