// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Material, IBlockAccess, AxisAlignedBB, EntityPlayer, 
//            World, EntityItem, ItemStack, Vec3D, 
//            MovingObjectPosition, StatList, StatCollector, StepSound, 
//            StepSoundStone, StepSoundSand, BlockStone, BlockGrass, 
//            BlockDirt, BlockSapling, BlockFlowing, BlockStationary, 
//            BlockSand, BlockGravel, BlockOre, BlockLog, 
//            BlockLeaves, BlockSponge, BlockGlass, BlockDispenser, 
//            BlockSandStone, BlockNote, BlockBed, BlockRail, 
//            BlockDetectorRail, BlockWeb, BlockTallGrass, BlockDeadBush, 
//            BlockCloth, BlockFlower, BlockMushroom, BlockOreStorage, 
//            BlockStep, BlockTNT, BlockBookshelf, BlockObsidian, 
//            BlockTorch, BlockFire, BlockMobSpawner, BlockStairs, 
//            BlockChest, BlockRedstoneWire, BlockWorkbench, BlockCrops, 
//            BlockFarmland, BlockFurnace, BlockSign, TileEntitySign, 
//            BlockDoor, BlockLadder, BlockLever, BlockPressurePlate, 
//            EnumMobType, BlockRedstoneOre, BlockRedstoneTorch, BlockButton, 
//            BlockSnow, BlockIce, BlockSnowBlock, BlockCactus, 
//            BlockClay, BlockReed, BlockJukeBox, BlockFence, 
//            BlockPumpkin, BlockNetherrack, BlockSoulSand, BlockGlowStone, 
//            BlockPortal, BlockCake, BlockRedstoneRepeater, BlockLockedChest, 
//            BlockTrapDoor, Item, ItemCloth, ItemLog, 
//            ItemSlab, ItemSapling, ItemBlock, Entity, 
//            EntityLiving

public class Block
{

    protected Block(int i, Material material)
    {
    	blockWorth = 1;
        field_27024_bo = true;
        enableStats = true;
        stepSound = soundPowderFootstep;
        blockParticleGravity = 1.0F;
        slipperiness = 0.6F;
        if(blocksList[i] != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Slot ").append(i).append(" is already occupied by ").append(blocksList[i]).append(" when adding ").append(this).toString());
        } else
        {
            blockMaterial = material;
            blocksList[i] = this;
            blockID = i;
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            opaqueCubeLookup[i] = isOpaqueCube();
            lightOpacity[i] = isOpaqueCube() ? 255 : 0;
            field_537_s[i] = !material.getCanBlockGrass();
            isBlockContainer[i] = false;
            return;
        }
    }

    private Block func_28027_k()
    {
        field_28029_t[blockID] = true;
        return this;
    }

    protected void func_28028_f()
    {
    }

    protected Block(int i, int j, Material material)
    {
        this(i, material);
        blockIndexInTexture = j;
    }

    protected Block setStepSound(StepSound stepsound)
    {
        stepSound = stepsound;
        return this;
    }

    protected Block setLightOpacity(int i)
    {
        lightOpacity[blockID] = i;
        return this;
    }

    protected Block setLightValue(float f)
    {
        lightValue[blockID] = (int)(15F * f);
        return this;
    }

    protected Block setResistance(float f)
    {
        blockResistance = f * 3F;
        return this;
    }
    
    protected Block setBlockWorth(int value)
    {
        blockWorth = value;
        return this;
    }

    public boolean func_28025_b()
    {
        return true;
    }

    protected Block setHardness(float f)
    {
        blockHardness = f;
        if(blockResistance < f * 5F)
        {
            blockResistance = f * 5F;
        }
        return this;
    }

    protected Block setTickOnLoad(boolean flag)
    {
        tickOnLoad[blockID] = flag;
        return this;
    }

    public void setBlockBounds(float f, float f1, float f2, float f3, float f4, float f5)
    {
        minX = f;
        minY = f1;
        minZ = f2;
        maxX = f3;
        maxY = f4;
        maxZ = f5;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return iblockaccess.getBlockMaterial(i, j, k).isSolid();
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return getBlockTextureFromSide(i);
    }

