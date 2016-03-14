package gigabit101.primitivecraft.event;

import java.util.ArrayList;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gigabit101.primitivecraft.init.ModItems;
import net.minecraft.block.BlockLeaves;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class EventDrops 
{
	public static final EventDrops instancemain = new EventDrops();

	@SubscribeEvent
	public void blockDestroyed(HarvestDropsEvent event)
	{
		int rand = event.world.rand.nextInt(4);
		if(event.harvester != null)
		{
			if(event.block instanceof BlockLeaves && rand == 0)
			{
				ArrayList<ItemStack> drops = event.drops;
				drops.add(new ItemStack(ModItems.twig));
			}
		}
	}
}
