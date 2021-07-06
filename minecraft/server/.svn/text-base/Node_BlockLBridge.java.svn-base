package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_BlockLBridge extends BlockContainer
{

    protected Node_BlockLBridge(int i, int j)
    {
        super(i, j, Material.iron);
        setTickOnLoad(true);
    }

    /*public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        Node_TileEntityLBridge tileentitylbridge = (Node_TileEntityLBridge)iblockaccess.getBlockTileEntity(i, j, k);
        int i1 = tileentitylbridge.getIndex();
        int j1 = tileentitylbridge.getMeta();
        if(i1 == Node_TileEntityLBridge.defaultInd)
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
    }*/

    public boolean isOpaqueCube()
    {
        return false;
    }

    protected TileEntity getBlockEntity()
    {
        return new Node_TileEntityLBridge();
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
