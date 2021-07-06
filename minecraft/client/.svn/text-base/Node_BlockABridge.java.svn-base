package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_BlockABridge extends BlockContainer
{

    protected Node_BlockABridge(int i, int j)
    {
        super(i, j, Material.iron);
        setTickOnLoad(true);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        Node_TileEntityABridge tileentityabridge = (Node_TileEntityABridge)iblockaccess.getBlockTileEntity(i, j, k);
        int i1 = tileentityabridge.getIndex();
        int j1 = tileentityabridge.getMeta();
        if(i1 == Node_TileEntityABridge.defaultInd)
        {
            return blockIndexInTexture;
        }
        if(Block.blocksList[i1] != null && i1 < Block.blocksList.length && i1 > 0)
        {
            return Block.blocksList[i1].getBlockTextureFromSideAndMetadata(l, j1);
        } else
        {
            return blockIndexInTexture;
        }
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    protected TileEntity getBlockEntity()
    {
        return new Node_TileEntityABridge();
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            InventoryPlayer inventoryplayer = entityplayer.inventory;
            ItemStack itemstack = inventoryplayer.armorInventory[0];
            double d = 0.75D;
            if(itemstack != null && itemstack.getItem().shiftedIndex == mod_Node_LaserBridge.accelBoots.shiftedIndex)
            {
                d = 1.25D;
            }
            mod_Node_PackLoader.trace((new StringBuilder()).append("EP motion was: [").append(entity.motionX).append(",").append(entity.motionZ).append("]").toString());
            if(Math.abs(entity.motionX) > Math.abs(entity.motionZ))
            {
                mod_Node_PackLoader.trace("changing x speed");
                entity.motionX *= 3.5D;
				
            } else
            {
                mod_Node_PackLoader.trace("changing z speed");
                entity.motionZ *= 3.5D;
            }
            if(entity.motionX > d)
            {
                mod_Node_PackLoader.trace("limiting pos X");
                entity.motionX = d;
            } else
            if(entity.motionX < -d)
            {
                mod_Node_PackLoader.trace("limiting neg X");
                entity.motionX = -d;
            }
            if(entity.motionZ > d)
            {
                mod_Node_PackLoader.trace("limiting pos z");
                entity.motionZ = d;
            } else
            if(entity.motionZ < -d)
            {
                mod_Node_PackLoader.trace("limiting neg z");
                entity.motionZ = -d;
            }
            mod_Node_PackLoader.trace((new StringBuilder()).append("EP motion now: [").append(entity.motionX).append(",").append(entity.motionZ).append("]").toString());
        }
    }
}
