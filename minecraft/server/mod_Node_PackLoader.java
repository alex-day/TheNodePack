package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class mod_Node_PackLoader
{
	
    public mod_Node_PackLoader()
    {
        
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
    public static File nodePackLog;
    public static PrintStream logPrintStream;
    public static Map ids = new HashMap();
    public static Map integerOptions = new HashMap();
    public static Map floatOptions = new HashMap();
    public static Map booleanOptions = new HashMap();
	public static String s;

    static 
    {
    	File nodePackDir = new File("NodePack/");
        nodePackLog = new File(nodePackDir,"NodePack_log.txt");
        System.out.println(nodePackLog.getAbsolutePath());
        try
        {
        	nodePackDir.mkdir();
            nodePackLog.createNewFile();
        }
        catch(Exception exception)
        {
            System.out.println("unable to load the nodepack files - abort");
            exception.printStackTrace();
        }
        try
        {
            logPrintStream = new PrintStream(nodePackLog);
            Node_MultiPrintStream multiStreamer = new Node_MultiPrintStream(System.out,logPrintStream);
            System.setOut(multiStreamer);
            System.setErr(multiStreamer);
        }
        catch(Exception exception1)
        {
            System.err.println(exception1);
            System.exit(1);
        }
        if(nodePackDir.isDirectory())
        {
            Node_BlockIDFilter blockidfilter = new Node_BlockIDFilter();
            File afile[] = nodePackDir.listFiles(blockidfilter);
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
            trace((new StringBuilder()).append("searching in directory: ").append(nodePackDir.getAbsolutePath()).toString());
            File afile1[] = nodePackDir.listFiles(optionsfilter);
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
