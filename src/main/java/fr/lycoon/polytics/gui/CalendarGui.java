package fr.lycoon.polytics.gui;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import fr.lycoon.polytics.gui.ArrowButton.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class CalendarGui extends GuiScreen {
	
	SimpleDateFormat df;
	String[] weekDays;
	LocalDate localDate;
	Calendar cal;
	Date date;
	DateFormatSymbols dfs;
	
	public CalendarGui(Calendar cal)
	{
		this.cal = cal;
	}
	
	@Override
	public void initGui()
	{
		localDate = LocalDate.now();
		
		// Génération des jours du mois
		int y = 0; int i = 1; int x = getFirstDayOfMonth();
		while (i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH))
		{
			if (x >= 7) // Passe à une nouvelle ligne
			{
				x = 0;
				y++;
			}
			
			if (i > cal.getMaximum(Calendar.DAY_OF_MONTH)) // Si tous les jours du mois ont été affichés
				break;
			
			CalendarDayButton day = new CalendarDayButton(i+1, 
					width/2-135 + 40*x, 
					height/2-40 + 25*y, 
					30, 25, 
					String.valueOf(i),
					i == Calendar.DAY_OF_MONTH);
			
			//if (Period.between(
					//LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)-1, i), 
					//LocalDate.now()).getDays() > 1) // Si les jours sont déjà passés, alors on les désactive
				//day.enabled = false;
			
			this.buttonList.add(day);
			x++; i++;
		}
		
		this.buttonList.add(new ArrowButton(0, width/2-165, height/2, 20, 20, Side.LEFT));
		this.buttonList.add(new ArrowButton(1, width/2+145, height/2, 20, 20, Side.RIGHT));
		
		Locale lang = new Locale(System.getProperty("user.language"));
		df = new SimpleDateFormat("LLLL YYYY", lang);
		dfs = new DateFormatSymbols(lang);
		weekDays = rearrangeDaysList(dfs.getShortWeekdays());
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		drawRect(width/2 - 145, height/2 + 90, width/2 + 145, height/2 - 60, 0x70000000);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		this.drawCenteredString(fontRenderer, "§lCalendar", width/2, height/2 - 100, 0xffffff);
		this.drawCenteredString(fontRenderer, df.format(cal.getTime()), width/2, height/2 - 78, 0xffffff);
		
		// Affichage des jours de la semaine
		for (int i = 0; i < 7; i++)
		{
			this.drawCenteredString(fontRenderer, weekDays[i], width/2-120 + 40*i, height/2 - 50, 0xffffff);
			//cal.set(Calendar.DAY_OF_MONTH, i);
			//dfs.getShortWeekdays()[cal.getTime().getDay()+1]
		}
	}
	
	public void actionPerformed(GuiButton btn)
	{
		if (btn.id == 0) // Flèche gauche
		{
			cal.add(Calendar.MONTH, -1);
			Minecraft.getMinecraft().displayGuiScreen(new CalendarGui(cal));
		}
		else if (btn.id == 1) // Flèche droite
		{
			cal.add(Calendar.MONTH, 1);
			Minecraft.getMinecraft().displayGuiScreen(new CalendarGui(cal));
		}
		else // Jours
		{
			int day = btn.id - 1;
			System.out.println(day);
		}
	}
	
	public String[] rearrangeDaysList(String[] days)
	{
		String last = days[1];
		String[] newDays = new String[7];
		for (int i = 0; i < 6; i++)
		{
			newDays[i] = days[i+2];
		}
		newDays[6] = last;
		
		return newDays;
	}
	
	public int getFirstDayOfMonth()
	{
		Calendar firstDay = Calendar.getInstance();
		firstDay.setTime(cal.getTime());
		firstDay.set(Calendar.DAY_OF_MONTH, 0);
		
		return firstDay.get(Calendar.DAY_OF_WEEK)-1;
	}
}
