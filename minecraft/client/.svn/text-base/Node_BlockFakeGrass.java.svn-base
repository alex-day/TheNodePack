package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_BlockFakeGrass extends Block
{
    protected Node_BlockFakeGrass(int i)
    {
        super(i, Material.ground);
        blockIndexInTexture = 0;
        //setTickOnLoad(true);
    }
	
	public int getRenderType() {
		return modelID;
	}
	
	public boolean isOpaqueCube()
    {
		/*boolean returnValue = false;
	
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		
		boolean check1 = true; //if true then is 1 or 2 else is 0
		boolean check2 = false; //if true is 2 else 1 ONLY if check1 = true
		
		for(int a = 0; a < stack.length; a++){
			String tempString = stack[a].toString();
			
			System.out.println(tempString);
			//tblocktorch = uf
			int index = tempString.indexOf(".a(");
				
			if(index != -1){
				returnValue = true;	
			}
		}
		*/
        return true;
    }

	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
        int i1 = quantityDropped(world.rand);
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(world.rand.nextFloat() > f)
            {
                continue;
            }
            int k1 = idDropped(l, world.rand);
            if(k1 > 0)
            {
                float f1 = 0.7F;
                double d = (double)(world.rand.nextFloat() * f1) + (double)(1.0F - f1) * 0.5D;
                double d1 = (double)(world.rand.nextFloat() * f1) + (double)(1.0F - f1) * 0.5D;
                double d2 = (double)(world.rand.nextFloat() * f1) + (double)(1.0F - f1) * 0.5D;
                EntityItem fakeGrassEntity = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, new ItemStack(k1, 1, damageDropped(l)));
                fakeGrassEntity.delayBeforeCanPickup = 10;
                world.entityJoinedWorld(fakeGrassEntity);
            }
        }
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        iblockaccess.getWorldChunkManager().func_4069_a(i, k, 1, 1);
        double d = iblockaccess.getWorldChunkManager().temperature[0];
        double d1 = iblockaccess.getWorldChunkManager().humidity[0];
        return ColorizerGrass.getGrassColor(d, d1);
    }
	
	public static int modelID;
}
