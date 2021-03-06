package carboniferous.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import carboniferous.CarboniferousMod;
import carboniferous.ModItems;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.IPlantable;

/**
 * @author ProPercivalalb
 **/
public class BlockMultipleBlocks3 extends Block {
  
	public static IIcon meteoriteBlock;
	public static IIcon meteoriteLightOre;
	public static IIcon meteoriteRedOre;
	public static IIcon basaltEncrustedDiamond;
	
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
		default: return null;
		}
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister) {
    	//Granite
        this.meteoriteBlock = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteBlock"); //0
        this.meteoriteLightOre = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteLightOre"); //1
        this.meteoriteRedOre = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteRedOre"); //2
        this.basaltEncrustedDiamond = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "basaltEncrustedDiamond"); //3
    }
    @Override
    public int damageDropped(int meta) {
    	if(meta == 3)
    		return 0;
    	
    	return meta;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
    	if(meta == 3)
    		return Items.diamond;
    	
    	return super.getItemDropped(meta, random, fortune);
    }
    
    @Override
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
    	return true;
    }

    public boolean isBeaconBase(World worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
    	int meta = worldObj.getBlockMetadata(x, y, z);
    	return false;
    }
}
