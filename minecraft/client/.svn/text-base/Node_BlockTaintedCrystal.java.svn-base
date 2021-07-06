package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.io.PrintStream;
import java.util.Random;

public class Node_BlockTaintedCrystal extends Block
{

    public Node_BlockTaintedCrystal(int i, int j, int k)
    {
        super(i, j, Material.glass);
        field_25231_altTexID = k;
        setTickOnLoad(true);
        field_25230_spread = 5;
        setLightValue(0.3125F);
        float f = 0.375F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return func_25226_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)) || func_25226_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k));
    }

    protected boolean func_25226_canThisCrystalGrowOnThisBlockID(int i)
    {
        return i == Block.netherrack.blockID || i == Block.slowSand.blockID;
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return world.getBlockLightValue(i, j, k) <= 13 && (func_25226_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)) || func_25226_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k)));
    }

    public int idDropped(int i, Random random)
    {
        return mod_Node_CrystalPack.shardTainted.shiftedIndex;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        func_25229_h(world, i, j, k);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        byte byte0 = 3;
        int l = byte0 - random.nextInt(byte0 * 2);
        int i1 = byte0 - random.nextInt(byte0 * 2);
        int j1 = byte0 - random.nextInt(byte0 * 2);
        int k1 = world.getBlockMetadata(i, j, k);
        int l1 = k1 + 1;
        int i2 = k1 % 10;
        if(i2 == 5)
        {
            l1 = (k1 / 10) * 10;
        }
        int j2 = random.nextInt(200);
		if((world.getBlockId(i, j - 1, k) == Block.slowSand.blockID || world.getBlockId(i, j + 1, k) == Block.slowSand.blockID) && j2 != 10)
        {
            j2 = random.nextInt(145);
        }
        if(func_25228_checkForTooManyLarge(world, i, j, k, random))
        {
            j2 = 0;
        }
        if(i2 == 5 && j2 == 10)
        {
            int k2 = 0;
            boolean flag = false;
            boolean flag1 = k1 / 10 == 1;
            int i3 = 0;
            System.out.println((new StringBuilder()).append("Attempting to place a large tainted crystal at: [").append(i).append(",").append(j).append(",").append(k).append("]").toString());
            for(; i3 < 4; i3++)
            {
                if(flag1)
                {
                    if(!world.isAirBlock(i, j - i3, k) && world.getBlockId(i, j - i3, k) != blockID)
                    {
                        break;
                    }
                    world.setBlockAndMetadataWithNotify(i, j - i3, k, mod_Node_CrystalPack.largeTaintedCrystal.blockID, k2);
                    mod_Node_PackLoader.trace((new StringBuilder()).append("generating large tainted crystal on roof at [").append(i).append(",").append(j - i3).append(",").append(k).append("]").toString());
                    flag = true;
                    continue;
                }
                if(!world.isAirBlock(i, j + i3, k) && world.getBlockId(i, j + i3, k) != blockID)
                {
                    break;
                }
                world.setBlockAndMetadataWithNotify(i, j + i3, k, mod_Node_CrystalPack.largeTaintedCrystal.blockID, k2);
                mod_Node_PackLoader.trace((new StringBuilder()).append("generating large tainted crystal on floor at [").append(i).append(",").append(j + i3).append(",").append(k).append("]").toString());
                flag = true;
            }

            if(!flag)
            {
                world.setBlockMetadata(i, j, k, (k1 / 10) * 10);
            }
        } else
        if(world.isAirBlock(i + l, j + i1, k + j1) && canBlockStay(world, i + l, j + i1, k + j1))
        {
            int l2 = random.nextInt(12);
            if((world.getBlockId(i, j - 1, k) == Block.slowSand.blockID || world.getBlockId(i, j + 1, k) == Block.slowSand.blockID) && l2 != 2)
            {
                l2 = random.nextInt(6);
            } else
			if(func_25227_checkForTooMany(world, i, j, k, random))
            {
                l2 = 0;
            }
            if(i2 == 5 && l2 == 2)
            {
                world.setBlockWithNotify(i + l, j + i1, k + j1, blockID);
                world.setBlockMetadata(i, j, k, l1);
            } else
            {
                world.setBlockMetadata(i, j, k, l1);
            }
        } else
        {
            world.setBlockMetadata(i, j, k, l1);
        }
        func_25229_h(world, i, j, k);
    }

    protected final void func_25229_h(World world, int i, int j, int k)
    {
        if(!canBlockStay(world, i, j, k))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        }
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        if(l == 0 && func_25226_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k)))
        {
            i1 = 10;
        }
        if(l == 1 && func_25226_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)))
        {
            i1 = 0;
        }
        world.setBlockMetadataWithNotify(i, j, k, i1);
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        byte byte0 = 0;
        if(func_25226_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k)))
        {
            byte0 = 10;
        }
        if(func_25226_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)))
        {
            byte0 = 0;
        }
        world.setBlockMetadataWithNotify(i, j, k, byte0);
    }

    public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(2);
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
        return 1;
    }

    public int tickRate()
    {
        return 20;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j / 10 == 1)
        {
            return field_25231_altTexID;
        } else
        {
            return getBlockTextureFromSide(i);
        }
    }

    public boolean func_25228_checkForTooManyLarge(World world, int i, int j, int k, Random random)
    {
        int l = -field_25230_spread;
        int j1 = -field_25230_spread;
        int l1 = -field_25230_spread;
        int j2 = 0;
        for(int i1 = -field_25230_spread; i1 <= field_25230_spread * 2; i1++)
        {
            for(int k1 = -field_25230_spread; k1 <= field_25230_spread * 2; k1++)
            {
                for(int i2 = -field_25230_spread; i2 <= field_25230_spread * 2; i2++)
                {
                    if(world.getBlockId(i + i1, j + k1, k + i2) == mod_Node_CrystalPack.largeTaintedCrystal.blockID)
                    {
                        j2++;
                    }
                }

            }

        }

        return j2 >= 12;
    }

    public boolean func_25227_checkForTooMany(World world, int i, int j, int k, Random random)
    {
        int l = -field_25230_spread;
        int j1 = -field_25230_spread;
        int l1 = -field_25230_spread;
        int j2 = 0;
        for(int i1 = -field_25230_spread; i1 <= field_25230_spread * 2; i1++)
        {
            for(int k1 = -field_25230_spread; k1 <= field_25230_spread * 2; k1++)
            {
                for(int i2 = -field_25230_spread; i2 <= field_25230_spread * 2; i2++)
                {
                    if(world.getBlockId(i + i1, j + k1, k + i2) == mod_Node_CrystalPack.largeTaintedCrystal.blockID || world.getBlockId(i + i1, j + k1, k + i2) == blockID)
                    {
                        j2++;
                    }
                }

            }

        }

        int k2 = 10 + random.nextInt(9);
        return j2 >= k2;
    }

    int field_25231_altTexID;
    int field_25230_spread;
}
