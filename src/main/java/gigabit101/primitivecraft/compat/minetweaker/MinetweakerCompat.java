package gigabit101.primitivecraft.compat.minetweaker;

import gigabit101.primitivecraft.compat.minetweaker.recipe.MTGrinder;
import minetweaker.MineTweakerAPI;
import minetweaker.api.liquid.ILiquidStack;
import net.minecraftforge.fluids.FluidStack;

public class MinetweakerCompat
{
    public static void init() 
    {
        MineTweakerAPI.registerClass(MTGrinder.class);
    }

//    public static ItemStack toStack(IItemStack iStack) 
//    {
//        return getItemStack(iStack);
//    }
//
//    public static Object toObject(IIngredient iStack) 
//    {
//        if (iStack == null)
//            return null;
//        else 
//        {
//            if (iStack instanceof IOreDictEntry)
//                return ((IOreDictEntry) iStack).getName();
//            else if (iStack instanceof IItemStack)
//                return getItemStack((IItemStack) iStack);
//            else if (iStack instanceof IngredientStack) {
//                IIngredient ingr = ReflectionHelper.getPrivateValue(IngredientStack.class, (IngredientStack) iStack, "ingredient");
//                return toObject(ingr);
//            } else
//                return null;
//        }
//    }
//
//    public static FluidStack toFluidStack(ILiquidStack iStack) {
//        return getLiquidStack(iStack);
//    }
}
