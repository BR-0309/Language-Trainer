package br_0309.apps.languageTrainer.data;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class LanguageData {

	private SimpleBooleanProperty isSelected;
	private SimpleStringProperty language;

	public LanguageData(boolean selected, String language) {
		isSelected = new SimpleBooleanProperty(selected);
		this.language = new SimpleStringProperty(language);
	}

	public BooleanProperty selectedProperty() {
		return isSelected;
	}

	public boolean isSelected() {
		return isSelected.get();
	}

	public String getLanguage() {
		return language.get();
	}

}
