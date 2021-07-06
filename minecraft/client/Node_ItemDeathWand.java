package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.List;

public class Node_ItemDeathWand extends Item
{

    protected Node_ItemDeathWand(int i, int j, int k)
    {
        super(i);
        setMaxDamage(k);
        maxStackSize = 1;
        radius = j;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(func_25025_V(world, entityplayer))
        {
            entityplayer.swingItem();
            itemstack.damageItem(1, null);
        }
        return itemstack;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public boolean func_25025_V(World world, EntityPlayer entityplayer)
    {
        boolean flag = false;
        int i = MathHelper.floor_double(entityplayer.posX - (double)radius - 1.0D);
        int j = MathHelper.floor_double(entityplayer.posX + (double)radius + 1.0D);
        int k = MathHelper.floor_double(entityplayer.posY - (double)radius - 1.0D);
        int l = MathHelper.floor_double(entityplayer.posY + (double)radius + 1.0D);
        int i1 = MathHelper.floor_double(entityplayer.posZ - (double)radius - 1.0D);
        int j1 = MathHelper.floor_double(entityplayer.posZ + (double)radius + 1.0D);
        List list = world.getEntitiesWithinAABBExcludingEntity(entityplayer, AxisAlignedBB.getBoundingBoxFromPool(i, k, i1, j, l, j1));
        for(int k1 = 0; k1 < list.size(); k1++)
        {
            Entity entity = (Entity)list.get(k1);
			if(entity instanceof EntityLiving) {
				entity.attackEntityFrom(entityplayer, 20);
			}
            flag = true;
        }

        return flag;
    }

    int radius;
}
