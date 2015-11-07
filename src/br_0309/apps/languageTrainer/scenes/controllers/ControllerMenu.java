package br_0309.apps.languageTrainer.scenes.controllers;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Predicate;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.data.ExcerciseData;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerMenu implements Initializable, IController {

	@FXML
	public TableView<ExcerciseData> table;
	@FXML
	public Button createTranslationList;
	@FXML
	public TextField search;
	@FXML
	public ComboBox<String> types;
	@FXML
	public Button viewStatistics;
	@FXML
	public Button createVerbList;
	@FXML
	public Button startTraining;

	private FilteredList<ExcerciseData> data;
	private ResourceBundle BUNDLE;

	@Override
	public void initialize(URL location, ResourceBundle BUNDLE) {
		this.BUNDLE = BUNDLE;
		initData();

		table.getColumns().get(0).setSortable(false);
		table.getColumns().get(1).setSortable(false);
		table.getColumns().get(2).setSortable(false);
		table.getColumns().get(3).setSortable(false);

		CheckBox checkbox = new CheckBox();
		checkbox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean isSelected = checkbox.isSelected();
				@SuppressWarnings("unchecked")
				Predicate<ExcerciseData> p = (Predicate<ExcerciseData>) data.getPredicate();
				for (ExcerciseData d : data) {
					if (p.test(d)) {
						d.setSelected(isSelected);
					}
				}
			}

		});
		table.getColumns().get(0).setGraphic(checkbox);

		table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("active"));
		table.getColumns().get(0).setCellFactory(tc -> new CheckBoxTableCell<>());
		table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
		table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("languages"));
		table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("type"));

		table.setItems(data);

		ArrayList<String> l = new ArrayList<String>();
		l.add(BUNDLE.getString("generic.all"));
		l.add(BUNDLE.getString("generic.translation"));
		l.add(BUNDLE.getString("generic.verbs"));
		types.setItems(FXCollections.observableList(l));
		types.getSelectionModel().select(0);

		search.textProperty().addListener((observable, oldValue, newValue) -> filter());
		types.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> filter());

		filter();
	}

	// FIXME: Split up per language combo
	private void initData() {
		final String TRANSLATION = BUNDLE.getString("generic.translation");
		ArrayList<ExcerciseData> data = new ArrayList<ExcerciseData>();
		// Get all excercise locations and store in File[] for loop
		ArrayList<File> folders = LanguageTrainer.universalData.excerciseLocations;
		// Loop through all the folders
		for (File folder : folders) {
			// Check for null or nonexistent folders
			if (folder == null) {
				System.err.println("Null reference in excercise locations!");
				continue;
			} else if (!folder.exists() || folder.isFile()) {
				System.err.print(folder.getAbsolutePath() + " does not exist or is a file!");
				continue;
			}
			// Cycle through all files in the folder
			for (File file : folder.listFiles()) {
				// Check for null/nonexistent files
				if (file == null) {
					System.err.println("Null reference file!");
					continue;
				} else if (!file.exists() || file.isDirectory()) {
					System.err.println(file.getAbsolutePath() + " does not exist or is a directory! Nested excersises are not supported!");
					continue;
				}
				// For translation files
				if (file.getName().endsWith(".tra")) {
					try {
						Scanner scan = new Scanner(file);
						String[] langs = scan.nextLine().split(":");
						scan.close();
						String name = file.getName().replaceAll("_", " ").replace(".tra", "");
						Arrays.sort(langs);
						// For each combination of languages
						for (int i = 0; i < langs.length - 1; i++) {
							for (int j = i + 1; j < langs.length; j++) {
								String lang1 = new Locale(langs[i]).getDisplayLanguage();
								String lang2 = new Locale(langs[j]).getDisplayLanguage();
								data.add(new ExcerciseData(false, name, lang1 + " " + lang2, TRANSLATION, file, new String[] { langs[i], langs[j] }));
							}
						}

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				} else if (file.getName().endsWith("vdt")) {
					// For verb files

				}
				this.data = new FilteredList<ExcerciseData>(FXCollections.observableList(data));
			}

		}
	}

	public void onStartTraining() {
		ArrayList<ExcerciseData> selected = new ArrayList<ExcerciseData>();
		for (ExcerciseData d : data) {
			if (d.isSelected()) {
				selected.add(d);
			}
		}
		if (selected.isEmpty()) {
			Toolkit.getDefaultToolkit().beep();
			table.requestFocus();
			return;
		}
		String translation = BUNDLE.getString("generic.translation");
		for (ExcerciseData d : selected) {
			if (d.getType().equals(translation)) {
				LanguageTrainer.showTranslation(selected);
			}
		}
	}

	@Override
	public void onExit() {
	}

	@Override
	public void onInsert(char c) {
		if (search.isFocused()) {
			search.setText(search.getText() + c);
		}

	}

	private void filter() {
		data.setPredicate(new Predicate<ExcerciseData>() {

			@Override
			public boolean test(ExcerciseData data) {
				if (data.getTitle().toLowerCase().contains(search.getText().toLowerCase())) {
					if (types.getSelectionModel().getSelectedIndex() == 0 || data.getType().equals(types.getSelectionModel().getSelectedItem())) { return true; }
				}
				return false;

			}
		});

	}

}
