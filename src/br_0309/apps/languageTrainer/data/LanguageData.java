package br_0309.apps.languageTrainer.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LanguageData {

	private StringProperty language;

	public LanguageData(boolean bool, String language) {
		this.language = new SimpleStringProperty(language);
	}

	public String getLanguage() {
		return language.get();
	}

	public StringProperty languageProperty() {
		return language;
	}

}
