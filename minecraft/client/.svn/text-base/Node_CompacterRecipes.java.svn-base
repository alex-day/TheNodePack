package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.HashMap;
import java.util.Map;

public class Node_CompacterRecipes
{

    public static final Node_CompacterRecipes func_25218_func_21200_a()
    {
        return field_25220_field_21202_a;
    }

    private Node_CompacterRecipes()
    {
        field_25221_field_21201_b = new HashMap();
        func_25219_func_21199_a(mod_Node_KimberlitePack.blockKimberlite.blockID, new ItemStack(mod_Node_KimberlitePack.oreKimberlite));
        func_25219_func_21199_a(Block.gravel.blockID, new ItemStack(Item.flint));
    }

    public void func_25219_func_21199_a(int i, ItemStack itemstack)
    {
        field_25221_field_21201_b.put(Integer.valueOf(i), itemstack);
    }

    public ItemStack func_25217_func_21198_a(int i)
    {
        return (ItemStack)field_25221_field_21201_b.get(Integer.valueOf(i));
    }

    public static final Node_CompacterRecipes field_25220_field_21202_a = new Node_CompacterRecipes();
    private Map field_25221_field_21201_b;

}
