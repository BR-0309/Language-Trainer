package br_0309.apps.languageTrainer.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class SystemUtil {

	public static boolean isJar() {
		try {
			return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getName().endsWith(".jar");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isExe() {
		try {
			return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getName().endsWith(".exe");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isDirectory() {
		try {
			return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI()).isDirectory();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isMacApp() {
		try {
			File file = new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			return file.getName().endsWith(".app") && file.isDirectory();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}

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

	public static boolean isMac() {
		return System.getProperty("os.name").startsWith("Mac");
	}

	public static boolean isWindows() {
		return System.getProperty("os.name").startsWith("Windows");
	}

}
