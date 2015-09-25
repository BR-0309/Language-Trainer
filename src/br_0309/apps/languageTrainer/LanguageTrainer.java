package br_0309.apps.languageTrainer;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import com.aquafx_project.AquaFx;

import br_0309.apps.languageTrainer.data.UserData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// FIXME: No custom icons for installer
public class LanguageTrainer extends Application {

	public static UserData data = new UserData();
	public static Stage window;

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		Stage one = new Stage();
		try {
			BorderPane pane = (BorderPane) FXMLLoader.load(getClass().getResource(Reference.FXML_PROFILE_SELECT),
					ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
			System.out.println(pane.getPrefWidth() + "  " + pane.getPrefHeight());
			Scene scene = new Scene(pane);
			one.setScene(scene);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		one.showAndWait();
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(Reference.FXML_MENU),
					ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
			Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
			scene.getStylesheets().add(getClass().getResource(Reference.CSS_APPLICATION).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LanguageHandler.setDisplayLanguage(LanguageHandler.getBestLocale());
		if (System.getProperty("os.name").startsWith("Mac")) {
			AquaFx.style();
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		} else if (System.getProperty("os.name").startsWith("Windows")) {

		} else {

		}
		launch(args);
		System.exit(0);
	}
}
