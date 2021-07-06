package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_BlockLargeCrystal extends Block
{

    public Node_BlockLargeCrystal(int i, int ai[], int ai1[])
    {
        super(i, Material.glass);
        field_25270_texArray = ai;
        field_25269_topTexArray = ai1;
        setTickOnLoad(true);
        setLightValue(0.6F);
        blockIndexInTexture = ai[0];
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return func_25268_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k), world.getBlockMetadata(i, j, k) % 10) || func_25268_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k), world.getBlockMetadata(i, j, k) % 10);
    }

    protected boolean func_25268_canThisCrystalGrowOnThisBlockID(int i, int j)
    {
        if(j == 5)
        {
            return i == Block.stone.blockID || i == Block.dirt.blockID || i == Block.grass.blockID || i == blockID || i == Block.cobblestone.blockID || i == Block.cobblestoneMossy.blockID;
        } else
        {
            return i == Block.stone.blockID || i == Block.dirt.blockID || i == Block.grass.blockID || i == blockID || i == Block.cobblestone.blockID || i == Block.cobblestoneMossy.blockID;
        }
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        if(l / 10 == 1)
        {
            return world.getBlockLightValue(i, j, k) <= 13 && func_25268_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k), world.getBlockMetadata(i, j, k) % 10);
        } else
        {
            return world.getBlockLightValue(i, j, k) <= 13 && func_25268_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k), world.getBlockMetadata(i, j, k) % 10);
        }
    }

    public int idDropped(int i, Random random)
    {
        int j = i % 10;
        if(j == 0)
        {
            return mod_Node_CrystalPack.crystalRed.blockID;
        }
        if(j == 1)
        {
            return mod_Node_CrystalPack.crystalBlue.blockID;
        }
        if(j == 2)
        {
            return mod_Node_CrystalPack.crystalGreen.blockID;
        }
        if(j == 3)
        {
            return mod_Node_CrystalPack.crystalPurple.blockID;
        }
        if(j == 4)
        {
            return mod_Node_CrystalPack.crystalYellow.blockID;
        }
        if(j == 5)
        {
            return mod_Node_CrystalPack.crystalWhite.blockID;
        } else
        {
            return blockID;
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        func_25267_h(world, i, j, k);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        func_25267_h(world, i, j, k);
    }

    protected final void func_25267_h(World world, int i, int j, int k)
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
        if(l == 0 && func_25268_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k), world.getBlockMetadata(i, j, k) % 10))
        {
            i1 = 10;
        }
        if(l == 1 && func_25268_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k), world.getBlockMetadata(i, j, k) % 10))
        {
            i1 = 0;
        }
        Random random = new Random();
        i1 += random.nextInt(6);
        world.setBlockMetadataWithNotify(i, j, k, i1);
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        if(func_25268_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k), world.getBlockMetadata(i, j, k) % 10))
        {
            l += 10;
        }
        if(func_25268_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k), world.getBlockMetadata(i, j, k) % 10))
        {
            l += 0;
        }
        world.setBlockMetadataWithNotify(i, j, k, l);
    }

    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return 13;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        int k = j % 10;
        if(i == 0 || i == 1)
        {
            return field_25269_topTexArray[k];
        } else
        {
            return field_25270_texArray[k];
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBoxFromPool((float)i + f, j, (float)k + f, (float)(i + 1) - f, (float)(j + 1) - f, (float)(k + 1) - f);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBoxFromPool((float)i + f, j, (float)k + f, (float)(i + 1) - f, j + 1, (float)(k + 1) - f);
    }

    int field_25270_texArray[];
    int field_25269_topTexArray[];
}
