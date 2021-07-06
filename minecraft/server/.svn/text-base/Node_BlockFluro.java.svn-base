package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_BlockFluro extends Block
{

    protected Node_BlockFluro(int i, int ai[])
    {
        super(i, Material.glass);
        texArray = ai;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return texArray[j];
    }
	
	public int damageDropped(int i)
    {
        return i;
    }
	
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
		if(entityliving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) entityliving;
			ItemStack is = entityplayer.getCurrentEquippedItem();
			if(is == null) {
				return;
			}
			int l = is.getItemDamage();
			
			world.setBlockMetadataWithNotify(i,j,k,l);
		}
    }
	
	

    int texArray[];
}
