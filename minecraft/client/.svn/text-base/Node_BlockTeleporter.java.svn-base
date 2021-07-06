package net.minecraft.src;

import java.util.Random;
import java.util.List;

public class Node_BlockTeleporter extends Block
{

    public Node_BlockTeleporter(int i, int[] tex)
    {
        super(i, 0, Material.glass);
        setTickOnLoad(true);
		texAry = tex;
		lastTP = 0;
		isRunning = false;
    }
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
		if(isRunning) {
			mod_Node_PackLoader.trace("Detected race condition.");
			return false;
		}
		
		isRunning = true;
		
		ItemStack is = entityplayer.getCurrentEquippedItem();
		if(is == null) {
			isRunning = false;
			return false;
		}
		
		Item gem = is.getItem();
		int type = 0;
		
		if(ModLoader.isModLoaded("mod_Node_CrystalPack")) {
			if(gem.shiftedIndex == mod_Node_CrystalPack.gemRed.shiftedIndex) {
				type = 1;
			} else if(gem.shiftedIndex == mod_Node_CrystalPack.gemBlue.shiftedIndex) {
				type = 2;
			} else if(gem.shiftedIndex == mod_Node_CrystalPack.gemGreen.shiftedIndex) {
				type = 3;
			} else if(gem.shiftedIndex == mod_Node_CrystalPack.gemPurple.shiftedIndex) {
				type = 4;
			} else if(gem.shiftedIndex == mod_Node_CrystalPack.gemYellow.shiftedIndex) {
				type = 5;
			} else if(gem.shiftedIndex == mod_Node_CrystalPack.gemWhite.shiftedIndex) {
				type = 6;
			} else if(gem.shiftedIndex == mod_Node_CrystalPack.gemTainted.shiftedIndex) {
				type = 7;
			} else {
				isRunning = false;
				return false;
			}
		} else {
			int dmg = is.getItemDamage();
			if(gem.shiftedIndex == Item.dyePowder.shiftedIndex) {
				if(dmg == 1) {
					type = 1;
				} else if(dmg == 4) {
					type = 2;
				} else if(dmg == 2) {
					type = 3;
				} else if(dmg == 5) {
					type = 4;
				} else if(dmg == 11) {
					type = 5;
				} else if(dmg == 15) {
					type = 6;
				} else if(dmg == 8) {
					type = 7;
				} else {
					pk.chatInfo("\247EThat colour dye is not a teleporter key.");
				}
			} else {
				isRunning = false;
				return false;
			}
		}
		
		if(lastTP == 0) {
			lastTP = world.getWorldTime() - 30;
		}
		if(world.getWorldTime() - lastTP < 25) {
			pk.chatInfo("\247EYou must wait a bit longer before you can teleport again.");
			isRunning = false;
			return false;
		}
		
		Node_NodeReceiver rec = pk.findNearestTP(i,j,k,type);
		
		if(rec != null) {
			teleport(world,entityplayer,i,j,k,rec);
			isRunning = false;
			return true;
		} else {
			pk.chatInfo("\247ENo receiver of matching colour found.");
		}
		
		isRunning = false;
		return false;
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
			
			//if it's a receiver
			if(l > 0) {
				//write new receiver into receiver log
				pk.addReceiver(i,j,k,l);
			}
		}
    }
	
	public void onBlockRemoval(World world, int i, int j, int k) {
		//delete receiver from receiver log
		pk.deleteReceiver(i,j,k);
		
	}

	
	public void teleport(World world, EntityPlayer entityplayer, int i, int j, int k, Node_NodeReceiver rec) {
		//precalculate the players displacement
		double xd = entityplayer.posX;
		double yd = entityplayer.posY;
		double zd = entityplayer.posZ;
		
		lastTP = world.getWorldTime();
		List list = world.getEntitiesWithinAABBExcludingEntity(null, AxisAlignedBB.getBoundingBoxFromPool(i-rad, j-rad, k-rad, i+rad, j+rad, k+rad));
		for(int k1 = 0; k1 < list.size(); k1++)
		{
			Entity entity = (Entity)list.get(k1);
			
			//find distance to receiver
			double xdist = i - entity.posX;
			double ydist = j - entity.posY;
			double zdist = k - entity.posZ;
			mod_Node_PackLoader.trace("xdist: "+xdist);
			mod_Node_PackLoader.trace("ydist: "+ydist);
			mod_Node_PackLoader.trace("zdist: "+zdist);
			
			if(Math.abs(xdist) > rad || Math.abs(ydist) > rad || Math.abs(zdist) > rad) {
				mod_Node_PackLoader.trace("Detected race condition.");
				continue;
			}
			
			mod_Node_PackLoader.trace("moving entity: "+entity);
			
			//set the new position of the entity;
			entity.setPosition(rec.x-xdist, rec.y-ydist, rec.z-zdist);
		}
		
		//create particles
		showParticleFX(world, rec.x, rec.y, rec.z);
		
		//play sound
		world.playSoundEffect((double)rec.x + 0.5D, (double)rec.y + 0.5D, (double)rec.z + 0.5D, "portal.travel", 1.0F, 0.5F * 0.4F + 0.8F);
	}
	
	
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return texAry[j];
    }
	
	void showParticleFX(World world, int x, int y, int z)
    {
        String s = "portal";
		
		Random rand = new Random();
		
        for(int i = 0; i < 60; i++)
        {
            double d = rand.nextGaussian()*0.5D;
            double d1 = rand.nextGaussian()*0.5D;
            double d2 = rand.nextGaussian()*0.5D;
			int width = 5;
			int height = 3;
            world.spawnParticle(s, (x + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, y + (double)(rand.nextGaussian() * height), (z + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
        }

    }
	
	int[] texAry;
	int rad = 5;
	public static mod_Node_TeleporterPack pk;
	public static long lastTP;
	public static boolean isRunning;
}
