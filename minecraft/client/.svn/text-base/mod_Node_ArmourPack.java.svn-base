package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class mod_Node_ArmourPack extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_ArmourPack()
    {
        if(bootsNether != null)
        {
            ModLoader.AddName(helmetNether, "Nether Helmet");
        }
        if(plateNether != null)
        {
            ModLoader.AddName(plateNether, "Nether Plate");
        }
        if(legsNether != null)
        {
            ModLoader.AddName(legsNether, "Nether Pants");
        }
        if(bootsNether != null)
        {
            ModLoader.AddName(bootsNether, "Nether Boots");
        }
        if(helmetObsidian != null)
        {
            ModLoader.AddName(helmetObsidian, "Obsidian Helmet");
        }
        if(plateObsidian != null)
        {
            ModLoader.AddName(plateObsidian, "Obsidian Plate");
        }
        if(legsObsidian != null)
        {
            ModLoader.AddName(legsObsidian, "Obsidian Pants");
        }
        if(bootsObsidian != null)
        {
            ModLoader.AddName(bootsObsidian, "Obsidian Boots");
        }
        if(itemMesh != null)
        {
            ModLoader.AddName(itemMesh, "Iron Mesh");
        }
        recipeItems = (new Object[][] {
            new Object[] {
                mod_Node_ToolPack.netherIngot, mod_Node_ToolPack.obsidianIngot, itemMesh
            }, new Object[] {
                helmetNether, helmetObsidian, Item.helmetChain
            }, new Object[] {
                plateNether, plateObsidian, Item.plateChain
            }, new Object[] {
                legsNether, legsObsidian, Item.legsChain
            }, new Object[] {
                bootsNether, bootsObsidian, Item.bootsChain
            }
        });
		
		AddRecipes();
    }

    public void AddRecipes()
    {
        for(int i = 0; i < recipeItems[0].length; i++)
        {
            Object obj = recipeItems[0][i];
            for(int j = 0; j < recipeItems.length - 1; j++)
            {
                Item item = (Item)recipeItems[j + 1][i];
                if(obj != null && item != null)
                {
                    ModLoader.AddRecipe(new ItemStack(item), new Object[] {
                        recipePatterns[j], Character.valueOf('X'), obj
                    });
                }
            }

        }

        if(itemMesh != null)
        {
            ModLoader.AddRecipe(new ItemStack(itemMesh, 2), new Object[] {
                "X X", " X ", "X X", Character.valueOf('X'), Item.ingotIron
            });
        }
    }

    public static Item helmetNether = null;
    public static Item plateNether = null;
    public static Item legsNether = null;
    public static Item bootsNether = null;
    public static Item helmetObsidian = null;
    public static Item plateObsidian = null;
    public static Item legsObsidian = null;
    public static Item bootsObsidian = null;
    public static Item itemMesh;
    private String recipePatterns[][] = {
        {
            "XXX", "X X"
        }, {
            "X X", "XXX", "XXX"
        }, {
            "XXX", "X X", "X X"
        }, {
            "X X", "X X"
        }
    };
    private Object recipeItems[][];

    static 
    {
        int i = ModLoader.AddArmor("nether");
        int j = ModLoader.AddArmor("obsidian");
        int k = mod_Node_PackLoader.getID("helmetNether");
        if(k != -1)
        {
            helmetNether = (new ItemArmor(k, 2, i, 0)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/nether_helmet.png")).setItemName("helmetNether");
        }
        int l = mod_Node_PackLoader.getID("plateNether");
        if(l != -1)
        {
            plateNether = (new ItemArmor(l, 2, i, 1)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/nether_plate.png")).setItemName("chestplateNether");
        }
        int i1 = mod_Node_PackLoader.getID("legsNether");
        if(i1 != -1)
        {
            legsNether = (new ItemArmor(i1, 2, i, 2)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/nether_legs.png")).setItemName("leggingsNether");
        }
        int j1 = mod_Node_PackLoader.getID("bootsNether");
        if(j1 != -1)
        {
            bootsNether = (new ItemArmor(j1, 2, i, 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/nether_boots.png")).setItemName("bootsNether");
        }
        int k1 = mod_Node_PackLoader.getID("helmetObsidian");
        if(k1 != -1)
        {
            helmetObsidian = (new ItemArmor(k1, 3, j, 0)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/obsidian_helmet.png")).setItemName("helmetObsidian");
        }
        int l1 = mod_Node_PackLoader.getID("plateObsidian");
        if(l1 != -1)
        {
            plateObsidian = (new ItemArmor(l1, 3, j, 1)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/obsidian_plate.png")).setItemName("chestplateObsidian");
        }
        int i2 = mod_Node_PackLoader.getID("legsObsidian");
        if(i2 != -1)
        {
            legsObsidian = (new ItemArmor(i2, 3, j, 2)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/obsidian_legs.png")).setItemName("leggingsObsidian");
        }
        int j2 = mod_Node_PackLoader.getID("bootsObsidian");
        if(j2 != -1)
        {
            bootsObsidian = (new ItemArmor(j2, 3, j, 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/armour/obsidian_boots.png")).setItemName("bootsObsidian");
        }
        int k2 = mod_Node_PackLoader.getID("mesh");
        if(k2 != -1)
        {
            itemMesh = (new Item(k2)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/mesh.png")).setItemName("mesh");
        }
    }
}
