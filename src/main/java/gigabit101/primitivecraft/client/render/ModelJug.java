package gigabit101.primitivecraft.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

public class ModelJug extends ModelBase
{
    public ModelRenderer base;
    public ModelRenderer side1;
    public ModelRenderer side2;
    public ModelRenderer side3;
    public ModelRenderer side4;
    public ModelRenderer fluid;
    public boolean hasFluid;
    public FluidStack fluidstack;

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
        this.fluid = new ModelRenderer(this, 0, 0);
        this.fluid.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.fluid.addBox(-4.0F, -8.0F, -4.0F, 8, 2, 8, 0.0F);
    }
	public static final ResourceLocation testNothing = new ResourceLocation("minecraft", "textures/blocks/hardened_clay_stained_brown.png");

    public void render(float f5) 
    { 
    	renderJug(f5);
        if(hasFluid)
        {
        	renderFluid(f5);
        }
    }
    
    public void renderJug(float f5)
    {
		Minecraft.getMinecraft().renderEngine.bindTexture(testNothing);
        this.side1.render(f5);
        this.side3.render(f5);
        this.side4.render(f5);
        this.side2.render(f5);
        this.base.render(f5);
    }
    
    public void renderFluid(float f5)
    {
    	if(hasFluid)
    	{
    		GL11.glPushMatrix();
    		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
    		GL11.glEnable(GL11.GL_CULL_FACE);
    		GL11.glDisable(GL11.GL_LIGHTING);
    		GL11.glEnable(GL11.GL_BLEND);
    		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    		float scale = 0.5F;
    		GL11.glScalef(scale, scale, scale);
    		GL11.glTranslatef(0f, 2.0F, 0f);

    		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
	        
	    	RenderBlocks renderBlocks = RenderBlocks.getInstance();
	        renderBlocks.setOverrideBlockTexture(fluidstack.getFluid().getStillIcon());
	        renderBlocks.renderBlockAsItem(Blocks.stone, 0, 1.0f);

	        renderBlocks.clearOverrideBlockTexture();
			
			GL11.glPopAttrib();
			GL11.glPopMatrix();
    	}
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
