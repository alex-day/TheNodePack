package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemPickaxe extends Node_ItemTool
{

    protected Node_ItemPickaxe(int i, Node_EnumToolMaterial enumnewtoolmaterial)
    {
        super(i, 2, enumnewtoolmaterial, field_25036_bi);
    }

    public boolean func_25035_a(Block block)
    {
        if(block == Block.obsidian)
        {
            return field_20927_a.func_21208_d() >= 3;
        }
        if(block == Block.blockDiamond || block == Block.oreDiamond)
        {
            return field_20927_a.func_21208_d() >= 2;
        }
        if(block == Block.blockGold || block == Block.oreGold)
        {
            return field_20927_a.func_21208_d() >= 2;
        }
        if(block == Block.blockSteel || block == Block.oreIron)
        {
            return field_20927_a.func_21208_d() >= 1;
        }
        if(block == Block.oreLapis || block == Block.blockLapis)
        {
            return field_20927_a.func_21208_d() >= 1;
        }
        if(block == Block.oreRedstone || block == Block.oreRedstoneGlowing)
        {
            return field_20927_a.func_21208_d() >= 2;
        }
        if(block.blockMaterial == Material.rock)
        {
            return true;
        } else
        {
            return block.blockMaterial == Material.iron;
        }
    }

    private static Block field_25036_bi[];

    static 
    {
        field_25036_bi = (new Block[] {
            Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, 
            Block.oreDiamond, Block.oreRedstone, Block.oreRedstoneGlowing, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.sandStone, mod_Node_KimberlitePack.oreKimberlite, mod_Node_KimberlitePack.blockKimberlite
        });
    }
}
