package br_0309.apps.languageTrainer.data;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.File;

public class ExerciseData implements Comparable<ExerciseData> {

    public final File file;
    public final String[] langs;
    private final SimpleBooleanProperty selected;
    private final SimpleStringProperty title;
    private final SimpleStringProperty languages;
    private final SimpleStringProperty type;

    public ExerciseData(boolean selected, String title, String languages, String type, File file, String[] langs2) {
        this.selected = new SimpleBooleanProperty(selected);
        this.title = new SimpleStringProperty(title);
        this.languages = new SimpleStringProperty(languages);
        this.type = new SimpleStringProperty(type);
        this.file = file;
        langs = langs2;
    }

    public boolean isSelected() {
        return selected.get();
    }

    public void setSelected(boolean value) {
        selected.set(value);
    }

    public String getTitle() {
        return title.get();
    }

    @SuppressWarnings("unused")
    public String getLanguages() {
        return languages.get();
    }

    public String getType() {
        return type.get();
    }

    @Override
    public int compareTo(ExerciseData o) {
        return title.get().compareTo(o.getTitle());
    }

    /**
     * isActive for table. <br>
     * On table: column.setCellValueFactory(new
     * PropertyValueFactory<>("active"));
     *
     * @return BooleanProperty
     */
    @SuppressWarnings("unused")
    public BooleanProperty activeProperty() {
        return selected;
    }

}
