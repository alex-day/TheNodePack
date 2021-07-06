package net.minecraft.src;

public class Node_ItemFluro extends ItemBlock
{

    public Node_ItemFluro(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
	
	public int func_27009_a(int i)
    {
        return mod_Node_Fluro.blockFluro.getBlockTextureFromSideAndMetadata(2, i);
    }

    public int func_21012_a(int i)
    {
        return i;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return super.getItemName()+"."+colours[itemstack.getItemDamage()];
    }
	
	public static final String colours[] = {
        "white", "blue", "green"
    };
}
