package br_0309.apps.languageTrainer.scenes.controllers;

import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ProfileNewController implements Initializable, IController {

	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField location;
	@FXML
	private Button browse;
	@FXML
	private Button ok;
	@FXML
	private Button cancel;

	public File profile;
	private File profileUnconfirmed;

	private ResourceBundle BUNDLE;

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		location.setText(Reference.DEFAULT_PROFILE_DIR);
		BUNDLE = resources;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ok.requestFocus();
			}
		});
	}

	public void onBrowse() {
		if (firstName.getText().trim().equals("")) {
			firstName.requestFocus();
			Toolkit.getDefaultToolkit().beep();
			return;
		} else if (lastName.getText().trim().equals("")) {
			lastName.requestFocus();
			Toolkit.getDefaultToolkit().beep();
			return;
		}
		FileChooser chooser = new FileChooser();
		String filename = firstName.getText().trim() + "_" + lastName.getText().trim() + ".ltd";
		if (filename != null && !filename.equals("_.ltd")) {
			chooser.setInitialFileName(filename);
		}
		chooser.getExtensionFilters().add(new ExtensionFilter(BUNDLE.getString("generic.ltd"), ".ltd"));
		File defaultFolder = new File(location.getText());
		if (!defaultFolder.exists()) {
			defaultFolder = new File(Reference.DEFAULT_PROFILE_DIR);
		} else if (defaultFolder.isFile()) {
			defaultFolder = defaultFolder.getParentFile();
		}
		chooser.setInitialDirectory(defaultFolder);
		File file = chooser.showSaveDialog(LanguageTrainer.window);
		if (file != null) {
			location.setText(file.getAbsolutePath());
			profileUnconfirmed = file;
		}
	}

	public void onCancel() {
		Stage stage = (Stage) cancel.getScene().getWindow();
		stage.close();
	}

	public void onOk() {
		Stage stage = (Stage) ok.getScene().getWindow();
		profile = profileUnconfirmed;
		stage.close();
	}

	@Override
	public void onExit() {
	}

	@Override
	public void onInsert() {
		// TODO Auto-generated method stub

	}

}
