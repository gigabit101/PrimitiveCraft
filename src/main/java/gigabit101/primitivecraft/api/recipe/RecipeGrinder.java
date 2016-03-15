package gigabit101.primitivecraft.api.recipe;

import java.util.List;

import gigabit101.primitivecraft.api.PrimitiveCraftApi;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeGrinder 
{
	ItemStack output;
	ItemStack output2;
	Object input;

	public RecipeGrinder(ItemStack output, ItemStack output2, Object input)
	{
		this.output = output;
		this.output2 = output2;
		this.input = input;
	}
	
	public boolean matches(ItemStack stack) 
	{
		if(input instanceof ItemStack) 
		{
			ItemStack inputCopy = ((ItemStack) input).copy();
			if(inputCopy.getItemDamage() == Short.MAX_VALUE)
			{
				inputCopy.setItemDamage(stack.getItemDamage());
			}
			return stack.isItemEqual(inputCopy);
		}

		if(input instanceof String) 
		{
			List<ItemStack> validStacks = OreDictionary.getOres((String) input);

			for(ItemStack ostack : validStacks) 
			{
				ItemStack cstack = ostack.copy();
				if(cstack.getItemDamage() == Short.MAX_VALUE)
				{
					cstack.setItemDamage(stack.getItemDamage());
				}
				if(stack.isItemEqual(cstack))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static ItemStack getOutputFrom(ItemStack input)
	{
		if(input != null)
		{
			for (RecipeGrinder recipe : PrimitiveCraftApi.grinderRecipes) 
			{
				if (recipe.matches(input)) //|| recipe.getOutput().getItem() == Item.getItemFromBlock(getBlockType())) 
				{
					ItemStack output = recipe.getOutput().copy();
					return output;
				}
			}
		}
		return null;
	}
	
	public static ItemStack getOutput2From(ItemStack input)
	{
		if(input != null)
		{
			for (RecipeGrinder recipe : PrimitiveCraftApi.grinderRecipes) 
			{
				if (recipe.matches(input))// || recipe.getOutput2().getItem() == Item.getItemFromBlock(getBlockType())) 
				{
					ItemStack output = recipe.getOutput().copy();
					return output;
				}
			}
		}
		return null;
	}
	
	public Object getInput() 
	{
		return input;
	}

	public ItemStack getOutput() 
	{
		return output;
	}
	
	public ItemStack getOutput2() 
	{
		return output2;
	}
}
