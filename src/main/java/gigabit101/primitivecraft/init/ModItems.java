package gigabit101.primitivecraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import gigabit101.primitivecraft.items.ItemCampfireStone;
import gigabit101.primitivecraft.items.ItemClayJug;
import gigabit101.primitivecraft.items.ItemDust;
import gigabit101.primitivecraft.items.ItemShale;
import net.minecraft.item.Item;

public class ModItems 
{
	public static Item shale;
	public static Item campfirestone;
	public static Item oredust;
	
	public static void init()
	{
		shale = new ItemShale();
		GameRegistry.registerItem(shale, "shale");
		
		campfirestone = new ItemCampfireStone();
		GameRegistry.registerItem(campfirestone, "campfirestone");
		
		oredust = new ItemDust();
		GameRegistry.registerItem(oredust, "dust");
	}
}
