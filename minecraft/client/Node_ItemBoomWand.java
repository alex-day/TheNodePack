package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemBoomWand extends Item
{

    protected Node_ItemBoomWand(int i, float f, int j)
    {
        super(i);
        setMaxDamage(j);
        maxStackSize = 1;
        field_25017_bj = f;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        func_25016_i(world, entityplayer);
        entityplayer.swingItem();
        itemstack.damageItem(1, null);
        return itemstack;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public void func_25016_i(World world, EntityPlayer entityplayer)
    {
        world.createExplosion(entityplayer, entityplayer.posX, entityplayer.posY, entityplayer.posZ, field_25017_bj);
    }

    float field_25017_bj;
}
