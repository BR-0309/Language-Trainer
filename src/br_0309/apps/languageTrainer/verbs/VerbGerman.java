package br_0309.apps.languageTrainer.verbs;

import java.io.Serializable;

public class VerbGerman implements Serializable, Verb {

    public String infinitiv;
    public String partizipI;
    public String partizipII;
    public String[] präsens;
    public String[] perfekt;
    public String[] präteritum;
    public String[] plusquamperfekt;
    public String[] futurI;
    public String[] futurII;
    public String[] konjunktivIPräsens;
    public String[] konjunktivIPerfekt;
    public String[] konjunktivIFuturI;
    public String[] konjunktivIFuturII;
    public String[] konjunktivIIPräteritum;
    public String[] konjunktivIIPlusquamperfekt;
    public String[] konjunktivIIFuturI;
    public String[] konjunktivIIFuturII;
    public boolean isHaben;

    @SuppressWarnings("HardcodedFileSeparator")
    public String getQuestion(int number) {
        switch(number) {
            case 0:
                return infinitiv + ": Partizip I";
            case 1:
                return infinitiv + ": Partizip II";
            case 2:
                return infinitiv + ": Präsens ich";
            case 3:
                return infinitiv + ": Präsens du";
            case 4:
                return infinitiv + ": Präsens er/sie/es";
            case 5:
                return infinitiv + ": Präsens wir";
            case 6:
                return infinitiv + ": Präsens ihr";
            case 7:
                return infinitiv + ": Präsens sie";
            case 8:
                return infinitiv + ": Perfekt ich";
            case 9:
                return infinitiv + ": Perfekt du";
            case 10:
                return infinitiv + ": Perfekt er/sie/es";
            case 11:
                return infinitiv + ": Perfekt wir";
            case 12:
                return infinitiv + ": Perfekt ihr";
            case 13:
                return infinitiv + ": Perfekt sie";
            case 14:
                return infinitiv + ": Präteritum ich";
            case 15:
                return infinitiv + ": Präteritum du";
            case 16:
                return infinitiv + ": Präteritum er/sie/es";
            case 17:
                return infinitiv + ": Präteritum wir";
            case 18:
                return infinitiv + ": Präteritum ihr";
            case 19:
                return infinitiv + ": Präteritum sie";
            case 20:
                return infinitiv + ": Plusquamperfekt ich";
            case 21:
                return infinitiv + ": Plusquamperfekt du";
            case 22:
                return infinitiv + ": Plusquamperfekt er/sie/es";
            case 23:
                return infinitiv + ": Plusquamperfekt wir";
            case 24:
                return infinitiv + ": Plusquamperfekt ihr";
            case 25:
                return infinitiv + ": Plusquamperfekt sie";
            case 26:
                return infinitiv + ": Futur I ich";
            case 27:
                return infinitiv + ": Futur I du";
            case 28:
                return infinitiv + ": Futur I er/sie/es";
            case 29:
                return infinitiv + ": Futur I wir";
            case 30:
                return infinitiv + ": Futur I ihr";
            case 31:
                return infinitiv + ": Futur I sie";
            case 32:
                return infinitiv + ": Futur II ich";
            case 33:
                return infinitiv + ": Futur II du";
            case 34:
                return infinitiv + ": Futur II er/sie/es";
            case 35:
                return infinitiv + ": Futur II wir";
            case 36:
                return infinitiv + ": Futur II ihr";
            case 37:
                return infinitiv + ": Futur II sie";
            case 38:
                return infinitiv + ": Konjunktiv I Präsens ich";
            case 39:
                return infinitiv + ": Konjunktiv I Präsens du";
            case 40:
                return infinitiv + ": Konjunktiv I Präsens er/sie/es";
            case 41:
                return infinitiv + ": Konjunktiv I Präsens wir";
            case 42:
                return infinitiv + ": Konjunktiv I Präsens ihr";
            case 43:
                return infinitiv + ": Konjunktiv I Präsens sie";
            case 44:
                return infinitiv + ": Konjunktiv I Perfekt ich";
            case 45:
                return infinitiv + ": Konjunktiv I Perfekt du";
            case 46:
                return infinitiv + ": Konjunktiv I Perfekt er/sie/es";
            case 47:
                return infinitiv + ": Konjunktiv I Perfekt wir";
            case 48:
                return infinitiv + ": Konjunktiv I Perfekt ihr";
            case 49:
                return infinitiv + ": Konjunktiv I Perfekt sie";
            case 50:
                return infinitiv + ": Konjunktiv I Futur I ich";
            case 51:
                return infinitiv + ": Konjunktiv I Futur I du";
            case 52:
                return infinitiv + ": Konjunktiv I Futur I er/sie/es";
            case 53:
                return infinitiv + ": Konjunktiv I Futur I wir";
            case 54:
                return infinitiv + ": Konjunktiv I Futur I ihr";
            case 55:
                return infinitiv + ": Konjunktiv I Futur I sie";
            case 56:
                return infinitiv + ": Konjunktiv I Futur II ich";
            case 57:
                return infinitiv + ": Konjunktiv I Futur II du";
            case 58:
                return infinitiv + ": Konjunktiv I Futur II er/sie/es";
            case 59:
                return infinitiv + ": Konjunktiv I Futur II wir";
            case 60:
                return infinitiv + ": Konjunktiv I Futur II ihr";
            case 61:
                return infinitiv + ": Konjunktiv I Futur II sie";
            case 62:
                return infinitiv + ": Konjunktiv II Präteritum ich";
            case 63:
                return infinitiv + ": Konjunktiv II Präteritum du";
            case 64:
                return infinitiv + ": Konjunktiv II Präteritum er/sie/es";
            case 65:
                return infinitiv + ": Konjunktiv II Präteritum wir";
            case 66:
                return infinitiv + ": Konjunktiv II Präteritum ihr";
            case 67:
                return infinitiv + ": Konjunktiv II Präteritum sie";
            case 68:
                return infinitiv + ": Konjunktiv II Plusquamperfekt ich";
            case 69:
                return infinitiv + ": Konjunktiv II Plusquamperfekt du";
            case 70:
                return infinitiv + ": Konjunktiv II Plusquamperfekt er/sie/es";
            case 71:
                return infinitiv + ": Konjunktiv II Plusquamperfekt wir";
            case 72:
                return infinitiv + ": Konjunktiv II Plusquamperfekt ihr";
            case 73:
                return infinitiv + ": Konjunktiv II Plusquamperfekt sie";
            case 74:
                return infinitiv + ": Konjunktiv II Futur I ich";
            case 75:
                return infinitiv + ": Konjunktiv II Futur I du";
            case 76:
                return infinitiv + ": Konjunktiv II Futur I er/sie/es";
            case 77:
                return infinitiv + ": Konjunktiv II Futur I wir";
            case 78:
                return infinitiv + ": Konjunktiv II Futur I ihr";
            case 79:
                return infinitiv + ": Konjunktiv II Futur I sie";
            case 80:
                return infinitiv + ": Konjunktiv II Futur II ich";
            case 81:
                return infinitiv + ": Konjunktiv II Futur II du";
            case 82:
                return infinitiv + ": Konjunktiv II Futur II er/sie/es";
            case 83:
                return infinitiv + ": Konjunktiv II Futur II wir";
            case 84:
                return infinitiv + ": Konjunktiv II Futur II ihr";
            case 85:
                return infinitiv + ": Konjunktiv II Futur II sie";
            default:
                return "ERROR";
        }
    }


    public boolean isCorrect(int number, String answer) {

        return false;
    }

    public String getAnswers(int number) {

        return "";
    }

}
