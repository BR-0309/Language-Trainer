package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.verbs.Verb;
import br_0309.apps.languageTrainer.verbs.VerbFrench;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerNewVerbFrench extends ControllerNewVerb implements Initializable, IController {

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

    public Label lblWarning;

    public VerbFrench result = null;
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
    private TextField[] allTextFields;
    private boolean isAvoirSelected = true;
    private List<Verb> preEnteredVerbs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblsPasseCompose = new Label[] {lblPasseComposeJe, lblPasseComposeTu, lblPasseComposeIl, lblPasseComposeNous, lblPasseComposeVous, lblPasseComposeIls};
        lblsPlusQueParfait = new Label[] {lblPlusQueParfaitJe, lblPlusQueParfaitTu, lblPlusQueParfaitIl, lblPlusQueParfaitNous, lblPlusQueParfaitVous,
                                          lblPlusQueParfaitIls};
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
        allTextFields = new TextField[] {txtPresentJe, txtPresentTu, txtPresentIl, txtPresentNous, txtPresentVous, txtPresentIls, txtPasseComposeJe, txtPasseComposeTu, txtPasseComposeIl, txtPasseComposeNous, txtPasseComposeVous,
                                         txtPasseComposeIls, txtImparfaitJe, txtImparfaitTu, txtImparfaitIl, txtImparfaitNous, txtImparfaitVous,
                                         txtImparfaitIls, txtPlusQueParfaitJe, txtPlusQueParfaitTu, txtPlusQueParfaitIl, txtPlusQueParfaitNous, txtPlusQueParfaitVous,
                                         txtPlusQueParfaitIls, txtPasseSimpleJe, txtPasseSimpleTu, txtPasseSimpleIl, txtPasseSimpleNous, txtPasseSimpleVous,
                                         txtPasseSimpleIls, txtFuturSimpleJe, txtFuturSimpleTu, txtFuturSimpleIl, txtFuturSimpleNous, txtFuturSimpleVous,
                                         txtFuturSimpleIls, txtFuturComposeJe, txtFuturComposeTu, txtFuturComposeIl, txtFuturComposeNous, txtFuturComposeVous,
                                         txtFuturComposeIls, txtConditionnelPresentJe, txtConditionnelPresentTu, txtConditionnelPresentIl, txtConditionnelPresentNous,
                                         txtConditionnelPresentVous, txtConditionnelPresentIls, txtImperatifPresentTu, txtImperatifPresentNous, txtImperatifPresentVous};
        // XXX: Add impératif and conditionnel/futur simple
        txtInfinitif.textProperty().addListener((observable, oldValue, newValue) -> {
            for (Verb v : preEnteredVerbs) {
                if (v == null) continue;
                if (v.getInfinitive().equals(newValue)) {
                    Toolkit.getDefaultToolkit().beep();
                    lblWarning.setVisible(true);
                } else {
                    lblWarning.setVisible(false);
                }
            }
            // XXX: Add futur simple/conditionnel présent
            for(TextField txt : txtsFuturCompose) {
                txt.setText(newValue);
            }
        });
        txtParticipePasse.textProperty().addListener((observable, oldValue, newValue) -> {
            newValue = newValue.trim();
            for(TextField txt : txtsPasseCompose) {
                txt.setText(newValue);
            }
            for(TextField txt : txtsPlusQueParfait) {
                txt.setText(newValue);
            }
        });

    }

    @SuppressWarnings("HardcodedFileSeparator")
    public void onAvoirChanged() {
        isAvoirSelected = ! isAvoirSelected;
        String[] passeCompose;
        String[] plusQueParfait;
        if (isAvoirSelected) {
            passeCompose = new String[] {"j'ai", "tu as", "il/elle/on a", "nous avons", "vous avez", "ils/elles ont"};
            plusQueParfait = new String[] {"j'avais", "tu avais", "il/elle/on avait", "nous avions", "vous aviez", "ils/elles avaient"};
        } else {
            passeCompose = new String[] {"je suis", "tu es", "il/elle/on est", "nous sommes", "vous êtes", "ils/elles sont"};
            plusQueParfait = new String[] {"j'étais", "tu étais", "il/elle/on était", "nous étions", "vous étiez", "ils/elles étaient"};
        }
        for (int i = 0; i < 6; i++) {
            lblsPasseCompose[i].setText(passeCompose[i]);
            lblsPlusQueParfait[i].setText(plusQueParfait[i]);
        }
    }

    public void onOk() {
        if(!areAllFieldsFilled() || lblWarning.isVisible()){
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        VerbFrench verb = new VerbFrench();
        verb.isAvoir = isAvoirSelected;
        verb.infinitif = txtInfinitif.getText().trim();
        verb.participePresent = txtParticipePresent.getText().trim();
        verb.participePasse = txtParticipePasse.getText().trim();
        verb.imperatifPresent[0] = txtImperatifPresentTu.getText().trim();
        verb.imperatifPresent[1] = txtImperatifPresentNous.getText().trim();
        verb.imperatifPresent[2] = txtImperatifPresentVous.getText().trim();

        for(int i = 0; i < 6; i++) {
            verb.present[i] = txtsPresent[i].getText().trim();
            verb.passeCompose[i] = txtsPasseCompose[i].getText().trim();
            verb.plusQueParfait[i] = txtsPlusQueParfait[i].getText().trim();
            verb.imparfait[i] = txtsImparfait[i].getText().trim();
            verb.passeSimple[i] = txtsPasseSimple[i].getText().trim();
            verb.futurCompose[i] = txtsFuturCompose[i].getText().trim();
            verb.futurSimple[i] = txtsFuturSimple[i].getText().trim();
            verb.conditionnelPresent[i] = txtsConditionnelPresent[i].getText().trim();
        }
        result = verb;
        onCancel();
    }

    private boolean areAllFieldsFilled() {
        for(TextField txt : allTextFields) {
            if(txt.getText().trim().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void onCancel() {
        Stage stage = (Stage) lblPasseComposeJe.getScene().getWindow();
        stage.close();
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }

    @Override
    public Verb getResult() {
        return result;
    }

    @Override
    void initPreEnteredVerbs(List<Verb> list) {
        preEnteredVerbs = list;
    }

    @Override
    public void loadVerb(Verb v) {
        VerbFrench verb = (VerbFrench) v;
        txtInfinitif.setText(verb.infinitif);
        txtParticipePasse.setText(verb.participePasse);
        txtParticipePresent.setText(verb.participePresent);
        txtImperatifPresentTu.setText(verb.imperatifPresent[0]);
        txtImperatifPresentNous.setText(verb.imperatifPresent[1]);
        txtImperatifPresentVous.setText(verb.imperatifPresent[2]);
        for(int i = 0; i < 6; i++){
            txtsPresent[i].setText(verb.present[i]);
            txtsPasseCompose[i].setText(verb.passeCompose[i]);
            txtsPlusQueParfait[i].setText(verb.plusQueParfait[i]);
            txtsImparfait[i].setText(verb.imparfait[i]);
            txtsPasseSimple[i].setText(verb.passeSimple[i]);
            txtsFuturCompose[i].setText(verb.futurCompose[i]);
            txtsFuturSimple[i].setText(verb.futurSimple[i]);
            txtsConditionnelPresent[i].setText(verb.conditionnelPresent[i]);
        }
    }
}
