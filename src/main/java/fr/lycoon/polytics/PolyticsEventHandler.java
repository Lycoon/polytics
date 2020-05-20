package fr.lycoon.polytics;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PolyticsEventHandler 
{
    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event)
    {
        System.out.println("Item ramassé");
    }
}
