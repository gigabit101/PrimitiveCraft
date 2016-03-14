package gigabit101.primitivecraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import gigabit101.primitivecraft.api.PrimitiveCraftApi;
import gigabit101.primitivecraft.config.ConfigPrimitiveCraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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
		PrimitiveCraftApi.registerGrinderRecipe(new ItemStack(ModItems.oredust, 2), null, new ItemStack(Blocks.iron_ore));
		PrimitiveCraftApi.registerGrinderRecipe(new ItemStack(ModItems.oredust, 2, 1), null, new ItemStack(Blocks.gold_ore));
		PrimitiveCraftApi.registerGrinderRecipe(new ItemStack(Items.string, 4), null, new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE));
	}
}
