package gigabit101.primitivecraft.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import gigabit101.primitivecraft.client.render.TileRenderCampfire;
import gigabit101.primitivecraft.client.render.TileRenderJug;
import gigabit101.primitivecraft.client.render.item.ItemRenderCampfire;
import gigabit101.primitivecraft.client.render.item.ItemRenderJug;
import gigabit101.primitivecraft.init.ModBlocks;
import gigabit101.primitivecraft.lib.RenderIds;
import gigabit101.primitivecraft.tile.TileCampfire;
import gigabit101.primitivecraft.tile.TileHardJug;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenders()
	{
		RenderIds.campfire = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileCampfire.class, new TileRenderCampfire());
		ClientRegistry.bindTileEntitySpecialRenderer(TileHardJug.class, new TileRenderJug());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.hardjug), new ItemRenderJug());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.campfire), new ItemRenderCampfire());

//		ClientRegistry.bindTileEntitySpecialRenderer(TileCampfire.class, new TileRenderCampfire());
		if(Loader.isModLoaded("NotEnoughItems"))
		{
			
		}
	}
}
