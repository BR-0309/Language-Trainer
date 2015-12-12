package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageHandler;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControllerAddLanguage implements Initializable, IController {

    @FXML
    public TextField txtSearch;
    @FXML
    public ListView<Locale> list;

    private FilteredList<Locale> objects;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        objects = new FilteredList<>(FXCollections.observableList(Arrays.asList(LanguageHandler.LANGUAGES)));
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            objects.setPredicate(locale -> locale.getDisplayLanguage().contains(newValue.trim()));
        });
        list.setItems(objects);
        list.setCellFactory(new Callback<ListView<Locale>, ListCell<Locale>>() {

            @Override
            public ListCell<Locale> call(ListView<Locale> param) {
                return new ListCell<Locale>() {
                    // Render everything in a HBox
                    private final HBox cell;
                    Label text = new Label();
                    Label icon = new Label();

                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        cell = new HBox();
                        HBox.setHgrow(icon, Priority.ALWAYS);
                        icon.setPadding(new Insets(0, 5, 0, 0));
                        cell.getChildren().add(icon);
                        cell.getChildren().add(text);
                    }

                    @Override
                    protected void updateItem(Locale item, boolean isEmpty) {
                        super.updateItem(item, isEmpty);
                        if (item == null || isEmpty) {
                            setGraphic(null);
                        } else {
                            text.setText(item.getDisplayLanguage());
                            icon.setGraphic(new ImageView(LanguageHandler.getFlag(item)));
                            setGraphic(cell);
                        }
                    }
                };
            }
        });
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }
}
