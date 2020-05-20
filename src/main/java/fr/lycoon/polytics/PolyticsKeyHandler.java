package fr.lycoon.polytics;

import org.lwjgl.input.Keyboard;

import fr.lycoon.polytics.gui.GuiHandler;
import fr.lycoon.polytics.gui.HomeGui;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class PolyticsKeyHandler
{
	
	 /* Si on ajoute une valeur à KeyValues alors
	 * 		Ajouter un SOMETHING_KEY = indiceKeyValues
	 */
	public static final int HOME_KEY = 0;
	
	// Il faut le même nombre de description que de touches, sinon ERREUR
	private static final String[] keyDesc = {"Home"};
	private static final int[] keyValues = {Keyboard.KEY_Y};
	private final KeyBinding[] keys;
	
	public PolyticsKeyHandler()
	{
		keys = new KeyBinding[keyValues.length];
		for (int i = 0; i < keyValues.length; i++)
		{
			keys[i] = new KeyBinding(keyDesc[i], keyValues[i], "Polytics");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event)
	{
		if (!FMLClientHandler.instance().isGUIOpen(HomeGui.class))
		{
			int key = Keyboard.getEventKey();
			boolean isDown = Keyboard.getEventKeyState();
			
			if (isDown && key == keyValues[HOME_KEY])
			{
				//Minecraft.getMinecraft().displayGuiScreen(new CalendarGui(Calendar.getInstance()));
				GuiHandler.showGui(HomeGui.getId());
			}
		}
	}
}
