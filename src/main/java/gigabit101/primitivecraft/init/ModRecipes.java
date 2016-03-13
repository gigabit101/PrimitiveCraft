package gigabit101.primitivecraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import gigabit101.primitivecraft.api.PrimitiveCraftApi;
import gigabit101.primitivecraft.config.ConfigPrimitiveCraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes 
{
	public static void init()
	{
		addCraftingRecipes();
		addGrinderRecipes();
		//Sets max stacksize of snowball's to 64
		if(ConfigPrimitiveCraft.snowballsStack64)
		{
			Items.snowball.setMaxStackSize(64);
		}
	}
	
	static void addCraftingRecipes()
	{
		if(ConfigPrimitiveCraft.enableGrinder)
		{
			GameRegistry.addRecipe(new ItemStack(ModBlocks.grinder), 
					"FFF", 
					"EXE", 
					"EEE", 
					'E', new ItemStack(Blocks.cobblestone), 
					'F', new ItemStack(Items.flint));	
		}
	}
	
	static void addGrinderRecipes()
	{
		PrimitiveCraftApi.registerGrinderRecipe(new ItemStack(Blocks.gravel), new ItemStack(Blocks.sand), new ItemStack(Blocks.cobblestone));
		PrimitiveCraftApi.registerGrinderRecipe(new ItemStack(Blocks.sand), null, new ItemStack(Blocks.gravel));
	}
}
