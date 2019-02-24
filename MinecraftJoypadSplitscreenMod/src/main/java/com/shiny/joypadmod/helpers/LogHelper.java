package com.shiny.joypadmod.helpers;

import org.apache.logging.log4j.Level;

import com.shiny.joypadmod.ControllerSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogHelper
{
    private static final Logger LOGGER = LogManager.getLogger();

	public static void Debug(String Message)
	{
        LOGGER.log(Level.DEBUG, Message);
	}

	public static void Error(String Message)
	{
        LOGGER.log(Level.ERROR, Message);
	}

	public static void Fatal(String Message)
	{
        LOGGER.log(Level.FATAL, Message);
	}

	public static void Info(String Message)
	{
		if (ControllerSettings.loggingLevel > 0)
            LOGGER.log(Level.INFO, Message);
	}

	public static void Trace(String Message)
	{
        LOGGER.log(Level.TRACE, Message);
	}

	public static void Warn(String Message)
	{
        LOGGER.log(Level.WARN, Message);
	}
}