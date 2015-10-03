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

	public static void launchJar(String dir) {
		File file = new File(dir);
		if (file.getName().endsWith(".jar")) {
			try {
				ProcessBuilder builder = new ProcessBuilder("java -jar " + file.getAbsolutePath());
				builder.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void launchJar(File file) {
		if (file.getName().endsWith(".jar")) {
			try {
				ProcessBuilder builder = new ProcessBuilder("java -jar " + file.getAbsolutePath());
				builder.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
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

	public static File getFile() throws URISyntaxException {
		return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI());
	}

	public static void restart() {
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

	public static String getTimeAndDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyy-mm-dd_hhmmss");
		return format.format(new Date());
	}

}