    public int getBlockTextureFromSide(int i)
    {
        return blockIndexInTexture;
    }

    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        AxisAlignedBB axisalignedbb1 = getCollisionBoundingBoxFromPool(world, i, j, k);
        if(axisalignedbb1 != null && axisalignedbb.intersectsWith(axisalignedbb1))
        {
            arraylist.add(axisalignedbb1);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return AxisAlignedBB.getBoundingBoxFromPool((double)i + minX, (double)j + minY, (double)k + minZ, (double)i + maxX, (double)j + maxY, (double)k + maxZ);
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public boolean canCollideCheck(int i, boolean flag)
    {
        return isCollidable();
    }

    public boolean isCollidable()
    {
        return true;
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
    }

    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
    {
    	
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
    }

    public int tickRate()
    {
        return 10;
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random)
    {
        return blockID;
    }

    public float blockStrength(EntityPlayer entityplayer)
    {
        if(blockHardness < 0.0F)
        {
            return 0.0F;
        }
        if(!entityplayer.canHarvestBlock(this))
        {
            return 1.0F / blockHardness / 100F;
        } else
        {
            return entityplayer.getCurrentPlayerStrVsBlock(this) / blockHardness / 30F;
        }
    }

    public void dropBlockAsItem(World world, int i, int j, int k, int l)
    {
        dropBlockAsItemWithChance(world, i, j, k, l, 1.0F);
    }

    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f)
    {
        if(world.singleplayerWorld)
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
                EntityItem entityitem = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, new ItemStack(k1, 1, damageDropped(l)));
                entityitem.delayBeforeCanPickup = 10;
                world.entityJoinedWorld(entityitem);
            }
        }

    }

    protected int damageDropped(int i)
    {
        return 0;
    }

    public float getExplosionResistance(Entity entity)
    {
        return blockResistance / 5F;
    }

    public MovingObjectPosition collisionRayTrace(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        setBlockBoundsBasedOnState(world, i, j, k);
        vec3d = vec3d.addVector(-i, -j, -k);
        vec3d1 = vec3d1.addVector(-i, -j, -k);
        Vec3D vec3d2 = vec3d.getIntermediateWithXValue(vec3d1, minX);
        Vec3D vec3d3 = vec3d.getIntermediateWithXValue(vec3d1, maxX);
        Vec3D vec3d4 = vec3d.getIntermediateWithYValue(vec3d1, minY);
        Vec3D vec3d5 = vec3d.getIntermediateWithYValue(vec3d1, maxY);
        Vec3D vec3d6 = vec3d.getIntermediateWithZValue(vec3d1, minZ);
        Vec3D vec3d7 = vec3d.getIntermediateWithZValue(vec3d1, maxZ);
        if(!isVecInsideYZBounds(vec3d2))
        {
            vec3d2 = null;
        }
        if(!isVecInsideYZBounds(vec3d3))
        {
            vec3d3 = null;
        }
        if(!isVecInsideXZBounds(vec3d4))
        {
            vec3d4 = null;
        }
        if(!isVecInsideXZBounds(vec3d5))
        {
            vec3d5 = null;
        }
        if(!isVecInsideXYBounds(vec3d6))
        {
            vec3d6 = null;
        }
        if(!isVecInsideXYBounds(vec3d7))
        {
            vec3d7 = null;
        }
        Vec3D vec3d8 = null;
        if(vec3d2 != null && (vec3d8 == null || vec3d.distanceTo(vec3d2) < vec3d.distanceTo(vec3d8)))
        {
            vec3d8 = vec3d2;
        }
        if(vec3d3 != null && (vec3d8 == null || vec3d.distanceTo(vec3d3) < vec3d.distanceTo(vec3d8)))
        {
            vec3d8 = vec3d3;
        }
        if(vec3d4 != null && (vec3d8 == null || vec3d.distanceTo(vec3d4) < vec3d.distanceTo(vec3d8)))
        {
            vec3d8 = vec3d4;
        }
        if(vec3d5 != null && (vec3d8 == null || vec3d.distanceTo(vec3d5) < vec3d.distanceTo(vec3d8)))
        {
            vec3d8 = vec3d5;
        }
        if(vec3d6 != null && (vec3d8 == null || vec3d.distanceTo(vec3d6) < vec3d.distanceTo(vec3d8)))
        {
            vec3d8 = vec3d6;
        }
        if(vec3d7 != null && (vec3d8 == null || vec3d.distanceTo(vec3d7) < vec3d.distanceTo(vec3d8)))
        {
            vec3d8 = vec3d7;
        }
        if(vec3d8 == null)
        {
            return null;
        }
        byte byte0 = -1;
        if(vec3d8 == vec3d2)
        {
            byte0 = 4;
        }
        if(vec3d8 == vec3d3)
        {
            byte0 = 5;
        }
        if(vec3d8 == vec3d4)
        {
            byte0 = 0;
        }
        if(vec3d8 == vec3d5)
        {
            byte0 = 1;
        }
        if(vec3d8 == vec3d6)
        {
            byte0 = 2;
        }
        if(vec3d8 == vec3d7)
        {
            byte0 = 3;
        }
        return new MovingObjectPosition(i, j, k, byte0, vec3d8.addVector(i, j, k));
    }

    private boolean isVecInsideYZBounds(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.yCoord >= minY && vec3d.yCoord <= maxY && vec3d.zCoord >= minZ && vec3d.zCoord <= maxZ;
        }
    }

    private boolean isVecInsideXZBounds(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.xCoord >= minX && vec3d.xCoord <= maxX && vec3d.zCoord >= minZ && vec3d.zCoord <= maxZ;
        }
    }

    private boolean isVecInsideXYBounds(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.xCoord >= minX && vec3d.xCoord <= maxX && vec3d.yCoord >= minY && vec3d.yCoord <= maxY;
        }
    }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
    }

    public boolean func_28026_e(World world, int i, int j, int k, int l)
    {
        return canPlaceBlockAt(world, i, j, k);
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        int l = world.getBlockId(i, j, k);
        return l == 0 || blocksList[l].blockMaterial.func_27090_g();
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        return false;
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    }

    public void velocityToAddToEntity(World world, int i, int j, int k, Entity entity, Vec3D vec3d)
    {
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
    }

    public boolean isPoweringTo(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return false;
    }

    public boolean canProvidePower()
    {
        return false;
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
    }

    public boolean isIndirectlyPoweringTo(World world, int i, int j, int k, int l)
    {
        return false;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        entityplayer.addNodeScore(blockWorth);
        dropBlockAsItem(world, i, j, k, l);
    }

    public boolean canBlockStay(World world, int i, int j, int k)
    {
        return true;
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
    }

    public Block setBlockName(String s)
    {
        blockName = (new StringBuilder()).append("tile.").append(s).toString();
        return this;
    }

    public String func_25012_e()
    {
        return StatCollector.translateToLocal((new StringBuilder()).append(getBlockName()).append(".name").toString());
    }

    public String getBlockName()
    {
        return blockName;
    }

    public void playBlock(World world, int i, int j, int k, int l, int i1)
    {
    }

    public boolean getEnableStats()
    {
        return enableStats;
    }

    protected Block disableStats()
    {
        enableStats = false;
        return this;
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public static final StepSound soundPowderFootstep;
    public static final StepSound soundWoodFootstep;
    public static final StepSound soundGravelFootstep;
    public static final StepSound soundGrassFootstep;
    public static final StepSound soundStoneFootstep;
    public static final StepSound soundMetalFootstep;
    public static final StepSound soundGlassFootstep;
    public static final StepSound soundClothFootstep;
    public static final StepSound soundSandFootstep;
    public static final Block blocksList[] = new Block[256];;
    public static final boolean tickOnLoad[] = new boolean[256];
    public static final boolean opaqueCubeLookup[] = new boolean[256];
    public static final boolean isBlockContainer[] = new boolean[256];
    public static final int lightOpacity[] = new int[256];
    public static final boolean field_537_s[] = new boolean[256];
    public static final int lightValue[] = new int[256];
    public static final boolean field_28029_t[] = new boolean[256];
    public static final Block stone;
    public static final BlockGrass grass;
    public static final Block dirt;
    public static final Block cobblestone;
    public static final Block planks;
    public static final Block sapling;
    public static final Block bedrock;
    public static final Block waterMoving;
    public static final Block waterStill;
    public static final Block lavaMoving;
    public static final Block lavaStill;
    public static final Block sand;
    public static final Block gravel;
    public static final Block oreGold;
    public static final Block oreIron;
    public static final Block oreCoal;
    public static final Block wood;
    public static final BlockLeaves leaves;
    public static final Block sponge;
    public static final Block glass;
    public static final Block oreLapis;
    public static final Block blockLapis;
    public static final Block dispenser;
    public static final Block sandStone;
    public static final Block musicBlock;
    public static final Block bed;
    public static final Block railPowered;
    public static final Block railDetector;
    public static final Block field_9033_V = null;
    public static final Block web = (new BlockWeb(30, 11)).setBlockName("web");
    public static final BlockTallGrass field_9031_X;
    public static final BlockDeadBush field_9030_Y;
    public static final Block field_9029_Z = null;
    public static final Block field_9049_aa = null;
    public static final Block cloth;
    public static final Block field_9048_ac = null;
    public static final BlockFlower plantYellow;
    public static final BlockFlower plantRed;
    public static final BlockFlower mushroomBrown;
    public static final BlockFlower mushroomRed;
    public static final Block blockGold;
    public static final Block blockSteel;
    public static final Block stairDouble;
    public static final Block stairSingle;
    public static final Block brick;
    public static final Block tnt;
    public static final Block bookShelf;
    public static final Block cobblestoneMossy;
    public static final Block obsidian;
    public static final Block torchWood;
    public static final BlockFire fire;
    public static final Block mobSpawner;
    public static final Block stairCompactPlanks;
    public static final Block chest;
    public static final Block redstoneWire;
    public static final Block oreDiamond;
    public static final Block blockDiamond;
    public static final Block workbench;
    public static final Block crops;
    public static final Block tilledField;
    public static final Block stoneOvenIdle;
    public static final Block stoneOvenActive;
    public static final Block signPost;
    public static final Block doorWood;
    public static final Block ladder;
    public static final Block minecartTrack;
    public static final Block stairCompactCobblestone;
    public static final Block signWall;
    public static final Block lever;
    public static final Block pressurePlateStone;
    public static final Block doorSteel;
    public static final Block pressurePlatePlanks;
    public static final Block oreRedstone;
    public static final Block oreRedstoneGlowing;
    public static final Block torchRedstoneIdle;
    public static final Block torchRedstoneActive;
    public static final Block button;
    public static final Block snow;
    public static final Block ice;
    public static final Block blockSnow;
    public static final Block cactus;
    public static final Block blockClay;
    public static final Block reed;
    public static final Block jukebox;
    public static final Block fence;
    public static final Block pumpkin;
    public static final Block bloodStone;
    public static final Block slowSand;
    public static final Block lightStone;
    public static final BlockPortal portal;
    public static final Block pumpkinLantern;
    public static final Block cake;
    public static final Block redstoneRepeaterIdle;
    public static final Block redstoneRepeaterActive;
    public static final Block lockedChest;
    public static final Block field_28030_bl;
    
    /*
	 * ------------- START Node Pack ---------------
	 */
	public static Block illuminationTubeFloor;
    public static Block illuminationTubeRoof;
	public static Block dirtStairs;
    public static Block stoneStairs;
    public static Block snowStairs;
    public static Block glassStairs;
    public static Block ironStairs;
    public static Block goldStairs;
    public static Block diamondStairs;
    public static Block netherStairs;
    public static Block brickStairs;
	
	public static Block blockFluro;
    
	public static Block blockLaserBridge;
	public static Block blockLaserBridgeControl;
	/*
	 * ------------- END Node Pack ---------------
	 */
    
    public int blockIndexInTexture;
    public final int blockID;
    protected float blockHardness;
    protected float blockResistance;
    protected boolean field_27024_bo;
    protected boolean enableStats;
    protected int blockWorth;
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;
    public StepSound stepSound;
    public float blockParticleGravity;
    public final Material blockMaterial;
    public float slipperiness;
    private String blockName;

    static 
    {
    	bed = (new BlockBed(26)).setHardness(0.2F).setBlockName("bed").disableStats().func_28027_k();
    	musicBlock = (new BlockNote(25)).setHardness(0.8F).setBlockName("musicBlock").func_28027_k();
        soundPowderFootstep = new StepSound("stone", 1.0F, 1.0F);
        soundWoodFootstep = new StepSound("wood", 1.0F, 1.0F);
        soundGravelFootstep = new StepSound("gravel", 1.0F, 1.0F);
        soundGrassFootstep = new StepSound("grass", 1.0F, 1.0F);
        soundStoneFootstep = new StepSound("stone", 1.0F, 1.0F);
        soundMetalFootstep = new StepSound("stone", 1.0F, 1.5F);
        soundGlassFootstep = new StepSoundStone("stone", 1.0F, 1.0F);
        soundClothFootstep = new StepSound("cloth", 1.0F, 1.0F);
        soundSandFootstep = new StepSoundSand("sand", 1.0F, 1.0F);
        stone = (new BlockStone(1, 1)).setHardness(1.5F).setResistance(10F).setStepSound(soundStoneFootstep).setBlockName("stone");
        grass = (BlockGrass)(new BlockGrass(2)).setHardness(0.6F).setStepSound(soundGrassFootstep).setBlockName("grass");
        dirt = (new BlockDirt(3, 2)).setHardness(0.5F).setStepSound(soundGravelFootstep).setBlockName("dirt");
        cobblestone = (new Block(4, 16, Material.rock)).setHardness(2.0F).setResistance(10F).setStepSound(soundStoneFootstep).setBlockName("stonebrick");
        planks = (new Block(5, 4, Material.wood)).setHardness(2.0F).setResistance(5F).setStepSound(soundWoodFootstep).setBlockName("wood").func_28027_k();
        sapling = (new BlockSapling(6, 15)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("sapling").func_28027_k();
        bedrock = (new Block(7, 17, Material.rock)).setHardness(-1F).setResistance(6000000F).setStepSound(soundStoneFootstep).setBlockName("bedrock").disableStats();
        waterMoving = (new BlockFlowing(8, Material.water)).setHardness(100F).setLightOpacity(3).setBlockName("water").disableStats().func_28027_k();
        waterStill = (new BlockStationary(9, Material.water)).setHardness(100F).setLightOpacity(3).setBlockName("water").disableStats().func_28027_k();
        lavaMoving = (new BlockFlowing(10, Material.lava)).setHardness(0.0F).setLightValue(1.0F).setLightOpacity(255).setBlockName("lava").disableStats().func_28027_k();
        lavaStill = (new BlockStationary(11, Material.lava)).setHardness(100F).setLightValue(1.0F).setLightOpacity(255).setBlockName("lava").disableStats().func_28027_k();
        sand = (new BlockSand(12, 18)).setHardness(0.5F).setStepSound(soundSandFootstep).setBlockName("sand");
        gravel = (new BlockGravel(13, 19)).setHardness(0.6F).setStepSound(soundGravelFootstep).setBlockName("gravel");
        oreGold = (new BlockOre(14, 32)).setHardness(3F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("oreGold").setBlockWorth(50);
        oreIron = (new BlockOre(15, 33)).setHardness(3F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("oreIron").setBlockWorth(20);
        oreCoal = (new BlockOre(16, 34)).setHardness(3F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("oreCoal").setBlockWorth(3);
        wood = (new BlockLog(17)).setHardness(2.0F).setStepSound(soundWoodFootstep).setBlockName("log").func_28027_k();
        leaves = (BlockLeaves)(new BlockLeaves(18, 52)).setHardness(0.2F).setLightOpacity(1).setStepSound(soundGrassFootstep).setBlockName("leaves").disableStats().func_28027_k();
        sponge = (new BlockSponge(19)).setHardness(0.6F).setStepSound(soundGrassFootstep).setBlockName("sponge");
        glass = (new BlockGlass(20, 49, Material.glass, false)).setHardness(0.3F).setStepSound(soundGlassFootstep).setBlockName("glass").setBlockWorth(3);
        oreLapis = (new BlockOre(21, 160)).setHardness(3F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("oreLapis").setBlockWorth(40);
        blockLapis = (new Block(22, 144, Material.rock)).setHardness(3F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("blockLapis").setBlockWorth(60);
        dispenser = (new BlockDispenser(23)).setHardness(3.5F).setStepSound(soundStoneFootstep).setBlockName("dispenser").func_28027_k().setBlockWorth(14);
        sandStone = (new BlockSandStone(24)).setStepSound(soundStoneFootstep).setHardness(0.8F).setBlockName("sandStone");
        railPowered = (new BlockRail(27, 179, true)).setHardness(0.7F).setStepSound(soundMetalFootstep).setBlockName("goldenRail").func_28027_k().setBlockWorth(75);
        railDetector = (new BlockDetectorRail(28, 195)).setHardness(0.7F).setStepSound(soundMetalFootstep).setBlockName("detectorRail").func_28027_k().setBlockWorth(75);
        field_9031_X = (BlockTallGrass)(new BlockTallGrass(31, 39)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("tallgrass");
        field_9030_Y = (BlockDeadBush)(new BlockDeadBush(32, 55)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("deadbush");
        cloth = (new BlockCloth()).setHardness(0.8F).setStepSound(soundClothFootstep).setBlockName("cloth").func_28027_k().setBlockWorth(2);
        plantYellow = (BlockFlower)(new BlockFlower(37, 13)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("flower").setBlockWorth(3);
        plantRed = (BlockFlower)(new BlockFlower(38, 12)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("rose").setBlockWorth(3);
        mushroomBrown = (BlockFlower)(new BlockMushroom(39, 29)).setHardness(0.0F).setStepSound(soundGrassFootstep).setLightValue(0.125F).setBlockName("mushroom").setBlockWorth(3);
        mushroomRed = (BlockFlower)(new BlockMushroom(40, 28)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("mushroom").setBlockWorth(3);
        blockGold = (new BlockOreStorage(41, 23)).setHardness(3F).setResistance(10F).setStepSound(soundMetalFootstep).setBlockName("blockGold").setBlockWorth(78);
        blockSteel = (new BlockOreStorage(42, 22)).setHardness(5F).setResistance(10F).setStepSound(soundMetalFootstep).setBlockName("blockIron").setBlockWorth(24);
        stairDouble = (new BlockStep(43, true)).setHardness(2.0F).setResistance(10F).setStepSound(soundStoneFootstep).setBlockName("stoneSlab").setBlockWorth(3);
        stairSingle = (new BlockStep(44, false)).setHardness(2.0F).setResistance(10F).setStepSound(soundStoneFootstep).setBlockName("stoneSlab").setBlockWorth(3);
        brick = (new Block(45, 7, Material.rock)).setHardness(2.0F).setResistance(10F).setStepSound(soundStoneFootstep).setBlockName("brick").setBlockWorth(60);
        tnt = (new BlockTNT(46, 8)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("tnt");
        bookShelf = (new BlockBookshelf(47, 35)).setHardness(1.5F).setStepSound(soundWoodFootstep).setBlockName("bookshelf").setBlockWorth(15);
        cobblestoneMossy = (new Block(48, 36, Material.rock)).setHardness(2.0F).setResistance(10F).setStepSound(soundStoneFootstep).setBlockName("stoneMoss").setBlockWorth(34);
        obsidian = (new BlockObsidian(49, 37)).setHardness(10F).setResistance(2000F).setStepSound(soundStoneFootstep).setBlockName("obsidian").setBlockWorth(30);
        torchWood = (new BlockTorch(50, 80)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(soundWoodFootstep).setBlockName("torch").func_28027_k().setBlockWorth(2);
        fire = (BlockFire)(new BlockFire(51, 31)).setHardness(0.0F).setLightValue(1.0F).setStepSound(soundWoodFootstep).setBlockName("fire").disableStats().func_28027_k();
        mobSpawner = (new BlockMobSpawner(52, 65)).setHardness(5F).setStepSound(soundMetalFootstep).setBlockName("mobSpawner").disableStats();
        stairCompactPlanks = (new BlockStairs(53, planks)).setBlockName("stairsWood").func_28027_k();
        chest = (new BlockChest(54)).setHardness(2.5F).setStepSound(soundWoodFootstep).setBlockName("chest").func_28027_k().setBlockWorth(2);
        redstoneWire = (new BlockRedstoneWire(55, 164)).setHardness(0.0F).setStepSound(soundPowderFootstep).setBlockName("redstoneDust").disableStats().func_28027_k();
        oreDiamond = (new BlockOre(56, 50)).setHardness(3F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("oreDiamond").setBlockWorth(100);
        blockDiamond = (new BlockOreStorage(57, 24)).setHardness(5F).setResistance(10F).setStepSound(soundMetalFootstep).setBlockName("blockDiamond").setBlockWorth(10);
        workbench = (new BlockWorkbench(58)).setHardness(2.5F).setStepSound(soundWoodFootstep).setBlockName("workbench").setBlockWorth(2);
        crops = (new BlockCrops(59, 88)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("crops").disableStats().func_28027_k();
        tilledField = (new BlockFarmland(60)).setHardness(0.6F).setStepSound(soundGravelFootstep).setBlockName("farmland");
        stoneOvenIdle = (new BlockFurnace(61, false)).setHardness(3.5F).setStepSound(soundStoneFootstep).setBlockName("furnace").func_28027_k();
        stoneOvenActive = (new BlockFurnace(62, true)).setHardness(3.5F).setStepSound(soundStoneFootstep).setLightValue(0.875F).setBlockName("furnace").func_28027_k().setBlockWorth(2);
        signPost = (new BlockSign(63, net.minecraft.src.TileEntitySign.class, true)).setHardness(1.0F).setStepSound(soundWoodFootstep).setBlockName("sign").disableStats().func_28027_k().setBlockWorth(2);
        doorWood = (new BlockDoor(64, Material.wood)).setHardness(3F).setStepSound(soundWoodFootstep).setBlockName("doorWood").disableStats().func_28027_k().setBlockWorth(2);
        ladder = (new BlockLadder(65, 83)).setHardness(0.4F).setStepSound(soundWoodFootstep).setBlockName("ladder").func_28027_k().setBlockWorth(2);
        minecartTrack = (new BlockRail(66, 128, false)).setHardness(0.7F).setStepSound(soundMetalFootstep).setBlockName("rail").func_28027_k().setBlockWorth(3);
        stairCompactCobblestone = (new BlockStairs(67, cobblestone)).setBlockName("stairsStone").func_28027_k();
        signWall = (new BlockSign(68, net.minecraft.src.TileEntitySign.class, false)).setHardness(1.0F).setStepSound(soundWoodFootstep).setBlockName("sign").disableStats().func_28027_k().setBlockWorth(2);
        lever = (new BlockLever(69, 96)).setHardness(0.5F).setStepSound(soundWoodFootstep).setBlockName("lever").func_28027_k();
        pressurePlateStone = (new BlockPressurePlate(70, stone.blockIndexInTexture, EnumMobType.mobs, Material.rock)).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("pressurePlate").func_28027_k().setBlockWorth(5);
        doorSteel = (new BlockDoor(71, Material.iron)).setHardness(5F).setStepSound(soundMetalFootstep).setBlockName("doorIron").disableStats().func_28027_k().setBlockWorth(3);
        pressurePlatePlanks = (new BlockPressurePlate(72, planks.blockIndexInTexture, EnumMobType.everything, Material.wood)).setHardness(0.5F).setStepSound(soundWoodFootstep).setBlockName("pressurePlate").func_28027_k().setBlockWorth(5);
        oreRedstone = (new BlockRedstoneOre(73, 51, false)).setHardness(3F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("oreRedstone").func_28027_k().setBlockWorth(35);
        oreRedstoneGlowing = (new BlockRedstoneOre(74, 51, true)).setLightValue(0.625F).setHardness(3F).setResistance(5F).setStepSound(soundStoneFootstep).setBlockName("oreRedstone").func_28027_k().setBlockWorth(35);
        torchRedstoneIdle = (new BlockRedstoneTorch(75, 115, false)).setHardness(0.0F).setStepSound(soundWoodFootstep).setBlockName("notGate").func_28027_k().setBlockWorth(10);
        torchRedstoneActive = (new BlockRedstoneTorch(76, 99, true)).setHardness(0.0F).setLightValue(0.5F).setStepSound(soundWoodFootstep).setBlockName("notGate").func_28027_k().setBlockWorth(10);
        button = (new BlockButton(77, stone.blockIndexInTexture)).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("button").func_28027_k().setBlockWorth(3);
        snow = (new BlockSnow(78, 66)).setHardness(0.1F).setStepSound(soundClothFootstep).setBlockName("snow");
        ice = (new BlockIce(79, 67)).setHardness(0.5F).setLightOpacity(3).setStepSound(soundGlassFootstep).setBlockName("ice");
        blockSnow = (new BlockSnowBlock(80, 66)).setHardness(0.2F).setStepSound(soundClothFootstep).setBlockName("snow");
        cactus = (new BlockCactus(81, 70)).setHardness(0.4F).setStepSound(soundClothFootstep).setBlockName("cactus").setBlockWorth(10);
        blockClay = (new BlockClay(82, 72)).setHardness(0.6F).setStepSound(soundGravelFootstep).setBlockName("clay").setBlockWorth(20);
        reed = (new BlockReed(83, 73)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("reeds").disableStats();
        jukebox = (new BlockJukeBox(84, 74)).setHardness(2.0F).setResistance(10F).setStepSound(soundStoneFootstep).setBlockName("jukebox").func_28027_k();
        fence = (new BlockFence(85, 4)).setHardness(2.0F).setResistance(5F).setStepSound(soundWoodFootstep).setBlockName("fence").func_28027_k();
        pumpkin = (new BlockPumpkin(86, 102, false)).setHardness(1.0F).setStepSound(soundWoodFootstep).setBlockName("pumpkin").func_28027_k().setBlockWorth(30);
        bloodStone = (new BlockNetherrack(87, 103)).setHardness(0.4F).setStepSound(soundStoneFootstep).setBlockName("hellrock");
        slowSand = (new BlockSoulSand(88, 104)).setHardness(0.5F).setStepSound(soundSandFootstep).setBlockName("hellsand").setBlockWorth(5);
        lightStone = (new BlockGlowStone(89, 105, Material.rock)).setHardness(0.3F).setStepSound(soundGlassFootstep).setLightValue(1.0F).setBlockName("lightgem").setBlockWorth(35);
        portal = (BlockPortal)(new BlockPortal(90, 14)).setHardness(-1F).setStepSound(soundGlassFootstep).setLightValue(0.75F).setBlockName("portal");
        pumpkinLantern = (new BlockPumpkin(91, 102, true)).setHardness(1.0F).setStepSound(soundWoodFootstep).setLightValue(1.0F).setBlockName("litpumpkin").func_28027_k();
        cake = (new BlockCake(92, 121)).setHardness(0.5F).setStepSound(soundClothFootstep).setBlockName("cake").disableStats().func_28027_k().setBlockWorth(100);
        redstoneRepeaterIdle = (new BlockRedstoneRepeater(93, false)).setHardness(0.0F).setStepSound(soundWoodFootstep).setBlockName("diode").disableStats().func_28027_k();
        redstoneRepeaterActive = (new BlockRedstoneRepeater(94, true)).setHardness(0.0F).setLightValue(0.625F).setStepSound(soundWoodFootstep).setBlockName("diode").disableStats().func_28027_k();
        lockedChest = (new BlockLockedChest(95)).setHardness(0.0F).setLightValue(1.0F).setStepSound(soundWoodFootstep).setBlockName("lockedchest").setTickOnLoad(true).func_28027_k();
        field_28030_bl = (new BlockTrapDoor(96, Material.wood)).setHardness(3F).setStepSound(soundWoodFootstep).setBlockName("trapdoor").disableStats().func_28027_k().setBlockWorth(3);
        
        /*
		 * ------------- START Node Pack ---------------
		 */
        illuminationTubeFloor = (new Node_BlockIlluminationTube(mod_Node_PackLoader.getID("IlluminationTube"), 0)).setHardness(0.0F).setLightValue(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("lightStick").setBlockWorth(3);
        illuminationTubeRoof = (new Node_BlockIlluminationTubeRoof(mod_Node_PackLoader.getID("IlluminationTubeRoof"), 0)).setHardness(0.0F).setLightValue(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("lightStick").setBlockWorth(3);
        
		dirtStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactDirt"), Block.dirt)).setBlockName("Dirt Stairs");
        stoneStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactStone"), Block.stone)).setBlockName("Plain Stone Stairs");
        snowStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactBlockSnow"), Block.blockSnow)).setBlockName("Snow Stairs");
        glassStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactGlass"), Block.glass)).setBlockName("Glass Stairs");
        ironStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactBlockSteel"), Block.blockSteel)).setBlockName("Iron Stairs");
        goldStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactBlockGold"), Block.blockGold)).setBlockName("Gold Stairs");
        diamondStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactBlockDiamond"), Block.blockDiamond)).setBlockName("Diamond Stairs");
        netherStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactNetherrack"), Block.bloodStone)).setBlockName("Netherrack Stairs");
        brickStairs = (new BlockStairs(mod_Node_PackLoader.getID("stairsCompactBrick"), Block.brick)).setBlockName("Brick Stairs");
		
		int[] texAry = new int[3];
		blockFluro = (new Node_BlockFluro(mod_Node_PackLoader.getID("blockFluro"), texAry)).setHardness(1.0F).setLightValue(1.0F).setResistance(2.0F).setStepSound(Block.soundGlassFootstep).setBlockName("Fluro Block").setBlockWorth(15);
		
		blockLaserBridge = (new Node_BlockLBridge(mod_Node_PackLoader.getID("LaserBridge"), 0)).setHardness(-1F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setBlockName("laserBridge");
		blockLaserBridgeControl = (new Node_BlockLBridgeControl(mod_Node_PackLoader.getID("LaserBridgeControl"), 0)).setHardness(1.0F).setResistance(1.0F).setStepSound(Block.soundMetalFootstep).setBlockName("laserControl").setBlockWorth(40);
		
		// --- add block items to item list ---
		Item.itemsList[blockFluro.blockID] = (new Node_ItemFluro(blockFluro.blockID - 256)).setItemName("Fluro Block");
		
		/*
		 * ------------- END Node Pack ---------------
		 */
        
        Item.itemsList[cloth.blockID] = (new ItemCloth(cloth.blockID - 256)).setItemName("cloth");
        Item.itemsList[wood.blockID] = (new ItemLog(wood.blockID - 256)).setItemName("log");
        Item.itemsList[stairSingle.blockID] = (new ItemSlab(stairSingle.blockID - 256)).setItemName("stoneSlab");
        Item.itemsList[sapling.blockID] = (new ItemSapling(sapling.blockID - 256)).setItemName("sapling");
        for(int i = 0; i < 256; i++)
        {
            if(blocksList[i] != null && Item.itemsList[i] == null)
            {
                Item.itemsList[i] = new ItemBlock(i - 256);
                blocksList[i].func_28028_f();
            }
        }

        field_537_s[0] = true;
        StatList.func_25088_a();
    }
}
