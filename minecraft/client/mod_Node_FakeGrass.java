package net.minecraft.src;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import java.util.Map;

public class mod_Node_FakeGrass extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }
	
    public mod_Node_FakeGrass()
    {
        if(fakeGrass != null){
            ModLoader.RegisterBlock(fakeGrass);
            mod_Node_PackLoader.trace("Sucessfully loaded Fake Grass");
            ModLoader.AddName(fakeGrass, "Fake Grass");
        }
		/*if(fakeGrassSlope != null){
			ModLoader.RegisterBlock(fakeGrassSlope);
            mod_Node_PackLoader.trace("Sucessfully loaded Fake Grass Ramp");
            ModLoader.AddName(fakeGrassSlope, "Fake Grass Ramp");
		}
		if(fakeGrassStair != null){
			ModLoader.RegisterBlock(fakeGrassStair);
            mod_Node_PackLoader.trace("Sucessfully loaded Fake Grass Stair");
            ModLoader.AddName(fakeGrassStair, "Fake Grass Stair");
		}*/
		AddRecipes();
		
		Node_BlockFakeGrass.modelID = ModLoader.getUniqueBlockModelID(this, true);
		//Node_BlockFakeGrassSlope.modelSlopeID = ModLoader.getUniqueBlockModelID(this, true);	
		renderer = new Node_RenderFakeGrass();
		
		ModLoader.SetInGameHook(this, true, false);
    }

	public void AddRenderer(Map map)
    {
        if(fakeGrass != null)
        {
            map.put(EntityItem.class, new Node_RenderFakeGrass());
        }
    }
	
	public void RenderInvBlock(RenderBlocks renderblocks, Block block, int i, int j)
    {
		renderer.renderInventoryBlock(block, i, j, minecraft.theWorld);
	}
	
    public boolean RenderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
    {
		renderblocks.renderStandardBlock(block, i, j, k);
		return true;
    }
	
    public void AddRecipes()
    {
        if(fakeGrass != null)
        {
            ModLoader.AddRecipe(new ItemStack(fakeGrass,9), new Object[] {
                "XX", "XX", Character.valueOf('X'), Block.dirt
            });
        }
		/*if(fakeGrassSlope != null){
		
			ModLoader.AddRecipe(new ItemStack(fakeGrassSlope,4), new Object[] {
                "#  ", " # ", "  #", Character.valueOf('#'), fakeGrass
            });
		}
		if(fakeGrassStair != null){
			ModLoader.AddRecipe(new ItemStack(fakeGrassStair, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), fakeGrass
            });
		}*/
    }
	
	public void OnTickInGame(Minecraft m)
    {
		//a run once kinda thing
		if(minecraft != m)
        {
            minecraft = m;
        }
    }
	
	public static Block fakeGrass = null;
	//public static Block fakeGrassSlope = null;
	//public static Block fakeGrassStair = null;
	
	public static Node_RenderFakeGrass renderer = null;

	public static StepSound soundGrassFootstep = null;
	public static Minecraft minecraft;

    static 
    {
        int i = mod_Node_PackLoader.getID("fakeGrass");
		//int j = mod_Node_PackLoader.getID("fakeGrassSlope");
		//int k = mod_Node_PackLoader.getID("fakeGrassStair");
		
		soundGrassFootstep = new StepSound("grass", 1.0F, 1.0F);
		
        if(i != -1)
        {
        	if(mod_Node_PackLoader.getBooleanOption("fakeGrassIndestructible")) {
        		fakeGrass = (new Node_BlockFakeGrass(i)).setHardness(-1F).setStepSound(soundGrassFootstep).setBlockName("fakeGrass");
        	} else {
        		fakeGrass = (new Node_BlockFakeGrass(i)).setHardness(0.6F).setStepSound(soundGrassFootstep).setBlockName("fakeGrass");
        	}
        }
		/*if(j != -1 && i != -1){
			fakeGrassSlope = (new Node_BlockFakeGrassSlope(j, 0, Material.ground)).setHardness(2.0F).setStepSound(soundGrassFootstep).setBlockName("fakeGrassSlope");
		}
		if(k != -1 && i != -1){
			fakeGrassStair = (new BlockStairs(k, fakeGrass)).setBlockName("fakeGrassStair");
		}*/
    }
}