package br_0309.apps.languageTrainer.scenes.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerNewVerbGerman implements Initializable, IController {

    // Labels behind the text fields (always "haben" or "sein")
    public Label lblHaben1;
    public Label lblHaben2;
    public Label lblHaben3;
    public Label lblHaben4;
    public Label lblHaben5;
    public Label lblHaben6;
    public Label lblHaben7;
    public Label lblHaben8;
    public Label lblHaben9;
    public Label lblHaben10;
    public Label lblHaben11;
    public Label lblHaben12;
    public Label lblHaben13;
    public Label lblHaben14;
    public Label lblHaben15;
    public Label lblHaben16;
    public Label lblHaben17;
    public Label lblHaben18;
    private Label[] lblsHaben;

    private boolean isHabenSelected = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblsHaben = new Label[] {lblHaben1, lblHaben2, lblHaben3, lblHaben4, lblHaben5, lblHaben6, lblHaben7, lblHaben8, lblHaben9, lblHaben10, lblHaben11,
                                 lblHaben12, lblHaben13, lblHaben14, lblHaben15, lblHaben16, lblHaben17, lblHaben18};
    }

    // RadioButton
    public void onHabenChanged() {
        // Inverts boolean
        isHabenSelected = ! isHabenSelected;
        String haben;
        if (isHabenSelected) {
            haben = "haben";
        } else {
            haben = "sein";
        }
        for (Label lbl : lblsHaben) {
            lbl.setText(haben);
        }
    }

    public void onOK() {

    }

    public void onCancel() {

    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }

}
