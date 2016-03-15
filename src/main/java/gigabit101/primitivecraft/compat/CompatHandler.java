package gigabit101.primitivecraft.compat;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gigabit101.primitivecraft.compat.waila.CompatModuleWaila;

public class CompatHandler 
{
	public static void init(FMLInitializationEvent event)
	{
		if(Loader.isModLoaded("Waila"))
		{
			new CompatModuleWaila().init(event);
		}
		if(Loader.isModLoaded("NotEnoughItems"))
		{
			
		}
	}
}
