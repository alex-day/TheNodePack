package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemTimeWand extends Item
{

    protected Node_ItemTimeWand(int i, int j)
    {
        super(i);
        setMaxDamage(j);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        func_25005_a(world);
        entityplayer.swingItem();
        itemstack.damageItem(1, null);
        return itemstack;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public void func_25005_a(World world)
    {
        long l = world.getWorldTime();
        l += 12000L;
        world.setWorldTime(l);
    }
}
