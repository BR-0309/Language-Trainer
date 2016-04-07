package br_0309.apps.languageTrainer.verbs;

import java.io.Serializable;

// FIXME: Check spelling
// FIXME: Add conjugation
// TODO: Remember that certain verbs don't conjugate completely
public class VerbFrench implements Serializable, Verb {

    public String infinitif;
    public String participePresent;
    public String participePasse;
    public String[] present;
    public String[] passeCompose;
    public String[] imparfait;
    public String[] plusQueParfait;
    public String[] passeSimple;
    public String[] futurSimple;
    public String[] futurCompose;
    public String[] conditionnelPresent;
    public String[] imperatifPresent;
    public boolean isAvoir;

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
                return infinitif + ": participe présent";
            case 1:
                return infinitif + ": participe passé";
            case 2:
                return infinitif + ": présent je";
            case 3:
                return infinitif + ": présent tu";
            case 4:
                return infinitif + ": présent il/elle/on";
            case 5:
                return infinitif + ": présent nous";
            case 6:
                return infinitif + ": présent vous";
            case 7:
                return infinitif + ": présent ils/elles";
            case 8:
                return infinitif + ": passé composé je";
            case 9:
                return infinitif + ": passé composé tu";
            case 10:
                return infinitif + ": passé composé il/elle/on";
            case 11:
                return infinitif + ": passé composé nous";
            case 12:
                return infinitif + ": passé composé vous";
            case 13:
                return infinitif + ": passé composé ils/elles";
            case 14:
                return infinitif + ": imparfait je";
            case 15:
                return infinitif + ": imparfait tu";
            case 16:
                return infinitif + ": imparfait il/elle/on";
            case 17:
                return infinitif + ": imparfait nous";
            case 18:
                return infinitif + ": imparfait vous";
            case 19:
                return infinitif + ": imparfait ils/elles";
            case 20:
                return infinitif + ": plus-que-parfait je";
            case 21:
                return infinitif + ": plus-que-parfait tu";
            case 22:
                return infinitif + ": plus-que-parfait il/elle/on";
            case 23:
                return infinitif + ": plus-que-parfait nous";
            case 24:
                return infinitif + ": plus-que-parfait vous";
            case 25:
                return infinitif + ": plus-que-parfait ils/elles";
            case 26:
                return infinitif + ": passé simple je";
            case 27:
                return infinitif + ": passé simple tu";
            case 28:
                return infinitif + ": passé simple il/elle/on";
            case 29:
                return infinitif + ": passé simple nous";
            case 30:
                return infinitif + ": passé simple vous";
            case 31:
                return infinitif + ": passé simple ils/elles";
            case 32:
                return infinitif + ": futur simple je";
            case 33:
                return infinitif + ": futur simple tu";
            case 34:
                return infinitif + ": futur simple il/elle/on";
            case 35:
                return infinitif + ": futur simple nous";
            case 36:
                return infinitif + ": futur simple vous";
            case 37:
                return infinitif + ": futur simple ils/elles";
            case 38:
                return infinitif + ": futur composé je";
            case 39:
                return infinitif + ": futur composé tu";
            case 40:
                return infinitif + ": futur composé il/elle/on";
            case 41:
                return infinitif + ": futur composé nous";
            case 42:
                return infinitif + ": futur composé vous";
            case 43:
                return infinitif + ": futur composé ils/elles";
            case 44:
                return infinitif + ": conditionnel présent je";
            case 45:
                return infinitif + ": conditionnel présent tu";
            case 46:
                return infinitif + ": conditionnel présent il/elle/on";
            case 47:
                return infinitif + ": conditionnel présent nous";
            case 48:
                return infinitif + ": conditionnel présent vous";
            case 49:
                return infinitif + ": conditionnel présent ils/elles";
            case 50:
                return infinitif + ": impératif tu";
            case 51:
                return infinitif + ": impératif nous";
            case 52:
                return infinitif + ": impératif vous";
            default:
                return "ERROR: " + number;
        }
    }

    public String getAnswers(int number) {
        String[] verbs;
        String[] answers;
        int pos;
        switch (number) {
            case 0:
                answers = participePresent.split(";");
                break;
            case 1:
                answers = participePasse.split(";");
                break;
            case 2:
                answers = present[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "je " + answers[i];
                }
                break;
            case 3:
                answers = present[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "tu " + answers[i];
                }
                break;
            case 4:
                verbs = present[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "il " + verb;
                    answers[pos++] = "elle " + verb;
                    answers[pos++] = "on " + verb;
                }
                break;
            case 5:
                answers = present[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "nous " + answers[i];
                }
                break;
            case 6:
                answers = present[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "vous " + answers[i];
                }
                break;
            case 7:
                verbs = present[5].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "ils " + verb;
                    answers[pos++] = "elles " + verb;
                }
                break;
            case 8:
                verbs = passeCompose[0].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "j'ai " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "je suis " + answers[i];
                        answers[pos++] = "je suis " + answers[i] + "e";
                    }
                }
                break;
            case 9:
                verbs = passeCompose[1].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "tu as " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "tu es " + answers[i];
                        answers[pos++] = "tu es" + answers[i] + "e";
                    }
                }
                break;
            case 10:
                verbs = passeCompose[2].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "il a " + answers[i];
                        answers[pos++] = "elle a " + answers[i];
                        answers[pos++] = "on a " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "il est " + answers[i];
                        answers[pos++] = "elle est " + answers[i] + "e";
                        answers[pos++] = "on est " + answers[i];
                    }
                }
                break;
            case 11:
                verbs = passeCompose[3].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "nous avons " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "nous sommes " + answers[i] + "s";
                    }
                }
                break;
            case 12:
                verbs = passeCompose[4].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "vous avez " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "vous êtes " + answers[i] + "s";
                    }
                }
                break;
            case 13:
                verbs = passeCompose[5].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "ils ont " + answers[i];
                        answers[pos++] = "elles ont " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "ils sont " + answers[i] + "s";
                        answers[pos++] = "elles sont " + answers[i] + "es";
                    }
                }
                break;
            case 14:
                answers = imparfait[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "je" + answers[i];
                }
                break;
            case 15:
                answers = imparfait[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "tu" + answers[i];
                }
                break;
            case 16:
                verbs = imparfait[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "il " + verb;
                    answers[pos++] = "elle " + verb;
                    answers[pos++] = "on " + verb;
                }
                break;
            case 17:
                answers = imparfait[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "nous" + answers[i];
                }
                break;
            case 18:
                answers = imparfait[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "vous" + answers[i];
                }
                break;
            case 19:
                verbs = imparfait[5].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "il " + verb;
                    answers[pos++] = "elle " + verb;
                }
                break;
            case 20:
                verbs = plusQueParfait[0].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "j'avais " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "j'étais " + answers[i];
                        answers[pos++] = "j'étais " + answers[i] + "e";
                    }
                }
                break;
            case 21:
                verbs = plusQueParfait[1].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "tu avais " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "tu étais " + answers[i];
                        answers[pos++] = "tu étais " + answers[i] + "e";
                    }
                }
                break;
            case 22:
                verbs = plusQueParfait[2].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "il avait " + answers[i];
                        answers[pos++] = "elle avait " + answers[i];
                        answers[pos++] = "on avait " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "il était " + answers[i];
                        answers[pos++] = "elle était " + answers[i] + "e";
                        answers[pos++] = "on était " + answers[i];
                    }
                }
                break;
            case 23:
                verbs = plusQueParfait[3].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "nous avions " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "nous étions " + answers[i] + "s";
                    }
                }
                break;
            case 24:
                verbs = plusQueParfait[4].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "vous aviez " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "vous étiez " + answers[i] + "s";
                    }
                }
                break;
            case 25:
                verbs = plusQueParfait[5].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                if (isAvoir) {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "ils avaient " + answers[i];
                        answers[pos++] = "elles avaient " + answers[i];
                    }
                } else {
                    for (int i = 0; i < answers.length; i++) {
                        answers[pos++] = "ils étaient " + answers[i] + "s";
                        answers[pos++] = "elles étaient " + answers[i] + "es";
                    }
                }
                break;
            case 26:
                answers = passeSimple[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "je " + answers[i];
                }
                break;
            case 27:
                answers = passeSimple[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "tu " + answers[i];
                }
                break;
            case 28:
                verbs = passeSimple[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "il " + verb;
                    answers[pos++] = "elle " + verb;
                    answers[pos++] = "on " + verb;
                }
                break;
            case 29:
                answers = passeSimple[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "nous " + answers[i];
                }
                break;
            case 30:
                answers = passeSimple[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "vous " + answers[i];
                }
                break;
            case 31:
                verbs = passeSimple[5].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "ils " + verb;
                    answers[pos++] = "elles " + verb;
                }
                break;
            case 32:
                answers = futurSimple[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "je " + answers[i];
                }
                break;
            case 33:
                answers = futurSimple[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "tu " + answers[i];
                }
                break;
            case 34:
                verbs = futurSimple[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "il " + verb;
                    answers[pos++] = "elle " + verb;
                    answers[pos++] = "on " + verb;
                }
                break;
            case 35:
                answers = futurSimple[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "nous " + answers[i];
                }
                break;
            case 36:
                answers = futurSimple[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "vous " + answers[i];
                }
                break;
            case 37:
                verbs = futurSimple[5].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "ils " + verb;
                    answers[pos++] = "elles " + verb;
                }
                break;
            case 38:
                answers = futurCompose[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "je vais " + answers[i];
                }
                break;
            case 39:
                answers = futurCompose[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "tu vas " + answers[i];
                }
                break;
            case 40:
                verbs = futurCompose[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "il va " + verb;
                    answers[pos++] = "elle va " + verb;
                    answers[pos++] = "on va " + verb;
                }
                break;
            case 41:
                answers = futurCompose[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "nous allons " + answers[i];
                }
                break;
            case 42:
                answers = futurCompose[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "vous allez " + answers[i];
                }
                break;
            case 43:
                verbs = futurCompose[5].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "ils vont " + verb;
                    answers[pos++] = "elles vont " + verb;
                }
                break;
            case 44:
                answers = conditionnelPresent[0].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "je " + answers[i];
                }
                break;
            case 45:
                answers = conditionnelPresent[1].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "tu " + answers[i];
                }
                break;
            case 46:
                verbs = conditionnelPresent[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "il " + verb;
                    answers[pos++] = "elle " + verb;
                    answers[pos++] = "on " + verb;
                }
                break;
            case 47:
                answers = conditionnelPresent[3].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "nous " + answers[i];
                }
                break;
            case 48:
                answers = conditionnelPresent[4].split(";");
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = "vous " + answers[i];
                }
                break;
            case 49:
                verbs = conditionnelPresent[5].split(";");
                answers = new String[verbs.length * 2];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "ils " + verb;
                    answers[pos++] = "elles " + verb;
                }
                break;
            case 50:
                answers = imperatifPresent[0].split(";");
                break;
            case 51:
                answers = imperatifPresent[1].split(";");
                break;
            case 52:
                answers = imperatifPresent[2].split(";");
                break;
            default:
                return "";
        }
        String s = "";
        for (String a : answers) {
            //noinspection HardcodedLineSeparator
            s += a + "\n";
        }
        return s;
    }

}
