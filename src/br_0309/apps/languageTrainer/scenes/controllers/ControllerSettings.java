package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.data.UserData;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

// No need for IController since it wouldn't be called anyway
public class ControllerSettings implements Initializable {

    @FXML
    public Button btnOK;
    @FXML
    public Button btnCancel;
    @FXML
    public ComboBox<String> boxCorrect;
    @FXML
    public ComboBox<String> boxIncorrect;
    @FXML
    public ComboBox<String> boxFinished;
    @FXML
    public ComboBox<String> boxTheme;
    @FXML
    public ComboBox<Language> boxLanguage;
    @FXML
    public CheckBox checkboxPlaySounds;

    private final HashMap<String, String> map = new HashMap<>();
    private final HashMap<String, Locale> mapLanguages = new HashMap<>();
    private final HashMap<String, String> mapReversed = new HashMap<>();
    private ResourceBundle BUNDLE;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        BUNDLE = bundle;
        // Set cell factory to render flags in dropdown
        boxLanguage.setCellFactory(new Callback<ListView<Language>, ListCell<Language>>() {

            @Override
            public ListCell<Language> call(ListView<Language> param) {
                return new ListCell<Language>() {
                    final Label text = new Label();
                    final Label icon = new Label();
                    // Render everything in a HBox
                    private final HBox cell;

                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        cell = new HBox();
                        HBox.setHgrow(icon, Priority.ALWAYS);
                        icon.setPadding(new Insets(0, 5, 0, 0));
                        cell.getChildren().add(icon);
                        cell.getChildren().add(text);
                    }

                    @Override
                    protected void updateItem(Language item, boolean isEmpty) {
                        super.updateItem(item, isEmpty);
                        if (item == null || isEmpty) {
                            setGraphic(null);
                        } else {
                            text.setText(item.getText());
                            icon.setGraphic(item.getIcon());
                            setGraphic(cell);
                        }
                    }
                };
            }
        });
        // Only show the text in the button cell
        boxLanguage.setButtonCell(new ListCell<Language>() {
            @Override
            protected void updateItem(Language item, boolean isEmpty) {
                if (item != null || !isEmpty) {
                    if (item != null) {
                        setText(item.getText());
                    }
                }
            }
        });

        for (String theme : Reference.THEMES) {
            boxTheme.getItems().add(bundle.getString(theme));
            map.put(bundle.getString(theme), theme);
            mapReversed.put(theme, bundle.getString(theme));
        }
        for (String sound : Reference.SOUNDS_CORRECT) {
            String s = sound.substring(sound.lastIndexOf("/") + 1).replace(".wav", "");
            boxCorrect.getItems().add(s);
            map.put(s, sound);
            mapReversed.put(sound, s);
        }
        for (String sound : Reference.SOUNDS_INCORRECT) {
            String s = sound.substring(sound.lastIndexOf("/") + 1).replace(".wav", "");
            boxIncorrect.getItems().add(s);
            map.put(s, sound);
            mapReversed.put(sound, s);
        }
        for (String sound : Reference.SOUNDS_FINISHED) {
            String s = sound.substring(sound.lastIndexOf("/") + 1).replace(".wav", "");
            boxFinished.getItems().add(s);
            map.put(s, sound);
            mapReversed.put(sound, s);
        }
        for (Locale l : LanguageHandler.INTERFACE_LANGS) {
            boxLanguage.getItems()
                       .add(new Language(l.getDisplayName(), new ImageView(Reference.FLAG_DIR + l.getCountry() + ".png")));
            mapLanguages.put(l.getDisplayName(), l);
        }

        String correct = LanguageTrainer.userData.getSoundCorrect();
        String incorrect = LanguageTrainer.userData.getSoundIncorrect();
        String finished = LanguageTrainer.userData.getSoundFinished();
        boxTheme.getSelectionModel().select(bundle.getString(LanguageTrainer.userData.getTheme()));
        boxCorrect.getSelectionModel().select(mapReversed.get(correct));
        boxIncorrect.getSelectionModel().select(mapReversed.get(incorrect));
        boxFinished.getSelectionModel().select(mapReversed.get(finished));
        checkboxPlaySounds.setSelected(LanguageTrainer.userData.getPlaySounds());

        // Select correct language by cycling through all of them
        Language l = new Language(LanguageTrainer.userData.getLanguage().getDisplayName(),
                                  new ImageView(
                                          Reference.FLAG_DIR + LanguageTrainer.userData.getLanguage().getCountry() +
                                          ".png"));
        boxLanguage.getSelectionModel().selectFirst();
        for (int i = 0; i < boxLanguage.getItems().size(); i++) {
            Language l2 = boxLanguage.getItems().get(i);
            if (l.getText().equals(l2.getText())) {
                return;
            } else {
                boxLanguage.getSelectionModel().selectNext();
            }
        }
    }

    public void onCancel() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void onOK() {
        LanguageTrainer.userData.setPlaySounds(checkboxPlaySounds.isSelected());
        LanguageTrainer.userData
                .setLanguage(mapLanguages.get(boxLanguage.getSelectionModel().getSelectedItem().getText()));
        LanguageTrainer.userData.setTheme(map.get(boxTheme.getSelectionModel().getSelectedItem()));
        LanguageTrainer.userData.setSoundCorrect(map.get(boxCorrect.getSelectionModel().getSelectedItem()));
        LanguageTrainer.userData.setSoundIncorrect(map.get(boxIncorrect.getSelectionModel().getSelectedItem()));
        LanguageTrainer.userData.setSoundFinished(map.get(boxFinished.getSelectionModel().getSelectedItem()));
        LanguageTrainer.userData.save();

        Stage stage = (Stage) btnOK.getScene().getWindow();
        stage.close();
        LanguageTrainer.showMenu();
    }

    public void onReset() {
        if (FXUtil.showConfirmationDialog(BUNDLE.getString("generic.confirm"), BUNDLE.getString("generic.confirmReset"),
                                          BUNDLE.getString("generic.noUndo"),
                                          BUNDLE.getString("generic.ok"), BUNDLE.getString("generic.cancel"))) {
            UserData userData = new UserData();
            boxTheme.getSelectionModel().select(BUNDLE.getString(userData.getTheme()));
            boxCorrect.getSelectionModel().select(mapReversed.get(userData.getSoundCorrect()));
            boxIncorrect.getSelectionModel().select(mapReversed.get(userData.getSoundIncorrect()));
            boxFinished.getSelectionModel().select(mapReversed.get(userData.getSoundFinished()));
            Label lbl = new Label(userData.getLanguage().getDisplayName(),
                                  new ImageView(Reference.FLAG_DIR + userData.getLanguage().getCountry() + ".png"));
            lbl.getStyleClass().add("label-langs");
            Language l = new Language(LanguageTrainer.userData.getLanguage().getDisplayName(),
                                      new ImageView(
                                              Reference.FLAG_DIR + LanguageTrainer.userData.getLanguage().getCountry() +
                                              ".png"));
            boxLanguage.getSelectionModel().selectFirst();
            for (int i = 0; i < boxLanguage.getItems().size(); i++) {
                Language l2 = boxLanguage.getItems().get(i);
                if (l.getText().equals(l2.getText())) {
                    return;
                } else {
                    boxLanguage.getSelectionModel().selectNext();
                }
            }
            checkboxPlaySounds.setSelected(userData.getPlaySounds());
        }
    }

    public void playCorrect() {
        AudioInputStream audioIn = null;
        try {
            BufferedInputStream in = new BufferedInputStream(
                    getClass().getResourceAsStream(map.get(boxCorrect.getSelectionModel().getSelectedItem())));
            audioIn = AudioSystem.getAudioInputStream(in);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            try {
                if (audioIn != null) {
                    audioIn.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void playIncorrect() {
        AudioInputStream audioIn = null;
        try {
            BufferedInputStream in = new BufferedInputStream(
                    getClass().getResourceAsStream(map.get(boxIncorrect.getSelectionModel().getSelectedItem())));
            audioIn = AudioSystem.getAudioInputStream(in);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            try {
                if (audioIn != null) {
                    audioIn.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void playFinished() {
        AudioInputStream audioIn = null;
        try {
            BufferedInputStream in = new BufferedInputStream(
                    getClass().getResourceAsStream(map.get(boxFinished.getSelectionModel().getSelectedItem())));
            audioIn = AudioSystem.getAudioInputStream(in);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            try {
                if (audioIn != null) {
                    audioIn.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

class Language {

    private final String text;
    private final ImageView icon;

    public Language(String text, ImageView icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public ImageView getIcon() {
        return icon;
    }

}
