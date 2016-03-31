package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerVerbs implements Initializable, IController {

    public Label lblCorrect;
    public Label lblIncorrect;
    public Label lblProgress;
    public Label lblList;
    public ProgressBar progressBar;
    public Button btnNext;
    public Button btnExit;
    public Label lblTitle;
    public Label lblTask;
    public TextField txtAnswer;
    public Button btnCheat;

    private ResourceBundle BUNDLE;
    private int correct;
    private int incorrect;
    private int cheated = 0;
    private int length;
    private int solvedCorrectly = 0;
    //FIXME: Note to self currently trying to get the verb Abfrageinterface to work with Verb
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BUNDLE = resources;
        btnExit.setOnAction(value -> {
            if (FXUtil.showConfirmationDialog(resources.getString("generic.confirm"), resources.getString("generic.confirmQuit"), "",
                                              resources.getString("generic.ok"), resources.getString("generic.cancel"))) {
                LanguageTrainer.showMenu();
            }
        });
        btnCheat.setPadding(Insets.EMPTY);
    }

    public void onNext() {

    }

    public void onCheat() {

    }

    private void updateProgressBar() {
        progressBar.setProgress((double) solvedCorrectly / length);
        //noinspection HardcodedFileSeparator
        lblProgress.setText(solvedCorrectly + "/" + Integer.toString(length) + " " +
                            new Double(progressBar.getProgress() * 100).intValue() + "%");
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }
}
