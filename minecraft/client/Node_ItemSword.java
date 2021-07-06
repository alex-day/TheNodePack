package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemSword extends Item
{

    public Node_ItemSword(int i, Node_EnumToolMaterial enumnewtoolmaterial)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(enumnewtoolmaterial.func_21207_a());
        field_25039_dmg = 4 + enumnewtoolmaterial.func_21205_c() * 2;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return 1.5F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(1, entityliving1);
        return true;
    }

    public boolean func_25008_a(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(2, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return field_25039_dmg;
    }

    public boolean isFull3D()
    {
        return true;
    }

    private int field_25039_dmg;
}
