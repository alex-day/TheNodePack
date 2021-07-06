package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_BlockDBridgeControl extends BlockContainer
{

    protected Node_BlockDBridgeControl(int i, int j)
    {
        super(i, 45, Material.ground);
        field_25266_tex = j;
    }

    protected TileEntity getBlockEntity()
    {
        return new Node_TileEntityDBridgeControl();
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return true;
        }
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
        if(itemstack != null)
        {
            Item item = itemstack.getItem();
            Node_TileEntityDBridgeControl tileentitydbridgecontrol1 = (Node_TileEntityDBridgeControl)world.getBlockTileEntity(i, j, k);
            boolean flag = item.shiftedIndex == Block.glass.blockID || item.shiftedIndex == Block.lavaMoving.blockID || item.shiftedIndex == Block.lavaStill.blockID || item.shiftedIndex == Block.waterMoving.blockID || item.shiftedIndex == Block.lavaStill.blockID || item.shiftedIndex == Block.leaves.blockID || item.shiftedIndex == Block.ice.blockID;
            if(item.shiftedIndex < Block.blocksList.length && (Block.blocksList[item.shiftedIndex].isOpaqueCube() || flag))
            {
                tileentitydbridgecontrol1.setIndex(item.shiftedIndex);
                if(item instanceof ItemCloth)
                {
                    tileentitydbridgecontrol1.setMeta(itemstack.getItemDamage());
                }
                if(item.shiftedIndex == Block.grass.blockID)
                {
                    tileentitydbridgecontrol1.setIndex(Block.dirt.blockID);
                }
            } else
            {
                tileentitydbridgecontrol1.setIndex(Node_TileEntityTBridge.defaultInd);
            }
        } else
        {
            Node_TileEntityDBridgeControl tileentitydbridgecontrol = (Node_TileEntityDBridgeControl)world.getBlockTileEntity(i, j, k);
            tileentitydbridgecontrol.setIndex(Node_TileEntityDBridge.defaultInd);
        }
        if(func_25263_isActive(world, i, j, k))
        {
            func_25265_createBridge(world, i, j, k, false);
            func_25264_setActive(world, i, j, k, false);
        } else
        {
            func_25265_createBridge(world, i, j, k, true);
            func_25264_setActive(world, i, j, k, true);
        }
        return true;
    }

    public boolean func_25263_isActive(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        return l / 10 == 1;
    }

    public void func_25264_setActive(World world, int i, int j, int k, boolean flag)
    {
        int l = world.getBlockMetadata(i, j, k);
        if(func_25263_isActive(world, i, j, k))
        {
            if(!flag)
            {
                l %= 10;
            }
        } else
        if(flag)
        {
            l = 10 + l;
        }
        world.setBlockMetadataWithNotify(i, j, k, l);
    }

    public void func_25265_createBridge(World world, int i, int j, int k, boolean flag)
    {
        int l = mod_Node_PackLoader.getIntOption("BridgeRange");
        int i1 = world.getBlockMetadata(i, j, k);
        int j1 = i1 % 10;
        int k1 = i;
        int l1 = k;
        for(int i2 = 0; i2 < l; i2++)
        {
            if(j1 == 3)
            {
                l1++;
            }
            if(j1 == 2)
            {
                l1--;
            }
            if(j1 == 5)
            {
                k1++;
            }
            if(j1 == 4)
            {
                k1--;
            }
            if(flag)
            {
				int testedBlockID = world.getBlockId(k1, j, l1);
                boolean waterLavaSnowCheck = (testedBlockID == Block.snow.blockID) ||
											(testedBlockID == Block.lavaMoving.blockID) ||
											(testedBlockID == Block.lavaStill.blockID) ||
											(testedBlockID == Block.waterMoving.blockID) ||
											(testedBlockID == Block.waterStill.blockID);
											
				if(world.isAirBlock(k1, j, l1) || func_25262_laserCheck(world, k1, j, l1) || waterLavaSnowCheck)
                {
					mod_Node_PackLoader.trace("generating laser");
                    world.setBlockWithNotify(k1, j, l1, mod_Node_LaserBridge.blockDeathBridge.blockID);
                    Node_TileEntityDBridge tileentitydbridge = new Node_TileEntityDBridge();
                    tileentitydbridge.setDaddy(i, j, k);
                    Node_TileEntityDBridgeControl tileentitydbridgecontrol = (Node_TileEntityDBridgeControl)world.getBlockTileEntity(i, j, k);
                    tileentitydbridge.setIndex(tileentitydbridgecontrol.getIndex());
                    tileentitydbridge.setMeta(tileentitydbridgecontrol.getMeta());
                    world.setBlockTileEntity(k1, j, l1, tileentitydbridge);
                    continue;
                }
                if(world.getBlockId(k1, j, l1) != mod_Node_LaserBridge.blockDeathBridge.blockID)
                {
                    break;
                }
                continue;
            }
            if(world.getBlockId(k1, j, l1) == mod_Node_LaserBridge.blockDeathBridge.blockID)
            {
                world.setBlockWithNotify(k1, j, l1, 0);
                continue;
            }
            if(!func_25262_laserCheck(world, k1, j, l1))
            {
                break;
            }
        }

    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(l > 0 && Block.blocksList[l].canProvidePower())
        {
            boolean flag = world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k);
            if(flag)
            {
                if(!func_25263_isActive(world, i, j, k))
                {
                    func_25265_createBridge(world, i, j, k, true);
                    func_25264_setActive(world, i, j, k, true);
                }
            } else
            if(func_25263_isActive(world, i, j, k))
            {
                func_25265_createBridge(world, i, j, k, false);
                func_25264_setActive(world, i, j, k, false);
            }
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        super.onBlockRemoval(world, i, j, k);
        if(func_25263_isActive(world, i, j, k))
        {
            func_25265_createBridge(world, i, j, k, false);
            func_25264_setActive(world, i, j, k, false);
        }
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.setBlockMetadataWithNotify(i, j, k, 3);
        }
        if(l == 1)
        {
            world.setBlockMetadataWithNotify(i, j, k, 4);
        }
        if(l == 2)
        {
            world.setBlockMetadataWithNotify(i, j, k, 2);
        }
        if(l == 3)
        {
            world.setBlockMetadataWithNotify(i, j, k, 5);
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 1)
        {
            return blockIndexInTexture + 17;
        }
        if(i == 0)
        {
            return blockIndexInTexture + 17;
        }
        if(i == j % 10)
        {
            return field_25266_tex;
        } else
        {
            return blockIndexInTexture;
        }
    }

    public boolean func_25262_laserCheck(World world, int i, int j, int k)
    {
        boolean flag = world.getBlockId(i, j, k) == mod_Node_LaserBridge.blockLaserBridge.blockID || world.getBlockId(i, j, k) == mod_Node_LaserBridge.blockAccelBridge.blockID || world.getBlockId(i, j, k) == mod_Node_LaserBridge.blockTrickBridge.blockID || world.getBlockId(i, j, k) == mod_Node_LaserBridge.blockDeathBridge.blockID;
        return flag;
    }

    private int field_25266_tex;
}
