package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.io.File;
import java.io.FilenameFilter;

public class Node_BlockIDFilter
    implements FilenameFilter
{

    public Node_BlockIDFilter()
    {
    }

    public boolean accept(File file, String s)
    {
        return s.matches("NodeID_[\\w]*.txt");
    }
}
