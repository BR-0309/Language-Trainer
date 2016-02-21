package br_0309.apps.languageTrainer.util;

import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.Reference;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class FXUtil {

    /**
     * Shows an Information Dialog with default title
     */
    public static void showInformationDialog(String header, String msg) {
        ResourceBundle BUNDLE = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
        showInformationDialog(BUNDLE.getString("generic.information"), header, msg);
    }

    /**
     * Shows an Information Dialog
     */
    public static void showInformationDialog(String title, String header, String msg) {
        Alert alert = new Alert(AlertType.INFORMATION);
        DialogPane pane = alert.getDialogPane();
        pane.getStylesheets().add(FXUtil.class.getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNIFIED);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        try {
            alert.initOwner(LanguageTrainer.window);
        } catch (NullPointerException ignored) {}
        alert.showAndWait();
    }

    /**
     * Show an error dialog
     */
    public static void showErrorDialog(String title, String header, String msg) {
        Alert alert = new Alert(AlertType.ERROR);
        DialogPane pane = alert.getDialogPane();
        pane.getStylesheets().add(FXUtil.class.getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        try {
            alert.initOwner(LanguageTrainer.window);
        } catch (NullPointerException ignored) {}
        alert.showAndWait();
    }

    /**
     * Show an error dialog with default title
     */
    public static void showErrorDialog(String header, String msg) {
        ResourceBundle BUNDLE = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
        showErrorDialog(BUNDLE.getString("generic.error"), header, msg);
    }

    /**
     * Show a warning dialog
     */
    public static void showWarningDialog(String title, String header, String msg) {
        Alert alert = new Alert(AlertType.WARNING);
        DialogPane pane = alert.getDialogPane();
        pane.getStylesheets().add(FXUtil.class.getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        try {
            alert.initOwner(LanguageTrainer.window);
        } catch (NullPointerException ignored) {}
        alert.showAndWait();
    }

    /**
     * Show an error dialog with an expandable stack trace
     */
    public static void showExceptionDialog(String title, String header, Exception exception) {
        ResourceBundle BUNDLE = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(exception.getLocalizedMessage());
        try {
            alert.initOwner(LanguageTrainer.window);
        } catch (NullPointerException ignored) {}

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        String exceptionText = stringWriter.toString();

        Label label = new Label(BUNDLE.getString("util.stacktrace"));

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Control.USE_COMPUTED_SIZE);
        textArea.setMaxHeight(Control.USE_COMPUTED_SIZE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().getStylesheets().add(FXUtil.class.getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
        alert.showAndWait();
    }

    /**
     * Show an error dialog with an expandable stack trace
     */
    public static void showExceptionDialog(String title, String header, Exception exception, Stage stage) {
        ResourceBundle BUNDLE = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(exception.getLocalizedMessage());
        try {
            alert.initOwner(stage);
        } catch (NullPointerException ignored) {}

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        String exceptionText = stringWriter.toString();

        Label label = new Label(BUNDLE.getString("util.stacktrace"));

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Control.USE_COMPUTED_SIZE);
        textArea.setMaxHeight(Control.USE_COMPUTED_SIZE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().getStylesheets().add(FXUtil.class.getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
        alert.showAndWait();
    }

    /**
     * Show an error dialog with an expandable stack trace
     */
    public static void showExceptionDialog(String title, String header, Throwable throwable) {
        ResourceBundle BUNDLE = ResourceBundle.getBundle(Reference.BUNDLE_LOC, Locale.getDefault());
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(throwable.getLocalizedMessage());
        try {
            alert.initOwner(LanguageTrainer.window);
        } catch (NullPointerException ignored) {}

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        String exceptionText = stringWriter.toString();

        Label label = new Label(BUNDLE.getString("util.stacktrace"));

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Control.USE_COMPUTED_SIZE);
        textArea.setMaxHeight(Control.USE_COMPUTED_SIZE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().getStylesheets().add(FXUtil.class.getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
        alert.showAndWait();
    }

    /**
     * Shows a confirmation dialog with custom OK/cancel button
     */
    public static boolean showConfirmationDialog(String title, String header, String msg, String btnOk, String btnCancel) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.initStyle(StageStyle.UTILITY);
        alert.setContentText(msg);
        alert.getDialogPane().getStylesheets().add(FXUtil.class.getResource(LanguageTrainer.userData.getTheme()).toExternalForm());
        try {
            alert.initOwner(LanguageTrainer.window);
        } catch (NullPointerException ignored) {
        }
        ButtonType ok = new ButtonType(btnOk, ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType(btnCancel, ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(ok, cancel);
        Optional<ButtonType> result = alert.showAndWait();
        //noinspection OptionalGetWithoutIsPresent
        return result.isPresent() && result.get().equals(ok);
    }

    /**
     * @return Yes: 0<br> No: 1<br> Cancel: 2
     */
    public static int showYesNoCancelDialog(String title, String header, String msg) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        try {
            alert.initOwner(LanguageTrainer.window);
        } catch (NullPointerException ignored) {}

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get().equals(ButtonType.YES)) {
                return 0;
            } else if (result.get().equals(ButtonType.NO)) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 2;
        }
    }

}
