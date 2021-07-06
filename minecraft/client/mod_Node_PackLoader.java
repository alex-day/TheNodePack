package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;

public class mod_Node_PackLoader extends BaseMod
{

    public String Version()
    {
        return "2.3 for Minecraft 1.6_06";
    }

    public mod_Node_PackLoader()
    {
        trace((new StringBuilder()).append(ids).append("").toString());
        trace((new StringBuilder()).append(integerOptions).append("").toString());
        trace((new StringBuilder()).append(floatOptions).append("").toString());
        trace((new StringBuilder()).append(booleanOptions).append("").toString());
		
		AddRecipes();
    }

    public void AddRecipes()
    {
        ModLoader.AddRecipe(new ItemStack(Item.silk, 9), new Object[] {
            "#", Character.valueOf('#'), Block.cloth
        });
    }

    public static void trace(String s)
    {
        logPrintStream.println((new StringBuilder()).append("<NodePack>: ").append(s).toString());
        logPrintStream.flush();
    }

    public static int getID(String s)
    {
        Integer integer = (Integer)ids.get(s);
        if(integer == null)
        {
            trace((new StringBuilder()).append("No match found for key: ").append(s).append(" id: ").append(integer).toString());
        }
        return integer.intValue();
    }

    public static int getIntOption(String s)
    {
        Integer integer = (Integer)integerOptions.get(s);
        if(integer == null)
        {
            trace((new StringBuilder()).append("No match found for key: ").append(s).append(" id: ").append(integer).toString());
        }
        return integer.intValue();
    }

    public static float getFloatOption(String s)
    {
        Float float1 = (Float)floatOptions.get(s);
        if(float1 == null)
        {
            trace((new StringBuilder()).append("No match found for key: ").append(s).append(" id: ").append(float1).toString());
        }
        return float1.floatValue();
    }

    public static boolean getBooleanOption(String s)
    {
        Boolean boolean1 = (Boolean)booleanOptions.get(s);
        if(boolean1 == null)
        {
            trace((new StringBuilder()).append("No match found for key: ").append(s).append(" id: ").append(boolean1).toString());
        }
        return boolean1.booleanValue();
    }

