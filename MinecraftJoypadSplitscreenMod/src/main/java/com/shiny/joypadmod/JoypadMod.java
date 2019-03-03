package com.shiny.joypadmod;

import com.shiny.joypadmod.helpers.LogHelper;
import com.shiny.joypadmod.helpers.McGuiHelper;
import com.shiny.joypadmod.helpers.ModVersionHelper;
import com.shiny.joypadmod.lwjglVirtualInput.VirtualKeyboard;
import com.shiny.joypadmod.lwjglVirtualInput.VirtualMouse;
import com.shiny.joypadmod.minecraftExtensions.JoypadMouseHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Main class for Joypad mod. This initializes everything.
 */

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


//@Mod(modid = JoypadMod.MODID, name = JoypadMod.NAME, version = ModVersionHelper.VERSION + "-" + JoypadMod.MINVERSION
//		+ JoypadMod.REVISION, clientSideOnly = true, acceptedMinecraftVersions = "[1.12,)")
// 1.6.4
// @NetworkMod(serverSideRequired = false)
@Mod("joypadsplitscreenmod")
public class JoypadMod
{
	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();

	//public static final String MODID = "joypadsplitscreenmod";
	//public static final String NAME = "Joypad / SplitScreen Mod";
	public static final float MINVERSION = 0.22f;
	//public static final String REVISION = "";

	private static ControllerSettings controllerSettings;

	private ModVersionHelper modHelper;

	public JoypadMod() {
		//INSTANCE = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		//FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		//FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverStarting);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
//		MinecraftForge.EVENT_BUS.register(new CommonEvents());
//		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.build());
	}


	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("preInit");

		MouseWrapper.create();

		// TODO Configuration files don't exist anymore
//		controllerSettings = new ControllerSettings(event.getSuggestedConfigurationFile());
		controllerSettings = new ControllerSettings(null);

		LOGGER.info("init");
		try
		{
			if (!(Minecraft.getInstance().mouseHelper instanceof net.minecraft.client.MouseHelper))
			{
				LOGGER.warn("Replacing Mousehelper that may have already been replaced by another mod!");
			}
			Minecraft.getInstance().mouseHelper = new JoypadMouseHelper(Minecraft.getInstance());
			LOGGER.info("Replaced mousehelper in Minecraft with JoypadMouseHelper");
		}
		catch (Exception ex)
		{
			LOGGER.warn("Unable to exchange mousehelper. Game may grab mouse from keyboard players!");
		}

		postInit();
	}


	public void postInit()
	{
		LOGGER.info("postInit");
		controllerSettings.init();
		try
		{
			VirtualKeyboard.create();
		}
		catch (Exception ex)
		{
			LOGGER.fatal("Unable to initialize VirtualKeyboard.  Limited compatibility with some mods likely. "
					+ ex.toString());
		}

		try
		{
			VirtualMouse.create();
		}
		catch (Exception ex)
		{
			LOGGER.fatal("Unable to initialize VirtualMouse.  Unable to continue. " + ex.toString());
			ControllerSettings.modDisabled = true;
		}

		try
		{
			McGuiHelper.create();
		}
		catch (Exception ex)
		{
			LOGGER.fatal("Unable to initialize McGuiHelper.  Unable to continue. " + ex.toString());
			ControllerSettings.modDisabled = true;
		}

		modHelper = new ModVersionHelper();
		modHelper.gameInit();
	}

}
