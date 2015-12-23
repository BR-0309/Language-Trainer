package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.data.ExerciseData;
import br_0309.apps.languageTrainer.data.Statistics;
import br_0309.apps.languageTrainer.data.VocabularyData;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.*;

public class ControllerTranslate implements Initializable, IController {

    private final ArrayList<VocabularyData> words = new ArrayList<>();
    private final ArrayList<ExerciseData> rest = new ArrayList<>();
    private final ArrayList<Statistics> stats = new ArrayList<>();
    private final ArrayList<VocabularyData> wrong = new ArrayList<>();
    @FXML
    public Label lblCorrect;
    @FXML
    public Label lblIncorrect;
    @FXML
    public Label lblProgress;
    @FXML
    public Label lblList;
    @FXML
    public ProgressBar progressBar;
    @FXML
    public Button btnNext;
    @FXML
    public Button btnExit;
    @FXML
    public Label lblTitle;
    @FXML
    public Label lblTask;
    @FXML
    public TextField txtAnswer;
    @FXML
    public Button btnCheat;
    private ResourceBundle BUNDLE;
    private int correct;
    private int incorrect;
    private int cheated = 0;
    private int length;
    private int solvedCorrectly = 0;

    @Override
    public void initialize(URL arg0, ResourceBundle bundle) {
        BUNDLE = bundle;
        btnExit.setOnAction(value -> {
            if (FXUtil.showConfirmationDialog(bundle.getString("generic.confirm"),
                                              bundle.getString("generic.confirmQuit"), "",
                                              bundle.getString("generic.ok"),
                                              bundle.getString("generic.cancel"))) {
                LanguageTrainer.showMenu();
            }
        });
        btnCheat.setPadding(Insets.EMPTY);
    }

    public void onNext() {
        // Copy current word into variable to reduce calls
        VocabularyData word = words.get(0);
        if (word.isCorrect(txtAnswer.getText().trim())) {
            LanguageTrainer.playSoundCorrect();
            // Shown on the progress bar
            solvedCorrectly++;
            // If solved correctly on first try
            if (!wrong.contains(word)) {
                correct++;
                for (Statistics stat : stats) {
                    if (stat.listName.equals(word.list) && Arrays.equals(stat.langCodes, word.langs)) {
                        stat.correct++;
                        break;
                    }
                }
            }
            words.remove(0);
        } else {
            LanguageTrainer.playSoundIncorrect();
            // If the word is wrong for the first time
            if (!wrong.contains(word)) {
                incorrect++;
                wrong.add(word);
                // Look for relevant statistic and increase the statistic
                for (Statistics stat : stats) {
                    if (stat.listName.equals(word.list) && Arrays.equals(stat.langCodes, word.langs)) {
                        stat.incorrect++;
                        break;
                    }
                }
            } else {
                // FIXME: Add something here
            }
        }
        if (words.isEmpty()) {
            if (rest.isEmpty()) {
                LanguageTrainer.playSoundFinished();

                MessageFormat format = new MessageFormat("");
                format.applyPattern(BUNDLE.getString("exercise.finishedMsg"));
                double[] answersCorrect = {1, 2};
                String[] answersCorrectStrings = {BUNDLE.getString("exercise.answer"),
                                                  BUNDLE.getString("exercise.answers")};
                ChoiceFormat formatAnswer = new ChoiceFormat(answersCorrect, answersCorrectStrings);
                double[] times = {0, 1, 2};
                String[] timesStrings = {BUNDLE.getString("exercise.times"), BUNDLE.getString("exercise.time"),
                                         BUNDLE.getString("exercise.times")};
                Format[] formats =
                        {NumberFormat.getInstance(), formatAnswer, NumberFormat.getInstance(), formatAnswer,
                         NumberFormat.getInstance(),
                         new ChoiceFormat(times, timesStrings)};
                format.setFormats(formats);
                String msg = format.format(new Object[]{correct, correct, incorrect, incorrect, cheated, cheated});
                FXUtil.showInformationDialog(BUNDLE.getString("exercise.finishedHeader"), msg);
                LanguageTrainer.showMenu();
                return;
            } else {
                // FIXME: Show verbs
            }
            return;
        } else {
            Collections.shuffle(words, LanguageTrainer.random);
        }
        VocabularyData d = words.get(0);
        lblTitle.setText(
                BUNDLE.getString("translate.task").replace("{1}", d.getFrom()).replace("{2}", d.getTo()));
        lblTask.setText(d.getQuestion());
        lblCorrect.setText(Integer.toString(correct));
        lblIncorrect.setText(Integer.toString(incorrect));
        lblList.setText(d.list);
        txtAnswer.setText("");
        updateProgressBar();
    }

    @Override
    public void onExit() {
        LanguageTrainer.userData.putStats(stats);
    }

    @Override
    public void onInsert(char c) {
        txtAnswer.setText(txtAnswer.getText() + c);
    }

    public void onCheat() {
        //FIXME: Make key look less terrible
        cheated++;
        VocabularyData word = words.get(0);
        String[] answers = word.getSolutions();
        String answer = "";
        for (String s : answers) {
            answer += s + "\n";
        }
        for (Statistics stat : stats) {
            if (stat.listName.equals(word.list) && Arrays.equals(stat.langCodes, word.langs)) {
                stat.cheated++;
                break;
            }
        }
        FXUtil.showInformationDialog(BUNDLE.getString("exercise.solution"), BUNDLE.getString("exercise.solutions"),
                                     answer);
    }

    // FIXME: Possible issue, check for one-word lines
    // FIXME: Read UTF-8
    public void init(ArrayList<ExerciseData> lists) {
        String TRANSLATION = BUNDLE.getString("generic.translation");
        // Cycle through all selected exercises
        for (ExerciseData eData : lists) {
            // If it is of type "Translation"
            if (eData.getType().equals(TRANSLATION)) {
                File file = eData.file;
                String lang1 = eData.langs[0];
                String lang2 = eData.langs[1];
                String name = file.getName().replaceAll("_", " ").replace(".tra", "");
                int left = 0, right = 1;
                try (Scanner scan = new Scanner(file)) {
                    String[] langs = scan.nextLine().split(":");
                    // Find the indices of the selected languages
                    for (int i = 0; i < langs.length; i++) {
                        if (langs[i].equals(lang1)) {
                            left = i;
                        } else if (langs[i].equals(lang2)) {
                            right = i;
                        }
                    }
                    // Cycle through all lines
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        String[] words = line.split("=");
                        this.words.add(new VocabularyData(words[left].split(";"), words[right].split(";"),
                                                          eData.langs, name));
                    }

                    stats.add(new Statistics(name, true, eData.langs));

                } catch (FileNotFoundException e) {
                    System.err.println("Can't find file: " + file.getName());
                    e.printStackTrace();
                }

            } else {
                // Else add to the rest list
                rest.add(eData);
            }
            length = words.size();
        }
        Collections.shuffle(words, LanguageTrainer.random);
        VocabularyData d = words.get(0);
        lblTitle.setText(
                BUNDLE.getString("translate.task").replace("{1}", d.getFrom()).replace("{2}", d.getTo()));
        lblTask.setText(d.getQuestion());
        lblList.setText(d.list);
        updateProgressBar();
    }

    private void updateProgressBar() {
        progressBar.setProgress((double) solvedCorrectly / length);
        lblProgress.setText(solvedCorrectly + "/" + Integer.toString(length) + " " +
                            new Double(progressBar.getProgress() * 100).intValue() + "%");
    }

}
