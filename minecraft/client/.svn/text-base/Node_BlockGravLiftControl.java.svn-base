package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class Node_BlockGravLiftControl extends Block
{

    protected Node_BlockGravLiftControl(int i, int j)
    {
        super(i, 45, Material.rock);
        tex = j;
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	boolean isActive = isActive(world,i,j,k);
        createLift(world, i, j, k, !isActive);
        setActive(world, i, j, k, !isActive);
        return true;
    }
    
    public boolean isActive(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        mod_Node_PackLoader.trace((new StringBuilder()).append("Checking active status with l: ").append(l).append(" and l/10: ").append(l / 10).toString());
        return l / 10 == 1;
    }

    public void setActive(World world, int i, int j, int k, boolean isActive)
    {
        int l = world.getBlockMetadata(i, j, k);
        mod_Node_PackLoader.trace((new StringBuilder()).append("Setting active status to ").append(isActive).append(" with l: ").append(l).append(" and l%10: ").append(l % 10).toString());
        if(isActive(world, i, j, k))
        {
            if(!isActive)
            {
                l %= 10;
            }
        } else
        if(isActive)
        {
            l = 10 + l;
        }
        mod_Node_PackLoader.trace((new StringBuilder()).append("Setting status to: ").append(l).toString());
        world.setBlockMetadataWithNotify(i, j, k, l);
    }

    public void reverseLift(World world, int i, int j, int k) {
    	int gravLiftRange = mod_Node_PackLoader.getIntOption("GravRange");
        for(int l = 1; l < gravLiftRange; l++)
        {
		    int i1 = world.getBlockMetadata(i, j, k);
	        if(i1 % 10 == 1)
	        {
	            if(world.getBlockId(i, j - l, k) != mod_Node_GravLift.blockGravLift.blockID)
	            {
	                break;
	            }
	            mod_Node_PackLoader.trace((new StringBuilder()).append("Changing Gravlift at [").append(i).append(",").append(j - l).append(",").append(k).append("]").toString());
	            int meta = world.getBlockMetadata(i, j - l, k);
	            Node_TileEntityGravLift tileentitygravlift = (Node_TileEntityGravLift) world.getBlockTileEntity(i, j - l, k);
	            
	            System.out.println("meta was: "+meta);
	            
	            if(meta == 0) {
	            	world.setBlockMetadataWithNotify(i, j - l, k, 1);
	            	//tileentitygravlift.setDirUp(1);
	            } else {
	            	world.setBlockMetadataWithNotify(i, j - l, k, 0);
	            	//tileentitygravlift.setDirUp(0);
	            }
	            
	            
	            world.setBlockTileEntity(i, j - l, k, tileentitygravlift);
	            continue;
	        }
	        if(world.getBlockId(i, j + l, k) != mod_Node_GravLift.blockGravLift.blockID)
	        {
	            break;
	        }
	        mod_Node_PackLoader.trace((new StringBuilder()).append("Changing Gravlift at [").append(i).append(",").append(j + l).append(",").append(k).append("]").toString());
	        int meta = world.getBlockMetadata(i, j + l, k);
	        Node_TileEntityGravLift tileentitygravlift = (Node_TileEntityGravLift) world.getBlockTileEntity(i, j + l, k);
	        
	        System.out.println("meta was: "+meta);
	        
	        if(meta == 0) {
            	world.setBlockMetadataWithNotify(i, j + l, k, 1);
            	//tileentitygravlift.setDirUp(1);
            } else {
            	world.setBlockMetadataWithNotify(i, j + l, k, 0);
            	//tileentitygravlift.setDirUp(0);
            }
	        
	        continue;
	    }
    }
    
    public void createLift(World world, int i, int j, int k, boolean makeBridge)
    {
        int gravLiftRange = mod_Node_PackLoader.getIntOption("GravRange");
        for(int l = 1; l < gravLiftRange; l++)
        {
            int i1 = world.getBlockMetadata(i, j, k);
            if(makeBridge)
            {
                Node_TileEntityGravLift tileentitygravlift = new Node_TileEntityGravLift();
                tileentitygravlift.setDaddy(i, j, k);
                if(i1 % 10 == 1)
                {
                    if(!world.isAirBlock(i, j - l, k))
                    {
                        break;
                    }
                    mod_Node_PackLoader.trace((new StringBuilder()).append("Creating Gravlift at [").append(i).append(",").append(j - l).append(",").append(k).append("]").toString());
                    world.setBlockAndMetadataWithNotify(i, j - l, k, mod_Node_GravLift.blockGravLift.blockID, 1);
                    tileentitygravlift.setDirUp(1);
                    world.setBlockTileEntity(i, j - l, k, tileentitygravlift);
                    continue;
                }
                if(!world.isAirBlock(i, j + l, k))
                {
                    break;
                }
                mod_Node_PackLoader.trace((new StringBuilder()).append("Creating Gravlift at [").append(i).append(",").append(j + l).append(",").append(k).append("]").toString());
                world.setBlockAndMetadataWithNotify(i, j + l, k, mod_Node_GravLift.blockGravLift.blockID, 0);
                tileentitygravlift.setDirUp(0);
                world.setBlockTileEntity(i, j + l, k, tileentitygravlift);
                continue;
            }
            if(i1 % 10 == 1)
            {
                if(world.getBlockId(i, j - l, k) != mod_Node_GravLift.blockGravLift.blockID)
                {
                    break;
                }
                mod_Node_PackLoader.trace((new StringBuilder()).append("Destroying GravLift at [").append(i).append(",").append(j - l).append(",").append(k).append("]").toString());
                world.setBlockWithNotify(i, j - l, k, 0);
                continue;
            }
            if(world.getBlockId(i, j + l, k) != mod_Node_GravLift.blockGravLift.blockID)
            {
                break;
            }
            mod_Node_PackLoader.trace((new StringBuilder()).append("Destroying GravLift at [").append(i).append(",").append(j + l).append(",").append(k).append("]").toString());
            world.setBlockWithNotify(i, j + l, k, 0);
        }

    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(l > 0 && Block.blocksList[l].canProvidePower())
        {
            boolean isBeingPowered = world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k);
            System.out.println("is block being powered? "+isBeingPowered);
            if(isBeingPowered)
            {
                if(isActive(world, i, j, k))
                {
                    //mod_Node_PackLoader.trace("Bridge block is deactivated. Activating...");
                    //createLift(world, i, j, k, true);
                    //setActive(world, i, j, k, true);
                    //mod_Node_PackLoader.trace("Bridge block is now activated.");
                	System.out.println("is active reversing lift");
                	reverseLift(world, i, j, k);
                }
            } else
            if(isActive(world, i, j, k))
            {
                //mod_Node_PackLoader.trace("Bridge block is activated. Deactivating...");
                //createLift(world, i, j, k, false);
                //setActive(world, i, j, k, false);
                //mod_Node_PackLoader.trace("Bridge block is now deactivated.");
            	//System.out.println("is active reversing lift");
                //reverseLift(world, i, j, k);
            }
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        super.onBlockRemoval(world, i, j, k);
        if(isActive(world, i, j, k))
        {
            mod_Node_PackLoader.trace("Bridge block is activated. Deactivating...");
            createLift(world, i, j, k, false);
            setActive(world, i, j, k, false);
            mod_Node_PackLoader.trace("Bridge block is now deactivated.");
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 1)
        {
            if(j % 10 == 1)
            {
                return blockIndexInTexture + 17;
            } else
            {
                return tex;
            }
        }
        if(i == 0)
        {
            if(j % 10 == 1)
            {
                return tex;
            } else
            {
                return blockIndexInTexture + 17;
            }
        } else
        {
            return blockIndexInTexture;
        }
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        if(l == 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        world.setBlockMetadataWithNotify(i, j, k, i1);
    }

    private int tex;
}
