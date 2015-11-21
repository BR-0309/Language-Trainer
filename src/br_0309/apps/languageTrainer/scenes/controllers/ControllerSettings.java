package br_0309.apps.languageTrainer.scenes.controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.data.UserData;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

// No need for IController since it wouldn't be called anyway
public class ControllerSettings implements Initializable {

	@FXML
	public Button btnOK;
	@FXML
	public Button btnCancel;
	@FXML
	public ComboBox<String> boxCorrect;
	@FXML
	public ComboBox<String> boxIncorrect;
	@FXML
	public ComboBox<String> boxFinished;
	@FXML
	public ComboBox<String> boxTheme;
	@FXML
	public ComboBox<String> boxLanguage;
	@FXML
	public CheckBox chckboxPlaySounds;

	private HashMap<String, String> map = new HashMap<String, String>();
	private HashMap<String, Locale> mapLanguages = new HashMap<String, Locale>();
	private HashMap<String, String> mapReversed = new HashMap<String, String>();
	private ResourceBundle BUNDLE;

	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		BUNDLE = bundle;
		for (String theme : Reference.THEMES) {
			boxTheme.getItems().add(bundle.getString(theme));
			map.put(bundle.getString(theme), theme);
			mapReversed.put(theme, bundle.getString(theme));
		}
		for (String sound : Reference.SOUNDS_CORRECT) {
			String s = sound.substring(sound.lastIndexOf("/") + 1).replace(".wav", "");
			boxCorrect.getItems().add(s);
			map.put(s, sound);
			mapReversed.put(sound, s);
		}
		for (String sound : Reference.SOUNDS_INCORRECT) {
			String s = sound.substring(sound.lastIndexOf("/") + 1).replace(".wav", "");
			boxIncorrect.getItems().add(s);
			map.put(s, sound);
			mapReversed.put(sound, s);
		}
		for (String sound : Reference.SOUNDS_FINISHED) {
			String s = sound.substring(sound.lastIndexOf("/") + 1).replace(".wav", "");
			boxFinished.getItems().add(s);
			map.put(s, sound);
			mapReversed.put(sound, s);
		}
		for (Locale l : LanguageHandler.INTERFACE_LANGS) {
			boxLanguage.getItems().add(l.getDisplayName());
			mapLanguages.put(l.getDisplayName(), l);
		}
		String correct = LanguageTrainer.userData.getSoundCorrect();
		String incorrect = LanguageTrainer.userData.getSoundIncorrect();
		String finished = LanguageTrainer.userData.getSoundFinished();
		boxTheme.getSelectionModel().select(bundle.getString(LanguageTrainer.userData.getTheme()));
		boxCorrect.getSelectionModel().select(mapReversed.get(correct));
		boxIncorrect.getSelectionModel().select(mapReversed.get(incorrect));
		boxFinished.getSelectionModel().select(mapReversed.get(finished));
		boxLanguage.getSelectionModel().select(LanguageTrainer.userData.getLanguage().getDisplayName());
		chckboxPlaySounds.setSelected(LanguageTrainer.userData.getPlaySounds());
	}

	public void onCancel() {
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}

	public void onOK() {
		LanguageTrainer.userData.setPlaySounds(chckboxPlaySounds.isSelected());
		LanguageTrainer.userData.setLanguage(mapLanguages.get(boxLanguage.getSelectionModel().getSelectedItem()));
		LanguageTrainer.userData.setTheme(map.get(boxTheme.getSelectionModel().getSelectedItem()));
		LanguageTrainer.userData.setSoundCorrect(map.get(boxCorrect.getSelectionModel().getSelectedItem()));
		LanguageTrainer.userData.setSoundIncorrect(map.get(boxIncorrect.getSelectionModel().getSelectedItem()));
		LanguageTrainer.userData.setSoundFinished(map.get(boxFinished.getSelectionModel().getSelectedItem()));
		LanguageTrainer.userData.save();

		Stage stage = (Stage) btnOK.getScene().getWindow();
		stage.close();
		LanguageTrainer.showMenu();
	}

	public void onReset() {
		if (FXUtil.showConfirmationDialog(BUNDLE.getString("generic.confirm"), BUNDLE.getString("generic.confirmReset"), BUNDLE.getString("generic.noUndo"),
				BUNDLE.getString("generic.ok"), BUNDLE.getString("generic.cancel"))) {
			UserData userData = new UserData();
			boxTheme.getSelectionModel().select(BUNDLE.getString(userData.getTheme()));
			boxCorrect.getSelectionModel().select(mapReversed.get(userData.getSoundCorrect()));
			boxIncorrect.getSelectionModel().select(mapReversed.get(userData.getSoundIncorrect()));
			boxFinished.getSelectionModel().select(mapReversed.get(userData.getSoundFinished()));
			boxLanguage.getSelectionModel().select(userData.getLanguage().getDisplayName());
			chckboxPlaySounds.setSelected(userData.getPlaySounds());
		}
	}

}
