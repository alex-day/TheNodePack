package net.minecraft.src;

public class Node_ItemFluro extends ItemBlock
{

    public Node_ItemFluro(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
	
    public int getMetadata(int i)
    {
        return i;
    }
    
}
