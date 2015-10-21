package br_0309.apps.languageTrainer.scenes.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// FIXME: Add onClose or similar
// TODO: Add new profile editor
public class ProfileSelectController implements Initializable {

	@FXML
	public ListView<String> list;
	@FXML
	public Button newProfile;
	@FXML
	public Button delete;
	@FXML
	public Button go;
	@FXML
	public Button cancel;

	private ResourceBundle BUNDLE;
	private Hashtable<String, File> profiles = new Hashtable<String, File>();
	public boolean isProfileSelected = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BUNDLE = resources;
		for (File file : LanguageTrainer.universalData.profileLocations) {
			for (File f : file.listFiles()) {
				if (f.getName().endsWith(".ltd")) {
					profiles.put(f.getName().replace(".ltd", ""), file);
					list.getItems().add(f.getName().replace(".ltd", "").replaceAll("_", " "));
				}
			}
		}

	}

	public void onCancel() {
		// FIXME: Use FXUtil
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(BUNDLE.getString("generic.confirm"));
		alert.setHeaderText(BUNDLE.getString("generic.confirmQuit"));
		alert.initOwner(LanguageTrainer.window.getOwner());
		alert.initModality(Modality.APPLICATION_MODAL);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		}
	}

	public void onNewProfile() {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Reference.FXML_PROFILE_NEW),
				ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
		try {
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(LanguageTrainer.window);
			stage.initStyle(StageStyle.UTILITY);
			stage.sizeToScene();
			stage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stage.showAndWait();
		ProfileNewController controller = (ProfileNewController) loader.getController();
		File profile = controller.profile;
		if (profile == null) {
			return;
		}
		profile.getParentFile().mkdirs();
		try {
			profile.createNewFile();
		} catch (IOException e) {
			FXUtil.showExceptionDialog("", BUNDLE.getString("profile.createFail"), e);
		}
	}

}
