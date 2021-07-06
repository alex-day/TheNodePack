package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.List;

public class Node_GuiCompacterServer extends Container
{

    public Node_GuiCompacterServer(IInventory iinventory, Node_TileEntityCompacter tileentitycompacter)
    {
        field_25544_cookTime = 0;
        field_25543_burnTime = 0;
        field_25542_b = 0;
        field_25546_inventory = iinventory;
        field_25545_compacter = tileentitycompacter;
        addSlot(new Slot(field_25545_compacter, 0, 34, 35));
        addSlot(new Slot(field_25545_compacter, 1, 116, 35));
        addSlot(new Slot(field_25545_compacter, 2, 34, 11));
        addSlot(new Slot(field_25545_compacter, 3, 10, 35));
        addSlot(new Slot(field_25545_compacter, 4, 58, 35));
        addSlot(new Slot(field_25545_compacter, 5, 34, 59));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                addSlot(new Slot(iinventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            addSlot(new Slot(iinventory, j, 8 + j * 18, 142));
        }

    }

    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        for(int i = 0; i < field_20121_g.size(); i++)
        {
            ICrafting icrafting = (ICrafting)field_20121_g.get(i);
            if(field_25544_cookTime != field_25545_compacter.compacterCookTime)
            {
                icrafting.func_20158_a(this, 0, field_25545_compacter.compacterCookTime);
            }
            if(field_25543_burnTime != field_25545_compacter.compacterBurnTime)
            {
                icrafting.func_20158_a(this, 1, field_25545_compacter.compacterBurnTime);
            }
            if(field_25542_b != field_25545_compacter.currentItemBurnTime)
            {
                icrafting.func_20158_a(this, 2, field_25545_compacter.currentItemBurnTime);
            }
        }

        field_25544_cookTime = field_25545_compacter.compacterCookTime;
        field_25543_burnTime = field_25545_compacter.compacterBurnTime;
        field_25542_b = field_25545_compacter.currentItemBurnTime;
    }

    public void func_20112_a(int i, int j)
    {
        if(i == 0)
        {
            field_25545_compacter.compacterCookTime = j;
        }
        if(i == 1)
        {
            field_25545_compacter.compacterBurnTime = j;
        }
        if(i == 2)
        {
            field_25545_compacter.currentItemBurnTime = j;
        }
    }

    public boolean isUsableByPlayer(EntityPlayer entityplayer)
    {
        return field_25545_compacter.canInteractWith(entityplayer);
    }

    private IInventory field_25546_inventory;
    private Node_TileEntityCompacter field_25545_compacter;
    private int field_25544_cookTime;
    private int field_25543_burnTime;
    private int field_25542_b;
}
