package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_GravLift extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_GravLift()
    {
        ModLoader.RegisterBlock(blockGravLiftControl);
        mod_Node_PackLoader.trace("Sucessfully loaded Gravity Lift Control");
        ModLoader.RegisterBlock(blockGravLift);
        mod_Node_PackLoader.trace("Sucessfully loaded Gravity Lift");
        ModLoader.AddName(blockGravLiftControl, "Gravity Lift Control");
        ModLoader.AddName(blockGravLift, "Gravity Lift");
        ModLoader.RegisterTileEntity(Node_TileEntityGravLift.class, "GravLift");
		
		AddRecipes();
    }

    public void AddRecipes()
    {
        ModLoader.AddRecipe(new ItemStack(blockGravLiftControl), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Item.ingotIron, Character.valueOf('X'), Item.diamond
        });
    }

    public static Block blockGravLiftControl = null;
    public static Block blockGravLift = null;

    static 
    {
        blockGravLiftControl = (new Node_BlockGravLiftControl(mod_Node_PackLoader.getID("GravLiftControl"), ModLoader.addOverride("/terrain.png", "/NodePack/gravity lift/control.png"))).setHardness(1.0F).setResistance(1.0F).setStepSound(Block.soundMetalFootstep).setBlockName("gravControl");
        int i = ModLoader.addOverride("/terrain.png", "/NodePack/gravity lift/lift.png");
        blockGravLift = (new Node_BlockGravLift(mod_Node_PackLoader.getID("GravLift"), i)).setHardness(-1F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setBlockName("gravLift");
    }
}
