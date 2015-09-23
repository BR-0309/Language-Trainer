package br_0309.apps.languageTrainer.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Settings {

	private final StringProperty language;

	public Settings() {
		this("ENGLISH");
	}

	public Settings(String language) {
		this.language = new SimpleStringProperty(language);
	}

	public StringProperty languageProperty() {
		return language;
	}

}
