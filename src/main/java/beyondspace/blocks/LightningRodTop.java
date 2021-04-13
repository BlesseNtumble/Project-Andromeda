package beyondspace.blocks;

import beyondspace.BeyondSpace;
import beyondspace.blocks.tileentity.LightningRodTopTileEntity;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LightningRodTop extends Block implements ITileEntityProvider {
	
	public LightningRodTop() {
		super(Material.iron);
		this.setBlockName("LightningRodTop");
        this.setBlockTextureName(GalacticraftCore.TEXTURE_PREFIX + "machine.png");
        this.setCreativeTab(BeyondSpace.gaTab);
        this.setHardness(1.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setResistance(18.0F);
        this.setStepSound(soundTypeMetal);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new LightningRodTopTileEntity();
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
}