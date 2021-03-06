package carboniferous.core.handlers;

import carboniferous.ModBlocks;
import carboniferous.block.BlockSapling;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;

/**
 * @author ProPercivalalb
 */
public class BonemealUseHandler {

	@SubscribeEvent
	public void action(BonemealEvent par1) {
		if(par1.block == ModBlocks.saplings_1) {
			if (applyBonemealSapling(par1.world, par1.x, par1.y, par1.z)) {
                if (!par1.world.isRemote) {
                	par1.world.playAuxSFX(2005, par1.x, par1.y, par1.z, 0);
                }
                par1.setResult(Result.ALLOW);
            }
		}
	}
	
	public static boolean applyBonemealSapling(World par1World, int par2, int par3, int par4) {
		if (!par1World.isRemote) {
            if ((double)par1World.rand.nextFloat() < 0.45D) {
                ((BlockSapling)ModBlocks.saplings_1).func_96477_c(par1World, par2, par3, par4, par1World.rand);
            }
        }
        return true;
    }
}
