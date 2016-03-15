package gigabit101.primitivecraft.world;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gigabit101.primitivecraft.config.ConfigPrimitiveCraft;
import gigabit101.primitivecraft.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;

public class WorldGenStones 
{
	public static final WorldGenStones instancemain = new WorldGenStones();

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onWorldDecoration(DecorateBiomeEvent.Decorate event) 
	{
		if ((event.getResult() == Result.ALLOW || event.getResult() == Result.DEFAULT) && event.type == EventType.FLOWERS) 
		{
			for(int i = 0; i < 2; i++) 
			{
				int x = event.chunkX + event.rand.nextInt(16) + 8;
				int z = event.chunkZ + event.rand.nextInt(16) + 8;
				int y = event.world.getTopSolidOrLiquidBlock(x, z);

				if(event.world.isAirBlock(x, y, z) && Blocks.flower_pot.canBlockStay(event.world, x, y, z) && ConfigPrimitiveCraft.genrocks)
				{
					event.world.setBlock(x, y, z, ModBlocks.rock);
				}
				else if(event.world.getBlock(x, y, z) == Blocks.water && ConfigPrimitiveCraft.genshale)
				{
					event.world.setBlock(x, y-1, z, ModBlocks.shale);
				}
			}
		}
	}
}
