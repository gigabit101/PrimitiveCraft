package gigabit101.primitivecraft.blocks;

import java.util.ArrayList;

import gigabit101.primitivecraft.client.CreativeTabPrimativeCraft;
import gigabit101.primitivecraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockShale extends Block
{
	public BlockShale(Material material) 
	{
		super(material);
		setBlockName("shaleblock");
		setCreativeTab(CreativeTabPrimativeCraft.instance);
		setHardness(2.0F);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister icon) 
	{
		blockIcon = icon.registerIcon("primitivecraft:" + getUnlocalizedName().substring(5));
	}
	
	@Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) 
	{
		return blockIcon;
	}
	
    @Override
    public IIcon getIcon(int side, int meta) 
    {
    	return blockIcon;
    }
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) 
    {
    	ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
    	drops.add(new ItemStack(ModItems.shale, 4));
    	return drops;
    }
}
