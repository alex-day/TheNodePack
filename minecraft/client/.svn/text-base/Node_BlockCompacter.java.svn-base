package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_BlockCompacter extends BlockFurnace
{

    protected Node_BlockCompacter(int i, boolean flag, int j, int k)
    {
        super(i, flag);
        isActive = flag;
        frontOnTex = k;
        frontOffTex = j;
    }

    public int idDropped(int i, Random random)
    {
        return mod_Node_KimberlitePack.blockCompacterIdle.blockID;
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);
        setDefaultDirection(world, i, j, k);
    }

    private void setDefaultDirection(World world, int i, int j, int k)
    {
        int l = world.getBlockId(i, j, k - 1);
        int i1 = world.getBlockId(i, j, k + 1);
        int j1 = world.getBlockId(i - 1, j, k);
        int k1 = world.getBlockId(i + 1, j, k);
        byte byte0 = 3;
        if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
        {
            byte0 = 3;
        }
        if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
        {
            byte0 = 2;
        }
        if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
        {
            byte0 = 5;
        }
        if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
        {
            byte0 = 4;
        }
        world.setBlockMetadataWithNotify(i, j, k, byte0);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return blockIndexInTexture + 17;
        }
        if(l == 0)
        {
            return blockIndexInTexture + 17;
        }
        int i1 = iblockaccess.getBlockMetadata(i, j, k);
        if(l != i1)
        {
            return blockIndexInTexture;
        }
        if(isActive)
        {
            return frontOnTex;
        } else
        {
            return frontOffTex;
        }
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        if(!isActive)
        {
            return;
        }
        int l = world.getBlockMetadata(i, j, k);
        float f = (float)i + 0.5F;
        float f1 = (float)j + 0.0F + (random.nextFloat() * 6F) / 16F;
        float f2 = (float)k + 0.5F;
        float f3 = 0.52F;
        float f4 = random.nextFloat() * 0.6F - 0.3F;
        if(l == 4)
        {
            world.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 5)
        {
            world.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 2)
        {
            world.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 3)
        {
            world.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        }
    }

    public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return blockIndexInTexture + 17;
        }
        if(i == 0)
        {
            return blockIndexInTexture + 17;
        }
        if(i == 3)
        {
            return frontOffTex;
        } else
        {
            return blockIndexInTexture;
        }
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return true;
        } else
        {
            Node_TileEntityCompacter tileentitycompacter = (Node_TileEntityCompacter)world.getBlockTileEntity(i, j, k);
            ModLoader.OpenGUI(entityplayer, new Node_GuiCompacter(entityplayer.inventory, tileentitycompacter));
            return true;
        }
    }

    public static void updateCompacterBlockState(boolean flag, World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        TileEntity tileentity = world.getBlockTileEntity(i, j, k);
        keepFurnaceInventory = true;
        if(flag)
        {
            world.setBlockWithNotify(i, j, k, mod_Node_KimberlitePack.blockCompacterActive.blockID);
        } else
        {
            world.setBlockWithNotify(i, j, k, mod_Node_KimberlitePack.blockCompacterIdle.blockID);
        }
        keepFurnaceInventory = false;
        world.setBlockMetadataWithNotify(i, j, k, l);
        world.setBlockTileEntity(i, j, k, tileentity);
    }

    protected TileEntity getBlockEntity()
    {
        return new Node_TileEntityCompacter();
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            world.setBlockMetadataWithNotify(i, j, k, 2);
        }
        if(l == 1)
        {
            world.setBlockMetadataWithNotify(i, j, k, 5);
        }
        if(l == 2)
        {
            world.setBlockMetadataWithNotify(i, j, k, 3);
        }
        if(l == 3)
        {
            world.setBlockMetadataWithNotify(i, j, k, 4);
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        if(!keepFurnaceInventory)
        {
            Node_TileEntityCompacter tileentitycompacter = (Node_TileEntityCompacter)world.getBlockTileEntity(i, j, k);
label0:
            for(int l = 0; l < tileentitycompacter.getSizeInventory(); l++)
            {
                ItemStack itemstack = tileentitycompacter.getStackInSlot(l);
                if(itemstack == null)
                {
                    continue;
                }
                float f = world.rand.nextFloat() * 0.8F + 0.1F;
                float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                float f2 = world.rand.nextFloat() * 0.8F + 0.1F;
                do
                {
                    if(itemstack.stackSize <= 0)
                    {
                        continue label0;
                    }
                    int i1 = world.rand.nextInt(21) + 10;
                    if(i1 > itemstack.stackSize)
                    {
                        i1 = itemstack.stackSize;
                    }
                    itemstack.stackSize -= i1;
                    EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
                    float f3 = 0.05F;
                    entityitem.motionX = (float)world.rand.nextGaussian() * f3;
                    entityitem.motionY = (float)world.rand.nextGaussian() * f3 + 0.2F;
                    entityitem.motionZ = (float)world.rand.nextGaussian() * f3;
                    world.entityJoinedWorld(entityitem);
                } while(true);
            }

        }
        
        //because this block extends furnace but doesn't want to call furnace on block removal
        //instead the following code is from container on block removal.
        world.removeBlockTileEntity(i, j, k);
    }
    
    public int frontOnTex;
    public int frontOffTex;
    private final boolean isActive;
    private static boolean keepFurnaceInventory = false;
}
