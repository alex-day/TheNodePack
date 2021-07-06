package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class mod_Node_CrystalPack extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_CrystalPack()
    {
        ModLoader.RegisterBlock(crystalRed);
        mod_Node_PackLoader.trace("Sucessfully loaded red crystal");
        ModLoader.RegisterBlock(crystalBlue);
        mod_Node_PackLoader.trace("Sucessfully loaded blue crystal");
        ModLoader.RegisterBlock(crystalGreen);
        mod_Node_PackLoader.trace("Sucessfully loaded green crystal");
        ModLoader.RegisterBlock(crystalPurple);
        mod_Node_PackLoader.trace("Sucessfully loaded purple crystal");
        ModLoader.RegisterBlock(crystalYellow);
        mod_Node_PackLoader.trace("Sucessfully loaded yellow crystal");
        ModLoader.RegisterBlock(crystalWhite);
        mod_Node_PackLoader.trace("Sucessfully loaded white crystal");
        ModLoader.RegisterBlock(crystalTainted);
        mod_Node_PackLoader.trace("Sucessfully loaded tainted crystal");
        ModLoader.RegisterBlock(largeCrystal);
        mod_Node_PackLoader.trace("Sucessfully loaded large crystal");
        ModLoader.RegisterBlock(largeTaintedCrystal);
        mod_Node_PackLoader.trace("Sucessfully loaded large tainted crystal");
        ModLoader.AddName(crystalRed, "Red Crystal");
        ModLoader.AddName(crystalBlue, "Blue Crystal");
        ModLoader.AddName(crystalGreen, "Green Crystal");
        ModLoader.AddName(crystalPurple, "Purple Crystal");
        ModLoader.AddName(crystalYellow, "Yellow Crystal");
        ModLoader.AddName(crystalWhite, "White Crystal");
        ModLoader.AddName(crystalTainted, "Tainted Crystal");
        ModLoader.AddName(largeCrystal, "Large Crystal");
        ModLoader.AddName(largeTaintedCrystal, "Large Tainted Crystal");
        ModLoader.AddName(shardRed, "Ruby Shard");
        ModLoader.AddName(shardBlue, "Saphire Shard");
        ModLoader.AddName(shardGreen, "Emerald Shard");
        ModLoader.AddName(shardPurple, "Amethyst Shard");
        ModLoader.AddName(shardYellow, "Citrine Shard");
        ModLoader.AddName(shardWhite, "Soulgem Shard");
        ModLoader.AddName(shardTainted, "Necris Shard");
        ModLoader.AddName(gemRed, "Ruby");
        ModLoader.AddName(gemBlue, "Saphire");
        ModLoader.AddName(gemGreen, "Emerald");
        ModLoader.AddName(gemPurple, "Amethyst");
        ModLoader.AddName(gemYellow, "Citrine");
        ModLoader.AddName(gemWhite, "Soulgem");
        ModLoader.AddName(gemTainted, "Necris");
        ModLoader.AddName(wishStone, "Wish Stone");
        ModLoader.AddName(wishWand, "Wish Staff");
        ModLoader.AddName(repairArmourStone, "Armourer Stone");
        ModLoader.AddName(repairArmourWand, "Armourer Staff");
        ModLoader.AddName(repairItemStone, "Tool-smith Stone");
        ModLoader.AddName(repairItemWand, "Tool-smith Staff");
        ModLoader.AddName(skeletonStone, "Bone-Soul Stone");
        ModLoader.AddName(skeletonWand, "Bone-Soul Wand");
        ModLoader.AddName(creeperStone, "Fuse-Soul Stone");
        ModLoader.AddName(creeperWand, "Fuse-Soul Wand");
        ModLoader.AddName(spiderStone, "Web-Soul Stone");
        ModLoader.AddName(spiderWand, "Web-Soul Wand");
        ModLoader.AddName(zombieStone, "Rotten-Soul Stone");
        ModLoader.AddName(zombieWand, "Rotten-Soul Wand");
        ModLoader.AddName(slimeStone, "Goo-Soul Stone");
        ModLoader.AddName(slimeWand, "Goo-Soul Wand");
        ModLoader.AddName(pigStone, "Oink-Soul Stone");
        ModLoader.AddName(pigWand, "Oink-Soul Wand");
        ModLoader.AddName(sheepStone, "Baa-Soul Stone");
        ModLoader.AddName(sheepWand, "Baa-Soul Wand");
        ModLoader.AddName(cowStone, "Moo-Soul Stone");
        ModLoader.AddName(cowWand, "Moo-Soul Wand");
        ModLoader.AddName(chickenStone, "Bwak-Soul Stone");
        ModLoader.AddName(chickenWand, "Bwak-Soul Wand");
        ModLoader.AddName(squidStone, "Ink-Soul Stone");
        ModLoader.AddName(squidWand, "Ink-Soul Wand");
        ModLoader.AddName(fireStone, "Fire Stone");
        ModLoader.AddName(fireWand, "Fire Wand");
        ModLoader.AddName(iceStone, "Ice Stone");
        ModLoader.AddName(iceWand, "Ice Wand");
        ModLoader.AddName(earthStone, "Earth Stone");
        ModLoader.AddName(earthWand, "Earth Wand");
        ModLoader.AddName(timeStone, "Time Stone");
        ModLoader.AddName(timeWand, "Time Wand");
        ModLoader.AddName(deathStone, "Death Stone");
        ModLoader.AddName(deathWand, "Death Wand");
        ModLoader.AddName(boomStone, "Dynomite Stone");
        ModLoader.AddName(boomWand, "Dynomite Wand");
        ModLoader.AddName(polymorphStone, "Polymorph Stone");
        ModLoader.AddName(polymorphWand, "Polymorph Wand");
		ModLoader.AddName(homeStone, "Home Stone");
        ModLoader.AddName(homeWand, "Home Wand");
		
		AddRecipes();
    }

    public void AddRecipes()
    {
    	
    	ModLoader.AddRecipe(new ItemStack(gemRed, 1), new Object[] {
            "##", "##", Character.valueOf('#'), shardRed
        });
        ModLoader.AddRecipe(new ItemStack(gemBlue, 1), new Object[] {
            "##", "##", Character.valueOf('#'), shardBlue
        });
        ModLoader.AddRecipe(new ItemStack(gemGreen, 1), new Object[] {
            "##", "##", Character.valueOf('#'), shardGreen
        });
        ModLoader.AddRecipe(new ItemStack(gemPurple, 1), new Object[] {
            "##", "##", Character.valueOf('#'), shardPurple
        });
        ModLoader.AddRecipe(new ItemStack(gemYellow, 1), new Object[] {
            "##", "##", Character.valueOf('#'), shardYellow
        });
        ModLoader.AddRecipe(new ItemStack(gemWhite, 1), new Object[] {
            "##", "##", Character.valueOf('#'), shardWhite
        });
        ModLoader.AddRecipe(new ItemStack(gemTainted, 1), new Object[] {
            "##", "##", Character.valueOf('#'), shardTainted
        });
        ModLoader.AddRecipe(new ItemStack(wishWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), wishStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(wishStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemBlue, Character.valueOf('X'), gemYellow
        });
        ModLoader.AddRecipe(new ItemStack(repairArmourWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), repairArmourStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(repairArmourStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemPurple, Character.valueOf('X'), gemGreen
        });
        ModLoader.AddRecipe(new ItemStack(repairItemWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), repairItemStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(repairItemStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemPurple, Character.valueOf('X'), gemRed
        });
        ModLoader.AddRecipe(new ItemStack(skeletonWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), skeletonStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(skeletonStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemTainted, Character.valueOf('X'), gemYellow
        });
        ModLoader.AddRecipe(new ItemStack(creeperWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), creeperStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(creeperStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemTainted, Character.valueOf('X'), gemRed
        });
        ModLoader.AddRecipe(new ItemStack(spiderWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), spiderStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(spiderStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemTainted, Character.valueOf('X'), gemBlue
        });
        ModLoader.AddRecipe(new ItemStack(zombieWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), zombieStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(zombieStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemTainted, Character.valueOf('X'), gemPurple
        });
        ModLoader.AddRecipe(new ItemStack(slimeWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), slimeStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(slimeStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemTainted, Character.valueOf('X'), gemGreen
        });
        ModLoader.AddRecipe(new ItemStack(pigWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), pigStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(pigStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemWhite, Character.valueOf('X'), gemRed
        });
        ModLoader.AddRecipe(new ItemStack(sheepWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), sheepStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(sheepStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemWhite, Character.valueOf('X'), gemPurple
        });
        ModLoader.AddRecipe(new ItemStack(cowWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), cowStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(cowStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemWhite, Character.valueOf('X'), gemGreen
        });
        ModLoader.AddRecipe(new ItemStack(chickenWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), chickenStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(chickenStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemWhite, Character.valueOf('X'), gemYellow
        });
        ModLoader.AddRecipe(new ItemStack(squidWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), squidStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(squidStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemWhite, Character.valueOf('X'), gemBlue
        });
        ModLoader.AddRecipe(new ItemStack(fireWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), fireStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(fireStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemRed, Character.valueOf('X'), gemYellow
        });
        ModLoader.AddRecipe(new ItemStack(iceWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), iceStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(iceStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemBlue, Character.valueOf('X'), gemWhite
        });
        ModLoader.AddRecipe(new ItemStack(earthWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), earthStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(earthStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemGreen, Character.valueOf('X'), gemWhite
        });
        ModLoader.AddRecipe(new ItemStack(timeWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), timeStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(timeStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemYellow, Character.valueOf('X'), gemWhite
        });
        ModLoader.AddRecipe(new ItemStack(deathWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), deathStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(deathStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemTainted, Character.valueOf('X'), gemWhite
        });
        ModLoader.AddRecipe(new ItemStack(boomWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), boomStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(boomStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemRed, Character.valueOf('X'), gemTainted
        });
        ModLoader.AddRecipe(new ItemStack(polymorphWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), polymorphStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(polymorphStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemPurple, Character.valueOf('X'), gemTainted
        });
		ModLoader.AddRecipe(new ItemStack(homeWand), new Object[] {
            "#  ", " X ", "  X", Character.valueOf('#'), homeStone, Character.valueOf('X'), Item.stick
        });
        ModLoader.AddRecipe(new ItemStack(homeStone), new Object[] {
            " # ", "#X#", " # ", Character.valueOf('#'), gemGreen, Character.valueOf('X'), gemRed
        });

    }

    public void GenerateSurface(World world, Random random, int i, int j)
    {
        int k = random.nextInt(12);
        if(k == 1)
        {
            for(int l = 0; l < 20; l++)
            {
                int i1 = random.nextInt(11);
                int j1 = crystalRed.blockID;
                if(i1 == 10)
                {
                    j1 = crystalWhite.blockID;
                } else
                if(i1 == 8 || i1 == 9)
                {
                    j1 = crystalYellow.blockID;
                } else
                if(i1 == 6 || i1 == 7)
                {
                    j1 = crystalPurple.blockID;
                } else
                if(i1 == 4 || i1 == 5)
                {
                    j1 = crystalGreen.blockID;
                } else
                if(i1 == 2 || i1 == 3)
                {
                    j1 = crystalBlue.blockID;
                }
                int k1 = i + random.nextInt(16);
                int l1 = random.nextInt(46);
                int i2 = j + random.nextInt(16);
                (new Node_WorldGenCrystals(j1)).func_25297_a(world, random, k1, l1, i2);
            }

        }
    }

    public void GenerateNether(World world, Random random, int i, int j)
    {
        int k = random.nextInt(16);
        if(k == 1)
        {
            for(int l = 0; l < 25; l++)
            {
                int i1 = random.nextInt(2);
                int j1 = crystalTainted.blockID;
                if(i1 == 0)
                {
                    j1 = crystalWhite.blockID;
                }
                int k1 = i + random.nextInt(16);
                int l1 = random.nextInt(128);
                int i2 = j + random.nextInt(16);
                (new Node_WorldGenCrystals(j1)).func_25297_a(world, random, k1, l1, i2);
            }

        }
    }

    public static final Block crystalRed;
    public static final Block crystalBlue;
    public static final Block crystalGreen;
    public static final Block crystalPurple;
    public static final Block crystalYellow;
    public static final Block crystalWhite;
    public static final Block crystalTainted;
    public static final Block largeCrystal;
    public static final Block largeTaintedCrystal;
    public static final Item shardRed = (new Item(mod_Node_PackLoader.getID("shardRed"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/shard_red.png")).setItemName("shardRed");
    public static final Item shardBlue = (new Item(mod_Node_PackLoader.getID("shardBlue"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/shard_blue.png")).setItemName("shardBlue");
    public static final Item shardGreen = (new Item(mod_Node_PackLoader.getID("shardGreen"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/shard_green.png")).setItemName("shardGreen");
    public static final Item shardPurple = (new Item(mod_Node_PackLoader.getID("shardPurple"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/shard_purple.png")).setItemName("shardPurple");
    public static final Item shardYellow = (new Item(mod_Node_PackLoader.getID("shardYellow"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/shard_yellow.png")).setItemName("shardYellow");
    public static final Item shardWhite = (new Item(mod_Node_PackLoader.getID("shardWhite"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/shard_white.png")).setItemName("shardWhite");
    public static final Item shardTainted = (new Item(mod_Node_PackLoader.getID("shardTainted"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/shard_tainted.png")).setItemName("shardTainted");
    public static final Item gemRed = (new Item(mod_Node_PackLoader.getID("gemRed"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/gem_red.png")).setItemName("gemRed");
    public static final Item gemBlue = (new Item(mod_Node_PackLoader.getID("gemBlue"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/gem_blue.png")).setItemName("gemBlue");
    public static final Item gemGreen = (new Item(mod_Node_PackLoader.getID("gemGreen"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/gem_green.png")).setItemName("gemGreen");
    public static final Item gemPurple = (new Item(mod_Node_PackLoader.getID("gemPurple"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/gem_purple.png")).setItemName("gemPurple");
    public static final Item gemYellow = (new Item(mod_Node_PackLoader.getID("gemYellow"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/gem_yellow.png")).setItemName("gemYellow");
    public static final Item gemWhite = (new Item(mod_Node_PackLoader.getID("gemWhite"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/gem_white.png")).setItemName("gemWhite");
    public static final Item gemTainted = (new Item(mod_Node_PackLoader.getID("gemTainted"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/crystals/gem_tainted.png")).setItemName("gemTainted");
    public static Item wishStone = (new Item(mod_Node_PackLoader.getID("wishStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/wishStone.png")).setItemName("wishStone");
    public static Item wishWand = (new Node_ItemHealWand(mod_Node_PackLoader.getID("wishWand"), 10, 5)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/wishWand.png")).setItemName("wishWand");
    public static Item repairArmourStone = (new Item(mod_Node_PackLoader.getID("repairArmourStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/repairArmourStone.png")).setItemName("repairArmourStone");
    public static Item repairArmourWand = (new Node_ItemRepairWand(mod_Node_PackLoader.getID("repairArmourWand"), 0.5D, 5, 1)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/repairArmourWand.png")).setItemName("repairArmourWand");
    public static Item repairItemStone = (new Item(mod_Node_PackLoader.getID("repairItemStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/repairItemStone.png")).setItemName("repairItemStone");
    public static Item repairItemWand = (new Node_ItemRepairWand(mod_Node_PackLoader.getID("repairItemWand"), 0.5D, 5, 0)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/repairItemWand.png")).setItemName("repairItemWand");
    public static Item skeletonStone = (new Item(mod_Node_PackLoader.getID("skeletonStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/skeletonStone.png")).setItemName("skeletonStone");
    public static Item skeletonWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("skeletonWand"), "Skeleton", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/skeletonWand.png")).setItemName("skeletonWand");
    public static Item creeperStone = (new Item(mod_Node_PackLoader.getID("creeperStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/creeperStone.png")).setItemName("creeperStone");
    public static Item creeperWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("creeperWand"), "Creeper", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/creeperWand.png")).setItemName("creeperWand");
    public static Item spiderStone = (new Item(mod_Node_PackLoader.getID("spiderStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/spiderStone.png")).setItemName("spiderStone");
    public static Item spiderWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("spiderWand"), "Spider", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/spiderWand.png")).setItemName("spiderWand");
    public static Item zombieStone = (new Item(mod_Node_PackLoader.getID("zombieStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/zombieStone.png")).setItemName("zombieStone");
    public static Item zombieWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("zombieWand"), "Zombie", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/zombieWand.png")).setItemName("zombieWand");
    public static Item slimeStone = (new Item(mod_Node_PackLoader.getID("slimeStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/slimeStone.png")).setItemName("slimeStone");
    public static Item slimeWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("slimeWand"), "Slime", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/slimeWand.png")).setItemName("slimeWand");
    public static Item pigStone = (new Item(mod_Node_PackLoader.getID("pigStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/pigStone.png")).setItemName("pigStone");
    public static Item pigWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("pigWand"), "Pig", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/pigWand.png")).setItemName("pigWand");
    public static Item sheepStone = (new Item(mod_Node_PackLoader.getID("sheepStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/sheepStone.png")).setItemName("sheepStone");
    public static Item sheepWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("sheepWand"), "Sheep", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/sheepWand.png")).setItemName("sheepWand");
    public static Item cowStone = (new Item(mod_Node_PackLoader.getID("cowStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/cowStone.png")).setItemName("cowStone");
    public static Item cowWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("cowWand"), "Cow", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/cowWand.png")).setItemName("cowWand");
    public static Item chickenStone = (new Item(mod_Node_PackLoader.getID("chickenStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/chickenStone.png")).setItemName("chickenStone");
    public static Item chickenWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("chickenWand"), "Chicken", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/chickenWand.png")).setItemName("chickenWand");
    public static Item squidStone = (new Item(mod_Node_PackLoader.getID("squidStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/squidStone.png")).setItemName("squidStone");
    public static Item squidWand = (new Node_ItemSpawnerWand(mod_Node_PackLoader.getID("squidWand"), "Squid", 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/squidWand.png")).setItemName("squidWand");
    public static Item fireStone = (new Item(mod_Node_PackLoader.getID("fireStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/fireStone.png")).setItemName("fireStone");
    public static Item fireWand = (new Node_ItemFireWand(mod_Node_PackLoader.getID("fireWand"), 31)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/fireWand.png")).setItemName("fireWand");
    public static Item iceStone = (new Item(mod_Node_PackLoader.getID("iceStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/iceStone.png")).setItemName("iceStone");
    public static Item iceWand = (new Node_ItemIceWand(mod_Node_PackLoader.getID("iceWand"), 10, 16)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/iceWand.png")).setItemName("iceWand");
    public static Item earthStone = (new Item(mod_Node_PackLoader.getID("earthStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/earthStone.png")).setItemName("earthStone");
    public static Item earthWand = (new Node_ItemEarthWand(mod_Node_PackLoader.getID("earthWand"), 10, 16)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/earthWand.png")).setItemName("earthWand");
    public static Item timeStone = (new Item(mod_Node_PackLoader.getID("timeStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/timeStone.png")).setItemName("timeStone");
    public static Item timeWand = (new Node_ItemTimeWand(mod_Node_PackLoader.getID("timeWand"), 10)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/timeWand.png")).setItemName("timeWand");
    public static Item deathStone = (new Item(mod_Node_PackLoader.getID("deathStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/deathStone.png")).setItemName("deathStone");
    public static Item deathWand = (new Node_ItemDeathWand(mod_Node_PackLoader.getID("deathWand"), 10, 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/deathWand.png")).setItemName("deathWand");
    public static Item boomStone = (new Item(mod_Node_PackLoader.getID("boomStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/boomStone.png")).setItemName("boomStone");
    public static Item boomWand = (new Node_ItemBoomWand(mod_Node_PackLoader.getID("boomWand"), 5F, 5)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/boomWand.png")).setItemName("boomWand");
    public static Item polymorphStone = (new Item(mod_Node_PackLoader.getID("polymorphStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/polymorphStone.png")).setItemName("polymorphStone");
    public static Item polymorphWand = (new Node_ItemPolymorphWand(mod_Node_PackLoader.getID("polymorphWand"), 20)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/polymorphWand.png")).setItemName("polymorphWand");
    public static Item homeStone = (new Item(mod_Node_PackLoader.getID("homeStone"))).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/homeStone.png")).setItemName("homeStone");
    public static Item homeWand = (new Node_ItemHomeWand(mod_Node_PackLoader.getID("homeWand"), 3)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/NodePack/wands & stones/homeWand.png")).setItemName("homeWand");
    public static int crystalTex[];
    public static int largeTex[];

    static 
    {
        crystalRed = (new Node_BlockCrystal(mod_Node_PackLoader.getID("crystalRed"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_red.png"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_red_alt.png"))).setHardness(0.5F).setResistance(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("crystalRed");
        crystalBlue = (new Node_BlockCrystal(mod_Node_PackLoader.getID("crystalBlue"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_blue.png"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_blue_alt.png"))).setHardness(0.5F).setResistance(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("crystalBlue");
        crystalGreen = (new Node_BlockCrystal(mod_Node_PackLoader.getID("crystalGreen"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_green.png"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_green_alt.png"))).setHardness(0.5F).setResistance(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("crystalGreen");
        crystalPurple = (new Node_BlockCrystal(mod_Node_PackLoader.getID("crystalPurple"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_purple.png"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_purple_alt.png"))).setHardness(0.5F).setResistance(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("crystalPurple");
        crystalYellow = (new Node_BlockCrystal(mod_Node_PackLoader.getID("crystalYellow"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_yellow.png"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_yellow_alt.png"))).setHardness(0.5F).setResistance(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("crystalYellow");
        crystalWhite = (new Node_BlockCrystal(mod_Node_PackLoader.getID("crystalWhite"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_white.png"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_white_alt.png"))).setHardness(0.5F).setResistance(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("crystalWhite");
        crystalTainted = (new Node_BlockTaintedCrystal(mod_Node_PackLoader.getID("crystalTainted"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_tainted.png"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_tainted_alt.png"))).setHardness(0.5F).setResistance(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("crystalTainted");
        crystalTex = new int[6];
        crystalTex[0] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_red.png");
        crystalTex[1] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_blue.png");
        crystalTex[2] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_green.png");
        crystalTex[3] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_purple.png");
        crystalTex[4] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_yellow.png");
        crystalTex[5] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_white.png");
        largeTex = new int[6];
        largeTex[0] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_red_alt.png");
        largeTex[1] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_blue_alt.png");
        largeTex[2] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_green_alt.png");
        largeTex[3] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_purple_alt.png");
        largeTex[4] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_yellow_alt.png");
        largeTex[5] = ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_white_alt.png");
        largeCrystal = (new Node_BlockLargeCrystal(mod_Node_PackLoader.getID("crystalLarge"), crystalTex, largeTex)).setHardness(1.0F).setResistance(2.0F).setStepSound(Block.soundGlassFootstep).setBlockName("largeCrystal");
        largeTaintedCrystal = (new Node_BlockLargeTaintedCrystal(mod_Node_PackLoader.getID("crystalTaintedLarge"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_tainted.png"), ModLoader.addOverride("/terrain.png", "/NodePack/crystals/crystal_large_tainted_alt.png"))).setHardness(1.0F).setResistance(2.0F).setStepSound(Block.soundGlassFootstep).setBlockName("largeTaintedCrystal");
    }
}
