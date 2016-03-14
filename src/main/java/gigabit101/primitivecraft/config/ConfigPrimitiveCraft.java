package gigabit101.primitivecraft.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigPrimitiveCraft 
{
	private static ConfigPrimitiveCraft instance = null;
	public static String CATEGORY_RECIPE = "RECIPE";
	public static String CATEGORY_TWEAKS = "TWEAKS";
	public static String CATEGORY_WORLD = "WORLD";
	
	public static boolean enableGrinder;
	public static boolean snowballsStack64;
	public static boolean genrocks;
	
	public static Configuration config;
	
    private ConfigPrimitiveCraft(File configFile) 
    {
        config = new Configuration(configFile);
        config.load();

        ConfigPrimitiveCraft.Configs();

        config.save();
    }
    
    public static ConfigPrimitiveCraft initialize(File configFile) 
    {
        if (instance == null)
        {
            instance = new ConfigPrimitiveCraft(configFile);
        }
        else
        {
            throw new IllegalStateException("Cannot initialize PrimitiveCraft Config twice");
        }
        return instance;
    }
    
    public static ConfigPrimitiveCraft instance() 
    {
        if (instance == null) 
        {
            throw new IllegalStateException("Instance of PrimitiveCraft Config requested before initialization");
        }
        return instance;
    }
    
    public static void Configs() 
    {
    	//Recipe
        enableGrinder = config.get(CATEGORY_RECIPE,"Enable Grinder",
                true,"set to false to remove recipe from the grinder").getBoolean();
        //World
        genrocks = config.get(CATEGORY_WORLD,"Enable Rocks Worldgen",
                true,"set to false to disable rocks from generating").getBoolean();
        //Tweaks
        snowballsStack64 = config.get(CATEGORY_TWEAKS,"Enable Snowballs to stack to 64",
                false,"set to false to remove recipe from the grinder").getBoolean();
        
        if (config.hasChanged())
        {
            config.save();
        }
    }
}
