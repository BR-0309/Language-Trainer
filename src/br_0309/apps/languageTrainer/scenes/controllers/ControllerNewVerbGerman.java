package br_0309.apps.languageTrainer.scenes.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

// FIXME: Remove IController
// This is terrible. Why can't I assign multiple nodes the same ID?
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

    // Labels Indikativ Perfekt
    public Label lblIndPerfekt1;
    public Label lblIndPerfekt2;
    public Label lblIndPerfekt3;
    public Label lblIndPerfekt4;
    public Label lblIndPerfekt5;
    public Label lblIndPerfekt6;

    // Labels Indikativ Plusquamperfekt
    public Label lblIndPlusquamperfekt1;
    public Label lblIndPlusquamperfekt2;
    public Label lblIndPlusquamperfekt3;
    public Label lblIndPlusquamperfekt4;
    public Label lblIndPlusquamperfekt5;
    public Label lblIndPlusquamperfekt6;

    // Labels Konjunktiv I Perfekt
    public Label lblKonjunktivIPerfekt1;
    public Label lblKonjunktivIPerfekt2;
    public Label lblKonjunktivIPerfekt3;
    public Label lblKonjunktivIPerfekt4;
    public Label lblKonjunktivIPerfekt5;
    public Label lblKonjunktivIPerfekt6;

    // Labels Konjunktiv II Plusquamperfekt
    public Label lblKonjunktivIIPlusquamperfekt1;
    public Label lblKonjunktivIIPlusquamperfekt2;
    public Label lblKonjunktivIIPlusquamperfekt3;
    public Label lblKonjunktivIIPlusquamperfekt4;
    public Label lblKonjunktivIIPlusquamperfekt5;
    public Label lblKonjunktivIIPlusquamperfekt6;

    // Text fields Präsens Indikativ
    public TextField txtPraesensIch;
    public TextField txtPraesensDu;
    public TextField txtPraesensEr;
    public TextField txtPraesensWir;
    public TextField txtPraesensIhr;
    public TextField txtPraesensSie;

    // Text fields Präteritum Indikativ
    public TextField txtPraeteritumIch;
    public TextField txtPraeteritumDu;
    public TextField txtPraeteritumEr;
    public TextField txtPraeteritumWir;
    public TextField txtPraeteritumIhr;
    public TextField txtPraeteritumSie;

    // Text fields Perfekt Indikativ
    public TextField txtPerfektIch;
    public TextField txtPerfektDu;
    public TextField txtPerfektEr;
    public TextField txtPerfektWir;
    public TextField txtPerfektIhr;
    public TextField txtPerfektSie;

    // Text fields Plusquamperfekt Indikativ
    public TextField txtPlusquamperfektIch;
    public TextField txtPlusquamperfektDu;
    public TextField txtPlusquamperfektEr;
    public TextField txtPlusquamperfektWir;
    public TextField txtPlusquamperfektIhr;
    public TextField txtPlusquamperfektSie;

    // Text fields Futur I Indikativ
    public TextField txtFuturIIch;
    public TextField txtFuturIDu;
    public TextField txtFuturIEr;
    public TextField txtFuturIWir;
    public TextField txtFuturIIhr;
    public TextField txtFuturISie;

    // Text fields Futur II Indikativ
    public TextField txtFuturIIIch;
    public TextField txtFuturIIDu;
    public TextField txtFuturIIEr;
    public TextField txtFuturIIWir;
    public TextField txtFuturIIIhr;
    public TextField txtFuturIISie;

    // Text fields Präsens Konjunktiv I
    public TextField txtKonjunktivIPraesensIch;
    public TextField txtKonjunktivIPraesensDu;
    public TextField txtKonjunktivIPraesensEr;
    public TextField txtKonjunktivIPraesensWir;
    public TextField txtKonjunktivIPraesensIhr;
    public TextField txtKonjunktivIPraesensSie;

    // Text fields Perfekt Konjunktiv I
    public TextField txtKonjunktivIPerfektIch;
    public TextField txtKonjunktivIPerfektDu;
    public TextField txtKonjunktivIPerfektEr;
    public TextField txtKonjunktivIPerfektWir;
    public TextField txtKonjunktivIPerfektIhr;
    public TextField txtKonjunktivIPerfektSie;

    // Text fields Futur I Konjunktiv I
    public TextField txtKonjunktivIFuturIIch;
    public TextField txtKonjunktivIFuturIDu;
    public TextField txtKonjunktivIFuturIEr;
    public TextField txtKonjunktivIFuturIWir;
    public TextField txtKonjunktivIFuturIIhr;
    public TextField txtKonjunktivIFuturISie;

    // Text fields Futur II Konjunktiv I
    public TextField txtKonjunktivIFuturIIIch;
    public TextField txtKonjunktivIFuturIIDu;
    public TextField txtKonjunktivIFuturIIEr;
    public TextField txtKonjunktivIFuturIIWir;
    public TextField txtKonjunktivIFuturIIIhr;
    public TextField txtKonjunktivIFuturIISie;

    // Text fields Präteritum Konjunktiv II
    public TextField txtKonjunktivIIPraeteritumIch;
    public TextField txtKonjunktivIIPraeteritumDu;
    public TextField txtKonjunktivIIPraeteritumEr;
    public TextField txtKonjunktivIIPraeteritumWir;
    public TextField txtKonjunktivIIPraeteritumIhr;
    public TextField txtKonjunktivIIPraeteritumSie;

    // Text fields Futur I Konjunktiv II
    public TextField txtKonjunktivIIFuturIIch;
    public TextField txtKonjunktivIIFuturIDu;
    public TextField txtKonjunktivIIFuturIEr;
    public TextField txtKonjunktivIIFuturIWir;
    public TextField txtKonjunktivIIFuturIIhr;
    public TextField txtKonjunktivIIFuturISie;

    // Text fields Futur II Konjunktiv II
    public TextField txtKonjunktivIIFuturIIIch;
    public TextField txtKonjunktivIIFuturIIDu;
    public TextField txtKonjunktivIIFuturIIEr;
    public TextField txtKonjunktivIIFuturIIWir;
    public TextField txtKonjunktivIIFuturIIIhr;
    public TextField txtKonjunktivIIFuturIISie;

    // Text fields Plusquamperfekt Konjunktiv II
    public TextField txtKonjunktivIIPlusquamperfektIch;
    public TextField txtKonjunktivIIPlusquamperfektDu;
    public TextField txtKonjunktivIIPlusquamperfektEr;
    public TextField txtKonjunktivIIPlusquamperfektWir;
    public TextField txtKonjunktivIIPlusquamperfektIhr;
    public TextField txtKonjunktivIIPlusquamperfektSie;

    public TextField txtInfinitiv;
    public TextField txtPartizipI;
    public TextField txtPartizipII;

    private Label[] lblsHaben;
    private Label[] lblsIndPerfekt;
    private Label[] lblsIndPlusquamperfekt;
    private Label[] lblsKonjunktivIPerfekt;
    private Label[] lblsKonjunktivIIPlusquamperfekt;
    private TextField[] allTextFields;

    private boolean isHabenSelected = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblsHaben = new Label[] {lblHaben1, lblHaben2, lblHaben3, lblHaben4, lblHaben5, lblHaben6, lblHaben7, lblHaben8, lblHaben9, lblHaben10, lblHaben11,
                                 lblHaben12, lblHaben13, lblHaben14, lblHaben15, lblHaben16, lblHaben17, lblHaben18};
        lblsIndPerfekt = new Label[] {lblIndPerfekt1, lblIndPerfekt2, lblIndPerfekt3, lblIndPerfekt4, lblIndPerfekt5, lblIndPerfekt6};
        lblsIndPlusquamperfekt = new Label[] {lblIndPlusquamperfekt1, lblIndPlusquamperfekt2, lblIndPlusquamperfekt3, lblIndPlusquamperfekt4,
                                              lblIndPlusquamperfekt5, lblIndPlusquamperfekt6};
        lblsKonjunktivIPerfekt = new Label[] {lblKonjunktivIPerfekt1, lblKonjunktivIPerfekt2, lblKonjunktivIPerfekt3, lblKonjunktivIPerfekt4,
                                              lblKonjunktivIPerfekt5, lblKonjunktivIPerfekt6};
        lblsKonjunktivIIPlusquamperfekt = new Label[] {lblKonjunktivIIPlusquamperfekt1, lblKonjunktivIIPlusquamperfekt2, lblKonjunktivIIPlusquamperfekt3,
                                                       lblKonjunktivIIPlusquamperfekt4, lblKonjunktivIIPlusquamperfekt5, lblKonjunktivIIPlusquamperfekt6};
        allTextFields = new TextField[] {txtInfinitiv, txtPartizipI, txtPartizipII, txtPraesensIch, txtPraesensDu, txtPraesensEr, txtPraesensWir,
                                         txtPraesensIhr, txtPraesensSie, txtPerfektIch, txtPerfektDu, txtPerfektEr, txtPerfektWir, txtPerfektIhr, txtPerfektSie,
                                         txtPraeteritumIch, txtPraeteritumDu, txtPraeteritumEr, txtPraeteritumWir, txtPraeteritumIhr, txtPraeteritumSie,
                                         txtPlusquamperfektIch, txtPlusquamperfektDu, txtPlusquamperfektEr, txtPlusquamperfektWir, txtPlusquamperfektIhr,
                                         txtPlusquamperfektSie, txtFuturIIch, txtFuturIDu, txtFuturIEr, txtFuturIWir, txtFuturIIhr, txtFuturISie, txtFuturIIIch,
                                         txtFuturIIDu, txtFuturIIEr, txtFuturIIWir, txtFuturIIIhr, txtFuturIISie, txtKonjunktivIPraesensIch,
                                         txtKonjunktivIPraesensDu, txtKonjunktivIPraesensEr, txtKonjunktivIPraesensWir, txtKonjunktivIPraesensIhr,
                                         txtKonjunktivIPraesensSie, txtKonjunktivIPerfektIch, txtKonjunktivIPerfektDu, txtKonjunktivIPerfektEr,
                                         txtKonjunktivIPerfektWir, txtKonjunktivIPerfektIhr, txtKonjunktivIPerfektSie, txtKonjunktivIFuturIIch,
                                         txtKonjunktivIFuturIDu, txtKonjunktivIFuturIEr, txtKonjunktivIFuturIWir, txtKonjunktivIFuturIIhr,
                                         txtKonjunktivIFuturISie, txtKonjunktivIFuturIIIch, txtKonjunktivIFuturIIDu, txtKonjunktivIFuturIIEr,
                                         txtKonjunktivIFuturIIWir, txtKonjunktivIFuturIIIhr, txtKonjunktivIFuturIISie, txtKonjunktivIIPraeteritumIch,
                                         txtKonjunktivIIPraeteritumDu, txtKonjunktivIIPraeteritumEr, txtKonjunktivIIPraeteritumWir,
                                         txtKonjunktivIIPraeteritumIhr, txtKonjunktivIIPraeteritumSie, txtKonjunktivIIPlusquamperfektIch,
                                         txtKonjunktivIIPlusquamperfektDu, txtKonjunktivIIPlusquamperfektEr, txtKonjunktivIIPlusquamperfektWir,
                                         txtKonjunktivIIPlusquamperfektIhr, txtKonjunktivIIPlusquamperfektSie, txtKonjunktivIIFuturIIch,
                                         txtKonjunktivIIFuturIDu, txtKonjunktivIIFuturIEr, txtKonjunktivIIFuturIWir, txtKonjunktivIIFuturIIhr,
                                         txtKonjunktivIIFuturISie, txtKonjunktivIIFuturIIIch, txtKonjunktivIIFuturIIDu, txtKonjunktivIIFuturIIEr,
                                         txtKonjunktivIIFuturIIWir, txtKonjunktivIIFuturIIIhr, txtKonjunktivIIFuturIISie};
    }

    // RadioButton
    @SuppressWarnings("HardcodedFileSeparator")
    public void onHabenChanged() {
        // Inverts boolean
        isHabenSelected = ! isHabenSelected;
        String haben;
        String[] indPerfekt;
        String[] indPlusquamperfekt;
        String[] konjunktivIPerfekt;
        String[] konjunktivIIPlusquamperfekt;
        if (isHabenSelected) {
            haben = "haben";
            indPerfekt = new String[] {"Ich habe", "Du hast", "Er/Sie/Es hat", "Wir haben", "Ihr habt", "Sie haben"};
            indPlusquamperfekt = new String[] {"Ich hatte", "Du hattest", "Er/Sie/Es hatte", "Wir hatten", "Ihr hattet", "Sie hatten"};
            konjunktivIPerfekt = new String[] {"Ich habe", "Du habest", "Er/Sie/Es habe", "Wir haben", "Ihr habet", "Sie haben"};
            konjunktivIIPlusquamperfekt = new String[] {"Ich hätte", "Du hättest", "Er/Sie/Es hätte", "Wir hätten", "Ihr hättet", "Sie hätten"};
        } else {
            haben = "sein";
            indPerfekt = new String[] {"Ich bin", "Du bist", "Er/Sie/Es ist", "Wir sind", "Ihr seid", "Sie sind"};
            indPlusquamperfekt = new String[] {"Ich war", "Du warst", "Er/Sie/Es war", "Wir waren", "Ihr wart", "Sie waren"};
            konjunktivIPerfekt = new String[] {"Ich sei", "Du seist/seiest", "Er/Sie/Es sei", "Wir seien", "Ihr seiet", "Sie seien"};
            konjunktivIIPlusquamperfekt = new String[] {"Ich wäre", "Du wärst/wärest", "Er/Sie/Es wäre", "Wir wären", "Ihr wärt/wäret", "Sie wären"};
        }
        for (Label aLblsHaben : lblsHaben) aLblsHaben.setText(haben);
        for (int i = 0; i < lblsIndPerfekt.length; i++) lblsIndPerfekt[i].setText(indPerfekt[i]);
        for (int i = 0; i < lblsIndPlusquamperfekt.length; i++) lblsIndPlusquamperfekt[i].setText(indPlusquamperfekt[i]);
        for (int i = 0; i < lblsKonjunktivIPerfekt.length; i++) lblsKonjunktivIPerfekt[i].setText(konjunktivIPerfekt[i]);
        for (int i = 0; i < lblsKonjunktivIIPlusquamperfekt.length; i++) lblsKonjunktivIIPlusquamperfekt[i].setText(konjunktivIIPlusquamperfekt[i]);
    }

    public void onOK() {
        if(!areAllFilled()){
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        // FIXME
    }

    public void onCancel() {
        Stage stage = (Stage) lblHaben1.getScene().getWindow();
        stage.close();
    }

    private boolean areAllFilled(){
        for (TextField txt : allTextFields) {
            if(txt.getText().trim().isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }
}
