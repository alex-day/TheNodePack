package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_IlluminationTube extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_IlluminationTube()
    {
        ModLoader.RegisterBlock(blockIlluminationTube);
        mod_Node_PackLoader.trace("Sucessfully loaded lightStick");
        ModLoader.AddName(blockIlluminationTube, "Illumination Tube");
		AddRecipes();
    }

    public void AddRecipes()
    {
        ModLoader.AddRecipe(new ItemStack(blockIlluminationTube, 4), new Object[] {
            " X ", "Y#Y", " X ", Character.valueOf('X'), Block.stone, Character.valueOf('#'), Item.lightStoneDust, Character.valueOf('Y'), Block.glass
        });
        ModLoader.AddRecipe(new ItemStack(blockIlluminationTube, 4), new Object[] {
            " X ", "Y#Y", " X ", Character.valueOf('X'), Block.stone, Character.valueOf('#'), Item.gunpowder, Character.valueOf('Y'), Block.glass
        });
    }

    public static final Block blockIlluminationTube;
    public static final Block blockIlluminationTubeRoof;

    static 
    {
        int i = ModLoader.addOverride("/terrain.png", "/NodePack/light_stick.png");
        int j = ModLoader.addOverride("/terrain.png", "/NodePack/light_stick_roof.png");
        blockIlluminationTube = (new Node_BlockIlluminationTube(mod_Node_PackLoader.getID("IlluminationTube"), i)).setHardness(0.0F).setLightValue(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("lightStick");
        blockIlluminationTubeRoof = (new Node_BlockIlluminationTubeRoof(mod_Node_PackLoader.getID("IlluminationTubeRoof"), j)).setHardness(0.0F).setLightValue(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("lightStick");
    }
}
