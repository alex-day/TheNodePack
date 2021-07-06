package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemHealWand extends Item
{

    protected Node_ItemHealWand(int i, int j, int k)
    {
        super(i);
        field_25038_heal = j;
        setMaxDamage(k);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.health < 20)
        {
            entityplayer.swingItem();
            entityplayer.heal(field_25038_heal);

			for(int j = 0; j < 20; j++)
			{
				double d3 = world.rand.nextGaussian() * 0.02D;
				double d4 = world.rand.nextGaussian() * 0.02D;
				double d5 = world.rand.nextGaussian() * 0.02D;
				world.spawnParticle("heart", entityplayer.posX + (double)(world.rand.nextFloat() * entityplayer.width), entityplayer.posY + (double)(world.rand.nextFloat() * entityplayer.height), entityplayer.posZ + (double)(world.rand.nextFloat() * entityplayer.width),d3,d4,d5);
			}
				
            itemstack.damageItem(1, null);
        }
        return itemstack;
    }

    public boolean isFull3D()
    {
        return true;
    }

    private int field_25038_heal;
    private int field_25037_uses;
}
