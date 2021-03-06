package carboniferous.block;

import java.util.Random;

import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockMultipleBlocks3 extends Block {
  
	public static IIcon meteoriteBlock;
	public static IIcon meteoriteLightOre;
	public static IIcon meteoriteRedOre;
	public static IIcon basaltEncrustedDiamond;
	public static IIcon graniteCoal;
	public static IIcon shale1;
	public static IIcon shale2;
	public static IIcon shale3;
	
	public BlockMultipleBlocks3() {
        super(Material.rock);
        this.setCreativeTab(null);
    }
	
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		return super.getBlockHardness(par1World, par2, par3, par4);
    }
	
	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 0 || meta == 1 || meta == 2) {
			return 1000.0F * 3.0F;
		}
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIcon(int side, int meta) {
		switch(meta) {
		case 0: return this.meteoriteBlock;
		case 1: return this.meteoriteLightOre;
		case 2: return this.meteoriteRedOre;
		case 3: return this.basaltEncrustedDiamond;
		case 4: return this.graniteCoal;
		case 5: return this.shale1;
		default: return null;
		}
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister) {
    	//Granite
        this.meteoriteBlock = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteBlock"); //0
        this.meteoriteLightOre = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteLightOre"); //1
        this.meteoriteRedOre = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteRedOre"); //2
        this.basaltEncrustedDiamond = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "basaltEncrustedDiamond"); //3
        this.graniteCoal = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreCoal"); //4
        this.shale1 = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "shale"); //5
    }
    
    @Override
    public int damageDropped(int meta) {
    	if(meta == 3 || meta == 4)
    		return 0;
    	
    	return meta;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
    	if(meta == 3)
    		return Items.diamond;
    	
    	if(meta == 4)
    		return Items.coal;
    	
    	return super.getItemDropped(meta, random, fortune);
    }
    
    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess world, int meta, int fortune) {
    	if(meta == 4)
    		return MathHelper.getRandomIntegerInRange(rand, 0, 2);
        else if (meta == 3)
        	return MathHelper.getRandomIntegerInRange(rand, 3, 7);
        else
        	return 0;
    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if(fortune > 0 && (meta == 3 || meta == 4)) {
            int j = rand.nextInt(fortune + 2) - 1;

            if (j < 0)
                j = 0;

            return this.quantityDropped(rand) * (j + 1);
        }
        else
            return this.quantityDropped(rand);
    }

    

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
    	return new ItemStack(this, 1, world.getBlockMetadata(x, y, z));
    }
    
    @Override
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
    	return true;
    }
}
