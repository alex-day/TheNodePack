package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;

public class Node_ItemFireWand extends Item
{

    protected Node_ItemFireWand(int i, int j)
    {
        super(i);
        setMaxDamage(j);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        EntityFireball entityfireball = new EntityFireball(world);
        entityfireball.setLocationAndAngles(entityplayer.posX, entityplayer.posY + (double)entityplayer.getEyeHeight(), entityplayer.posZ, entityplayer.rotationYaw, entityplayer.rotationPitch);
        entityfireball.posX -= MathHelper.cos((entityfireball.rotationYaw / 180F) * 3.141593F) * 0.16F;
        entityfireball.posY -= 0.10000000149011612D;
        entityfireball.posZ -= MathHelper.sin((entityfireball.rotationYaw / 180F) * 3.141593F) * 0.16F;
        entityfireball.setPosition(entityfireball.posX, entityfireball.posY, entityfireball.posZ);
        entityfireball.yOffset = 0.0F;
        entityfireball.field_9405_b = -MathHelper.sin((entityfireball.rotationYaw / 180F) * 3.141593F) * MathHelper.cos((entityfireball.rotationPitch / 180F) * 3.141593F);
        entityfireball.field_9403_d = MathHelper.cos((entityfireball.rotationYaw / 180F) * 3.141593F) * MathHelper.cos((entityfireball.rotationPitch / 180F) * 3.141593F);
        entityfireball.field_9404_c = -MathHelper.sin((entityfireball.rotationPitch / 180F) * 3.141593F);
        func_25018_h(entityfireball, entityfireball.field_9405_b, entityfireball.field_9403_d, entityfireball.field_9404_c, 1.5F, 1.0F);
        Vec3D vec3d = entityplayer.getLook(1.0F);
        entityfireball.posX = entityfireball.posX + vec3d.xCoord * 2D;
        entityfireball.posY = entityfireball.posY + vec3d.yCoord * 2D;
        entityfireball.posZ = entityfireball.posZ + vec3d.zCoord * 2D;
        world.entityJoinedWorld(entityfireball);
        entityplayer.swingItem();
        itemstack.damageItem(1, null);
        return itemstack;
    }

    public void func_25018_h(EntityFireball entityfireball, double d, double d1, double d2, 
            float f, float f1)
    {
        float f2 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
        d /= f2;
        d1 /= f2;
        d2 /= f2;
        Random random = new Random();
        d += random.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d1 += random.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d2 += random.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d *= f;
        d1 *= f;
        d2 *= f;
        entityfireball.field_9405_b = d / 10D;
        entityfireball.field_9403_d = d1 / 10D;
        entityfireball.field_9404_c = d2 / 10D;
        float f3 = MathHelper.sqrt_double(d * d + d2 * d2);
        entityfireball.prevRotationYaw = entityfireball.rotationYaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
        entityfireball.prevRotationPitch = entityfireball.rotationPitch = (float)((Math.atan2(d1, f3) * 180D) / 3.1415927410125732D);
    }

    public boolean isFull3D()
    {
        return true;
    }

    private int field_25019_b;
}
