package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.util.FXUtil;
import br_0309.apps.languageTrainer.verbs.Verb;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerCreateVerbList implements Initializable, IController {

    public ListView<Verb> list;
    public TextField txtSearch;
    public TextField txtTitle;
    public Label lblLang;
    public int language;
    private ResourceBundle BUNDLE;
    private final ArrayList<Verb> unfilteredList = new ArrayList<>();
    private FilteredList<Verb> filteredList;
    private boolean alreadySaved = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BUNDLE = resources;
        list.setCellFactory(new Callback<ListView<Verb>, ListCell<Verb>>() {

            @Override
            public ListCell<Verb> call(ListView<Verb> param) {
                return new ListCell<Verb>() {
                    final Label text = new Label();

                    @Override
                    protected void updateItem(Verb item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            text.setText(item.getInfinitive());
                            setGraphic(text);
                        }
                    }
                };
            }
        });
        filteredList = new FilteredList<>(FXCollections.emptyObservableList());
        txtSearch.textProperty().addListener(
                (observable, oldValue, newValue) -> filteredList.setPredicate(t -> t == null || t.getInfinitive().trim().contains(newValue.trim())));
    }

    @Override
    public void onExit() {
        if (alreadySaved) {
            return;
        }
        alreadySaved = true;
        int choice = FXUtil.showYesNoCancelDialog(BUNDLE.getString("generic.confirm"), BUNDLE.getString("createTranslation.save"),
                                                  BUNDLE.getString("createTranslation.changes"));
        // 0=yes, 1=no, 2=cancel
        if (choice == 0) {
            save();
            LanguageTrainer.showMenu();
        } else if (choice == 1) {
            LanguageTrainer.showMenu();
        } else {
            alreadySaved = false;
        }
    }

    @Override
    public void onInsert(char c) {

    }

    public void addVerb() {
        String FXML;
        switch (language){
            case 0:
                FXML = Reference.FXML_VERB_ENGLISH;
                break;
            case 1:
                FXML = Reference.FXML_VERB_GERMAN;
                break;
            case 2:
                FXML = Reference.FXML_VERB_FRENCH;
                break;
            default:
                System.err.println("Invalid verb language number: " + language);
                FXML = "";
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(LanguageTrainer.window);
        stage.setTitle(BUNDLE.getString("verbs.newVerb"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML), BUNDLE);
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
            ControllerNewVerb controller = loader.getController();
            controller.initPreEnteredVerbs(unfilteredList);
            stage.setScene(scene);
            stage.showAndWait();
            unfilteredList.add(controller.getResult());
            filteredList = new FilteredList<>(FXCollections.observableArrayList(unfilteredList));
            list.setItems(filteredList);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: Add title
            FXUtil.showExceptionDialog("", "", e);
        }
    }

    public void setLanguage(int language) {
        lblLang.setText(Reference.VERB_LOCALES[language].getDisplayLanguage());
        lblLang.setGraphic(new ImageView(LanguageHandler.getFlag(Reference.VERB_LOCALES[language])));
        this.language = language;
    }

    public void open() {// Note to future self, working on opening now. Copy code from ControllerCreateTranslationList
    }

    public void save() {
        if(list.getItems().isEmpty()){
            Toolkit.getDefaultToolkit().beep();
            list.requestFocus();
            return;
        }else if(txtTitle.getText().isEmpty()){
            Toolkit.getDefaultToolkit().beep();
            txtTitle.requestFocus();
            return;
        }
        String filename = txtTitle.getText().trim().replaceAll(" ", "_");
        File file = new File(Reference.DEFAULT_EXERCISE_DIR + File.separator + filename + ".vdt");
        try {
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
            // TODO Specify
            FXUtil.showErrorDialog(BUNDLE.getString("generic.error"), BUNDLE.getString("createList.saveFailed"), e.getLocalizedMessage());
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeUTF(Integer.toString(language));
            for(Verb v : unfilteredList){
                out.writeObject(v);
            }
        }catch(IOException e) {
            e.printStackTrace();
            // TODO Specify
            FXUtil.showErrorDialog(BUNDLE.getString("generic.error"), BUNDLE.getString("createList.saveFailed"), e.getLocalizedMessage());
        } finally{
            try {
                out.flush();
                out.close();
            }catch(IOException | NullPointerException e){
                e.printStackTrace();
                // TODO Specify
                FXUtil.showErrorDialog(BUNDLE.getString("generic.error"), BUNDLE.getString("createList.saveFailed"), e.getLocalizedMessage());
            }
        }
    }

    public void edit() {
        int index = -143;
        Verb verb = list.getSelectionModel().getSelectedItem();
        for(int i = 0; i < unfilteredList.size(); i++){
            if(unfilteredList.get(i).getInfinitive().trim().equals(verb.getInfinitive().trim())){
                index = i;
                break;
            }
        }
        List<Verb> list2 = unfilteredList;
        list2.remove(verb);
        String FXML;
        switch (language){
            case 0:
                FXML = Reference.FXML_VERB_ENGLISH;
                break;
            case 1:
                FXML = Reference.FXML_VERB_GERMAN;
                break;
            case 2:
                FXML = Reference.FXML_VERB_FRENCH;
                break;
            default:
                System.err.println("Invalid verb language number: " + language);
                FXML = "";
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(LanguageTrainer.window);
        stage.setTitle(BUNDLE.getString("verbs.newVerb"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML), BUNDLE);
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
            ControllerNewVerb controller = loader.getController();
            controller.initPreEnteredVerbs(list2);
            controller.loadVerb(verb);
            stage.setScene(scene);
            stage.showAndWait();
            unfilteredList.add(index, controller.getResult());
            filteredList = new FilteredList<>(FXCollections.observableArrayList(unfilteredList));
            list.setItems(filteredList);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: Add title
            FXUtil.showExceptionDialog("", "", e);
        }
    }

}
