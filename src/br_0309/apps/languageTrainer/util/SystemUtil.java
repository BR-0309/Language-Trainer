package br_0309.apps.languageTrainer.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Add Linux stuff
public class SystemUtil {

	/**
	 * @return if the application is run as a jar file
	 */
	public static boolean isJar() {
		try {
			return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getName().endsWith(".jar");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @return if the application is run as an exe file
	 */
	public static boolean isExe() {
		try {
			return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getName().endsWith(".exe");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @return if the application is run from a directory (loose class files)
	 */
	public static boolean isDirectory() {
		try {
			return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI()).isDirectory();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @return if the application is run as a mac application bundle file
	 */
	public static boolean isMacApp() {
		try {
			File file = new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			return file.getName().endsWith(".app") && file.isDirectory();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	/** Launches a mac app bunlde */
	public static void launchMacApp(String dir) throws IOException {
		if (isMac()) {
			if (Desktop.isDesktopSupported()) {
				File file = new File(dir);
				if (!file.exists()) {
					System.err.println("[ERROR]: File \"" + file.getAbsolutePath() + "\" does not exist!");
					return;
				}
				Desktop.getDesktop().open(file);
			} else {
				System.err.println("[ERROR]: Desktop not supported!");
			}
		} else {
			System.err.println("[ERROR]: .app's can only be run on OS X!");
		}
	}

	/** Launches a windows exe file */
	public static void launchExe(String dir) throws IOException {
		if (isWindows()) {
			if (Desktop.isDesktopSupported()) {
				File file = new File(dir);
				if (!file.exists() || !file.getName().endsWith(".exe")) {
					System.err.println("[ERROR]: File \"" + file.getAbsolutePath() + "\" does not exist!");
					return;
				}
				Desktop.getDesktop().open(file);
			} else {
				System.err.println("[ERROR]: Desktop not supported!");
			}
		} else {
			System.err.println("[ERROR]: EXE's can only be run on windows!");
		}
	}

	/** Launches a mac app bunlde */
	public static void launchMacApp(File file) throws IOException {
		if (isMac()) {
			if (Desktop.isDesktopSupported()) {
				if (!file.exists()) {
					System.err.println("[ERROR]: File \"" + file.getAbsolutePath() + "\" does not exist!");
					return;
				}
				Desktop.getDesktop().open(file);
			} else {
				System.err.println("[ERROR]: Desktop not supported!");
			}
		} else {
			System.err.println("[ERROR]: .app's can only be run on OS X!");
		}
	}

	/** Launches a windows exe file */
	public static void launchExe(File file) throws IOException {
		if (isWindows()) {
			if (Desktop.isDesktopSupported()) {
				if (!file.exists() || !file.getName().endsWith(".exe")) {
					System.err.println("[ERROR]: File \"" + file.getAbsolutePath() + "\" does not exist!");
					return;
				}
				Desktop.getDesktop().open(file);
			} else {
				System.err.println("[ERROR]: Desktop not supported!");
			}
		} else {
			System.err.println("[ERROR]: EXE's can only be run on windows!");
		}
	}

	/** Launches a jar file */
	public static void launchJar(String dir) {
		File file = new File(dir);
		if (file.getName().endsWith(".jar")) {
			try {
				ProcessBuilder builder = new ProcessBuilder("java -jar " + file.getAbsolutePath());
				builder.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("File is not of type JAR");
		}
	}

	/** Launches a jar file */
	public static void launchJar(File file) {
		if (file.getName().endsWith(".jar")) {
			try {
				ProcessBuilder builder = new ProcessBuilder("java -jar " + file.getAbsolutePath());
				builder.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("File is not of type JAR");
		}
	}

	/**
	 * @return is running on a mac
	 */
	public static boolean isMac() {
		return System.getProperty("os.name").startsWith("Mac");
	}

	/**
	 * @return is running on windows
	 */
	public static boolean isWindows() {
		return System.getProperty("os.name").startsWith("Windows");
	}

	/** Returns the file/folder of the coe source */
	public static File getFile() throws URISyntaxException {
		return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI());
	}

	/** Restarts the application */
	public static void restart() {
		// TODO: Add linux restart
		if (isExe()) {
			try {
				launchExe(getFile());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			System.exit(0);
		} else if (isMacApp()) {
			try {
				launchMacApp(getFile());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			System.exit(0);
		} else if (isJar()) {
			try {
				launchJar(getFile());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}

	/**
	 * @return the current time and date in format: <b>yyy-mm-dd_hhmmss</b>
	 */
	public static String getTimeAndDate() {
		return new SimpleDateFormat("yyyy-mm-dd_hhmmss").format(new Date());
	}

	/** @return the user's home directory */
	public static String getUserHome() {
		return System.getProperty("user.home");
	}

	/** @return the current directory */
	public static String getCurrentDir() {
		return System.getProperty("user.dir");
	}

	public static String getTimeAndDateFormatted() {
		return new SimpleDateFormat("yy-mm-dd hh:mm").format(new Date());
	}

}
