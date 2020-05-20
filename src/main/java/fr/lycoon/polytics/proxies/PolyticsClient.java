package fr.lycoon.polytics.proxies;

import fr.lycoon.polytics.PolyticsKeyHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class PolyticsClient extends PolyticsCommon
{
	public PolyticsClient()
	{		
		MinecraftForge.EVENT_BUS.register(new PolyticsKeyHandler());
	}
	
    @Override
    public void preInit(FMLPreInitializationEvent e) 
    {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) 
    {
        super.postInit(e);
    }
}
