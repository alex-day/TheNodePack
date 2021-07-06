package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.io.*;
import java.util.*;
import net.minecraft.client.Minecraft;

public class mod_Node_TeleporterPack extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }
	
    public mod_Node_TeleporterPack()
    {
		ModLoader.RegisterBlock(teleporter, Node_ItemTeleporter.class);
        ModLoader.AddName(new ItemStack(teleporter,1,0), "Empty Teleporter Node");
		ModLoader.AddName(new ItemStack(teleporter,1,1), "Red Teleporter Node");
		ModLoader.AddName(new ItemStack(teleporter,1,2), "Blue Teleporter Node");
		ModLoader.AddName(new ItemStack(teleporter,1,3), "Green Teleporter Node");
		ModLoader.AddName(new ItemStack(teleporter,1,4), "Purple Teleporter Node");
		ModLoader.AddName(new ItemStack(teleporter,1,5), "Yellow Teleporter Node");
		ModLoader.AddName(new ItemStack(teleporter,1,6), "White Teleporter Node");
		ModLoader.AddName(new ItemStack(teleporter,1,7), "Tainted Teleporter Node");
		mod_Node_PackLoader.trace("Sucessfully loaded Teleporter Node");
		ModLoader.AddName(socket, "Socket");
		
		ModLoader.SetInGameHook(this, true, false);
		world = "";
		
		Node_BlockTeleporter.pk = this;
    }
	
	public static File getAppDir(String s)
    {
        File MCfile = Minecraft.getAppDir(s);
		File recFile = new File(MCfile,"/mods/NodePack/tps/");
		recFile.mkdir();
		return recFile;
    }
	
	public String getMapName()
    {
        return game.theWorld.worldInfo.getWorldName()+game.theWorld.worldInfo.getDimension();
    }
	
	public String getServerName()
    {
        return game.gameSettings.lastServer;
    }
	
	public void chatInfo(String s)
    {
        game.ingameGUI.addChatMessage(s);
    }
	
	private void saveNodeReceivers()
    {
        settingsFile = new File(getAppDir("minecraft"), world+".tps");
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(settingsFile));
            for(Iterator iterator = receivers.iterator(); iterator.hasNext();)
            {
                Node_NodeReceiver receiver = (Node_NodeReceiver)iterator.next();
                printwriter.println(receiver.x+":"+receiver.y+":"+receiver.z+":"+receiver.type);
            }

            printwriter.close();
        }
        catch(Exception exception)
        {
            chatInfo("\247EError Saving NodeReceivers");
        }
    }

    private void loadNodeReceivers()
    {
        String s1 = getMapName();
        String s;
        if(s1.equals("MpServer"))
        {
            String as[] = getServerName().toLowerCase().split(":");
            s = as[0];
        } else
        {
            s = s1;
        }
        if(!world.equals(s))
        {
            world = s;
            receivers = new ArrayList();
            settingsFile = new File(getAppDir("minecraft"),world+".tps");
            try
            {
                if(settingsFile.exists())
                {
                    BufferedReader bufferedreader = new BufferedReader(new FileReader(settingsFile));
                    String s2;
                    while((s2 = bufferedreader.readLine()) != null) 
                    {
                        String as1[] = s2.split(":");
                        if(as1.length == 4)
                        {
                            receivers.add(new Node_NodeReceiver(Integer.parseInt(as1[0]), Integer.parseInt(as1[1]), Integer.parseInt(as1[2]), Integer.parseInt(as1[3])));
                        }
                    }
                    bufferedreader.close();
                    chatInfo((new StringBuilder("\247ENodeReceivers loaded for ")).append(world).toString());
                } else
                {
                    chatInfo("\247E No receivers exist for this world");
                }
            }
            catch(Exception exception)
            {
                chatInfo("\247EError Loading NodeReceivers");
            }
        }
    }
	
	public void deleteReceiver(int x, int y, int z)
    {
		Node_NodeReceiver removeMe = null;
		for(Iterator iterator = receivers.iterator(); iterator.hasNext();)
        {
            Node_NodeReceiver receiver = (Node_NodeReceiver)iterator.next();
            if(receiver.x == x && receiver.y == y && receiver.z == z)
            {
                removeMe = receiver;
			}
        }
		if(removeMe != null) {
			receivers.remove(removeMe);
			saveNodeReceivers();
		}
    }
	
	public void addReceiver(int x, int y, int z, int type) {
		receivers.add(new Node_NodeReceiver(x, y, z, type));
        saveNodeReceivers();
	}
	
    public void AddRecipes()
    {
        ModLoader.AddRecipe(new ItemStack(teleporter, 1, 0), new Object[] {
            "###", "#X#", "###", Character.valueOf('#'), Block.stone,
			Character.valueOf('X'), socket
        });
        
		ModLoader.AddRecipe(new ItemStack(socket, 4), new Object[] {
            " Y ", "Y Y", " Y ", Character.valueOf('Y'), Item.ingotIron
        });
		
		if(ModLoader.isModLoaded("mod_Node_CrystalPack")) {
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 1), new Object[] {
				new ItemStack(mod_Node_CrystalPack.gemRed, 1), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 2), new Object[] {
				new ItemStack(mod_Node_CrystalPack.gemBlue, 1), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 3), new Object[] {
				new ItemStack(mod_Node_CrystalPack.gemGreen, 1), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 4), new Object[] {
				new ItemStack(mod_Node_CrystalPack.gemPurple, 1), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 5), new Object[] {
				new ItemStack(mod_Node_CrystalPack.gemYellow, 1), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 6), new Object[] {
				new ItemStack(mod_Node_CrystalPack.gemWhite, 1), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 7), new Object[] {
				new ItemStack(mod_Node_CrystalPack.gemTainted, 1), new ItemStack(teleporter, 1, 0)
			});
		} else {
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 1), new Object[] {
				new ItemStack(Item.dyePowder, 1, 1), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 2), new Object[] {
				new ItemStack(Item.dyePowder, 1, 4), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 3), new Object[] {
				new ItemStack(Item.dyePowder, 1, 2), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 4), new Object[] {
				new ItemStack(Item.dyePowder, 1, 5), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 5), new Object[] {
				new ItemStack(Item.dyePowder, 1, 11), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 6), new Object[] {
				new ItemStack(Item.dyePowder, 1, 15), new ItemStack(teleporter, 1, 0)
			});
			ModLoader.AddShapelessRecipe(new ItemStack(teleporter, 1, 7), new Object[] {
				new ItemStack(Item.dyePowder, 1, 8), new ItemStack(teleporter, 1, 0)
			});
		}
    }

    public Node_NodeReceiver findNearestTP(int x, int y, int z, int type) {
		Node_NodeReceiver min = null;
		int dist = Integer.MAX_VALUE;
		for(Iterator iterator = receivers.iterator(); iterator.hasNext();)
        {
            Node_NodeReceiver receiver = (Node_NodeReceiver)iterator.next();
            if(receiver.type == type)
            {
				int newDist = getDist(x,y,z,receiver.x,receiver.y,receiver.z);
				if(newDist > 0 && newDist < dist) {
					min = receiver;
					dist = newDist;
				}
			}
        }
		return min;
	}
	
	public int getDist(int x1, int y1, int z1, int x2, int y2, int z2) {
		return (int)Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) + (z2-z1)*(z2-z1));
	}
	
	public void OnTickInGame(Minecraft minecraft)
    {
		//a run once kinda thing
		if(game == null)
        {
            game = minecraft;
			AddRecipes();
        }
		loadNodeReceivers();
    }
	
	public static Block teleporter;
	public static Item socket = (new Item(mod_Node_PackLoader.getID("socket"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/teleporter/socket.png")).setItemName("socket");;
	
	private Minecraft game;
	public ArrayList receivers;
	private File settingsFile;
	private String world;
	
	static {
		int[] tex = new int[8];
        tex[0] = ModLoader.addOverride("/terrain.png", "/NodePack/teleporter/teleporter_empty.png");
		tex[1] = ModLoader.addOverride("/terrain.png", "/NodePack/teleporter/teleporter_red.png");
        tex[2] = ModLoader.addOverride("/terrain.png", "/NodePack/teleporter/teleporter_blue.png");
        tex[3] = ModLoader.addOverride("/terrain.png", "/NodePack/teleporter/teleporter_green.png");
        tex[4] = ModLoader.addOverride("/terrain.png", "/NodePack/teleporter/teleporter_purple.png");
        tex[5] = ModLoader.addOverride("/terrain.png", "/NodePack/teleporter/teleporter_yellow.png");
        tex[6] = ModLoader.addOverride("/terrain.png", "/NodePack/teleporter/teleporter_white.png");
		tex[7] = ModLoader.addOverride("/terrain.png", "/NodePack/teleporter/teleporter_tainted.png");
        
		teleporter = (new Node_BlockTeleporter(mod_Node_PackLoader.getID("teleporter"), tex)).setHardness(0.5F).setResistance(1.0F).setStepSound(Block.soundMetalFootstep).setBlockName("teleporter");
	}
}
