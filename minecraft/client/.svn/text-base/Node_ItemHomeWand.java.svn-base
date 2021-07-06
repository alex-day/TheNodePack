package net.minecraft.src;

public class Node_ItemHomeWand extends Item
{

    protected Node_ItemHomeWand(int i, int k)
    {
        super(i);
        setMaxDamage(k);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.swingItem();
        returnToSpawn(world,entityplayer);
		
		world.playSoundEffect((double)entityplayer.posX + 0.5D, (double)entityplayer.posY + 0.5D, (double)entityplayer.posZ + 0.5D, "portal.travel", 1.0F, 0.5F * 0.4F + 0.8F);
		
		for(int j = 0; j < 20; j++)
		{
				double d3 = world.rand.nextGaussian() * 0.2D;
				double d4 = world.rand.nextFloat() * 0.2D;
				double d5 = world.rand.nextGaussian() * 0.2D;
				world.spawnParticle("portal", entityplayer.posX + (double)(world.rand.nextGaussian() * entityplayer.width), entityplayer.posY + (double)(world.rand.nextGaussian() * entityplayer.height), entityplayer.posZ + (double)(world.rand.nextGaussian() * entityplayer.width),d3,d4,d5);
		}
				
        itemstack.damageItem(1, null);
		
        return itemstack;
    }
	
	public void returnToSpawn(World world, EntityPlayer thePlayer) {
		if(!world.worldProvider.canRespawnHere())
        {
            ModLoader.getMinecraftInstance().usePortal();
        }
		ChunkCoordinates chunkcoordinates = world.getSpawnPoint();
        //thePlayer.setPlayerSpawnCoordinate(chunkcoordinates);
        thePlayer.setLocationAndAngles((float)chunkcoordinates.x + 0.5F, (float)chunkcoordinates.y + 0.1F, (float)chunkcoordinates.z + 0.5F, 0.0F, 0.0F);
	}
	
    public boolean isFull3D()
    {
        return true;
    }
	
}