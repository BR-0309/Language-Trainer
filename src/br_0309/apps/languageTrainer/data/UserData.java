package br_0309.apps.languageTrainer.data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.Reference;

public class UserData implements Serializable {

	private static final long serialVersionUID = 2362898497407984692L;
	public ArrayList<ListStatistics> stats = new ArrayList<ListStatistics>();
	public Properties properties;
	public File file;

	public UserData() {
		properties = new Properties(getDefaults());
	}

	public UserData(File file) {
		this.file = file;
		load();
	}

	private Properties getDefaults() {
		Properties p = new Properties();
		p.setProperty(Reference.PROPERTY_LANGUAGE, LanguageHandler.getBestLocale().getLanguage());
		p.setProperty(Reference.PROPERTY_SOUND_CORRECT, Reference.SOUNDS_CORRECT[0]);
		p.setProperty(Reference.PROPERTY_SOUND_INCORRECT, Reference.SOUNDS_INCORRECT[0]);
		p.setProperty(Reference.PROPERTY_SOUND_FINISHED, Reference.SOUNDS_FINISHED[0]);
		p.setProperty(Reference.PROPERTY_PLAY_SOUNDS, "true");
		return p;
	}

	public void save() {
		ObjectOutputStream out = null;
		try {
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
				properties = new Properties(getDefaults());
			}
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(properties);
			out.writeObject(stats);
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

	@SuppressWarnings("unchecked")
	public void load() {
		ObjectInputStream in = null;
		try {
			if (!file.exists()) {
				save();
				return;
			}
			in = new ObjectInputStream(new FileInputStream(file));

			properties = (Properties) in.readObject();
			stats = (ArrayList<ListStatistics>) in.readObject();
		} catch (EOFException e) {
			System.out.println("EOFException. Saving");
			save();
			load();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				// XXX: Find out why in.close causes NPE
				// e.printStackTrace();
			}
		}
	}

	public String getLanguage() {
		return properties.getProperty(Reference.PROPERTY_LANGUAGE);
	}

	public void putStats(ArrayList<ListStatistics> list) {
		stats.addAll(list);
		save();
	}

}
