package gigabit101.primitivecraft.client.render;

import org.lwjgl.opengl.GL11;

import gigabit101.primitivecraft.tile.TileHardJug;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileRenderJug extends TileEntitySpecialRenderer
{	
	public ModelJug modelJug;
	
	public TileRenderJug()
	{
		modelJug = new ModelJug();
	}
	
	public void renderJug(TileHardJug tm, double d, double d1, double d2, float f) 
	{
		GL11.glPushMatrix();
		
		GL11.glTranslated(d + 0.5D, d1 + 1.5D, d2 + 0.5D);
		GL11.glRotatef(180, 0, 0, 5);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		modelJug.hasFluid = tm.tank.isFull();
		if(!tm.tank.isEmpty())
		{
			modelJug.fluidstack = tm.tank.getFluid();
		}
		modelJug.render(0.0625F);
		
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,	double d2, float f) 
	{
		this.renderJug((TileHardJug)tileentity, d0, d1, d2, f);
	}
}
