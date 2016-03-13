package gigabit101.primitivecraft.client.container;

import gigabit101.primitivecraft.tile.TileGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import reborncore.client.gui.SlotOutput;
import reborncore.common.container.RebornContainer;

public class ContainerGrinder extends RebornContainer
{
	public TileGrinder tile;
	public EntityPlayer player;
	public int stackamount;

	public ContainerGrinder(TileGrinder tilesimple, EntityPlayer player)
	{
		super();
		this.tile = tilesimple;
		this.player = player;

		this.addSlotToContainer(new Slot(tilesimple.inventory, 0, 56, 34));
		this.addSlotToContainer(new SlotOutput(tilesimple.inventory, 1, 116, 34));
		this.addSlotToContainer(new SlotOutput(tilesimple.inventory, 2, 116, 61));

		int i;

		for (i = 0; i < 3; ++i) 
		{
			for (int j = 0; j < 9; ++j) 
			{
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i) 
		{
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return true;
	}
}
