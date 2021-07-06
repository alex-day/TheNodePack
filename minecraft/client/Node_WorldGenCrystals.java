package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_WorldGenCrystals extends RenderTNTPrimed
{

    public Node_WorldGenCrystals(int i)
    {
        field_25298_a = i;
    }

    public boolean func_25297_a(World world, Random random, int i, int j, int k)
    {
		int limit = 16;
		if(world.worldInfo.getDimension() != 0) {
			limit = 24;
		}
        for(int l = 0; l < limit; l++)
        {
            byte byte0 = 3;
            int i1 = (i + byte0) - random.nextInt(byte0 * 2 + 1);
            int j1 = (j + byte0) - random.nextInt(byte0 * 2 + 1);
            int k1 = (k + byte0) - random.nextInt(byte0 * 2 + 1);
            if(Block.blocksList[field_25298_a] instanceof Node_BlockTaintedCrystal)
            {
                if(world.isAirBlock(i1, j1, k1) && ((Node_BlockTaintedCrystal)Block.blocksList[field_25298_a]).canBlockStay(world, i1, j1, k1))
                {
                    mod_Node_PackLoader.trace((new StringBuilder()).append("tainted crystal created at [").append(i1).append(",").append(j1).append(",").append(k1).append("]").toString());
                    world.setBlock(i1, j1, k1, field_25298_a);
                }
                continue;
            }
            if(world.isAirBlock(i1, j1, k1) && ((Node_BlockCrystal)Block.blocksList[field_25298_a]).canBlockStay(world, i1, j1, k1))
            {
                mod_Node_PackLoader.trace((new StringBuilder()).append("crystal created at [").append(i1).append(",").append(j1).append(",").append(k1).append("]").toString());
                world.setBlock(i1, j1, k1, field_25298_a);
            }
        }

        return true;
    }

    private int field_25298_a;
}
