package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.Reference;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAbout implements Initializable, IController {

    public TextArea txtArea;
    public Label lblTitle;
    public WebView view;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Nodes have not been added to the scene yet, so this must be run after initialisation
        Platform.runLater(() -> {
            Stage stage = (Stage) txtArea.getScene().getWindow(); stage.setTitle(resources.getString("about.title"));
        }); lblTitle.setText(resources.getString("generic.windowTitle") + " " + Reference.VERSION); txtArea.setText(resources.getString("about.area"));
    }

    public void onResources() {

    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }
}
