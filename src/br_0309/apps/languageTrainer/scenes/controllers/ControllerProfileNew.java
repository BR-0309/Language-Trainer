package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.util.SystemUtil;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

// IController won't be called anyway
public class ControllerProfileNew implements Initializable {

    public File profile;

    public TextField txtName;
    public TextField txtLocation;
    public Button ok;
    public Button cancel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtLocation.setText(Reference.DEFAULT_PROFILE_DIR);
        // Focus may not be on the text fields so that one can read the prompt text
        Platform.runLater(() -> ok.requestFocus());
    }

    public void onBrowse() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setInitialDirectory(new File(SystemUtil.getUserHome()));
        File file = chooser.showDialog(null);
        txtLocation.setText(file.getAbsolutePath());
    }

    public void onCancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void onOk() {
        if (txtName.getText().trim().equals("")) {
            txtName.requestFocus();
            Toolkit.getDefaultToolkit().beep();
            return;
        } else if (txtLocation.getText().trim().equals("")) {
            txtLocation.requestFocus();
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        Stage stage = (Stage) ok.getScene().getWindow();
        profile = new File(txtLocation.getText() + File.separator + txtName.getText().replaceAll(" ", "_") + ".ltd");
        stage.close();
    }
}
