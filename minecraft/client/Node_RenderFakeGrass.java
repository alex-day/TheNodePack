package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class Node_RenderFakeGrass extends Render
{

    public Node_RenderFakeGrass()
    {
		random = new Random();
		renderBlocks = new RenderBlocks();
    }

	
	public void renderBlockHere(World world, double x, double y, double z, Block block, int i, int j){
		Tessellator tessellator = Tessellator.instance;

		y = y + 1;
		
		/*
			0 - in hand
			1 - in world as item
			2 - in GUI
		*/
		int renderType = 1;
		
		int l = 0;
        float f = 0;
        float f1 = 0;
        float f2 = 0;
		float f3 = 0;
		
		l = block.colorMultiplier(world, (int)x, (int)y, (int)z);
		f = (float)(l >> 16 & 0xff) / 255F;
		f1 = (float)(l >> 8 & 0xff) / 255F;
		f2 = (float)(l & 0xff) / 255F;
		
		
		block.setBlockBoundsForItemRender();
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		
		f3 = getBrightness(world, block, (int)x, (int)y, (int)z, i);		
		tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);
			
		renderBlocks.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		
		f3 = getBrightness(world, block, (int)x, (int)y, (int)z, i);	
		tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);
			
		renderBlocks.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		
		f3 = getBrightness(world, block, (int)x, (int)y, (int)z, i);	
		tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);
			
		renderBlocks.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		
		f3 = getBrightness(world, block, (int)x, (int)y, (int)z, i);	
		tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);
			
		renderBlocks.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		
		f3 = getBrightness(world, block, (int)x, (int)y, (int)z, i);	
		tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);
			
		renderBlocks.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		
		f3 = getBrightness(world, block, (int)x, (int)y, (int)z, i);	
		tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);
			
		renderBlocks.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, i));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

	
	
	public float getBrightness(World w, Block b, int x, int y, int z, int i){
		float returnValue = 0.0F;
		int counter = 0;
		
		returnValue = b.getBlockBrightness(w, x, y, z);
		
		if(returnValue <= 0.05F){
			returnValue = 0.05F;
		}
		/*	
		while(returnValue <= 0.01F && counter < 9){
			
			if(counter == 0){
				int temp = y - 1;
				returnValue = b.getBlockBrightness(w, x, temp, z);
			} else if(counter == 1){
				int temp = y + 1;
				returnValue = b.getBlockBrightness(w, x, temp, z);
			} else if(counter == 2){
				int temp = z - 1;
				returnValue = b.getBlockBrightness(w, x, y, temp);
			} else if(counter == 3){
				int temp = z + 1;
				returnValue = b.getBlockBrightness(w, x, y, temp);
			} else if(counter == 4){
				int temp = x - 1;
				returnValue = b.getBlockBrightness(w, temp, y, z);
			} else if(counter == 5){
				int temp = x + 1;
				returnValue = b.getBlockBrightness(w, temp, y, z);
			} else if(counter == 6){
				returnValue = 0.01F;
				counter = 10;
			} else if(counter == 7){
			
			} else if(counter == 8){
			
			} else {
				returnValue = 0.01F;
			}
			
			
			counter++;
		}
		*/
		return returnValue;
	}
	
	public void renderInventoryBlock(Block block, int i, int j, World world){
		Tessellator tessellator = Tessellator.instance;

		/*
			0 - in hand
			1 - in world as item
			2 - in GUI
		
		int renderType = 0;
		
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		
		boolean check1 = false; //if true then is 1 or 2 else is 0
		boolean check2 = false; //if true is 2 else 1 ONLY if check1 = true
		
		for(int a = 0; a < stack.length; a++){
			String tempString = stack[a].toString();
			
			int index = tempString.indexOf(".av.");
				
			if(index != -1){
				check1 = true;			
				int subIndex = tempString.indexOf(".a(");			
				
				if(subIndex != -1){
					check2 = true;
				}			
			}
		}
		
		if(check1){
			if(check2){
				renderType = 2;
			} else {
				renderType = 1;
			}
		} else {
			renderType = 0;
		}
		*/
		
		int l = 0;
        float f = 0;
        float f1 = 0;
        float f2 = 0;
		float f3 = 0;
		EntityPlayer player = null;
		
		player = (EntityPlayer)world.playerEntities.get(0);
		l = block.colorMultiplier(world, (int)player.posX, (int)player.posY, (int)player.posZ);
		f = (float)(l >> 16 & 0xff) / 255F;
		f1 = (float)(l >> 8 & 0xff) / 255F;
		f2 = (float)(l & 0xff) / 255F;
			
		block.setBlockBoundsForItemRender();
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);

			f3 = getInvBrightness(world, block, (int)player.posX, (int)player.posY, (int)player.posZ, i);		
            tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);

		renderBlocks.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);

			f3 = getInvBrightness(world, block, (int)player.posX, (int)player.posY, (int)player.posZ, i);
            tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);

		renderBlocks.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);

			f3 = getInvBrightness(world, block, (int)player.posX, (int)player.posY, (int)player.posZ, i);
            tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);

		renderBlocks.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);

			f3 = getInvBrightness(world, block, (int)player.posX, (int)player.posY, (int)player.posZ, i);
            tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);

		renderBlocks.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);

			f3 = getInvBrightness(world, block, (int)player.posX, (int)player.posY, (int)player.posZ, i);
            tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);

		renderBlocks.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, i));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);

			f3 = getInvBrightness(world, block, (int)player.posX, (int)player.posY, (int)player.posZ, i);
            tessellator.setColorOpaque_F(f * f3, f1 * f3, f2 * f3);

		renderBlocks.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, i));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

	public float getInvBrightness(World w, Block b, int x, int y, int z, int i){
		float returnValue = 0.0F;
		
		returnValue = 1.0F;	
		
		return returnValue;
	}
	
    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
		if(((EntityItem)entity).item.itemID ==  mod_Node_FakeGrass.fakeGrass.blockID){
			RenderTheGrass(((EntityItem)entity), d, d1, d2, f, f1);
		} else {
			doRenderItem((EntityItem)entity, d, d1, d2, f, f1);
		}
    }
	
	
    public void RenderTheGrass(EntityItem fakeGrass, double d, double d1, double d2, 
            float f, float f1)
    {
        random.setSeed(187L);
        ItemStack itemstack = fakeGrass.item;
        GL11.glPushMatrix();
        float f2 = MathHelper.sin(((float)fakeGrass.age + f1) / 10F + fakeGrass.field_804_d) * 0.1F + 0.1F;
        float f3 = (((float)fakeGrass.age + f1) / 20F + fakeGrass.field_804_d) * 57.29578F;
        byte byte0 = 1;
        if(fakeGrass.item.stackSize > 1)
        {
            byte0 = 2;
        }
        if(fakeGrass.item.stackSize > 5)
        {
            byte0 = 3;
        }
        if(fakeGrass.item.stackSize > 20)
        {
            byte0 = 4;
        }
        GL11.glTranslatef((float)d, (float)d1 + f2, (float)d2);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
		
        if(itemstack.itemID < 256 && renderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
        {
		
            GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
            loadTexture("/terrain.png");
            float f4 = 0.25F;
            /*
			if(!Block.blocksList[itemstack.itemID].renderAsNormalBlock() && itemstack.itemID != Block.stairSingle.blockID)
            {
                f4 = 0.5F;
            }
			*/
            GL11.glScalef(f4, f4, f4);
            for(int j = 0; j < byte0; j++)
            {
                GL11.glPushMatrix();
                if(j > 0)
                {
                    float f5 = ((random.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    float f7 = ((random.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    float f9 = ((random.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    GL11.glTranslatef(f5, f7, f9);
                }
                //renderBlocks.renderBlockOnInventory(Block.blocksList[itemstack.itemID], itemstack.getItemDamage()); 				
				//System.out.println(fakeGrass.posX+" - "+fakeGrass.posY+" - "+fakeGrass.posZ);
				
				renderBlockHere(fakeGrass.worldObj, fakeGrass.posX, fakeGrass.posY, fakeGrass.posZ, Block.blocksList[itemstack.itemID], itemstack.getItemDamage(), (Block.blocksList[itemstack.itemID]).getRenderType());
				
                GL11.glPopMatrix();
            }
		
        } else
        {

        }
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glPopMatrix();
    }
	

	
	/*	DO NOT CHANGE, COPY AND PASTE FROM ITEMRENDERER	*/
	public void doRenderItem(EntityItem entityitem, double d, double d1, double d2, 
            float f, float f1)
    {
        random.setSeed(187L);
        ItemStack itemstack = entityitem.item;
        GL11.glPushMatrix();
        float f2 = MathHelper.sin(((float)entityitem.age + f1) / 10F + entityitem.field_804_d) * 0.1F + 0.1F;
        float f3 = (((float)entityitem.age + f1) / 20F + entityitem.field_804_d) * 57.29578F;
        byte byte0 = 1;
        if(entityitem.item.stackSize > 1)
        {
            byte0 = 2;
        }
        if(entityitem.item.stackSize > 5)
        {
            byte0 = 3;
        }
        if(entityitem.item.stackSize > 20)
        {
            byte0 = 4;
        }
        GL11.glTranslatef((float)d, (float)d1 + f2, (float)d2);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        if(itemstack.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
        {
            GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
            loadTexture("/terrain.png");
            float f4 = 0.25F;
            if(!Block.blocksList[itemstack.itemID].renderAsNormalBlock() && itemstack.itemID != Block.stairSingle.blockID)
            {
                f4 = 0.5F;
            }
            GL11.glScalef(f4, f4, f4);
            for(int j = 0; j < byte0; j++)
            {
                GL11.glPushMatrix();
                if(j > 0)
                {
                    float f5 = ((random.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    float f7 = ((random.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    float f9 = ((random.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    GL11.glTranslatef(f5, f7, f9);
                }
                renderBlocks.renderBlockOnInventory(Block.blocksList[itemstack.itemID], itemstack.getItemDamage());
                GL11.glPopMatrix();
            }

        } else
        {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            int i = itemstack.getIconIndex();
            if(itemstack.itemID < 256)
            {
                loadTexture("/terrain.png");
            } else
            {
                loadTexture("/gui/items.png");
            }
            Tessellator tessellator = Tessellator.instance;
            float f6 = (float)((i % 16) * 16 + 0) / 256F;
            float f8 = (float)((i % 16) * 16 + 16) / 256F;
            float f10 = (float)((i / 16) * 16 + 0) / 256F;
            float f11 = (float)((i / 16) * 16 + 16) / 256F;
            float f12 = 1.0F;
            float f13 = 0.5F;
            float f14 = 0.25F;
            for(int k = 0; k < byte0; k++)
            {
                GL11.glPushMatrix();
                if(k > 0)
                {
                    float f15 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f16 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f17 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    GL11.glTranslatef(f15, f16, f17);
                }
                GL11.glRotatef(180F - renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 1.0F, 0.0F);
                tessellator.addVertexWithUV(0.0F - f13, 0.0F - f14, 0.0D, f6, f11);
                tessellator.addVertexWithUV(f12 - f13, 0.0F - f14, 0.0D, f8, f11);
                tessellator.addVertexWithUV(f12 - f13, 1.0F - f14, 0.0D, f8, f10);
                tessellator.addVertexWithUV(0.0F - f13, 1.0F - f14, 0.0D, f6, f10);
                tessellator.draw();
                GL11.glPopMatrix();
            }

        }
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glPopMatrix();
    }

	
	private Random random;
	private RenderBlocks renderBlocks;
}
