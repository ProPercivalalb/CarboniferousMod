package carboniferous.world.biome;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;

/**
 * @author ProPercivalalb
 **/
public class BiomeHighlands extends BiomeCarboniferous {
	
	//private static final WorldGenBoulder boulders = new WorldGenBoulder(ModBlocks.multiBlock3, 5, 0);
	
    public BiomeHighlands() {
    	super(new BiomeProperties("Highlands").setBaseHeight(3F).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(2.0F).setWaterColor(39219));
        this.decorator.treesPerChunk = 4;
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityDimetrodon.class, 26, 2, 3));
        //this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityOrthacanthus.class, 12, 3, 5));
    }

    @Override
    public int getSkyColorByTemp(float var1) {
        return 0x669933;
    }

    /**
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        int i = random.nextInt(10);
        if (i == 0) {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
    }
    
    @Override
    public void decorate(World world, Random rand, int chunkX, int chunkY) {
        int k = rand.nextInt(3);
    
            for (int l = 0; l < k; ++l)
            {
                int i1 = chunkX + rand.nextInt(16) + 8;
                int j1 = chunkY + rand.nextInt(16) + 8;
                int k1 = world.getHeightValue(i1, j1);
                boulders.generate(world, rand, i1, k1, j1);
            }


        super.decorate(world, rand, chunkX, chunkY);
    }**/
}
