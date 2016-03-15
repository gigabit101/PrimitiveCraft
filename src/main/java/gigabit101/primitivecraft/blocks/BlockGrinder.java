package gigabit101.primitivecraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gigabit101.primitivecraft.PrimitiveCraft;
import gigabit101.primitivecraft.api.VanillaPacketDispatcher;
import gigabit101.primitivecraft.client.GuiHandler;
import gigabit101.primitivecraft.tile.TileGrinder;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGrinder extends BlockBase
{
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	@SideOnly(Side.CLIENT)
	private IIcon iconBottom;
	
	public BlockGrinder(Material material)
	{
		super(material);
		setBlockName("grinder");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) 
	{
		return new TileGrinder();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) 
	{
		TileGrinder tile = (TileGrinder) world.getTileEntity(x, y, z);
		
		if(!player.isSneaking())
		{
			player.openGui(PrimitiveCraft.INSTANCE, GuiHandler.grinderID, world, x, y, z);
		}
		else
		{
			if(tile != null)
			{
				tile.addProgress();
			}
		}
		return true;
	}
	
	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity ent, float p_149746_6_) 
	{
		if(ent instanceof EntityPlayer)
		{
			TileGrinder tile = (TileGrinder) world.getTileEntity(x, y, z);
			if(tile.FallenUpon((Entity) ent))
			{
				VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, x, y, z);
			}
		}
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) 
	{
		this.blockIcon = icon.registerIcon("primitivecraft:grinderSide");
		this.iconFront = icon.registerIcon("primitivecraft:grinderFace");

		this.iconTop = icon.registerIcon("primitivecraft:grinderSide");
		this.iconBottom = icon.registerIcon("primitivecraft:grinderSide");
	}

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) 
    {
        int metadata = getTileRotation(blockAccess, x, y, z);
        return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop :
                side == 0 ? this.iconBottom : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon));
    }

    @Override
    public IIcon getIcon(int side, int meta) 
    {
        if (side == 1) 
        {
            return this.iconTop;
        } 
        else if (side == 3) 
        {
            return this.iconFront;
        } 
        else 
        {
            return this.blockIcon;
        }
    }
}