    public static void parseFileForIDs(File file)
        throws Exception
    {
        BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
        for(String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
        {
            if(s.matches("[\\s]*") || s.startsWith("#"))
            {
                continue;
            }
            String as[] = s.split("[\\s][\\s]*");
            if(as.length != 2)
            {
                trace((new StringBuilder()).append("Error parsing in Id in file: ").append(file.getAbsolutePath()).append(" for line: ").append(s).toString());
                trace((new StringBuilder()).append("Reason: Too many tokens on line ").append(as.length).toString());
                continue;
            }
            int i = -1;
            try
            {
                i = Integer.parseInt(as[1]);
            }
            catch(NumberFormatException numberformatexception)
            {
                trace((new StringBuilder()).append("Error parsing in Id in file: ").append(file.getAbsolutePath()).append(" for line: ").append(s).toString());
                trace("Reason: Could not convert ID token to integer");
            }
            ids.put(as[0], Integer.valueOf(i));
        }

    }

    public static void parseFileForOptions(File file)
        throws Exception
    {
        BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
        for(String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
        {
            if(s.matches("[\\s]*") || s.startsWith("#"))
            {
                continue;
            }
            String as[] = s.split("[\\s][\\s]*");
            if(as.length != 3)
            {
                trace((new StringBuilder()).append("Error parsing in options in file: ").append(file.getAbsolutePath()).append(" for line: ").append(s).toString());
                trace((new StringBuilder()).append("Reason: Too many tokens on line ").append(as.length).toString());
                continue;
            }
            if(as[0].equalsIgnoreCase("int"))
            {
                int i = -1;
                try
                {
                    i = Integer.parseInt(as[2]);
                }
                catch(NumberFormatException numberformatexception)
                {
                    trace((new StringBuilder()).append("Error parsing in options file in file: ").append(file.getAbsolutePath()).append(" for line: ").append(s).toString());
                    trace("Reason: Could not convert value token to an integer");
                }
                integerOptions.put(as[1], Integer.valueOf(i));
                continue;
            }
            if(as[0].equalsIgnoreCase("float"))
            {
                float f = -1F;
                try
                {
                    f = Float.parseFloat(as[2]);
                }
                catch(NumberFormatException numberformatexception1)
                {
                    trace((new StringBuilder()).append("Error parsing in options file in file: ").append(file.getAbsolutePath()).append(" for line: ").append(s).toString());
                    trace("Reason: Could not convert value token to float");
                }
                floatOptions.put(as[1], Float.valueOf(f));
                continue;
            }
            if(as[0].equalsIgnoreCase("boolean"))
            {
                boolean flag = false;
                try
                {
                    flag = Boolean.parseBoolean(as[2]);
                }
                catch(NumberFormatException numberformatexception2)
                {
                    trace((new StringBuilder()).append("Error parsing in options file in file: ").append(file.getAbsolutePath()).append(" for line: ").append(s).toString());
                    trace("Reason: Could not convert value token to a boolean");
                }
                booleanOptions.put(as[1], Boolean.valueOf(flag));
            } else
            {
                trace((new StringBuilder()).append("Error parsing in options file in file: ").append(file.getAbsolutePath()).append(" for line: ").append(s).toString());
                trace("Reason: Could not resolve option type");
            }
        }

    }

    public static final int field_25104_k = 0;
    public static final int field_25110_e = 1;
    public static final int field_25107_h = 2;
    public static File field_25109_f;
    public static PrintStream logPrintStream;
    public static Map ids = new HashMap();
    public static Map integerOptions = new HashMap();
    public static Map floatOptions = new HashMap();
    public static Map booleanOptions = new HashMap();
	public static String s;

    static 
    {
        ModLoader.getMinecraftInstance();
        File file = Minecraft.getMinecraftDir();
		s = (new StringBuilder()).append(file.getAbsolutePath()).append("/mods/NodePack/").toString();
        File file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append("/mods/").toString());
        File file2 = new File((new StringBuilder()).append(file1.getAbsolutePath()).append("/NodePack/").toString());
        field_25109_f = new File((new StringBuilder()).append(s).append("NodePack_log.txt").toString());
        System.out.println(field_25109_f.getAbsolutePath());
        try
        {
            file1.mkdir();
            file2.mkdir();
            field_25109_f.createNewFile();
        }
        catch(Exception exception)
        {
            System.out.println("unable to load the nodepack files - abort");
            exception.printStackTrace();
        }
        try
        {
            logPrintStream = new PrintStream(field_25109_f);
            Node_MultiPrintStream multiStreamer = new Node_MultiPrintStream(System.out,logPrintStream);
            System.setOut(multiStreamer);
            System.setErr(multiStreamer);
        }
        catch(Exception exception1)
        {
            System.err.println(exception1);
            System.exit(1);
        }
        File file3 = new File(s);
        if(file3.isDirectory())
        {
            Node_BlockIDFilter blockidfilter = new Node_BlockIDFilter();
            File afile[] = file3.listFiles(blockidfilter);
            for(int i = 0; i < afile.length; i++)
            {
                try
                {
                    parseFileForIDs(afile[i]);
                    continue;
                }
                catch(Exception exception2)
                {
                    trace((new StringBuilder()).append("Error parsing in Id file: ").append(afile[i].getAbsolutePath()).toString());
                }
                trace("Reason: IO Error");
            }

            Node_OptionsFilter optionsfilter = new Node_OptionsFilter();
            trace((new StringBuilder()).append("searching in directory: ").append(file3.getAbsolutePath()).toString());
            File afile1[] = file3.listFiles(optionsfilter);
            trace((new StringBuilder()).append("There are ").append(afile1.length).append(" files that match.").toString());
            for(int j = 0; j < afile1.length; j++)
            {
                try
                {
                    parseFileForOptions(afile1[j]);
                    continue;
                }
                catch(Exception exception3)
                {
                    trace((new StringBuilder()).append("Error parsing in options file: ").append(afile1[j].getAbsolutePath()).toString());
                }
                trace("Reason: IO Error");
            }

        }
    }
}
