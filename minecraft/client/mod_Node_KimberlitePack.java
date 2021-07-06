package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class mod_Node_KimberlitePack extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_KimberlitePack()
    {
        if(blockKimberlite != null)
        {
            ModLoader.RegisterBlock(blockKimberlite);
            ModLoader.AddName(blockKimberlite, "Kimberlite");
            mod_Node_PackLoader.trace("Sucessfully loaded kimberlite");
        }
        if(oreKimberlite != null)
        {
            ModLoader.RegisterBlock(oreKimberlite);
            ModLoader.AddName(oreKimberlite, "Kimberlite Ore");
            mod_Node_PackLoader.trace("Sucessfully loaded kimberlite ore");
        }
        if(blockCompacterIdle != null && blockCompacterActive != null)
        {
            ModLoader.RegisterBlock(blockCompacterIdle);
            ModLoader.AddName(blockCompacterIdle, "Compacter");
            mod_Node_PackLoader.trace("Sucessfully loaded compacter idle");
            ModLoader.RegisterBlock(blockCompacterActive);
            ModLoader.AddName(blockCompacterActive, "Volcanic Compressor");
            mod_Node_PackLoader.trace("Sucessfully loaded compacter active");
            ModLoader.RegisterTileEntity(Node_TileEntityCompacter.class, "Compacter");
        }
        if(oreKimberlite != null)
        {
            ModLoader.AddSmelting(oreKimberlite.blockID, new ItemStack(Item.diamond, 1));
        }
		
		AddRecipes();
    }

    public void AddRecipes()
    {
        if(blockCompacterIdle != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockCompacterIdle, 1), new Object[] {
                "###", "# #", "###", Character.valueOf('#'), Block.stone
            });
        }
    }

    public void GenerateNether(World world, Random random, int i, int j)
    {
        if(blockKimberlite != null)
        {
            for(int k = 0; k < 20; k++)
            {
                int l = i + random.nextInt(16);
                int i1 = random.nextInt(64);
                int j1 = j + random.nextInt(16);
                (new Node_WorldGenMinableNether(blockKimberlite.blockID, 7)).func_25323_a(world, random, l, i1, j1);
            }

        }
    }

    public static Block blockKimberlite = null;
    public static Block oreKimberlite = null;
    public static Block blockCompacterIdle = null;
    public static Block blockCompacterActive = null;

    static 
    {
        int i = ModLoader.addOverride("/terrain.png", "/NodePack/kimberlite.png");
        int j = mod_Node_PackLoader.getID("kimberlite");
        if(j != -1)
        {
            blockKimberlite = (new Block(j, i, Material.rock)).setHardness(2.0F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setBlockName("kimberlite");
        }
        int k = ModLoader.addOverride("/terrain.png", "/NodePack/kimberlite_ore.png");
        int l = mod_Node_PackLoader.getID("kimberliteOre");
        if(l != -1)
        {
            oreKimberlite = (new BlockOre(l, k)).setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setBlockName("oreKimberlite");
        }
        int i1 = mod_Node_PackLoader.getID("compacterActive");
        int j1 = mod_Node_PackLoader.getID("compacterIdle");
        if(j1 != -1 && i1 != -1)
        {
            int k1 = ModLoader.addOverride("/terrain.png", "/NodePack/compacter_idle.png");
            int l1 = ModLoader.addOverride("/terrain.png", "/NodePack/compacter_active.png");
            blockCompacterIdle = (new Node_BlockCompacter(j1, false, k1, l1)).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setBlockName("Compacter");
            blockCompacterActive = (new Node_BlockCompacter(i1, true, k1, l1)).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setLightValue(0.875F).setBlockName("Compacter");
        }
    }
}
