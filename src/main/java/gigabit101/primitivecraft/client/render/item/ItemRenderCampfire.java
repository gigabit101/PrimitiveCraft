package gigabit101.primitivecraft.client.render.item;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import gigabit101.primitivecraft.client.render.ModelCampfire;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderCampfire implements IItemRenderer
{
	private ModelCampfire model;
	
	public ItemRenderCampfire() 
	{
		model = new ModelCampfire();
	}
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return true;
	}

    @Override
    public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
    {
        switch (itemRenderType)
        {
            case ENTITY:
            {
                renderAludel(-0.5F, -0.38F, 0.5F);
                return;
            }
            case EQUIPPED:
            {
                renderAludel(0.0F, 0.0F, 1.0F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderAludel(0.0F, 0.0F, 1.0F);
                return;
            }
            case INVENTORY:
            {
                renderAludel(-1.0F, -0.9F, 0.0F);
                return;
            }
            default:
        }
    }
	public static final ResourceLocation testLog = new ResourceLocation("minecraft", "textures/blocks/log_oak.png");

    private void renderAludel(float x, float y, float z)
    {
        GL11.glPushMatrix();

        // Scale, Translate, Rotate
        GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef(x + 1, y + 2F, z);
		GL11.glRotatef(180, 0, 0, 5);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(testLog);

        // Render
        model.render(0.0625F);

        GL11.glPopMatrix();
    }
}
