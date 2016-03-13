package gigabit101.primitivecraft.tile;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gigabit101.primitivecraft.api.PrimitiveCraftApi;
import gigabit101.primitivecraft.api.VanillaPacketDispatcher;
import gigabit101.primitivecraft.api.recipe.RecipeGrinder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import reborncore.common.util.Inventory;
import reborncore.common.util.ItemUtils;
import scala.xml.persistent.SetStorage;

public class TileGrinder extends TileBase implements IInventory
{
	public int input = 0;
	public int output = 1;
	public int output2 = 2;
	public Inventory inventory = new Inventory(3, "TileGrinderInv", 64);
	public int progress;
	public int maxProgress = 4;
	public boolean hasPlate;
	
	@Override
	public void updateEntity() 
	{
		if(canGrind() && progress == maxProgress)
		{
			grind();
		}
	}
	
	public boolean FallenUpon(Entity entity)
	{
		if(entity.isDead)
			return false;
		
		if(canGrind() && getOutput() != null && hasPressureplate())
			addProgress();	
		
		return true;
	}
	
	public boolean hasPressureplate()
	{
		if(worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof BlockPressurePlate)
		{
			return true;
		}
		return false;
	}
	
	public void addProgress()
	{
		progress++;
	}
	
    public int gaugeProgressScaled (int scale)
    {
        return (progress * scale) / maxProgress;
    }
	
	public boolean canGrind()
	{
		if(getOutput() != null)
		{
			return true;
		}
		return false;
	}
	
	public void grind()
	{
		if(!worldObj.isRemote)
		{
			//Second output 
			int chance = worldObj.rand.nextInt(4);
			if(getOutput2() != null && chance == 0)
			{
				if(getStackInSlot(output2) == null)
				{
					setInventorySlotContents(this.output2, getOutput2());
				}
				else if(ItemUtils.isItemEqual(getStackInSlot(this.output2), getOutput2(), true, true))
				{
					getStackInSlot(output2).stackSize += getOutput2().stackSize;
				}
			}
			
			//Output
			if(getStackInSlot(output) == null)
			{
				setInventorySlotContents(this.output, getOutput());
				decrStackSize(input, 1);
			}
			else if(ItemUtils.isItemEqual(getStackInSlot(this.output), getOutput(), true, true))
			{
				getStackInSlot(output).stackSize += getOutput().stackSize;
				decrStackSize(input, 1);
			}
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(worldObj, xCoord, yCoord, zCoord);
		}
		if(inventory.hasChanged)
		{
			progress = 0;
		}
	}
	//Gets the ItemStack the recipe will craft
	public ItemStack getOutput()
	{
		if(getStackInSlot(input) != null)
		{
			ItemStack input = getStackInSlot(this.input);
			for (RecipeGrinder recipe : PrimitiveCraftApi.grinderRecipes) 
			{
				if (recipe.matches(input) || recipe.getOutput().getItem() == Item.getItemFromBlock(getBlockType())) 
				{
					ItemStack output = recipe.getOutput().copy();
					return output;
				}
			}
		}
		return null;
	}
	//Gets the 2nd ItemStack the recipe will craft
	public ItemStack getOutput2()
	{
		if(getStackInSlot(input) != null)
		{
			ItemStack input = getStackInSlot(this.input);
			for (RecipeGrinder recipe : PrimitiveCraftApi.grinderRecipes) 
			{
				if (recipe.matches(input) || recipe.getOutput2().getItem() == Item.getItemFromBlock(getBlockType())) 
				{
					if(recipe.getOutput2() != null)
					{
						ItemStack output2 = recipe.getOutput2().copy();
						return output2;
					}
					return null;
				}
			}
		}
		return null;
	}
	
	public int getProgress()
	{
		return progress;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound data) 
	{
		super.writeToNBT(data);
		inventory.writeToNBT(data);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound data) 
	{
		super.readFromNBT(data);
		inventory.readFromNBT(data);
	}

	@Override
	public int getSizeInventory() 
	{
		return inventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int slotId) 
	{
		return inventory.getStackInSlot(slotId);
	}

	@Override
	public ItemStack decrStackSize(int slotId, int count) 
	{
		return inventory.decrStackSize(slotId, count);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) 
	{
		return getStackInSlotOnClosing(p_70304_1_);
	}

	@Override
	public void setInventorySlotContents(int slotId, ItemStack itemstack) 
	{
		inventory.setInventorySlotContents(slotId, itemstack);
	}

	@Override
	public String getInventoryName() 
	{
		return inventory.getInventoryName();
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return inventory.getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return true;
	}

	@Override
	public void openInventory() 
	{
		inventory.openInventory();
	}

	@Override
	public void closeInventory() 
	{
		inventory.closeInventory();
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) 
	{
		return inventory.isItemValidForSlot(i, itemstack);
	}
	
	@SideOnly(Side.CLIENT)
	public void addWailaInfo(List<String> info) 
	{
		 int progress = getProgress();
		 int maxprogress = this.maxProgress;
		 String name = "";
		 if(getStackInSlot(this.input) != null)
		 {
			 name = getStackInSlot(this.input).getDisplayName();
		 }
		// String name = "";
		// if (getStackInSlot(1) != null && storedItem == null)
		// {
		// name = getStackInSlot(1).getDisplayName();
		// size += getStackInSlot(1).stackSize;
		// }
		// if(getStackInSlot(1) != null && storedItem != null)
		// {
		// name = getStackInSlot(1).getDisplayName();
		// size += getStackInSlot(1).stackSize + storedItem.stackSize;
		// }
		// if (storedItem != null)
		 if(getStackInSlot(this.input) != null)
		 {
			 info.add("Input " + name);
		 }

		 info.add("Progress " + progress + "/" + maxprogress);
	}
}
