package com.shiny.joypadmod;

//import static java.awt.SystemColor.window;
import net.minecraft.client.Minecraft;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorEnterCallback;

import java.nio.DoubleBuffer;

public class MouseWrapper {

    private static boolean windowEntered = false;
    private static GLFWCursorEnterCallback enterCallback;
    private static DoubleBuffer b1 = BufferUtils.createDoubleBuffer(1);
    private static DoubleBuffer b2 = BufferUtils.createDoubleBuffer(1);
    private static long mainWindowId;

    public static void create() {
        mainWindowId = Minecraft.getInstance().mainWindow.getHandle();

        GLFW.glfwSetCursorEnterCallback(mainWindowId, enterCallback = GLFWCursorEnterCallback.create((window, entered) -> {
            windowEntered = entered;
        }));
    }

    public static boolean isInsideWindow() {
        return windowEntered;
    }

    public static Double getDX() {
        GLFW.glfwGetCursorPos(mainWindowId, b1, b2);
        return b1.get(0);
    }

    public static Double getDY() {
        GLFW.glfwGetCursorPos(mainWindowId, b1, b2);
        return b2.get(0);
    }
}
