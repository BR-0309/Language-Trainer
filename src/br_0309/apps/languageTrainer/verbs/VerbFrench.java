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
    public String[] conditionnelPasse1;
    public String[] conditionnelPasse2;
    public String[] imperatifPresent;
    public String[] imperatifPasse;
    public boolean isAvoir;

    public String getQuestion(int number) {
        return "ERROR";
    }

    @Override
    public String getAnswers(int number) {
        return "";
    }

    public boolean isCorrect(int number, String answer) {

        return false;
    }

}
