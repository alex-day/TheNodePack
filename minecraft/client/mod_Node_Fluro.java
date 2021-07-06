package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_Fluro extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_Fluro()
    {
        if(blockFluro != null)
        {
            ModLoader.RegisterBlock(blockFluro,Node_ItemFluro.class);
            mod_Node_PackLoader.trace("Sucessfully loaded Fluro Block");
			ModLoader.AddName(new ItemStack(blockFluro,1,0), "White Fluro Tube");
			ModLoader.AddName(new ItemStack(blockFluro,1,1), "Blue Fluro Tube");
			ModLoader.AddName(new ItemStack(blockFluro,1,2), "Green Fluro Tube");
        }
		AddRecipes();
    }

    public void AddRecipes()
    {
        if(blockFluro != null)
        {
			ModLoader.AddRecipe(new ItemStack(blockFluro, 8, 0), new Object[] {
				"#Y#", "YXY", "#Y#",
				Character.valueOf('#'), Block.glass,
				Character.valueOf('X'), new ItemStack(Block.torchWood),
				Character.valueOf('Y'), new ItemStack(Item.dyePowder, 1, 15)
			});
			ModLoader.AddRecipe(new ItemStack(blockFluro, 8, 1), new Object[] {
				"#Y#", "YXY", "#Y#",
				Character.valueOf('#'), Block.glass,
				Character.valueOf('X'), new ItemStack(Block.torchWood),
				Character.valueOf('Y'), new ItemStack(Item.dyePowder, 1, 4)
			});
			ModLoader.AddRecipe(new ItemStack(blockFluro, 8, 2), new Object[] {
				"#Y#", "YXY", "#Y#",
				Character.valueOf('#'), Block.glass,
				Character.valueOf('X'), new ItemStack(Block.torchWood),
				Character.valueOf('Y'), new ItemStack(Item.dyePowder, 1, 2)
			});
        }
    }

    public static Block blockFluro = null;
    public static int texAry[];

    static 
    {
        texAry = new int[3];
        texAry[0] = ModLoader.addOverride("/terrain.png", "/NodePack/fluro tubes/fluro-white.png");
        texAry[1] = ModLoader.addOverride("/terrain.png", "/NodePack/fluro tubes/fluro-blue.png");
        texAry[2] = ModLoader.addOverride("/terrain.png", "/NodePack/fluro tubes/fluro-green.png");
		
        int i = mod_Node_PackLoader.getID("blockFluro");
        if(i != -1)
        {
            blockFluro = (new Node_BlockFluro(i, texAry)).setHardness(1.0F).setLightValue(1.0F).setResistance(2.0F).setStepSound(Block.soundGlassFootstep).setBlockName("Fluro Block");
        }
    }
}
