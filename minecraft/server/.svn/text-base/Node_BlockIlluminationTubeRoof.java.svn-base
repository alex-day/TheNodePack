package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_BlockIlluminationTubeRoof extends Node_BlockIlluminationTube
{

    protected Node_BlockIlluminationTubeRoof(int i, int j)
    {
        super(i, j);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 2;
    }

    public int idDropped(int i, Random random)
    {
        return Block.illuminationTubeFloor.blockID;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return world.isBlockOpaqueCube(i, j + 1, k);
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        if(world.isBlockOpaqueCube(i, j + 1, k))
        {
            i1 = 6;
        }
        world.setBlockMetadataWithNotify(i, j, k, i1);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.getBlockMetadata(i, j, k) == 0)
        {
            onBlockAdded(world, i, j, k);
        }
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        if(world.isBlockOpaqueCube(i, j + 1, k))
        {
            world.setBlockMetadataWithNotify(i, j, k, 6);
        }
        boolean flag = func_25272_h(world, i, j, k);
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(func_25272_h(world, i, j, k))
        {
            int i1 = world.getBlockMetadata(i, j, k);
            boolean flag = false;
            if(!world.isBlockOpaqueCube(i, j + 1, k))
            {
                flag = true;
            }
            if(flag)
            {
                dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
                world.setBlockWithNotify(i, j, k, 0);
            }
        }
    }

    private boolean func_25272_h(World world, int i, int j, int k)
    {
        if(!canPlaceBlockAt(world, i, j, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
            return false;
        } else
        {
            return true;
        }
    }

    public MovingObjectPosition collisionRayTrace(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        int l = world.getBlockMetadata(i, j, k) & 7;
        float f = 0.15F;
        float f1 = 0.1F;
        setBlockBounds(0.5F - f1, 0.4F, 0.5F - f1, 0.5F + f1, 1.0F, 0.5F + f1);
        return super.collisionRayTrace(world, i, j, k, vec3d, vec3d1);
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
    }
}
