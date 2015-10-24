package br_0309.apps.languageTrainer.data;

import java.io.File;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ExcersiseData implements Comparable<ExcersiseData> {

	private SimpleBooleanProperty selected;
	private SimpleStringProperty title;
	private SimpleStringProperty languages;
	private SimpleStringProperty type;
	public File file;

	public ExcersiseData(boolean selected, String title, String languages, String type, File file) {
		this.selected = new SimpleBooleanProperty(selected);
		this.title = new SimpleStringProperty(title);
		this.languages = new SimpleStringProperty(languages);
		this.type = new SimpleStringProperty(type);
		this.file = file;
	}

	public boolean isSelected() {
		return selected.get();
	}

	public String getTitle() {
		return title.get();
	}

	public String getLanguages() {
		return languages.get();
	}

	public String getType() {
		return type.get();
	}

	@Override
	public int compareTo(ExcersiseData o) {
		int last = title.get().compareTo(o.getTitle());
		return last;
	}

	public void setSelected(boolean value) {
		selected.set(value);
	}

	/**
	 * @returns BooleanProperty isActive for table. <br>
	 *          On table: column.setCellValueFactory(new
	 *          PropertyValueFactory<>("active"));
	 */
	public BooleanProperty activeProperty() {
		return selected;
	}

}
