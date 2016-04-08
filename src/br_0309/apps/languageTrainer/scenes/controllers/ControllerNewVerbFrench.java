package br_0309.apps.languageTrainer.scenes.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerNewVerbFrench implements Initializable {

    // Passé composé labels
    public Label lblPasseComposeJe;
    public Label lblPasseComposeTu;
    public Label lblPasseComposeIl;
    public Label lblPasseComposeNous;
    public Label lblPasseComposeVous;
    public Label lblPasseComposeIls;

    // Plus-que-parfait labels
    public Label lblPlusQueParfaitJe;
    public Label lblPlusQueParfaitTu;
    public Label lblPlusQueParfaitIl;
    public Label lblPlusQueParfaitNous;
    public Label lblPlusQueParfaitVous;
    public Label lblPlusQueParfaitIls;

    public TextField txtInfinitif;
    public TextField txtParticipePresent;
    public TextField txtParticipePasse;

    public TextField txtPresentJe;
    public TextField txtPresentTu;
    public TextField txtPresentIl;
    public TextField txtPresentNous;
    public TextField txtPresentVous;
    public TextField txtPresentIls;

    public TextField txtPasseComposeJe;
    public TextField txtPasseComposeTu;
    public TextField txtPasseComposeIl;
    public TextField txtPasseComposeNous;
    public TextField txtPasseComposeVous;
    public TextField txtPasseComposeIls;

    public TextField txtImparfaitJe;
    public TextField txtImparfaitTu;
    public TextField txtImparfaitIl;
    public TextField txtImparfaitNous;
    public TextField txtImparfaitVous;
    public TextField txtImparfaitIls;

    public TextField txtPlusQueParfaitJe;
    public TextField txtPlusQueParfaitTu;
    public TextField txtPlusQueParfaitIl;
    public TextField txtPlusQueParfaitNous;
    public TextField txtPlusQueParfaitVous;
    public TextField txtPlusQueParfaitIls;

    public TextField txtPasseSimpleJe;
    public TextField txtPasseSimpleTu;
    public TextField txtPasseSimpleIl;
    public TextField txtPasseSimpleNous;
    public TextField txtPasseSimpleVous;
    public TextField txtPasseSimpleIls;

    public TextField txtFuturSimpleJe;
    public TextField txtFuturSimpleTu;
    public TextField txtFuturSimpleIl;
    public TextField txtFuturSimpleNous;
    public TextField txtFuturSimpleVous;
    public TextField txtFuturSimpleIls;

    public TextField txtFuturComposeJe;
    public TextField txtFuturComposeTu;
    public TextField txtFuturComposeIl;
    public TextField txtFuturComposeNous;
    public TextField txtFuturComposeVous;
    public TextField txtFuturComposeIls;

    public TextField txtConditionnelPresentJe;
    public TextField txtConditionnelPresentTu;
    public TextField txtConditionnelPresentIl;
    public TextField txtConditionnelPresentNous;
    public TextField txtConditionnelPresentVous;
    public TextField txtConditionnelPresentIls;

    public TextField txtImperatifPresentTu;
    public TextField txtImperatifPresentNous;
    public TextField txtImperatifPresentVous;

    private Label[] lblsPasseCompose;
    private Label[] lblsPlusQueParfait;
    private TextField[] txtsPresent;
    private TextField[] txtsPasseCompose;
    private TextField[] txtsImparfait;
    private TextField[] txtsPlusQueParfait;
    private TextField[] txtsPasseSimple;
    private TextField[] txtsFuturSimple;
    private TextField[] txtsFuturCompose;
    private TextField[] txtsConditionnelPresent;
    private TextField[] txtsImperfatifPresent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblsPasseCompose = new Label[] {lblPasseComposeJe, lblPasseComposeTu, lblPasseComposeIl, lblPasseComposeNous, lblPasseComposeVous, lblPasseComposeIls};
        lblsPlusQueParfait = new Label[] {lblPlusQueParfaitJe, lblPlusQueParfaitTu, lblPlusQueParfaitIl, lblPlusQueParfaitNous, lblPlusQueParfaitVous,
                                          lblPasseComposeIls};
        txtsPresent = new TextField[] {txtPresentJe, txtPresentTu, txtPresentIl, txtPresentNous, txtPresentVous, txtPresentIls};
        txtsPasseCompose = new TextField[] {txtPasseComposeJe, txtPasseComposeTu, txtPasseComposeIl, txtPasseComposeNous, txtPasseComposeVous,
                                            txtPasseComposeIls};
        txtsImparfait = new TextField[] {txtImparfaitJe, txtImparfaitTu, txtImparfaitIl, txtImparfaitNous, txtImparfaitVous, txtImparfaitIls};
        txtsPlusQueParfait = new TextField[] {txtPlusQueParfaitJe, txtPlusQueParfaitTu, txtPlusQueParfaitIl, txtPlusQueParfaitNous, txtPlusQueParfaitVous,
                                              txtPlusQueParfaitIls};
        txtsPasseSimple = new TextField[] {txtPasseSimpleJe, txtPasseSimpleTu, txtPasseSimpleIl, txtPasseSimpleNous, txtPasseSimpleVous, txtPasseSimpleIls};
        txtsFuturSimple = new TextField[] {txtFuturSimpleJe, txtFuturSimpleTu, txtFuturSimpleIl, txtFuturSimpleNous, txtFuturSimpleVous, txtFuturSimpleIls};
        txtsFuturCompose = new TextField[] {txtFuturComposeJe, txtFuturComposeTu, txtFuturComposeIl, txtFuturComposeNous, txtFuturComposeVous,
                                            txtFuturComposeIls};
        txtsConditionnelPresent = new TextField[] {txtConditionnelPresentJe, txtConditionnelPresentTu, txtConditionnelPresentIl, txtConditionnelPresentNous,
                                                   txtConditionnelPresentVous, txtConditionnelPresentIls};
        txtsImperfatifPresent = new TextField[] {txtImperatifPresentTu, txtImperatifPresentNous, txtImperatifPresentVous};
    }

    public void onAvoirChanged() {

    }

    public void onOk() {

    }

    public void onCancel() {

    }

}
