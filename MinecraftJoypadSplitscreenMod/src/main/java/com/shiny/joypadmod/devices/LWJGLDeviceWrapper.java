package com.shiny.joypadmod.devices;

import org.lwjgl.glfw.GLFW;
//import org.lwjgl.input.Controllers;
public class LWJGLDeviceWrapper extends InputDevice {

	public LWJGLDeviceWrapper(int index) {
		super(index);		
	}

	@Override
	public String getName() {
		return  GLFW.glfwGetJoystickName(myIndex);
	}

	@Override
	public int getButtonCount() {
		return GLFW.glfwGetJoystickButtons(myIndex).array().length;
		//return Controllers.getController(myIndex).getButtonCount().size;
	}

	@Override
	public int getAxisCount() {
		return GLFW.glfwGetJoystickAxes(myIndex).array().length;
		//return Controllers.getController(myIndex).getAxisCount();
	}

	@Override
	public float getAxisValue(int axisIndex) {
		return GLFW.glfwGetJoystickAxes(myIndex).get(axisIndex);
//		return Controllers.getController(myIndex).getAxisValue(axisIndex);
	}

	@Override
	public String getAxisName(int index) {
		return "Axis" + index;
//		return Controllers.getController(myIndex).getAxisName(index);
	}

	@Override
	public float getDeadZone(int index) {
		// TODO Can find deadzone mapping in GLFW so using index as a HACK
		return index;
		//return Controllers.getController(myIndex).getDeadZone(index);
	}

	@Override
	public String getButtonName(int index) {
		return "BUTTON_" + index;
		//return Controllers.getController(myIndex).getButtonName(index);
	}

	@Override
	public Boolean isButtonPressed(int index) {

		return GLFW.glfwGetJoystickButtons(myIndex).get(index) != 0;
//		return Controllers.getController(myIndex).isButtonPressed(index);
	}

	@Override
	public Float getPovX() {
		// TODO not sure what the order of values in in the float array - guessing
		return GLFW.glfwGetJoystickAxes(myIndex).get(0);
//		return Controllers.getController(myIndex).getPovX();
	}

	@Override
	public Float getPovY() {
		// TODO not sure what the order of values in in the float array - guessing
		return GLFW.glfwGetJoystickAxes(myIndex).get(1);
//		return Controllers.getController(myIndex).getPovY();
	}

	@Override
	public void setDeadZone(int axisIndex, float value) {
		// TODO Can't map deadzone in GLFW
		//Controllers.getController(myIndex).setDeadZone(axisIndex, value);
	}
	
	public void setIndex(int index)
	{
		myIndex = index;
	}

	@Override
	public Boolean isConnected() {
		return true; // if this device ever disconnects LWJGL chokes and minecraft needs to be restarted
	}

	@Override
	public int getBatteryLevel() { 
		return -1; // not supported
	}

}
