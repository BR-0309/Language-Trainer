package br_0309.apps.languageTrainer.verbs;

interface Verb {

    boolean isCorrect(int number, String answer);
    String getQuestion(int number);
    String getAnswers(int number);

}
