package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_BlockClock extends Block
{

    protected Node_BlockClock(int i, int ai[])
    {
        super(i, Material.glass);
        setTickOnLoad(true);
        field_25273_texArray = ai;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return field_25273_texArray[j];
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        onBlockPlaced(world, i, j, k, 0);
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        long l1 = world.getWorldTime();
        int i1 = (int)(l1 % 24000L);
        int j1 = world.getBlockMetadata(i, j, k);
        j1 = i1 / 1500;
        world.setBlockAndMetadataWithNotify(i, j, k, blockID, j1);
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        onBlockPlaced(world, i, j, k, 0);
    }

    int field_25273_texArray[];
}
