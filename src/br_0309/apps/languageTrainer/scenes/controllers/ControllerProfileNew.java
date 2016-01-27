package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import javafx.application.Platform;
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

// IController won't be called anyway
public class ControllerProfileNew implements Initializable {

    public File profile;

    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtLocation;
    public Button ok;
    public Button cancel;
    private File profileUnconfirmed;

    private ResourceBundle BUNDLE;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtLocation.setText(Reference.DEFAULT_PROFILE_DIR);
        BUNDLE = resources;
        // Focus may not be on the text fields so that one can read the prompt
        // text
        Platform.runLater(() -> ok.requestFocus());
        txtFirstName.textProperty().addListener((observable, oldTxt, newText) -> updateLocation());
        txtLastName.textProperty().addListener((observable, oldTxt, newText) -> updateLocation());
        profileUnconfirmed = new File(Reference.DEFAULT_PROFILE_DIR + File.separator + "_.ltd");
    }

    public void onBrowse() {
        // FIXME: File chooser returns invalid filename (.ltd..)
        FileChooser chooser = new FileChooser();
        String filename = txtFirstName.getText().trim() + "_" + txtLastName.getText().trim() + ".ltd";
        if (! filename.equals("_.ltd")) {
            chooser.setInitialFileName(filename);
        }
        chooser.getExtensionFilters().add(new ExtensionFilter(BUNDLE.getString("generic.ltd"), ".ltd"));
        File defaultFolder = new File(txtLocation.getText());
        if (defaultFolder.isFile() && ! defaultFolder.getParentFile().exists()) {
            defaultFolder = new File(Reference.DEFAULT_PROFILE_DIR);
        } else if (defaultFolder.isFile() && defaultFolder.getParentFile().exists()) {
            defaultFolder = defaultFolder.getParentFile();
        } else if (! defaultFolder.exists()) {
            defaultFolder = new File(Reference.DEFAULT_PROFILE_DIR);
        }
        chooser.setInitialDirectory(defaultFolder);
        File file = chooser.showSaveDialog(LanguageTrainer.window);
        if (file != null) {
            txtLocation.setText(file.getAbsolutePath());
            profileUnconfirmed = new File(txtLocation.getText());
            try {
                String name = file.getName().replace(".ltd", "").replace(" ", "_");
                String[] names = name.split("_");
                txtFirstName.setText(names[0].replace(".ltd", ""));
                txtLastName.setText(names[1].replace(".ltd", ""));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("User entered invalid filename. Because it's so hard to use the text fields.");
            }
        }
    }

    public void onCancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void onOk() {
        if (txtFirstName.getText().trim().equals("")) {
            txtFirstName.requestFocus();
            Toolkit.getDefaultToolkit().beep();
            return;
        } else if (txtLastName.getText().trim().equals("")) {
            txtLastName.requestFocus();
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        Stage stage = (Stage) ok.getScene().getWindow();
        profile = profileUnconfirmed;
        stage.close();
    }

    private void updateLocation() {
        txtLocation.setText(profileUnconfirmed.getParentFile().getAbsolutePath() + File.separator + txtFirstName.getText().trim() +
                            "_" + txtLastName.getText().trim() + ".ltd");
    }
}
