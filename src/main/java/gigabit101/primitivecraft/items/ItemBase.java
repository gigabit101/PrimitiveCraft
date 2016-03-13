package gigabit101.primitivecraft.items;

import gigabit101.primitivecraft.client.CreativeTabPrimativeCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public ItemBase()
	{
		setCreativeTab(CreativeTabPrimativeCraft.instance);
	}
	
	@Override
	public void registerIcons(IIconRegister icon) 
	{
		itemIcon = icon.registerIcon("primitivecraft:" + getUnlocalizedName().substring(5));
	}
}
