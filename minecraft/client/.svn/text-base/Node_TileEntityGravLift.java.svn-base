package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_TileEntityGravLift extends TileEntity
{

    public Node_TileEntityGravLift()
    {
        daddyX = 0;
        daddyY = 0;
        daddyZ = 0;
        dirUp = 0;
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        daddyX = nbttagcompound.getShort("DaddyX");
        daddyY = nbttagcompound.getShort("DaddyY");
        daddyZ = nbttagcompound.getShort("DaddyZ");
        dirUp = nbttagcompound.getShort("DirUp");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("DaddyX", (short)daddyX);
        nbttagcompound.setShort("DaddyY", (short)daddyY);
        nbttagcompound.setShort("DaddyZ", (short)daddyZ);
        nbttagcompound.setShort("DirUp", (short)dirUp);
    }

    public void setDaddy(int i, int j, int k)
    {
        //mod_Node_PackLoader.trace("setting daddy");
        daddyX = i;
        daddyY = j;
        daddyZ = k;
    }

    public void setDirUp(int i)
    {
        dirUp = i;
    }
    
    public int getDirUp() {
		return dirUp;
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
        if(dirUp == 1)
        {
            return worldObj.getBlockId(xCoord, yCoord + 1, zCoord) == mod_Node_GravLift.blockGravLift.blockID || worldObj.getBlockId(xCoord, yCoord + 1, zCoord) == mod_Node_GravLift.blockGravLiftControl.blockID;
        } else
        {
            return worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == mod_Node_GravLift.blockGravLift.blockID || worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == mod_Node_GravLift.blockGravLiftControl.blockID;
        }
    }

    private int daddyX;
    private int daddyY;
    private int daddyZ;
    private int dirUp;
	
}
