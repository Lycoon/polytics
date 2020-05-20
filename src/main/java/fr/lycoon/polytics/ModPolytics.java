package fr.lycoon.polytics;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.apache.logging.log4j.Logger;

import fr.lycoon.polytics.proxies.PolyticsCommon;

@Mod(modid = ModPolytics.MODID, name = ModPolytics.NAME, version = ModPolytics.VERSION)
public class ModPolytics
{
    public static final String MODID = "polytics";
    public static final String NAME = "Polytics";
    public static final String VERSION = "1.0.1";
    
    @Instance(ModPolytics.MODID)
    public static ModPolytics instance;
    
    @SidedProxy(clientSide = "fr.lycoon.polytics.proxies.PolyticsClient", serverSide = "fr.lycoon.polytics.proxies.PolyticsServer")
    public static PolyticsCommon proxy;
    
    private static SimpleNetworkWrapper network;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog(); // event.getModLog() retourne un logger avec votre modid
        proxy.preInit(event);
        
        network = NetworkRegistry.INSTANCE.newSimpleChannel("polytics");
        MinecraftForge.EVENT_BUS.register(new PolyticsEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
        proxy.postInit(event);
    }
    
    public static CreativeTabs creativeTab = new CreativeTabs("Polytics")
    {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Item.getItemById(339));
        }
    };
}
