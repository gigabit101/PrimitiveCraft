package gigabit101.primitivecraft.compat.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import gigabit101.primitivecraft.lib.ModInfo;

public class NEIConfig implements IConfigureNEI
{
	@Override
	public String getName() 
	{
		return ModInfo.MODID;
	}

	@Override
	public String getVersion() 
	{
		return ModInfo.MODVERSION;
	}

	@Override
	public void loadConfig() 
	{
		NEIGrinderRecipeHandler grinder = new NEIGrinderRecipeHandler();
		API.registerUsageHandler(grinder);
		API.registerRecipeHandler(grinder);
		
//		API.hideItem(new ItemStack(ModBlocks.campfire));
	}
}
