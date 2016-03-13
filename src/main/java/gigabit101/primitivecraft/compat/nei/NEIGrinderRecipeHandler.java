package gigabit101.primitivecraft.compat.nei;

import java.util.ArrayList;
import java.util.List;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import gigabit101.primitivecraft.api.PrimitiveCraftApi;
import gigabit101.primitivecraft.api.recipe.RecipeGrinder;
import gigabit101.primitivecraft.client.gui.GuiGrinder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import scala.Array;

public class NEIGrinderRecipeHandler extends TemplateRecipeHandler
{
	public class CachedGrinderRecipe extends CachedRecipe
	{
		public List <PositionedStack> inputs = new ArrayList<PositionedStack>();
		public PositionedStack output1;
		public PositionedStack output2;
		public int chance;
		
		public CachedGrinderRecipe(RecipeGrinder recipe) 
		{
			if(recipe == null)
				return;
			
//			inputs.add(new PositionedStack(new ItemStack(ModBlocks.pool, 1, recipe.getOutput().getItem() == Item.getItemFromBlock(ModBlocks.pool) ? 2 : 0), 71, 37));

			if(recipe.getInput() instanceof String)
			{
				inputs.add(new PositionedStack(OreDictionary.getOres((String) recipe.getInput()), 42, 37));
			}
			else 
			{
				inputs.add(new PositionedStack(recipe.getInput(), 42, 37));
			}

			output1 = new PositionedStack(recipe.getOutput(), 101, 37);
			output2 = new PositionedStack(recipe.getOutput2(), 101, 57);

			chance = 1/4;
		}

		
		@Override
		public List<PositionedStack> getIngredients() 
		{
			return getCycledIngredients(cycleticks / 20, inputs);
		}


		@Override
		public PositionedStack getResult() 
		{
			return output1;
		}
	}
	
	
	@Override
	public String getRecipeName() 
	{
		return "grinderrecipe";
	}

	@Override
	public String getGuiTexture() 
	{
		return "primitivecraft:textures/gui/grinder.png";
	}
	

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) 
	{
		if(outputId.equals("grinderrecipe")) 
		{
			for(RecipeGrinder recipe : PrimitiveCraftApi.grinderRecipes) 
			{
				if(recipe == null)
					continue;

				arecipes.add(new CachedGrinderRecipe(recipe));
			}
		} 
		else super.loadCraftingRecipes(outputId, results);
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) 
	{
		for(RecipeGrinder recipe : PrimitiveCraftApi.grinderRecipes) 
		{
			if(recipe == null)
				continue;
			if(NEIServerUtils.areStacksSameTypeCrafting(recipe.getOutput(), result))
				arecipes.add(new CachedGrinderRecipe(recipe));
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) 
	{
		for(RecipeGrinder recipe : PrimitiveCraftApi.grinderRecipes) 
		{
			if(recipe == null)
				continue;
			CachedGrinderRecipe crecipe = new CachedGrinderRecipe(recipe);
			if(crecipe.contains(crecipe.getIngredients(), ingredient) || crecipe.contains(crecipe.getOtherStacks(), ingredient))
				arecipes.add(crecipe);
		}
	}

}
