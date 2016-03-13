package gigabit101.primitivecraft.api;

import java.util.ArrayList;
import java.util.List;

import gigabit101.primitivecraft.api.recipe.RecipeGrinder;
import net.minecraft.item.ItemStack;

public class PrimitiveCraftApi 
{
	public static List<RecipeGrinder> grinderRecipes = new ArrayList<RecipeGrinder>();
	
	public static RecipeGrinder registerGrinderRecipe(ItemStack output, ItemStack output2, Object input) 
	{
		RecipeGrinder recipe = new RecipeGrinder(output, output2, input);
		grinderRecipes.add(recipe);
		return recipe;
	}
}
