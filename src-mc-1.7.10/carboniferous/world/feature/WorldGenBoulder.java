package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBoulder extends WorldGenerator {
	
    private Block fillerBlock;
    private int fillerMeta;
    private int field_150544_b;

    public WorldGenBoulder(Block fillerBlock, int fillerMeta, int p_i45450_2_)
    {
        super(false);
        this.fillerBlock = fillerBlock;
        this.fillerMeta = fillerMeta;
        this.field_150544_b = p_i45450_2_;
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        while(true) {
            if (y > 3) {
                label63: {
                    if (!world.isAirBlock(x, y - 1, z)) {
                        Block block = world.getBlock(x, y - 1, z);

                        if (block == ModBlocks.grass || block == ModBlocks.dirt || block == ModBlocks.multiBlock1)
                            break label63;
                    }

                    --y;
                    continue;
                }
            }

            if (y <= 3)
                return false;

            int k2 = this.field_150544_b;

            for (int l = 0; k2 >= 0 && l < 3; ++l)
            {
                int i1 = k2 + rand.nextInt(2);
                int j1 = k2 + rand.nextInt(2);
                int k1 = k2 + rand.nextInt(2);
                float f = (float)(i1 + j1 + k1) * 0.333F + 0.5F;

                for (int l1 = x - i1; l1 <= x + i1; ++l1)
                {
                    for (int i2 = z - k1; i2 <= z + k1; ++i2)
                    {
                        for (int j2 = y - j1; j2 <= y + j1; ++j2)
                        {
                            float f1 = (float)(l1 - x);
                            float f2 = (float)(i2 - z);
                            float f3 = (float)(j2 - y);

                            if (f1 * f1 + f2 * f2 + f3 * f3 <= f * f)
                            {
                                world.setBlock(l1, j2, i2, this.fillerBlock, this.fillerMeta, 4);
                            }
                        }
                    }
                }

                x += -(k2 + 1) + rand.nextInt(2 + k2 * 2);
                z += -(k2 + 1) + rand.nextInt(2 + k2 * 2);
                y += 0 - rand.nextInt(2);
            }

            return true;
        }
    }
}