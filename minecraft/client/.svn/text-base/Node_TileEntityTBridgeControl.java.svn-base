package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_TileEntityTBridgeControl extends TileEntity
{

    public Node_TileEntityTBridgeControl()
    {
        worldObj = -1;
        meta = 0;
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        worldObj = nbttagcompound.getShort("TBridgeInd");
        meta = nbttagcompound.getShort("TBridgeMeta");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("TBridgeInd", (short)worldObj);
        nbttagcompound.setShort("TBridgeMeta", (short)meta);
    }

    public int getIndex()
    {
        if(worldObj > 0)
        {
            return worldObj;
        } else
        {
            return Node_TileEntityTBridge.defaultInd;
        }
    }

    public void setIndex(int i)
    {
        worldObj = i;
    }

    public int getMeta()
    {
        return meta;
    }

    public void setMeta(int i)
    {
        meta = i;
    }

    private int worldObj;
    private int meta;
}
