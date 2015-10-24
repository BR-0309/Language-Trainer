package br_0309.apps.languageTrainer;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.ResourceBundle;

import br_0309.apps.languageTrainer.data.UniversalData;
import br_0309.apps.languageTrainer.data.UserData;
import br_0309.apps.languageTrainer.scenes.controllers.IController;
import br_0309.apps.languageTrainer.scenes.controllers.ProfileSelectController;
import br_0309.apps.languageTrainer.util.FXUtil;
import br_0309.apps.languageTrainer.util.SystemUtil;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

// FIXME: No custom icons for installer
// TODO: Add icons at different resolutions
// TODO: Add themes
public class LanguageTrainer extends Application {

	public static UserData userData = new UserData();
	public static UniversalData universalData = new UniversalData();

	public static Stage window;
	public static IController currentController;

	@Override
	public void start(Stage primaryStage) {
		try {
			Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {
				throwable.printStackTrace();
				FXUtil.showExceptionDialog("", throwable.toString(), throwable);
			});
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(Reference.LOGO)));
			window = primaryStage;
			showLogin();
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Reference.FXML_MENU), ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
			scene.getStylesheets().add(getClass().getResource(Reference.CSS_APPLICATION).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			currentController = loader.getController();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {
					// OK return false for some reason despite the
					// FXUtil.showConfirm... returns true when ok
					if (!showExitPrompt()) {
						currentController.onExit();
						event.consume();
					}
				}
			});
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Main method */
	public static void main(String[] args) {
		// Syste-specific settings
		if (SystemUtil.isWindows()) {
			File file = new File(System.getProperty("user.home") + File.separator + "AppData" + File.separator + "Roaming" + File.separator + "LanguageTrainer"
					+ File.separator);
			file.mkdirs();
			Reference.DEFAULT_SAVE_DIR = file.getAbsolutePath();

		} else if (SystemUtil.isMac()) {
			// TODO: Check Mac application support directory
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			File file = new File(System.getProperty("user.home") + File.separator + "Libraries" + File.separator + "ApplicationSupport" + File.separator);
			file.mkdirs();
			Reference.DEFAULT_SAVE_DIR = file.getAbsolutePath();
		} else {
			File file = new File(System.getProperty("user.home") + File.separator + "LanguageTrainer" + File.separator);
			file.mkdirs();
			Reference.DEFAULT_SAVE_DIR = file.getAbsolutePath();
		}
		Reference.DEFAULT_EXCERSISE_DIR = Reference.DEFAULT_SAVE_DIR + "excersises" + File.separator;
		// If the application is run from anything but loose files, redirect
		// console to log_<<time>>
		if (!SystemUtil.isDirectory() || SystemUtil.isMacApp()) {
			File log = new File(Reference.DEFAULT_SAVE_DIR + "logs" + File.separator + "log_" + SystemUtil.getTimeAndDate());
			try {
				log.getParentFile().mkdirs();
				log.createNewFile();
				PrintStream writer = new PrintStream(log);
				System.setErr(writer);
				System.setOut(writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Set language to best suited language before user settings are loaded
		LanguageHandler.setDisplayLanguage(LanguageHandler.getBestLocale());
		printSystemInfo();
		universalData.load();
		File file = new File(Reference.DEFAULT_EXCERSISE_DIR);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		universalData.addExcersiseLocation(file);
		launch(args);
	}

	/** Print all relevant information about the system, user and languages */
	private static void printSystemInfo() {
		System.out.println("Operating System:\t\t" + System.getProperty("os.name") + "\n" + "Operating System Version:\t" + System.getProperty("os.version")
				+ "\n" + "Architecture:\t\t\t" + System.getProperty("os.arch") + "\n" + "Java Version:\t\t\t" + System.getProperty("java.version") + "\n"
				+ "Java Vendor:\t\t\t" + System.getProperty("java.vendor") + "\n" + "JavaFX Version:\t\t\t" + System.getProperty("javafx.version") + "\n"
				+ "Java Home Dir:\t\t\t" + System.getProperty("java.home") + "\n" + "Temporary Dir:\t\t\t" + System.getProperty("java.io.tmpdir") + "\n"
				+ "Execution Dir:\t\t\t" + System.getProperty("user.dir") + "\n" + "User Home Dir:\t\t\t" + System.getProperty("user.home") + "\n"
				+ "System language:\t\t" + System.getProperty("user.language") + "\n" + "JVM Default Locale:\t\t" + Locale.getDefault().toString() + "\n"
				+ "Best suited locale:\t\t" + LanguageHandler.getBestLocale().toString() + "\n");
	}

	/** Shows the profile select screen */
	private void showLogin() {
		Stage stage = new Stage();
		// TODO: Add more images for better resolutions
		stage.getIcons().add(new Image(Reference.LOGO));
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Reference.FXML_PROFILE_SELECT),
				ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
		try {
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			stage.setMinWidth(350);
			stage.setMinHeight(400);
			stage.setScene(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		stage.showAndWait();
		ProfileSelectController controller = (ProfileSelectController) loader.getController();
		if (!controller.isProfileSelected) {
			System.exit(0);
		}
	}

	public static void setScene(String sceneLoc) {
		FXMLLoader loader = new FXMLLoader(LanguageTrainer.class.getResource(sceneLoc), ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
		try {
			Parent root = loader.load();
			Scene scene = new Scene(root);
			window.setScene(scene);
			currentController = (IController) loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean showExitPrompt() {
		ResourceBundle BUNDLE = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
		return FXUtil.showConfirmationDialog(BUNDLE.getString("generic.confirm"), BUNDLE.getString("generic.reallyQuit"),
				BUNDLE.getString("generic.confirmQuit"), BUNDLE.getString("generic.ok"), BUNDLE.getString("generic.cancel"));
	}

}
