package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_ToolPack extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_ToolPack()
    {
        if(netherBlock != null)
        {
            ModLoader.RegisterBlock(netherBlock);
            ModLoader.AddName(netherBlock, "Nether Block");
            mod_Node_PackLoader.trace("Sucessfully loaded Nether Block");
        }
        if(obsidianBlock != null)
        {
            ModLoader.RegisterBlock(obsidianBlock);
            ModLoader.AddName(obsidianBlock, "Obsidian Block");
            mod_Node_PackLoader.trace("Sucessfully loaded Obsidian Block");
        }
        if(netherIngot != null)
        {
            ModLoader.AddName(netherIngot, "Nether Ingot");
            Node_CompacterRecipes.field_25220_field_21202_a.func_25219_func_21199_a(Block.netherrack.blockID, new ItemStack(netherIngot));
        }
        if(netherAxe != null)
        {
            ModLoader.AddName(netherAxe, "Nether Axe");
        }
        if(netherHoe != null)
        {
            ModLoader.AddName(netherHoe, "Nether Hoe");
        }
        if(netherPick != null)
        {
            ModLoader.AddName(netherPick, "Nether Pickaxe");
        }
        if(netherShovel != null)
        {
            ModLoader.AddName(netherShovel, "Nether Shovel");
        }
        if(netherSword != null)
        {
            ModLoader.AddName(netherSword, "Nether Sword");
        }
        if(obsidianIngot != null)
        {
            ModLoader.AddName(obsidianIngot, "Obsidian Ingot");
            Node_CompacterRecipes.field_25220_field_21202_a.func_25219_func_21199_a(Block.obsidian.blockID, new ItemStack(obsidianIngot));
        }
        if(obsidianAxe != null)
        {
            ModLoader.AddName(obsidianAxe, "Obsidian Axe");
        }
        if(obsidianHoe != null)
        {
            ModLoader.AddName(obsidianHoe, "Obsidian Hoe");
        }
        if(obsidianPick != null)
        {
            ModLoader.AddName(obsidianPick, "Obsidian Pickaxe");
        }
        if(obsidianShovel != null)
        {
            ModLoader.AddName(obsidianShovel, "Obsidian Shovel");
        }
        if(obsidianSword != null)
        {
            ModLoader.AddName(obsidianSword, "Obsidian Sword");
        }
        if(netherBlockStairs != null)
        {
            ModLoader.RegisterBlock(netherBlockStairs);
            ModLoader.AddName(netherBlockStairs, "Nether Block Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded nether block stairs");
        }
        if(obsidianBlockStairs != null)
        {
            ModLoader.RegisterBlock(obsidianBlockStairs);
            ModLoader.AddName(obsidianBlockStairs, "Obsidian Block Stairs");
            mod_Node_PackLoader.trace("Sucessfully loaded obsidian block stairs");
        }
        recipeTools = (new Object[][] {
            new Object[] {
                netherIngot, obsidianIngot
            }, new Object[] {
                netherPick, obsidianPick
            }, new Object[] {
                netherShovel, obsidianShovel
            }, new Object[] {
                netherAxe, obsidianAxe
            }, new Object[] {
                netherHoe, obsidianHoe
            }
        });
        recipeWeapons = (new Object[][] {
            new Object[] {
                netherIngot, obsidianIngot
            }, new Object[] {
                netherSword, obsidianSword
            }
        });
        ingotRecipes = (new Object[][] {
            new Object[] {
                netherBlock, netherIngot
            }, new Object[] {
                obsidianBlock, obsidianIngot
            }
        });
		
		AddRecipes();
    }

    public void AddRecipes()
    {
        for(int i = 0; i < recipeTools[0].length; i++)
        {
            Object obj = recipeTools[0][i];
            for(int l = 0; l < recipeTools.length - 1; l++)
            {
                Item item = (Item)recipeTools[l + 1][i];
                if(obj != null && item != null)
                {
                    ModLoader.AddRecipe(new ItemStack(item), new Object[] {
                        field_25140_g[l], Character.valueOf('#'), Item.stick, Character.valueOf('X'), obj
                    });
                }
            }

        }

        for(int j = 0; j < recipeWeapons[0].length; j++)
        {
            Object obj1 = recipeWeapons[0][j];
            for(int i1 = 0; i1 < recipeWeapons.length - 1; i1++)
            {
                Item item1 = (Item)recipeWeapons[i1 + 1][j];
                if(obj1 != null && item1 != null)
                {
                    ModLoader.AddRecipe(new ItemStack(item1), new Object[] {
                        field_25148_H[i1], Character.valueOf('#'), Item.stick, Character.valueOf('X'), obj1
                    });
                }
            }

        }

        for(int k = 0; k < ingotRecipes.length; k++)
        {
            Block block = (Block)ingotRecipes[k][0];
            if(ingotRecipes[k][1] != null && block != null)
            {
                ItemStack itemstack = new ItemStack((Item)ingotRecipes[k][1], 9);
                ModLoader.AddRecipe(new ItemStack(block), new Object[] {
                    "###", "###", "###", Character.valueOf('#'), itemstack
                });
                ModLoader.AddRecipe(itemstack, new Object[] {
                    "#", Character.valueOf('#'), block
                });
            }
        }

        if(netherBlockStairs != null && netherBlock != null)
        {
            ModLoader.AddRecipe(new ItemStack(netherBlockStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), netherBlock
            });
        }
        if(obsidianBlockStairs != null && obsidianBlock != null)
        {
            ModLoader.AddRecipe(new ItemStack(obsidianBlockStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), obsidianBlock
            });
        }
    }

    public static Item netherIngot = null;
    public static Item netherAxe = null;
    public static Item netherHoe = null;
    public static Item netherPick = null;
    public static Item netherShovel = null;
    public static Item netherSword = null;
    public static Item obsidianIngot = null;
    public static Item obsidianAxe = null;
    public static Item obsidianHoe = null;
    public static Item obsidianPick = null;
    public static Item obsidianShovel = null;
    public static Item obsidianSword = null;
    public static Block netherBlock;
    public static Block obsidianBlock;
    public static Block netherBlockStairs = null;
    public static Block obsidianBlockStairs = null;
    private Object recipeTools[][];
    private Object recipeWeapons[][];
    private Object ingotRecipes[][];
    private String field_25140_g[][] = {
        {
            "XXX", " # ", " # "
        }, {
            "X", "#", "#"
        }, {
            "XX", "X#", " #"
        }, {
            "XX", " #", " #"
        }
    };
    private String field_25148_H[][] = {
        {
            "X", "X", "#"
        }
    };

    static 
    {
        Node_ItemTool.field_25030_az1 = EnumToolMaterial.WOOD;
        netherBlock = null;
        obsidianBlock = null;
        int i = mod_Node_PackLoader.getID("netherIngot");
        if(i != -1)
        {
            netherIngot = (new Item(i)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/NetherIngot.png")).setItemName("netherIngot");
        }
        int j = mod_Node_PackLoader.getID("axeNether");
        if(j != -1)
        {
            netherAxe = (new Node_ItemAxe(j, Node_EnumToolMaterial.NETHER)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/tools/NetherAxe.png")).setItemName("axeNether");
        }
        int k = mod_Node_PackLoader.getID("hoeNether");
        if(k != -1)
        {
            netherHoe = (new Node_ItemHoe(k, Node_EnumToolMaterial.NETHER)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/tools/NetherHoe.png")).setItemName("hoeNether");
        }
        int l = mod_Node_PackLoader.getID("pickNether");
        if(l != -1)
        {
            netherPick = (new Node_ItemPickaxe(l, Node_EnumToolMaterial.NETHER)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/tools/NetherPick.png")).setItemName("pickNether");
        }
        int i1 = mod_Node_PackLoader.getID("shovelNether");
        if(i1 != -1)
        {
            netherShovel = (new Node_ItemSpade(i1, Node_EnumToolMaterial.NETHER)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/tools/NetherShovel.png")).setItemName("shovelNether");
        }
        int j1 = mod_Node_PackLoader.getID("swordNether");
        if(j1 != -1)
        {
            netherSword = (new Node_ItemSword(j1, Node_EnumToolMaterial.NETHER)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/weapons/NetherSword.png")).setItemName("swordNether");
        }
        int k1 = mod_Node_PackLoader.getID("obsidianIngot");
        if(k1 != -1)
        {
            obsidianIngot = (new Item(k1)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/ObsidianIngot.png")).setItemName("obsidianIngot");
        }
        int l1 = mod_Node_PackLoader.getID("axeObsidian");
        if(l1 != -1)
        {
            obsidianAxe = (new Node_ItemAxe(l1, Node_EnumToolMaterial.OBSIDIAN)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/tools/ObsidianAxe.png")).setItemName("axeObsidian");
        }
        int i2 = mod_Node_PackLoader.getID("hoeObsidian");
        if(i2 != -1)
        {
            obsidianHoe = (new Node_ItemHoe(i2, Node_EnumToolMaterial.OBSIDIAN)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/tools/ObsidianHoe.png")).setItemName("hoeObsidian");
        }
        int j2 = mod_Node_PackLoader.getID("pickObsidian");
        if(j2 != -1)
        {
            obsidianPick = (new Node_ItemPickaxe(j2, Node_EnumToolMaterial.OBSIDIAN)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/tools/ObsidianPick.png")).setItemName("pickObsidian");
        }
        int k2 = mod_Node_PackLoader.getID("shovelObsidian");
        if(k2 != -1)
        {
            obsidianShovel = (new Node_ItemSpade(k2, Node_EnumToolMaterial.OBSIDIAN)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/tools/ObsidianShovel.png")).setItemName("shovelObsidian");
        }
        int l2 = mod_Node_PackLoader.getID("swordObsidian");
        if(l2 != -1)
        {
            obsidianSword = (new Node_ItemSword(l2, Node_EnumToolMaterial.OBSIDIAN)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/weapons/ObsidianSword.png")).setItemName("swordObsidian");
        }
        int i3 = mod_Node_PackLoader.getID("netherBlock");
        if(i3 != -1)
        {
            netherBlock = (new BlockOreStorage(i3, ModLoader.addOverride("/terrain.png", "/NodePack/nether_block.png"))).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setBlockName("netherBlock");
        }
        int j3 = mod_Node_PackLoader.getID("obsidianBlock");
        if(j3 != -1)
        {
            obsidianBlock = (new BlockOreStorage(j3, ModLoader.addOverride("/terrain.png", "/NodePack/obsidian_block.png"))).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setBlockName("obsidianBlock");
        }
        int k3 = mod_Node_PackLoader.getID("stairsCompactBlockNether");
        if(k3 != -1)
        {
            netherBlockStairs = (new BlockStairs(k3, netherBlock)).setBlockName("Nether Stairs");
        }
        int l3 = mod_Node_PackLoader.getID("stairsCompactBlockObsidian");
        if(l3 != -1)
        {
            obsidianBlockStairs = (new BlockStairs(l3, obsidianBlock)).setBlockName("Obsidian Stairs");
        }
    }
}
