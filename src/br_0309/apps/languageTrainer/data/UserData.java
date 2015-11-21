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
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Properties;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.Reference;

public class UserData implements Serializable {

	private static final long serialVersionUID = 2362898497407984692L;
	public ArrayList<ListStatistics> stats = new ArrayList<ListStatistics>();
	public Properties properties;
	public File file;

	/** Creates a UserData object with only the defaults */
	public UserData() {
		properties = new Properties(getDefaults());
	}

	/** Creates a UserData object from a file */
	public UserData(File file) {
		this.file = file;
		load();
	}

	/** Returns all the default values */
	private Properties getDefaults() {
		Properties p = new Properties();
		p.setProperty(Reference.PROPERTY_LANGUAGE, LanguageHandler.getBestLocale().getLanguage());
		p.setProperty(Reference.PROPERTY_LANGUAGE_REGION, LanguageHandler.getBestLocale().getCountry());
		p.setProperty(Reference.PROPERTY_SOUND_CORRECT, Reference.SOUNDS_CORRECT[0]);
		p.setProperty(Reference.PROPERTY_SOUND_INCORRECT, Reference.SOUNDS_INCORRECT[0]);
		p.setProperty(Reference.PROPERTY_SOUND_FINISHED, Reference.SOUNDS_FINISHED[0]);
		p.setProperty(Reference.PROPERTY_PLAY_SOUNDS, "true");
		p.setProperty(Reference.PROPERTY_THEME, Reference.THEMES[0]);
		return p;
	}

	/** Saves to a file */
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
	/** Loades from a file */
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
			// Fill in default properties to prevent updates braking profiles
			Properties defaults = getDefaults();
			if (properties == null) {
				properties = new Properties(getDefaults());
			}
			for (Entry<Object, Object> entry : defaults.entrySet()) {
				if (!properties.containsKey(entry.getKey())) {
					properties.setProperty(entry.getKey().toString(), entry.getValue().toString());
				}
			}
		}
	}

	/** Returns the language the user chose, or best suited */
	public Locale getLanguage() {
		return new Locale(properties.getProperty(Reference.PROPERTY_LANGUAGE), properties.getProperty(Reference.PROPERTY_LANGUAGE_REGION));
	}

	/** Adds all ListStatistics in list */
	public void putStats(ArrayList<ListStatistics> list) {
		stats.addAll(list);
		save();
	}

	/** @return if sounds should be played */
	public boolean getPlaySounds() {
		return Boolean.parseBoolean(properties.getProperty(Reference.PROPERTY_PLAY_SOUNDS));
	}

	/** @return the theme the user chose, or default */
	public String getTheme() {
		return properties.getProperty(Reference.PROPERTY_THEME);
	}

	/** @return the selected sound for correct answers */
	public String getSoundCorrect() {
		return properties.getProperty(Reference.PROPERTY_SOUND_CORRECT);
	}

	/** @return the selected sound for incorrect answers */
	public String getSoundIncorrect() {
		return properties.getProperty(Reference.PROPERTY_SOUND_INCORRECT);
	}

	/** @return the sound for a finished exercise */
	public String getSoundFinished() {
		return properties.getProperty(Reference.PROPERTY_SOUND_FINISHED);
	}

	/** Sets the value of playSounds. <b>Does not save.</b> */
	public void setPlaySounds(boolean value) {
		properties.setProperty(Reference.PROPERTY_PLAY_SOUNDS, Boolean.toString(value));
	}

	/** Sets the theme. <b>Does not save.</b> */
	public void setTheme(String theme) {
		properties.setProperty(Reference.PROPERTY_THEME, theme);
	}

	/** Sets the correct sound. <b>Does not save.</b> */
	public void setSoundCorrect(String sound) {
		properties.setProperty(Reference.PROPERTY_SOUND_CORRECT, sound);
	}

	/** Sets the incorrect sound. <b>Does not save.</b> */
	public void setSoundIncorrect(String sound) {
		properties.setProperty(Reference.PROPERTY_SOUND_INCORRECT, sound);
	}

	/** Sets the finished sound. <b>Does not save.</b> */
	public void setSoundFinished(String sound) {
		properties.setProperty(Reference.PROPERTY_SOUND_FINISHED, sound);
	}

	/**
	 * Sets the language. Sets this to the active language. <b>Does not
	 * save.</b>
	 */
	public void setLanguage(Locale locale) {
		properties.setProperty(Reference.PROPERTY_LANGUAGE, locale.getLanguage());
		properties.setProperty(Reference.PROPERTY_LANGUAGE_REGION, locale.getCountry());
		LanguageHandler.setDisplayLanguage(locale);
	}

}
