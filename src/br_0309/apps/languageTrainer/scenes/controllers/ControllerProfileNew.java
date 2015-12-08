package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerProfileNew implements Initializable, IController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField location;
    @FXML
    private Button ok;
    @FXML
    private Button cancel;

    public File profile;
    private File profileUnconfirmed;

    private ResourceBundle BUNDLE;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        location.setText(Reference.DEFAULT_PROFILE_DIR);
        BUNDLE = resources;
        // Focus may not be on the text fields so that one can read the prompt
        // text
        Platform.runLater(() -> ok.requestFocus());
        firstName.textProperty().addListener((observable, oldTxt, newText) -> updateLocation());
        lastName.textProperty().addListener((observable, oldTxt, newText) -> updateLocation());
        profileUnconfirmed = new File(Reference.DEFAULT_PROFILE_DIR + File.separator + "_.ltd");
    }

    public void onBrowse() {
        FileChooser chooser = new FileChooser();
        String filename = firstName.getText().trim() + "_" + lastName.getText().trim() + ".ltd";
        if (!filename.equals("_.ltd")) {
            chooser.setInitialFileName(filename);
        }
        chooser.getExtensionFilters().add(new ExtensionFilter(BUNDLE.getString("generic.ltd"), ".ltd"));
        File defaultFolder = new File(location.getText());
        if (defaultFolder.isFile() && !defaultFolder.getParentFile().exists()) {
            defaultFolder = new File(Reference.DEFAULT_PROFILE_DIR);
        } else if (defaultFolder.isFile() && defaultFolder.getParentFile().exists()) {
            defaultFolder = defaultFolder.getParentFile();
        } else if (!defaultFolder.exists()) {
            defaultFolder = new File(Reference.DEFAULT_PROFILE_DIR);
        }
        chooser.setInitialDirectory(defaultFolder);
        File file = chooser.showSaveDialog(LanguageTrainer.window);
        if (file != null) {
            location.setText(file.getAbsolutePath());
            profileUnconfirmed = file;
            try {
                String name = file.getName().replace(".ltd", "").replace(" ", "_");
                String[] names = name.split("_");
                firstName.setText(names[0].replace(".ltd", ""));
                lastName.setText(names[1].replace(".ltd", ""));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("User entered invalid filename. Because it's sooo hard to use the textfield.");
            }
        }
    }

    public void onCancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void onOk() {
        if (firstName.getText().trim().equals("")) {
            firstName.requestFocus();
            Toolkit.getDefaultToolkit().beep();
            return;
        } else if (lastName.getText().trim().equals("")) {
            lastName.requestFocus();
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        Stage stage = (Stage) ok.getScene().getWindow();
        profile = profileUnconfirmed;
        stage.close();
    }

    private void updateLocation() {
        location.setText(
                profileUnconfirmed.getParentFile().getAbsolutePath() + File.separator + firstName.getText().trim() + "_" + lastName.getText().trim() + ".ltd");
    }

    @Override
    public void onExit() {
    }

    @Override
    public void onInsert(char c) {
        if (firstName.isFocused()) {
            firstName.setText(firstName.getText() + c);
        } else if (lastName.isFocused()) {
            lastName.setText(lastName.getText() + c);
        } else if (location.isFocused()) {
            location.setText(location.getText() + c);
        }
    }
}
