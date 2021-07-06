package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_WorldGenSpires extends RenderTNTPrimed
{

    public Node_WorldGenSpires(int i, int j, int k, boolean flag)
    {
        field_25291_radius = i;
        field_25295_f = j;
        field_25294_type = k;
        field_25292_deathSpire = flag;
    }

    public boolean func_25286_a(World world, Random random, int i, int j, int k)
    {
        j = func_25285_findFloor(world, i, j, k);
        if(j == 0)
        {
            return false;
        }
        if(func_25284_isAreaClear(world, i, j, k))
        {
            int l = i - field_25291_radius;
            int i1 = k - field_25291_radius;
            int j1 = field_25291_radius * 2 + 1;
            for(int k1 = 0; k1 < j1; k1++)
            {
                for(int l1 = 0; l1 < j1; l1++)
                {
                    int i2 = 0;
                    int j2 = (int)((double)field_25291_radius * 0.66666666666666663D);
                    if(field_25294_type == 1 || field_25294_type == 5)
                    {
                        if(j2 == 0)
                        {
                            j2 = 1;
                        }
                        i2 = random.nextInt(j2) - random.nextInt(j2 * 2);
                    }
                    int k2 = func_25287_distanceBetween(i, k, l + k1, i1 + l1);
                    if(k2 <= field_25291_radius + i2)
                    {
                        func_25290_fillWater(world, l + k1, j, i1 + l1);
                        func_25288_generateColumn(world, random, l + k1, j, i1 + l1, k2);
                        continue;
                    }
                    if(k2 > field_25291_radius && random.nextInt(4) == 1)
                    {
                        func_25290_fillWater(world, l + k1, j, i1 + l1);
                        func_25283_clearArea(world, random, l + k1, j, i1 + l1);
                    }
                }

            }

            return true;
        } else
        {
            return false;
        }
    }

    private boolean func_25284_isAreaClear(World world, int i, int j, int k)
    {
        int l = j;
        int i1 = i - field_25291_radius;
        int j1 = k - field_25291_radius;
        int k1 = field_25291_radius * 2 + 1;
        for(int l1 = 0; l1 < k1; l1++)
        {
            for(int i2 = 0; i2 < k1; i2++)
            {
                if(func_25287_distanceBetween(i, k, i1 + l1, j1 + i2) > field_25291_radius)
                {
                    continue;
                }
                j = func_25285_findFloor(world, i1 + l1, j, j1 + i2);
                if(j == 0)
                {
                    return false;
                }
                if(Math.abs(l - j) > 7)
                {
                    return false;
                }
                if(world.getBlockLightValue(i1 + l1, j, j1 + i2) < 12)
                {
                    return false;
                }
            }

        }

        return true;
    }

    private int func_25285_findFloor(World world, int i, int j, int k)
    {
        for(int l = j + 32; l > 10; l--)
        {
            boolean flag = world.getBlockId(i, l - 1, k) != Block.leaves.blockID || world.getBlockId(i, l - 1, k) != Block.wood.blockID;
            boolean flag1 = world.getBlockId(i, l - 1, k) == Block.waterMoving.blockID || world.getBlockId(i, l - 1, k) == Block.waterStill.blockID || world.getBlockId(i, l - 1, k) == Block.ice.blockID;
            if((world.isAirBlock(i, l, k) || world.getBlockId(i, l, k) == Block.leaves.blockID || world.getBlockId(i, l, k) == Block.wood.blockID) && (world.isBlockOpaqueCube(i, l - 1, k) || flag1) && flag)
            {
                return l;
            }
        }

        return 0;
    }

    public void func_25290_fillWater(World world, int i, int j, int k)
    {
        int l = j;
        j = func_25285_findFloor(world, i, j, k);
        if(j == 0)
        {
            return;
        }
        int i1 = j;
        for(boolean flag = false; !flag; i1--)
        {
            if(world.getBlockId(i, i1, k) == Block.waterMoving.blockID || world.getBlockId(i, i1, k) == Block.waterStill.blockID || world.getBlockId(i, i1 - 1, k) == Block.ice.blockID)
            {
                if(field_25292_deathSpire)
                {
                    world.setBlock(i, i1, k, Block.netherrack.blockID);
                } else
                {
                    world.setBlock(i, i1, k, Block.stone.blockID);
                }
                continue;
            }
            if(world.isBlockOpaqueCube(i, i1, k))
            {
                flag = true;
            }
        }

    }

    private void func_25288_generateColumn(World world, Random random, int i, int j, int k, int l)
    {
        int i1 = j;
        for(j = func_25285_findFloor(world, i, j, k); j < i1; j++)
        {
            if(field_25292_deathSpire)
            {
                float f = random.nextFloat();
                if(f < 0.01F)
                {
                    world.setBlockWithNotify(i, j, k, Block.lavaMoving.blockID);
                } else
                {
                    world.setBlockWithNotify(i, j, k, Block.netherrack.blockID);
                }
                continue;
            }
            int j1 = random.nextInt(2);
            if(j1 == 1)
            {
                world.setBlockWithNotify(i, j, k, Block.stone.blockID);
                continue;
            }
            if(j1 == 0)
            {
                world.setBlockWithNotify(i, j, k, Block.dirt.blockID);
            }
        }

        if(j > i1 + 7)
        {
            j = i1;
        }
        int k1 = field_25295_f;
        int l1 = (int)((float)l * (1.0F + random.nextFloat() * 2.0F));
        if(l1 == 0)
        {
            l1 = 1;
            k1 *= 2;
        }
        k1 /= l1;
        for(int i2 = 0; i2 < k1; i2++)
        {
            if(!world.isAirBlock(i, j + i2, k) && world.getBlockId(i, j + i2, k) != Block.leaves.blockID && world.getBlockId(i, j + i2, k) != Block.wood.blockID)
            {
                continue;
            }
            if(field_25292_deathSpire)
            {
                int j2 = random.nextInt(2 + i2);
                if(j2 > k1 / (i2 + 1))
                {
                    break;
                }
                float f1 = random.nextFloat();
                if(f1 < 0.01F)
                {
                    world.setBlockWithNotify(i, j + i2, k, Block.lavaMoving.blockID);
                } else
                {
                    world.setBlockWithNotify(i, j + i2, k, Block.netherrack.blockID);
                }
                continue;
            }
            int k2 = random.nextInt(2 + i2);
            if(k2 > k1 / (i2 + 1))
            {
                break;
            }
            world.setBlockWithNotify(i, j + i2, k, Block.stone.blockID);
        }

    }

    private void func_25283_clearArea(World world, Random random, int i, int j, int k)
    {
        int l = j;
        for(j = func_25285_findFloor(world, i, j, k); j < l; j++)
        {
            if(field_25292_deathSpire)
            {
                float f = random.nextFloat();
                if(f < 0.01F)
                {
                    world.setBlockWithNotify(i, j, k, Block.lavaMoving.blockID);
                } else
                {
                    world.setBlockWithNotify(i, j, k, Block.netherrack.blockID);
                }
                continue;
            }
            int i1 = random.nextInt(2);
            if(i1 == 1)
            {
                world.setBlockWithNotify(i, j, k, Block.stone.blockID);
                continue;
            }
            if(i1 == 0)
            {
                world.setBlockWithNotify(i, j, k, Block.dirt.blockID);
            }
        }

        if(j > l + 7)
        {
            j = l;
        }
        for(int j1 = 0; j1 < field_25295_f; j1++)
        {
            if(!world.isAirBlock(i, j + j1, k))
            {
                world.setBlockWithNotify(i, j + j1, k, 0);
            }
        }

    }

    private double func_25289_distanceBetweenD(int i, int j, int k, int l)
    {
        int i1 = 2;
        double d = 1.0D / (double)i1;
        double d1 = 0.0D;
        int j1 = 0;
        for(int k1 = 0; k1 < i1; k1++)
        {
            for(int l1 = 0; l1 < i1; l1++)
            {
                double d3 = ((double)k - 0.5D) + d * (double)k1;
                double d4 = ((double)l - 0.5D) + d * (double)l1;
                j1++;
                d1 += Math.sqrt(Math.pow(d3 - (double)i, 2D) + Math.pow(d4 - (double)j, 2D));
            }

        }

        double d2 = d1 / (double)j1;
        return d2;
    }

    private int func_25287_distanceBetween(int i, int j, int k, int l)
    {
        double d = func_25289_distanceBetweenD(i, j, k, l);
        if(d > (double)field_25291_radius)
        {
            d++;
        }
        Double double1 = Double.valueOf(d);
        return double1.intValue();
    }

    private int field_25291_radius;
    private int field_25295_f;
    private int field_25294_type;
    private boolean field_25292_deathSpire;
    private static final int field_25293_MAX_DIFFERENCE = 7;
    private static final float field_25296_LAVA_CHANCE = 0.01F;
}
