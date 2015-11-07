package br_0309.apps.languageTrainer.scenes.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.data.ExerciseData;
import br_0309.apps.languageTrainer.data.ListStatistics;
import br_0309.apps.languageTrainer.data.VocabularyData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class ControllerTranslate implements Initializable, IController {

	@FXML
	public Label lblCorrect;
	@FXML
	public Label lblIncorrect;
	@FXML
	public Label lblProgress;
	@FXML
	public Label lblList;
	@FXML
	public ProgressBar progressBar;
	@FXML
	public Button btnNext;
	@FXML
	public Button btnExit;
	@FXML
	public Label lblTitle;
	@FXML
	public Label lblTask;
	@FXML
	public TextField txtAnswer;

	private ResourceBundle BUNDLE;
	private ArrayList<VocabularyData> words = new ArrayList<VocabularyData>();
	private ArrayList<VocabularyData> cheated = new ArrayList<VocabularyData>();
	private ArrayList<ListStatistics> stats = new ArrayList<ListStatistics>();
	private ArrayList<ExerciseData> rest = new ArrayList<ExerciseData>();
	private int correct;
	private int incorrect;
	private int skipped;

	@Override
	public void initialize(URL arg0, ResourceBundle bundle) {
		BUNDLE = bundle;
	}

	public void onNext() {
		VocabularyData oldData = words.get(0);
		if (oldData.isCorrect(txtAnswer.getText().trim())) {
			LanguageTrainer.playSoundCorrect();
			if (!cheated.contains(oldData)) {
				correct++;
				for (ListStatistics stat : stats) {
					if (stat.listName.equals(oldData.getTitle())) {
						stat.correct++;
					}
				}
			}
			words.remove(0);
		} else {
			LanguageTrainer.playSoundIncorrect();
			Collections.shuffle(words, LanguageTrainer.random);
			incorrect++;
		}
		if (words.isEmpty()) {

			return;
		} else {
			lblCorrect.setText(Integer.toString(correct));
			lblIncorrect.setText(Integer.toString(incorrect));
		}
	}

	@Override
	public void onExit() {
		// TODO Save statistics

	}

	@Override
	public void onInsert(char c) {
		txtAnswer.setText(txtAnswer.getText() + c);
	}

	public void init(ArrayList<ExerciseData> lists) {

	}

}
