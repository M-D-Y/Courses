

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class StartDemo {

	public static void main(String args[]) {
		String demo = null;
		demo = "FileOutputStreamDemo2";
		// System.exit(0);
		start(demo);
	}

	static void start(String classToRun) {
		try {
			final Class<?> clazz = Class.forName(classToRun);
			final Method method = clazz.getMethod("main", String[].class);

			final Object[] varargs = new Object[1];
			varargs[0] = new String[] {};
			method.invoke(null, varargs);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	};

	static void startFromUrl(String classToRun) {
		try {
			URL[] urls = null;
			URLClassLoader urlLoader;

			// urls = new URL();

			urlLoader = new URLClassLoader(urls);

			@SuppressWarnings("rawtypes")
			Class runClass = urlLoader.loadClass(classToRun);

			Object[] arguments = new Object[] {};
			Method mainMethod = runClass.getMethod("main", String[].class);
			mainMethod.invoke(null, arguments);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}