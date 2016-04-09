package br_0309.apps.languageTrainer.verbs;

import java.io.Serializable;

public class VerbGerman extends Verb implements Serializable {

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

    public VerbGerman() {
        präsens = new String[6];
        perfekt = new String[6];
        präteritum = new String[6];
        plusquamperfekt = new String[6];
        futurI = new String[6];
        futurII = new String[6];
        konjunktivIPräsens = new String[6];
        konjunktivIPerfekt = new String[6];
        konjunktivIFuturI = new String[6];
        konjunktivIFuturII = new String[6];
        konjunktivIIPräteritum = new String[6];
        konjunktivIIPlusquamperfekt = new String[6];
        konjunktivIIFuturI = new String[6];
        konjunktivIIFuturII = new String[6];
        isHaben = true;
    }

    public boolean isCorrect(int number, String answer) {
        answer = answer.trim();
        //noinspection HardcodedLineSeparator
        for (String s : getAnswers(number).split("\n")) {
            if (s.trim().equals(answer)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("HardcodedFileSeparator")
    public String getQuestion(int number) {
        switch (number) {
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

    public String getAnswers(int number) {
        String[] answers;
        String[] verbs;
        int pos;
        String person;
        String ending;
        switch (number) {
            case 0:
                answers = partizipI.split(";");
                break;
            case 1:
                answers = partizipII.split(";");
                break;
            case 2:
                answers = präsens[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich " + answers[i];
                }
                break;
            case 3:
                answers = präsens[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du " + answers[i];
                }
                break;
            case 4:
                verbs = präsens[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "er " + verb;
                    answers[pos++] = "sie " + verb;
                    answers[pos++] = "es " + verb;
                }
                break;
            case 5:
                answers = präsens[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir " + answers[i];
                }
                break;
            case 6:
                answers = präsens[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr " + answers[i];
                }
                break;
            case 7:
                answers = präsens[5].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie " + answers[i];
                }
                break;
            case 8:
                answers = perfekt[0].split(";");
                if (isHaben) {
                    person = "ich habe ";
                } else {
                    person = "ich bin ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 9:
                answers = perfekt[1].split(";");
                if (isHaben) {
                    person = "du hast ";
                } else {
                    person = "du bist ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 10:
                verbs = perfekt[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                if (isHaben) {
                    person = " hat ";
                } else {
                    person = " ist ";
                }
                for (String verb : verbs) {
                    answers[pos++] = "er" + person + verb;
                    answers[pos++] = "sie" + person + verb;
                    answers[pos++] = "es" + person + verb;
                }
                break;
            case 11:
                answers = perfekt[3].split(";");
                if (isHaben) {
                    person = "wir haben ";
                } else {
                    person = "wir sind ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 12:
                answers = perfekt[4].split(";");
                if (isHaben) {
                    person = "ihr habt ";
                } else {
                    person = "ihr seid ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 13:
                answers = perfekt[5].split(";");
                if (isHaben) {
                    person = "sie haben ";
                } else {
                    person = "sie sind ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 14:
                answers = präteritum[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich " + answers[i];
                }
                break;
            case 15:
                answers = präteritum[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du " + answers[i];
                }
                break;
            case 16:
                verbs = präteritum[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "er " + verb;
                    answers[pos++] = "sie " + verb;
                    answers[pos++] = "es " + verb;
                }
                break;
            case 17:
                answers = präteritum[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir " + answers[i];
                }
                break;
            case 18:
                answers = präteritum[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr " + answers[i];
                }
                break;
            case 19:
                answers = präteritum[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie " + answers[i];
                }
                break;
            case 20:
                answers = plusquamperfekt[0].split(";");
                if (isHaben) {
                    person = "ich hatte ";
                } else {
                    person = "ich war ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 21:
                answers = plusquamperfekt[1].split(";");
                if (isHaben) {
                    person = "du hattest ";
                } else {
                    person = "du warst ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 22:
                verbs = plusquamperfekt[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                if (isHaben) {
                    person = " hatte ";
                } else {
                    person = " war ";
                }
                for (String verb : verbs) {
                    answers[pos++] = "er" + person + verb;
                    answers[pos++] = "sie" + person + verb;
                    answers[pos++] = "es" + person + verb;
                }
                break;
            case 23:
                answers = plusquamperfekt[3].split(";");
                if (isHaben) {
                    person = "wir hatten ";
                } else {
                    person = "wir waren ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 24:
                answers = plusquamperfekt[4].split(";");
                if (isHaben) {
                    person = "ihr hattet ";
                } else {
                    person = "ihr wart ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 25:
                answers = plusquamperfekt[5].split(";");
                if (isHaben) {
                    person = "sie hatten ";
                } else {
                    person = "sie waren ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 26:
                answers = futurI[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich werde " + answers[i];
                }
                break;
            case 27:
                answers = futurI[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du wirst " + answers[i];
                }
                break;
            case 28:
                verbs = futurI[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "er wird " + verb;
                    answers[pos++] = "sie wird " + verb;
                    answers[pos++] = "es wird " + verb;
                }
                break;
            case 29:
                answers = futurI[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir werden " + answers[i];
                }
                break;
            case 30:
                answers = futurI[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr werdet " + answers[i];
                }
                break;
            case 31:
                answers = futurI[5].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie werden " + answers[i];
                }
                break;
            case 32:
                answers = futurII[0].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich werde " + answers[i] + ending;
                }
                break;
            case 33:
                answers = futurII[1].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du wirst " + answers[i] + ending;
                }
                break;
            case 34:
                verbs = futurII[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (String verb : verbs) {
                    answers[pos++] = "er wird " + verb + ending;
                    answers[pos++] = "sie wird " + verb + ending;
                    answers[pos++] = "es wird " + verb + ending;
                }
                break;
            case 35:
                answers = futurII[3].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir werden " + answers[i] + ending;
                }
                break;
            case 36:
                answers = futurII[4].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr werdet " + answers[i] + ending;
                }
                break;
            case 37:
                answers = futurII[5].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie werden " + answers[i] + ending;
                }
                break;
            case 38:
                answers = konjunktivIPräsens[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich " + answers[i];
                }
                break;
            case 39:
                answers = konjunktivIPräsens[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du " + answers[i];
                }
                break;
            case 40:
                verbs = konjunktivIPräsens[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "er " + verb;
                    answers[pos++] = "sie " + verb;
                    answers[pos++] = "es " + verb;
                }
                break;
            case 41:
                answers = konjunktivIPräsens[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir " + answers[i];
                }
                break;
            case 42:
                answers = konjunktivIPräsens[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr " + answers[i];
                }
                break;
            case 43:
                answers = konjunktivIPräsens[5].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie " + answers[i];
                }
                break;
            case 44:
                answers = konjunktivIPerfekt[0].split(";");
                if (isHaben) {
                    person = "ich habe ";
                } else {
                    person = "ich sei ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 45:
                verbs = konjunktivIPerfekt[1].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isHaben) {
                    person = "du habest ";
                } else {
                    person = "du seist ";
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "du seiest " + answers[i];
                    }
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[pos++] = person + answers[i];
                }
                break;
            case 46:
                verbs = konjunktivIPerfekt[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                if (isHaben) {
                    person = " habe ";
                } else {
                    person = " sei ";
                }
                for (String verb : verbs) {
                    answers[pos++] = "er" + person + verb;
                    answers[pos++] = "sie" + person + verb;
                    answers[pos++] = "es" + person + verb;
                }
                break;
            case 47:
                answers = konjunktivIPerfekt[3].split(";");
                if (isHaben) {
                    person = "wir haben ";
                } else {
                    person = "wir seien ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 48:
                answers = konjunktivIPerfekt[4].split(";");
                if (isHaben) {
                    person = "ihr habet ";
                } else {
                    person = "ihr seiet ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 49:
                answers = konjunktivIPerfekt[5].split(";");
                if (isHaben) {
                    person = "sie haben ";
                } else {
                    person = "sie seien ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 50:
                answers = konjunktivIFuturI[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich werde " + answers[i];
                }
                break;
            case 51:
                answers = konjunktivIFuturI[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du werdest " + answers[i];
                }
                break;
            case 52:
                verbs = konjunktivIFuturI[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "er werde " + verb;
                    answers[pos++] = "sie werde " + verb;
                    answers[pos++] = "es werde " + verb;
                }
                break;
            case 53:
                answers = konjunktivIFuturI[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir werden " + answers[i];
                }
                break;
            case 54:
                answers = konjunktivIFuturI[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr werdet " + answers[i];
                }
                break;
            case 55:
                answers = konjunktivIFuturI[5].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie werden " + answers[i];
                }
                break;
            case 56:
                answers = konjunktivIFuturII[0].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich werde " + answers[i] + ending;
                }
                break;
            case 57:
                answers = konjunktivIFuturII[1].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du werdest " + answers[i] + ending;
                }
                break;
            case 58:
                verbs = konjunktivIFuturII[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (String verb : verbs) {
                    answers[pos++] = "er werde " + verb + ending;
                    answers[pos++] = "sie werde " + verb + ending;
                    answers[pos++] = "es werde " + verb + ending;
                }
                break;
            case 59:
                answers = konjunktivIFuturII[3].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir werden " + answers[i] + ending;
                }
                break;
            case 60:
                answers = konjunktivIFuturII[4].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr werdet " + answers[i] + ending;
                }
                break;
            case 61:
                answers = konjunktivIFuturII[5].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie werden " + answers[i] + ending;
                }
                break;
            case 62:
                answers = konjunktivIIPräteritum[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich " + answers[i];
                }
                break;
            case 63:
                answers = konjunktivIIPräteritum[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du " + answers[i];
                }
                break;
            case 64:
                verbs = konjunktivIIPräteritum[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "er " + verb;
                    answers[pos++] = "sie " + verb;
                    answers[pos++] = "es " + verb;
                }
                break;
            case 65:
                answers = konjunktivIIPräteritum[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir " + answers[i];
                }
                break;
            case 66:
                answers = konjunktivIIPräteritum[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr " + answers[i];
                }
                break;
            case 67:
                answers = konjunktivIIPräteritum[5].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie " + answers[i];
                }
                break;
            case 68:
                answers = konjunktivIIPlusquamperfekt[0].split(";");
                if (isHaben) {
                    person = "ich hätte ";
                } else {
                    person = "ich wäre ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 69:
                verbs = konjunktivIIPlusquamperfekt[1].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isHaben) {
                    person = "du hättest ";
                } else {
                    person = "du wärst ";
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "du wärest " + answers[i];
                    }
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[pos++] = person + answers[i];
                }
                break;
            case 70:
                verbs = konjunktivIIPlusquamperfekt[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                if (isHaben) {
                    person = " hätte ";
                } else {
                    person = " wäre ";
                }
                for (String verb : verbs) {
                    answers[pos++] = "er" + person + verb;
                    answers[pos++] = "sie" + person + verb;
                    answers[pos++] = "es" + person + verb;
                }
                break;
            case 71:
                answers = konjunktivIIPlusquamperfekt[3].split(";");
                if (isHaben) {
                    person = "wir hätten ";
                } else {
                    person = "wir wären ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 72:
                verbs = konjunktivIIPlusquamperfekt[1].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isHaben) {
                    person = "ihr hättet ";
                } else {
                    person = "ihr wärt ";
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "du wäret " + answers[i];
                    }
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[pos++] = person + answers[i];
                }
                break;
            case 73:
                answers = konjunktivIIPlusquamperfekt[5].split(";");
                if (isHaben) {
                    person = "sie hätten ";
                } else {
                    person = "sie wären ";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = person + answers[i];
                }
                break;
            case 74:
                answers = konjunktivIIFuturI[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich würde " + answers[i];
                }
                break;
            case 75:
                answers = konjunktivIIFuturI[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du würdest " + answers[i];
                }
                break;
            case 76:
                verbs = konjunktivIIFuturI[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "er würde " + verb;
                    answers[pos++] = "sie würde " + verb;
                    answers[pos++] = "es würde " + verb;
                }
                break;
            case 77:
                answers = konjunktivIIFuturI[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir würden " + answers[i];
                }
                break;
            case 78:
                answers = konjunktivIIFuturI[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr würdet " + answers[i];
                }
                break;
            case 79:
                answers = konjunktivIIFuturI[5].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie würden " + answers[i];
                }
                break;
            case 80:
                answers = konjunktivIIFuturII[0].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ich würdest " + answers[i] + ending;
                }
                break;
            case 81:
                answers = konjunktivIIFuturII[1].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "du würdest " + answers[i] + ending;
                }
                break;
            case 82:
                verbs = konjunktivIIFuturII[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (String verb : verbs) {
                    answers[pos++] = "er würde " + verb + ending;
                    answers[pos++] = "sie würde " + verb + ending;
                    answers[pos++] = "es würde " + verb + ending;
                }
                break;
            case 83:
                answers = konjunktivIIFuturII[3].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "wir würden " + answers[i] + ending;
                }
                break;
            case 84:
                answers = konjunktivIIFuturII[4].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "ihr würdet " + answers[i] + ending;
                }
                break;
            case 85:
                answers = konjunktivIIFuturII[5].split(";");
                if (isHaben) {
                    ending = " haben";
                } else {
                    ending = " sein";
                }
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "sie würden " + answers[i] + ending;
                }
                break;
            default:
                return "";
        }
        String returns = "";
        for (String s : answers) {
            //noinspection HardcodedLineSeparator
            returns += s + "\n";
        }
        return returns;
    }

    @Override
    public String getInfinitive() {
        return infinitiv;
    }

}
