package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public enum Node_EnumToolMaterial
{
	NETHER(2, 200, 5F, 2),
	OBSIDIAN(4, 2341, 10F, 4);
/*
    public static EnumToolMaterial[] values()
    {
        return (EnumToolMaterial[])field_21209_j.clone();
    }

    public static EnumToolMaterial valueOf(String s)
    {
        return (EnumToolMaterial)Enum.valueOf(EnumToolMaterial.class, s);
    }
*/
    private Node_EnumToolMaterial(int j, int k, float f, int l)
    {
        field_21213_f = j;
        field_21212_g = k;
        field_21211_h = f;
        field_21210_i = l;
    }

    public int func_21207_a()
    {
        return field_21212_g;
    }

    public float func_21206_b()
    {
        return field_21211_h;
    }

    public int func_21205_c()
    {
        return field_21210_i;
    }

    public int func_21208_d()
    {
        return field_21213_f;
    }
/*
    public static final EnumToolMaterial WOOD;
    public static final EnumToolMaterial STONE;
    public static final EnumToolMaterial IRON;
    public static final EnumToolMaterial EMERALD;
    public static final EnumToolMaterial GOLD;
*/
    private final int field_21213_f;
    private final int field_21212_g;
    private final float field_21211_h;
    private final int field_21210_i;
/*
    private static final EnumToolMaterial field_21209_j[]; /* synthetic field */
/*
    static 
    {
        WOOD = new EnumToolMaterial("WOOD", 0, 0, 59, 2.0F, 0);
        STONE = new EnumToolMaterial("STONE", 1, 1, 131, 4F, 1);
        IRON = new EnumToolMaterial("IRON", 2, 2, 250, 6F, 2);
        EMERALD = new EnumToolMaterial("EMERALD", 3, 3, 1561, 8F, 3);
        GOLD = new EnumToolMaterial("GOLD", 4, 0, 32, 12F, 0);
        field_21209_j = (new EnumToolMaterial[] {
            WOOD, STONE, IRON, EMERALD, GOLD
        });
    }
*/
}