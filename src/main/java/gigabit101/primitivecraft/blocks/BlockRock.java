package gigabit101.primitivecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockRock extends BlockBase
{
	public BlockRock(Material material) 
	{
		super(material);
		setBlockName("rock");
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 1.0F, 0.5F + f);
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister icon) 
	{
		blockIcon = icon.registerIcon("minecraft:" + "cobblestone");
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
}
