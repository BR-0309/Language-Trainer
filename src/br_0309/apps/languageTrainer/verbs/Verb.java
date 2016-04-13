package br_0309.apps.languageTrainer.verbs;

import java.io.Serializable;
import java.util.Locale;

public abstract class Verb implements Serializable {

    public abstract boolean isCorrect(int number, String answer);

    public abstract String getQuestion(int number);

    public abstract String getAnswers(int number);

    public abstract String getInfinitive();

    public abstract String getList();

    public abstract void setList(String list);

    public abstract Locale getLocale();

    public abstract int getMaxValue();

}
