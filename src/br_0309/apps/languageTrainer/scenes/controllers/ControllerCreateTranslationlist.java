package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.data.VocabularyListData;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

// FIXME: Search doesn't really work
// FIXME: Ignores last row if not commited
public class ControllerCreateTranslationList implements Initializable, IController {

    private final ArrayList<Locale> locales = new ArrayList<>();
    private final ObservableList<VocabularyListData> data = FXCollections.observableArrayList();

    public TableView<VocabularyListData> table;
    public TextField txtSearch;
    public TextField txtTitle;

    private ResourceBundle BUNDLE;

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BUNDLE = resources;
        txtSearch.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (event.getCode() == KeyCode.ENTER) next();
        });
        table.getSelectionModel().setCellSelectionEnabled(true);
        table.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                return;
            }
            if (table.getEditingCell() == null) {
                if (! event.getCode().isArrowKey() && ! event.getCode().isFunctionKey() &&
                    ! event.getCode().isMediaKey() && ! event.getCode().isModifierKey() &&
                    ! event.getCode().equals(KeyCode.CAPS)) {
                    TablePosition cellPos = table.getFocusModel().getFocusedCell();
                    table.edit(cellPos.getRow(), cellPos.getTableColumn());
                }
            }
        });
        table.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                TablePosition pos = table.getFocusModel().getFocusedCell();
                if (pos.getRow() == - 1) {
                    table.getSelectionModel().select(0);
                } else if (pos.getRow() == table.getItems().size() - 1 && pos.getColumn() == table.getColumns().size() - 1) {
                    // Ignore error message shown regarding maxCellCount
                    data.add(new VocabularyListData());
                    table.scrollTo(data.size() - 1);
                }
            }
        });
        table.setEditable(true);
        table.setItems(data);
        data.add(new VocabularyListData());
        txtTitle.textProperty().addListener((observable, oldValue, newValue) -> {
            for (char c : Reference.INVALID_FILE_CHARS) {
                if (newValue.contains(c + "")) {
                    txtTitle.setText(oldValue);
                    Toolkit.getDefaultToolkit().beep();
                    String chars = "";
                    for (char d : Reference.INVALID_FILE_CHARS) {
                        chars += d + " ";
                    }
                    FXUtil.showWarningDialog(BUNDLE.getString("generic.warning"), BUNDLE.getString("warnings.invalidCharHeader"),
                                             BUNDLE.getString("warnings.invalidCharMessage").replace("{0}", chars));
                    return;
                }
            }
        });
    }

    public void exit() {
        int choice = FXUtil.showYesNoCancelDialog(BUNDLE.getString("generic.confirm"), BUNDLE.getString("createTranslation.save"),
                                                  BUNDLE.getString("createTranslation.changes"));
        // If Yes was selected
        if (choice == 0) {
            // If saving was unsuccessful
            if(!saveBoolean()){
                return;
            }
            // If cancel was selected
        } else if (choice == 2) {
            return;
        }
        // If saving was successful or no was selected
        LanguageTrainer.showMenu();
    }

    public void open() {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File(Reference.DEFAULT_EXERCISE_DIR));
        chooser.getExtensionFilters().add((new FileChooser.ExtensionFilter(BUNDLE.getString("generic.tra"), "*.tra")));
        File file = chooser.showOpenDialog(LanguageTrainer.window);
        if (file == null) {
            return;
        }
        data.clear();
        table.getColumns().clear();
        locales.clear();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String langs = reader.readLine();
            String[] langs2 = langs.split(":");
            String[] keys = new String[langs2.length];
            for (int i = 0; i < langs2.length; i++) {
                Locale l = new Locale(langs2[i]);
                locales.add(l);
                table.getColumns().add(newColumn(l));
                keys[i] = l.getDisplayLanguage();
                System.out.println(l.getDisplayLanguage());
            }
            String line;
            while ((line = reader.readLine()) != null) {
                String[] input = line.split("=");
                VocabularyListData d = new VocabularyListData();
                for (int i = 0; i < keys.length; i++) {
                    d.set(keys[i], input[i]);
                }
                data.add(d);
            }
        } catch (IOException e) {
            FXUtil.showErrorDialog(BUNDLE.getString("generic.error"), BUNDLE.getString("createList.openFailed"), e.getLocalizedMessage());
            e.printStackTrace();
            return;
        }
        txtTitle.setText(file.getName().replaceAll("_", " ").substring(0, file.getName().length() - 4));
    }

    public void save() {
        if (table.getColumns().size() < 2) {
            FXUtil.showErrorDialog(BUNDLE.getString("createList.saveFailed"), BUNDLE.getString("createList.requirement"));
            return;
        }
        if (txtTitle.getText().trim().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            txtTitle.requestFocus();
            FXUtil.showErrorDialog(BUNDLE.getString("createList.saveFailed"), BUNDLE.getString("createList.enterTitle"));
            return;
        }
        File file = new File(Reference.DEFAULT_EXERCISE_DIR + File.separator + txtTitle.getText().trim().replaceAll(" ", "_") + ".tra");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            if (! file.exists()) {
                //noinspection ResultOfMethodCallIgnored
                file.getParentFile().mkdirs();
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            }
            String lang = locales.get(0).getLanguage();
            for (int i = 1; i < locales.size(); i++) {
                lang += ":" + locales.get(i).getLanguage();
            }
            writer.write(lang);
            writer.newLine();
            // Cycle through all rows of the table
            for (VocabularyListData d : data) {
                String[] words = new String[locales.size()];
                // Add all columns to array
                for (int i = 0; i < locales.size(); i++) {
                    words[i] = d.get(locales.get(i).getDisplayLanguage()).trim();
                }
                // Make sure there are at least two values in the array
                int counter = 0;
                for (String s : words) {
                    if (! s.equals("")) {
                        counter++;
                    }
                    if (counter > 1) break;
                }
                if (counter < 2) continue;
                String line = words[0];
                for (int i = 1; i < words.length; i++) {
                    line += "=" + words[i];
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            FXUtil.showErrorDialog(BUNDLE.getString("generic.error"), BUNDLE.getString("createList.saveFailed"), e.getLocalizedMessage());
        }
        FXUtil.showInformationDialog(BUNDLE.getString("createList.saveSuccessful"),
                                     BUNDLE.getString("createList.savedAs").replace("{0}", file.getAbsolutePath()));
    }

    public boolean saveBoolean() {
        if (table.getColumns().size() < 2) {
            FXUtil.showErrorDialog(BUNDLE.getString("createList.saveFailed"), BUNDLE.getString("createList.requirement"));
            return false;
        }
        if (txtTitle.getText().trim().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            txtTitle.requestFocus();
            FXUtil.showErrorDialog(BUNDLE.getString("createList.saveFailed"), BUNDLE.getString("createList.enterTitle"));
            return false;
        }
        File file = new File(Reference.DEFAULT_EXERCISE_DIR + File.separator + txtTitle.getText().trim().replaceAll(" ", "_") + ".tra");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            if (! file.exists()) {
                //noinspection ResultOfMethodCallIgnored
                file.getParentFile().mkdirs();
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            }
            String lang = locales.get(0).getLanguage();
            for (int i = 1; i < locales.size(); i++) {
                lang += ":" + locales.get(i).getLanguage();
            }
            writer.write(lang);
            writer.newLine();
            // Cycle through all rows of the table
            for (VocabularyListData d : data) {
                String[] words = new String[locales.size()];
                // Add all columns to array
                for (int i = 0; i < locales.size(); i++) {
                    words[i] = d.get(locales.get(i).getDisplayLanguage()).trim();
                }
                // Make sure there are at least two values in the array
                int counter = 0;
                for (String s : words) {
                    if (! s.equals("")) {
                        counter++;
                    }
                    if (counter > 1) break;
                }
                if (counter < 2) continue;
                String line = words[0];
                for (int i = 1; i < words.length; i++) {
                    line += "=" + words[i];
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            FXUtil.showErrorDialog(BUNDLE.getString("generic.error"), BUNDLE.getString("createList.saveFailed"), e.getLocalizedMessage());
        }
        FXUtil.showInformationDialog(BUNDLE.getString("createList.saveSuccessful"),
                                     BUNDLE.getString("createList.savedAs").replace("{0}", file.getAbsolutePath()));
        return true;
    }

    public void addLanguage() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Reference.FXML_LANGUAGE_ADD),
                                           ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(LanguageTrainer.window);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle(BUNDLE.getString("createTranslation.addLanguage"));
            ControllerAddLanguage controller = loader.getController();
            controller.addLocales(locales);
            stage.showAndWait();
            if (controller.newLocale != null) {
                locales.add(controller.newLocale);
                table.getColumns().add(newColumn(controller.newLocale));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void next() {
        String text = txtSearch.getText().toLowerCase();
        int i = 0;
        TablePosition p = table.getFocusModel().getFocusedCell();
        while (i < (data.size() - 1) * table.getColumns().size() - 1) {
            if (table.getSelectionModel().isSelected(data.size() - 1, table.getColumns().get(table.getColumns().size() - 1))) {
                table.getSelectionModel().select(0, table.getColumns().get(0));
            } else {
                table.getSelectionModel().selectNext();
            }
            ObservableList<TablePosition> positions = table.getSelectionModel().getSelectedCells();
            for (TablePosition pos : positions) {
                VocabularyListData data = table.getSelectionModel().getSelectedItem();
                if (data.get(pos.getTableColumn().getText()).toLowerCase().contains(text)) {
                    return;
                }
            }
            i++;
        }
        Toolkit.getDefaultToolkit().beep();
        //noinspection unchecked
        table.getSelectionModel().select(p.getRow(), p.getTableColumn());
    }

    public void previous() {
        String text = txtSearch.getText().toLowerCase();
        int i = 0;
        TablePosition p = table.getFocusModel().getFocusedCell();
        while (i < (data.size() - 1) * table.getColumns().size() - 1) {
            if (table.getSelectionModel().isSelected(0, table.getColumns().get(0))) {
                table.getSelectionModel().selectLast();
            } else {
                table.getSelectionModel().selectPrevious();
            }
            ObservableList<TablePosition> positions = table.getSelectionModel().getSelectedCells();
            for (TablePosition pos : positions) {
                VocabularyListData data = table.getSelectionModel().getSelectedItem();
                if (data.get(pos.getTableColumn().getText()).toLowerCase().contains(text)) {
                    return;
                }
            }
            i++;
        }
        Toolkit.getDefaultToolkit().beep();
        //noinspection unchecked
        table.getSelectionModel().select(p.getRow(), p.getTableColumn());
    }

    @SuppressWarnings({"Convert2Lambda", "unchecked"})
    private TableColumn<VocabularyListData, String> newColumn(Locale locale) {
        TableColumn column = new TableColumn<>(locale.getDisplayLanguage());
        column.setEditable(true);
        column.setCellFactory(TextFieldTableCell.forTableColumn());

        column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                ((VocabularyListData) event.getTableView().getItems().get(event.getTablePosition().getRow())).set(event.getTableColumn().getText(),
                                                                                                                  event.getNewValue().toString());
                event.getTableView().getSelectionModel().selectNext();
            }
        });

        column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                VocabularyListData data1 = (VocabularyListData) param.getValue();
                return new ReadOnlyStringWrapper(data1.get(param.getTableColumn().getText()));
            }
        });
        column.setGraphic(new ImageView(LanguageHandler.getFlag(locale)));
        return column;
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {
        if (txtTitle.isFocused()) {
            txtTitle.setText(txtTitle.getText() + c);
        } else if (txtSearch.isFocused()) {
            txtSearch.setText(txtSearch.getText() + c);
        } else if (table.isFocused()) {
            TablePosition pos = table.getEditingCell();
            VocabularyListData data = table.getItems().get(pos.getRow());
            String columnHeader = table.getColumns().get(pos.getColumn()).getText();
            data.set(columnHeader, data.get(columnHeader) + c);
        }
    }
}
