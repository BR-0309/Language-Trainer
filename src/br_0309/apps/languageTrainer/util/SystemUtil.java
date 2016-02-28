package br_0309.apps.languageTrainer.util;

import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemUtil {

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

    /**
     * Returns the file/folder of the coe source
     */
    public static File getFile() throws URISyntaxException {
        return new File(SystemUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    }

    /**
     * @return the current time and date in format: <b>yyy-MM-dd_hhmmss</b>
     */
    public static String getTimeAndDate() {
        return new SimpleDateFormat("yyyy-MM-dd_hhmmss").format(new Date());
    }

    /**
     * @return the user's home directory
     */
    public static String getUserHome() {
        return System.getProperty("user.home");
    }

    public static String getTimeAndDataFormatted() {
        return new SimpleDateFormat("HH:mm:ss dd/MM/yyyy zzz").format(new Date());
    }

}
