package gigabit101.primitivecraft.blocks;

import gigabit101.primitivecraft.lib.RenderIds;
import gigabit101.primitivecraft.tile.TileHardJug;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockClayJug extends BlockBase
{
	public BlockClayJug(Material material) 
	{
		super(material);
		setBlockName("clayjug");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) 
	{
		return new TileHardJug();
	}
	
	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() 
	{
		return false;
	}
	
	@Override
	public int getRenderType() 
	{
		return RenderIds.campfire;
	}
}
