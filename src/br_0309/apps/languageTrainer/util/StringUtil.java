package br_0309.apps.languageTrainer.util;

public class StringUtil {

    // VERY APPROXIMATE!!!!!
    private static final char[] DEF_VOWELS = "aeiouyäöüéèêàáâæAEIOUYÄÖÜÉÈÊÀÁÂÆ".toCharArray();

    public static boolean endsInVowel(String s) {
        for (char c : DEF_VOWELS) {
            if (s.charAt(s.length() - 1) == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVowel(char c) {
        for (char c1 : DEF_VOWELS) {
            if (c == c1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isConsonant(char c) {
        for (char c1 : DEF_VOWELS) {
            if (c == c1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOneSyllable(String word) {
        int i = 0;
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                i++;
            }
        }
        if (i == 1) {
            return true;
        }
        else if (i == 2) {
            if (word.contains("ie") || word.contains("ou") || word.contains("ee") || word.contains("oo")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTwoSyllable(String word) {
        int i = 0;
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                i++;
            }
        }
        return i == 2;
    }

}
