package gigabit101.primitivecraft.client.render;

import org.lwjgl.opengl.GL11;

public class RenderUtil 
{
    public static void setGLColorFromInt(int color) 
    {
        setGLColorFromIntPlusAlpha(0xFF_00_00_00 | color);
    }
    
    public static void setGLColorFromIntPlusAlpha(int color) 
    {
        float alpha = (color >> 24 & 255) / 255.0F;
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;

		GL11.glColor4f(red, green, blue, 1.0F);
    }
}
