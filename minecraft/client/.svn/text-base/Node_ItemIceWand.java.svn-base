package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemIceWand extends Item
{

    protected Node_ItemIceWand(int i, int j, int k)
    {
        super(i);
        radius = j;
        setMaxDamage(k);
        maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(freeze(world, i, j, k))
        {
            entityplayer.swingItem();
            itemstack.damageItem(1, null);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean isFull3D()
    {
        return true;
    }

    public boolean freeze(World world, int i, int j, int k)
    {
        boolean flag = false;
        for(int l = -radius; l <= radius; l++)
        {
            for(int i1 = -radius; i1 <= radius; i1++)
            {
                for(int j1 = -radius; j1 <= radius; j1++)
                {
                    if(func_25021_m(i, j, k, i + l, j + i1, k + j1) > radius)
                    {
                        continue;
                    }
                    if(world.getBlockId(i + l, j + i1, k + j1) == Block.waterMoving.blockID || world.getBlockId(i + l, j + i1, k + j1) == Block.waterStill.blockID)
                    {
                        world.setBlockWithNotify(i + l, j + i1, k + j1, Block.ice.blockID);
                        flag = true;
                        continue;
                    }
                    if(Block.snow.canPlaceBlockAt(world, i + l, j + i1, k + j1) && world.isAirBlock(i + l, j + i1, k + j1))
                    {
                        world.setBlockWithNotify(i + l, j + i1, k + j1, Block.snow.blockID);
                        flag = true;
                    }
                }

            }

        }

        return flag;
    }

    private double func_25020_distanceBetweenD(int i, int j, int k, int l, int i1, int j1)
    {
        double d = Math.sqrt(Math.pow(l - i, 2D) + Math.pow(i1 - j, 2D) + Math.pow(j1 - k, 2D));
        return d;
    }

    private int func_25021_m(int i, int j, int k, int l, int i1, int j1)
    {
        Double double1 = Double.valueOf(func_25020_distanceBetweenD(i, j, k, l, i1, j1));
        return double1.intValue();
    }

    private int radius;
    private int field_25024_uses;
}
