package gigabit101.primitivecraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import gigabit101.primitivecraft.blocks.BlockCampfire;
import gigabit101.primitivecraft.blocks.BlockClayJug;
import gigabit101.primitivecraft.blocks.BlockGrinder;
import gigabit101.primitivecraft.blocks.BlockRock;
import gigabit101.primitivecraft.blocks.BlockShale;
import gigabit101.primitivecraft.tile.TileCampfire;
import gigabit101.primitivecraft.tile.TileGrinder;
import gigabit101.primitivecraft.tile.TileHardJug;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static Block campfire;
	public static Block hardjug;
	public static Block grinder;
	public static Block shale;
	public static Block rock;
	
	public static void init()
	{
		campfire = new BlockCampfire(Material.rock);
		GameRegistry.registerBlock(campfire, "campfire");
		GameRegistry.registerTileEntity(TileCampfire.class, "campfirePC");
		
		hardjug = new BlockClayJug(Material.rock);
		GameRegistry.registerBlock(hardjug, "hardjug");
		GameRegistry.registerTileEntity(TileHardJug.class, "hardjugPC");
		
		grinder = new BlockGrinder(Material.rock);
		GameRegistry.registerBlock(grinder, "grinder");
		GameRegistry.registerTileEntity(TileGrinder.class, "grinderPC");
		
		shale = new BlockShale(Material.rock);
		GameRegistry.registerBlock(shale, "shaleblock");
		
		rock = new BlockRock(Material.rock);
		GameRegistry.registerBlock(rock, "rock");
	}
}