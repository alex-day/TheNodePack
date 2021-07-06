package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_TileEntityABridge extends TileEntity
{

    public Node_TileEntityABridge()
    {
        index = -1;
        meta = 0;
        daddyX = 0;
        daddyY = 0;
        daddyZ = 0;
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        index = nbttagcompound.getShort("ABridgeInd");
        meta = nbttagcompound.getShort("ABridgeMeta");
        daddyX = nbttagcompound.getShort("DaddyX");
        daddyY = nbttagcompound.getShort("DaddyY");
        daddyZ = nbttagcompound.getShort("DaddyZ");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("ABridgeInd", (short)index);
        nbttagcompound.setShort("ABridgeMeta", (short)meta);
        nbttagcompound.setShort("DaddyX", (short)daddyX);
        nbttagcompound.setShort("DaddyY", (short)daddyY);
        nbttagcompound.setShort("DaddyZ", (short)daddyZ);
    }

    public void setDaddy(int i, int j, int k)
    {
        //mod_Node_PackLoader.trace("setting daddy");
        daddyX = i;
        daddyY = j;
        daddyZ = k;
    }

    public void updateEntity()
    {
        if(!canSeeDaddy())
        {
            worldObj.setBlockWithNotify(xCoord, yCoord, zCoord, 0);
        }
    }

    public boolean canSeeDaddy()
    {
        int i = daddyX - xCoord;
        int j = daddyZ - zCoord;
        byte byte0 = 0;
        byte byte1 = 0;
        boolean flag = false;
        if(i == 0)
        {
            int k = Math.abs(j);
            if(j < 0)
            {
                byte1 = -1;
            } else
            {
                byte1 = 1;
            }
        }
        if(j == 0)
        {
            int l = Math.abs(i);
            if(i < 0)
            {
                byte0 = -1;
            } else
            {
                byte0 = 1;
            }
        }
        int i1 = xCoord;
        int j1 = zCoord;
        i1 += byte0;
        j1 += byte1;
        if(worldObj.getBlockId(i1, yCoord, j1) == mod_Node_LaserBridge.blockAccelBridge.blockID || worldObj.getBlockId(i1, yCoord, j1) == mod_Node_LaserBridge.blockAccelBridgeControl.blockID)
        {
            return true;
        }
        if(laserCheck(worldObj, i1, yCoord, j1))
        {
            i1 += byte0;
            j1 += byte1;
            if(worldObj.getBlockId(i1, yCoord, j1) == mod_Node_LaserBridge.blockAccelBridge.blockID || worldObj.getBlockId(i1, yCoord, j1) == mod_Node_LaserBridge.blockAccelBridgeControl.blockID)
            {
                return true;
            }
        }
        return false;
    }

    public int getIndex()
    {
        if(index > 0)
        {
            return index;
        } else
        {
            return defaultInd;
        }
    }

    public void setIndex(int i)
    {
        index = i;
    }

    public int getMeta()
    {
        return meta;
    }

    public void setMeta(int i)
    {
        meta = i;
    }

    public boolean laserCheck(World world, int i, int j, int k)
    {
        boolean flag = world.getBlockId(i, j, k) == mod_Node_LaserBridge.blockLaserBridge.blockID || world.getBlockId(i, j, k) == mod_Node_LaserBridge.blockAccelBridge.blockID || world.getBlockId(i, j, k) == mod_Node_LaserBridge.blockTrickBridge.blockID || world.getBlockId(i, j, k) == mod_Node_LaserBridge.blockDeathBridge.blockID;
        return flag;
    }

    private int index;
    private int meta;
    private int daddyX;
    private int daddyY;
    private int daddyZ;
    public static int defaultInd;
}
