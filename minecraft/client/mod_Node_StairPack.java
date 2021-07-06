package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_StairPack extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_StairPack()
    {
        if(blockDirtStairs != null)
        {
            ModLoader.RegisterBlock(blockDirtStairs);
            ModLoader.AddName(blockDirtStairs, "Dirt Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded dirt stairs");
        }
        if(blockStoneStairs != null)
        {
            ModLoader.RegisterBlock(blockStoneStairs);
            ModLoader.AddName(blockStoneStairs, "Stone Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded stone stairs");
        }
        if(blockSnowStairs != null)
        {
            ModLoader.RegisterBlock(blockSnowStairs);
            ModLoader.AddName(blockSnowStairs, "Snow Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded snow stairs");
        }
        if(blockGlassStairs != null)
        {
            ModLoader.RegisterBlock(blockGlassStairs);
            ModLoader.AddName(blockGlassStairs, "Glass Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded glass stairs");
        }
        if(blockIronStairs != null)
        {
            ModLoader.RegisterBlock(blockIronStairs);
            ModLoader.AddName(blockIronStairs, "Iron Block Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded iron block stairs");
        }
        if(blockGoldStairs != null)
        {
            ModLoader.RegisterBlock(blockGoldStairs);
            ModLoader.AddName(blockGoldStairs, "Gold Block Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded gold block stairs");
        }
        if(blockDiamondStairs != null)
        {
            ModLoader.RegisterBlock(blockDiamondStairs);
            ModLoader.AddName(blockDiamondStairs, "Diamond Block Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded diamond block stairs");
        }
        if(blockNetherrackStairs != null)
        {
            ModLoader.RegisterBlock(blockNetherrackStairs);
            ModLoader.AddName(blockNetherrackStairs, "Netherrack Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded netherrack stairs");
        }
        if(blockBrickStairs != null)
        {
            ModLoader.RegisterBlock(blockBrickStairs);
            ModLoader.AddName(blockBrickStairs, "Brick Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded brick stairs");
        }
		
		AddRecipes();
    }

    public void AddRecipes()
    {
        if(blockDirtStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockDirtStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.dirt
            });
        }
        if(blockStoneStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockStoneStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.stone
            });
        }
        if(blockSnowStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockSnowStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.blockSnow
            });
        }
        if(blockGlassStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockGlassStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.glass
            });
        }
        if(blockIronStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockIronStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.blockSteel
            });
        }
        if(blockGoldStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockGoldStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.blockGold
            });
        }
        if(blockDiamondStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockDiamondStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.blockDiamond
            });
        }
        if(blockNetherrackStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockNetherrackStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.netherrack
            });
        }
        if(blockBrickStairs != null)
        {
            ModLoader.AddRecipe(new ItemStack(blockBrickStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.brick
            });
        }
    }

    public static Block blockDirtStairs = null;
    public static Block blockStoneStairs = null;
    public static Block blockSnowStairs = null;
    public static Block blockGlassStairs = null;
    public static Block blockIronStairs = null;
    public static Block blockGoldStairs = null;
    public static Block blockDiamondStairs = null;
    public static Block blockNetherrackStairs = null;
    public static Block blockBrickStairs = null;

    static 
    {
        int i = mod_Node_PackLoader.getID("stairsCompactDirt");
        if(i != -1)
        {
            blockDirtStairs = (new BlockStairs(i, Block.dirt)).setBlockName("Dirt Stairs");
        }
        int j = mod_Node_PackLoader.getID("stairsCompactStone");
        if(j != -1)
        {
            blockStoneStairs = (new BlockStairs(j, Block.stone)).setBlockName("Plain Stone Stairs");
        }
        int k = mod_Node_PackLoader.getID("stairsCompactBlockSnow");
        if(k != -1)
        {
            blockSnowStairs = (new BlockStairs(k, Block.blockSnow)).setBlockName("Snow Stairs");
        }
        int l = mod_Node_PackLoader.getID("stairsCompactGlass");
        if(l != -1)
        {
            blockGlassStairs = (new BlockStairs(l, Block.glass)).setBlockName("Glass Stairs");
        }
        int i1 = mod_Node_PackLoader.getID("stairsCompactBlockSteel");
        if(i1 != -1)
        {
            blockIronStairs = (new BlockStairs(i1, Block.blockSteel)).setBlockName("Iron Stairs");
        }
        int j1 = mod_Node_PackLoader.getID("stairsCompactBlockGold");
        if(j1 != -1)
        {
            blockGoldStairs = (new BlockStairs(j1, Block.blockGold)).setBlockName("Gold Stairs");
        }
        int k1 = mod_Node_PackLoader.getID("stairsCompactBlockDiamond");
        if(k1 != -1)
        {
            blockDiamondStairs = (new BlockStairs(k1, Block.blockDiamond)).setBlockName("Diamond Stairs");
        }
        int l1 = mod_Node_PackLoader.getID("stairsCompactNetherrack");
        if(l1 != -1)
        {
            blockNetherrackStairs = (new BlockStairs(l1, Block.netherrack)).setBlockName("Netherrack Stairs");
        }
        int i2 = mod_Node_PackLoader.getID("stairsCompactBrick");
        if(i2 != -1)
        {
            blockBrickStairs = (new BlockStairs(i2, Block.brick)).setBlockName("Brick Stairs");
        }
    }
}
