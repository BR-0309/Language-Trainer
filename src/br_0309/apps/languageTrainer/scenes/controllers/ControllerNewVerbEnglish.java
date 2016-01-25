package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.verbs.VerbEnglish;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerNewVerbEnglish implements Initializable, IController {

    public TextField txtInfinitive;
    public TextField txtPresentParticiple;
    public TextField txtPastParticiple;

    public TextField txtPresentSimpleI;
    public TextField txtPresentSimpleYou;
    public TextField txtPresentSimpleHe;
    public TextField txtPresentSimpleWe;
    public TextField txtPresentSimpleYouPlural;
    public TextField txtPresentSimpleThey;

    public TextField txtPresentPerfectI;
    public TextField txtPresentPerfectYou;
    public TextField txtPresentPerfectHe;
    public TextField txtPresentPerfectWe;
    public TextField txtPresentPerfectYouPlural;
    public TextField txtPresentPerfectThey;

    public TextField txtPresentContinuousI;
    public TextField txtPresentContinuousYou;
    public TextField txtPresentContinuousHe;
    public TextField txtPresentContinuousWe;
    public TextField txtPresentContinuousYouPlural;
    public TextField txtPresentContinuousThey;

    public TextField txtPresentPerfectContinuousI;
    public TextField txtPresentPerfectContinuousYou;
    public TextField txtPresentPerfectContinuousHe;
    public TextField txtPresentPerfectContinuousWe;
    public TextField txtPresentPerfectContinuousYouPlural;
    public TextField txtPresentPerfectContinuousThey;

    public TextField txtPastSimpleI;
    public TextField txtPastSimpleYou;
    public TextField txtPastSimpleHe;
    public TextField txtPastSimpleWe;
    public TextField txtPastSimpleYouPlural;
    public TextField txtPastSimpleThey;

    public TextField txtPastPerfectI;
    public TextField txtPastPerfectYou;
    public TextField txtPastPerfectHe;
    public TextField txtPastPerfectWe;
    public TextField txtPastPerfectYouPlural;
    public TextField txtPastPerfectThey;

    public TextField txtPastContinuousI;
    public TextField txtPastContinuousYou;
    public TextField txtPastContinuousHe;
    public TextField txtPastContinuousWe;
    public TextField txtPastContinuousYouPlural;
    public TextField txtPastContinuousThey;

    public TextField txtPastPerfectContinuousI;
    public TextField txtPastPerfectContinuousYou;
    public TextField txtPastPerfectContinuousHe;
    public TextField txtPastPerfectContinuousWe;
    public TextField txtPastPerfectContinuousYouPlural;
    public TextField txtPastPerfectContinuousThey;

    public TextField txtFutureI;
    public TextField txtFutureYou;
    public TextField txtFutureHe;
    public TextField txtFutureWe;
    public TextField txtFutureYouPlural;
    public TextField txtFutureThey;

    public TextField txtFuturePerfectI;
    public TextField txtFuturePerfectYou;
    public TextField txtFuturePerfectHe;
    public TextField txtFuturePerfectWe;
    public TextField txtFuturePerfectYouPlural;
    public TextField txtFuturePerfectThey;

    public TextField txtFutureContinuousI;
    public TextField txtFutureContinuousYou;
    public TextField txtFutureContinuousHe;
    public TextField txtFutureContinuousWe;
    public TextField txtFutureContinuousYouPlural;
    public TextField txtFutureContinuousThey;

    public TextField txtFuturePerfectContinuousI;
    public TextField txtFuturePerfectContinuousYou;
    public TextField txtFuturePerfectContinuousHe;
    public TextField txtFuturePerfectContinuousWe;
    public TextField txtFuturePerfectContinuousYouPlural;
    public TextField txtFuturePerfectContinuousThey;

    private boolean update = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtInfinitive.textProperty().addListener((observable, oldValue, newValue) -> {
            update = false; fillTxtBoxes(VerbEnglish.conjugate(newValue)); update = true;
        });

        txtPastSimpleI.textProperty().addListener(((observable, oldValue, newValue) -> {
            if (update) {
                update = false; txtPastSimpleYou.setText(newValue); txtPastSimpleHe.setText(newValue); txtPastSimpleWe.setText(newValue);
                txtPastSimpleYouPlural.setText(newValue); txtPastSimpleThey.setText(newValue); update = true;
            }
        })); txtPastParticiple.textProperty().addListener((observable, oldValue, newValue) -> {
            if (update) {
                update = false; txtPresentPerfectI.setText(newValue); txtPresentPerfectYou.setText(newValue); txtPresentPerfectHe.setText(newValue);
                txtPresentPerfectWe.setText(newValue); txtPresentPerfectYouPlural.setText(newValue); txtPresentPerfectThey.setText(newValue);
                txtPastSimpleI.setText(newValue); txtPastSimpleYou.setText(newValue); txtPastSimpleHe.setText(newValue); txtPastSimpleWe.setText(newValue);
                txtPastSimpleYouPlural.setText(newValue); txtPastSimpleThey.setText(newValue); txtPastPerfectI.setText(newValue);
                txtPastPerfectYou.setText(newValue); txtPastPerfectHe.setText(newValue); txtPastPerfectWe.setText(newValue);
                txtPastPerfectYouPlural.setText(newValue); txtPastPerfectThey.setText(newValue); txtFuturePerfectI.setText(newValue);
                txtFuturePerfectYou.setText(newValue); txtFuturePerfectHe.setText(newValue); txtFuturePerfectWe.setText(newValue);
                txtFuturePerfectYouPlural.setText(newValue); txtFuturePerfectThey.setText(newValue); update = true;
            }
        }); txtPresentParticiple.textProperty().addListener((observable, oldValue, newValue) -> {
            txtPresentContinuousI.setText(newValue); txtPresentContinuousYou.setText(newValue); txtPresentContinuousHe.setText(newValue);
            txtPresentContinuousWe.setText(newValue); txtPresentContinuousYouPlural.setText(newValue); txtPresentContinuousThey.setText(newValue);
            txtPresentPerfectContinuousI.setText(newValue); txtPresentPerfectContinuousYou.setText(newValue); txtPresentPerfectContinuousHe.setText(newValue);
            txtPresentPerfectContinuousWe.setText(newValue); txtPresentPerfectContinuousYouPlural.setText(newValue);
            txtPresentPerfectContinuousThey.setText(newValue); txtPastContinuousI.setText(newValue); txtPastContinuousYou.setText(newValue);
            txtPastContinuousHe.setText(newValue); txtPastContinuousWe.setText(newValue); txtPastContinuousYouPlural.setText(newValue);
            txtPastContinuousThey.setText(newValue); txtPastPerfectContinuousI.setText(newValue); txtPastPerfectContinuousYou.setText(newValue);
            txtPastPerfectContinuousHe.setText(newValue); txtPastPerfectContinuousWe.setText(newValue); txtPastPerfectContinuousYouPlural.setText(newValue);
            txtPastPerfectContinuousThey.setText(newValue); txtFutureContinuousI.setText(newValue); txtFutureContinuousYou.setText(newValue);
            txtFutureContinuousHe.setText(newValue); txtFutureContinuousWe.setText(newValue); txtFutureContinuousYouPlural.setText(newValue);
            txtFutureContinuousThey.setText(newValue); txtFuturePerfectContinuousI.setText(newValue); txtFuturePerfectContinuousYou.setText(newValue);
            txtFuturePerfectContinuousHe.setText(newValue); txtFuturePerfectContinuousWe.setText(newValue);
            txtFuturePerfectContinuousYouPlural.setText(newValue); txtFuturePerfectContinuousThey.setText(newValue);
        });
    }

    public void onCancel() {
        Stage stage = (Stage) txtInfinitive.getScene().getWindow(); stage.close();
    }

    public void onOK() {
        if (areAllFilled()) {
            VerbEnglish verb = new VerbEnglish(); verb.infinitive = txtInfinitive.getText(); verb.presentParticiple = txtPresentParticiple.getText();
            verb.pastParticiple = txtPastParticiple.getText();

            String presentSimpleI = "", presentSimpleYou = "", presentSimpleHe = "", presentSimpleWe = "", presentSimpleYouPlural = "", presentSimpleThey = "";
            String[] array = {"I ", "You ", "He ", "She ", "It ", "We ", "You ", "They "}; for (String s : txtPresentSimpleI.getText().trim().split(";")) {
                presentSimpleI += array[0] + s + ";";
            } for (String s : txtPresentSimpleYou.getText().trim().split(";")) {
                presentSimpleYou += array[1] + s + ";";
            } for (String s : txtPresentSimpleHe.getText().trim().split(";")) {
                presentSimpleHe += array[2] + s + ";"; presentSimpleHe += array[3] + s + ";"; presentSimpleHe += array[4] + s + ";";
            } for (String s : txtPresentSimpleWe.getText().trim().split(";")) {
                presentSimpleWe += array[5] + s + ";";
            } for (String s : txtPresentSimpleYouPlural.getText().trim().split(";")) {
                presentSimpleYouPlural += array[6] + s + ";";
            } for (String s : txtPresentSimpleThey.getText().trim().split(";")) {
                presentSimpleThey += array[7] + s + ";";
            } verb.presentSimple = new String[] {presentSimpleI, presentSimpleYou, presentSimpleHe, presentSimpleWe, presentSimpleYouPlural, presentSimpleThey};

            String presentPerfectI = "", presentPerfectYou = "", presentPerfectHe = "", presentPerfectWe = "", presentPerfectYouPlural = "",
                    presentPerfectThey = "";
            array = new String[] {"I have ", "You have ", "He has ", "She has ", "It has ", "We have ", "You have ", "They have "};
            for (String s : txtPresentPerfectI.getText().trim().split(";")) {
                presentPerfectI += array[0] + s + ";";
            } for (String s : txtPresentPerfectYou.getText().trim().split(";")) {
                presentPerfectYou += array[1] + s + ";";
            } for (String s : txtPresentPerfectHe.getText().trim().split(";")) {
                presentPerfectHe += array[2] + s + ";"; presentPerfectHe += array[3] + s + ";"; presentPerfectHe += array[4] + s + ";";
            } for (String s : txtPresentPerfectWe.getText().trim().split(";")) {
                presentPerfectWe += array[5] + s + ";";
            } for (String s : txtPresentPerfectYouPlural.getText().trim().split(";")) {
                presentPerfectYouPlural += array[6] + s + ";";
            } for (String s : txtPresentPerfectThey.getText().trim().split(";")) {
                presentPerfectThey += array[7] + s + ";";
            } verb.presentPerfect = new String[] {presentPerfectI, presentPerfectYou, presentPerfectHe, presentPerfectWe, presentPerfectYouPlural,
                                                  presentPerfectThey};

            String presentContinuousI = "", presentContinuousYou = "", presentContinuousHe = "", presentContinuousWe = "", presentContinuousYouPlural = "",
                    presentContinuousThey = "";
            array = new String[] {"I have ", "You have ", "He has ", "She has ", "It has ", "We have ", "You have ", "They have "};
            for (String s : txtPresentContinuousI.getText().trim().split(";")) {
                presentContinuousI += array[0] + s + ";";
            } for (String s : txtPresentContinuousYou.getText().trim().split(";")) {
                presentContinuousYou += array[1] + s + ";";
            } for (String s : txtPresentContinuousHe.getText().trim().split(";")) {
                presentContinuousHe += array[2] + s + ";"; presentContinuousHe += array[3] + s + ";"; presentContinuousHe += array[4] + s + ";";
            } for (String s : txtPresentContinuousWe.getText().trim().split(";")) {
                presentContinuousWe += array[5] + s + ";";
            } for (String s : txtPresentContinuousYouPlural.getText().trim().split(";")) {
                presentContinuousThey += array[6] + s + ";";
            } for (String s : txtPresentContinuousThey.getText().trim().split(";")) {
                presentContinuousThey += array[7] + s + ";";
            } verb.presentContinuous = new String[] {presentContinuousI, presentContinuousYou, presentContinuousHe, presentContinuousWe,
                                                     presentContinuousYouPlural, presentContinuousThey};

            String presentPerfectContinuousI = "", presentPerfectContinuousYou = "", presentPerfectContinuousHe = "", presentPerfectContinuousWe = "",
                    presentPerfectContinuousYouPlural = "", presentPerfectContinuousThey = "";
            array = new String[] {"I have ", "You have ", "He has ", "She has ", "It has ", "We have ", "You have ", "They have "};
            for (String s : txtPresentPerfectContinuousI.getText().trim().split(";")) {
                presentPerfectContinuousI += array[0] + s + ";";
            } for (String s : txtPresentPerfectContinuousYou.getText().trim().split(";")) {
                presentPerfectContinuousYou += array[1] + s + ";";
            } for (String s : txtPresentPerfectContinuousHe.getText().trim().split(";")) {
                presentPerfectContinuousHe += array[2] + s + ";"; presentPerfectContinuousHe += array[3] + s + ";";
                presentPerfectContinuousHe += array[4] + s + ";";
            } for (String s : txtPresentPerfectContinuousWe.getText().trim().split(";")) {
                presentPerfectContinuousWe += array[5] + s + ";";
            } for (String s : txtPresentPerfectContinuousYouPlural.getText().trim().split(";")) {
                presentPerfectContinuousYouPlural += array[6] + s + ";";
            } for (String s : txtPresentPerfectContinuousThey.getText().trim().split(";")) {
                presentPerfectContinuousThey += array[7] + s + ";";
            } verb.presentPerfectContinuous = new String[] {presentPerfectContinuousI, presentPerfectContinuousYou, presentPerfectContinuousHe,
                                                            presentPerfectContinuousWe, presentPerfectContinuousYouPlural, presentPerfectContinuousThey};

            String pastSimpleI = "", pastSimpleYou = "", pastSimpleHe = "", pastSimpleWe = "", pastSimpleYouPlural = "", pastSimpleThey = "";
            array = new String[] {"I ", "You ", "He ", "She ", "It ", "We ", "You ", "They "}; for (String s : txtPastSimpleI.getText().trim().split(";")) {
                pastSimpleI += array[0] + s + ";";
            } for (String s : txtPastSimpleYou.getText().trim().split(";")) {
                pastSimpleYou += array[1] + s + ";";
            } for (String s : txtPastSimpleHe.getText().trim().split(";")) {
                pastSimpleHe += array[2] + s + ";"; pastSimpleHe += array[3] + s + ";"; pastSimpleHe += array[4] + s + ";";
            } for (String s : txtPastSimpleWe.getText().trim().split(";")) {
                pastSimpleWe += array[5] + s + ";";
            } for (String s : txtPastSimpleYouPlural.getText().trim().split(";")) {
                pastSimpleYouPlural += array[6] + s + ";";
            } for (String s : txtPastSimpleThey.getText().trim().split(";")) {
                pastSimpleThey += array[7] + s + ";";
            } verb.pastSimple = new String[] {pastSimpleI, pastSimpleYou, pastSimpleHe, pastSimpleWe, pastSimpleYouPlural, pastSimpleThey};

            String pastPerfectI = "", pastPerfectYou = "", pastPerfectHe = "", pastPerfectWe = "", pastPerfectYouPlural = "", pastPerfectThey = "";
            array = new String[] {"I was ", "You were ", "He was ", "She was ", "It was ", "We were ", "You were ", "They were "};
            for (String s : txtPastPerfectI.getText().trim().split(";")) {
                pastPerfectI += array[0] + s + ";";
            } for (String s : txtPastPerfectYou.getText().trim().split(";")) {
                pastPerfectYou += array[1] + s + ";";
            } for (String s : txtPastPerfectHe.getText().trim().split(";")) {
                pastPerfectHe += array[2] + s + ";"; pastPerfectHe += array[3] + s + ";"; pastPerfectHe += array[4] + s + ";";
            } for (String s : txtPastPerfectWe.getText().trim().split(";")) {
                pastPerfectWe += array[5] + s + ";";
            } for (String s : txtPastPerfectYouPlural.getText().trim().split(";")) {
                pastPerfectYouPlural += array[6] + s + ";";
            } for (String s : txtPastPerfectThey.getText().trim().split(";")) {
                pastPerfectThey += array[7] + s + ";";
            } verb.pastPerfect = new String[] {pastPerfectI, pastPerfectYou, pastPerfectHe, pastPerfectWe, pastPerfectYouPlural, pastPerfectThey};

            String pastContinuousI = "", pastContinuousYou = "", pastContinuousHe = "", pastContinuousWe = "", pastContinuousYouPlural = "",
                    pastContinuousThey = "";
            array = new String[] {"I was ", "You were ", "He was ", "She was ", "It was ", "We were ", "You  were ", "They were "};
            for (String s : txtPastContinuousI.getText().trim().split(";")) {
                pastContinuousI += array[0] + s + ";";
            } for (String s : txtPastContinuousYou.getText().trim().split(";")) {
                pastContinuousYou += array[1] + s + ";";
            } for (String s : txtPastContinuousHe.getText().trim().split(";")) {
                pastContinuousHe += array[2] + s + ";"; pastContinuousHe += array[3] + s + ";"; pastContinuousHe += array[4] + s + ";";
            } for (String s : txtPastContinuousWe.getText().trim().split(";")) {
                pastContinuousWe += array[5] + s + ";";
            } for (String s : txtPastContinuousYouPlural.getText().trim().split(";")) {
                pastContinuousYouPlural += array[6] + s + ";";
            } for (String s : txtPastContinuousThey.getText().trim().split(";")) {
                pastContinuousThey += array[7] + s + ";";
            } verb.pastContinuous = new String[] {pastContinuousI, pastContinuousYou, pastContinuousHe, pastContinuousWe, pastContinuousYouPlural,
                                                  pastContinuousThey};

            String pastPerfectContinuousI = "", pastPerfectContinuousYou = "", pastPerfectContinuousHe = "", pastPerfectContinuousWe = "",
                    pastPerfectContinuousYouPlural = "", pastPerfectContinuousThey = "";
            array = new String[] {"I had been ", "You had been ", "He had been ", "She had been ", "We had been ", "You had been ", "They had been "};
            for (String s : txtPastPerfectContinuousI.getText().trim().split(";")) {
                pastPerfectContinuousI += array[0] + s + ";";
            } for (String s : txtPastPerfectContinuousYou.getText().trim().split(";")) {
                pastPerfectContinuousYou += array[1] + s + ";";
            } for (String s : txtPastPerfectContinuousHe.getText().trim().split(";")) {
                pastPerfectContinuousHe += array[2] + s + ";"; pastPerfectContinuousHe += array[3] + s + ";"; pastPerfectContinuousHe += array[4] + s + ";";
            } for (String s : txtPastPerfectContinuousWe.getText().trim().split(";")) {
                pastPerfectContinuousWe += array[5] + s + ";";
            } for (String s : txtPastPerfectContinuousYouPlural.getText().trim().split(";")) {
                pastPerfectContinuousYouPlural += array[6] + s + ";";
            } for (String s : txtPastPerfectContinuousThey.getText().trim().split(";")) {
                pastPerfectContinuousThey += array[7] + s + ";";
            } verb.pastPerfectContinuous = new String[] {pastPerfectContinuousI, pastPerfectContinuousYou, pastPerfectContinuousHe, pastPerfectContinuousWe,
                                                         pastPerfectContinuousYouPlural, pastPerfectContinuousThey};

            String futureI = "", futureYou = "", futureHe = "", futureWe = "", futureYouPlural = "", futureThey = "";
            array = new String[] {"I will ", "You will ", "He will ", "She will ", "It will ", "We will ", "You will ", "They will "};
            for (String s : txtFutureI.getText().trim().split(";")) {
                futureI += array[0] + s + ";";
            } for (String s : txtFutureYou.getText().trim().split(";")) {
                futureYou += array[1] + s + ";";
            } for (String s : txtFutureHe.getText().trim().split(";")) {
                futureHe += array[2] + s + ";"; futureHe += array[3] + s + ";"; futureHe += array[4] + s + ";";
            } for (String s : txtFutureWe.getText().trim().split(";")) {
                futureWe += array[5] + s + ";";
            } for (String s : txtFutureYouPlural.getText().trim().split(";")) {
                futureYouPlural += array[6] + s + ";";
            } for (String s : txtFutureThey.getText().trim().split(";")) {
                futureThey += array[7] + s + ";";
            } verb.future = new String[] {futureI, futureYou, futureHe, futureWe, futureYouPlural, futureThey};

            String futurePerfectI = "", futurePerfectYou = "", futurePerfectHe = "", futurePerfectWe = "", futurePerfectYouPlural = "", futurePerfectThey = "";
            array = new String[] {"I will have ", "You will have ", "He will have ", "SHe will have ", "It will have ", "We will have ", "You will have ",
                                  "They will have "}; for (String s : txtFuturePerfectI.getText().trim().split(";")) {
                futurePerfectI += array[0] + s + ";";
            } for (String s : txtFuturePerfectYou.getText().trim().split(";")) {
                futurePerfectYou += array[1] + s + ";";
            } for (String s : txtFuturePerfectHe.getText().trim().split(";")) {
                futurePerfectHe += array[2] + s + ";"; futurePerfectHe += array[3] + s + ";"; futurePerfectHe += array[4] + s + ";";
            } for (String s : txtFuturePerfectWe.getText().trim().split(";")) {
                futurePerfectWe += array[5] + s + ";";
            } for (String s : txtFuturePerfectYouPlural.getText().trim().split(";")) {
                futurePerfectYouPlural += array[6] + s + ";";
            } for (String s : txtFuturePerfectThey.getText().trim().split(";")) {
                futurePerfectThey += array[7] + s + ";";
            } verb.futurePerfect = new String[] {futurePerfectI, futurePerfectYou, futurePerfectHe, futurePerfectWe, futurePerfectYouPlural, futurePerfectThey};

            String futureContinuousI = "", futureContinuousYou = "", futureContinuousHe = "", futureContinuousWe = "", futureContinuousYouPlural = "",
                    futureContinuousThey = "";
            array = new String[] {"I will have ", "You will have ", "He will have ", "She will have ", "It will have ", "We will have ", "You will have ",
                                  "They will have "}; for (String s : txtFutureContinuousI.getText().trim().split(";")) {
                futureContinuousI += array[0] + s + ";";
            } for (String s : txtFutureContinuousYou.getText().trim().split(";")) {
                futureContinuousYou += array[1] + s + ";";
            } for (String s : txtFutureContinuousHe.getText().trim().split(";")) {
                futureContinuousHe += array[2] + s + ";"; futureContinuousHe += array[3] + s + ";"; futureContinuousHe += array[4] + s + ";";
            } for (String s : txtFutureContinuousWe.getText().trim().split(";")) {
                futureContinuousWe += array[5] + s + ";";
            } for (String s : txtFutureContinuousYouPlural.getText().trim().split(";")) {
                futureContinuousYouPlural += array[6] + s + ";";
            } for (String s : txtFutureContinuousThey.getText().trim().split(";")) {
                futureContinuousThey += array[7] + s + ";";
            } verb.futureContinuous = new String[] {futureContinuousI, futureContinuousYou, futureContinuousHe, futureContinuousWe, futureContinuousYouPlural,
                                                    futureContinuousThey};

            String futurePerfectContinuousI = "", futurePerfectContinuousYou = "", futurePerfectContinuousHe = "", futurePerfectContinuousWe = "",
                    futurePerfectContinuousYouPlural = "", futurePerfectContinuousThey = "";
            array = new String[] {"I will have been ", "You will have been ", "He will have been ", "She will have been ", "It will have been ",
                                  "We will have" + " been", "You will have been ", "They will have "};
            for (String s : txtFuturePerfectContinuousI.getText().trim().split(";")) {
                futurePerfectContinuousI += array[0] + s + ";";
            } for (String s : txtFuturePerfectContinuousYou.getText().trim().split(";")) {
                futurePerfectContinuousYou += array[1] + s + ";";
            } for (String s : txtFuturePerfectContinuousHe.getText().trim().split(";")) {
                futurePerfectContinuousHe += array[2] + s + ";"; futurePerfectContinuousHe += array[3] + s + ";";
                futurePerfectContinuousHe += array[4] + s + ";";
            } for (String s : txtFuturePerfectContinuousWe.getText().trim().split(";")) {
                futurePerfectContinuousWe += array[5] + s + ";";
            } for (String s : txtFuturePerfectContinuousYouPlural.getText().trim().split(";")) {
                futurePerfectContinuousYouPlural += array[6] + s + ";";
            } for (String s : txtFuturePerfectContinuousThey.getText().trim().split(";")) {
                futurePerfectContinuousThey += array[7] + s + ";";
            } verb.futurePerfectContinuous = new String[] {futurePerfectContinuousI, futurePerfectContinuousYou, futurePerfectContinuousHe,
                                                           futurePerfectContinuousWe, futurePerfectContinuousYouPlural, futurePerfectContinuousThey};
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private void fillTxtBoxes(VerbEnglish verb) {
        txtPresentParticiple.setText(verb.presentParticiple); txtPastParticiple.setText(verb.pastParticiple); txtPresentSimpleI.setText(verb.presentSimple[0]);
        txtPresentSimpleYou.setText(verb.presentSimple[1]); txtPresentSimpleHe.setText(verb.presentSimple[2]);
        txtPresentSimpleWe.setText(verb.presentSimple[3]); txtPresentSimpleYouPlural.setText(verb.presentSimple[4]);
        txtPresentSimpleThey.setText(verb.presentSimple[5]); txtPresentPerfectI.setText(verb.presentPerfect[0]);
        txtPresentPerfectYou.setText(verb.presentPerfect[1]); txtPresentPerfectHe.setText(verb.presentPerfect[2]);
        txtPresentPerfectWe.setText(verb.presentPerfect[3]); txtPresentPerfectYouPlural.setText(verb.presentPerfect[4]);
        txtPresentPerfectThey.setText(verb.presentPerfect[5]); txtPresentContinuousI.setText(verb.presentContinuous[0]);
        txtPresentContinuousYou.setText(verb.presentContinuous[1]); txtPresentContinuousHe.setText(verb.presentContinuous[2]);
        txtPresentContinuousWe.setText(verb.presentContinuous[3]); txtPresentContinuousYouPlural.setText(verb.presentContinuous[4]);
        txtPresentContinuousThey.setText(verb.presentContinuous[5]); txtPresentPerfectContinuousI.setText(verb.presentContinuous[0]);
        txtPresentPerfectContinuousYou.setText(verb.presentContinuous[1]); txtPresentPerfectContinuousHe.setText(verb.presentContinuous[2]);
        txtPresentPerfectContinuousWe.setText(verb.presentContinuous[3]); txtPresentPerfectContinuousYouPlural.setText(verb.presentContinuous[4]);
        txtPresentPerfectContinuousThey.setText(verb.presentContinuous[5]); txtPastSimpleI.setText(verb.pastSimple[0]);
        txtPastSimpleYou.setText(verb.pastSimple[1]); txtPastSimpleHe.setText(verb.pastSimple[2]); txtPastSimpleWe.setText(verb.pastSimple[3]);
        txtPastSimpleYouPlural.setText(verb.pastSimple[4]); txtPastSimpleThey.setText(verb.pastSimple[5]); txtPastPerfectI.setText(verb.pastPerfect[0]);
        txtPastPerfectYou.setText(verb.pastPerfect[1]); txtPastPerfectHe.setText(verb.pastPerfect[2]); txtPastPerfectWe.setText(verb.pastPerfect[3]);
        txtPastPerfectYouPlural.setText(verb.pastPerfect[4]); txtPastPerfectThey.setText(verb.pastPerfect[5]);
        txtPastContinuousI.setText(verb.pastContinuous[0]); txtPastContinuousYou.setText(verb.pastContinuous[1]);
        txtPastContinuousHe.setText(verb.pastContinuous[2]); txtPastContinuousWe.setText(verb.pastContinuous[3]);
        txtPastContinuousYouPlural.setText(verb.pastContinuous[4]); txtPastContinuousThey.setText(verb.pastContinuous[5]);
        txtPastPerfectContinuousI.setText(verb.pastPerfectContinuous[0]); txtPastPerfectContinuousYou.setText(verb.pastPerfectContinuous[1]);
        txtPastPerfectContinuousHe.setText(verb.pastPerfectContinuous[2]); txtPastPerfectContinuousWe.setText(verb.pastPerfectContinuous[3]);
        txtPastPerfectContinuousYouPlural.setText(verb.pastPerfectContinuous[4]); txtPastPerfectContinuousThey.setText(verb.pastPerfectContinuous[5]);
        txtFutureI.setText(verb.future[0]); txtFutureYou.setText(verb.future[1]); txtFutureHe.setText(verb.future[2]); txtFutureWe.setText(verb.future[3]);
        txtFutureYouPlural.setText(verb.future[4]); txtFutureThey.setText(verb.future[5]); txtFuturePerfectI.setText(verb.futurePerfect[0]);
        txtFuturePerfectYou.setText(verb.futurePerfect[1]); txtFuturePerfectHe.setText(verb.futurePerfect[2]);
        txtFuturePerfectWe.setText(verb.futurePerfect[3]); txtFuturePerfectYouPlural.setText(verb.futurePerfect[4]);
        txtFuturePerfectThey.setText(verb.futurePerfect[5]); txtFutureContinuousI.setText(verb.futureContinuous[0]);
        txtFutureContinuousYou.setText(verb.futureContinuous[1]); txtFutureContinuousHe.setText(verb.futureContinuous[2]);
        txtFutureContinuousWe.setText(verb.futureContinuous[3]); txtFutureContinuousYouPlural.setText(verb.futureContinuous[4]);
        txtFutureContinuousThey.setText(verb.futureContinuous[5]); txtFuturePerfectContinuousI.setText(verb.futurePerfectContinuous[0]);
        txtFuturePerfectContinuousYou.setText(verb.futurePerfectContinuous[1]); txtFuturePerfectContinuousHe.setText(verb.futurePerfectContinuous[2]);
        txtFuturePerfectContinuousWe.setText(verb.futurePerfectContinuous[3]); txtFuturePerfectContinuousYouPlural.setText(verb.futurePerfectContinuous[4]);
        txtFuturePerfectContinuousThey.setText(verb.futurePerfectContinuous[5]);
    }

    private boolean areAllFilled() {
        return ! (txtPresentParticiple.getText().trim().isEmpty() || txtPastParticiple.getText().trim().isEmpty() || txtPresentSimpleI.getText().trim()
                                                                                                                                      .isEmpty() ||
                  txtPresentSimpleYou.getText().trim().isEmpty() || txtPresentSimpleHe.getText().trim().isEmpty() || txtPresentSimpleWe.getText().trim()
                                                                                                                                       .isEmpty()
                  || txtPresentSimpleYouPlural.getText().trim().isEmpty() || txtPresentSimpleThey.getText().trim().isEmpty() || txtPresentPerfectI.getText()
                                                                                                                                                  .trim()
                                                                                                                                                  .isEmpty()
                  || txtPresentPerfectYou.getText().trim().isEmpty() || txtPresentPerfectHe.getText().trim().isEmpty() || txtPresentPerfectWe.getText().trim()
                                                                                                                                             .isEmpty()
                  || txtPresentPerfectYouPlural.getText().trim().isEmpty() || txtPresentPerfectThey.getText().trim().isEmpty() || txtPresentContinuousI
                          .getText().trim().isEmpty() || txtPresentContinuousYou.getText().trim().isEmpty() || txtPresentContinuousHe.getText().trim().isEmpty()
                  || txtPresentContinuousWe.getText().trim().isEmpty() || txtPresentContinuousYouPlural.getText().trim().isEmpty() || txtPresentContinuousThey
                          .getText().trim().isEmpty() || txtPresentPerfectContinuousI.getText().trim().isEmpty() || txtPresentPerfectContinuousYou.getText()
                                                                                                                                                  .trim()
                                                                                                                                                  .isEmpty()
                  || txtPresentPerfectContinuousHe.getText().trim().isEmpty() || txtPresentPerfectContinuousWe.getText().trim().isEmpty()
                  || txtPresentPerfectContinuousYouPlural.getText().trim().isEmpty() || txtPresentPerfectContinuousThey.getText().trim().isEmpty()
                  || txtPastSimpleI.getText().trim().isEmpty() || txtPastSimpleYou.getText().trim().isEmpty() || txtPastSimpleHe.getText().trim().isEmpty()
                  || txtPastSimpleWe.getText().trim().isEmpty() || txtPastSimpleYouPlural.getText().trim().isEmpty() || txtPastSimpleThey.getText().trim()
                                                                                                                                         .isEmpty()
                  || txtPastPerfectI.getText().trim().isEmpty() || txtPastPerfectYou.getText().trim().isEmpty() || txtPastPerfectHe.getText().trim().isEmpty()
                  || txtPastPerfectWe.getText().trim().isEmpty() || txtPastPerfectYouPlural.getText().trim().isEmpty() || txtPastPerfectThey.getText().trim()
                                                                                                                                            .isEmpty()
                  || txtPastContinuousI.getText().trim().isEmpty() || txtPastContinuousYou.getText().trim().isEmpty() || txtPastContinuousHe.getText().trim()
                                                                                                                                            .isEmpty()
                  || txtPastContinuousWe.getText().trim().isEmpty() || txtPastContinuousYouPlural.getText().trim().isEmpty() || txtPastContinuousThey.getText()
                                                                                                                                                     .trim()
                                                                                                                                                     .isEmpty()
                  || txtPastPerfectContinuousI.getText().trim().isEmpty() || txtPastPerfectContinuousYou.getText().trim().isEmpty()
                  || txtPastPerfectContinuousHe.getText().trim().isEmpty() || txtPastPerfectContinuousWe.getText().trim().isEmpty()
                  || txtPastPerfectContinuousYouPlural.getText().trim().isEmpty() || txtPastPerfectContinuousThey.getText().trim().isEmpty() || txtFutureI
                          .getText().trim().isEmpty() || txtFutureYou.getText().trim().isEmpty() || txtFutureHe.getText().trim().isEmpty() || txtFutureWe
                          .getText().trim().isEmpty() || txtFutureYouPlural.getText().trim().isEmpty() || txtFutureThey.getText().trim().isEmpty()
                  || txtFuturePerfectI.getText().trim().isEmpty() || txtFuturePerfectYou.getText().trim().isEmpty() || txtFuturePerfectHe.getText().trim()
                                                                                                                                         .isEmpty()
                  || txtFuturePerfectWe.getText().trim().isEmpty() || txtFuturePerfectYouPlural.getText().trim().isEmpty() || txtFuturePerfectThey.getText()
                                                                                                                                                  .trim()
                                                                                                                                                  .isEmpty()
                  || txtFutureContinuousI.getText().trim().isEmpty() || txtFutureContinuousYou.getText().trim().isEmpty() || txtFutureContinuousHe.getText()
                                                                                                                                                  .trim()
                                                                                                                                                  .isEmpty()
                  || txtFutureContinuousWe.getText().trim().isEmpty() || txtFutureContinuousYouPlural.getText().trim().isEmpty() || txtFutureContinuousThey
                          .getText().trim().isEmpty() || txtFuturePerfectContinuousI.getText().trim().isEmpty() || txtFuturePerfectContinuousYou.getText()
                                                                                                                                                .trim()
                                                                                                                                                .isEmpty()
                  || txtFuturePerfectContinuousHe.getText().trim().isEmpty() || txtFuturePerfectContinuousWe.getText().trim().isEmpty()
                  || txtFuturePerfectContinuousYouPlural.getText().trim().isEmpty() || txtFuturePerfectContinuousThey.getText().trim().isEmpty());
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {
        Node node = txtInfinitive.getScene().getFocusOwner();
        if(node instanceof TextField){
            TextField txt = (TextField) node;
            txt.setText(txt.getText() + c);
        }
    }
}
