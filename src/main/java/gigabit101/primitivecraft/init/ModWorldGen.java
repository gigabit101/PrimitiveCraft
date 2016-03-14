package gigabit101.primitivecraft.init;

import gigabit101.primitivecraft.config.ConfigPrimitiveCraft;
import gigabit101.primitivecraft.world.WorldGenStones;
import net.minecraftforge.common.MinecraftForge;

public class ModWorldGen 
{
	public static void init()
	{
		if(ConfigPrimitiveCraft.genrocks)
		{
			//Register Rock World gen
			MinecraftForge.TERRAIN_GEN_BUS.register(WorldGenStones.instancemain);
		}
	}
}
