package fr.lycoon.polytics.gui;

import fr.lycoon.polytics.ModPolytics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class CalendarDayButton extends GuiButton
{
	private static final ResourceLocation DAY = new ResourceLocation(ModPolytics.MODID, "textures/gui/day.png");
	private static final ResourceLocation CURRENT_DAY = new ResourceLocation(ModPolytics.MODID, "textures/gui/current_day.png");
	private static final ResourceLocation HOVERED_DAY = new ResourceLocation(ModPolytics.MODID, "textures/gui/hovered_day.png");
	private static final ResourceLocation OFF_DAY = new ResourceLocation(ModPolytics.MODID, "textures/gui/off_day.png");
	private boolean isCurrent;
	
	public CalendarDayButton(int buttonId, int x, int y, int width, int height, String buttonText, boolean isCurrent) 
	{
		super(buttonId, x, y, width, height, buttonText);
		this.isCurrent = isCurrent;
	}

    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
    	if (this.visible)
    	{
            FontRenderer fontrenderer = mc.fontRenderer;
            boolean hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            
            if (this.enabled)
            {
            	if (hovered)
            		mc.getTextureManager().bindTexture(HOVERED_DAY);
            	else
            		mc.getTextureManager().bindTexture(DAY);
            }
        	else
        		mc.getTextureManager().bindTexture(OFF_DAY);
            
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            drawScaledCustomSizeModalRect(this.x, this.y, 0, 0, 128, 128, this.width, this.height, 128, 128);
            drawCenteredString(fontrenderer, (hovered ? "§7§l" : "§7") +this.displayString, this.x + 15, this.y + 10, 1);
    	
            if (isCurrent)
            {
            	mc.getTextureManager().bindTexture(CURRENT_DAY);
            	drawScaledCustomSizeModalRect(this.x + 25, this.y + 17, 0, 0, 128, 128, 4, 4, 128, 128);
            }
    	}
	}
}
