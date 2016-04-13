package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.data.ExerciseData;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ControllerMenu implements Initializable, IController {

    public TableView<ExerciseData> table;
    public Button createTranslationList;
    public TextField search;
    public ComboBox<String> types;
    public Button viewStatistics;
    public Button createVerbList;
    public Button startTraining;

    private FilteredList<ExerciseData> data;
    private ResourceBundle BUNDLE;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BUNDLE = resources;
        initData();

        table.getColumns().get(0).setSortable(false);
        table.getColumns().get(1).setSortable(false);
        table.getColumns().get(2).setSortable(false);
        table.getColumns().get(3).setSortable(false);

        CheckBox checkbox = new CheckBox();
        checkbox.setOnAction(event -> {
            boolean isSelected = checkbox.isSelected();
            @SuppressWarnings("unchecked") Predicate<ExerciseData> p = (Predicate<ExerciseData>) data.getPredicate(); data.stream().filter(p).forEach(
                    d -> d.setSelected(isSelected));
        });
        table.getColumns().get(0).setGraphic(checkbox);

        table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("active"));
        table.getColumns().get(0).setCellFactory(tc -> new CheckBoxTableCell<>());
        table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
        table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("languages"));
        table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("type"));

        table.setItems(data);

        ArrayList<String> l = new ArrayList<>();
        l.add(BUNDLE.getString("generic.all"));
        l.add(BUNDLE.getString("generic.translation"));
        l.add(BUNDLE.getString("generic.verbs"));
        types.setItems(FXCollections.observableList(l));
        types.getSelectionModel().select(0);

        search.textProperty().addListener((observable, oldValue, newValue) -> filter());
        types.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> filter());

        filter();
    }

    private void initData() {
        String TRANSLATION = BUNDLE.getString("generic.translation");
        String VERBS = BUNDLE.getString("generic.verbs");
        ArrayList<ExerciseData> data = new ArrayList<>();
        // Get all exercise locations and store in File[] for loop
        ArrayList<File> folders = LanguageTrainer.universalData.exerciseLocations;
        // Loop through all the folders
        for (File folder : folders) {
            // Check for null or nonexistent folders
            if (folder == null) {
                System.err.println("Null reference in exercise locations!");
                continue;
            } else if (! folder.exists() || folder.isFile()) {
                System.err.println(folder.getAbsolutePath() + " does not exist or is a file!");
                continue;
            }
            // Cycle through all files in the folder
            for (File file : folder.listFiles()) {
                // Check for null/nonexistent files
                if (file == null) {
                    System.err.println("Null reference file!");
                    continue;
                } else if (! file.exists() || file.isDirectory()) {
                    System.err.println(file.getAbsolutePath() + " does not exist or is a directory! Nested exercises are not supported!");
                    continue;
                }
                // For translation files
                if (file.getName().endsWith(".tra")) {
                    try (Scanner scan = new Scanner(new FileInputStream(file), "UTF-8")) {
                        String[] langs = scan.nextLine().split(":");
                        String name = file.getName().replaceAll("_", " ").replace(".tra", "");
                        Arrays.sort(langs);
                        // For each combination of languages
                        for (int i = 0; i < langs.length - 1; i++) {
                            for (int j = i + 1; j < langs.length; j++) {
                                String lang1 = new Locale(langs[i]).getDisplayLanguage();
                                String lang2 = new Locale(langs[j]).getDisplayLanguage();
                                data.add(new ExerciseData(false, name, lang1 + " " + lang2, TRANSLATION, file, new String[] {langs[i], langs[j]}));
                            }
                        }

                    } catch (Exception e) {
                        System.err.println("Something went wrong while trying to read: " + file.getAbsolutePath());
                        e.printStackTrace();
                    }
                } else if (file.getName().endsWith("vdt")) {
                    // For verb files
                    ObjectInputStream in = null; try {
                        in = new ObjectInputStream(new FileInputStream(file)); String lang = in.readUTF(); int language = - 1; try {
                            language = Integer.parseInt(lang);
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid language code number: " + lang);
                        } if (language >= Reference.VERB_LOCALES.length) {
                            System.err.printf("Invalid lang code (%s) in file %s. Skipping." + System.lineSeparator(), lang,
                                              file.getAbsolutePath() + System.lineSeparator());
                            continue;
                        } data.add(new ExerciseData(false, file.getName().replaceAll("_", " ").replace(".vdt", ""),
                                                    Reference.VERB_LOCALES[language].getDisplayLanguage(), VERBS, file, new String[] {lang}));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.data = new FilteredList<>(FXCollections.observableList(data));
        }
    }

    public void onStartTraining() {
        // Copies selected items
        // TODO: Find out how this actually works
        ArrayList<ExerciseData> selected = data.stream().filter(ExerciseData::isSelected).collect(Collectors.toCollection(ArrayList::new));
        if (selected.isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            table.requestFocus();
            return;
        }
        String translation = BUNDLE.getString("generic.translation"); boolean hasTranslation = false; for (ExerciseData data : selected) {
            if (data.getType().equals(translation)) {
                hasTranslation = true; break;
            }
        } if (hasTranslation) {
            LanguageTrainer.showTranslation(selected);
        } else {
            LanguageTrainer.showVerbs(selected);
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
        data.setPredicate(data1 -> {
            if (data1.getTitle().toLowerCase().contains(search.getText().toLowerCase())) {
                if (types.getSelectionModel().getSelectedIndex() == 0 || data1.getType().equals(types.getSelectionModel().getSelectedItem())) {
                    return true;
                }
            }
            return false;

        });

    }

    public void onSettings() {
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.initOwner(LanguageTrainer.window);
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(Reference.FXML_SETTINGS),
                                            ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: Add title and header
            FXUtil.showExceptionDialog("", "", e);
        }
    }

    public void onStatistics() {
        LanguageTrainer.setScene(Reference.FXML_STATISTICS);
    }

    public void onTranslationList() {
        LanguageTrainer.setScene(Reference.FXML_CREATE_TRANSLATION);
    }

    public void onVerbList() {
        ArrayList<Locale> locales = new ArrayList<>(); Collections.addAll(locales, Reference.VERB_LOCALES); Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Reference.FXML_LANGUAGE_ADD),
                                           ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault())); try {
            Parent root = loader.load(); Scene scene = new Scene(root); scene.getStylesheets().add(
                    getClass().getResource(LanguageTrainer.userData.getTheme()).toExternalForm()); stage.setScene(scene); stage.sizeToScene();
            stage.setResizable(false); stage.initModality(Modality.APPLICATION_MODAL); stage.initOwner(LanguageTrainer.window); stage.initStyle(
                    StageStyle.UTILITY); stage.setTitle(BUNDLE.getString("verbs.selectLanguage")); ControllerAddLanguage controller = loader.getController();
            controller.addOnlyTheseLocales(locales); stage.showAndWait(); if (controller.newLocale != null) {
                for (int i = 0; i < Reference.VERB_LOCALES.length; i++) {
                    if (controller.newLocale.equals(Reference.VERB_LOCALES[i])) {
                        LanguageTrainer.showCreateVerbList(i); return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onAbout() {
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.initOwner(LanguageTrainer.window);
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(Reference.FXML_ABOUT), ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: Add title and header
            FXUtil.showExceptionDialog("", "", e);
        }
    }

}
