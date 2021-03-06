package carboniferous.core.addons.thaumcraft;

import java.util.List;
import java.util.logging.Level;

import com.google.common.base.Optional;

import carboniferous.core.addons.PluginEvent;
import carboniferous.core.helper.LogHelper;
import carboniferous.world.biome.BiomeGenBaseCarboniferous;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.biome.BiomeGenBase;

public class ThaumcraftPlugin {

    private static final String MOD_ID   = "Thaumcraft";
    private static final String MOD_NAME = "Thaumcraft 3";
    private Optional<ThaumcraftApi> api = Optional.absent();
    
    public void registerItemAspects() {
    	 //registerItemAspects(ModBlocks.logs_1, -1, Arrays.asList(32), Arrays.asList(4));
         //registerItemAspects(ModBlocks.planks_1, -1, Arrays.asList(32), Arrays.asList(1));
         //registerItemAspects(ModBlocks.planks_1, -1, Arrays.asList(32), Arrays.asList(4));
         //registerItemAspects(ModBlocks.multiBlock1, 0, Arrays.asList(11), Arrays.asList(2));
         //registerItemAspects(ModBlocks.multiBlock1, 1, Arrays.asList(11, 7), Arrays.asList(1, 1));
         //registerItemAspects(ModBlocks.multiBlock1, 2, Arrays.asList(11), Arrays.asList(2));
         //registerItemAspects(ModBlocks.dirt, 0, Arrays.asList(16), Arrays.asList(2));
         //registerItemAspects(ModBlocks.grass, 0, Arrays.asList(32, 16), Arrays.asList(1, 2));
    }
    
    public void registerBiomeInfo() {
    	registerBiomeInfo(BiomeGenBaseCarboniferous.rainforest, 850, 32, "Lignum", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.calamitesSwamp, 21, 600, "Aqua", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.carboniferousOcean, 300, 21, "Aqua", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.carboniferousRiver, 250, 21, "Aqua", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.coalSwamp, 550, 36, "Herba", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.highlands, 450, 11, "Saxum", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.island, 350, 21, "Aqua", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.coalSwamp, 330, 36, "Herba", false, false);
    }
    
    @SubscribeEvent
    public void init(PluginEvent.Init event) {
        if (!api.isPresent()) {
        	return;
        }
        
        registerItemAspects();
        registerBiomeInfo();
    }
    
    protected void registerItemAspects(int blockID, int meta, List<Integer> aspectsID, List<Integer> aspectsAmount) {
    	api.get().registerItemAspects(blockID, meta, aspectsID, aspectsAmount);
    }
    
    protected void registerBiomeInfo(BiomeGenBase biome, int visLevel, int tagID, String tagName, boolean greatwood, boolean silverwood) {
    	api.get().registerBiomeInfo(biome, visLevel, tagID, tagName, greatwood, silverwood);
    }

    @SubscribeEvent
    public void postInit(PluginEvent.Post event) {
        api = Optional.absent();
    }

    @SubscribeEvent
    public void preInit(PluginEvent.Pre event) {
        if (!Loader.isModLoaded(MOD_ID)) {
        	return;
        }
        LogHelper.log(Level.INFO, "Loaded " + MOD_NAME + " Addon");
        try {
            api = Optional.of(new ThaumcraftApi());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }

}
