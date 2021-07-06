package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_BlockTBridge extends BlockContainer
{

    protected Node_BlockTBridge(int i, int j)
    {
        super(i, j, Material.iron);
        setTickOnLoad(true);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        Node_TileEntityTBridge tileentitytbridge = (Node_TileEntityTBridge)iblockaccess.getBlockTileEntity(i, j, k);
        int i1 = tileentitytbridge.getIndex();
        int j1 = tileentitytbridge.getMeta();
        if(i1 == Node_TileEntityTBridge.defaultInd)
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
        return new Node_TileEntityTBridge();
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }
}
