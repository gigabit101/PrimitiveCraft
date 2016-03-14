package gigabit101.primitivecraft.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gigabit101.primitivecraft.client.CreativeTabPrimativeCraft;
import gigabit101.primitivecraft.init.ModItems;
import gigabit101.primitivecraft.lib.RenderIds;
import gigabit101.primitivecraft.tile.TileCampfire;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import reborncore.common.util.ItemUtils;

public class BlockCampfire extends BlockContainer
{	    
	public BlockCampfire(Material material)
	{
		super(material);
		setBlockName("campfire");
		setCreativeTab(CreativeTabPrimativeCraft.instance);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float p_149727_7_, float p_149727_8_, float p_149727_9_) 
	{
		TileCampfire tile = (TileCampfire) world.getTileEntity(x, y, z); 
		if(tile != null)
		{
			if(player.getCurrentEquippedItem() != null)
			{
				ItemStack playersStack = player.getCurrentEquippedItem().copy();
				ItemStack input = new ItemStack(playersStack.getItem(), 1);
				int i = 0;
				
		        for (i = 0; i < 5; ++i) 
		        {
		        	if (tile.isItemValidForSlot(i, input))
		        	{
			        	if (tile.getStackInSlot(i) == null)
			        	{
							tile.setInventorySlotContents(i, input);
							player.getCurrentEquippedItem().stackSize--;
							break;
			        	}
			        	else if(ItemUtils.isItemEqual(input, tile.getStackInSlot(i), true, true) && tile.getStackInSlot(i).stackSize != 8)
			        	{
							tile.getStackInSlot(i).stackSize++;
							player.getCurrentEquippedItem().stackSize--;
							break;
			        	}
		        	}
		        }
				return true;
			}
		}
		//DEBUG
		if(player.isSneaking() && !world.isRemote)
		{
			if(tile.getStackInSlot(0) != null)
				player.addChatComponentMessage(new ChatComponentText("0 " + tile.getStackInSlot(0).getDisplayName() + " " + tile.getStackInSlot(0).stackSize));
			if(tile.getStackInSlot(1) != null)
				player.addChatComponentMessage(new ChatComponentText("1 " + tile.getStackInSlot(1).getDisplayName() + " " + tile.getStackInSlot(1).stackSize));
			if(tile.getStackInSlot(2) != null)
				player.addChatComponentMessage(new ChatComponentText("2 " + tile.getStackInSlot(2).getDisplayName() + " " + tile.getStackInSlot(2).stackSize));
			if(tile.getStackInSlot(3) != null)
				player.addChatComponentMessage(new ChatComponentText("3 " + tile.getStackInSlot(3).getDisplayName() + " " + tile.getStackInSlot(3).stackSize));
			if(tile.getStackInSlot(4) != null)
				player.addChatComponentMessage(new ChatComponentText("4 " + tile.getStackInSlot(4).getDisplayName() + " " + tile.getStackInSlot(4).stackSize));
		}
		return false;
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
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) 
	{
		return new TileCampfire();
	}
}
