package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_BlockDetector extends Block
{

    protected Node_BlockDetector(int i, int ai[], int j)
    {
        super(i, Material.glass);
        setTickOnLoad(true);
        texArray = ai;
        radius = j;
        setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return world.isBlockOpaqueCube(i, j - 1, k);
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(!world.isBlockOpaqueCube(i, j - 1, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        } else {
        	onBlockPlaced(world, i, j, k, 0);
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return texArray[j];
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        if(!world.isBlockOpaqueCube(i, j - 1, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        } else
        {
        	int cyanID = mod_Node_PackLoader.getIntOption("DetectorCyanID");
        	int yellowID = mod_Node_PackLoader.getIntOption("DetectorYellowID");
        	int blueID = mod_Node_PackLoader.getIntOption("DetectorBlueID");
        	int redID = mod_Node_PackLoader.getIntOption("DetectorRedID");
        	int greyID = mod_Node_PackLoader.getIntOption("DetectorBrownID");
        	int blackID = mod_Node_PackLoader.getIntOption("DetectorGreyID");
        	
            int i1 = world.getBlockMetadata(i, j, k);
            if(canDetect(world, i, j, k, cyanID))
            {
                i1 = 6;
            } else
            if(canDetect(world, i, j, k, yellowID))
            {
                i1 = 5;
            } else
            if(canDetect(world, i, j, k, blueID))
            {
                i1 = 4;
            } else
            if(canDetect(world, i, j, k, redID))
            {
                i1 = 3;
            } else
            if(canDetect(world, i, j, k, greyID))
            {
                i1 = 2;
            } else
            if(canDetect(world, i, j, k, blackID))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            world.setBlockAndMetadataWithNotify(i, j, k, blockID, i1);
            
        }
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        onBlockPlaced(world, i, j, k, 0);
        return true;
    }

    public boolean canDetect(World world, int i, int j, int k, int l)
    {
        radius = mod_Node_PackLoader.getIntOption("DetectorRange");
        int i1 = i - radius;
        int j1 = j - radius;
        int k1 = k - radius;
        int l1 = radius * 2 + 1;
        for(int i2 = 0; i2 < l1; i2++)
        {
            for(int j2 = 0; j2 < l1; j2++)
            {
                for(int k2 = 0; k2 < l1; k2++)
                {
                    int l2 = world.getBlockId(i1 + i2, j1 + j2, k1 + k2);
                    if(l2 == l)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    int texArray[];
    int radius;
}
