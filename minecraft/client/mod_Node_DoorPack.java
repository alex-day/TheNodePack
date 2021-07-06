package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_DoorPack extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_DoorPack()
    {
        if(blockGlassDoor != null)
        {
            ModLoader.RegisterBlock(blockGlassDoor);
            ModLoader.AddName(blockGlassDoor, "Glass Door");
            mod_Node_PackLoader.trace("Sucessfully loaded Glass Door");
        }
        if(blockBrickDoor != null)
        {
            ModLoader.RegisterBlock(blockBrickDoor);
            ModLoader.AddName(blockBrickDoor, "Brick Door");
            mod_Node_PackLoader.trace("Sucessfully loaded Brick Door");
        }
        if(itemGlassDoor != null)
        {
            ModLoader.AddName(itemGlassDoor, "Glass Door");
        }
        if(itemBrickDoor != null)
        {
            ModLoader.AddName(itemBrickDoor, "Brick Door");
        }
		
        if(blockGlassTrapDoor != null) {
        	ModLoader.RegisterBlock(blockGlassTrapDoor);
            ModLoader.AddName(blockGlassTrapDoor, "Glass Trap Door");
            mod_Node_PackLoader.trace("Sucessfully loaded Glass Trap Door");
        }
        
        if(blockDirtTrapDoor != null) {
        	ModLoader.RegisterBlock(blockDirtTrapDoor);
            ModLoader.AddName(blockDirtTrapDoor, "Dirt Trap Door");
            mod_Node_PackLoader.trace("Sucessfully loaded Dirt Trap Door");
        }
        
        if(blockSandTrapDoor != null) {
        	ModLoader.RegisterBlock(blockSandTrapDoor);
            ModLoader.AddName(blockSandTrapDoor, "Sand Trap Door");
            mod_Node_PackLoader.trace("Sucessfully loaded Sand Trap Door");
        }
        
        if(blockSnowTrapDoor != null) {
        	ModLoader.RegisterBlock(blockSnowTrapDoor);
            ModLoader.AddName(blockSnowTrapDoor, "Snow Trap Door");
            mod_Node_PackLoader.trace("Sucessfully loaded Snow Trap Door");
        }
        
		AddRecipes();
    }

    public void AddRecipes()
    {
        if(itemBrickDoor != null)
        {
            ModLoader.AddRecipe(new ItemStack(itemBrickDoor), new Object[] {
                "##", "##", "##", Character.valueOf('#'), Block.brick
            });
        }
        if(itemGlassDoor != null)
        {
            ModLoader.AddRecipe(new ItemStack(itemGlassDoor), new Object[] {
                "##", "##", "##", Character.valueOf('#'), Block.glass
            });
        }
        
        if(blockGlassTrapDoor != null) {
        	ModLoader.AddRecipe(new ItemStack(blockGlassTrapDoor, 2), new Object[] {
                "###", "###", Character.valueOf('#'), Block.glass
            });
        }
        
        if(blockDirtTrapDoor != null) {
        	ModLoader.AddRecipe(new ItemStack(blockDirtTrapDoor, 2), new Object[] {
                "###", "###", Character.valueOf('#'), Block.dirt
            });
        }
        
        if(blockSandTrapDoor != null) {
        	ModLoader.AddRecipe(new ItemStack(blockSandTrapDoor, 2), new Object[] {
                "###", "###", Character.valueOf('#'), Block.sand
            });
        }
        
        if(blockSnowTrapDoor != null) {
        	ModLoader.AddRecipe(new ItemStack(blockSnowTrapDoor, 2), new Object[] {
                "###", "###", Character.valueOf('#'), Block.blockSnow
            });
        }
    }

    public static Block blockBrickDoor = null;
    public static Block blockGlassDoor = null;
    public static Item itemBrickDoor = null;
    public static Item itemGlassDoor = null;
    
    public static Block blockGlassTrapDoor = null;
    public static Block blockDirtTrapDoor = null;
    public static Block blockSnowTrapDoor = null;
    public static Block blockSandTrapDoor = null;

    static 
    {
        int i = ModLoader.addOverride("/terrain.png", "/NodePack/brick_door_top.png");
        int j = ModLoader.addOverride("/terrain.png", "/NodePack/brick_door_bottom.png");
        int k = ModLoader.addOverride("/terrain.png", "/NodePack/glass_door_top.png");
        int l = ModLoader.addOverride("/terrain.png", "/NodePack/glass_door_bottom.png");
        int i1 = mod_Node_PackLoader.getID("doorBrick");
        if(i1 != -1)
        {
            blockBrickDoor = (new Node_BlockDoor(i1, Material.rock, i, j)).setHardness(3F).setStepSound(Block.soundStoneFootstep).setBlockName("doorBrick");
        }
        int j1 = mod_Node_PackLoader.getID("doorGlass");
        if(j1 != -1)
        {
            blockGlassDoor = (new Node_BlockDoor(j1, Material.glass, k, l)).setHardness(1.5F).setStepSound(Block.soundGlassFootstep).setBlockName("doorGlass");
        }
        int k1 = mod_Node_PackLoader.getID("doorGlassItem");
        if(k1 != -1 && j1 != -1)
        {
            itemGlassDoor = (new Node_ItemDoor(k1, Material.glass)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/glass_door.png")).setItemName("doorGlass");
        }
        int l1 = mod_Node_PackLoader.getID("doorBrickItem");
        if(l1 != -1 && i1 != -1)
        {
            itemBrickDoor = (new Node_ItemDoor(l1, Material.rock)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/brick_door.png")).setItemName("doorBrick");
        }
        
        int glassTrap = mod_Node_PackLoader.getID("trapGlass");
        if(glassTrap != -1) {
        	blockGlassTrapDoor = (new Node_BlockTrapDoor(glassTrap, Material.glass)).setHardness(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("trapGlass");
        }
        int dirtTrap = mod_Node_PackLoader.getID("trapDirt");
        if(dirtTrap != -1) {
        	blockDirtTrapDoor = (new Node_BlockTrapDoor(dirtTrap, Material.ground)).setHardness(1.5F).setStepSound(Block.soundGrassFootstep).setBlockName("trapDirt");
        }
        int sandTrap = mod_Node_PackLoader.getID("trapSand");
        if(sandTrap != -1) {
        	blockSandTrapDoor = (new Node_BlockTrapDoor(sandTrap, Material.sand)).setHardness(1.5F).setStepSound(Block.soundGravelFootstep).setBlockName("trapSand");
        }
        int snowTrap = mod_Node_PackLoader.getID("trapSnow");
        if(snowTrap != -1) {
        	blockSnowTrapDoor = (new Node_BlockTrapDoor(snowTrap, Material.snow)).setHardness(1.0F).setStepSound(Block.soundClothFootstep).setBlockName("trapSnow");
        }
    }
}
