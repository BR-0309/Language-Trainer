package br_0309.apps.languageTrainer.scenes.controllers;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Predicate;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.data.ExerciseData;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerMenu implements Initializable, IController {

	@FXML
	public TableView<ExerciseData> table;
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

	private FilteredList<ExerciseData> data;
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
				Predicate<ExerciseData> p = (Predicate<ExerciseData>) data.getPredicate();
				for (ExerciseData d : data) {
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
		final String VERBS = BUNDLE.getString("generic.verbs");
		ArrayList<ExerciseData> data = new ArrayList<ExerciseData>();
		// Get all exercise locations and store in File[] for loop
		ArrayList<File> folders = LanguageTrainer.universalData.exerciseLocations;
		// Loop through all the folders
		for (File folder : folders) {
			// Check for null or nonexistent folders
			if (folder == null) {
				System.err.println("Null reference in exercise locations!");
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
					System.err.println(file.getAbsolutePath() + " does not exist or is a directory! Nested exersises are not supported!");
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
								data.add(new ExerciseData(false, name, lang1 + " " + lang2, TRANSLATION, file, new String[] { langs[i], langs[j] }));
							}
						}

					} catch (Exception e) {
						System.err.print("Something went wrong while trying to read: " + file.getAbsolutePath());
						e.printStackTrace();
						continue;
					}
				} else if (file.getName().endsWith("vdt")) {
					// For verb files
					try {
						Scanner scan = new Scanner(file);
						String lang = scan.nextLine();
						scan.close();
						if (lang.length() > 3) {
							System.err.printf("Invalid lang code (%s) in file %s. Skipping.\n", lang, file.getAbsolutePath());
							continue;
						}
						data.add(new ExerciseData(false, file.getName().replaceAll("_", " ").replace(".vdt", ""), new Locale(lang).getDisplayLanguage(), VERBS,
								file, new String[] { lang }));
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					}
				}
			}
			this.data = new FilteredList<ExerciseData>(FXCollections.observableList(data));
		}
	}

	public void onStartTraining() {
		ArrayList<ExerciseData> selected = new ArrayList<ExerciseData>();
		for (ExerciseData d : data) {
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
		for (ExerciseData d : selected) {
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
		data.setPredicate(new Predicate<ExerciseData>() {

			@Override
			public boolean test(ExerciseData data) {
				if (data.getTitle().toLowerCase().contains(search.getText().toLowerCase())) {
					if (types.getSelectionModel().getSelectedIndex() == 0 || data.getType().equals(types.getSelectionModel().getSelectedItem())) { return true; }
				}
				return false;

			}
		});

	}

	public void onSettings() {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initOwner(LanguageTrainer.window);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.sizeToScene();
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(Reference.FXML_SETTINGS),
					ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(Reference.CSS_DEFAULT);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
			FXUtil.showExceptionDialog("", "", e);
		}
		stage.showAndWait();
	}

	public void onStatistics() {
		// FIXME: Implement statistics
	}

	public void onTranslationList() {
		// FIXME: Implement translation list editor
	}

	public void onVerbList() {
		// FIXME: Implement verb list editor
	}

}
