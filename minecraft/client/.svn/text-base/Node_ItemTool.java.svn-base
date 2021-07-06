package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemTool extends ItemTool
{

    protected Node_ItemTool(int i, int j, Node_EnumToolMaterial enumnewtoolmaterial, Block ablock[])
    {
        super(i, j, field_25030_az1, ablock);
        efficiencyOnProperMaterial = 4F;
        field_20927_a = enumnewtoolmaterial;
        field_25029_bi = ablock;
        maxStackSize = 1;
        setMaxDamage(enumnewtoolmaterial.func_21207_a());
        efficiencyOnProperMaterial = enumnewtoolmaterial.func_21206_b();
        damageVsEntity = j + enumnewtoolmaterial.func_21205_c();
    }

    public boolean canHarvestBlock(Block block)
    {
        if(this instanceof Node_ItemPickaxe)
        {
            Node_ItemPickaxe itemnewpickaxe = (Node_ItemPickaxe)this;
            return itemnewpickaxe.func_25035_a(block);
        }
        if(this instanceof Node_ItemSpade)
        {
            Node_ItemSpade itemnewspade = (Node_ItemSpade)this;
            return itemnewspade.func_25033_c(block);
        } else
        {
            return (this instanceof Node_ItemAxe) ? false : false;
        }
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        for(int i = 0; i < field_25029_bi.length; i++)
        {
            if(field_25029_bi[i] == block)
            {
                return efficiencyOnProperMaterial;
            }
        }
		
		if((block.blockID == Block.obsidian.blockID || block.blockID == Block.oreRedstone.blockID) && field_20927_a.equals(Node_EnumToolMaterial.OBSIDIAN))
        {
            return efficiencyOnProperMaterial;
        }

        return 1.0F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(2, entityliving1);
        return true;
    }

    public boolean func_25008_a(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(1, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    public boolean isFull3D()
    {
        return true;
    }

    private Block field_25029_bi[];
    private float efficiencyOnProperMaterial;
    private int damageVsEntity;
    public static EnumToolMaterial field_25030_az1;
    protected Node_EnumToolMaterial field_20927_a;
}
