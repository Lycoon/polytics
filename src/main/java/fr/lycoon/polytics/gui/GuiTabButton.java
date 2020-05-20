package fr.lycoon.polytics.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;

public class GuiTabButton extends GuiScreen
{
	GuiScreen gui;
	TabButton[] tabArray;
	
	public GuiTabButton(GuiScreen gui)
	{
		this.gui = gui;
		
		tabArray = new TabButton[3];
		
		tabArray[0] = new TabButton(0, 0, 0, "Home");
		tabArray[1] = new TabButton(1, getStringWidth(0) + 50, 200, "Calendar");                       // Les id des boutons commenceront de 0 à n
		tabArray[2] = new TabButton(2, getStringWidth(0) + getStringWidth(1) + 20, 100, "Candidates"); // Il faudra donc penser à mettre n+1 sur les boutons des autres Gui
	}
	
	@Override
	public void actionPerformed(GuiButton btn)
	{
		for (int i = 0; i < tabArray.length; i++)
		{
			switch (tabArray[i].id)
			{
				case 0:
					GuiHandler.showGui(0);
					break;
				case 1:
					GuiHandler.showGui(1);
					break;
				case 2:
					GuiHandler.showGui(2);
					break;
			}
		}
	}
	
	private int getStringWidth(int id) // Je raccourcis la fonction de base car trop longue à écrire dans les instances de bouton
	{
		return this.gui.mc.fontRenderer.getStringWidth(tabArray[id].displayString);
	}
}
