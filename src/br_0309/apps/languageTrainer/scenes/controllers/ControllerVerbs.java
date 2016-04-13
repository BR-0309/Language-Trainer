package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.data.ExerciseData;
import br_0309.apps.languageTrainer.data.Statistics;
import br_0309.apps.languageTrainer.util.FXUtil;
import br_0309.apps.languageTrainer.verbs.Verb;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerVerbs implements Initializable, IController {

    private final ArrayList<Verb> verbs = new ArrayList<>();
    private final ArrayList<String> wrong = new ArrayList<>();
    private final ArrayList<Statistics> statistics = new ArrayList<>();
    private final Random random = new Random();
    public Label lblCorrect;
    public Label lblIncorrect;
    public Label lblProgress;
    public Label lblList;
    public ProgressBar progressBar;
    public Button btnNext;
    public Button btnExit;
    public Label lblLanguage;
    public Label lblIcon;
    public Label lblTask;
    public TextField txtAnswer;
    public Button btnCheat;
    private ResourceBundle BUNDLE;
    private int correct = 0;
    private int incorrect = 0;
    private int cheated = 0;
    private int pos = 0;
    private int length = 10;
    private int q;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BUNDLE = resources;
        btnExit.setOnAction(value -> {
            if (FXUtil.showConfirmationDialog(resources.getString("generic.confirm"), resources.getString("generic.confirmQuit"), "",
                                              resources.getString("generic.ok"), resources.getString("generic.cancel"))) {
                LanguageTrainer.showMenu();
            }
        });
        btnCheat.setPadding(Insets.EMPTY);
    }

    // FIXME NOTE TO SELF CURRENTLY TESTING VERBS WITH FRENCH VERBS THAT APPEAR TO BE BEYOND BROKEN
    public void onNext() {
        String answer = txtAnswer.getText().trim().replace("  ", " "); Verb verb = verbs.get(0); if (verbs.get(0).isCorrect(q, answer)) {
            LanguageTrainer.playSoundCorrect(); if (! wrong.contains(verb.getQuestion(q))) {
                correct++; pos++; for (Statistics stat : statistics) {
                    if (stat.listName.equals(verb.getList()) && stat.langCodes[0].equals(verb.getLocale().getLanguage())) {
                        stat.correct++; break;
                    }
                }
            } else {
                wrong.remove(verb.getQuestion(q));
            }
        } else {
            LanguageTrainer.playSoundIncorrect(); if (! wrong.contains(verb.getQuestion(q))) {
                incorrect++; for (Statistics stat : statistics) {
                    if (stat.listName.equals(verb.getList()) && stat.langCodes[0].equals(verb.getLocale().getLanguage())) {
                        stat.incorrect++; break;
                    }
                }
            } else {
                wrong.add(verb.getQuestion(q));
            }
        } if (pos >= length) {
            LanguageTrainer.playSoundFinished(); MessageFormat format = new MessageFormat(""); format.applyPattern(BUNDLE.getString("exercise.finishedMsg"));
            double[] answersCorrect = {1, 2}; String[] answersCorrectStrings = {BUNDLE.getString("exercise.answer"), BUNDLE.getString("exercise.answers")};
            ChoiceFormat formatAnswer = new ChoiceFormat(answersCorrect, answersCorrectStrings); double[] times = {0, 1, 2};
            String[] timesStrings = {BUNDLE.getString("exercise.times"), BUNDLE.getString("exercise.time"), BUNDLE.getString("exercise.times")};
            Format[] formats = {NumberFormat.getInstance(), formatAnswer, NumberFormat.getInstance(), formatAnswer, NumberFormat.getInstance(),
                                new ChoiceFormat(times, timesStrings)}; format.setFormats(formats); String msg = format.format(
                    new Object[] {correct, correct, incorrect, incorrect, cheated, cheated}); FXUtil.showInformationDialog(
                    BUNDLE.getString("exercise.finishedHeader"), msg); LanguageTrainer.showMenu();
        } else {
            Collections.shuffle(verbs, random);
        } updateUI();
    }

    public void onCheat() {
        Verb verb = verbs.get(0); if (! wrong.contains(verb.getQuestion(q))) {
            wrong.add(verb.getQuestion(q)); cheated++; for (Statistics stat : statistics) {
                if (stat.listName.equals(verb.getList()) && stat.langCodes[0].equals(verb.getLocale().getLanguage())) {
                    stat.cheated++; break;
                }
            }
        } String[] answers = verb.getAnswers(q).split(";"); String answer = ""; for (String s : answers) {
            answer += s + System.lineSeparator();
        } FXUtil.showInformationDialog(BUNDLE.getString("exercise.solution"), BUNDLE.getString("exercise.solutions"), answer);
    }

    private void updateUI() {
        Verb verb = verbs.get(0); q = random.nextInt(verb.getMaxValue()); progressBar.setProgress((double) pos / length);
        //noinspection HardcodedFileSeparator
        lblProgress.setText(pos + "/ " + length + " " +
                            new Double(progressBar.getProgress() * 100).intValue() + "%"); lblLanguage.setText(verb.getLocale().getDisplayLanguage());
        lblIcon.setGraphic(new ImageView(LanguageHandler.getFlag(verb.getLocale()))); txtAnswer.setText(""); lblCorrect.setText(Integer.toString(correct));
        lblIncorrect.setText(Integer.toString(incorrect)); lblList.setText(verb.getList()); lblTask.setText(verb.getQuestion(q));
    }

    public void init(ArrayList<ExerciseData> selected) {
        for (ExerciseData data : selected) {
            String listName = data.getTitle(); ObjectInputStream in = null; try {
                in = new ObjectInputStream(new FileInputStream(data.file)); String language = in.readUTF(); if (language == null || language.isEmpty()) {
                    Toolkit.getDefaultToolkit().beep(); FXUtil.showErrorDialog("", ""); return;
                } int langInt; try {
                    langInt = Integer.parseInt(language);
                } catch (NumberFormatException e) {
                    Toolkit.getDefaultToolkit().beep(); FXUtil.showErrorDialog("Invalid file format", language); continue;
                } Object obj = in.readObject(); if (obj instanceof ArrayList) {
                    @SuppressWarnings("unchecked") ArrayList<Verb> l = (ArrayList<Verb>) obj; statistics.add(
                            new Statistics(listName, false, new String[] {Reference.VERB_LOCALES[langInt].getLanguage()}, l.size())); for (Verb v : l) {
                        v.setList(listName); verbs.add(v);
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep(); FXUtil.showErrorDialog("Invalid file format", "Can't find array");
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } length = length * statistics.size(); updateUI();
    }

    @Override
    public void onExit() {
        LanguageTrainer.userData.putStats(statistics);
    }

    @Override
    public void onInsert(char c) {
        txtAnswer.setText(txtAnswer.getText() + c);
    }
}
