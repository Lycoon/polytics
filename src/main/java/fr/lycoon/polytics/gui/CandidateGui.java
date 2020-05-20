package fr.lycoon.polytics.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class CandidateGui extends GuiScreen {
	
	private GuiTabButton tab;
	
	@Override
	public void initGui()
	{
		tab = new GuiTabButton(this);
		addTabButton();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		drawRect(width/2 - 145, height/2 + 90, width/2 + 145, height/2 - 60, 0x70000000);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		this.drawCenteredString(fontRenderer, "§lCandidate", width/2, height/2 - 100, 0xffffff);
	}
	
	@Override
	public void actionPerformed(GuiButton btn)
	{
		tab.actionPerformed(btn);
	}
	
	private void addTabButton()
    {        
        for(int i = 0; i < tab.tabArray.length; i++)
            this.buttonList.add(tab.tabArray[i]);
    }
	
	public static int getId()
	{
		return 1;
	}
}
