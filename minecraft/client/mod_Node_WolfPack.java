package net.minecraft.src;

import java.io.*;
import java.util.*;
import net.minecraft.client.Minecraft;

public class mod_Node_WolfPack extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }
	
    public mod_Node_WolfPack()
    {
		ModLoader.AddName(shaker, "Empty Shaker");
		ModLoader.AddName(shakerHerbs, "Mixed Herbs Shaker");
		ModLoader.AddName(herbs, "Mixed Herbs");
		ModLoader.AddName(porkSpiced, "Spiced Pork");
		ModLoader.AddName(porkMarinated, "Marinated Pork");
		ModLoader.AddName(wolfTotem, "Wolf Totem");
		
		AddRecipes();
		
		ModLoader.AddSmelting(porkSpiced.shiftedIndex, new ItemStack(porkMarinated));
    }
	
	
	
    public void AddRecipes()
    {
        ModLoader.AddRecipe(new ItemStack(wolfTotem), new Object[] {
            "#", "X", "X", Character.valueOf('#'), porkSpiced,
			Character.valueOf('X'), Item.stick
        });
		
		ModLoader.AddRecipe(new ItemStack(shaker), new Object[] {
            "Y","Y", Character.valueOf('Y'), Block.glass
        });
		
		ModLoader.AddShapelessRecipe(new ItemStack(shakerHerbs), new Object[] {
			new ItemStack(shaker), new ItemStack(herbs),
		});
		
		ModLoader.AddShapelessRecipe(new ItemStack(herbs, 4), new Object[] {
			new ItemStack(Item.seeds), new ItemStack(Block.plantYellow),
			new ItemStack(Block.plantRed)
		});
		
		ModLoader.AddShapelessRecipe(new ItemStack(porkSpiced), new Object[] {
			new ItemStack(shakerHerbs), new ItemStack(Item.porkRaw)
		});
			
    }
	
	public static Item shaker = (new Item(mod_Node_PackLoader.getID("shaker"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wolf/shaker.png")).setItemName("shaker").setMaxStackSize(1);
	public static Item shakerHerbs = (new Item(mod_Node_PackLoader.getID("shakerHerbs"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wolf/shakerHerbs.png")).setItemName("shakerHerbs").setMaxStackSize(1).setContainerItem(shaker);
	public static Item herbs = (new Item(mod_Node_PackLoader.getID("herbs"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wolf/herbs.png")).setItemName("herbs");
	public static Item porkSpiced = (new ItemFood(mod_Node_PackLoader.getID("porkSpiced"),5,true)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wolf/porkSpiced.png")).setItemName("porkSpiced");
	public static Item porkMarinated = (new ItemFood(mod_Node_PackLoader.getID("porkMarinated"),12,true)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wolf/porkMarinated.png")).setItemName("porkMarinated");
	public static Item wolfTotem = (new Node_ItemTotem(mod_Node_PackLoader.getID("wolfTotem"),1)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wolf/wolfTotem.png")).setItemName("wolfTotem");
	
}
