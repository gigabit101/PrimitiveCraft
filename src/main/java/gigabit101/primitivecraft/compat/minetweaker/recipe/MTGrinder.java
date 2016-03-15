package gigabit101.primitivecraft.compat.minetweaker.recipe;

import gigabit101.primitivecraft.api.PrimitiveCraftApi;
import gigabit101.primitivecraft.api.recipe.RecipeGrinder;
import minetweaker.IUndoableAction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.liquid.ILiquidStack;
import minetweaker.api.minecraft.MineTweakerMC;
import minetweaker.api.oredict.IOreDictEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.primitivecraft.grinder")
public class MTGrinder
{
	@ZenMethod
	public static void addRecipe(IIngredient input, IItemStack output1, IItemStack output2) 
	{
		MineTweakerAPI.apply(new AddRecipeAction(input, MineTweakerMC.getItemStack(output1), MineTweakerMC.getItemStack(output2)));
	}

	@ZenMethod
	public static void removeRecipe(IIngredient input) 
	{
		MineTweakerAPI.apply(new RemoveRecipeAction(input));
	}


	private static class AddRecipeAction implements IUndoableAction 
	{
		private Object input;
		private ItemStack output1, output2;

		public AddRecipeAction(Object input, ItemStack output1, ItemStack output2) 
		{
			if (input instanceof IItemStack)
				input = MineTweakerMC.getItemStack((IItemStack) input);
			//TODO
//			if (input instanceof IOreDictEntry)


			if (input instanceof ILiquidStack) 
			{
				MineTweakerAPI.logError("A liquid was passed into a grinder recipe, grinder do not use liquids when crafting, aborting!");
				input = output1 = output2 = null;
			}

			this.input = input;
			this.output1 = output1;
			this.output2 = output2;
		}

		@Override
		public void apply() 
		{
			if (input == null || output1 == null ||output2 == null)
				return;
			PrimitiveCraftApi.registerGrinderRecipe(output1, output2, input);
		}

		@Override
		public void undo() 
		{
			if (input == null || output1 == null ||output2 == null)
				return;
			PrimitiveCraftApi.removeRecipe(input);
		}

		@Override
		public String describe() 
		{
			return String.format("Adding grinder recipe (%s => %s & %s)", input, output1, output2);
		}

		@Override
		public String describeUndo() 
		{
			return String.format("Reverting /%s/", describe());
		}

		@Override
		public boolean canUndo() 
		{
			return true;
		}

		@Override
		public Object getOverrideKey() 
		{
			return null;
		}
	}

	private static class RemoveRecipeAction implements IUndoableAction 
	{
		private Object input;
		private ItemStack output1, output2;

		public RemoveRecipeAction(Object input) {
			if (input instanceof IItemStack)
				input = MineTweakerMC.getItemStack((IItemStack) input);
			//TODO
//			if (input instanceof IOreDictEntry)

			if (input instanceof ILiquidStack) 
			{
				MineTweakerAPI.logError("A liquid was passed intro a grinder recipe, calculators do not use liquids when crafting, aborting!");
				input = output1 = output2 = null;
			}

			this.input = input;

			ItemStack dummyInput = null;

			if (input instanceof ItemStack)
				dummyInput = (ItemStack) input;
			//TODO
//			if (input instanceof RecipeHelper.OreStack)
			
			ItemStack stacks1 = RecipeGrinder.getOutputFrom(dummyInput);
			ItemStack stacks2 = RecipeGrinder.getOutput2From(dummyInput);
			output1 = stacks1;
			if(stacks1 != null)
			{
				output2 = stacks2;
			}
			else
			{
				output2 = null;
			}
		}

		@Override
		public void apply() 
		{
			if (input == null || output1 == null ||output2 == null)
				return;
			PrimitiveCraftApi.removeRecipe(input);
		}

		@Override
		public boolean canUndo() 
		{
			return true;
		}

		@Override
		public void undo() 
		{
			if (input == null || output1 == null ||output2 == null)
				return;	
			PrimitiveCraftApi.registerGrinderRecipe(output1, output2, input);
		}

		@Override
		public String describe() 
		{
			return String.format("Removing grinder recipe (%s => %s & %s)", input, output1, output2);
		}

		@Override
		public String describeUndo() 
		{
			return String.format("Reverting /%s/", describe());
		}

		@Override
		public Object getOverrideKey() 
		{
			return null;
		}
	}
}
