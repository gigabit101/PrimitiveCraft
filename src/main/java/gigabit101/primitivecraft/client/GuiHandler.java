package gigabit101.primitivecraft.client;

import cpw.mods.fml.common.network.IGuiHandler;
import gigabit101.primitivecraft.client.container.ContainerGrinder;
import gigabit101.primitivecraft.client.gui.GuiGrinder;
import gigabit101.primitivecraft.tile.TileGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	public static int grinderID = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == grinderID)
		{
			return new ContainerGrinder((TileGrinder) world.getTileEntity(x, y, z), player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == grinderID)
		{
			return new GuiGrinder(player, (TileGrinder) world.getTileEntity(x, y, z));
		}
		return null;
	}
}
