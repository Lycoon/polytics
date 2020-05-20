package fr.lycoon.polytics.gui;

import java.util.Calendar;

import net.minecraft.client.Minecraft;

public class GuiHandler
{	
	public static void showGui(int id)
	{
		switch (id)
		{
			case 0:
				Minecraft.getMinecraft().displayGuiScreen(new CalendarGui(Calendar.getInstance()));
				System.out.println("HOME");
			break;
			case 1:
				Minecraft.getMinecraft().displayGuiScreen(new CalendarGui(Calendar.getInstance()));
			break;
			case 2:
				Minecraft.getMinecraft().displayGuiScreen(new CandidateGui());
				System.out.println("Candidate");
			break;
		}		
	}
}
