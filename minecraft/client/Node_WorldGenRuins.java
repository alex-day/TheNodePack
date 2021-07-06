package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_WorldGenRuins extends RenderTNTPrimed
{

    public Node_WorldGenRuins(int i, int j, int k)
    {
        field_25315_radius = i;
        field_25321_skip = j;
        field_25316_type = k;
        if(field_25316_type == 9)
        {
            field_25316_type = 7;
        }
        if(field_25316_type == 7)
        {
            field_25315_radius = field_25315_radius + 2;
        }
        field_25317_numTorches = 0;
        field_25314_torchSkip = 0;
        field_25319_skipCounter = 0;
        field_25322_skipper = false;
        field_25318_placedChest = false;
        field_25313_placedSpawn = false;
    }

    public boolean func_25301_a(World world, Random random, int i, int j, int k)
    {
        j = func_25302_findFloor(world, i, j, k);
        if(j == 0)
        {
            return false;
        }
        if(func_25309_isAreaClear(world, i, j, k))
        {
            int l = i - field_25315_radius;
            int i1 = k - field_25315_radius;
            int j1 = field_25315_radius * 2 + 1;
            if(field_25321_skip != 0)
            {
                field_25319_skipCounter = random.nextInt(field_25321_skip);
            }
            for(int k1 = 0; k1 < j1; k1++)
            {
                for(int l1 = 0; l1 < j1; l1++)
                {
                    int i2 = 0;
                    int j2 = (int)((double)field_25315_radius * 0.66666666666666663D);
                    if(field_25316_type == 1 || field_25316_type == 5)
                    {
                        i2 = random.nextInt(j2) - random.nextInt(j2 * 2);
                    }
                    if(func_25300_distanceBetween(i, k, l + k1, i1 + l1) == field_25315_radius + i2)
                    {
                        func_25304_fillWater(world, l + k1, j, i1 + l1);
                        if(field_25321_skip != 0)
                        {
                            if(!field_25322_skipper)
                            {
                                func_25310_generateColumn(world, random, l + k1, j, i1 + l1);
                            }
                            if(field_25319_skipCounter == field_25321_skip)
                            {
                                field_25319_skipCounter = 0;
                                field_25322_skipper = !field_25322_skipper;
                            } else
                            {
                                field_25319_skipCounter++;
                            }
                        } else
                        {
                            func_25310_generateColumn(world, random, l + k1, j, i1 + l1);
                        }
                        continue;
                    }
                    if(func_25300_distanceBetween(i, k, l + k1, i1 + l1) < field_25315_radius)
                    {
                        func_25304_fillWater(world, l + k1, j, i1 + l1);
                        func_25307_clearArea(world, random, l + k1, j, i1 + l1);
                    }
                }

            }

            return true;
        } else
        {
            return false;
        }
    }

    private boolean func_25309_isAreaClear(World world, int i, int j, int k)
    {
        int l = j;
        int i1 = i - field_25315_radius;
        int j1 = k - field_25315_radius;
        int k1 = field_25315_radius * 2 + 1;
        for(int l1 = 0; l1 < k1; l1++)
        {
            for(int i2 = 0; i2 < k1; i2++)
            {
                if(func_25300_distanceBetween(i, k, i1 + l1, j1 + i2) > field_25315_radius)
                {
                    continue;
                }
                j = func_25302_findFloor(world, i1 + l1, j, j1 + i2);
                if(j == 0)
                {
                    return false;
                }
                if(Math.abs(l - j) > 3)
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

    private int func_25302_findFloor(World world, int i, int j, int k)
    {
        for(int l = j + 32; l > 10; l--)
        {
            boolean flag = world.getBlockId(i, l - 1, k) != Block.leaves.blockID;
            boolean flag1 = world.getBlockId(i, l - 1, k) == Block.waterMoving.blockID || world.getBlockId(i, l - 1, k) == Block.waterStill.blockID || world.getBlockId(i, l - 1, k) == Block.ice.blockID;
            if((world.isAirBlock(i, l, k) || world.getBlockId(i, l, k) == Block.leaves.blockID) && (world.isBlockOpaqueCube(i, l - 1, k) || flag1) && flag)
            {
                return l;
            }
        }

        return 0;
    }

    public void func_25304_fillWater(World world, int i, int j, int k)
    {
        int l = j;
        j = func_25302_findFloor(world, i, j, k);
        if(j == 0)
        {
            return;
        }
        int i1 = j;
        for(boolean flag = false; !flag; i1--)
        {
            if(world.getBlockId(i, i1, k) == Block.waterMoving.blockID || world.getBlockId(i, i1, k) == Block.waterStill.blockID || world.getBlockId(i, i1 - 1, k) == Block.ice.blockID)
            {
                world.setBlockWithNotify(i, i1, k, Block.sand.blockID);
                continue;
            }
            if(world.isBlockOpaqueCube(i, i1, k))
            {
                flag = true;
            }
        }

    }

    private void func_25310_generateColumn(World world, Random random, int i, int j, int k)
    {
        int l = j;
        for(j = func_25302_findFloor(world, i, j, k); j < l; j++)
        {
            int i1 = random.nextInt(30);
            if(i1 <= 13)
            {
                world.setBlockWithNotify(i, j, k, Block.cobblestoneMossy.blockID);
                continue;
            }
            if(i1 <= 25)
            {
                world.setBlockWithNotify(i, j, k, Block.cobblestone.blockID);
            }
        }

        if(j > l + 3)
        {
            j = l;
        }
        for(int j1 = 0; j1 < 5; j1++)
        {
            if(!world.isAirBlock(i, j + j1, k) && world.getBlockId(i, j + j1, k) != Block.leaves.blockID)
            {
                continue;
            }
            int k1 = random.nextInt(30 + j1 * 10);
            if(k1 < 13)
            {
                world.setBlockWithNotify(i, j + j1, k, Block.cobblestoneMossy.blockID);
                continue;
            }
            if(k1 < 25)
            {
                world.setBlockWithNotify(i, j + j1, k, Block.cobblestone.blockID);
                continue;
            }
            if(j1 == 0 || field_25316_type == 7 || !Block.torchWood.canPlaceBlockAt(world, i, j + j1, k) || field_25317_numTorches >= 8)
            {
                continue;
            }
            if(field_25314_torchSkip < 8)
            {
                field_25314_torchSkip++;
            } else
            {
                world.setBlockAndMetadataWithNotify(i, j + j1, k, Block.torchWood.blockID, 5);
                field_25317_numTorches++;
                field_25314_torchSkip = 0;
            }
        }

    }

    private void func_25307_clearArea(World world, Random random, int i, int j, int k)
    {
        int l = j;
        j = func_25302_findFloor(world, i, j, k);
        if(field_25316_type == 2 || field_25316_type == 6)
        {
            for(; j < l; j++)
            {
                int i1 = random.nextInt(3);
                if(i1 == 1)
                {
                    world.setBlockWithNotify(i, j, k, Block.cobblestoneMossy.blockID);
                    continue;
                }
                if(i1 == 2)
                {
                    world.setBlockWithNotify(i, j, k, Block.cobblestone.blockID);
                }
            }

        }
        if(j > l + 3)
        {
            j = l;
        }
        for(int j1 = 0; j1 < 5; j1++)
        {
            if(!world.isAirBlock(i, j + j1, k))
            {
                world.setBlockWithNotify(i, j + j1, k, 0);
            }
        }

        if(field_25316_type == 3 || field_25316_type == 7)
        {
            int k1 = random.nextInt(3);
            if(field_25316_type == 7)
            {
                k1 = random.nextInt(1);
            }
            if(k1 == 0)
            {
                world.setBlockWithNotify(i, j + 5, k, Block.cobblestoneMossy.blockID);
            } else
            if(k1 == 1)
            {
                world.setBlockWithNotify(i, j + 5, k, Block.cobblestone.blockID);
            }
            int i2 = random.nextInt(10);
            if(field_25316_type == 7)
            {
                i2 = random.nextInt(20);
            }
            if(i2 == 1)
            {
                func_25310_generateColumn(world, random, i, j, k);
            } else
            if(i2 > 5 && random.nextInt(50) == 1 && field_25316_type == 7)
            {
                func_25299_genMobSpawner(world, random, i, j, k);
                return;
            }
        }
        if(field_25316_type == 4 || field_25316_type == 8)
        {
            int l1 = random.nextInt(5);
            if(l1 == 1)
            {
                func_25310_generateColumn(world, random, i, j, k);
            }
        }
        if(random.nextInt(250) == 1 && field_25316_type < 4)
        {
            func_25308_genChest(world, random, i, j, k);
        } else
        if(field_25316_type == 7 && field_25313_placedSpawn && random.nextInt(2) == 1)
        {
            func_25308_genChest(world, random, i, j, k);
        }
    }

    private double func_25305_distanceBetweenD(int i, int j, int k, int l)
    {
        double d = Math.sqrt(Math.pow(k - i, 2D) + Math.pow(l - j, 2D));
        return d;
    }

    private int func_25300_distanceBetween(int i, int j, int k, int l)
    {
        Double double1 = Double.valueOf(func_25305_distanceBetweenD(i, j, k, l));
        return double1.intValue();
    }

    private void func_25308_genChest(World world, Random random, int i, int j, int k)
    {
        if(!field_25318_placedChest)
        {
            world.setBlockWithNotify(i, j, k, Block.chest.blockID);
            TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i, j, k);
            int l = 0;
            byte byte0 = 3;
            if(field_25316_type == 7)
            {
                byte0 = 6;
            }
            for(; l < byte0; l++)
            {
                ItemStack itemstack = func_25303_a(random);
                if(itemstack != null)
                {
                    tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), itemstack);
                }
            }

            field_25318_placedChest = true;
        }
    }

    private void func_25299_genMobSpawner(World world, Random random, int i, int j, int k)
    {
        if(!field_25313_placedSpawn)
        {
            world.setBlockWithNotify(i, j, k, Block.mobSpawner.blockID);
            TileEntityMobSpawner mobSpawner = (TileEntityMobSpawner)world.getBlockTileEntity(i, j, k);
            mobSpawner.setMobID(func_25306_b(random));
            field_25313_placedSpawn = true;
        }
    }

    private ItemStack func_25303_a(Random random)
    {
        int i = random.nextInt(8);
        if(i == 0)
        {
            return new ItemStack(Item.coal, random.nextInt(3) + 1);
        }
        if(i == 1)
        {
            return new ItemStack(Block.torchWood, random.nextInt(4) + 1);
        }
        if(i == 2)
        {
            return new ItemStack(Item.clay, random.nextInt(2) * 4 + 4);
        }
        if(i == 3)
        {
            return new ItemStack(Item.bone, random.nextInt(4) + 1);
        }
        if(i == 4)
        {
            return new ItemStack(Item.stick, random.nextInt(2) + 1);
        }
        if(i == 5)
        {
            return new ItemStack(Block.torchWood, random.nextInt(4) + 1);
        } else
        {
            return null;
        }
    }

    private String func_25306_b(Random random)
    {
        int i = random.nextInt(4);
        if(i == 0)
        {
            return "Skeleton";
        }
        if(i == 1)
        {
            return "Zombie";
        }
        if(i == 2)
        {
            return "Slime";
        }
        if(i == 3)
        {
            return "Spider";
        } else
        {
            return "";
        }
    }

    private int field_25315_radius;
    private int field_25321_skip;
    private int field_25319_skipCounter;
    private boolean field_25322_skipper;
    private int field_25316_type;
    private int field_25314_torchSkip;
    private int field_25317_numTorches;
    private boolean field_25318_placedChest;
    private boolean field_25313_placedSpawn;
    private static final int field_25312_COLUMN_HEIGHT = 5;
    private static final int field_25311_TORCH_LIMIT = 8;
    private static final int field_25320_MAX_DIFFERENCE = 3;
}
