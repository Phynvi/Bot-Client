package com.client.api.method;

import java.lang.reflect.Method;

import com.client.core.Client;
import com.client.data.Constants;
import com.client.data.Variables;
import com.client.reflection.Int;
import com.client.reflection.Objects;

public class Game {

	public static Client client = Variables.getEngine().getClient();
	public static String main = Constants.mainClass;
	public static Object clientObj = Variables.getEngine().getClient().getClient();

	public static void doAction(final int i) {
		try {
			final ClassLoader cl = client.classLoader;
			final Class<?> c = cl.loadClass(main);
			for (final Method m : c.getDeclaredMethods()) {
				if (m != null) {
					if (m.getName().equals(Constants.doAction)) {
						if (m.getParameterCount() == 1) {
							m.setAccessible(true);
							m.invoke(clientObj, i);
						}
					}
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	public static int getBaseX() {
		return Int.getInstance().getInt(main, Constants.baseX, clientObj);
	}

	public static int getBaseY() {
		return Int.getInstance().getInt(main, Constants.baseY, clientObj);
	}

	public static int getLoopCycle() {
		return Int.getInstance().getInt(main, Constants.loopCycle, clientObj);
	}

	public static int getOpenInterfaceID() {
		return Int.getInstance().getInt(main, Constants.openInterfaceID, clientObj);
	}

	public static int getPlane() {
		return Int.getInstance().getInt(main, Constants.plane, clientObj);
	}

	public static void setMenuAction1(final int value, final int index) {
		Int.getInstance().setIntArray(main, Constants.menuActionCmd1, clientObj,
				index, value);
	}

	public static void setMenuAction2(final int value, final int index) {
		Int.getInstance().setIntArray(main, Constants.menuActionCmd2, clientObj,
				index, value);
	}

	public static void setMenuAction3(final int value, final int index) {
		Int.getInstance().setIntArray(main, Constants.menuActionCmd3, clientObj,
				index, value);
	}

	public static void setMenuAction4(final int value, final int index) {
		Int.getInstance().setIntArray(main, Constants.menuActionCmd4, clientObj,
				index, value);
	}

	public static void setMenuActionId(final int value, final int index) {
		Int.getInstance().setIntArray(main, Constants.menuActionID, clientObj, index,
				value);
	}
    public static Object[][][] getGroundItems() {
        return (Object[][][]) Objects.getInstance().get3DObjectArray(Constants.mainClass, Constants.groundArray, client.getClient(), Constants.dequeClass);
    }
	public static Object getScene() {
	return Objects.getInstance().getObject(Constants.mainClass, Constants.worldController, client.getClient(), Constants.worldControllerClass);
}
}
