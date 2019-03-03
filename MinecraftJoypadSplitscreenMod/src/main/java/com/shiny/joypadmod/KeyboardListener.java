package com.shiny.joypadmod;

import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyboardListener {

    private static long mainWindowId = 0;
    private static GLFWKeyCallback keyCallback;

    public static void create() {
        mainWindowId = Minecraft.getInstance().mainWindow.getHandle();
        GLFW.glfwSetKeyCallback(mainWindowId, keyCallback = GLFWKeyCallback.create((window, key, scancode, action, mods) -> {

        }));
    }



}
