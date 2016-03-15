package gigabit101.primitivecraft.tile;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gigabit101.primitivecraft.init.ModBlocks;
import gigabit101.primitivecraft.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import reborncore.common.util.Inventory;
import reborncore.common.util.Tank;

public class TileCampfire extends TileBase implements IInventory, IFluidHandler
{	
	public Inventory inventory = new Inventory(5, "TileCampfire", 8);
	public Tank tank = new Tank("tilecampfirejug", 1000, this);

	public int rockSlotID = 0;
	public int stickSlotID = 1;
	public int jugSlotID = 2;
	public int spitSlotID = 3;
	public int fireSlodID = 4;
	public boolean hasFire;
	
	@Override
	public void updateEntity() 
	{
		if(isActive())
		{
			worldObj.spawnParticle("smoke", xCoord + 0.5, yCoord + 1.0 , zCoord + 0.5, 0.0D, 0.01D, 0.0D);
		}
		if(getStackInSlot(jugSlotID) != null)
		{
			tank.compareAndUpdate();
		}
	}
	
	public boolean isActive()
	{
		if(getStackInSlot(rockSlotID) != null && getStackInSlot(stickSlotID) != null && getStackInSlot(fireSlodID) != null)
		{
			if(getStackInSlot(rockSlotID).stackSize == 8 && getStackInSlot(stickSlotID).stackSize == 8 && getStackInSlot(fireSlodID).stackSize == 1)
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound data) 
	{
		super.writeToNBT(data);
		inventory.writeToNBT(data);
		tank.writeToNBT(data);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound data) 
	{
		super.readFromNBT(data);
		inventory.readFromNBT(data);
		tank.readFromNBT(data);
	}
	
	public Packet getDescriptionPacket() 
	{
		NBTTagCompound nbtTag = new NBTTagCompound();
		writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) 
	{
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
		readFromNBT(packet.func_148857_g());
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
		if(itemstack.getItem() == Item.getItemFromBlock(ModBlocks.rock) && i == this.rockSlotID)
		{
			return true;
		}
		else if(itemstack.getItem() == Items.stick && i == this.stickSlotID)
		{
			return true;
		}
		else if(itemstack.getItem() == Items.apple && i == this.spitSlotID)
		{
			return true;
		}
		else if(itemstack.getItem() == Item.getItemFromBlock(ModBlocks.hardjug) && i == this.jugSlotID)
		{
			return true;
		}
		else if(itemstack.getItem() == ModItems.shale && i == this.fireSlodID && getStackInSlot(this.fireSlodID) == null && getStackInSlot(rockSlotID) != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// IFluidHandler
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) 
	{
		int fill = tank.fill(resource, doFill);
		tank.compareAndUpdate();
		return fill;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) 
	{
		FluidStack drain = tank.drain(resource.amount, doDrain);
		tank.compareAndUpdate();
		return drain;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) 
	{
		FluidStack drain = tank.drain(maxDrain, doDrain);
		tank.compareAndUpdate();
		return drain;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) 
	{
		return tank.getFluid() == null || tank.getFluid().getFluid() == fluid;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) 
	{
		return tank.getFluid() == null || tank.getFluid().getFluid() == fluid;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) 
	{
		return new FluidTankInfo[] { tank.getInfo() };
	}
	
	@SideOnly(Side.CLIENT)
	public void addWailaInfo(List<String> info) 
	{
		if (getStackInSlot(jugSlotID) != null && tank.getFluid() != null) 
		{
			info.add(tank.getFluidAmount() + " of " + tank.getFluidType().getName());
		} 
		else if(getStackInSlot(jugSlotID) != null)
		{
			info.add("Empty");
		}
	}
}
