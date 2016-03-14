package gigabit101.primitivecraft.compat.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import gigabit101.primitivecraft.api.PrimitiveCraftApi;
import gigabit101.primitivecraft.api.recipe.RecipeGrinder;
import gigabit101.primitivecraft.client.gui.GuiGrinder;
import gigabit101.primitivecraft.lib.ModInfo;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

public class NEIGrinderRecipeHandler extends TemplateRecipeHandler
{
	public class CachedGrinderRecipe extends CachedRecipe
	{
		public List <PositionedStack> inputs = new ArrayList<PositionedStack>();
		public PositionedStack output1;
		public PositionedStack output2;
		//TODO
		public int chance;
		
		public CachedGrinderRecipe(RecipeGrinder recipe) 
		{
			if(recipe == null)
				return;
			
			if(recipe.getInput() instanceof String)
			{
				inputs.add(new PositionedStack(OreDictionary.getOres((String) recipe.getInput()), 42, 37));
			}
			else 
			{
				inputs.add(new PositionedStack(recipe.getInput(), 51, 23));
			}

			output1 = new PositionedStack(recipe.getOutput(), 110, 23);
			if(recipe.getOutput2() != null)
			{
				output2 = new PositionedStack(recipe.getOutput2(), 111, 49);
			}

//			chance = 1/4;
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
		
		@Override
		public PositionedStack getOtherStack() 
		{
			return output2;
		}
	}
	
	
	@Override
	public String getRecipeName() 
	{
		return StatCollector.translateToLocal(ModInfo.MODID.toLowerCase() + ".grinderrecipe");
	}

	@Override
	public String getGuiTexture() 
	{
		return "primitivecraft:textures/gui/grinder.png";
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass() 
	{
		return GuiGrinder.class;
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) 
	{
		if(outputId.equals(getRecipeName())) 
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
			if(crecipe.contains(crecipe.getIngredients(), ingredient)) //|| crecipe.contains(crecipe.getOtherStacks(), ingredient))
				arecipes.add(crecipe);
		}
	}
	
    @Override
    public void loadTransferRects()
    {
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 28, 24, 16), getRecipeName()));
    }
}
