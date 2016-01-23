package br_0309.apps.languageTrainer.data;

import java.util.HashMap;

public class VocabularyListData {

    private final HashMap<String, String> map = new HashMap<>();

    public String get(String key) {
        String s = map.get(key); if (s == null) { return ""; } else return s;
    }

    public void set(String key, String value) {
        map.put(key, value);
    }
}
