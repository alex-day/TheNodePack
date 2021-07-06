package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_ItemEarthWand extends Item
{

    protected Node_ItemEarthWand(int i, int j, int k)
    {
        super(i);
        radius = j;
        setMaxDamage(k);
        maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(makeGrass(world, i, j, k))
        {
            entityplayer.swingItem();
            itemstack.damageItem(1, null);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean isFull3D()
    {
        return true;
    }

    /**
     * converts dirt in a certain radius to grass
     * also has a chance to grows saplings and crops
     * Now also gives a random chance to create tall grass
     * @param world
     * @param i
     * @param j
     * @param k
     * @return true if something happened
     */
    public boolean makeGrass(World world, int i, int j, int k)
    {
        boolean flag = false;
        for(int l = -radius; l <= radius; l++)
        {
            for(int i1 = -radius; i1 <= radius; i1++)
            {
                for(int j1 = -radius; j1 <= radius; j1++)
                {
                    if(getLinearDistanceInt(i, j, k, i + l, j + i1, k + j1) > radius)
                    {
                        continue;
                    }
                    if(world.getBlockId(i + l, j + i1, k + j1) == Block.sapling.blockID)
                    {
                        ((BlockSapling)Block.sapling).growTree(world, i + l, j + i1, k + j1, world.rand);
                        flag = true;
                        continue;
                    }
                    if(world.getBlockId(i + l, j + i1, k + j1) == Block.crops.blockID)
                    {
                        ((BlockCrops)Block.crops).fertilize(world, i + l, j + i1, k + j1);
                        flag = true;
                        continue;
                    }
                    if(world.getBlockId(i + l, j + i1, k + j1) == Block.dirt.blockID && world.isAirBlock(i + l, j + i1 + 1, k + j1))
                    {
                        world.setBlockWithNotify(i + l, j + i1, k + j1, Block.grass.blockID);
                        flag = true;
                    }
                    if(world.getBlockId(i + l, j + i1, k + j1) == Block.grass.blockID && world.isAirBlock(i + l, j + i1 + 1, k + j1))
                    {
                    	int randy = world.rand.nextInt(8);
                    	if(randy == 0) {
	                        world.setBlockAndMetadataWithNotify(i + l, j + i1 + 1, k + j1, Block.tallGrass.blockID, 1+world.rand.nextInt(2));
	                        flag = true;
                    	}
                    }
                }

            }

        }

        return flag;
    }

    /**
     * returns the linear distance between two blocks
     * @param i
     * @param j
     * @param k
     * @param l
     * @param i1
     * @param j1
     * @return
     */
    private double getLinearDistance(int i, int j, int k, int l, int i1, int j1)
    {
        double d = Math.sqrt(Math.pow(l - i, 2D) + Math.pow(i1 - j, 2D) + Math.pow(j1 - k, 2D));
        return d;
    }

    
    /**
     * gets the linear distance between two blocks and converts it to an integer.
     * @param i
     * @param j
     * @param k
     * @param l
     * @param i1
     * @param j1
     * @return
     */
    private int getLinearDistanceInt(int i, int j, int k, int l, int i1, int j1)
    {
        Double double1 = Double.valueOf(getLinearDistance(i, j, k, l, i1, j1));
        return double1.intValue();
    }

    private int radius;
}
