package gigabit101.primitivecraft;

import java.io.File;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import gigabit101.primitivecraft.api.PrimitiveCraftApi;
import gigabit101.primitivecraft.client.GuiHandler;
import gigabit101.primitivecraft.compat.CompatHandler;
import gigabit101.primitivecraft.config.ConfigPrimitiveCraft;
import gigabit101.primitivecraft.event.EventDrops;
import gigabit101.primitivecraft.init.ModBlocks;
import gigabit101.primitivecraft.init.ModItems;
import gigabit101.primitivecraft.init.ModRecipes;
import gigabit101.primitivecraft.lib.ModInfo;
import gigabit101.primitivecraft.proxy.CommonProxy;
import gigabit101.primitivecraft.world.WorldGenStones;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(name = ModInfo.MODNAME, modid = ModInfo.MODID, version = ModInfo.MODVERSION, dependencies = ModInfo.MOD_DEPENDENCUIES)
public class PrimitiveCraft 
{
	@SidedProxy(clientSide = ModInfo.MOD_CLIENT_PROXY, serverSide = ModInfo.MOD_COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Mod.Instance
	public static PrimitiveCraft INSTANCE;
	
	public static ConfigPrimitiveCraft config;
	
	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		String path = event.getSuggestedConfigurationFile().getAbsolutePath().replace(ModInfo.MODID, "PrimitiveCraft");
		config = ConfigPrimitiveCraft.initialize(new File(path));
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Load Mod Items
		ModItems.init();
		//Load Mod Blocks
		ModBlocks.init();
		//Load Mod Recipes
		ModRecipes.init();
		//Register Renders on client side
		proxy.initRenders();
		//Register GuiHandler
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
		//Register Mod Compat
		CompatHandler.init(event);
		//Register Leave drops
		MinecraftForge.EVENT_BUS.register(EventDrops.instancemain);
		//Register World gen
		MinecraftForge.TERRAIN_GEN_BUS.register(WorldGenStones.instancemain);
	}
}
