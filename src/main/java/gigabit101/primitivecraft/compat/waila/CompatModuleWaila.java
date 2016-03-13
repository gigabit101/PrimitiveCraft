package gigabit101.primitivecraft.compat.waila;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import gigabit101.primitivecraft.tile.TileGrinder;
import mcp.mobius.waila.api.IWailaRegistrar;

public class CompatModuleWaila 
{
	public void init(FMLInitializationEvent event) 
	{
		FMLInterModComms.sendMessage("Waila", "register", getClass().getName() + ".callbackRegister");
	}

	public static void callbackRegister(IWailaRegistrar registrar) 
	{
		registrar.registerBodyProvider(new WailaProviderPrimitiveCraft(), TileGrinder.class);
	}
}
