package br_0309.apps.languageTrainer.verbs;

import br_0309.apps.languageTrainer.util.StringUtil;

import java.io.Serializable;

public class VerbEnglish implements Serializable {

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
    public transient boolean warning = false;

    public VerbEnglish() {}

    public static VerbEnglish conjugate(String infinitive) {
        if (infinitive == null || infinitive.trim().equals("")) return EMPTY_VERB;
        // Participles
        String presentParticiple;
        String pastParticiple;
        boolean warning = false;
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
            warning = true;
        } else {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive + "ed";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.presentParticiple = presentParticiple;
        verb.pastParticiple = pastParticiple;
        verb.infinitive = infinitive;
        verb.warning = warning;
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
        boolean warning = false;
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
            warning = true;
        } else {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive + "ed";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.presentParticiple = presentParticiple;
        verb.pastParticiple = pastParticiple;
        verb.infinitive = infinitive;
        verb.warning = warning;
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
        boolean warning = false;
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
            warning = true;
        } else {
            presentParticiple = infinitive + "ing";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.presentParticiple = presentParticiple;
        verb.pastParticiple = pastParticiple;
        verb.infinitive = infinitive;
        verb.warning = warning;
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

    public static VerbEnglish conjugate(String infinitive, String pastParticiple, boolean needAnotherVar) {
        if (infinitive == null || infinitive.trim().equals("")) return EMPTY_VERB;
        if (pastParticiple == null || pastParticiple.trim().equals("")) return conjugate(infinitive);
        // Participles
        String presentParticiple;
        boolean warning = false;
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
            warning = true;
        } else {
            presentParticiple = infinitive + "ing";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.presentParticiple = presentParticiple;
        verb.pastParticiple = pastParticiple;
        verb.infinitive = infinitive;
        verb.warning = warning;
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

    public static VerbEnglish getEmptyInstance() {
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

}
