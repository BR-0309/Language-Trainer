package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageHandler;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.*;

// No IController since it's in it's own stage
public class ControllerAddLanguage implements Initializable {

    public TextField txtSearch;
    public ListView<Locale> list;

    public Locale newLocale = null;
    private FilteredList<Locale> objects;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            objects.setPredicate(locale -> locale.getDisplayLanguage().toLowerCase().trim().contains(newValue.toLowerCase().trim()));
        });
        list.setCellFactory(new Callback<ListView<Locale>, ListCell<Locale>>() {

            @Override
            public ListCell<Locale> call(ListView<Locale> param) {
                return new ListCell<Locale>() {
                    final Label text = new Label();
                    final Label icon = new Label();
                    // Render everything in a HBox
                    private final HBox cell;

                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        cell = new HBox();
                        HBox.setHgrow(icon, Priority.ALWAYS);
                        icon.setPadding(new Insets(0, 5, 0, 0));
                        cell.getChildren().add(icon);
                        cell.getChildren().add(text);
                    }

                    @Override
                    protected void updateItem(Locale item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
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

    public void addLocales(ArrayList<Locale> locales) {
        List<Locale> localeList = new ArrayList<>();
        for (Locale locale : LanguageHandler.LANGUAGES) {
            String lang = locale.getLanguage();
            // b to please compiler
            boolean b = true;
            for (Locale l : locales) {
                if (l.getLanguage().equals(lang)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                localeList.add(locale);
            }
        }
        Comparator<Locale> comparator = (locale1, locale2) -> locale1.getDisplayLanguage().compareTo(locale2.getDisplayLanguage());
        Collections.sort(localeList, comparator);
        objects = new FilteredList<>(FXCollections.observableList(localeList));
        list.setItems(objects);
    }

    public void ok() {
        newLocale = list.getSelectionModel().getSelectedItem();
        Stage stage = (Stage) txtSearch.getScene().getWindow();
        stage.close();
    }

    public void cancel() {
        Stage stage = (Stage) txtSearch.getScene().getWindow();
        stage.close();
    }

}
