package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemRepairWand extends Item
{

    protected Node_ItemRepairWand(int i, double d, int j, int k)
    {
        super(i);
        repairAmount = d;
        setMaxDamage(j);
        maxStackSize = 1;
        field_25015_e = k;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(field_25015_e == 1)
        {
            if(repairArmour(entityplayer.inventory.armorInventory))
            {
                entityplayer.swingItem();
                itemstack.damageItem(1, null);
            }
        } else
        if(repairItems(entityplayer.inventory))
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

    public boolean repairArmour(ItemStack aitemstack[])
    {
        boolean flag = false;
        for(int i = 0; i < aitemstack.length; i++)
        {
            if(aitemstack[i] == null || !(aitemstack[i].getItem() instanceof ItemArmor) || aitemstack[i].getItemDamage() == 0)
            {
                continue;
            }
            int j = (int)((double)aitemstack[i].getMaxDamage() * repairAmount);
            mod_Node_PackLoader.trace("armour max damage: "+aitemstack[i].getMaxDamage());
			mod_Node_PackLoader.trace("armour damage: "+aitemstack[i].getItemDamage());
            if(j > aitemstack[i].getItemDamage())
            {
                j = aitemstack[i].getItemDamage();
            }
            mod_Node_PackLoader.trace((new StringBuilder()).append("armour amt: ").append(j).toString());
            aitemstack[i].damageItem(-j,null);
            flag = true;
        }

        return flag;
    }

    public boolean repairItems(InventoryPlayer inventoryplayer)
    {
        boolean flag = false;
        for(int i = 0; i < 9; i++)
        {
            ItemStack itemstack = inventoryplayer.getStackInSlot(i);
            if(itemstack == null || !itemstack.isItemStackDamageable() ||
				(itemstack.getItem() instanceof Node_ItemRepairWand) || (itemstack.getItem() instanceof Node_ItemSpawnerWand) ||
				(itemstack.getItem() instanceof Node_ItemFireWand) || (itemstack.getItem() instanceof Node_ItemHealWand) ||
				(itemstack.getItem() instanceof Node_ItemIceWand) || (itemstack.getItem() instanceof Node_ItemEarthWand) ||
				(itemstack.getItem() instanceof Node_ItemTimeWand) || (itemstack.getItem() instanceof Node_ItemDeathWand) ||
				(itemstack.getItem() instanceof Node_ItemBoomWand) || (itemstack.getItem() instanceof Node_ItemPolymorphWand) ||
				(itemstack.getItem() instanceof Node_ItemHomeWand) || itemstack.getItemDamage() == 0)
            {
                continue;
            }
            int j = (int)((double)itemstack.getMaxDamage() * repairAmount);
            mod_Node_PackLoader.trace((new StringBuilder()).append("item damage: ").append(itemstack.getItemDamage()).toString());
            mod_Node_PackLoader.trace((new StringBuilder()).append("item max damage: ").append(itemstack.getMaxDamage()).toString());
            if(j > itemstack.getItemDamage())
            {
                j = itemstack.getItemDamage();
            }
            mod_Node_PackLoader.trace((new StringBuilder()).append("item amt: ").append(j).toString());
            itemstack.damageItem(-j,null);
            flag = true;
        }

        return flag;
    }

    private double repairAmount;
    private int field_25015_e;
    private int field_25013_bi;
}
