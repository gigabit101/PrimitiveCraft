package gigabit101.primitivecraft.client;

import gigabit101.primitivecraft.lib.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabPrimativeCraft extends CreativeTabs
{
	public static CreativeTabPrimativeCraft instance = new CreativeTabPrimativeCraft();

	public CreativeTabPrimativeCraft() 
	{
		super(ModInfo.MODID);
	}

	@Override
	public Item getTabIconItem() 
	{
		return Items.stick;
	}
}
