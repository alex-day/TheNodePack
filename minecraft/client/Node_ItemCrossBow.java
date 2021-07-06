package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_ItemCrossBow extends Item
{

    public Node_ItemCrossBow(int i)
    {
        super(i);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.inventory.consumeInventoryItem(mod_Node_Crossbow.itemBolt.shiftedIndex))
        {
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!world.multiplayerWorld)
            {
                world.entityJoinedWorld(new Node_EntityBolt(world, entityplayer));
            }
        }
        return itemstack;
    }
}
