package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControllerAbout implements Initializable, IController {

    public TextArea txtArea;
    public Label lblTitle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Nodes have not been added to the scene yet, so this must be run after initialisation
        Platform.runLater(() -> {
            Stage stage = (Stage) txtArea.getScene().getWindow();
            stage.setTitle(resources.getString("about.title"));
        });
        lblTitle.setText(resources.getString("generic.windowTitle") + " " + Reference.VERSION);
        txtArea.setText(resources.getString("about.area").replace("{0}", System.getProperty("java.version")).replace("{1}", System.getProperty("java.vendor"))
                .replace("{2}", Reference.DEFAULT_SAVE_DIR + File.separator + "logs"));
    }

    public void onResources() {
        Stage stage = new Stage(StageStyle.UTILITY);
        try {
            Parent root = FXMLLoader
                    .load(getClass().getResource(Reference.FXML_RESOURCES), ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: Add message
            FXUtil.showExceptionDialog("", "", e);
        }
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }
}
