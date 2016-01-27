package br_0309.apps.languageTrainer.data;

import java.io.Serializable;
import java.util.Date;

// FIXME: Add total to prevent cheating the cheats
public class Statistics implements Serializable, Comparable<Statistics> {

    private static final long serialVersionUID = - 2484107990886936920L;
    public final String listName;
    public final boolean listType;
    public final String[] langCodes;
    public final Date date = new Date();
    public int correct = 0;
    public int incorrect = 0;
    public int cheated = 0;

    /**
     * @param listType true: translation. false: br_0309.apps.languageTrainer.verbs
     */
    public Statistics(String listName, boolean listType, String[] langCodes) {
        this.listName = listName;
        this.listType = listType;
        this.langCodes = langCodes;
    }

    @Override
    public int compareTo(Statistics o) {
        return date.compareTo(o.date);
    }
}
