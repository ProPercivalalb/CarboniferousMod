package carboniferous.world.biome;

import java.util.Random;

import carboniferous.entity.EntityAmmonite;
import carboniferous.entity.EntityCrab;
import carboniferous.entity.EntityDendrerpeton;
import carboniferous.entity.EntityDimetrodon;
import carboniferous.entity.EntityOrthacanthus;
import carboniferous.world.feature.WorldGenCalamites;
import carboniferous.world.feature.WorldGenLepidodendron;
import carboniferous.world.feature.WorldGenSmallTrees;
import carboniferous.world.feature.WorldGenWaterCalamites;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenCalamitesSwamp extends BiomeGenBaseCarboniferous {

	public BiomeGenCalamitesSwamp(int par1) {
		super(par1);
		this.setColor(0xfa9418);
		this.setBiomeName("Calamites Swamp");
		this.setHeight(BiomeGenBaseCarboniferous.height_calamites_swamp);
		this.waterColorMultiplier = 0x333300;
		this.theBiomeDecorator.treesPerChunk = 6;
		this.getBiomeDecorator().smallFernPerChunk = 14;
        this.getBiomeDecorator().coralPerChunk = 2;
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDendrerpeton.class, 30, 4, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAmmonite.class, 30, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCrab.class, 10, 3, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDimetrodon.class, 24, 1, 2));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityOrthacanthus.class, 21, 2, 4));
	}

	@Override
	public int getSkyColorByTemp(float par1) {
        return 26163;
    }

	@Override
    public WorldGenAbstractTree func_150567_a(Random random) {
		int i = random.nextInt(30);
        if (i <= 6) {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
        if (i > 6 && i <= 16) {
            return (WorldGenAbstractTree)new WorldGenWaterCalamites(false);
        }
        if (i > 16 && i <= 24) {
            return (WorldGenAbstractTree)new WorldGenCalamites(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }
    }
}
