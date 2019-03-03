package com.shiny.joypadmod.devices;

//import org.lwjgl.LWJGLException;
import org.lwjgl.glfw.GLFW;
//import org.lwjgl.input.Controllers;

import com.shiny.joypadmod.helpers.LogHelper;

public class LWJGLibrary extends InputLibrary {
	
	LWJGLDeviceWrapper theDevice;
	LWJGLDeviceWrapper tempDevice;


	// TODO not sure of exception replacement
	@Override
	public void create() { //throws LWJGLException {
		//Controllers.create();
		theDevice = new LWJGLDeviceWrapper(0);
		tempDevice = new LWJGLDeviceWrapper(0);
	}

	@Override
	public Boolean isCreated() {
		return true;
//		return Controllers.isCreated();
	}

	@Override
	public void clearEvents() {
		//Controllers.clearEvents();
	}

	@Override
	public InputDevice getController(int index) {
		theDevice.setIndex(index);
		return theDevice;
	}

	@Override
	public int getControllerCount() {
		for (int i = 0; i <= 15; i++) {
			if (GLFW.glfwGetJoystickName(i) == null) {
				return i+1;
			}
		}
		return 0;
	}

	@Override
	public InputDevice getEventSource() {

		// TODO
		//tempDevice.setIndex(Controllers.getEventSource().getIndex());
		return tempDevice;
	}

	@Override
	public int getEventControlIndex() {
		// TODO
		return 0;
		//return Controllers.getEventControlIndex();
	}

	@Override
	public Boolean isEventButton() {
		// TODO
		return false;
//		return Controllers.isEventButton();
	}

	@Override
	public Boolean isEventAxis() {
		// TODO
		return false;
//		return Controllers.isEventAxis();
	}

	@Override
	public Boolean isEventPovX() {
		// TODO
		return false;
//		return Controllers.isEventPovX();
	}

	@Override
	public Boolean isEventPovY() {
		// TODO
		return false;
//		return Controllers.isEventPovY();
	}

	@Override
	public Boolean next() {
		// TODO
		return false;
		// return Controllers.next();
	}

	@Override
	public void poll() {
		return; // polling happens within Minecraft itself so no need to do our own		
	}
	
	@Override
	public Boolean wasDisconnected() {
		return false; // not supported in this library
	}

	@Override
	public Boolean wasConnected() {
		return false; // not supported in this library
	}

	@Override
	public InputDevice getCurrentController() {
		return theDevice;
	}

}
