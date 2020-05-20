package fr.lycoon.polytics.gui;

import fr.lycoon.polytics.ModPolytics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class TabButton extends GuiButton
{
	private static final ResourceLocation TAB = new ResourceLocation(ModPolytics.MODID, "textures/gui/menu_tab.png");
	
	public TabButton(int buttonId, int x, int y, String buttonText) 
	{
		super(buttonId, x, y, buttonText);
	}
	
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
    	if (this.visible)
    	{
            FontRenderer fontrenderer = mc.fontRenderer;
            
            this.width = fontrenderer.getStringWidth(this.displayString) + 10;
            this.height = 20;
            
            boolean hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
        	
            if (this.enabled)
        		mc.getTextureManager().bindTexture(TAB);
        	else
        		mc.getTextureManager().bindTexture(TAB);
            
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            drawScaledCustomSizeModalRect(this.x, this.y, 0, 0, 128, 50, this.width, this.height, 128, 50);
            drawCenteredString(fontrenderer, (hovered ? "§e" : "§f") +this.displayString, this.x + (this.width / 2), this.y + (this.height - 8)/2, 1);
    	}
	}
}
