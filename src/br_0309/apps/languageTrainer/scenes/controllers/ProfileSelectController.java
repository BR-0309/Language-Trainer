package br_0309.apps.languageTrainer.scenes.controllers;

import java.io.File;
import java.net.URL;
import java.util.Hashtable;
import java.util.Optional;
import java.util.ResourceBundle;

import br_0309.apps.languageTrainer.LanguageTrainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Modality;

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
					list.getItems().add(f.getName().replace(".ltd", ""));
				}
			}
		}

	}

	public void onCancel() {
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

	// TODO public void onNewProfile

}
