package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_Detector extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_Detector()
    {
        ModLoader.RegisterBlock(blockDetector);
        mod_Node_PackLoader.trace("Sucessfully loaded MEtal Detector");
        ModLoader.AddName(blockDetector, "Metal Detector");
		AddRecipes();
    }

    public void AddRecipes()
    {
        ModLoader.AddRecipe(new ItemStack(blockDetector), new Object[] {
            "#A#", "BCD", "#E#", Character.valueOf('#'), Item.ingotIron, Character.valueOf('A'), Item.ingotGold, Character.valueOf('B'), Item.coal, Character.valueOf('C'), 
            Item.diamond, Character.valueOf('D'), Item.redstone, Character.valueOf('E'), new ItemStack(Item.dyePowder, 1, 4)
        });
        
    }

    public static Block blockDetector = null;
    public static int field_25092_texAry[];

    static 
    {
        field_25092_texAry = new int[7];
        field_25092_texAry[0] = ModLoader.addOverride("/terrain.png", "/NodePack/detector/detector_off.png");
        field_25092_texAry[1] = ModLoader.addOverride("/terrain.png", "/NodePack/detector/detector_coal.png");
        field_25092_texAry[2] = ModLoader.addOverride("/terrain.png", "/NodePack/detector/detector_iron.png");
        field_25092_texAry[3] = ModLoader.addOverride("/terrain.png", "/NodePack/detector/detector_redstone.png");
        field_25092_texAry[4] = ModLoader.addOverride("/terrain.png", "/NodePack/detector/detector_lapis.png");
        field_25092_texAry[5] = ModLoader.addOverride("/terrain.png", "/NodePack/detector/detector_gold.png");
        field_25092_texAry[6] = ModLoader.addOverride("/terrain.png", "/NodePack/detector/detector_diamond.png");
        blockDetector = (new Node_BlockDetector(mod_Node_PackLoader.getID("nodeDetector"), field_25092_texAry, 3)).setHardness(1.0F).setLightValue(0.5F).setResistance(2.0F).setStepSound(Block.soundMetalFootstep).setBlockName("detector");
    }
}
