package br_0309.apps.languageTrainer.verbs;

import java.io.Serializable;

public abstract class Verb implements Serializable {

    public abstract boolean isCorrect(int number, String answer);

    public abstract String getQuestion(int number);

    public abstract String getAnswers(int number);

    public abstract String getInfinitive();

}
