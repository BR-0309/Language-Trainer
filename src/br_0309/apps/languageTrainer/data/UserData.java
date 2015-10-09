package br_0309.apps.languageTrainer.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br_0309.apps.languageTrainer.Reference;

public class UserData implements Serializable {

	private static final long serialVersionUID = 2362898497407984692L;
	public List<String> map = new ArrayList<String>();
	public Properties properties;
	// TODO: Add themes
	public String theme;

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
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(""));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void load() {
		// TODO: Implement loading of settings
	}

}
