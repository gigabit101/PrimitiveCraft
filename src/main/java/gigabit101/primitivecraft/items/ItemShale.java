package gigabit101.primitivecraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShale extends ItemBase
{
	public ItemShale()
	{
		setUnlocalizedName("shale");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) 
	{
		if(!world.isRemote)
		{
			if(world.getBlock(x, y + 1, z) == Blocks.air)
			{
				int random = world.rand.nextInt(4);
				if(random != 0)
				{
					world.setBlock(x, y + 1, z, Blocks.fire);
				}
				stack.stackSize--;
			}
		}
		return true;
	}
}
