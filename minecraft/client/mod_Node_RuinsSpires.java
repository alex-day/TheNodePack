package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class mod_Node_RuinsSpires extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_RuinsSpires()
    {
    }

    public void GenerateSurface(World world, Random random, int i, int j)
    {
        int k = mod_Node_PackLoader.getIntOption("RuinDistance");
        float f = mod_Node_PackLoader.getFloatOption("RuinChance");
        int l = mod_Node_PackLoader.getIntOption("RuinTries");
        int i1 = mod_Node_PackLoader.getIntOption("RuinSpread");
        int j1 = mod_Node_PackLoader.getIntOption("SpireRadius");
        float f1 = mod_Node_PackLoader.getFloatOption("SpireChance");
        int k1 = mod_Node_PackLoader.getIntOption("SpireHeight");
        float deathChance = mod_Node_PackLoader.getFloatOption("DeathSpires");
        if(Math.abs(i % k) < 16 && Math.abs(j % k) < 16)
        {
            float f2 = random.nextFloat();
            if(f2 <= f)
            {
                float f3 = random.nextFloat();
                if(f3 < f1)
                {
                    mod_Node_PackLoader.trace((new StringBuilder()).append("generating spires for [").append(i).append(",").append(j).append("]").toString());
                    for(int l1 = 0; l1 < l; l1++)
                    {
                        int j2 = 2;
                        if(j1 > 2)
                        {
                            j2 += random.nextInt(j1 - 2);
                        }
                        int l2 = (1 + random.nextInt(k1 * 2)) * 5;
                        int j3 = random.nextInt(9);
                        int l3 = i + random.nextInt(i1);
                        int j4 = 32 + random.nextInt(64);
                        int l4 = j + random.nextInt(i1);
						
						boolean isDeath = random.nextFloat() < deathChance;
						
                        boolean flag1 = (new Node_WorldGenSpires(j2, l2, j3, isDeath)).func_25286_a(world, random, l3, j4, l4);
                        if(flag1)
                        {
                            mod_Node_PackLoader.trace("spires have been generated!");
                        }
                    }

                } else
                {
                    mod_Node_PackLoader.trace((new StringBuilder()).append("generating ruins for [").append(i).append(",").append(j).append("]").toString());
                    for(int i2 = 0; i2 < l; i2++)
                    {
                        int k2 = 3 + random.nextInt(5);
                        int i3 = random.nextInt(4);
                        int k3 = random.nextInt(9);
                        int i4 = i + random.nextInt(i1);
                        int k4 = 32 + random.nextInt(64);
                        int i5 = j + random.nextInt(i1);
                        boolean flag2 = (new Node_WorldGenRuins(k2, i3, k3)).func_25301_a(world, random, i4, k4, i5);
                        if(flag2)
                        {
                            mod_Node_PackLoader.trace("ruins have been generated!");
                        }
                    }

                }
            }
        }
    }
}
