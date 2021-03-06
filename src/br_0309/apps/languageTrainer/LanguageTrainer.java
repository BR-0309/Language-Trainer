package br_0309.apps.languageTrainer;

import br_0309.apps.languageTrainer.data.ExerciseData;
import br_0309.apps.languageTrainer.data.UniversalData;
import br_0309.apps.languageTrainer.data.UserData;
import br_0309.apps.languageTrainer.scenes.controllers.*;
import br_0309.apps.languageTrainer.util.FXUtil;
import br_0309.apps.languageTrainer.util.SystemUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

// TODO: Make themes less terrible
// FIXME: If window is maximised, keep it so
public class LanguageTrainer extends Application {

    public static final UniversalData universalData = new UniversalData();
    public static UserData userData = new UserData();
    public static Stage window;
    public static Random random;
    private static IController currentController;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) {
        // Error handler for main thread, just in case
        Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {
            throwable.printStackTrace();
            FXUtil.showExceptionDialog(ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()).getString("generic.error"), throwable.toString(),
                                       throwable);
        });
        // System-specific settings
        if (SystemUtil.isWindows()) {
            File file = new File(System.getProperty("user.home") + File.separator + "AppData" + File.separator + "Roaming" +
                                 File.separator + "LanguageTrainer" + File.separator);
            file.mkdirs();
            Reference.DEFAULT_SAVE_DIR = file.getAbsolutePath();
        } else if (SystemUtil.isMac()) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            File file = new File(System.getProperty("user.home") + File.separator + "Library" + File.separator +
                                 "Application Support" + File.separator + "LanguageTrainer" + File.separator);
            file.mkdirs();
            Reference.DEFAULT_SAVE_DIR = file.getAbsolutePath();
        } else {
            File file = new File(System.getProperty("user.home") + File.separator + "LanguageTrainer" + File.separator);
            file.mkdirs();
            Reference.DEFAULT_SAVE_DIR = file.getAbsolutePath();
        }
        Reference.DEFAULT_EXERCISE_DIR = Reference.DEFAULT_SAVE_DIR + File.separator + "exercises" + File.separator;
        // If the application is run from anything but loose files, redirect console to log_<<time>>.txt
        if (! SystemUtil.isDirectory() || SystemUtil.isMacApp()) {
            File log = new File(Reference.DEFAULT_SAVE_DIR + File.separator + "logs" + File.separator + "log_" + SystemUtil.getTimeAndDate() + ".txt");
            try {
                log.getParentFile().mkdirs();
                log.createNewFile();
                PrintStream writer = new PrintStream(log);
                System.setErr(writer);
                System.setOut(writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // TODO: Add code to copy files over automatically on a different thread

        System.out.println("Start time: " + SystemUtil.getTimeAndDataFormatted());
        // Set language to best suited language before user settings are loaded
        LanguageHandler.setDisplayLanguage(LanguageHandler.getBestLocale());
        printSystemInfo();
        universalData.load();
        File file = new File(Reference.DEFAULT_EXERCISE_DIR);
        file.mkdirs();
        universalData.addExerciseLocation(file);
        random = new Random(SystemUtil.getTimeAndDate().hashCode());
        launch(args);
    }

    /**
     * Print all relevant information about the system, user and languages
     */
    private static void printSystemInfo() {
        System.out.println("Operating System:\t\t\t" + System.getProperty("os.name") + System.lineSeparator() + "Operating System Version:\t" +
                           System.getProperty("os.version") + System.lineSeparator() + "Architecture:\t\t\t\t" +
                           System.getProperty("os.arch") + System.lineSeparator() + "Java Version:\t\t\t\t" +
                           System.getProperty("java.version") + System.lineSeparator() + "Java Vendor:\t\t\t\t" +
                           System.getProperty("java.vendor") + System.lineSeparator() + "Java Home Dir:\t\t\t\t" +
                           System.getProperty("java.home") + System.lineSeparator() + "Temporary Dir:\t\t\t\t" +
                           System.getProperty("java.io.tmpdir") + System.lineSeparator() + "Execution Dir:\t\t\t\t" +
                           System.getProperty("user.dir") + System.lineSeparator() + "User Home Dir:\t\t\t\t" +
                           System.getProperty("user.home") + System.lineSeparator() + "System language:\t\t\t" +
                           System.getProperty("user.language") + System.lineSeparator() + "JVM Default Locale:\t\t\t" +
                           Locale.getDefault() + System.lineSeparator() + "Best suited locale:\t\t\t" + LanguageHandler.getBestLocale() +
                           System.lineSeparator() + "Language Trainer version:\t" + Reference.VERSION + System.lineSeparator());
    }

    public static void setScene(String sceneLoc) {
        currentController.onExit();
        FXMLLoader loader = new FXMLLoader(LanguageTrainer.class.getResource(sceneLoc), ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
        try {
            boolean maximised = window.isMaximized();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(LanguageTrainer.class.getResource(userData.getTheme()).toExternalForm());
            currentController = loader.getController();
            window.setScene(scene);
            if (maximised) {
                window.setMaximized(true);
            } else {
                window.setMinWidth(0);
                window.setMinHeight(0);
                window.sizeToScene();
                window.setMinWidth(window.getWidth());
                window.setMinHeight(window.getHeight());
            }
        } catch (IOException e) {
            e.printStackTrace();
            ResourceBundle bundle = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
            FXUtil.showExceptionDialog(bundle.getString("error.load").replace("{0}", sceneLoc), e.getLocalizedMessage(), e);
        }
    }

    public static void showMenu() {
        currentController.onExit();
        FXMLLoader loader = new FXMLLoader(LanguageTrainer.class.getResource(Reference.FXML_MENU),
                                           ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
        try {
            boolean maximised = window.isMaximized();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(LanguageTrainer.class.getResource(userData.getTheme()).toExternalForm());
            currentController = loader.getController();
            window.setScene(scene);
            if (maximised) {
                window.setMaximized(true);
            } else {
                window.setMinWidth(0);
                window.setMinHeight(0);
                window.sizeToScene();
                window.setMinWidth(window.getWidth());
                window.setMinHeight(window.getHeight());
            }

        } catch (IOException e) {
            e.printStackTrace();
            ResourceBundle bundle = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
            FXUtil.showExceptionDialog(bundle.getString("error.load").replace("{0}", Reference.FXML_MENU), e.getLocalizedMessage(), e);
        }
    }

    private static boolean askForExit() {
        ResourceBundle BUNDLE = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
        return FXUtil.showConfirmationDialog(BUNDLE.getString("generic.confirm"), BUNDLE.getString("generic.confirmQuit"),
                                             BUNDLE.getString("generic.confirmQuit"), BUNDLE.getString("generic.ok"), BUNDLE.getString("generic.cancel"));
    }

    public static void playSoundCorrect() {
        if (userData.getPlaySounds()) {
            AudioInputStream audioIn = null;
            try {
                BufferedInputStream in = new BufferedInputStream(LanguageTrainer.class.getResourceAsStream(userData.getSoundCorrect()));
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

    public static void playSoundIncorrect() {
        if (userData.getPlaySounds()) {
            AudioInputStream audioIn = null;
            try {
                BufferedInputStream in = new BufferedInputStream(LanguageTrainer.class.getResourceAsStream(userData.getSoundIncorrect()));
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

    public static void playSoundFinished() {
        if (userData.getPlaySounds()) {
            AudioInputStream audioIn = null;
            try {
                BufferedInputStream in = new BufferedInputStream(LanguageTrainer.class.getResourceAsStream(userData.getSoundFinished()));
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

    public static void showTranslation(ArrayList<ExerciseData> selected) {
        currentController.onExit();
        FXMLLoader loader = new FXMLLoader(LanguageTrainer.class.getResource(Reference.FXML_TRANSLATION),
                                           ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
        try {
            boolean maximised = window.isMaximized();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(LanguageTrainer.class.getResource(userData.getTheme()).toExternalForm());
            ControllerTranslate controller = loader.getController();
            controller.init(selected);
            currentController = controller;
            window.setScene(scene);
            if (maximised) {
                window.setMaximized(true);
                window.hide();
                window.show();
            } else {
                window.setMinWidth(0);
                window.setMinHeight(0);
                window.sizeToScene();
                window.setMinWidth(window.getWidth());
                window.setMinHeight(window.getHeight());
            }
        } catch (IOException e) {
            ResourceBundle bundle = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()); FXUtil.showExceptionDialog(
                    bundle.getString("error.load").replace("{0}", Reference.FXML_TRANSLATION), e.getLocalizedMessage(), e);
        }
    }

    public static void showVerbs(ArrayList<ExerciseData> selected) {
        currentController.onExit(); FXMLLoader loader = new FXMLLoader(LanguageTrainer.class.getResource(Reference.FXML_VERBS),
                                                                       ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault())); try {
            boolean maximised = window.isMaximized(); Parent root = loader.load(); Scene scene = new Scene(root); scene.getStylesheets().add(
                    LanguageTrainer.class.getResource(userData.getTheme()).toExternalForm()); ControllerVerbs controller = loader.getController();
            controller.init(selected); currentController = controller; window.setScene(scene); if (maximised) {
                window.setMaximized(true); window.hide(); window.show();
            } else {
                window.setMinWidth(0); window.setMinHeight(0); window.sizeToScene(); window.setMinWidth(window.getWidth()); window.setMinHeight(
                        window.getHeight());
            }
        } catch (IOException e) {
            ResourceBundle bundle = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
            FXUtil.showExceptionDialog(bundle.getString("error.load").replace("{0}", Reference.FXML_TRANSLATION), e.getLocalizedMessage(), e);
        }
    }

    public static void showCreateVerbList(int language) {
        currentController.onExit();
        FXMLLoader loader = new FXMLLoader(LanguageTrainer.class.getResource(Reference.FXML_CREATE_VERBS),
                                           ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
        try {
            boolean maximised = window.isMaximized();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(LanguageTrainer.class.getResource(userData.getTheme()).toExternalForm());
            ControllerCreateVerbList controller = loader.getController();
            controller.setLanguage(language);
            currentController = controller;
            window.setScene(scene);
            if (maximised) {
                window.setMaximized(true);
                window.hide();
                window.show();
            } else {
                window.setMinWidth(0);
                window.setMinHeight(0);
                window.sizeToScene();
                window.setMinWidth(window.getWidth());
                window.setMinHeight(window.getHeight());
            }
            }catch(IOException e){
                ResourceBundle bundle = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
                FXUtil.showExceptionDialog(bundle.getString("error.load").replace("{0}", Reference.FXML_TRANSLATION), e.getLocalizedMessage(), e);
            }
        }

    @Override
    public void start(Stage primaryStage) {
        Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {
            throwable.printStackTrace();
            FXUtil.showExceptionDialog(ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()).getString("generic.error"), throwable.toString(),
                                       throwable);
        });
        try {
            window = primaryStage;
            window.getIcons().add(new Image(getClass().getResourceAsStream(Reference.LOGO)));
            showLogin();
            LanguageHandler.setDisplayLanguage(userData.getLanguage());
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Reference.FXML_MENU),
                                               ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
            BorderPane root = loader.load();
            Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
            scene.getStylesheets().add(getClass().getResource(userData.getTheme()).toExternalForm());
            window.setScene(scene);
            window.setTitle(ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()).getString("generic.windowTitle") +
                            " " + Reference.VERSION);
            currentController = loader.getController();
            window.setOnCloseRequest(event -> {
                if (askForExit()) {
                    try {
                        currentController.onExit();
                        System.out.println("Stop time: " + SystemUtil.getTimeAndDataFormatted());
                    } catch (NullPointerException e) {
                        System.err.println("Scene does not have assigned controller!");
                    }
                } else {
                    event.consume();
                }
            });
            window.sizeToScene();
            window.show();
            window.setMinWidth(window.getWidth());
            window.setMinHeight(window.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
            FXUtil.showExceptionDialog("", "", e);
        }
    }

    /**
     * Shows the profile select screen
     */
    private void showLogin() {
        Stage stage = new Stage();
        stage.getIcons().add(new Image(getClass().getResourceAsStream(Reference.LOGO)));
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Reference.FXML_PROFILE_SELECT),
                                           ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Reference.THEMES[0]);
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setResizable(false);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.showAndWait();
        ControllerProfileSelect controller = loader.getController();
        if (! controller.isProfileSelected) {
            System.out.println("Stop time: " + SystemUtil.getTimeAndDataFormatted());
            System.exit(0);
        }
    }

}
