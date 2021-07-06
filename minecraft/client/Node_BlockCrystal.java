package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.io.PrintStream;
import java.util.Random;

public class Node_BlockCrystal extends Block
{

    public Node_BlockCrystal(int i, int j, int k)
    {
        super(i, j, Material.glass);
        field_25241_altTexID = k;
        setTickOnLoad(true);
        field_25240_spread = 3;
        setLightValue(0.3125F);
        float f = 0.375F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return func_25239_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)) || func_25239_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k));
    }

    protected boolean func_25239_canThisCrystalGrowOnThisBlockID(int i)
    {
        if(blockID == mod_Node_CrystalPack.crystalWhite.blockID)
        {
            return i == Block.stone.blockID || i == Block.dirt.blockID || i == Block.grass.blockID || i == Block.cobblestone.blockID || i == Block.cobblestoneMossy.blockID || i == Block.netherrack.blockID || i == Block.slowSand.blockID;
        } else
        {
            return i == Block.stone.blockID || i == Block.dirt.blockID || i == Block.grass.blockID || i == Block.cobblestone.blockID || i == Block.cobblestoneMossy.blockID;
        }
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return world.getBlockLightValue(i, j, k) <= 13 && (func_25239_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)) || func_25239_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k)));
    }

    public int idDropped(int i, Random random)
    {
        if(blockID == mod_Node_CrystalPack.crystalRed.blockID)
        {
            return mod_Node_CrystalPack.shardRed.shiftedIndex;
        }
        if(blockID == mod_Node_CrystalPack.crystalBlue.blockID)
        {
            return mod_Node_CrystalPack.shardBlue.shiftedIndex;
        }
        if(blockID == mod_Node_CrystalPack.crystalGreen.blockID)
        {
            return mod_Node_CrystalPack.shardGreen.shiftedIndex;
        }
        if(blockID == mod_Node_CrystalPack.crystalPurple.blockID)
        {
            return mod_Node_CrystalPack.shardPurple.shiftedIndex;
        }
        if(blockID == mod_Node_CrystalPack.crystalYellow.blockID)
        {
            return mod_Node_CrystalPack.shardYellow.shiftedIndex;
        }
        if(blockID == mod_Node_CrystalPack.crystalWhite.blockID)
        {
            return mod_Node_CrystalPack.shardWhite.shiftedIndex;
        } else
        {
            return blockID;
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        func_25238_h(world, i, j, k);
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
        if((world.getBlockId(i, j - 1, k) == Block.cobblestone.blockID || world.getBlockId(i, j + 1, k) == Block.cobblestone.blockID) && j2 != 10)
        {
            j2 = random.nextInt(160);
        }
        if((world.getBlockId(i, j - 1, k) == Block.slowSand.blockID || world.getBlockId(i, j + 1, k) == Block.slowSand.blockID) && j2 != 10)
        {
            j2 = random.nextInt(145);
        }
		if((world.getBlockId(i, j - 1, k) == Block.cobblestoneMossy.blockID || world.getBlockId(i, j + 1, k) == Block.cobblestoneMossy.blockID) && j2 != 10)
        {
            j2 = random.nextInt(100);
        } else
        if(func_25236_checkForTooManyLarge(world, i, j, k, random))
        {
            j2 = 0;
        }
        if(func_25235_checkForMobSpawner(world, i, j, k, random))
        {
            j2 = 0;
        }
        if(i2 == 5 && j2 == 10)
        {
            byte byte1 = 0;
            if(blockID == mod_Node_CrystalPack.crystalBlue.blockID)
            {
                byte1 = 1;
            }
            if(blockID == mod_Node_CrystalPack.crystalGreen.blockID)
            {
                byte1 = 2;
            }
            if(blockID == mod_Node_CrystalPack.crystalPurple.blockID)
            {
                byte1 = 3;
            }
            if(blockID == mod_Node_CrystalPack.crystalYellow.blockID)
            {
                byte1 = 4;
            }
            if(blockID == mod_Node_CrystalPack.crystalWhite.blockID)
            {
                byte1 = 5;
            }
            boolean flag = false;
            boolean flag1 = k1 / 10 == 1;
            int l2 = 0;
            System.out.println((new StringBuilder()).append("Attempting to place a large crystal at: [").append(i).append(",").append(j).append(",").append(k).append("]").toString());
            for(; l2 < 4; l2++)
            {
                if(flag1)
                {
                    if(!world.isAirBlock(i, j - l2, k) && world.getBlockId(i, j - l2, k) != blockID)
                    {
                        break;
                    }
                    world.setBlockAndMetadataWithNotify(i, j - l2, k, mod_Node_CrystalPack.largeCrystal.blockID, byte1);
                    mod_Node_PackLoader.trace((new StringBuilder()).append("generating large crystal on roof at [").append(i).append(",").append(j - l2).append(",").append(k).append("]").toString());
                    flag = true;
                    continue;
                }
                if(!world.isAirBlock(i, j + l2, k) && world.getBlockId(i, j + l2, k) != blockID)
                {
                    break;
                }
                world.setBlockAndMetadataWithNotify(i, j + l2, k, mod_Node_CrystalPack.largeCrystal.blockID, byte1);
                mod_Node_PackLoader.trace((new StringBuilder()).append("generating large crystal on floor at [").append(i).append(",").append(j + l2).append(",").append(k).append("]").toString());
                flag = true;
            }

            if(!flag)
            {
                world.setBlockMetadata(i, j, k, (k1 / 10) * 10);
            }
        } else
        if(world.isAirBlock(i + l, j + i1, k + j1) && canBlockStay(world, i + l, j + i1, k + j1))
        {
            int k2 = random.nextInt(12);
            if((world.getBlockId(i, j - 1, k) == Block.cobblestone.blockID || world.getBlockId(i, j + 1, k) == Block.cobblestone.blockID) && k2 != 2)
            {
                k2 = random.nextInt(8);
            } else
			if((world.getBlockId(i, j - 1, k) == Block.netherrack.blockID || world.getBlockId(i, j + 1, k) == Block.netherrack.blockID) && k2 != 2)
            {
                k2 = random.nextInt(6);
            } else
            if((world.getBlockId(i, j - 1, k) == Block.cobblestoneMossy.blockID || world.getBlockId(i, j + 1, k) == Block.cobblestoneMossy.blockID) && k2 != 2)
            {
                k2 = random.nextInt(4);
            }
            if(func_25237_checkForTooMany(world, i, j, k, random) || func_25235_checkForMobSpawner(world, i, j, k, random))
            {
                k2 = 0;
            }
            if(i2 == 5 && k2 == 2)
            {
                if((world.getBlockId(i, j - 1, k) == Block.slowSand.blockID || world.getBlockId(i, j + 1, k) == Block.slowSand.blockID) && blockID == mod_Node_CrystalPack.crystalWhite.blockID)
                {
                    world.setBlockWithNotify(i + l, j + i1, k + j1, mod_Node_CrystalPack.crystalTainted.blockID);
                    world.setBlockMetadata(i, j, k, l1);
                } else
                {
                    world.setBlockWithNotify(i + l, j + i1, k + j1, blockID);
                    world.setBlockMetadata(i, j, k, l1);
                }
            } else
            {
                world.setBlockMetadata(i, j, k, l1);
            }
        } else
        {
            world.setBlockMetadata(i, j, k, l1);
        }
        func_25238_h(world, i, j, k);
    }

    protected final void func_25238_h(World world, int i, int j, int k)
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
        if(l == 0 && func_25239_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k)))
        {
            i1 = 10;
        }
        if(l == 1 && func_25239_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)))
        {
            i1 = 0;
        }
        world.setBlockMetadataWithNotify(i, j, k, i1);
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        byte byte0 = 0;
        if(func_25239_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k)))
        {
            byte0 = 10;
        }
        if(func_25239_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)))
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
            return field_25241_altTexID;
        } else
        {
            return getBlockTextureFromSide(i);
        }
    }

    public boolean func_25236_checkForTooManyLarge(World world, int i, int j, int k, Random random)
    {
        int l = -field_25240_spread;
        int j1 = -field_25240_spread;
        int l1 = -field_25240_spread;
        int j2 = 0;
        for(int i1 = -field_25240_spread; i1 <= field_25240_spread * 2; i1++)
        {
            for(int k1 = -field_25240_spread; k1 <= field_25240_spread * 2; k1++)
            {
                for(int i2 = -field_25240_spread; i2 <= field_25240_spread * 2; i2++)
                {
                    if(world.getBlockId(i + i1, j + k1, k + i2) == mod_Node_CrystalPack.largeCrystal.blockID)
                    {
                        j2++;
                    }
                }

            }

        }

        return j2 >= 10;
    }

    public boolean func_25237_checkForTooMany(World world, int i, int j, int k, Random random)
    {
        int l = -field_25240_spread;
        int j1 = -field_25240_spread;
        int l1 = -field_25240_spread;
        int j2 = 0;
        for(int i1 = -field_25240_spread; i1 <= field_25240_spread * 2; i1++)
        {
            for(int k1 = -field_25240_spread; k1 <= field_25240_spread * 2; k1++)
            {
                for(int i2 = -field_25240_spread; i2 <= field_25240_spread * 2; i2++)
                {
                    if(world.getBlockId(i + i1, j + k1, k + i2) == mod_Node_CrystalPack.largeCrystal.blockID || world.getBlockId(i + i1, j + k1, k + i2) == blockID)
                    {
                        j2++;
                    }
                }

            }

        }

        int k2 = 8 + random.nextInt(9);
        return j2 >= k2;
    }

    public boolean func_25235_checkForMobSpawner(World world, int i, int j, int k, Random random)
    {
        int l = -field_25240_spread;
        int j1 = -field_25240_spread;
        int l1 = -field_25240_spread;
        for(int i1 = -field_25240_spread; i1 <= field_25240_spread * 2; i1++)
        {
            for(int k1 = -field_25240_spread; k1 <= field_25240_spread * 2; k1++)
            {
                for(int i2 = -field_25240_spread; i2 <= field_25240_spread * 2; i2++)
                {
                    if(world.getBlockId(i + i1, j + k1, k + i2) == Block.mobSpawner.blockID)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    int field_25241_altTexID;
    int field_25240_spread;
}
