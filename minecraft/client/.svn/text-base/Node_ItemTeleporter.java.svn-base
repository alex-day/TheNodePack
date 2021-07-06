package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemTeleporter extends ItemBlock
{

    public Node_ItemTeleporter(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    /*public int getIconIndex(ItemStack itemstack)
    {
        return mod_Node_TeleporterPack.teleporter.getBlockTextureFromSideAndMetadata(2, itemstack.getItemDamage());
    }*/
	
	public int func_27009_a(int i)
    {
        return mod_Node_TeleporterPack.teleporter.getBlockTextureFromSideAndMetadata(2, i);
    }

    public int func_21012_a(int i)
    {
        return i;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return super.getItemName()+"."+colours[itemstack.getItemDamage()];
    }
	
	public static final String colours[] = {
        "empty", "red", "blue", "green", "purple", "yellow", "white", "tainted"
    };
}
