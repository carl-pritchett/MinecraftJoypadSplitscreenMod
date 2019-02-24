package com.shiny.joypadmod.minecraftExtensions;

import com.shiny.joypadmod.ControllerSettings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// warning: small but non zero chance of this causing incompatibility with other mods
public class JoypadMouseHelper extends MouseHelper
{
	private static final Logger LOGGER = LogManager.getLogger();

	public JoypadMouseHelper(Minecraft minecraftIn) {
		super(minecraftIn);
	}

	/**
	 * Grabs the mouse cursor it doesn't move and isn't seen.
	 */
	@Override
	public void grabMouse()
	{
		if (ControllerSettings.isInputEnabled() && !ControllerSettings.grabMouse)
		{
			// VirtualMouse.setGrabbed(true);
			return;
		}

		super.grabMouse();
	}

	/**
	 * Ungrabs the mouse cursor so it can be moved and set it to the center of the screen
	 */
	@Override
	public void ungrabMouse()
	{
		if (ControllerSettings.isInputEnabled() && !ControllerSettings.grabMouse)
		{
			// VirtualMouse.setGrabbed(false);
			return;
		}

		super.ungrabMouse();
	}

	/*
	 * @Override public void mouseXYChange() { this.deltaX = Mouse.getDX(); this.deltaY = Mouse.getDY(); if (this.deltaX != 0 || this.deltaY != 0) { LogHelper.Info("MouseHelper dx:" + deltaX + " dy:"
	 * + deltaY); } }
	 */

	@Override
	protected void finalize() throws Throwable
	{
		try
		{
			LOGGER.warn("JoypadMouseHelper being garbage collected. "
					+ "If Minecraft not shutting down, this means another mod may have replaced it.");
		}
		catch (Throwable t)
		{
			throw t;
		}
		finally
		{
			super.finalize();
		}
	}

	// side note, I had early visions of simply Overriding the mouseXYChange() method and this mod would be
	// half done, but alas not all Minecraft uses this method.

}
