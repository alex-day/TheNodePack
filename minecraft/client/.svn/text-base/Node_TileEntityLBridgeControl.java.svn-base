package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_TileEntityLBridgeControl extends TileEntity
{

    public Node_TileEntityLBridgeControl()
    {
        worldObj = -1;
        meta = 0;
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        worldObj = nbttagcompound.getShort("LBridgeInd");
        meta = nbttagcompound.getShort("LBridgeMeta");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("LBridgeInd", (short)worldObj);
        nbttagcompound.setShort("LBridgeMeta", (short)meta);
    }

    public int getIndex()
    {
        if(worldObj > 0)
        {
            return worldObj;
        } else
        {
            return Node_TileEntityLBridge.defaultInd;
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
