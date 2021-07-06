package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_TileEntityCompacter extends TileEntity
    implements IInventory
{

    public Node_TileEntityCompacter()
    {
        compacterItemStacks = new ItemStack[6];
        compacterBurnTime = 0;
        currentItemBurnTime = 0;
        compacterCookTime = 0;
    }

    public int getSizeInventory()
    {
        return compacterItemStacks.length;
    }

    public ItemStack getStackInSlot(int i)
    {
        return compacterItemStacks[i];
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if(compacterItemStacks[i] != null)
        {
            if(compacterItemStacks[i].stackSize <= j)
            {
                ItemStack itemstack = compacterItemStacks[i];
                compacterItemStacks[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = compacterItemStacks[i].splitStack(j);
            if(compacterItemStacks[i].stackSize == 0)
            {
                compacterItemStacks[i] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        compacterItemStacks[i] = itemstack;
        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInvName()
    {
        return "Compacter";
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        compacterItemStacks = new ItemStack[getSizeInventory()];
        for(int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound1.getByte("Slot");
            if(byte0 >= 0 && byte0 < compacterItemStacks.length)
            {
                compacterItemStacks[byte0] = new ItemStack(nbttagcompound1);
            }
        }

        compacterBurnTime = nbttagcompound.getShort("BurnTime");
        compacterCookTime = nbttagcompound.getShort("CookTime");
        currentItemBurnTime = getItemBurnTime(compacterItemStacks[1]);
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)compacterBurnTime);
        nbttagcompound.setShort("CookTime", (short)compacterCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < compacterItemStacks.length; i++)
        {
            if(compacterItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                compacterItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.setTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int i)
    {
        return (compacterCookTime * i) / 200;
    }

    public int getBurnTimeRemainingScaled(int i)
    {
        if(currentItemBurnTime == 0)
        {
            currentItemBurnTime = 200;
        }
        return (compacterBurnTime * i) / currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return compacterBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = compacterBurnTime > 0;
        boolean flag1 = false;
        if(compacterBurnTime > 0)
        {
            compacterBurnTime--;
        }
        if(!worldObj.multiplayerWorld)
        {
            if(compacterBurnTime == 0 && canSmelt())
            {
                int i = 0;
                boolean flag2 = true;
                for(int j = 2; j < 6; j++)
                {
                    if(compacterItemStacks[j] != null)
                    {
                        if(i == 0)
                        {
                            i = compacterItemStacks[j].getItem().shiftedIndex;
                            continue;
                        }
                        if(i != compacterItemStacks[j].getItem().shiftedIndex)
                        {
                            flag2 = false;
                        }
                    } else
                    {
                        flag2 = false;
                    }
                }

                if(flag2)
                {
                    currentItemBurnTime = compacterBurnTime = getItemBurnTime(compacterItemStacks[2]);
                }
                if(compacterBurnTime > 0)
                {
                    flag1 = true;
                    for(int k = 2; k < 6; k++)
                    {
                        if(compacterItemStacks[k] == null)
                        {
                            continue;
                        }
                        compacterItemStacks[k].stackSize--;
                        if(compacterItemStacks[k].stackSize == 0)
                        {
                            compacterItemStacks[k] = null;
                        }
                    }

                }
            }
            if(isBurning() && canSmelt())
            {
                compacterCookTime++;
                if(compacterCookTime == 200)
                {
                    compacterCookTime = 0;
                    smeltItem();
                    flag1 = true;
                }
            } else
            {
                compacterCookTime = 0;
            }
            if(flag != (compacterBurnTime > 0))
            {
                flag1 = true;
                Node_BlockCompacter.updateCompacterBlockState(compacterBurnTime > 0, worldObj, xCoord, yCoord, zCoord);
            }
        }
        if(flag1)
        {
            onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
        if(compacterItemStacks[0] == null)
        {
            return false;
        }
        ItemStack itemstack = Node_CompacterRecipes.func_25218_func_21200_a().func_25217_func_21198_a(compacterItemStacks[0].getItem().shiftedIndex);
        if(itemstack == null)
        {
            return false;
        }
        if(compacterItemStacks[1] == null)
        {
            return true;
        }
        if(!compacterItemStacks[1].isItemEqual(itemstack))
        {
            return false;
        }
        if(compacterItemStacks[1].stackSize < getInventoryStackLimit() && compacterItemStacks[1].stackSize < compacterItemStacks[1].getMaxStackSize())
        {
            return true;
        } else
        {
            return compacterItemStacks[1].stackSize < itemstack.getMaxStackSize();
        }
    }

    public void smeltItem()
    {
        if(!canSmelt())
        {
            return;
        }
        ItemStack itemstack = Node_CompacterRecipes.func_25218_func_21200_a().func_25217_func_21198_a(compacterItemStacks[0].getItem().shiftedIndex);
        if(compacterItemStacks[1] == null)
        {
            compacterItemStacks[1] = itemstack.copy();
        } else
        if(compacterItemStacks[1].itemID == itemstack.itemID)
        {
            compacterItemStacks[1].stackSize++;
        }
        compacterItemStacks[0].stackSize--;
        if(compacterItemStacks[0].stackSize <= 0)
        {
            compacterItemStacks[0] = null;
        }
    }

    private int getItemBurnTime(ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return 0;
        }
        int i = itemstack.getItem().shiftedIndex;
        if(i < 256 && Block.blocksList[i].blockMaterial == Material.wood)
        {
            return 300;
        }
        if(i == Item.stick.shiftedIndex)
        {
            return 100;
        }
        if(i == Item.coal.shiftedIndex)
        {
            return 1600;
        }
        if(i == Item.bucketLava.shiftedIndex)
        {
            return 20000;
        } else
        {
            return ModLoader.AddAllFuel(i);
        }
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        } else
        {
            return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
        }
    }

    private ItemStack compacterItemStacks[];
    public int compacterBurnTime;
    public int currentItemBurnTime;
    public int compacterCookTime;
}
