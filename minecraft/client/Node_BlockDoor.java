package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_BlockDoor extends BlockDoor
{

    protected Node_BlockDoor(int i, Material material, int j, int k)
    {
        super(i, material);
        field_25281_topInd = j;
        field_25280_bottomInd = k;
        blockIndexInTexture = k;
        float f = 0.5F;
        float f1 = 1.0F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 0 || i == 1)
        {
            return field_25281_topInd;
        }
        int k = getState(j);
        if((k == 0 || k == 2) ^ (i <= 3))
        {
            return field_25281_topInd;
        }
        int l = k / 2 + (i & 1 ^ k);
        l += (j & 4) / 4;
        int i1 = 97 - (j & 8) * 2;
        if((l & 1) != 0)
        {
            i1 = -i1;
        }
        if(i1 == 97 || i1 == -97)
        {
            return field_25280_bottomInd;
        } else
        {
            return field_25281_topInd;
        }
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(blockMaterial == Material.rock)
        {
            return true;
        }
        int l = world.getBlockMetadata(i, j, k);
        if((l & 8) != 0)
        {
            if(world.getBlockId(i, j - 1, k) == blockID)
            {
            	blockActivated(world, i, j - 1, k, entityplayer);
            }
            return true;
        }
        if(world.getBlockId(i, j + 1, k) == blockID)
        {
            world.setBlockMetadataWithNotify(i, j + 1, k, (l ^ 4) + 8);
        }
        world.setBlockMetadataWithNotify(i, j, k, l ^ 4);
        world.markBlocksDirty(i, j - 1, k, i, j, k);
        if(Math.random() < 0.5D)
        {
            world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.door_open", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
        } else
        {
            world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.door_close", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
        }
        return true;
    }

    public int idDropped(int i, Random random)
    {
        if((i & 8) != 0)
        {
            return 0;
        }
        if(blockMaterial == Material.rock)
        {
            return mod_Node_DoorPack.itemBrickDoor.shiftedIndex;
        } else
        {
            return mod_Node_DoorPack.itemGlassDoor.shiftedIndex;
        }
    }

    private int field_25281_topInd;
    private int field_25280_bottomInd;
}
