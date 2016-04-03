package br_0309.apps.languageTrainer.verbs;

import br_0309.apps.languageTrainer.util.StringUtil;

import java.io.Serializable;

public class VerbEnglish implements Serializable, Verb {

    public static transient final VerbEnglish EMPTY_VERB = getEmptyInstance();
    public String infinitive;
    public String presentParticiple;
    public String pastParticiple;
    public String[] presentSimple;
    public String[] presentContinuous;
    public String[] presentPerfect;
    public String[] presentPerfectContinuous;
    public String[] pastSimple;
    public String[] pastContinuous;
    public String[] pastPerfect;
    public String[] pastPerfectContinuous;
    public String[] future;
    public String[] futurePerfect;
    public String[] futureContinuous;
    public String[] futurePerfectContinuous;

    public VerbEnglish() {
    }

    public static VerbEnglish conjugate(String infinitive) {
        if (infinitive == null || infinitive.trim().equals("")) return EMPTY_VERB;
        // Participles
        String presentParticiple;
        String pastParticiple;
        if (infinitive.endsWith("y") && StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 2))) {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive.substring(0, infinitive.length() - 1) + "ied";
        } else if (infinitive.endsWith("e")) {
            presentParticiple = infinitive.substring(0, infinitive.length() - 1) + "ing";
            pastParticiple = infinitive + "d";
        } else if (infinitive.endsWith("w") || infinitive.endsWith("x") || infinitive.endsWith("z")) {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive + "ed";
        } else if (StringUtil.isOneSyllable(infinitive) && infinitive.length() > 2) {
            if (StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 3)) && StringUtil.isVowel(infinitive.charAt(infinitive.length() - 2)) &&
                StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 1))) {
                String s = infinitive + infinitive.charAt(infinitive.length() - 1);
                presentParticiple = s + "ing";
                pastParticiple = s + "ed";
            } else {
                presentParticiple = infinitive + "ing";
                pastParticiple = infinitive + "ed";
            }
        } else if (StringUtil.isTwoSyllable(infinitive)) {
            String s = infinitive + infinitive.charAt(infinitive.length() - 1);
            presentParticiple = s + "ing";
            pastParticiple = s + "ed";
        } else {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive + "ed";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.presentParticiple = presentParticiple;
        verb.pastParticiple = pastParticiple;
        verb.infinitive = infinitive;
        // Present tenses
        verb.presentContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                               presentParticiple};
        String thirdPersonSingular = infinitive;
        if (infinitive.endsWith("ss") || infinitive.endsWith("x") || infinitive.endsWith("ch") || infinitive.endsWith("sh") || infinitive.endsWith("o")) {
            thirdPersonSingular += "es";
        } else if (infinitive.endsWith("y")) {
            thirdPersonSingular = infinitive.substring(0, infinitive.length() - 2) + "ies";
        } else {
            thirdPersonSingular += "s";
        }
        verb.presentSimple = new String[] {infinitive, infinitive, thirdPersonSingular, infinitive, infinitive, infinitive};
        verb.presentPerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.presentPerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                      presentParticiple};
        // Future tenses
        verb.future = new String[] {infinitive, infinitive, infinitive, infinitive, infinitive, infinitive};
        verb.futureContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple};
        verb.futurePerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.futurePerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                     presentParticiple};
        // Past tenses
        verb.pastSimple = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.pastPerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.pastPerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                   presentParticiple};
        verb.pastContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple};
        return verb;
    }

    public static VerbEnglish conjugate(String infinitive, String pastSimpleI) {
        if (infinitive == null || infinitive.trim().equals("")) return EMPTY_VERB;
        if (pastSimpleI == null || pastSimpleI.trim().equals("")) return conjugate(infinitive);
        // Participles
        String presentParticiple;
        String pastParticiple;
        if (infinitive.endsWith("y") && StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 2))) {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive.substring(0, infinitive.length() - 1) + "ied";
        } else if (infinitive.endsWith("e")) {
            presentParticiple = infinitive.substring(0, infinitive.length() - 1) + "ing";
            pastParticiple = infinitive + "d";
        } else if (infinitive.endsWith("w") || infinitive.endsWith("x") || infinitive.endsWith("z")) {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive + "ed";
        } else if (StringUtil.isOneSyllable(infinitive) && infinitive.length() > 2) {
            if (StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 3)) && StringUtil.isVowel(infinitive.charAt(infinitive.length() - 2)) &&
                StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 1))) {
                String s = infinitive + infinitive.charAt(infinitive.length() - 1);
                presentParticiple = s + "ing";
                pastParticiple = s + "ed";
            } else {
                presentParticiple = infinitive + "ing";
                pastParticiple = infinitive + "ed";
            }
        } else if (StringUtil.isTwoSyllable(infinitive)) {
            String s = infinitive + infinitive.charAt(infinitive.length() - 1);
            presentParticiple = s + "ing";
            pastParticiple = s + "ed";
        } else {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive + "ed";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.presentParticiple = presentParticiple;
        verb.pastParticiple = pastParticiple;
        verb.infinitive = infinitive;
        // Present tenses
        verb.presentContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                               presentParticiple};
        String thirdPersonSingular = infinitive;
        if (infinitive.endsWith("ss") || infinitive.endsWith("x") || infinitive.endsWith("ch") || infinitive.endsWith("sh") || infinitive.endsWith("o")) {
            thirdPersonSingular += "es";
        } else if (infinitive.endsWith("y")) {
            thirdPersonSingular = infinitive.substring(0, infinitive.length() - 2) + "ies";
        } else {
            thirdPersonSingular += "s";
        }
        verb.presentSimple = new String[] {infinitive, infinitive, thirdPersonSingular, infinitive, infinitive, infinitive};
        verb.presentPerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.presentPerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                      presentParticiple};
        // Future tenses
        verb.future = new String[] {infinitive, infinitive, infinitive, infinitive, infinitive, infinitive};
        verb.futureContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple};
        verb.futurePerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.futurePerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                     presentParticiple};
        // Past tenses
        verb.pastSimple = new String[] {pastSimpleI, pastSimpleI, pastSimpleI, pastSimpleI, pastSimpleI, pastSimpleI};
        verb.pastPerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.pastPerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                   presentParticiple};
        verb.pastContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple};
        return verb;
    }

    public static VerbEnglish conjugate(String infinitive, String pastSimpleI, String pastParticiple) {
        if (infinitive == null || infinitive.trim().equals("")) return EMPTY_VERB;
        if (pastSimpleI == null || pastSimpleI.trim().equals("")) return conjugate(infinitive);
        // Participles
        String presentParticiple;
        if (infinitive.endsWith("y") && StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 2))) {
            presentParticiple = infinitive + "ing";
        } else if (infinitive.endsWith("e")) {
            presentParticiple = infinitive.substring(0, infinitive.length() - 1) + "ing";
        } else if (infinitive.endsWith("w") || infinitive.endsWith("x") || infinitive.endsWith("z")) {
            presentParticiple = infinitive + "ing";
        } else if (StringUtil.isOneSyllable(infinitive) && infinitive.length() > 2) {
            if (StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 3)) && StringUtil.isVowel(infinitive.charAt(infinitive.length() - 2)) &&
                StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 1))) {
                String s = infinitive + infinitive.charAt(infinitive.length() - 1);
                presentParticiple = s + "ing";
            } else {
                presentParticiple = infinitive + "ing";
            }
        } else if (StringUtil.isTwoSyllable(infinitive)) {
            String s = infinitive + infinitive.charAt(infinitive.length() - 1);
            presentParticiple = s + "ing";
        } else {
            presentParticiple = infinitive + "ing";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.presentParticiple = presentParticiple;
        verb.pastParticiple = pastParticiple;
        verb.infinitive = infinitive;
        // Present tenses
        verb.presentContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                               presentParticiple};
        String thirdPersonSingular = infinitive;
        if (infinitive.endsWith("ss") || infinitive.endsWith("x") || infinitive.endsWith("ch") || infinitive.endsWith("sh") || infinitive.endsWith("o")) {
            thirdPersonSingular += "es";
        } else if (infinitive.endsWith("y")) {
            thirdPersonSingular = infinitive.substring(0, infinitive.length() - 2) + "ies";
        } else {
            thirdPersonSingular += "s";
        }
        verb.presentSimple = new String[] {infinitive, infinitive, thirdPersonSingular, infinitive, infinitive, infinitive};
        verb.presentPerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.presentPerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                      presentParticiple};
        // Future tenses
        verb.future = new String[] {infinitive, infinitive, infinitive, infinitive, infinitive, infinitive};
        verb.futureContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple};
        verb.futurePerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.futurePerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                     presentParticiple};
        // Past tenses
        verb.pastSimple = new String[] {pastSimpleI, pastSimpleI, pastSimpleI, pastSimpleI, pastSimpleI, pastSimpleI};
        verb.pastPerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.pastPerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                   presentParticiple};
        verb.pastContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple};
        return verb;
    }

    public static VerbEnglish conjugate(String infinitive, String pastParticiple, @SuppressWarnings("UnusedParameters") boolean needAnotherVar) {
        if (infinitive == null || infinitive.trim().equals("")) return EMPTY_VERB;
        if (pastParticiple == null || pastParticiple.trim().equals("")) return conjugate(infinitive);
        // Participles
        String presentParticiple;
        if (infinitive.endsWith("y") && StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 2))) {
            presentParticiple = infinitive + "ing";
        } else if (infinitive.endsWith("e")) {
            presentParticiple = infinitive.substring(0, infinitive.length() - 1) + "ing";
        } else if (infinitive.endsWith("w") || infinitive.endsWith("x") || infinitive.endsWith("z")) {
            presentParticiple = infinitive + "ing";
        } else if (StringUtil.isOneSyllable(infinitive) && infinitive.length() > 2) {
            if (StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 3)) && StringUtil.isVowel(infinitive.charAt(infinitive.length() - 2)) &&
                StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 1))) {
                String s = infinitive + infinitive.charAt(infinitive.length() - 1);
                presentParticiple = s + "ing";
            } else {
                presentParticiple = infinitive + "ing";
            }
        } else if (StringUtil.isTwoSyllable(infinitive)) {
            String s = infinitive + infinitive.charAt(infinitive.length() - 1);
            presentParticiple = s + "ing";
        } else {
            presentParticiple = infinitive + "ing";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.presentParticiple = presentParticiple;
        verb.pastParticiple = pastParticiple;
        verb.infinitive = infinitive;
        // Present tenses
        verb.presentContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                               presentParticiple};
        String thirdPersonSingular = infinitive;
        if (infinitive.endsWith("ss") || infinitive.endsWith("x") || infinitive.endsWith("ch") || infinitive.endsWith("sh") || infinitive.endsWith("o")) {
            thirdPersonSingular += "es";
        } else if (infinitive.endsWith("y")) {
            thirdPersonSingular = infinitive.substring(0, infinitive.length() - 2) + "ies";
        } else {
            thirdPersonSingular += "s";
        }
        verb.presentSimple = new String[] {infinitive, infinitive, thirdPersonSingular, infinitive, infinitive, infinitive};
        verb.presentPerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.presentPerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                      presentParticiple};
        // Future tenses
        verb.future = new String[] {infinitive, infinitive, infinitive, infinitive, infinitive, infinitive};
        verb.futureContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple};
        verb.futurePerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.futurePerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                     presentParticiple};
        // Past tenses
        verb.pastSimple = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.pastPerfect = new String[] {pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple, pastParticiple};
        verb.pastPerfectContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple,
                                                   presentParticiple};
        verb.pastContinuous = new String[] {presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple, presentParticiple};
        return verb;
    }

    private static VerbEnglish getEmptyInstance() {
        VerbEnglish verb = new VerbEnglish();
        verb.presentSimple = new String[6];
        verb.presentPerfect = new String[6];
        verb.presentContinuous = new String[6];
        verb.presentPerfectContinuous = new String[6];
        verb.pastSimple = new String[6];
        verb.pastPerfect = new String[6];
        verb.pastContinuous = new String[6];
        verb.pastPerfectContinuous = new String[6];
        verb.future = new String[6];
        verb.futurePerfect = new String[6];
        verb.futureContinuous = new String[6];
        verb.futurePerfectContinuous = new String[6];
        return verb;
    }

    @SuppressWarnings("HardcodedFileSeparator")
    public String getQuestion(int number) {
        switch (number) {
            case 0:
                return infinitive + ": present participle";
            case 1:
                return infinitive + ": past participle";
            case 2:
                return infinitive + ": present simple I";
            case 3:
                return infinitive + ": present simple you";
            case 4:
                return infinitive + ": present simple he/she/it";
            case 5:
                return infinitive + ": present simple we";
            case 6:
                return infinitive + ": present simple you plural";
            case 7:
                return infinitive + ": present simple they";
            case 8:
                return infinitive + ": present continuous I";
            case 9:
                return infinitive + ": present continuous you";
            case 10:
                return infinitive + ": present continuous he/she/it";
            case 11:
                return infinitive + ": present continuous we";
            case 12:
                return infinitive + ": present continuous you plural";
            case 13:
                return infinitive + ": present continuous they";
            case 14:
                return infinitive + ": present perfect I";
            case 15:
                return infinitive + ": present perfect you";
            case 16:
                return infinitive + ": present perfect he/she/it";
            case 17:
                return infinitive + ": present perfect we";
            case 18:
                return infinitive + ": present perfect you plural";
            case 19:
                return infinitive + ": present perfect they";
            case 20:
                return infinitive + ": present perfect continuous I";
            case 21:
                return infinitive + ": present perfect continuous you";
            case 22:
                return infinitive + ": present perfect continuous he/she/it";
            case 23:
                return infinitive + ": present perfect continuous we";
            case 24:
                return infinitive + ": present perfect continuous you plural";
            case 25:
                return infinitive + ": present perfect continuous they";
            case 26:
                return infinitive + ": past simple I";
            case 27:
                return infinitive + ": past simple you";
            case 28:
                return infinitive + ": past simple he/she/it";
            case 29:
                return infinitive + ": past simple we";
            case 30:
                return infinitive + ": past simple you plural";
            case 31:
                return infinitive + ": past simple they";
            case 32:
                return infinitive + ": past continuous I";
            case 33:
                return infinitive + ": past continuous you";
            case 34:
                return infinitive + ": past continuous he/she/it";
            case 35:
                return infinitive + ": past continuous we";
            case 36:
                return infinitive + ": past continuous you plural";
            case 37:
                return infinitive + ": past continuous they";
            case 38:
                return infinitive + ": past perfect I";
            case 39:
                return infinitive + ": past perfect you";
            case 40:
                return infinitive + ": past perfect he/she/it";
            case 41:
                return infinitive + ": past perfect we";
            case 42:
                return infinitive + ": past perfect you plural";
            case 43:
                return infinitive + ": past perfect they";
            case 44:
                return infinitive + ": past perfect continuous I";
            case 45:
                return infinitive + ": past perfect continuous you";
            case 46:
                return infinitive + ": past perfect continuous he/she/it";
            case 47:
                return infinitive + ": past perfect continuous we";
            case 48:
                return infinitive + ": past perfect continuous you plural";
            case 49:
                return infinitive + ": past perfect continuous they";
            case 50:
                return infinitive + ": future I";
            case 51:
                return infinitive + ": future you";
            case 52:
                return infinitive + ": future he/she/it";
            case 53:
                return infinitive + ": future we";
            case 54:
                return infinitive + ": future you plural";
            case 55:
                return infinitive + ": future they";
            case 56:
                return infinitive + ": future perfect I";
            case 57:
                return infinitive + ": future perfect you";
            case 58:
                return infinitive + ": future perfect he/she/it";
            case 59:
                return infinitive + ": future perfect we";
            case 60:
                return infinitive + ": future perfect you plural";
            case 61:
                return infinitive + ": future perfect they";
            case 62:
                return infinitive + ": future continuous I";
            case 63:
                return infinitive + ": future continuous you";
            case 64:
                return infinitive + ": future continuous he/she/it";
            case 65:
                return infinitive + ": future continuous we";
            case 66:
                return infinitive + ": future continuous you plural";
            case 67:
                return infinitive + ": future continuous they";
            case 68:
                return infinitive + ": future perfect continuous I";
            case 69:
                return infinitive + ": future perfect continuous you";
            case 70:
                return infinitive + ": future perfect continuous he/she/it";
            case 71:
                return infinitive + ": future perfect continuous we";
            case 72:
                return infinitive + ": future perfect continuous you plural";
            case 73:
                return infinitive + ": future perfect continuous they";
            default:
                System.err.println("Invalid question number: " + number);
                return "ERROR";
        }
    }

    public boolean isCorrect(int number, String answer) {
        String[] verbs;
        String[] answers;
        int pos;
        switch (number) {
            case 0:
                return equalsAny(presentParticiple.split(";"), answer);
            case 1:
                return equalsAny(pastParticiple.split(";"), answer);
            case 2:
                verbs = presentSimple[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 3:
                verbs = presentSimple[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 4:
                verbs = presentSimple[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he " + verb;
                    answers[pos++] = "she " + verb;
                    answers[pos++] = "it " + verb;
                }
                return equalsAny(answers, answer);
            case 5:
                verbs = presentSimple[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 6:
                verbs = presentSimple[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 7:
                verbs = presentSimple[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 8:
                verbs = presentContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I am " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 9:
                verbs = presentContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you are " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 10:
                verbs = presentContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he is " + verb;
                    answers[pos++] = "she is " + verb;
                    answers[pos++] = "it is " + verb;
                }
                return equalsAny(answers, answer);
            case 11:
                verbs = presentContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we are " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 12:
                verbs = presentContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you are " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 13:
                verbs = presentContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they are " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 14:
                verbs = presentPerfect[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 15:
                verbs = presentPerfect[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 16:
                verbs = presentPerfect[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he has " + verb;
                    answers[pos++] = "she has " + verb;
                    answers[pos++] = "it has " + verb;
                }
                return equalsAny(answers, answer);
            case 17:
                verbs = presentPerfect[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 18:
                verbs = presentPerfect[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 19:
                verbs = presentPerfect[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 20:
                verbs = presentPerfectContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 21:
                verbs = presentPerfectContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 22:
                verbs = presentPerfectContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he has been" + verb;
                    answers[pos++] = "she has been " + verb;
                    answers[pos++] = "it has been " + verb;
                }
                return equalsAny(answers, answer);
            case 23:
                verbs = presentPerfectContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 24:
                verbs = presentPerfectContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 25:
                verbs = presentPerfectContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 26:
                verbs = pastSimple[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 27:
                verbs = pastSimple[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 28:
                verbs = pastSimple[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he " + verb;
                    answers[pos++] = "she " + verb;
                    answers[pos++] = "it " + verb;
                }
                return equalsAny(answers, answer);
            case 29:
                verbs = pastSimple[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 30:
                verbs = pastSimple[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 31:
                verbs = pastSimple[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 32:
                verbs = pastContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I was " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 33:
                verbs = pastContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you were " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 34:
                verbs = pastContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he was " + verb;
                    answers[pos++] = "she was " + verb;
                    answers[pos++] = "it was " + verb;
                }
                return equalsAny(answers, answer);
            case 35:
                verbs = pastContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we were " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 36:
                verbs = pastContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you were " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 37:
                verbs = pastContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they were " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 38:
                verbs = pastPerfect[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I had " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 39:
                verbs = pastPerfect[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you had " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 40:
                verbs = pastPerfect[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he had " + verb;
                    answers[pos++] = "she had " + verb;
                    answers[pos++] = "it had " + verb;
                }
                return equalsAny(answers, answer);
            case 41:
                verbs = pastPerfect[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we had " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 42:
                verbs = pastPerfect[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you had " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 43:
                verbs = pastPerfect[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they had " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 44:
                verbs = pastPerfectContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I had been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 45:
                verbs = pastPerfectContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you had been  " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 46:
                verbs = pastPerfectContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he had been " + verb;
                    answers[pos++] = "she had been " + verb;
                    answers[pos++] = "it had been " + verb;
                }
                return equalsAny(answers, answer);
            case 47:
                verbs = pastPerfectContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we had been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 48:
                verbs = pastPerfectContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you had been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 49:
                verbs = pastPerfectContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they had been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 50:
                verbs = future[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I will " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 51:
                verbs = future[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 52:
                verbs = future[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he will " + verb;
                    answers[pos++] = "she will " + verb;
                    answers[pos++] = "it will " + verb;
                }
                return equalsAny(answers, answer);
            case 53:
                verbs = future[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we will " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 54:
                verbs = future[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 55:
                verbs = future[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they will " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 56:
                verbs = futurePerfect[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I will have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 57:
                verbs = futurePerfect[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 58:
                verbs = futurePerfect[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he will have " + verb;
                    answers[pos++] = "she will have " + verb;
                    answers[pos++] = "it will have " + verb;
                }
                return equalsAny(answers, answer);
            case 59:
                verbs = futurePerfect[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we will have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 60:
                verbs = futurePerfect[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 61:
                verbs = futurePerfect[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they will have " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 62:
                verbs = futureContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I will be " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 63:
                verbs = futureContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will be " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 64:
                verbs = futureContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he will be " + verb;
                    answers[pos++] = "she will be " + verb;
                    answers[pos++] = "it will be " + verb;
                }
                return equalsAny(answers, answer);
            case 65:
                verbs = futureContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we will be " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 66:
                verbs = futureContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will be " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 67:
                verbs = futureContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they will be " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 68:
                verbs = futurePerfectContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I will have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 69:
                verbs = futurePerfectContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 70:
                verbs = futurePerfectContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he will have been " + verb;
                    answers[pos++] = "she will have been " + verb;
                    answers[pos++] = "it will have been " + verb;
                }
                return equalsAny(answers, answer);
            case 71:
                verbs = futurePerfectContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we will have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 72:
                verbs = futurePerfectContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            case 73:
                verbs = futurePerfectContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they will have been " + verbs[i];
                }
                return equalsAny(answers, answer);
            default:
                System.err.println("Invalid question number: " + number);
                return false;
        }
    }

    public String getAnswers(int number) {
        String[] verbs;
        String[] answers;
        int pos;
        switch (number) {
            case 0:
                answers = presentParticiple.split(";");
                break;
            case 1:
                answers = pastParticiple.split(";");
                break;
            case 2:
                verbs = presentSimple[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I " + verbs[i];
                }
                break;
            case 3:
                verbs = presentSimple[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you " + verbs[i];
                }
                break;
            case 4:
                verbs = presentSimple[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he " + verb;
                    answers[pos++] = "she " + verb;
                    answers[pos++] = "it " + verb;
                }
                break;
            case 5:
                verbs = presentSimple[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we " + verbs[i];
                }
                break;
            case 6:
                verbs = presentSimple[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you " + verbs[i];
                }
                break;
            case 7:
                verbs = presentSimple[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they " + verbs[i];
                }
                break;
            case 8:
                verbs = presentContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I am " + verbs[i];
                }
                break;
            case 9:
                verbs = presentContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you are " + verbs[i];
                }
                break;
            case 10:
                verbs = presentContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he is " + verb;
                    answers[pos++] = "she is " + verb;
                    answers[pos++] = "it is " + verb;
                }
                break;
            case 11:
                verbs = presentContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we are " + verbs[i];
                }
                break;
            case 12:
                verbs = presentContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you are " + verbs[i];
                }
                break;
            case 13:
                verbs = presentContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they are " + verbs[i];
                }
                break;
            case 14:
                verbs = presentPerfect[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I have " + verbs[i];
                }
                break;
            case 15:
                verbs = presentPerfect[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you have " + verbs[i];
                }
                break;
            case 16:
                verbs = presentPerfect[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he has " + verb;
                    answers[pos++] = "she has " + verb;
                    answers[pos++] = "it has " + verb;
                }
                break;
            case 17:
                verbs = presentPerfect[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we have " + verbs[i];
                }
                break;
            case 18:
                verbs = presentPerfect[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you have " + verbs[i];
                }
                break;
            case 19:
                verbs = presentPerfect[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they have " + verbs[i];
                }
                break;
            case 20:
                verbs = presentPerfectContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I have been " + verbs[i];
                }
                break;
            case 21:
                verbs = presentPerfectContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you have been " + verbs[i];
                }
                break;
            case 22:
                verbs = presentPerfectContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he has been" + verb;
                    answers[pos++] = "she has been " + verb;
                    answers[pos++] = "it has been " + verb;
                }
                break;
            case 23:
                verbs = presentPerfectContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we have been " + verbs[i];
                }
                break;
            case 24:
                verbs = presentPerfectContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you have been " + verbs[i];
                }
                break;
            case 25:
                verbs = presentPerfectContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they have been " + verbs[i];
                }
                break;
            case 26:
                verbs = pastSimple[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I " + verbs[i];
                }
                break;
            case 27:
                verbs = pastSimple[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you " + verbs[i];
                }
                break;
            case 28:
                verbs = pastSimple[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he " + verb;
                    answers[pos++] = "she " + verb;
                    answers[pos++] = "it " + verb;
                }
                break;
            case 29:
                verbs = pastSimple[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we " + verbs[i];
                }
                break;
            case 30:
                verbs = pastSimple[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you " + verbs[i];
                }
                break;
            case 31:
                verbs = pastSimple[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they " + verbs[i];
                }
                break;
            case 32:
                verbs = pastContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I was " + verbs[i];
                }
                break;
            case 33:
                verbs = pastContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you were " + verbs[i];
                }
                break;
            case 34:
                verbs = pastContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he was " + verb;
                    answers[pos++] = "she was " + verb;
                    answers[pos++] = "it was " + verb;
                }
                break;
            case 35:
                verbs = pastContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we were " + verbs[i];
                }
                break;
            case 36:
                verbs = pastContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you were " + verbs[i];
                }
                break;
            case 37:
                verbs = pastContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they were " + verbs[i];
                }
                break;
            case 38:
                verbs = pastPerfect[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I had " + verbs[i];
                }
                break;
            case 39:
                verbs = pastPerfect[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you had " + verbs[i];
                }
                break;
            case 40:
                verbs = pastPerfect[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he had " + verb;
                    answers[pos++] = "she had " + verb;
                    answers[pos++] = "it had " + verb;
                }
                break;
            case 41:
                verbs = pastPerfect[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we had " + verbs[i];
                }
                break;
            case 42:
                verbs = pastPerfect[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you had " + verbs[i];
                }
                break;
            case 43:
                verbs = pastPerfect[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they had " + verbs[i];
                }
                break;
            case 44:
                verbs = pastPerfectContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I had been " + verbs[i];
                }
                break;
            case 45:
                verbs = pastPerfectContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you had been " + verbs[i];
                }
                break;
            case 46:
                verbs = pastPerfectContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he had been " + verb;
                    answers[pos++] = "she had been " + verb;
                    answers[pos++] = "it had been " + verb;
                }
                break;
            case 47:
                verbs = pastPerfectContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we had been " + verbs[i];
                }
                break;
            case 48:
                verbs = pastPerfectContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you had been " + verbs[i];
                }
                break;
            case 49:
                verbs = pastPerfectContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they had been " + verbs[i];
                }
                break;
            case 50:
                verbs = future[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I will " + verbs[i];
                }
                break;
            case 51:
                verbs = future[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will " + verbs[i];
                }
                break;
            case 52:
                verbs = future[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he will " + verb;
                    answers[pos++] = "she will " + verb;
                    answers[pos++] = "it will " + verb;
                }
                break;
            case 53:
                verbs = future[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we will " + verbs[i];
                }
                break;
            case 54:
                verbs = future[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will " + verbs[i];
                }
                break;
            case 55:
                verbs = future[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they will " + verbs[i];
                }
                break;
            case 56:
                verbs = futurePerfect[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I will have " + verbs[i];
                }
                break;
            case 57:
                verbs = futurePerfect[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will have " + verbs[i];
                }
                break;
            case 58:
                verbs = futurePerfect[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he will have " + verb;
                    answers[pos++] = "she will have " + verb;
                    answers[pos++] = "it will have " + verb;
                }
                break;
            case 59:
                verbs = futurePerfect[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we will have " + verbs[i];
                }
                break;
            case 60:
                verbs = futurePerfect[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will have " + verbs[i];
                }
                break;
            case 61:
                verbs = futurePerfect[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they will have " + verbs[i];
                }
                break;
            case 62:
                verbs = futureContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I will be " + verbs[i];
                }
                break;
            case 63:
                verbs = futureContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will be " + verbs[i];
                }
                break;
            case 64:
                verbs = futureContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he will be " + verb;
                    answers[pos++] = "she will be " + verb;
                    answers[pos++] = "it will be " + verb;
                }
                break;
            case 65:
                verbs = futureContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we will be " + verbs[i];
                }
                break;
            case 66:
                verbs = futureContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will be " + verbs[i];
                }
                break;
            case 67:
                verbs = futureContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they will be " + verbs[i];
                }
                break;
            case 68:
                verbs = futurePerfectContinuous[0].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "I will have been " + verbs[i];
                }
                break;
            case 69:
                verbs = futurePerfectContinuous[1].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will have been " + verbs[i];
                }
                break;
            case 70:
                verbs = futurePerfectContinuous[2].split(";");
                answers = new String[verbs.length * 3];
                pos = 0;
                for (String verb : verbs) {
                    answers[pos++] = "he will have been " + verb;
                    answers[pos++] = "she will have been " + verb;
                    answers[pos++] = "it will have been " + verb;
                }
                break;
            case 71:
                verbs = futurePerfectContinuous[3].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "we will have been " + verbs[i];
                }
                break;
            case 72:
                verbs = futurePerfectContinuous[4].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "you will have been " + verbs[i];
                }
                break;
            case 73:
                verbs = futurePerfectContinuous[5].split(";");
                answers = new String[verbs.length];
                for (int i = 0; i < verbs.length; i++) {
                    answers[i] = "they will have been " + verbs[i];
                }
                break;
            default:
                System.err.println("Invalid question number: " + number);
                return "";
        }
        String s = "";
        for(String a : answers){
            //noinspection HardcodedLineSeparator
            s += a + "\n";
        }
        return s;
    }
    private boolean equalsAny(String[] answers, String answer) {
        for (String s : answers) {
            if (s.trim().equals(answer.trim())) return true;
        }
        return false;
    }

}
