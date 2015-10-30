package br_0309.apps.languageTrainer.scenes.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Predicate;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.data.ExcersiseData;
import br_0309.apps.languageTrainer.data.LanguageData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	public TableView<ExcersiseData> table;
	@FXML
	public TableView<LanguageData> tableLanguages;
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
	public TextField searchLanguages;
	@FXML
	public Button startTraining;

	private FilteredList<ExcersiseData> data;
	private FilteredList<LanguageData> languages;
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
				for (ExcersiseData d : data) {
					d.setSelected(isSelected);
				}
			}

		});
		table.getColumns().get(0).setGraphic(checkbox);

		table.getColumns().get(0).setResizable(false);
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

		tableLanguages.getColumns().get(0).setSortable(false);
		tableLanguages.getColumns().get(1).setSortable(false);

		// FIXME FIXME FIXME FIXME MAKE LANGUAGE TABLE WORK!!

		tableLanguages.setItems(languages);

		search.textProperty().addListener((observable, oldValue, newValue) -> filter());
		types.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> filter());
	}

	private void initData() {
		ObservableList<ExcersiseData> list = FXCollections.observableArrayList();
		ObservableList<LanguageData> listLangs = FXCollections.observableArrayList();
		listLangs.add(new LanguageData(false, "Deutsch"));

		String translation = BUNDLE.getString("generic.translation");
		String verbs = BUNDLE.getString("generic.verbs");
		for (File folder : LanguageTrainer.universalData.excersiseLocations) {
			if (!folder.exists() || folder.isFile()) {
				continue;
			}
			File[] files = folder.listFiles();
			for (File f : files) {
				if (f.getName().endsWith(".tra")) {
					Scanner scan = null;
					try {
						scan = new Scanner(f);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					String langs = scan.nextLine();
					scan.close();

					String[] langs2 = langs.split(":");
					Locale[] l = new Locale[langs2.length];
					for (int i = 0; i < langs2.length; i++) {
						l[i] = new Locale(langs2[i]);
					}
					String languages = "";
					for (Locale locale : l) {
						languages += locale.getDisplayLanguage() + " ";
					}
					ExcersiseData data = new ExcersiseData(false, f.getName().replaceAll("_", "").replace(".tra", ""), languages.trim(), translation, f);
					list.add(data);
				} else if (f.getName().endsWith(".vdt")) {
					Scanner scan = null;
					try {
						scan = new Scanner(f);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					String langs = scan.nextLine();
					scan.close();

					String[] langs2 = langs.split(":");
					Locale[] l = new Locale[langs2.length];
					for (int i = 0; i < langs2.length; i++) {
						l[i] = new Locale(langs2[i]);
					}
					String languages = "";
					for (Locale locale : l) {
						languages += locale.getDisplayLanguage() + " ";
						listLangs.add(new LanguageData(true, locale.getDisplayLanguage()));
					}
					ExcersiseData data = new ExcersiseData(false, f.getName().replaceAll("_", "").replace(".vdt", ""), languages.trim(), verbs, f);
					list.add(data);
				}
			}
		}
		data = new FilteredList<ExcersiseData>(list);
		languages = new FilteredList<LanguageData>(listLangs);
	}

	@Override
	public void onExit() {
	}

	@Override
	public void onInsert(char c) {
		// TODO Auto-generated method stub

	}

	private void filter() {
		data.setPredicate(new Predicate<ExcersiseData>() {

			@Override
			public boolean test(ExcersiseData data) {
				if (data.getTitle().toLowerCase().contains(search.getText().toLowerCase())
						&& types.getSelectionModel().getSelectedItem().equals(BUNDLE.getString("generic.all"))
						|| types.getSelectionModel().getSelectedItem().equals(data.getType())) {
					/*
					 * for (LanguageData l : languages) { if
					 * (data.getLanguages().contains(l.getLanguage().get())) {
					 * return false; } }
					 */
					return true;
				}
				return false;
			}
		});
	}

}
