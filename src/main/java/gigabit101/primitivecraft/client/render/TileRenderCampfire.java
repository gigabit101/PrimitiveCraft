package gigabit101.primitivecraft.client.render;

import org.lwjgl.opengl.GL11;

import gigabit101.primitivecraft.tile.TileCampfire;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileRenderCampfire extends TileEntitySpecialRenderer
{
	public ModelCampfire modelCampfire;
	
	public TileRenderCampfire()
	{
		modelCampfire = new ModelCampfire();
	}
	
	public void renderCapfire(TileCampfire tm, double d, double d1, double d2, float f) 
	{
		GL11.glPushMatrix();
		
		GL11.glTranslated(d + 0.5D, d1 + 1.5, d2 + 0.5D);
		GL11.glScaled(1.5F, 1F, 1.5F);
		GL11.glRotatef(180, 0, 0, 5);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		if(tm.getStackInSlot(tm.rockSlotID) != null)
		{
			modelCampfire.stones = tm.getStackInSlot(tm.rockSlotID).stackSize;
		}
		if(tm.getStackInSlot(tm.rockSlotID) == null)
		{
			modelCampfire.stones = 0;
		}
		modelCampfire.isActive = tm.getStackInSlot(tm.fireSlodID) != null;	
		modelCampfire.hasSpit = tm.getStackInSlot(tm.spitSlotID) != null;
		modelCampfire.hasJug = tm.getStackInSlot(tm.jugSlotID) != null;
		modelCampfire.hasFluid = tm.tank.getFluid() != null;
		if(tm.tank.getFluid() != null)
		{	
			modelCampfire.fluidstack = tm.tank.getFluid();
		}
		modelCampfire.render(0.0625F);
		
		GL11.glDisable(GL11.GL_BLEND);
		
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,	double d2, float f) 
	{
		this.renderCapfire((TileCampfire)tileentity, d0, d1, d2, f);
	}
}
