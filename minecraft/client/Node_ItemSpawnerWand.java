package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemSpawnerWand extends Item
{

    protected Node_ItemSpawnerWand(int i, String s, int j)
    {
        super(i);
        field_25004_type = s;
        setMaxDamage(j);
        maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        j++;
        if(!Block.mobSpawner.canPlaceBlockAt(world, i, j, k))
        {
            return false;
        } else
        {
            world.setBlockWithNotify(i, j, k, Block.mobSpawner.blockID);
            TileEntityMobSpawner mobSpawner = (TileEntityMobSpawner)world.getBlockTileEntity(i, j, k);
            mobSpawner.setMobID(field_25004_type);
            itemstack.damageItem(1, null);
            return true;
        }
    }

    public boolean isFull3D()
    {
        return true;
    }

    private String field_25004_type;
    private int field_25003_a;
}
