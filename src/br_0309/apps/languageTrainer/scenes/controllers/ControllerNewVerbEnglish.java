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
            update = false;
            fillTxtBoxes(VerbEnglish.conjugate(newValue));
            update = true;
        });

        txtPastSimpleI.textProperty().addListener(((observable, oldValue, newValue) -> {
            if (update) {
                update = false;
                txtPastSimpleYou.setText(newValue);
                txtPastSimpleHe.setText(newValue);
                txtPastSimpleWe.setText(newValue);
                txtPastSimpleYouPlural.setText(newValue);
                txtPastSimpleThey.setText(newValue);
                update = true;
            }
        }));
        txtPastParticiple.textProperty().addListener((observable, oldValue, newValue) -> {
            if (update) {
                update = false;
                txtPresentPerfectI.setText(newValue);
                txtPresentPerfectYou.setText(newValue);
                txtPresentPerfectHe.setText(newValue);
                txtPresentPerfectWe.setText(newValue);
                txtPresentPerfectYouPlural.setText(newValue);
                txtPresentPerfectThey.setText(newValue);
                txtPastSimpleI.setText(newValue);
                txtPastSimpleYou.setText(newValue);
                txtPastSimpleHe.setText(newValue);
                txtPastSimpleWe.setText(newValue);
                txtPastSimpleYouPlural.setText(newValue);
                txtPastSimpleThey.setText(newValue);
                txtPastPerfectI.setText(newValue);
                txtPastPerfectYou.setText(newValue);
                txtPastPerfectHe.setText(newValue);
                txtPastPerfectWe.setText(newValue);
                txtPastPerfectYouPlural.setText(newValue);
                txtPastPerfectThey.setText(newValue);
                txtFuturePerfectI.setText(newValue);
                txtFuturePerfectYou.setText(newValue);
                txtFuturePerfectHe.setText(newValue);
                txtFuturePerfectWe.setText(newValue);
                txtFuturePerfectYouPlural.setText(newValue);
                txtFuturePerfectThey.setText(newValue);
                update = true;
            }
        });
        txtPresentParticiple.textProperty().addListener((observable, oldValue, newValue) -> {
            txtPresentContinuousI.setText(newValue);
            txtPresentContinuousYou.setText(newValue);
            txtPresentContinuousHe.setText(newValue);
            txtPresentContinuousWe.setText(newValue);
            txtPresentContinuousYouPlural.setText(newValue);
            txtPresentContinuousThey.setText(newValue);
            txtPresentPerfectContinuousI.setText(newValue);
            txtPresentPerfectContinuousYou.setText(newValue);
            txtPresentPerfectContinuousHe.setText(newValue);
            txtPresentPerfectContinuousWe.setText(newValue);
            txtPresentPerfectContinuousYouPlural.setText(newValue);
            txtPresentPerfectContinuousThey.setText(newValue);
            txtPastContinuousI.setText(newValue);
            txtPastContinuousYou.setText(newValue);
            txtPastContinuousHe.setText(newValue);
            txtPastContinuousWe.setText(newValue);
            txtPastContinuousYouPlural.setText(newValue);
            txtPastContinuousThey.setText(newValue);
            txtPastPerfectContinuousI.setText(newValue);
            txtPastPerfectContinuousYou.setText(newValue);
            txtPastPerfectContinuousHe.setText(newValue);
            txtPastPerfectContinuousWe.setText(newValue);
            txtPastPerfectContinuousYouPlural.setText(newValue);
            txtPastPerfectContinuousThey.setText(newValue);
            txtFutureContinuousI.setText(newValue);
            txtFutureContinuousYou.setText(newValue);
            txtFutureContinuousHe.setText(newValue);
            txtFutureContinuousWe.setText(newValue);
            txtFutureContinuousYouPlural.setText(newValue);
            txtFutureContinuousThey.setText(newValue);
            txtFuturePerfectContinuousI.setText(newValue);
            txtFuturePerfectContinuousYou.setText(newValue);
            txtFuturePerfectContinuousHe.setText(newValue);
            txtFuturePerfectContinuousWe.setText(newValue);
            txtFuturePerfectContinuousYouPlural.setText(newValue);
            txtFuturePerfectContinuousThey.setText(newValue);
        });
    }

    public void onCancel() {
        Stage stage = (Stage) txtInfinitive.getScene().getWindow();
        stage.close();
    }

    public void onOK() {
        if (areAllFilled()) {
            VerbEnglish verb = new VerbEnglish();
            verb.infinitive = txtInfinitive.getText().trim();
            verb.presentParticiple = txtPresentParticiple.getText().trim();
            verb.pastParticiple = txtPastParticiple.getText().trim();

            verb.presentSimple = new String[] {txtPresentSimpleI.getText().trim(), txtPresentSimpleYou.getText().trim(), txtPresentSimpleHe.getText().trim(),
                                               txtPresentSimpleWe.getText().trim(), txtPresentSimpleYouPlural.getText().trim(),
                                               txtPresentSimpleThey.getText().trim()};
            verb.presentPerfect = new String[] {txtPresentPerfectI.getText().trim(), txtPresentPerfectYou.getText().trim(),
                                                txtPresentPerfectHe.getText().trim(), txtPresentPerfectWe.getText().trim(),
                                                txtPresentPerfectYouPlural.getText().trim(), txtPresentPerfectThey.getText().trim()};
            verb.presentContinuous = new String[] {txtPresentContinuousI.getText().trim(), txtPresentContinuousYou.getText().trim(),
                                                   txtPresentContinuousHe.getText().trim(), txtPresentContinuousWe.getText().trim(),
                                                   txtPresentContinuousYouPlural.getText().trim(), txtPresentContinuousThey.getText().trim()};
            verb.presentPerfectContinuous = new String[] {txtPresentContinuousI.getText().trim(), txtPresentContinuousYou.getText().trim(),
                                                          txtPresentContinuousHe.getText().trim(), txtPresentContinuousWe.getText().trim(),
                                                          txtPresentContinuousYouPlural.getText().trim(), txtPresentContinuousThey.getText().trim()};
            verb.pastSimple = new String[] {txtPastSimpleI.getText().trim(), txtPastSimpleYou.getText().trim(), txtPastSimpleHe.getText().trim(),
                                            txtPastSimpleWe.getText().trim(), txtPastSimpleYouPlural.getText().trim(), txtPastSimpleThey.getText().trim()};
            verb.pastPerfect = new String[] {txtPastPerfectI.getText().trim(), txtPastPerfectYou.getText().trim(), txtPastPerfectHe.getText().trim(),
                                             txtPastPerfectWe.getText().trim(), txtPastPerfectYouPlural.getText().trim(), txtPastPerfectThey.getText().trim()};
            verb.pastContinuous = new String[] {txtPastContinuousI.getText().trim(), txtPastContinuousYou.getText().trim(),
                                                txtPastContinuousHe.getText().trim(), txtPastContinuousWe.getText().trim(),
                                                txtPastContinuousYouPlural.getText().trim(), txtPastContinuousThey.getText().trim()};
            verb.pastPerfectContinuous = new String[] {txtPastPerfectContinuousI.getText().trim(), txtPastPerfectContinuousYou.getText().trim(),
                                                       txtPastPerfectContinuousHe.getText().trim(), txtPastPerfectContinuousWe.getText().trim(),
                                                       txtPastPerfectContinuousYouPlural.getText().trim(), txtPastPerfectContinuousThey.getText().trim()};
            verb.future = new String[] {txtFutureI.getText().trim(), txtFutureYou.getText().trim(), txtFutureHe.getText().trim(), txtFutureWe.getText().trim(),
                                        txtFutureYouPlural.getText().trim(), txtFutureThey.getText().trim()};
            verb.futurePerfect = new String[] {txtFuturePerfectI.getText().trim(), txtFuturePerfectYou.getText().trim(), txtFuturePerfectHe.getText().trim(),
                                               txtFuturePerfectWe.getText().trim(),
                                               txtFuturePerfectYouPlural.getText().trim(),
                                               txtFuturePerfectThey.getText().trim()};
            verb.futureContinuous = new String[] {txtFutureContinuousI.getText().trim(), txtFutureContinuousYou.getText().trim(), txtFutureContinuousHe.getText().trim(),
                                                  txtFutureContinuousWe.getText().trim(),
                                                  txtFutureContinuousYouPlural.getText().trim(),
                                                  txtFutureContinuousThey.getText().trim()};
            verb.futurePerfectContinuous = new String[] {txtFuturePerfectContinuousI.getText().trim(), txtFuturePerfectContinuousYou.getText().trim(),
                                                         txtFuturePerfectContinuousHe.getText().trim(),
                                                         txtFuturePerfectContinuousWe.getText().trim(), txtFuturePerfectContinuousYouPlural.getText().trim(),
                                                         txtFuturePerfectContinuousThey.getText().trim()};
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private void fillTxtBoxes(VerbEnglish verb) {
        txtPresentParticiple.setText(verb.presentParticiple);
        txtPastParticiple.setText(verb.pastParticiple);
        txtPresentSimpleI.setText(verb.presentSimple[0]);
        txtPresentSimpleYou.setText(verb.presentSimple[1]);
        txtPresentSimpleHe.setText(verb.presentSimple[2]);
        txtPresentSimpleWe.setText(verb.presentSimple[3]);
        txtPresentSimpleYouPlural.setText(verb.presentSimple[4]);
        txtPresentSimpleThey.setText(verb.presentSimple[5]);
        txtPresentPerfectI.setText(verb.presentPerfect[0]);
        txtPresentPerfectYou.setText(verb.presentPerfect[1]);
        txtPresentPerfectHe.setText(verb.presentPerfect[2]);
        txtPresentPerfectWe.setText(verb.presentPerfect[3]);
        txtPresentPerfectYouPlural.setText(verb.presentPerfect[4]);
        txtPresentPerfectThey.setText(verb.presentPerfect[5]);
        txtPresentContinuousI.setText(verb.presentContinuous[0]);
        txtPresentContinuousYou.setText(verb.presentContinuous[1]);
        txtPresentContinuousHe.setText(verb.presentContinuous[2]);
        txtPresentContinuousWe.setText(verb.presentContinuous[3]);
        txtPresentContinuousYouPlural.setText(verb.presentContinuous[4]);
        txtPresentContinuousThey.setText(verb.presentContinuous[5]);
        txtPresentPerfectContinuousI.setText(verb.presentContinuous[0]);
        txtPresentPerfectContinuousYou.setText(verb.presentContinuous[1]);
        txtPresentPerfectContinuousHe.setText(verb.presentContinuous[2]);
        txtPresentPerfectContinuousWe.setText(verb.presentContinuous[3]);
        txtPresentPerfectContinuousYouPlural.setText(verb.presentContinuous[4]);
        txtPresentPerfectContinuousThey.setText(verb.presentContinuous[5]);
        txtPastSimpleI.setText(verb.pastSimple[0]);
        txtPastSimpleYou.setText(verb.pastSimple[1]);
        txtPastSimpleHe.setText(verb.pastSimple[2]);
        txtPastSimpleWe.setText(verb.pastSimple[3]);
        txtPastSimpleYouPlural.setText(verb.pastSimple[4]);
        txtPastSimpleThey.setText(verb.pastSimple[5]);
        txtPastPerfectI.setText(verb.pastPerfect[0]);
        txtPastPerfectYou.setText(verb.pastPerfect[1]);
        txtPastPerfectHe.setText(verb.pastPerfect[2]);
        txtPastPerfectWe.setText(verb.pastPerfect[3]);
        txtPastPerfectYouPlural.setText(verb.pastPerfect[4]);
        txtPastPerfectThey.setText(verb.pastPerfect[5]);
        txtPastContinuousI.setText(verb.pastContinuous[0]);
        txtPastContinuousYou.setText(verb.pastContinuous[1]);
        txtPastContinuousHe.setText(verb.pastContinuous[2]);
        txtPastContinuousWe.setText(verb.pastContinuous[3]);
        txtPastContinuousYouPlural.setText(verb.pastContinuous[4]);
        txtPastContinuousThey.setText(verb.pastContinuous[5]);
        txtPastPerfectContinuousI.setText(verb.pastPerfectContinuous[0]);
        txtPastPerfectContinuousYou.setText(verb.pastPerfectContinuous[1]);
        txtPastPerfectContinuousHe.setText(verb.pastPerfectContinuous[2]);
        txtPastPerfectContinuousWe.setText(verb.pastPerfectContinuous[3]);
        txtPastPerfectContinuousYouPlural.setText(verb.pastPerfectContinuous[4]);
        txtPastPerfectContinuousThey.setText(verb.pastPerfectContinuous[5]);
        txtFutureI.setText(verb.future[0]);
        txtFutureYou.setText(verb.future[1]);
        txtFutureHe.setText(verb.future[2]);
        txtFutureWe.setText(verb.future[3]);
        txtFutureYouPlural.setText(verb.future[4]);
        txtFutureThey.setText(verb.future[5]);
        txtFuturePerfectI.setText(verb.futurePerfect[0]);
        txtFuturePerfectYou.setText(verb.futurePerfect[1]);
        txtFuturePerfectHe.setText(verb.futurePerfect[2]);
        txtFuturePerfectWe.setText(verb.futurePerfect[3]);
        txtFuturePerfectYouPlural.setText(verb.futurePerfect[4]);
        txtFuturePerfectThey.setText(verb.futurePerfect[5]);
        txtFutureContinuousI.setText(verb.futureContinuous[0]);
        txtFutureContinuousYou.setText(verb.futureContinuous[1]);
        txtFutureContinuousHe.setText(verb.futureContinuous[2]);
        txtFutureContinuousWe.setText(verb.futureContinuous[3]);
        txtFutureContinuousYouPlural.setText(verb.futureContinuous[4]);
        txtFutureContinuousThey.setText(verb.futureContinuous[5]);
        txtFuturePerfectContinuousI.setText(verb.futurePerfectContinuous[0]);
        txtFuturePerfectContinuousYou.setText(verb.futurePerfectContinuous[1]);
        txtFuturePerfectContinuousHe.setText(verb.futurePerfectContinuous[2]);
        txtFuturePerfectContinuousWe.setText(verb.futurePerfectContinuous[3]);
        txtFuturePerfectContinuousYouPlural.setText(verb.futurePerfectContinuous[4]);
        txtFuturePerfectContinuousThey.setText(verb.futurePerfectContinuous[5]);
    }

    /**
     * Returns true if all the text fields have <i>something</i> in them
     */
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
        if (node instanceof TextField) {
            TextField txt = (TextField) node;
            txt.setText(txt.getText() + c);
        }
    }
}
