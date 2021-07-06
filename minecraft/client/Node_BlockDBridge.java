package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_BlockDBridge extends BlockContainer
{

    protected Node_BlockDBridge(int i, int j)
    {
        super(i, j, Material.iron);
        setTickOnLoad(true);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        Node_TileEntityDBridge tileentitydbridge = (Node_TileEntityDBridge)iblockaccess.getBlockTileEntity(i, j, k);
        int i1 = tileentitydbridge.getIndex();
        int j1 = tileentitydbridge.getMeta();
        if(i1 == Node_TileEntityDBridge.defaultInd)
        {
            return blockIndexInTexture;
        }
        if(Block.blocksList[i1] != null && i1 < Block.blocksList.length && i1 > 0)
        {
            return Block.blocksList[i1].getBlockTextureFromSideAndMetadata(l, j1);
        } else
        {
            return blockIndexInTexture;
        }
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    protected TileEntity getBlockEntity()
    {
        return new Node_TileEntityDBridge();
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        if(world.multiplayerWorld)
        {
            return;
        } else
        {
            Entity entity1 = null;
            entity.attackEntityFrom(entity1, 4);
            return;
        }
    }
}
