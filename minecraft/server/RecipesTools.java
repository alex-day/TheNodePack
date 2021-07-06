// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Item, ItemStack, CraftingManager

public class RecipesTools
{

    public RecipesTools()
    {
        recipeItems = (new Object[][] {
            new Object[] {
                Block.planks, Block.cobblestone, Item.ingotIron, Item.diamond, Item.ingotGold, Item.ingotNether, Item.ingotObsidian
            }, new Object[] {
                Item.pickaxeWood, Item.pickaxeStone, Item.pickaxeSteel, Item.pickaxeDiamond, Item.pickaxeGold, Item.netherPick, Item.obsidianPick
            }, new Object[] {
                Item.shovelWood, Item.shovelStone, Item.shovelSteel, Item.shovelDiamond, Item.shovelGold, Item.netherShovel, Item.obsidianShovel
            }, new Object[] {
                Item.axeWood, Item.axeStone, Item.axeSteel, Item.axeDiamond, Item.axeGold, Item.netherAxe, Item.obsidianAxe
            }, new Object[] {
                Item.hoeWood, Item.hoeStone, Item.hoeSteel, Item.hoeDiamond, Item.hoeGold, Item.netherHoe, Item.obsidianHoe
            }
        });
    }

    public void addRecipes(CraftingManager craftingmanager)
    {
        for(int i = 0; i < recipeItems[0].length; i++)
        {
            Object obj = recipeItems[0][i];
            for(int j = 0; j < recipeItems.length - 1; j++)
            {
                Item item = (Item)recipeItems[j + 1][i];
                craftingmanager.addRecipe(new ItemStack(item), new Object[] {
                    recipePatterns[j], Character.valueOf('#'), Item.stick, Character.valueOf('X'), obj
                });
            }

        }

    }

    private String recipePatterns[][] = {
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
    private Object recipeItems[][];
}
