package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.data.UserData;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;

// IController not going to get called anyway
public class ControllerProfileSelect implements Initializable {

    private final Hashtable<String, File> profiles = new Hashtable<>();
    public ListView<String> list;
    public Button newProfile;
    public Button cancel;
    public boolean isProfileSelected = false;
    private ResourceBundle BUNDLE;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BUNDLE = resources;
        for (File file : LanguageTrainer.universalData.profileLocations) {
            File[] files = file.listFiles();
            if (files == null) {
                continue;
            }
            for (File f : files) {
                if (f.getName().endsWith(".ltd")) {
                    String name = f.getName().replace(".ltd", "").replaceAll("_", " ");
                    profiles.put(name, new File(f.getAbsolutePath()));
                    list.getItems().add(name);
                }
            }
        }
        try {
            list.getItems().sort(Comparator.naturalOrder());
        } catch (NullPointerException e) {
            System.err.println("No registered profiles!");
        }
    }

    public void onCancel() {
        if (FXUtil.showConfirmationDialog(BUNDLE.getString("generic.confirm"), BUNDLE.getString("generic.confirmQuit"), null, BUNDLE.getString("generic.ok"),
                                          BUNDLE.getString("generic.cancel"))) {
            System.exit(0);
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void onNewProfile() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Reference.FXML_PROFILE_NEW),
                                           ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(LanguageTrainer.window);
            stage.initStyle(StageStyle.UTILITY);
            stage.sizeToScene();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.showAndWait();
        ControllerProfileNew controller = loader.getController();
        File profile = controller.profile;
        if (profile == null) {
            return;
        }
        System.out.println(profile.getAbsolutePath());
        profile.getParentFile().mkdirs();
        Stage stage2 = (Stage) newProfile.getScene().getWindow();
        try {
            profile.createNewFile();
            LanguageTrainer.userData = new UserData(profile);
            LanguageTrainer.universalData.addProfileLocation(profile.getParentFile());
            isProfileSelected = true;
            stage2.close();
        } catch (IOException e) {
            FXUtil.showExceptionDialog(ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()).getString("generic.error"),
                                       BUNDLE.getString("profile.createFail"), e, stage2);
        }
    }

    public void onGo() {
        String name = list.getSelectionModel().getSelectedItem();
        // TODO: Find out why go returns nul
        Stage stage = (Stage) newProfile.getScene().getWindow();
        if (name != null && ! name.equals("")) {
            try {
                LanguageTrainer.userData = new UserData(profiles.get(name));
                isProfileSelected = true;
                stage.close();
            } catch (Exception e) {
                FXUtil.showExceptionDialog(ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault()).getString("generic.error"),
                                           BUNDLE.getString("profile.loadFail"), e, stage);
            }
        }
    }

    public void onDelete() {
        if (list.getSelectionModel().getSelectedItem() == null) {
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        String name = list.getSelectionModel().getSelectedItem();
        if (FXUtil.showConfirmationDialog(BUNDLE.getString("profileSelect.deleteTitle"), BUNDLE.getString("profileSelect.deleteHeader").replace("{0}", name),
                                          BUNDLE.getString("profileSelect.deleteMsg"), BUNDLE.getString("generic.yes"), BUNDLE.getString("generic.no"))) {
            File file = profiles.get(name);
            System.out.println("Deleting profile at: " + file.getAbsolutePath());
            try {
                if (file.delete()) {
                    System.out.println("Profile deleted at: " + file.getAbsolutePath());
                    list.getItems().remove(name);
                } else {
                    System.out.println("Failed to delete profile at: " + file.getAbsolutePath());
                }
            } catch (SecurityException e) {
                e.printStackTrace();
                FXUtil.showErrorDialog(BUNDLE.getString("generic.error"), BUNDLE.getString("error.accessDenied"), e.getLocalizedMessage());
            }
        }
    }
}
