package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Map;

public class mod_Node_Crossbow extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_Crossbow()
    {
        if(itemBolt != null)
        {
            ModLoader.AddName(itemBolt, "Bolt");
        }
        if(itemCrossBow != null)
        {
            ModLoader.AddName(itemCrossBow, "Crossbow");
        }
		AddRecipes();
    }

    public void AddRecipes()
    {
        if(itemBolt != null)
        {
            ModLoader.AddRecipe(new ItemStack(itemBolt, 4), new Object[] {
                "X", "Y", "Z", Character.valueOf('X'), Item.ingotIron, Character.valueOf('Y'), Item.bone, Character.valueOf('Z'), Item.feather
            });
        }
        if(itemCrossBow != null)
        {
            ModLoader.AddRecipe(new ItemStack(itemCrossBow), new Object[] {
                "XYX", "OXO", "OXO", Character.valueOf('X'), Item.stick, Character.valueOf('O'), Item.silk, Character.valueOf('Y'), Item.ingotIron
            });
        }
    }

    public void AddRenderer(Map map)
    {
        if(itemBolt != null)
        {
            map.put(Node_EntityBolt.class, new Node_RenderBolt());
        }
    }

    public static Item itemBolt = null;
    public static Item itemCrossBow = null;

    static 
    {
        int i = mod_Node_PackLoader.getID("bolt");
        if(i != -1)
        {
            itemBolt = (new Item(i)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/weapons/bolt.png")).setItemName("bolt");
        }
        int j = mod_Node_PackLoader.getID("crossbow");
        if(j != -1)
        {
            itemCrossBow = (new Node_ItemCrossBow(j)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/weapons/crossbow.png")).setItemName("crossBow");
        }
    }
}
