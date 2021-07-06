package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemDoor extends Item
{

    public Node_ItemDoor(int i, Material material)
    {
        super(i);
        field_25040_mat = material;
        setMaxDamage(64);
        maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(l != 1)
        {
            return false;
        }
        j++;
        Block block;
        if(field_25040_mat == Material.glass)
        {
            block = mod_Node_DoorPack.blockGlassDoor;
        } else
        {
            block = mod_Node_DoorPack.blockBrickDoor;
        }
        if(!block.canPlaceBlockAt(world, i, j, k))
        {
            return false;
        }
        int i1 = MathHelper.floor_double(((entityplayer.rotationYaw + 180D) * 4D) / 360D - 0.5D) & 3;
        byte byte0 = 0;
        byte byte1 = 0;
        if(i1 == 0)
        {
            byte1 = 1;
        }
        if(i1 == 1)
        {
            byte0 = -1;
        }
        if(i1 == 2)
        {
            byte1 = -1;
        }
        if(i1 == 3)
        {
            byte0 = 1;
        }
        int j1 = (world.isBlockOpaqueCube(i - byte0, j, k - byte1) ? 1 : 0) + (world.isBlockOpaqueCube(i - byte0, j + 1, k - byte1) ? 1 : 0);
        int k1 = (world.isBlockOpaqueCube(i + byte0, j, k + byte1) ? 1 : 0) + (world.isBlockOpaqueCube(i + byte0, j + 1, k + byte1) ? 1 : 0);
        boolean flag = world.getBlockId(i - byte0, j, k - byte1) == block.blockID || world.getBlockId(i - byte0, j + 1, k - byte1) == block.blockID;
        boolean flag1 = world.getBlockId(i + byte0, j, k + byte1) == block.blockID || world.getBlockId(i + byte0, j + 1, k + byte1) == block.blockID;
        boolean flag2 = false;
        if(flag && !flag1)
        {
            flag2 = true;
        } else
        if(k1 > j1)
        {
            flag2 = true;
        }
        if(flag2)
        {
            i1 = i1 - 1 & 3;
            i1 += 4;
        }
        world.setBlockWithNotify(i, j, k, block.blockID);
        world.setBlockMetadataWithNotify(i, j, k, i1);
        world.setBlockWithNotify(i, j + 1, k, block.blockID);
        world.setBlockMetadataWithNotify(i, j + 1, k, i1 + 8);
        itemstack.stackSize--;
        return true;
    }

    private Material field_25040_mat;
}
