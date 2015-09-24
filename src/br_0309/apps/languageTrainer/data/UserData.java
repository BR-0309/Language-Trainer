package br_0309.apps.languageTrainer.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br_0309.apps.languageTrainer.Reference;

public class UserData implements Serializable {

	private static final long serialVersionUID = 2362898497407984692L;
	public List<String> map = new ArrayList<String>();
	private Properties properties;
	public String lang;

	public UserData() {
		properties = new Properties(getDefaults());
	}

	private Properties getDefaults() {
		Properties p = new Properties();
		p.setProperty(Reference.PROPERTY_LANGUAGE, "en");

		return p;
	}

	public void save() {
		// TODO: Implement saving of settings
	}

	public void load() {
		// TODO: Implement loading of settings
	}

}
