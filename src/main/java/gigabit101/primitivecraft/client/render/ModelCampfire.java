package gigabit101.primitivecraft.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.BlockFire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class ModelCampfire extends ModelBase
{
    public ModelRenderer base;
    public ModelRenderer side1;
    public ModelRenderer side2;
    public ModelRenderer side3;
    public ModelRenderer side4;
    public ModelRenderer Log1;
    public ModelRenderer Log2;
    public ModelRenderer Log3;
    public ModelRenderer Log4;
    public ModelRenderer Log5;
    public ModelRenderer Log6;
    public ModelRenderer Log7;
    public ModelRenderer Log8;
    public ModelRenderer sideRock1;
    public ModelRenderer sideRock2;
    public ModelRenderer sideRock3;
    public ModelRenderer sideRock4;
    public ModelRenderer sideRock5;
    public ModelRenderer sideRock6;
    public ModelRenderer sideRock7;
    public ModelRenderer sideRock8;
    public ModelRenderer sideRock9;
    public ModelRenderer sideRock10;
    public ModelRenderer sideRock11;
    public ModelRenderer sideRock12;
    public ModelRenderer sideRock13;
    public ModelRenderer sideRock14;
    public ModelRenderer sideRock15;
    public ModelRenderer sideRock16;
    public ModelRenderer spitStand1;
    public ModelRenderer spitStand2;
    public ModelRenderer spitRod;
    public ModelRenderer addedPiece1;
    public ModelRenderer addedPiece2;
    public ModelRenderer addedPiece3;
    public ModelRenderer addedPiece4;
    public ModelRenderer topPiece1;
    public ModelRenderer topPiece2;
    
    public boolean isActive;
    public boolean hasSpit;
    public boolean hasJug;
    public int sticks;
    public int stones;
    public int meta;

    public ModelCampfire() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.sideRock5 = new ModelRenderer(this, 0, 0);
        this.sideRock5.setRotationPoint(-1.0F, 23.0F, 9.0F);
        this.sideRock5.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.sideRock10 = new ModelRenderer(this, 0, 0);
        this.sideRock10.setRotationPoint(-5.0F, 23.0F, -9.0F);
        this.sideRock10.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Log3 = new ModelRenderer(this, 0, 0);
        this.Log3.setRotationPoint(-4.5F, 23.0F, 0.0F);
        this.Log3.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 7, 0.0F);
        this.setRotateAngle(Log3, 0.0F, 1.5707963267948966F, 0.0F);
        this.sideRock2 = new ModelRenderer(this, 0, 0);
        this.sideRock2.setRotationPoint(5.0F, 23.0F, 9.0F);
        this.sideRock2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.sideRock4 = new ModelRenderer(this, 0, 0);
        this.sideRock4.setRotationPoint(1.0F, 23.0F, 9.0F);
        this.sideRock4.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Log1 = new ModelRenderer(this, 0, 0);
        this.Log1.setRotationPoint(0.0F, 23.0F, 4.5F);
        this.Log1.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 7, 0.0F);
        this.Log7 = new ModelRenderer(this, 0, 0);
        this.Log7.setRotationPoint(4.5F, 23.0F, 0.0F);
        this.Log7.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 7, 0.0F);
        this.setRotateAngle(Log7, 0.0F, 1.5707963267948966F, 0.0F);
        this.spitStand1 = new ModelRenderer(this, 0, 0);
        this.spitStand1.setRotationPoint(0.0F, 20.0F, 9.5F);
        this.spitStand1.addBox(-1.5F, -8.0F, -1.5F, 3, 12, 3, 0.0F);
        this.topPiece2 = new ModelRenderer(this, 0, 0);
        this.topPiece2.setRotationPoint(0.0F, 10.5F, -9.5F);
        this.topPiece2.addBox(-1.5F, -1.0F, -1.5F, 3, 2, 3, 0.0F);
        this.side1 = new ModelRenderer(this, 0, 0);
        this.side1.setRotationPoint(0.0F, 14.9F, 5.0F);
        this.side1.addBox(-4.0F, -1.0F, -5.0F, 8, 2, 10, 0.0F);
        this.setRotateAngle(side1, 1.5707963267948966F, 0.0F, 0.0F);
        this.Log2 = new ModelRenderer(this, 0, 0);
        this.Log2.setRotationPoint(-4.5F, 23.0F, 4.5F);
        this.Log2.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 7, 0.0F);
        this.setRotateAngle(Log2, 0.0F, -0.7853981633974483F, 0.0F);
        this.sideRock1 = new ModelRenderer(this, 0, 0);
        this.sideRock1.setRotationPoint(7.0F, 23.0F, 9.0F);
        this.sideRock1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.spitRod = new ModelRenderer(this, 0, 0);
        this.spitRod.setRotationPoint(0.0F, 11.5F, 0.0F);
        this.spitRod.addBox(-12.0F, -0.5F, -0.5F, 24, 1, 1, 0.0F);
        this.setRotateAngle(spitRod, 0.0F, 1.5707963267948966F, 0.0F);
        this.sideRock6 = new ModelRenderer(this, 0, 0);
        this.sideRock6.setRotationPoint(-3.0F, 23.0F, 9.0F);
        this.sideRock6.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Log5 = new ModelRenderer(this, 0, 0);
        this.Log5.setRotationPoint(0.0F, 23.0F, -4.5F);
        this.Log5.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 7, 0.0F);
        this.sideRock15 = new ModelRenderer(this, 0, 0);
        this.sideRock15.setRotationPoint(5.0F, 23.0F, -9.0F);
        this.sideRock15.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.topPiece1 = new ModelRenderer(this, 0, 0);
        this.topPiece1.setRotationPoint(0.0F, 10.5F, 9.5F);
        this.topPiece1.addBox(-1.5F, -1.0F, -1.5F, 3, 2, 3, 0.0F);
        this.side4 = new ModelRenderer(this, 0, 0);
        this.side4.setRotationPoint(5.0F, 15.9F, 0.0F);
        this.side4.addBox(-6.0F, -1.0F, -4.0F, 12, 2, 10, 0.0F);
        this.setRotateAngle(side4, 1.5707963267948966F, 1.5707963267948966F, 0.0F);
        this.addedPiece2 = new ModelRenderer(this, 0, 0);
        this.addedPiece2.setRotationPoint(-1.0F, 11.5F, 9.5F);
        this.addedPiece2.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(addedPiece2, 0.0F, 1.5707963267948966F, 0.0F);
        this.Log4 = new ModelRenderer(this, 0, 0);
        this.Log4.setRotationPoint(-4.5F, 23.0F, -4.5F);
        this.Log4.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 7, 0.0F);
        this.setRotateAngle(Log4, 0.0F, 0.7853981633974483F, 0.0F);
        this.addedPiece4 = new ModelRenderer(this, 0, 0);
        this.addedPiece4.setRotationPoint(-1.0F, 11.5F, -9.5F);
        this.addedPiece4.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(addedPiece4, 0.0F, 1.5707963267948966F, 0.0F);
        this.sideRock13 = new ModelRenderer(this, 0, 0);
        this.sideRock13.setRotationPoint(1.0F, 23.0F, -9.0F);
        this.sideRock13.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.sideRock9 = new ModelRenderer(this, 0, 0);
        this.sideRock9.setRotationPoint(-7.0F, 23.0F, -9.0F);
        this.sideRock9.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.side2 = new ModelRenderer(this, 0, 0);
        this.side2.setRotationPoint(0.0F, 14.9F, -5.0F);
        this.side2.addBox(-4.0F, -1.0F, -5.0F, 8, 2, 10, 0.0F);
        this.setRotateAngle(side2, 1.5707963267948966F, 0.0F, 0.0F);
        this.sideRock12 = new ModelRenderer(this, 0, 0);
        this.sideRock12.setRotationPoint(-1.0F, 23.0F, -9.0F);
        this.sideRock12.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(0.0F, 20.89999999999997F, 0.0F);
        this.base.addBox(-6.0F, -1.0F, -6.0F, 12, 2, 12, 0.0F);
        this.Log8 = new ModelRenderer(this, 0, 0);
        this.Log8.setRotationPoint(4.5F, 23.0F, 4.5F);
        this.Log8.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 7, 0.0F);
        this.setRotateAngle(Log8, 0.0F, 0.7853981633974483F, 0.0F);
        this.sideRock16 = new ModelRenderer(this, 0, 0);
        this.sideRock16.setRotationPoint(7.0F, 23.0F, -9.0F);
        this.sideRock16.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.addedPiece1 = new ModelRenderer(this, 0, 0);
        this.addedPiece1.setRotationPoint(1.0F, 11.5F, 9.5F);
        this.addedPiece1.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(addedPiece1, 0.0F, 1.5707963267948966F, 0.0F);
        this.side3 = new ModelRenderer(this, 0, 0);
        this.side3.setRotationPoint(-5.0F, 15.9F, 0.0F);
        this.side3.addBox(-6.0F, -1.0F, -4.0F, 12, 2, 10, 0.0F);
        this.setRotateAngle(side3, 1.5707963267948966F, 1.5707963267948966F, 0.0F);
        this.addedPiece3 = new ModelRenderer(this, 0, 0);
        this.addedPiece3.setRotationPoint(1.0F, 11.5F, -9.5F);
        this.addedPiece3.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(addedPiece3, 0.0F, 1.5707963267948966F, 0.0F);
        this.sideRock7 = new ModelRenderer(this, 0, 0);
        this.sideRock7.setRotationPoint(-5.0F, 23.0F, 9.0F);
        this.sideRock7.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.sideRock11 = new ModelRenderer(this, 0, 0);
        this.sideRock11.setRotationPoint(-3.0F, 23.0F, -9.0F);
        this.sideRock11.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.spitStand2 = new ModelRenderer(this, 0, 0);
        this.spitStand2.setRotationPoint(0.0F, 20.0F, -9.5F);
        this.spitStand2.addBox(-1.5F, -8.0F, -1.5F, 3, 12, 3, 0.0F);
        this.Log6 = new ModelRenderer(this, 0, 0);
        this.Log6.setRotationPoint(4.5F, 23.0F, -4.5F);
        this.Log6.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 7, 0.0F);
        this.setRotateAngle(Log6, 0.0F, -0.7853981633974483F, 0.0F);
        this.sideRock14 = new ModelRenderer(this, 0, 0);
        this.sideRock14.setRotationPoint(3.0F, 23.0F, -9.0F);
        this.sideRock14.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.sideRock8 = new ModelRenderer(this, 0, 0);
        this.sideRock8.setRotationPoint(-7.0F, 23.0F, 9.0F);
        this.sideRock8.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.sideRock3 = new ModelRenderer(this, 0, 0);
        this.sideRock3.setRotationPoint(3.0F, 23.0F, 9.0F);
        this.sideRock3.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
    }

	public static final ResourceLocation testLog = new ResourceLocation("minecraft", "textures/blocks/log_oak.png");
	public static final ResourceLocation testNothing = new ResourceLocation("minecraft", "textures/blocks/hardened_clay_stained_brown.png");
	public static final ResourceLocation testStone = new ResourceLocation("minecraft", "textures/blocks/cobblestone.png");



    public void render(float f5) 
    { 
    	renderBase(f5);
    	renderJug(f5);
    	renderSpit(f5);
    	renderStones1(f5);
    	renderStones2(f5);
    	renderFire(f5);
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
    
    public void renderBase(float f5)
    {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().renderEngine.bindTexture(testLog);
		
    	this.Log1.render(f5);
    	this.Log2.render(f5);
    	this.Log3.render(f5);
    	this.Log4.render(f5);
    	this.Log5.render(f5);
    	this.Log6.render(f5);
    	this.Log7.render(f5);
    	this.Log8.render(f5);
    	
		GL11.glDisable(GL11.GL_BLEND);
		
		GL11.glPopMatrix();
    }
    
    public void renderStones1(float f5)
    {
    	if(stones != 0)
    	{
			GL11.glPushMatrix();	
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft.getMinecraft().renderEngine.bindTexture(testStone);
			if(stones >= 1)
				this.sideRock1.render(f5);
			if(stones >= 2)
				this.sideRock3.render(f5);
			if(stones >= 3)
				this.sideRock5.render(f5);
			if(stones >= 4)
				this.sideRock7.render(f5);
			if(stones >= 5)
				this.sideRock9.render(f5);
			if(stones >= 6)
				this.sideRock11.render(f5);
			if(stones >= 7)
				this.sideRock13.render(f5);
			if(stones >= 8)
				this.sideRock15.render(f5);
	    	
			GL11.glDisable(GL11.GL_BLEND);
			
			GL11.glPopMatrix();
    	}
    }
    
    public void renderStones2(float f5)
    {
    	if(stones != 0)
    	{
			GL11.glPushMatrix();
			
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft.getMinecraft().renderEngine.bindTexture(testStone);
			GL11.glRotatef(95, 0, 5, 0);
	
			if(stones >= 1)
				this.sideRock2.render(f5);
			if(stones >= 2)
				this.sideRock4.render(f5);
			if(stones >= 3)
				this.sideRock6.render(f5);
			if(stones >= 4)
				this.sideRock8.render(f5);
			if(stones >= 5)
				this.sideRock10.render(f5);
			if(stones >= 6)
				this.sideRock12.render(f5);
			if(stones >= 7)
				this.sideRock14.render(f5);
			if(stones >= 8)
				this.sideRock16.render(f5);
	    	
			GL11.glDisable(GL11.GL_BLEND);
			
			GL11.glPopMatrix();
    	}
    }
    
    public void renderJug(float f5)
    {
    	if(hasJug)
    	{
			GL11.glPushMatrix();
						
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft.getMinecraft().renderEngine.bindTexture(testNothing);

			this.base.render(f5);
			this.side1.render(f5);
			this.side2.render(f5);
			this.side3.render(f5);
			this.side4.render(f5);
			
			GL11.glDisable(GL11.GL_BLEND);
			
			GL11.glPopMatrix();
    	}
    }
    
    public void renderSpit(float f5)
    {
    	if(hasSpit)
    	{
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft.getMinecraft().renderEngine.bindTexture(testLog);
			
			this.spitStand1.render(f5);
			this.spitStand2.render(f5);
			this.spitRod.render(f5);
			
			GL11.glDisable(GL11.GL_BLEND);
			
			GL11.glPopMatrix();
    	}
    }
    
    public void renderFire(float f5)
    {
    	if(isActive)
    	{
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glRotatef(180, 0, 0, 5);
			if(!hasJug)
			{
				GL11.glTranslatef(0f, -0.8F, 0f);
			}
			else
			{
				GL11.glTranslatef(0f, -1.2F, 0f);
			}
			if(hasJug)
			{
				GL11.glScalef(1F, 0.5F, 1F);
			}
			
			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
	        
	    	RenderBlocks renderBlocks = RenderBlocks.getInstance();
	        renderBlocks.setOverrideBlockTexture(Blocks.fire.getFireIcon(1));
	        renderBlocks.renderBlockAsItem(Blocks.torch, 1, 2.0f);
	
	        renderBlocks.clearOverrideBlockTexture();
			
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
    	}
    }
}
