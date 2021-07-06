package net.minecraft.src;

public class Node_BlockTrapDoor extends BlockTrapDoor {

	protected Node_BlockTrapDoor(int i, Material material) {
		super(i, material);
		
		if(material == Material.ground) {
			blockIndexInTexture = Block.dirt.blockIndexInTexture;
		} else if(material == Material.glass) {
			blockIndexInTexture = Block.glass.blockIndexInTexture;
		} else if(material == Material.sand) {
			blockIndexInTexture = Block.sand.blockIndexInTexture;
		} else {
			blockIndexInTexture = Block.blockSnow.blockIndexInTexture;
		}
	}
	
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(blockMaterial == Material.iron)
        {
            return true;
        } else
        {
            int l = world.getBlockMetadata(i, j, k);
            world.setBlockAndMetadataWithNotify(i, j, k, blockID, l ^ 4);
            world.func_28107_a(entityplayer, 1003, i, j, k, 0);
            return true;
        }
    }

    public void func_28042_a(World world, int i, int j, int k, boolean flag)
    {
        int l = world.getBlockMetadata(i, j, k);
        boolean flag1 = (l & 4) > 0;
        if(flag1 == flag)
        {
            return;
        } else
        {
            world.setBlockAndMetadataWithNotify(i, j, k,blockID, l ^ 4);
            world.func_28107_a(null, 1003, i, j, k, 0);
            return;
        }
    }
    
}
