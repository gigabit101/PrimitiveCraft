package gigabit101.primitivecraft.client.gui;

import gigabit101.primitivecraft.client.container.ContainerGrinder;
import gigabit101.primitivecraft.tile.TileGrinder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiGrinder extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation("primitivecraft", "textures/gui/grinder.png");
	private static Minecraft mc = Minecraft.getMinecraft();

	TileGrinder tile;

	public GuiGrinder(EntityPlayer player, TileGrinder tile) 
	{
		super(new ContainerGrinder(tile, player));
		this.xSize = 176;
		this.ySize = 167;
		this.tile = tile;
	}
	
	@Override
	public void initGui() 
	{
		super.initGui();
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) 
	{
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		
        int j = 0;
        j = tile.gaugeProgressScaled(20);
        if (j > 0) 
        {
            this.drawTexturedModalRect(k + 80, l + 35, 176, 14, j + 2, 16);
        }
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) 
	{
		String name = StatCollector.translateToLocal("tile.grinder.name");
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString("" + tile.getProgress(), this.xSize / 2, this.ySize / 2 - 58, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}
}
