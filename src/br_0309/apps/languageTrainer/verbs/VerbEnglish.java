package br_0309.apps.languageTrainer.verbs;

import br_0309.apps.languageTrainer.util.StringUtil;

import java.io.Serializable;

public class VerbEnglish implements Serializable {

    public String infinitive;

    public String[] presntSimple;
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
        if (infinitive.trim().equals("")) return null;
        // Present participle
        String presentParticiple;
        String pastParticiple;
        if (infinitive.endsWith("y") && StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 1))) {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive.substring(0, infinitive.length() - 2) + "ied";
        }
        else if (infinitive.endsWith("e")) {
            presentParticiple = infinitive.substring(0, infinitive.length() - 2) + "ing";
            pastParticiple = infinitive + "d";
        }
        else if (infinitive.endsWith("w") || infinitive.endsWith("x") || infinitive.endsWith("z")) {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive + "ed";
        }
        else if (StringUtil.isOneSyllable(infinitive)) {
            if (StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 4)) && StringUtil.isVowel(infinitive.charAt(infinitive.length() - 3)) &&
                    StringUtil.isConsonant(infinitive.charAt(infinitive.length() - 2))) {

            }
            else {
                presentParticiple = infinitive + "ing";
                pastParticiple = infinitive + "ed";
            }
        }
        else if (StringUtil.isTwoSyllable(infinitive)) {

        }
        else {
            presentParticiple = infinitive + "ing";
            pastParticiple = infinitive + "ed";
        }

        VerbEnglish verb = new VerbEnglish();
        verb.infinitive = infinitive;
        verb.presentContinuous = new String[]{"am " + presentParticiple, "are " + presentParticiple, "is " + presentParticiple, "are " + presentParticiple,
                                              "are " + presentParticiple, "are " + presentParticiple};
        return null;
    }

    public static VerbEnglish conjugate(String infinitive, String pastSimpleI) {
        return null;
    }

    public static VerbEnglish conjugate(String infinitive, String pastSimpleI, String pastParticiple) {
        return null;
    }

}
