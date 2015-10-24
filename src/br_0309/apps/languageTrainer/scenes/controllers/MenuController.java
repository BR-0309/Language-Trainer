package br_0309.apps.languageTrainer.scenes.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import br_0309.apps.languageTrainer.data.ExcersiseData;
import br_0309.apps.languageTrainer.data.LanguageData;
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

public class MenuController implements Initializable, IController {

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

		tableLanguages.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("selected"));
		tableLanguages.getColumns().get(0).setCellFactory(tc -> new CheckBoxTableCell<>());
		CheckBox checkbox2 = new CheckBox();
		checkbox2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean isSelected = checkbox2.isSelected();
				for (ExcersiseData d : data) {
					d.setSelected(isSelected);
				}
			}

		});
		tableLanguages.getColumns().get(0).setGraphic(checkbox2);

		tableLanguages.onMouseClickedProperty().addListener((observable, oldVaue, newValue) -> filter());
		search.textProperty().addListener((observable, oldValue, newValue) -> filter());
		types.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> filter());
	}

	private void initData() {
		// for()
	}

	@Override
	public void onExit() {
	}

	@Override
	public void onInsert() {
		// TODO Auto-generated method stub

	}

	private void filter() {
		data.setPredicate(new Predicate<ExcersiseData>() {

			@Override
			public boolean test(ExcersiseData data) {
				if (data.getTitle().toLowerCase().contains(search.getText().toLowerCase())
						&& types.getSelectionModel().getSelectedItem().equals(BUNDLE.getString("generic.all"))
						|| types.getSelectionModel().getSelectedItem().equals(data.getType())) {
					for (LanguageData l : languages) {
						if (data.getLanguages().contains(l.getLanguage())) {
							return false;
						}
					}
					return true;
				}
				return false;
			}
		});
	}

}
