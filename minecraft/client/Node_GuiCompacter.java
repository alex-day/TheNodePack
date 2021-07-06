package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class Node_GuiCompacter extends GuiContainer
{

    public Node_GuiCompacter(InventoryPlayer inventoryplayer, Node_TileEntityCompacter tileentitycompacter)
    {
        super(new Node_GuiCompacterServer(inventoryplayer, tileentitycompacter));
        ySize = 166;
        compacter = tileentitycompacter;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("Compacter", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 60, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f)
    {
        int i = mc.renderEngine.getTexture("/gui/compacter.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
        if(compacter.isBurning())
        {
            int l = compacter.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(j + 117, (k + 57 + 12) - l, 176, 12 - l, 14, l + 2);
        }
        int i1 = compacter.getCookProgressScaled(24);
        drawTexturedModalRect(j + 79, k + 34, 176, 14, i1 + 1, 16);
    }

    public final Node_TileEntityCompacter compacter;
}
