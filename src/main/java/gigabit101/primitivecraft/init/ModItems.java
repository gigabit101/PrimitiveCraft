package gigabit101.primitivecraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import gigabit101.primitivecraft.items.ItemDust;
import gigabit101.primitivecraft.items.ItemShale;
import gigabit101.primitivecraft.items.ItemTwig;
import net.minecraft.item.Item;

public class ModItems 
{
	public static Item shale;
	public static Item oredust;
	public static Item twig;
	
	public static void init()
	{
		shale = new ItemShale();
		GameRegistry.registerItem(shale, "shale");
		
		oredust = new ItemDust();
		GameRegistry.registerItem(oredust, "dust");
		
		twig = new ItemTwig();
		GameRegistry.registerItem(twig, "twig");
	}
}
