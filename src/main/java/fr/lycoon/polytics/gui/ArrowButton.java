package fr.lycoon.polytics.gui;

import fr.lycoon.polytics.ModPolytics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ArrowButton extends GuiButton
{
	private static final ResourceLocation LEFT = new ResourceLocation(ModPolytics.MODID, "textures/gui/arrow_left.png");
	private static final ResourceLocation RIGHT = new ResourceLocation(ModPolytics.MODID, "textures/gui/arrow_right.png");
	private static final ResourceLocation LEFT_HOVERED = new ResourceLocation(ModPolytics.MODID, "textures/gui/arrow_left_hovered.png");
	private static final ResourceLocation RIGHT_HOVERED = new ResourceLocation(ModPolytics.MODID, "textures/gui/arrow_right_hovered.png");
	private Side side;
	
	public enum Side {
		LEFT,
		RIGHT;
	}
	
	public ArrowButton(int buttonId, int x, int y, int width, int height, Side side) 
	{
		super(buttonId, x, y, width, height, "");
		this.side = side;
	}

    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
    	if (this.visible)
    	{
            boolean hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            
            if (side == Side.LEFT)
            {
            	if (hovered)
            		mc.getTextureManager().bindTexture(LEFT_HOVERED);
            	else
            		mc.getTextureManager().bindTexture(LEFT);
            }
        	else
        	{
            	if (hovered)
            		mc.getTextureManager().bindTexture(RIGHT_HOVERED);
            	else
            		mc.getTextureManager().bindTexture(RIGHT);
        	}
            
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            drawScaledCustomSizeModalRect(this.x, this.y, 0, 0, 128, 128, this.width, this.height, 128, 128);
    	}
	}
}
