package gigabit101.primitivecraft.client.render;

import org.lwjgl.opengl.GL11;

import gigabit101.primitivecraft.tile.TileCampfire;
import gigabit101.primitivecraft.tile.TileHardJug;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileRenderJug extends TileEntitySpecialRenderer
{
//	public static final ResourceLocation txCampfire = new ResourceLocation("primitivecraft", "textures/model/campfire.png");
	public static final ResourceLocation testNothing = new ResourceLocation("minecraft", "textures/blocks/hardened_clay_stained_brown.png");
	
	public ModelJug modelJug;
	
	public TileRenderJug()
	{
		modelJug = new ModelJug();
	}
	
	public void renderTreadmill(TileHardJug tm, double d, double d1, double d2, float f) 
	{
		GL11.glPushMatrix();
		
		GL11.glTranslated(d + 0.5D, d1 + 1.5D, d2 + 0.5D);
		GL11.glRotatef(180, 0, 0, 5);

//		GL11.glTranslated(d, d1, d2);
//		GL11.glScaled(1.5F, 1F, 1.5F);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(testNothing);
		modelJug.render(0.0625F);
		
		GL11.glDisable(GL11.GL_BLEND);
		
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,	double d2, float f) 
	{
		this.renderTreadmill((TileHardJug)tileentity, d0, d1, d2, f);
	}
}
