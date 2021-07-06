package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_BlockGravLift extends BlockContainer
{

    protected Node_BlockGravLift(int i, int j)
    {
        super(i, j, Material.glass);
        setTickOnLoad(true);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    protected TileEntity getBlockEntity()
    {
        return new Node_TileEntityGravLift();
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
        }
        int l = world.getBlockMetadata(i, j, k);
        double d = 0.40000000000000002D;
        if(l == 1)
        {
            entity.motionY += 0.01D;
            if(entity.motionY < -d)
            {
                entity.motionY = -d;
            }
        } else
        {
            entity.motionY += 0.044999999999999998D;
            if(entity.motionY > d)
            {
                entity.motionY = d;
            }
        }
        entity.fallDistance = 0.0F;
    }
}
