package br_0309.apps.languageTrainer.scenes.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

// No need for IController since it wouldn't be called anyway
public class ControllerSettings implements Initializable {

	@FXML
	public Button btnOK;
	@FXML
	public Button btnCancel;
	@FXML
	public ComboBox<String> boxCorrec;
	@FXML
	public ComboBox<String> boxIncorrect;
	@FXML
	public ComboBox<String> boxFinshed;
	@FXML
	public CheckBox chckboxPlaySounds;

	@Override
	public void initialize(URL url, ResourceBundle bundle) {

	}

}
