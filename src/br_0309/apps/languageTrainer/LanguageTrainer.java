package br_0309.apps.languageTrainer;

import java.util.Locale;
import java.util.ResourceBundle;

import br_0309.apps.languageTrainer.data.UserData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// FIXME: No custom icons for installer
public class LanguageTrainer extends Application {

	public static UserData data = new UserData();

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/br_0309/apps/languageTrainer/scenes/Menu.fxml"),
					ResourceBundle.getBundle("lang.Locale", Locale.getDefault()));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/br_0309/apps/languageTrainer/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LanguageHandler.setDisplayLanguage(LanguageHandler.getBestLocale());

		// launch(args);
		System.exit(0);
	}
}
