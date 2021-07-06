package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;
import java.util.List;

public class Node_ItemPolymorphWand extends Item
{

    private static final double RANGE = 5.0;

	protected Node_ItemPolymorphWand(int i, int j)
    {
        super(i);
        setMaxDamage(j);
        maxStackSize = 1;
    }

    public boolean isFull3D()
    {
        return true;
    }
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		/*EntityLiving entityToConvert = getEntityToConvert(world, entityplayer);
        if(entityToConvert != null)
        {
            convertEntity(itemstack, entityplayer, entityToConvert);
        }*/
		
		convertEntities(world, itemstack, entityplayer);
		
        return itemstack;
    }
	
	public void convertEntities(World world, ItemStack itemstack, EntityPlayer entityplayer)
    {
        int i = MathHelper.floor_double(entityplayer.posX - RANGE);
        int j = MathHelper.floor_double(entityplayer.posX + RANGE);
        int k = MathHelper.floor_double(entityplayer.posY - RANGE);
        int l = MathHelper.floor_double(entityplayer.posY + RANGE);
        int i1 = MathHelper.floor_double(entityplayer.posZ - RANGE);
        int j1 = MathHelper.floor_double(entityplayer.posZ + RANGE);
        List list = world.getEntitiesWithinAABBExcludingEntity(entityplayer, AxisAlignedBB.getBoundingBoxFromPool(i, k, i1, j, l, j1));
        for(int k1 = 0; k1 < list.size(); k1++)
        {
            Entity entity = (Entity)list.get(k1);
			if(entity instanceof EntityLiving) {
				EntityLiving entityliving = (EntityLiving)entity;
				if(entityliving instanceof EntityMob || entityliving instanceof EntityFlying) {
					convertEntity(itemstack, entityplayer, entityliving);
				}
			}
        }
    }
	
    public void convertEntity(ItemStack itemstack, EntityPlayer entityplayer, EntityLiving entityliving)
    {
		World world = entityliving.worldObj;
		String s = getRandomPassiveMob();
		EntityLiving entityliving1 = (EntityLiving)EntityList.createEntityInWorld(s, world);
		if(entityliving1 == null)
		{
			return;
		} else
		{
			double d = entityliving.posX;
			double d1 = entityliving.posY;
			double d2 = entityliving.posZ;
			entityliving1.setLocationAndAngles(d, d1, d2, world.rand.nextFloat() * 360F, 0.0F);
			world.entityJoinedWorld(entityliving1);
			entityliving1.spawnExplosionParticle();
			
			entityliving.unusedEntityMethod();
			entityliving.setEntityDead();
			
			for(int j = 0; j < 20; j++)
			{
				double d3 = world.rand.nextGaussian() * 0.02D;
				double d4 = world.rand.nextGaussian() * 0.02D;
				double d5 = world.rand.nextGaussian() * 0.02D;
				world.spawnParticle("heart", entityliving1.posX + (double)(world.rand.nextFloat() * entityliving1.width), entityliving1.posY + (double)(world.rand.nextFloat() * entityliving1.height), entityliving1.posZ + (double)(world.rand.nextFloat() * entityliving1.width),d3,d4,d5);
			}
			
			entityplayer.swingItem();
			itemstack.damageItem(1, null);
			return;
		}
    }

    public String getRandomPassiveMob()
    {
        Random random = new Random();
        int i = random.nextInt(5);
        if(i == 0)
        {
            return "Chicken";
        }
        if(i == 1)
        {
            return "Cow";
        }
        if(i == 2)
        {
            return "Sheep";
        }
        if(i == 3)
        {
            return "Pig";
        }
        if(i == 4)
        {
            return "Squid";
        } else
        {
            return "";
        }
    }
}
