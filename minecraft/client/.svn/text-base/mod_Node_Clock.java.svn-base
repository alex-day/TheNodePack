package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_Clock extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_Clock()
    {
        if(blockClock != null)
        {
            ModLoader.RegisterBlock(blockClock);
            mod_Node_PackLoader.trace("Sucessfully loaded Clock Block");
            ModLoader.AddName(blockClock, "Clock Block");
        }
		AddRecipes();
    }

    public void AddRecipes()
    {
        if(blockClock != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockClock), new Object[] {
                "###", "#X#", "###", Character.valueOf('#'), Block.glass, Character.valueOf('X'), Item.pocketSundial
            });
        }
    }

    public static Block blockClock = null;
    public static int texAry[];

    static 
    {
        texAry = new int[16];
        texAry[0] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_0000.png");
        texAry[1] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_1500.png");
        texAry[2] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_3000.png");
        texAry[3] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_4500.png");
        texAry[4] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_6000.png");
        texAry[5] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_7500.png");
        texAry[6] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_9000.png");
        texAry[7] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_10500.png");
        texAry[8] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_12000.png");
        texAry[9] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_13500.png");
        texAry[10] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_15000.png");
        texAry[11] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_16500.png");
        texAry[12] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_18000.png");
        texAry[13] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_19500.png");
        texAry[14] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_21000.png");
        texAry[15] = ModLoader.addOverride("/terrain.png", "/NodePack/clock/clockblock_22500.png");
        int i = mod_Node_PackLoader.getID("blockClock");
        if(i != -1)
        {
            blockClock = (new Node_BlockClock(i, texAry)).setHardness(1.0F).setLightValue(0.875F).setResistance(2.0F).setStepSound(Block.soundGlassFootstep).setBlockName("clockBlock");
        }
    }
}
