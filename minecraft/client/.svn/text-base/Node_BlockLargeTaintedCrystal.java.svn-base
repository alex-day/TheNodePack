package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_BlockLargeTaintedCrystal extends Block
{

    public Node_BlockLargeTaintedCrystal(int i, int j, int k)
    {
        super(i, Material.glass);
        field_25277_texArray = j;
        field_25276_topTexArray = k;
        setTickOnLoad(true);
        setLightValue(0.6F);
        blockIndexInTexture = j;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return func_25274_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)) || func_25274_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k));
    }

    protected boolean func_25274_canThisCrystalGrowOnThisBlockID(int i)
    {
        return i == Block.netherrack.blockID || i == Block.glowStone.blockID || i == blockID;
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        if(l / 10 == 1)
        {
            return world.getBlockLightValue(i, j, k) <= 13 && func_25274_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k));
        } else
        {
            return world.getBlockLightValue(i, j, k) <= 13 && func_25274_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
        }
    }

    public int idDropped(int i, Random random)
    {
        return mod_Node_CrystalPack.crystalTainted.blockID;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        func_25275_h(world, i, j, k);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        func_25275_h(world, i, j, k);
    }

    protected final void func_25275_h(World world, int i, int j, int k)
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
        if(l == 0 && func_25274_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k)))
        {
            i1 = 10;
        }
        if(l == 1 && func_25274_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)))
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
        if(func_25274_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j + 1, k)))
        {
            l += 10;
        }
        if(func_25274_canThisCrystalGrowOnThisBlockID(world.getBlockId(i, j - 1, k)))
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
            return field_25276_topTexArray;
        } else
        {
            return field_25277_texArray;
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

    int field_25277_texArray;
    int field_25276_topTexArray;
}
