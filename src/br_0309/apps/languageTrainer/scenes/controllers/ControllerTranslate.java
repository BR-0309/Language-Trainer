package br_0309.apps.languageTrainer.scenes.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

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
	private ArrayList<ExerciseData> rest = new ArrayList<ExerciseData>();
	private ArrayList<ListStatistics> stats = new ArrayList<ListStatistics>();
	private int correct;
	private int incorrect;

	@Override
	public void initialize(URL arg0, ResourceBundle bundle) {
		BUNDLE = bundle;
	}

	public void onNext() {
		// FIXME: Implement onNext
	}

	@Override
	public void onExit() {
		LanguageTrainer.userData.putStats(stats);
	}

	public void onCheat() {
		// FIXME: Implement onCheat
		// FIXME: Add cheat button
	}

	@Override
	public void onInsert(char c) {
		txtAnswer.setText(txtAnswer.getText() + c);
	}

	public void init(ArrayList<ExerciseData> lists) {
		String TRANSLATION = BUNDLE.getString("generic.translation");
		// Cycle through all selected exercises
		for (ExerciseData eData : lists) {
			// If it is of type "Translation"
			if (eData.getType().equals(TRANSLATION)) {
				File file = eData.file;
				String lang1 = eData.langs[0];
				String lang2 = eData.langs[1];
				int left = 0, right = 1;
				Scanner scan = null;
				try {
					scan = new Scanner(file);
					String[] langs = scan.nextLine().split(":");
					// Find the indices of the selected languages
					for (int i = 0; i < langs.length; i++) {
						if (langs[i].equals(lang1)) {
							left = i;
						} else if (langs[i].equals(lang2)) {
							right = i;
						}
					}
					// Cycle through all lines
					while (scan.hasNextLine()) {
						String line = scan.nextLine();
						String[] words = line.split("=");
						this.words.add(new VocabularyData(words[left].split(";"), words[right].split(";"), eData.langs));
					}

				} catch (FileNotFoundException e) {
					System.err.println("Can't find file: " + file.getName());
					e.printStackTrace();
				} finally {
					scan.close();
				}

			} else {
				// Else add to the rest list
				rest.add(eData);
			}
		}
		Collections.shuffle(words, LanguageTrainer.random);
		VocabularyData d = words.get(0);
		lblTitle.setText(BUNDLE.getString("translate.task").replace("{1}", d.getFrom()).replace("{2}", d.getTo()));
		lblTask.setText(d.getQuestion());
		updateProgressBar();
	}

	private void updateProgressBar() {
		progressBar.setProgress((double) correct / words.size());
		lblProgress.setText(correct + "/" + Integer.toString(words.size()) + " " + new Double(progressBar.getProgress() * 100).intValue() + "%");
	}

}
