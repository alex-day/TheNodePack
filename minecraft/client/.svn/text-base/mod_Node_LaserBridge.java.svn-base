package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_LaserBridge extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_LaserBridge()
    {
        ModLoader.RegisterBlock(blockLaserBridgeControl);
        mod_Node_PackLoader.trace("Sucessfully loaded Laser Bridge Control");
        ModLoader.RegisterBlock(blockLaserBridge);
        mod_Node_PackLoader.trace("Sucessfully loaded Laser Bridge");
        ModLoader.RegisterBlock(blockAccelBridgeControl);
        mod_Node_PackLoader.trace("Sucessfully loaded Laser Bridge Control A");
        ModLoader.RegisterBlock(blockAccelBridge);
        mod_Node_PackLoader.trace("Sucessfully loaded Laser Bridge A");
        ModLoader.RegisterBlock(blockTrickBridgeControl);
        mod_Node_PackLoader.trace("Sucessfully loaded Laser Bridge Control T");
        ModLoader.RegisterBlock(blockTrickBridge);
        mod_Node_PackLoader.trace("Sucessfully loaded Laser Bridge T");
        ModLoader.RegisterBlock(blockDeathBridgeControl);
        mod_Node_PackLoader.trace("Sucessfully loaded Laser Bridge Control D");
        ModLoader.RegisterBlock(blockDeathBridge);
        mod_Node_PackLoader.trace("Sucessfully loaded Laser Bridge D");
        ModLoader.AddName(blockLaserBridgeControl, "Laser Bridge Control");
        ModLoader.AddName(blockLaserBridge, "Laser Bridge");
        ModLoader.AddName(blockAccelBridgeControl, "Accel Bridge Control");
        ModLoader.AddName(blockAccelBridge, "Accel Bridge");
        ModLoader.AddName(blockTrickBridgeControl, "Trick Bridge Control");
        ModLoader.AddName(blockTrickBridge, "Trick Bridge");
        ModLoader.AddName(blockDeathBridgeControl, "Death Bridge Control");
        ModLoader.AddName(blockDeathBridge, "Death Bridge");
        ModLoader.AddName(accelBoots, "Accel Boots");
        ModLoader.RegisterTileEntity(Node_TileEntityLBridge.class, "LBridge");
        ModLoader.RegisterTileEntity(Node_TileEntityLBridgeControl.class, "LBridgeControl");
        ModLoader.RegisterTileEntity(Node_TileEntityABridge.class, "ABridge");
        ModLoader.RegisterTileEntity(Node_TileEntityABridgeControl.class, "ABridgeControl");
        ModLoader.RegisterTileEntity(Node_TileEntityTBridge.class, "TBridge");
        ModLoader.RegisterTileEntity(Node_TileEntityTBridgeControl.class, "TBridgeControl");
        ModLoader.RegisterTileEntity(Node_TileEntityDBridge.class, "DBridge");
        ModLoader.RegisterTileEntity(Node_TileEntityDBridgeControl.class, "DBridgeControl");
		
		AddRecipes();
    }

    public void AddRecipes()
    {
        if(blockLaserBridgeControl != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockLaserBridgeControl), new Object[] {
                "###", "#X#", "###", Character.valueOf('#'), Block.cobblestone, Character.valueOf('X'), Item.slimeBall
            });
        }
        if(blockAccelBridgeControl != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockAccelBridgeControl), new Object[] {
                "###", "#X#", "#O#", Character.valueOf('#'), Item.ingotIron, Character.valueOf('X'), Item.bucketWater, Character.valueOf('O'), blockLaserBridgeControl
            });
        }
        if(blockTrickBridgeControl != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockTrickBridgeControl), new Object[] {
                "###", "#X#", "#O#", Character.valueOf('#'), Item.ingotIron, Character.valueOf('X'), Item.feather, Character.valueOf('O'), blockLaserBridgeControl
            });
        }
        if(blockDeathBridgeControl != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockDeathBridgeControl), new Object[] {
                "###", "#X#", "#O#", Character.valueOf('#'), Item.ingotIron, Character.valueOf('X'), Item.bucketLava, Character.valueOf('O'), blockLaserBridgeControl
            });
        }
        if(accelBoots != null)
        {
            ModLoader.AddRecipe(new ItemStack(accelBoots), new Object[] {
                "# #", "# #", Character.valueOf('#'), Item.slimeBall
            });
        }
    }

    public static Block blockLaserBridgeControl = null;
    public static Block blockLaserBridge = null;
    public static Block blockAccelBridgeControl = null;
    public static Block blockAccelBridge = null;
    public static Block blockTrickBridgeControl = null;
    public static Block blockTrickBridge = null;
    public static Block blockDeathBridgeControl = null;
    public static Block blockDeathBridge = null;
    public static Item accelBoots = null;

    static 
    {
        int i = mod_Node_PackLoader.getID("LaserBridgeControl");
        int j = mod_Node_PackLoader.getID("LaserBridge");
        if(i != -1 && j != -1)
        {
            blockLaserBridgeControl = (new Node_BlockLBridgeControl(i, ModLoader.addOverride("/terrain.png", "/NodePack/laser bridge/control.png"))).setHardness(1.0F).setResistance(1.0F).setStepSound(Block.soundMetalFootstep).setBlockName("laserControl");
            int k = ModLoader.addOverride("/terrain.png", "/NodePack/laser bridge/bridge.png");
            blockLaserBridge = (new Node_BlockLBridge(j, k)).setHardness(-1F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setBlockName("laserBridge");
            Node_TileEntityLBridge.defaultInd = -1;
        }
        int l = mod_Node_PackLoader.getID("LaserBridgeControlA");
        int i1 = mod_Node_PackLoader.getID("LaserBridgeA");
        if(l != -1 && i1 != -1)
        {
            blockAccelBridgeControl = (new Node_BlockABridgeControl(l, ModLoader.addOverride("/terrain.png", "/NodePack/laser bridge/controlA.png"))).setHardness(1.0F).setResistance(1.0F).setStepSound(Block.soundMetalFootstep).setBlockName("laserControlA");
            int j1 = ModLoader.addOverride("/terrain.png", "/NodePack/laser bridge/bridgeA.png");
            blockAccelBridge = (new Node_BlockABridge(i1, j1)).setHardness(-1F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setBlockName("laserBridgeA");
            Node_TileEntityABridge.defaultInd = -1;
        }
        int k1 = mod_Node_PackLoader.getID("LaserBridgeControlT");
        int l1 = mod_Node_PackLoader.getID("LaserBridgeT");
        if(k1 != -1 && l1 != -1)
        {
            blockTrickBridgeControl = (new Node_BlockTBridgeControl(k1, ModLoader.addOverride("/terrain.png", "/NodePack/laser bridge/controlT.png"))).setHardness(1.0F).setResistance(1.0F).setStepSound(Block.soundMetalFootstep).setBlockName("laserControlT");
            int i2 = ModLoader.addOverride("/terrain.png", "/NodePack/laser bridge/bridgeT.png");
            blockTrickBridge = (new Node_BlockTBridge(l1, i2)).setHardness(-1F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setBlockName("laserBridgeT");
            Node_TileEntityTBridge.defaultInd = -1;
        }
        int j2 = mod_Node_PackLoader.getID("LaserBridgeControlD");
        int k2 = mod_Node_PackLoader.getID("LaserBridgeD");
        if(j2 != -1 && k2 != -1)
        {
            blockDeathBridgeControl = (new Node_BlockDBridgeControl(j2, ModLoader.addOverride("/terrain.png", "/NodePack/laser bridge/controlD.png"))).setHardness(1.0F).setResistance(1.0F).setStepSound(Block.soundMetalFootstep).setBlockName("laserControlD");
            int l2 = ModLoader.addOverride("/terrain.png", "/NodePack/laser bridge/bridgeD.png");
            blockDeathBridge = (new Node_BlockDBridge(k2, l2)).setHardness(-1F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setBlockName("laserBridgeD");
            Node_TileEntityDBridge.defaultInd = -1;
        }
        int i3 = mod_Node_PackLoader.getID("bootsAccel");
        if(i3 != -1)
        {
            int j3 = ModLoader.AddArmor("accel");
            accelBoots = (new ItemArmor(i3, 2, j3, 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/accel_boots.png")).setItemName("bootsAccel");
        }
    }
}
