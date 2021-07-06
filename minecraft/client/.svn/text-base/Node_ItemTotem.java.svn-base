package net.minecraft.src;

public class Node_ItemTotem extends Item
{

    protected Node_ItemTotem(int i, int k)
    {
        super(i);
        setMaxDamage(k);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		entityplayer.swingItem();
		
		spawnFriendlyWolf(world, entityplayer);
		
		itemstack.damageItem(1, null);
		
        return itemstack;
    }

    public boolean isFull3D()
    {
        return true;
    }
	
	public void spawnFriendlyWolf(World world, EntityPlayer ep) {
		
		EntityWolf entityW = new EntityWolf(world);
		
		for(int i=0; i<25; i++) {			
			
			double d6 = (double)ep.posX + (world.rand.nextDouble() - world.rand.nextDouble()) * 2D;
			double d7 = (ep.posY + world.rand.nextInt(3)) - 1;
			double d8 = (double)ep.posZ + (world.rand.nextDouble() - world.rand.nextDouble()) * 2D;
			
			entityW.setLocationAndAngles(d6, d7, d8, world.rand.nextFloat() * 360F, 0.0F);
			
			
			
			if(!world.checkIfAABBIsClear(entityW.boundingBox) && world.getCollidingBoundingBoxes(entityW, entityW.boundingBox).size() == 0 && !world.getIsAnyLiquid(entityW.boundingBox))
			{
				System.out.println("cant spawn");
				continue;
			}
			
			world.entityJoinedWorld(entityW);
			entityW.spawnExplosionParticle();
			
			entityW.setWolfTamed(true);
			entityW.setPathToEntity(null);
			entityW.setWolfSitting(true);
			entityW.health = 20;
			entityW.setWolfOwner(ep.username);
			entityW.showHeartsOrSmokeFX(true);
			world.func_9425_a(entityW, (byte)7);
			
			break;
		}
	}

    private int field_25038_heal;
    private int field_25037_uses;
}
