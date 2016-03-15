package gigabit101.primitivecraft.items.itemblock;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gigabit101.primitivecraft.init.ModBlocks;
import gigabit101.primitivecraft.tile.TileHardJug;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockJug extends ItemBlock
{
	public ItemBlockJug(Block block) 
	{
		super(block);
	}
	
	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) 
	{
		if (!world.setBlock(x, y, z, ModBlocks.hardjug, metadata, 3))
		{
			return false;
		}
		if (world.getBlock(x, y, z) == ModBlocks.hardjug) 
		{
			world.getBlock(x, y, z).onBlockPlacedBy(world, x, y, z, player, stack);
			world.getBlock(x, y, z).onPostBlockPlaced(world, x, y, z, metadata);
		}
		if (stack != null && stack.hasTagCompound()) 
		{
			((TileHardJug) world.getTileEntity(x, y, z)).readFromNBTWithoutCoords(stack.getTagCompound().getCompoundTag("tileEntity"));
		}
		return true;
	}
	
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
    {
        if (stack != null && stack.hasTagCompound()) 
        {
            if (stack.getTagCompound().getCompoundTag("tileEntity") != null)
            {
                list.add(stack.getTagCompound().getCompoundTag("tileEntity").getInteger("storedQuantity") + "mb " +
                        (stack.getTagCompound().getCompoundTag("tileEntity").getString("storedFluid")));
            }
        }
    }
}
