package gigabit101.primitivecraft.blocks;

import gigabit101.primitivecraft.api.VanillaPacketDispatcher;
import gigabit101.primitivecraft.init.ModBlocks;
import gigabit101.primitivecraft.lib.RenderIds;
import gigabit101.primitivecraft.tile.TileHardJug;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
	{
		if(fillBlockWithFluid(world, x, y, z, player, side, hitX, hitY, hitZ))
		{
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, x, y, z);
			return true;
		}
		return false;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block blockId, int meta)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TileHardJug)
		{
			if (((TileHardJug) te).tank.getFluid() != null)
			{
				float xOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				float yOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				float zOffset = world.rand.nextFloat() * 0.8F + 0.1F;
						
				ItemStack stacknbt = ((TileHardJug) te).getDropWithNBT();
				int amountToDrop = Math.min(world.rand.nextInt(21) + 10, stacknbt.stackSize);

				EntityItem entityitem = new EntityItem(world, x + xOffset, y + yOffset, z + zOffset, stacknbt.splitStack(amountToDrop));
				world.spawnEntityInWorld(entityitem);
			}
			else 
			{
				float xOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				float yOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				float zOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				ItemStack stack = new ItemStack(ModBlocks.hardjug);
				
				EntityItem entityitem = new EntityItem(world, x + xOffset, y + yOffset, z + zOffset, stack);
				world.spawnEntityInWorld(entityitem);
			}
		}
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
	
	protected void dropBlockAsItem(World world, int x, int y, int z, ItemStack stack) {}
}
